<%-- 
    Document   : list_menu
    Created on : 10 thg 9, 2023, 09:10:00
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<section class="container mt-5">
    <div class="d-flex justify-content-between align-items-center">
        <h1 class="text-center text-danger">DANH SÁCH MENU</h1>
        <div class="d-flex flex-column align-items-end">
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <a href="<c:url value="/admin/menu" />" class="btn btn-info mb-2">Thêm menu</a>
            </sec:authorize>
            <form class="d-flex mt-2" action="<c:url value='/list_menu' />">
                <div class="input-group">
                    <input class="form-control me-2" type="text" name="kw" placeholder="Nhập từ khóa...">
                    <button class="btn btn-primary" type="submit">Tìm</button>
                </div>
            </form>
        </div>
    </div>

    <c:if test="${counter > 1}">
        <ul class="pagination mt-3">
            <li class="page-item"><a class="page-link" href="<c:url value='list_menu' />">Tất cả</a></li>
                <c:forEach begin="1" end="${counter}" var="i">
                    <c:url value="list_menu" var="pageUrl">
                        <c:param name="page" value="${i}" />
                    </c:url>
                <li class="page-item"><a class="page-link" href="${pageUrl}">${i}</a></li>
                </c:forEach>
        </ul>
    </c:if>

    <div class="table-responsive mt-4">
        <table class="table table-hover">
            <thead>
                <tr>
                    <th scope="col">Ảnh</th>
                    <th scope="col">ID</th>
                    <th scope="col">Tên món</th>
                    <th scope="col">Giá</th>
                    <th scope="col">Chi nhánh</th>
                    <th scope="col">Thao tác</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${menu}" var="m">
                    <tr>
                        <td>
                            <img src="${m.image}" alt="${m.menuName}" width="120" class="img-thumbnail" />
                        </td>
                        <td>${m.menuID}</td>
                        <td>${m.menuName}</td>
                        <td>${m.price}</td>
                        <td>${m.branchID.branchName}</td>
                        <td>
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <div class="btn-group">
                                    <a href="<c:url value='/admin/menu/${m.menuID}' />" class="btn btn-success">Cập nhật</a>
                                    <a href="<c:url value='/admin/menu/delete/${m.menuID}' />" class="btn btn-danger" onclick="return confirm('Bạn có chắc muốn xóa?')">Xóa</a>
                                </div>
                            </sec:authorize>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</section>


