<%-- 
    Document   : service
    Created on : 1 thg 9, 2023, 21:02:07
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container mt-5">
    <h1 class="text-center text-danger">QUẢN LÝ DỊCH VỤ</h1>

    <c:url value="/admin/service" var="action" />
    <form:form method="post" action="${action}" modelAttribute="service" enctype="multipart/form-data">
        <form:errors path="*" element="div" cssClass="alert alert-danger" />
        <form:hidden path="serviceID" />
        <form:hidden path="image" />

        <div class="form-floating mb-3 mt-3">
            <form:input type="text" class="form-control" path="serviceName" id="serviceName" placeholder="Tên dịch vụ..." />
            <label for="serviceName">Tên dịch vụ</label>
            <form:errors path="serviceName" element="div" cssClass="text-danger" />
        </div>

        <div class="form-floating mb-3 mt-3" style="word-break: break-all;">
            <form:textarea class="form-control" id="des" name="text" path="description" placeholder="Mô tả..."></form:textarea>
                <label for="des">Mô tả</label>
            <form:errors path="description" element="div" cssClass="text-danger" />
        </div>

        <div class="form-floating mb-3 mt-3">
            <form:input type="number" class="form-control" path="price" id="price" placeholder="Nhập giá..." />
            <label for="price">Giá</label>
        </div>

        <div class="form-floating mb-3 mt-3">
            <form:select class="form-select" id="branch" name="branch" path="branchID">
                <c:forEach items="${branches}" var="b">
                    <c:choose>
                        <c:when test="${b.branchID == service.branchID.branchID}">
                            <option value="${b.branchID}" selected>${b.branchName}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${b.branchID}">${b.branchName}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
            <label for="branch" class="form-label">Chi nhánh:</label>
        </div>

        <div class="form-floating mb-3 mt-3">
            <form:input type="file" class="form-control" path="file" id="file" />
            <label for="file">Ảnh</label>
            <c:if test="${service.image != null}">
                <img src="${service.image}" width="120" />
            </c:if>
        </div>

        <div class="form-floating mb-3 mt-3">
            <button class="btn btn-info" type="submit">
                <c:choose>
                    <c:when test="${service.serviceID == null}">Thêm dịch vụ</c:when>
                    <c:otherwise>Cập nhật dịch vụ</c:otherwise>
                </c:choose>
            </button>
        </div>
    </form:form>
</div>