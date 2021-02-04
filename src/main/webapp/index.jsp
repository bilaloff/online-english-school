<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="i18n.copy"/>

<c:set var="context" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=yes">
    <title><fmt:message key="title.home"/></title>
    <link rel="stylesheet" href="${context}/assets/css/shared.css"/>
    <link rel="stylesheet" href="${context}/assets/css/header.css"/>
    <link rel="stylesheet" href="${context}/assets/css/footer.css"/>
    <link rel="stylesheet" href="${context}/assets/css/home.css"/>
    <link rel="stylesheet" href="${context}/assets/fonts/fontawesome/css/all.css">
    <link rel="icon" type="image/png" sizes="16x16" href="${context}/favicon.ico">
    <script defer type="module" src="${context}/assets/js/main.js"></script>
</head>
<body>

<jsp:include page="WEB-INF/pages/includes/header.jsp"/>

<div class="banner-wrapper">
    <video autoplay muted loop class="banner-video hidden-sm">
        <source src="assets/video/home-banner.mp4" type="video/mp4">
    </video>

    <div class="banner-copy-wrapper">
        <div class="container">
            <div class="banner-copy">
                <p class="banner-subheader banner-subheader--highlight"><fmt:message key="home.hero.welcome"/></p>
                <h1 class="banner-header"><fmt:message key="home.hero.header"/></h1>
                <p class="banner-subheader"><fmt:message key="home.hero.subheader"/></p>
            </div>
        </div>
    </div>
</div>

<c:import url="WEB-INF/pages/includes/footer.jsp"/>

</body>
</html>