<%-- 
    Document   : event
    Created on : 2 thg 9, 2023, 16:17:58
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">
    <h1 class="text-center text-info mt-1">Event</h1>
    <c:url value="/event" var="action" />
    <form:form action="${action}" method="post" modelAttribute="events">
        <div class="form-floating mb-3 mt-3">
            <form:select class="form-select" id="branch" name="branch" path="branchID">
                <c:forEach items="${branchList}" var="b">
                    <c:choose>
                        <c:when test="${b.branchID == event.branchID.branchID}">
                            <option value="${b.branchID}" selected>${b.branchID}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${b.branchID}">${b.branchID}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
            <label for="branch" class="form-label">Chi nhánh:</label>
        </div>
        <div class="form-floating mb-3 mt-3">
            <form:select class="form-select" id="halls" name="halls" path="hallID">
                <c:forEach items="${hallList}" var="h">
                    <c:choose>
                        <c:when test="${h.hallID == event.hallID.hallID}">
                            <option value="${h.hallID}" selected>${h.hallID}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${h.hallID}">${h.hallID}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
            <label for="halls" class="form-label">Sảnh cưới</label>
        </div>
        <div class="form-floating mb-3 mt-3">
            <form:select class="form-select" id="menu" name="menu" path="menuID">
                <c:forEach items="${menuList}" var="m">
                    <c:choose>
                        <c:when test="${m.menuID == event.menuID.menuID}">
                            <option value="${m.menuID}" selected>${m.menuID}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${m.menuID}">${m.menuID}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
            <label for="menu" class="form-label">Thực đơn</label>
        </div>
        <div class="form-floating mb-3 mt-3">
            <form:select class="form-select" id="dv" name="service" path="serviceID">
                <c:forEach items="${dvList}" var="dv">
                    <c:choose>
                        <c:when test="${dv.serviceID == event.serviceID.serviceID}">
                            <option value="${dv.serviceID}" selected>${dv.serviceID}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${dv.serviceID}">${dv.serviceID}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
            <label for="service" class="form-label">Dịch vụ</label>
        </div>
        <%-- 
        <div class="mb-3">
            <label for="userID" class="form-label">User ID</label>
            <form:input path="userID" id="userID" class="form-control" />
        </div>
        --%>
        <div class="mb-3">
            <label for="totalPrice" class="form-label">Total Price</label>
            <form:input path="totalPrice" id="totalPrice" class="form-control" />
        </div>
        <div class="mb-3">
            <label for="status" class="form-label">Status</label>
            <form:select path="status" id="status" class="form-control">
                <form:option value="CONFIRMED">Đã xác nhận</form:option>
                <form:option value="PENDING">Chưa xác nhận</form:option>
                <form:option value="CANCELLED">Đã hủy</form:option>
            </form:select>
        </div>
        <button type="submit" class="btn btn-primary">Create</button>
    </form:form>
</div>