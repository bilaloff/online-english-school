<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="i18n.copy"/>

<c:set var="context" value="${pageContext.request.contextPath}"/>

<footer class="footer">
    <div class="container">
        <div class="footer-columns">
            <nav class="footer-column">
                <h4 class="footer__heading"><fmt:message key="footer.company"/></h4>
                <ul class="list">
                    <li class="list__item"><a href=""><fmt:message key="footer.about"/></a></li>
                    <li class="list__item"><a href=""><fmt:message key="footer.career"/>
                        <span class="list__item__span"><fmt:message key="footer.hiring"/></span></a></li>
                    <li class="list__item"><a href=""><fmt:message key="footer.contactus"/></a></li>
                    <li class="list__item"><a href=""><fmt:message key="footer.about"/></a></li>
                </ul>
            </nav>
            <nav class="footer-column">
                <h4 class="footer__heading"><fmt:message key="footer.community"/></h4>
                <ul class="list">
                    <li class="list__item"><a href=""><fmt:message key="footer.blog"/></a></li>
                    <li class="list__item"><a href=""><fmt:message key="footer.teachers"/></a></li>
                    <li class="list__item"><a href=""><fmt:message key="footer.music"/></a></li>
                    <li class="list__item"><a href=""><fmt:message key="footer.dictionary"/></a></li>
                </ul>
            </nav>
            <nav class="footer-column">
                <h4 class="footer__heading"><fmt:message key="footer.career"/></h4>
                <ul class="list">
                    <li class="list__item"><a href=""><fmt:message key="footer.work"/></a></li>
                    <li class="list__item"><a href="">Q&A</a></li>
                </ul>
            </nav>
            <nav class="footer-column">
                <label for="select-region"></label>
                <select class="footer__select" name="" id="select-region">
                    <option value="" hidden selected><fmt:message key="country"/></option>
                    <option value="en-AU">Australia</option>
                    <option value="pt-BR">Brazil</option>
                    <option value="ga-IE">Ireland</option>
                    <option value="it-IT">Italy</option>
                    <option value="en-NZ">New Zealand</option>
                    <option value="no-NO">Norway</option>
                    <option value="ru">Russia</option>
                    <option value="es-ES">Spain</option>
                    <option value="en-GB">United Kingdom</option>
                    <option value="en-US">United States</option>
                </select>
            </nav>
        </div>
        <div class="footer-columns">
            <nav class="footer-column">
                <h4 class="footer__heading"><fmt:message key="footer.support"/></h4>
                <ul class="list">
                    <li class="list__item list__item--email"><a href="mailto:contact@englishwithmusic.ru"><i
                            class="fas fa-envelope"></i>support@englishwithmusic.ru</a></li>
                </ul>
            </nav>
            <nav class="footer-column">
                <h4 class="footer__heading"><fmt:message key="footer.join"/></h4>
                <ul class="list list--inline list--social">
                    <li class="list__item"><a href=""><i class="fab fa-instagram"></i></a></li>
                    <li class="list__item"><a href=""><i class="fab fa-twitter"></i></a></li>
                    <li class="list__item"><a href=""><i class="fab fa-facebook-square"></i></a></li>
                </ul>
            </nav>
        </div>
        <div class="footer-columns">
            <nav class="footer-column">
                <h4 class="footer__heading"><fmt:message key="footer.exams"/></h4>
                <ul class="list list--inline list--small">
                    <li class="list__item"><a href="">IELTS</a></li>
                    <li class="list__item"><a href="">TOEFL</a></li>
                    <li class="list__item"><a href="">GMAT</a></li>
                    <li class="list__item"><a href="">BEC</a></li>
                    <li class="list__item"><a href="">FCE</a></li>
                    <li class="list__item"><a href="">TestDaf</a></li>
                    <li class="list__item"><a href="">SAT</a></li>
                    <li class="list__item"><a href="">AP</a></li>
                </ul>
            </nav>
        </div>
        <div class="footer__copyright text--center">© 2020 English Online LLC. All Rights Reserved.</div>
    </div>
</footer>