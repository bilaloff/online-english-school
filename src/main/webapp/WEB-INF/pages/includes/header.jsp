<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="i18n.copy"/>

<c:set var="context" value="${pageContext.request.contextPath}"/>

<jsp:useBean id="user" class="com.english.model.User" scope="session"/>

<header class="header-wrapper">
    <div class="container">
        <nav class="navbar">
            <ul class="navbar-items hidden-sm">
                <li class="navbar-item">
                    <a href="${context}/" class="navbar-link"><fmt:message key="nav.home"/></a>
                </li>
                <li class="navbar-item">
                    <a href="${context}/pages/teachers" class="navbar-link"><fmt:message key="nav.teachers"/></a>
                </li>
                <li class="navbar-item">
                    <a href="${context}/pages/blog" class="navbar-link"><fmt:message key="nav.blog"/></a>
                </li>
                <li class="navbar-item">
                    <a href="${context}/pages/music" class="navbar-link"><fmt:message key="nav.music"/></a>
                </li>
                <li class="navbar-item">
                    <a href="${context}/pages/dictionary" class="navbar-link"><fmt:message key="nav.dictionary"/></a>
                </li>
            </ul>
            <ul class="navbar-items push-right">
                <c:if test="${!user.logged}">
                    <li class="navbar-item">
                        <a class="btn btn-sign-in" href="${context}/pages/signin"><fmt:message key="nav.signin"/></a>
                    </li>
                    <li class="navbar-item">
                        <a class="btn btn-sign-up" href="${context}/pages/signup"><fmt:message key="nav.signup"/></a>
                    </li>
                </c:if>
            </ul>

            <c:if test="${user.logged}">
                <div class="dropdown">
                    <div class="profile" id="dropdown-button">
                        <div class="profile-name">${user.name}</div>
                        <img src="${user.image}"
                             class="profile-image" alt=""/>
                    </div>
                    <div class="dropdown-menu" id="dropdown-menu">
                        <div class="dropdown-header">
                            <img src="${user.image}"
                                 class="dropdown-image" alt=""/>
                            <div class="dropdown-profile">
                                <div class="dropdown-name">${user.name}</div>
                                <div class="dropdown-email">${user.email}</div>
                            </div>
                        </div>
                        <ul class="dropdown-items">
                            <li class="dropdown-item">
                                <a href="${context}/" class="dropdown-link"><fmt:message key="dropdown.home"/></a>
                            </li>
                            <li class="dropdown-item">
                                <a href="${context}/pages/lessons" class="dropdown-link"><fmt:message
                                        key="dropdown.lessons"/></a>
                            </li>
                            <li class="dropdown-item">
                                <a href="${context}/pages/messages" class="dropdown-link"><fmt:message
                                        key="dropdown.messages"/></a>
                            </li>
                            <hr/>
                            <li class="dropdown-item">
                                <a href="${context}/pages/teachers" class="dropdown-link"><fmt:message
                                        key="dropdown.teachers"/></a>
                            </li>
                            <li class="dropdown-item">
                                <a href="${context}/pages/" class="dropdown-link"><fmt:message key="dropdown.blog"/></a>
                            </li>
                            <li class="dropdown-item">
                                <a href="${context}/pages/music" class="dropdown-link"><fmt:message
                                        key="dropdown.music"/></a>
                            </li>
                            <li class="dropdown-item">
                                <a href="${context}/pages/dictionary" class="dropdown-link"><fmt:message
                                        key="dropdown.dictionary"/></a>
                            </li>
                            <li class="dropdown-item">
                                <a href="${context}/pages/bookmarks" class="dropdown-link"><fmt:message
                                        key="dropdown.bookmarks"/></a>
                            </li>
                            <li class="dropdown-item">
                                <a href="${context}/pages/settings" class="dropdown-link"><fmt:message
                                        key="dropdown.settings"/></a>
                            </li>
                            <hr/>
                            <li class="dropdown-item">
                                <a href="#" class="dropdown-link dropdown-link--img">
                                    <img alt="flag"
                                         src="${context}/assets/images/web/flags/<fmt:message key="locale"/>.png">
                                    <fmt:message key="country"/></a>
                            </li>
                            <hr/>
                            <li class="dropdown-item">
                                <a href="${context}/pages/signout" class="dropdown-link"><fmt:message
                                        key="dropdown.signout"/></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </c:if>
        </nav>
    </div>
</header>