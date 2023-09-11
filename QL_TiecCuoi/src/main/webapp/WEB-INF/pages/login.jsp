<%-- 
    Document   : login
    Created on : 20 thg 8, 2023, 22:54:22
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header text-center text-danger">
                    <h1>ĐĂNG NHẬP</h1>
                </div>
                <div class="card-body">
                    <c:if test="${param.error != null}">
                        <div class="alert alert-danger">
                            Đã có lỗi xảy ra! Vui lòng quay lại sau!
                        </div>
                    </c:if>
                    <c:if test="${param.accessDenied != null}">
                        <div class="alert alert-danger">
                            Bạn không có quyền truy cập!!!
                        </div>
                    </c:if>
                    <form method="post" action="${action}" class="needs-validation" novalidate>
                        <div class="mb-3">
                            <label for="username" class="form-label">Username</label>
                            <input type="text" id="username" name="username" class="form-control" required>
                            <div class="invalid-feedback">
                                Vui lòng nhập tên đăng nhập.
                            </div>
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Password</label>
                            <input type="password" id="password" name="password" class="form-control" required>
                            <div class="invalid-feedback">
                                Vui lòng nhập mật khẩu.
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">ĐĂNG NHẬP</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
