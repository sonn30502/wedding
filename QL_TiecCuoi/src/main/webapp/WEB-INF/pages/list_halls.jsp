<%-- 
    Document   : list_halls
    Created on : 30 thg 8, 2023, 16:24:20
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<section class="container mt-5">
    <div class="d-flex justify-content-between align-items-center">
       <h1 class="text-center text-danger">DANH SÁCH SẢNH CƯỚI</h1>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <div class="text-center">
                <a href="<c:url value="/admin/halls" />" class="btn btn-info mt-3">Thêm sảnh cưới</a>
            </div>
        </sec:authorize>
    </div>

    <div class="d-flex justify-content-end align-items-center mt-3">
        <form class="d-flex" action="<c:url value='/list_halls' />">
            <div class="input-group">
                <input class="form-control me-2" type="text" name="kw" placeholder="Nhập từ khóa...">
                <button class="btn btn-primary" type="submit">Tìm</button>
            </div>
        </form>
        <c:if test="${counter > 1}">
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="<c:url value="list_halls" />">Tất cả</a></li>
                    <c:forEach begin="1" end="${counter}" var="i">
                        <c:url value="list_halls" var="pageUrl">
                            <c:param name="page" value="${i}"></c:param>
                        </c:url>
                    <li class="page-item"><a class="page-link" href="${pageUrl}">${i}</a></li>
                    </c:forEach>
            </ul>
        </c:if>
    </div>

    <div class="table-responsive mt-3">
        <table class="table table-bordered table-hover">
            <thead class="table-primary">
                <tr>
                    <th></th>
                    <th>ID</th>
                    <th>Tên sảnh</th>
                    <th>Giá sáng</th>
                    <th>Giá trưa</th>
                    <th>Giá tối</th>
                    <th>Giá cuối tuần</th>
                    <th>Chi nhánh</th>
                    <th>Thao tác</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${halls}" var="h">
                    <tr>
                        <td>
                            <img src="${h.image}" alt="${h.hallName}" width="120" />
                        </td>
                        <td>${h.hallID}</td>
                        <td>${h.hallName}</td>
                        <td>${h.priceMorning}</td>
                        <td>${h.priceAfternoon}</td>
                        <td>${h.priceEvening}</td>
                        <td>${h.priceWeekend}</td>
                        <td>${h.branchID.branchName}</td>
                        <td>
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <div class="btn-group">
                                    <a href="<c:url value='/admin/halls/${h.hallID}' />" class="btn btn-success">Cập nhật</a>
                                    <a href="<c:url value='/admin/halls/delete/${h.hallID}' />" class="btn btn-danger" onclick="return confirm('Bạn có chắc muốn xóa?')">Xóa</a>
                                </div>
                            </sec:authorize>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</section>



