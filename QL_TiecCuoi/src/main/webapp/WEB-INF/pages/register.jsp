<%-- 
    Document   : register
    Created on : 17 thg 8, 2023, 21:57:17
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header text-center text-danger">
                    <h1>ĐĂNG KÝ</h1>
                </div>
                <div class="card-body">
                    <c:if test="$errMsg != null">
                        <div class="alert alert-danger">
                            ${errMsg}
                        </div>
                    </c:if>
                    <form:form action="${action}" method="post" modelAttribute="user" enctype="multipart/form-data">
                        <form:hidden path="profileImage" />
                        <div class="mb-3">
                            <label for="firstName" class="form-label">First Name:</label>
                            <form:input type="text" class="form-control" id="firstName" path="firstName"/>
                        </div>
                        <div class="mb-3">
                            <label for="lastName" class="form-label">Last Name:</label>
                            <form:input type="text" class="form-control" id="lastName" path="lastName"/>
                        </div>
                        <div class="mb-3">
                            <label for="email" class="form-label">Email:</label>
                            <form:input type="email" class="form-control" id="email" path="email"/>
                        </div>
                        <div class="mb-3">
                            <label for="username" class="form-label">Username:</label>
                            <form:input type="text" class="form-control" id="username" path="username"/>
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Password:</label>
                            <form:input type="password" class="form-control" id="password" path="password"/>
                        </div>
                        <div class="mb-3">
                            <label for="confirm-password" class="form-label">Confirm Password:</label>
                            <form:input type="password" class="form-control" id="confirm-password" path="confirmPassword"/>
                        </div>
                        <div class="form-floating mb-3 mt-3">
                            <form:input type="file" class="form-control" path="file" id="file" name="file" />
                            <label for="file">Ảnh đại diện</label>
                        </div>
                        <button type="submit" class="btn btn-primary">Đăng ký</button>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>


