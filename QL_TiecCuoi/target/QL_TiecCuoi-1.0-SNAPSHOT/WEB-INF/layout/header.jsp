<%-- 
    Document   : header
    Created on : 18 thg 8, 2023, 23:17:51
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="action" />

<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #ff3366;">
    <div class="container">
        <a class="navbar-brand" href="#" style="color: #fff; font-weight: bold;">WEDDING</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link" href="${action}" style="color: #fff;">Trang chủ</a>
                </li>

                <c:choose>
                    <c:when test="${pageContext.request.userPrincipal.name != null}">
                        <!-- Links when logged in -->
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value='/' />" style="color: #fff;">${pageContext.request.userPrincipal.name}</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value='/logout' />" style="color: #fff;">Đăng xuất</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <!-- Links when not logged in -->
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value='/login' />" style="color: #fff;">Đăng nhập</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value='/register' />" style="color: #fff;">Đăng ký</a>
                        </li>
                    </c:otherwise>
                </c:choose>

                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/list_halls' />" style="color: #fff;">Sảnh cưới</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/list_branch' />" style="color: #fff;">Chi nhánh</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/list_menu' />" style="color: #fff;">Menu</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/list_service' />" style="color: #fff;">Dịch vụ</a>
                </li>
            </ul>
        </div>
    </div>
</nav>



