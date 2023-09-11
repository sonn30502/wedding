<%-- 
    Document   : list_menu
    Created on : 1 thg 9, 2023, 21:33:50
    Author     : ASUS
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container mt-5">
    <h1 class="text-center text-danger">QUẢN LÝ MENU</h1>

    <c:url value="/admin/menu" var="action" />
    <form:form method="post" action="${action}" modelAttribute="menu" enctype="multipart/form-data">
        <form:errors path="*" element="div" cssClass="alert alert-danger" />
        <form:hidden path="menuID" />
        <form:hidden path="image" />

        <div class="mb-3">
            <label for="menuName" class="form-label">Tên menu</label>
            <form:input type="text" class="form-control" path="menuName" id="menuName" placeholder="Tên menu..." />
            <form:errors path="menuName" element="div" cssClass="text-danger" />
        </div>

        <div class="mb-3">
            <label for="description" class="form-label">Mô tả</label>
            <form:textarea class="form-control" id="description" name="text" path="description" placeholder="Mô tả"></form:textarea>
            <form:errors path="description" element="div" cssClass="text-danger" />
        </div>

        <div class="mb-3">
            <label for="price" class="form-label">Giá</label>
            <form:input type="number" class="form-control" path="price" id="price" placeholder="Nhập giá..." />
        </div>

        <div class="mb-3">
            <label for="branch" class="form-label">Chi nhánh:</label>
            <form:select class="form-select" id="branch" name="branch" path="branchID">
                <c:forEach items="${branchList}" var="b">
                    <c:choose>
                        <c:when test="${b.branchID == menu.branchID.branchID}">
                            <option value="${b.branchID}" selected>${b.branchName}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${b.branchID}">${b.branchName}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
        </div>

        <div class="mb-3">
            <label for="file" class="form-label">Ảnh</label>
            <form:input type="file" class="form-control" path="file" id="file" />
            <c:if test="${menu.image != null}">
                <img src="${menu.image}" width="120" />
            </c:if>
        </div>

        <div class="mb-3">
            <button class="btn btn-info" type="submit">
                <c:choose>
                    <c:when test="${menu.menuID == null}">Thêm menu</c:when>
                    <c:otherwise>Cập nhật menu</c:otherwise>
                </c:choose>
            </button>
        </div>
    </form:form>
</div>


