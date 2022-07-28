<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>
<head>
    <style>
        table, th, td {
          border: 1px solid black;
        }
        td {
          text-align: center;
        }
        table {
            width: 100%;
            height: auto;
        }
        #th_number {
            width: 20%;
            height: auto;
        }
        #th_text {
            width: 20%;
            height: auto;
        }
        #th_date {
            width: 20%;
            height: auto;
        }
        #th_image {
            width: 40%;
            height: auto;
        }
        #td_number {
            width: 20%;
            height: auto;
        }
        #td_text {
            width: 20%;
            height: auto;
        }
        #td_date {
            width: 20%;
            height: auto;
        }
        #td_image {
            width: 40%;
            height: auto;
        }
    </style>
  <title>Главная</title>
</head>
<body>
<div>
    <c:if test="${not empty records}">
		    <table>
                <tr>
                    <th id = "th_number">number</td>
                    <th id = "th_text">text</td>
                    <th id = "th_date">date</td>
                    <th id = "th_image">image</td>
                </tr>
                <c:forEach var="listValue" items="${records}">
                <tr>
                    <td id = "td_number">${listValue.number}</td>
                    <td id = "td_text">${listValue.text}</td>
                    <td id = "td_date">${listValue.date}</td>
                    <td id = "td_image"><img src="data:image/jpg;base64,${listValue.image}" width = "100%" height="100%"/></td>
                </tr>
                </c:forEach>
			</table>
	</c:if>
</div>
</body>
</html>