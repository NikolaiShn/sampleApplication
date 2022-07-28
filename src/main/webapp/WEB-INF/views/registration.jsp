<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE HTML>
<html>
<head>
  <title>Регистрация</title>
</head>
<body>
<div>
    <div>
       <form method="POST" action="/registration">
        <sec:csrfInput />
         <input name="username" type="text" placeholder="Username"/>
         <input name="password" type="password" placeholder="Password"/>
         <input name="name" type="text", placeholder="Name">
         <input name="lastName" type="text", placeholder="LastName">
         <button type="submit">Зарегистрироваться</button>
       </form>
    </div>
</div>
</body>
</html>