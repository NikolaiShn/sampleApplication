<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE HTML>
<html>
<head>
  <title>Главная</title>
</head>
<body>
<div>
    <h4><a href="/login">Войти</a></h4>
    <h4><a href="/listing">Просмотреть список</a></h4>
    <h4><a href="/addOne">Добавить данные в список</a></h4>
    <div>
          <form method="POST" action="/logout">
          <sec:csrfInput />
            <button type="submit">Выход из системы</button>
          </form>
    </div>
</div>
</body>
</html>