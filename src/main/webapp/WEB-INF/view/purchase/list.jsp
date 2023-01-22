<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../layout/header.jsp" %>
        <div class="top">
            <h1>상품 목록 페이지</h1>
        </div>
        <hr>
        <div class="table__box">
            <div>
                <table border="">
                    <tr>
                        <th>구매번호</th>
                        <th>구매자이름</th>
                        <th>구매상품명</th>
                        <th>구매수량</th>
                        <th>구매일자</th>
                        <th>구매취소</th>
                    </tr>
                    <c:forEach items="${purchaseList}" var="purchase">
                        <tr>
                            <td>${purchase.id}</td>
                            <td>${purchase.username}</td>
                            <td>${purchase.name}</td>
                            <td>${purchase.count}개</td>
                            <td>${purchase.createdAtToString}개</td>
                            <td>
                                <form action="/purchase/delete" method="post">
                                    <input type="hidden" name="purchaseId" value="${purchase.id}">
                                    <button type="submit">삭제</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <%@ include file="../layout/footer.jsp" %>