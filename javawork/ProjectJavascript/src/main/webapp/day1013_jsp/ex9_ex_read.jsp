<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap"
          rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <style>
        body * {
            font-family: 'Jua';
        }
        h5 {
            text-align: center;
        }
    </style>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");

    String line = request.getParameter("line");
    String img = request.getParameter("selected");
    String today = request.getParameter("today");
%>
<div>
    <h5 style="color: white; background-color: tomato; width: 300px"><%=today%></h5>
    <img src="<%=img%>" style="border: <%=line%>;width: 300px ">
</div>
</body>
</html>