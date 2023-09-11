<%-- 
    Document   : branch
    Created on : 24 thg 8, 2023, 15:52:02
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container mt-5">
   <h1 class="text-center text-danger">QUẢN LÝ CHI NHÁNH</h1>

    <c:url value="/admin/branch" var="action" />
    <form:form method="post" action="${action}" modelAttribute="branch" enctype="multipart/form-data">
        <form:errors path="*" element="div" cssClass="alert alert-danger" />
        <form:hidden path="branchID" />
        <form:hidden path="image" />

        <div class="mb-3 mt-3">
            <label for="branchName" class="form-label">Tên chi nhánh</label>
            <form:input type="text" class="form-control" path="branchName" id="branchName" placeholder="Tên chi nhánh..." />
            <form:errors path="branchName" element="div" cssClass="text-danger" />
        </div>

        <div class="mb-3">
            <label for="address" class="form-label">Địa chỉ</label>
            <form:textarea class="form-control" id="address" name="text" path="address" placeholder="Địa chỉ"></form:textarea>
            <form:errors path="address" element="div" cssClass="text-danger" />
        </div>

        <div class="mb-3 mt-3">
            <label for="phoneNumber" class="form-label">Số điện thoại</label>
            <form:input type="text" class="form-control" path="phoneNumber" id="phoneNumber" placeholder="Số điện thoại..." />
        </div>

        <div class="mb-3 mt-3">
            <label for="file" class="form-label">Ảnh</label>
            <form:input type="file" class="form-control" path="file" id="file" />
            <c:if test="${branch.image != null}">
                <img src="${branch.image}" width="120" />
            </c:if>
        </div>

        <div class="mb-3 mt-3">
            <button class="btn btn-info" type="submit">
                <c:choose>
                    <c:when test="${branch.branchID == null}">Thêm chi nhánh</c:when>
                    <c:otherwise>Cập nhật chi nhánh</c:otherwise>
                </c:choose>
            </button>
        </div>
    </form:form>
</div>


