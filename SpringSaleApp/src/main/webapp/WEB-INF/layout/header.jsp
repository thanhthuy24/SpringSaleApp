<%-- 
    Document   : header
    Created on : Jul 22, 2024, 1:38:48 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">E-Commerce</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="#">Trang chủ</a>
                </li>
                <c:forEach items="${cates}" var="c" >
                    <c:url value="/" var="cateUrl" >
                        <c:param name="cateId" value="${c.id}" />
                    </c:url>
                    <li class="nav-item">
                        <a class="nav-link" href="${cateUrl}">${c.name}</a>
                    </li>
                </c:forEach>
                <li class="nav-item">
                    <a class="nav-link text-danger" href="<c:url value="/stats" />">
                       Thong ke
                       </a>
                       </li>
                       <sec:authorize access="!isAuthenticated()">
                           <li class="nav-item">
                           <a class="nav-link" href="<c:url value="/login" />">
                               Login
                           </a>
                    </li>
                </sec:authorize>

                <sec:authorize access="isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/" />">
                            Welcome <sec:authentication property="principal.username" />!
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/logout" />">
                            Logout
                        </a>
                    </li>
                </sec:authorize>
            </ul>
        </div>
    </div>
</nav>