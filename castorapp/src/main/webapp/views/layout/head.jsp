<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="navbar-header">
    <button class="navbar-toggle" type="button" data-toggle="collapse" id="menu-toggler">
        <span class="sr-only">Toggle navigation</span>
        <span class="fa fa-bars"></span>
    </button>
    <a class="navbar-brand" href="/castorapp/">
        <i class="fa fa-building-o"></i>&nbsp;<span>CASTOR APP</span>
    </a>
</div>
<ul class="nav navbar-nav pull-right hidden-xs">
    <li class="settings hidden-xs hidden-sm">
        <a href="${urlPath}/sisani/" role="button" title="Cerrar sesión">
            <i class="fa fa-share"></i>
        </a>
    </li>
</ul>