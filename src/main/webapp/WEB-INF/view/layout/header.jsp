<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>구매서버</title>
    <link rel="stylesheet" href="/css/test.css">
</head>

<body>  
    
    <nav>
        <div>
            <img src="images/d.jpg" usemap="#image-map">

<map name="image-map">
    <area target="" alt="" title="" href="/" coords="1,0,202,67" shape="rect">
</map>
        </div>
        
    <div>
        <ul>
            <li>
            <form action="">
                <input type="text"> 
                <button type="submit">검색</button>
            </form>
        </li>
            <c:choose>
                <c:when test="${principal == null}">
                    <li>
                        <a href="/">홈</a>
                    </li>
                    <li>
                        <a href="/loginForm">로그인</a>
                    </li>
                    <li>
                        <a href="/joinForm">회원가입</a>
                    </li>
                </c:when>

                <c:otherwise>
                    <li>
                        <a href="/">홈</a>
                    </li>
                    <li>
                        <!-- /user/1/purchase -->
                        <a href="/purchase">구매목록</a>
                    </li>
                    <li>
                        <a href="/logout">로그아웃</a>
                    </li>
                </c:otherwise>
            </c:choose>

        </ul>
    </div>
    </nav>