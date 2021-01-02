<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="i18n.copy"/>

<c:set var="context" value="${pageContext.request.contextPath}"/>

<footer class="footer">
    <div class="container">
        <div class="footer-columns">
            <div class="footer-column">
                <h4 class="footer-header"><fmt:message key="footer.company"/></h4>
                <ul class="footer-items">
                    <li class="footer-item"><a href=""><fmt:message key="footer.about"/></a></li>
                    <li class="footer-item"><a href=""><fmt:message key="footer.career"/>
                        <span class="footer-item-span"><fmt:message key="footer.hiring"/></span></a></li>
                    <li class="footer-item"><a href=""><fmt:message key="footer.contactus"/></a></li>
                    <li class="footer-item"><a href=""><fmt:message key="footer.about"/></a></li>
                </ul>
            </div>
            <div class="footer-column">
                <h4 class="footer-header"><fmt:message key="footer.community"/></h4>
                <ul class="footer-items">
                    <li class="footer-item"><a href=""><fmt:message key="footer.blog"/></a></li>
                    <li class="footer-item"><a href=""><fmt:message key="footer.teachers"/></a></li>
                    <li class="footer-item"><a href=""><fmt:message key="footer.music"/></a></li>
                    <li class="footer-item"><a href=""><fmt:message key="footer.dictionary"/></a></li>
                </ul>
            </div>
            <div class="footer-column">
                <h4 class="footer-header"><fmt:message key="footer.career"/></h4>
                <ul class="footer-items">
                    <li class="footer-item"><a href=""><fmt:message key="footer.work"/></a></li>
                    <li class="footer-item"><a href="">Q&A</a></li>
                </ul>
            </div>
            <div class="footer-column">
                <label for="select-region"></label>
                <select class="footer-select" name="" id="select-region">
                    <option value="" selected><fmt:message key="country"/></option>
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
            </div>
        </div>
        <div class="footer-columns">
            <div class="footer-column">
                <h4 class="footer-header"><fmt:message key="footer.support"/></h4>
                <ul class="footer-items">
                    <li class="footer-item footer-item--email"><a href="mailto:contact@englishwithmusic.ru"><i
                            class="fas fa-envelope"></i>support@englishwithmusic.ru</a></li>
                </ul>
            </div>
            <div class="footer-column">
                <h4 class="footer-header"><fmt:message key="footer.join"/></h4>
                <ul class="footer-items">
                    <li class="footer-item footer-item--social">
                        <a href=""><i class="fab fa-instagram"></i></a>
                    </li>
                    <li class="footer-item footer-item--social">
                        <a href=""><i class="fab fa-twitter"></i></a>
                    </li>
                    <li class="footer-item footer-item--social">
                        <a href=""><i class="fab fa-facebook-square"></i></a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="footer-columns">
            <div class="footer-column">
                <h4 class="footer-header"><fmt:message key="footer.exams"/></h4>
                <ul class="footer-items footer-items--small">
                    <li class="footer-item"><a href="">IELTS</a></li>
                    <li class="footer-item"><a href="">TOEFL</a></li>
                    <li class="footer-item"><a href="">GMAT</a></li>
                    <li class="footer-item"><a href="">BEC</a></li>
                    <li class="footer-item"><a href="">FCE</a></li>
                    <li class="footer-item"><a href="">TestDaf</a></li>
                    <li class="footer-item"><a href="">SAT</a></li>
                    <li class="footer-item"><a href="">AP</a></li>
                </ul>
            </div>
        </div>
        <div class="footer-copyright">© 2020 English Online LLC. All Rights Reserved.</div>
    </div>
</footer>