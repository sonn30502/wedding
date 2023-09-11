<%-- 
    Document   : list_branch
    Created on : 1 thg 9, 2023, 15:31:32
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<section class="container mt-5">
    <!-- Tiêu đề và nút thêm chi nhánh -->
    <div class="d-flex justify-content-between align-items-center mb-3">
        <h1 class="text-center text-danger">DANH SÁCH CHI NHÁNH</h1>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <a href="<c:url value='/admin/branch' />" class="btn btn-info">Thêm chi nhánh</a>
        </sec:authorize>
    </div>

    <!-- Bảng danh sách chi nhánh -->
    <div class="table-responsive">
        <table class="table table-hover">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Ảnh</th>
                    <th scope="col">ID</th>
                    <th scope="col">Tên sảnh</th>
                    <th scope="col">Địa chỉ</th>
                    <th scope="col">SDT</th>
                    <th scope="col">Thao tác</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${branch}" var="b">
                    <tr>
                        <td>
                            <img src="${b.image}" alt="${b.branchName}" width="120" class="img-thumbnail" />
                        </td>
                        <td>${b.branchID}</td>
                        <td>${b.branchName}</td>
                        <td>${b.address}</td>
                        <td>${b.phoneNumber}</td>
                        <td>
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <div class="btn-group" role="group">
                                    <a href="<c:url value='/admin/branch/${b.branchID}' />" class="btn btn-success">Cập nhật</a>
                                    <a href="<c:url value='/admin/branch/delete/${b.branchID}' />" class="btn btn-danger" onclick="return confirm('Bạn có chắc muốn xóa?')">Xóa</a>
                                </div>
                            </sec:authorize>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- Phân trang -->
    <c:if test="${counter > 1}">
        <ul class="pagination justify-content-center mt-4">
            <li class="page-item"><a class="page-link" href="<c:url value='list_branch' />">Tất cả</a></li>
                <c:forEach begin="1" end="${counter}" var="i">
                    <c:url value="list_branch" var="pageUrl">
                        <c:param name="page" value="${i}" />
                    </c:url>
                <li class="page-item"><a class="page-link" href="${pageUrl}">${i}</a></li>
                </c:forEach>
        </ul>
    </c:if>
</section>

