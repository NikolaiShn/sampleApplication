<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE HTML>
<html>
<head>
  <title>Главная</title>
</head>
<body>
    <form accept-charset="UTF-8" style = "width:350px; display:block; margin:auto;" method="POST" action="/login">
      <sec:csrfInput />
      <c:if test="${param.error != null}">
         <div style = "box-sizing:border-box; text-align:center; background-color: #ff3d00; width: 350px; margin-bottom:2px">
         Не удалось войти, попробуйте ещё раз.
         <br>
         Причина: ${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}
         </div>
      </c:if>
      <input style = "box-sizing:border-box; text-align:center; width:100%; padding:8px; margin-bottom:4px;" name="username" type="text" placeholder="имя пользователя"/>
      <input style = "box-sizing:border-box; text-align:center; width:100%; padding:8px; margin-bottom:4px;" name="password" type="password" placeholder="пароль"/>
      <button style = "display:block; background-color: #ccff90; border:none; width:150px; padding:6px; margin: 0 auto 4px;"
              type="submit">Войти
      </button>
    </form>
    <p style = "padding:6px 0; width:150px; margin:auto;" align = "center">
    <a style = "text-decoration:none;" href="/registration">Зарегистрироваться</a>
    </p>
</body>
</html>