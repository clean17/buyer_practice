<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="top">
    <h1>회원 가입 페이지</h1>
</div>
    <hr>
    <div class="table__box">
        <fieldset>
            <legend class="fieldset__title">회원 가입 양식</legend> 
             
    <form action="/join" method="post" class="form__">
        <table>
            <tr><input type="text" name="username" placeholder="Enter username" required></tr>
            <tr><input type="password" name="password" placeholder="Enter password" required></tr>
            <tr><input type="email" name="email" placeholder="Enter email" required></tr>
        </table>
        <div class="flex__right">
        <div > <button type="submit" class="right__font"> 회원가입 </button></div>
        </div>
    
    </form>
</fieldset>
</div>
<%@ include file="../layout/footer.jsp" %>
