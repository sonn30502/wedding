<%-- 
    Document   : halls
    Created on : 29 thg 8, 2023, 16:42:18
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container mt-5">
    <h1 class="text-center text-danger">QUẢN LÝ SẢNH CƯỚI</h1>

    <c:url value="/admin/halls" var="action" />
    <form:form method="post" action="${action}" modelAttribute="halls" enctype="multipart/form-data">
        <form:errors path="*" element="div" cssClass="alert alert-danger" />
        <form:hidden path="hallID" />
        <form:hidden path="image" />

        <div class="mb-3">
            <label for="hallName" class="form-label">Tên sảnh cưới</label>
            <form:input type="text" class="form-control" path="hallName" id="hallName" placeholder="Tên sảnh cưới..." />
            <form:errors path="hallName" element="div" cssClass="text-danger" />
        </div>

        <div class="mb-3">
            <label for="des" class="form-label">Mô tả</label>
            <form:textarea class="form-control" id="des" name="text" path="description" placeholder="Mô tả"></form:textarea>
            <form:errors path="description" element="div" cssClass="text-danger" />
        </div>

        <div class="mb-3">
            <label for="priceMorning" class="form-label">Giá sảnh sáng</label>
            <form:input type="number" class="form-control" path="priceMorning" id="priceMorning" placeholder="Nhập giá sảnh sáng..." />
        </div>

        <div class="mb-3">
            <label for="priceAfternoon" class="form-label">Giá sảnh chiều</label>
            <form:input type="number" class="form-control" path="priceAfternoon" id="priceAfternoon" placeholder="Nhập giá sảnh chiều..." />
        </div>

        <div class="mb-3">
            <label for="priceEvening" class="form-label">Giá sảnh tối</label>
            <form:input type="number" class="form-control" path="priceEvening" id="priceEvening" placeholder="Nhập giá sảnh tối..." />
        </div>

        <div class="mb-3">
            <label for="priceWeekend" class="form-label">Giá sảnh cuối tuần</label>
            <form:input type="number" class="form-control" path="priceWeekend" id="priceWeekend" placeholder="Nhập giá sảnh cuối tuần..." />
        </div>

        <div class="mb-3">
            <label for="branch" class="form-label">Chi nhánh:</label>
            <form:select class="form-select" id="branch" path="branchID">
                <c:forEach items="${branches}" var="b">
                    <c:choose>
                        <c:when test="${b.branchID == halls.branchID}">
                            <form:option value="${b.branchID}" selected="selected">${b.branchName}</form:option>
                        </c:when>
                        <c:otherwise>
                            <form:option value="${b.branchID}">${b.branchName}</form:option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
        </div>

        <div class="mb-3">
            <label for="file" class="form-label">Ảnh</label>
            <form:input type="file" class="form-control" path="file" id="file"  />
            <c:if test="${halls.image != null}">
                <img src="${halls.image}" width="120" />
            </c:if>
        </div>

        <div class="mb-3">
            <button class="btn btn-info" type="submit">
                <c:choose>
                    <c:when test="${halls.hallID == null}">Thêm sảnh cưới</c:when>
                    <c:otherwise>Cập nhật sảnh cưới</c:otherwise>
                </c:choose>
            </button>
        </div>
    </form:form>
</div>