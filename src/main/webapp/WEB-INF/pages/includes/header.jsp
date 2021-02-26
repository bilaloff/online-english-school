<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="i18n.copy"/>

<c:set var="context" value="${pageContext.request.contextPath}"/>

<jsp:useBean id="user" class="com.english.model.User" scope="session"/>

<header class="header">
    <div class="container">
        <nav class="nav">
            <ul class="list list--inline">
                <li class="list__item">
                    <a href="${context}/"><fmt:message key="nav.home"/></a>
                </li>
                <li class="list__item">
                    <a href="${context}/pages/teachers"><fmt:message key="nav.teachers"/></a>
                </li>
                <li class="list__item">
                    <a href="${context}/pages/blog"><fmt:message key="nav.blog"/></a>
                </li>
                <li class="list__item">
                    <a href="${context}/pages/music"><fmt:message key="nav.music"/></a>
                </li>
                <li class="list__item">
                    <a href="${context}/pages/dictionary"><fmt:message key="nav.dictionary"/></a>
                </li>
            </ul>
            <c:choose>
                <c:when test="${!user.logged}">
                    <div class="nav__buttons">
                        <a class="btn btn--outline" href="${context}/pages/signin"><fmt:message key="nav.signin"/></a>
                        <a class="btn btn--primary" href="${context}/pages/signup"><fmt:message key="nav.signup"/></a>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="dropdown">
                        <div class="dropdown__button" id="dropdown-button">
                            <span class="dropdown__username">German</span>
                            <img class="dropdown__image"
                                 src="https://images.unsplash.com/photo-1543466835-00a7907e9de1?ixid=MXwxMjA3fDB8MHxzZWFyY2h8N3x8ZG9nfGVufDB8fDB8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
                                 alt="">
                        </div>
                        <div class="dropdown__content" id="dropdown-menu">
                            <div class="media">
                                <div class="media__image">
                                    <img src="https://images.unsplash.com/photo-1543466835-00a7907e9de1?ixid=MXwxMjA3fDB8MHxzZWFyY2h8N3x8ZG9nfGVufDB8fDB8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
                                         alt="">
                                </div>
                                <div class="media__body">
                                    <div class="media__title">German</div>
                                    <span class="media__email">pinncho@gmail.com</span>
                                </div>
                            </div>
                            <ul class="list">
                                <li class="list__item">
                                    <a href="${context}/" class="dropdown-link"><fmt:message key="dropdown.home"/></a>
                                </li>
                                <li class="list__item">
                                    <a href="${context}/pages/lessons" class="dropdown-link"><fmt:message
                                            key="dropdown.lessons"/></a>
                                </li>
                                <li class="list__item">
                                    <a href="${context}/pages/messages" class="dropdown-link"><fmt:message
                                            key="dropdown.messages"/></a>
                                </li>
                            </ul>
                            <ul class="list">
                                <li class="list__item">
                                    <a href="${context}/pages/teachers" class="dropdown-link"><fmt:message
                                            key="dropdown.teachers"/></a>
                                </li>
                                <li class="list__item">
                                    <a href="${context}/pages/" class="dropdown-link"><fmt:message
                                            key="dropdown.blog"/></a>
                                </li>
                                <li class="list__item">
                                    <a href="${context}/pages/music" class="dropdown-link"><fmt:message
                                            key="dropdown.music"/></a>
                                </li>
                                <li class="list__item">
                                    <a href="${context}/pages/dictionary" class="dropdown-link"><fmt:message
                                            key="dropdown.dictionary"/></a>
                                </li>
                                <li class="list__item">
                                    <a href="${context}/pages/bookmarks" class="dropdown-link"><fmt:message
                                            key="dropdown.bookmarks"/></a>
                                </li>
                                <li class="list__item">
                                    <a href="${context}/pages/settings" class="dropdown-link"><fmt:message
                                            key="dropdown.settings"/></a>
                                </li>
                            </ul>
                            <ul class="list">
                                <li class="list__item list__item--nav-image">
                                    <a href="#">
                                        <img alt="Flag of a country"
                                             src="${context}/assets/images/web/flags/<fmt:message key="locale"/>.png">
                                        <fmt:message key="country"/></a>
                                </li>
                            </ul>
                            <ul class="list">
                                <li class="list__item">
                                    <a href="${context}/pages/signout" class="dropdown-link"><fmt:message
                                            key="dropdown.signout"/></a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>
        </nav>
    </div>
</header>