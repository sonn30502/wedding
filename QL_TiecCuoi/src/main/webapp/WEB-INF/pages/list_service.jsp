<%-- 
    Document   : list_service
    Created on : 1 thg 9, 2023, 21:33:50
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<section class="container mt-5">
    <div class="d-flex justify-content-between align-items-center">
       <h1 class="text-center text-danger">DANH SÁCH DỊCH VỤ</h1>
        <div class="d-flex flex-column align-items-end">
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <a href="<c:url value="/admin/service" />" class="btn btn-info mb-2">Thêm dịch vụ</a>
            </sec:authorize>
            <form class="d-flex mt-2" action="<c:url value='/list_service' />">
                <div class="input-group">
                    <input class="form-control me-2" type="text" name="kw" placeholder="Nhập từ khóa...">
                    <button class="btn btn-primary" type="submit">Tìm</button>
                </div>
            </form>
        </div>
    </div>


    <table class="table table-hover">
        <thead>
            <tr>
                <th scope="col">Ảnh</th>
                <th scope="col">ID</th>
                <th scope="col">Tên dịch vụ</th>
                <th scope="col">Chi tiết dịch vụ</th>
                <th scope="col">Giá</th>
                <th scope="col">Chi nhánh</th>
                <th scope="col">Thao tác</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${service}" var="s">
                <tr>
                    <td>
                        <img src="${s.image}" alt="${s.serviceName}" width="120" />
                    </td>
                    <td>${s.serviceID}</td>
                    <td>${s.serviceName}</td>
                    <td>${s.description}</td>
                    <td>${s.price}</td>
                    <td>${s.branchID.branchName}</td>

                    <td>
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <div class="btn-group">
                                <a href="<c:url value='/admin/service/${s.serviceID}' />" class="btn btn-success">Cập nhật</a>
                                <a href="<c:url value='/admin/service/delete/${s.serviceID}' />" class="btn btn-danger" onclick="return confirm('Bạn có chắc muốn xóa?')">Xóa</a>
                            </div>
                        </sec:authorize>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>

