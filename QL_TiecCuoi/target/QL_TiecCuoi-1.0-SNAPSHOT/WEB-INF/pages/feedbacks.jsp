<%-- 
    Document   : feedback
    Created on : 2 thg 9, 2023, 11:45:26
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container">
    <h1 class="text-center text-info mt-1">Trang phản hồi khách hàng</h1>
    <c:url value="/feedbacks" var="action" />
    <form:form action="${action}" method="post" modelAttribute="feedback">
        <div class="form-floating mb-3 mt-3">
            <form:select class="form-select" id="event" name="event" path="eventID">
                <c:forEach items="${eventList}" var="e">
                    <c:choose>
                        <c:when test="${e.eventID == feedback.eventID.eventID}">
                            <option value="${e.eventID}" selected>${e.eventID}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${e.eventID}">${e.eventID}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
            <label for="event" class="form-label">ID sự kiện</label>
        </div>
        <div class="mb-3">
            <label for="feedbackContent" class="form-label">Nội dung phản hồi:</label>
            <form:textarea path="feedbackContent" class="form-control" rows="5" />
        </div>

        <div class="mb-3">
            <label for="rating" class="form-label">Đánh giá:</label>
            <form:input type="number" path="rating" min="1" max="5" class="form-control" />
        </div>

        <button type="submit" class="btn btn-primary">Gửi phản hồi</button>
    </form:form>
</div>