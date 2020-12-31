package com.english.filter;

import javax.servlet.*;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

public class SessionLocaleFilter extends HttpFilter {

    private Locale defaultLocale;
    private static final String LOCALE = "locale";
    private static final Map<String, Locale> supportedLocales =
            Map.of("en-AU", new Locale("en", "AU"),
                    "en-GB", new Locale("en", "GB"),
                    "en-NZ", new Locale("en", "NZ"),
                    "en-US", new Locale("en", "US"),
                    "es-ES", new Locale("es", "ES"),
                    "ga-IE", new Locale("ga", "IE"),
                    "it-IT", new Locale("it", "IT"),
                    "no-NO", new Locale("no", "NO"),
                    "pt-BR", new Locale("pt", "BR"),
                    "ru", new Locale("ru"));

    @Override
    public void init(FilterConfig config) throws ServletException {
        super.init(config);
        String defaultLocaleParam = config.getInitParameter("DEFAULT_LOCALE");
        defaultLocale = (defaultLocaleParam == null)
                ? Locale.getDefault()
                : Locale.forLanguageTag(defaultLocaleParam);
    }

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();

        if (isLocaleSupported(req.getParameter(LOCALE))) {
            session.setAttribute(LOCALE, supportedLocales.get(req.getParameter(LOCALE)));
        } else if (session.getAttribute(LOCALE) == null) {
            session.setAttribute(LOCALE, getClientSupportedLocale(req));
        }

        chain.doFilter(req, res);
    }

    private Locale getClientSupportedLocale(HttpServletRequest req) {
        Enumeration<Locale> clientLocales = req.getLocales();
        while (clientLocales.hasMoreElements()) {
            Locale currLocale = clientLocales.nextElement();
            if (isLocaleSupported(currLocale.toLanguageTag())) {
                return supportedLocales.get(currLocale.toLanguageTag());
            }
        }
        return defaultLocale;
    }

    private boolean isLocaleSupported(String localeString) {
        if (localeString == null) {
            return false;
        } else {
            return supportedLocales.containsKey(localeString);
        }
    }

}
