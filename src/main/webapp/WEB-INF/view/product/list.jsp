<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
    <div class="top">
        <h1>상품 목록 페이지</h1>
    </div>
    <hr>
    <div class="table__box">
        <div>
            <table border="">
                <tr>
                    <th>번호</th>
                    <th>상품명</th>
                    <th>가격</th>
                    <th>재고</th>
                    <th>등록일</th>
                </tr>
                 <c:forEach items="${productList}" var="pro">
                <tr>
                    <td>${pro.id}</td>
                    <td><a href="/product/${pro.id}" class="product__name">${pro.name}</a></td>
                    <td>${pro.price}원</td>
                    <td>${pro.qty}개</td>
                    <td>${pro.createdAtToString}</td>
                </tr>
                </c:forEach>
            </table>
        </div>
    </div>
<%@ include file="../layout/footer.jsp" %>
