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
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</a></td>
                    <td>${product.price}원</td>
                    <td>${product.qty}개</td>
                    <td>${product.createdAtToString}</td>
                </tr>
            </table>
        </div>
        <div>
            <c:if test="${principal != null}">
                <form action="/purchase/insert" method="post">
                    <div class="purchase_btn">
                        <div>
                            <input type="hidden" name="productId" value="${product.id}">
                            <!-- userId 를 보내지말고 .. 컨트롤러에서 검증해 -->
                            <select name="count">
                                <c:forEach begin="1" end="${product.qty}" var="num">
                                    <option value="${num}">${product.name} ${num} 개</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div>
                        </div>
                        <button type="submit"> 구매 </button>
                    </div>
                </form>
            </c:if>
        </div>
    </div>
    <!-- 
    <c:if test="${principal != null}">
            <form action="/purchase/insert" method="post">
                <input type="hidden" name="productId" value="${product.id}">
                <select name="count">
                    <c:forEach begin="1" end="${product.qty}" var="num">
                        <option value="${num}">${num}</option>
                    </c:forEach>
                </select>
                <button type="submit">구매하기</button>
            </form>
        </c:if> -->
<%@ include file="../layout/footer.jsp" %>
