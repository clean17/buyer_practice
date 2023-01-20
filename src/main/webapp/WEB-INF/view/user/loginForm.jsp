

        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="top">
    <h1> 로그인 </h1>
</div>
    <hr>
    <div class="table__box">
        <fieldset>
            <legend class="fieldset__title"> 로그인 양식 </legend> 
             
    <form action="/login" method="post" class="form__">
        <table>
            <tr><input type="text" name="username" value="${cookie.remember.value}" placeholder="아이디" required></tr>
            <tr><input type="password" name="password" placeholder="패스워드" required></tr>
            <!-- <tr><input type="email" name="email" placeholder="이메일" required></tr> -->
        </table>

        <div class="checkbox">
            <div ><input class="checkbox__box1" type="checkbox" name="remember" ></div>
            <div class="checkbox__box2">ID 기억하기</div>
        </div>
        <div class="flex__right">
            <div>
                <form action="/joinForm" method="get"></form>
            </div>
            <div>
                <div> <button type="submit" class="right__font"> 로그인 </button></div>
            </div>
        </div>
    </form>
    
</fieldset>
</div>
<%@ include file="../layout/footer.jsp" %>
