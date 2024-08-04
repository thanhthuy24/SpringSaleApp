<%-- 
    Document   : index
    Created on : Jul 16, 2024, 2:25:07 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang chủ</title>
    </head>
    <body>
        <h1 class="text-center text-primary mt-1" >DANH MỤC SẢN PHẨM</h1>
        
        <div class="row">
            <div class="col-md-3 col-12 bg-secondary">
                <c:url value="/" var="action" />
                <form action="${action}">
                    <div class="mb-3 mt-3">
                        <label for="q" class="form-label">Từ khóa: </label>
                        <input type="search" class="form-control" id="q" placeholder="Từ khóa" name="q">
                    </div>
                    <div class="mb-3 mt-3">
                        <label for="q" class="form-label">Từ giá </label>
                        <input type="number" class="form-control" id="fromPrice" placeholder="giá" name="fromPrice">
                    </div>
                    <div class="mb-3 mt-3">
                        <label for="q" class="form-label">Đến giá </label>
                        <input type="number" class="form-control" id="toPrice" placeholder="giá" name="toPrice">
                    </div>
                    <div class="mb-3 mt-3">
                        <input type="submit" value="Tìm sản phẩm" />
                    </div>
                </form>
            </div>
                    
            <div class="col-md-9 col-12">
                <a href="<c:url value="/products" />" class="btn btn-info mb-1">Add product</a>
                <table class="table table-striped">
                    <tr>
                        <th></th>
                        <th>Id</th>
                        <th>Tên sản phẩm</th>
                        <th>Gía bán</th>
                        <th></th>
                    </tr>
                    <c:forEach items="${products}" var="p">
                        <tr id="product${p.id}">
                            <td>
                                <image width="120" src="${p.image}" alt="${p.name}" />
                            </td>
                            <td>${p.id}</td>
                            <td>${p.name}</td>
                            <td>${String.format("%,d", p.price)}</td>
                            <td>
                                <a href="<c:url value="/products/${p.id}" />" class="btn btn-success">Cập nhật</a>
                                
                                <c:url value="/api/products/${p.id}" var="endpoint" />
                                <button onclick="deleteProduct('${endpoint}', ${p.id})" class="btn btn-danger">&times;</button>
                            </td>
                        </tr>
                    </c:forEach>

                </table> 
            </div>
        </div>
    </body>
</html>
