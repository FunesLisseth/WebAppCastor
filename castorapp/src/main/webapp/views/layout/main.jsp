<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML>
<html lang="es">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><tiles:insertAttribute name="title" ignore="true"/></title>

    <!-- bootstrap -->
    <link href="<c:url value="/css/bootstrap/bootstrap.min.css"/>" rel="stylesheet" >
    <link href="<c:url value="/css/bootstrap/bootstrap-theme.min.css"/>" rel="stylesheet" >
    <link href="<c:url value="/css/bootstrap/bootstrap-overrides.css"/>" rel="stylesheet" >

    <!-- libraries -->
    <link rel="stylesheet" href="<c:url value="/css/font-awesome/font-awesome.css"/>" >

    <!-- global styles -->
    <link rel="stylesheet" href="<c:url value="/css/general/layout.css"/>" type="text/css" >
    <!-- this page specific styles -->
    <link rel="stylesheet" href="<c:url value="/css/general/main.css"/>" type="text/css" >
</head>
<body>
    <c:set var="urlPath" value="${pageContext.request.contextPath}" />
    <div id="wrapper">
        <!-- navbar -->
        <header class="navbar navbar-inverse" role="banner">
            <tiles:insertAttribute name="header"></tiles:insertAttribute>
        </header>
        <!-- end navbar -->
        <!-- container -->
        <div id="container">
            <!-- menu -->
            <aside id="sidebar-nav">
                <tiles:insertAttribute name="menu"></tiles:insertAttribute>
            </aside>
            <!-- content -->
            <section class="content">
                <tiles:insertAttribute name="content"></tiles:insertAttribute>
            </section>
            <!-- end content -->
        </div>
        <!-- end container -->
    </div>

    <script src="<c:url value="/js/jquery/jquery.min.js"/>"></script>
    <script src="<c:url value="/js/bootstrap/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/js/utilfunctions.js"/>"></script>
    <script src="<c:url value="/js/theme.js"/>"></script>
    <script src="<c:url value="/js/moment.min.js"/>"></script>

</body>
</html>