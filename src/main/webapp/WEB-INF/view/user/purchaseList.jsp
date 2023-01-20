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
                <c:forEach items="" var="">
                    <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</a></td>
                    <td>${product.price}원</td>
                    <td>${product.qty}개</td>
                    <td>${product.createdAt}</td>
                </tr>
                </c:forEach>
                
            </table>
        </div>
        <div>  
            
            <form action="/purchaselist" method="post">
                <div class="purchase_btn">
                    <div>
                        <select name="name" id="">
                            <option value="바나나">바나나 ( <small>남은수량 ${product.qty}</small> )</option>
                        </select>
                    </div>
                    <div>
                        <input type="number" size="5" name="qty" placeholder="구매 수량" max="50" id="">
                    </div>
                    <button type="submit"> 구매 </button>
                </div>
            </form>
        </div> 
    </div>
<%@ include file="../layout/footer.jsp" %>
