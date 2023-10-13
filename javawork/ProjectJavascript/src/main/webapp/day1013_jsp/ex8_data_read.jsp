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
    </style>
</head>
<%
    //post 방식은 일단 한글 엔코딩부터
    request.setCharacterEncoding("utf-8");

    //선택을 안할경우 null 값을 반환
    //선택을 할 경우에만 문자열 배열값을 반환
    String name = request.getParameter("name");
    int javaScore = 0;
    int jspScore = 0;
    int springScore = 0;

    String hp1 = request.getParameter("hp1");
    String hp2 = request.getParameter("hp2");
    String tcolor = request.getParameter("tcolor");
    String bcolor = request.getParameter("bcolor");
    //점수 계산
    int total = 0;
    double avg = 0;
    try {
        javaScore = Integer.parseInt(request.getParameter("java"));
        jspScore = Integer.parseInt(request.getParameter("jsp"));
        springScore = Integer.parseInt(request.getParameter("spring"));
        total = javaScore + jspScore + springScore;
        avg = total / 3.0;
    }catch (NumberFormatException e){

        total=0;
        avg=0;
    }


%>
<body>
<div>
<div style="font-size: 2em; background-color: <%=bcolor%>; color: <%=tcolor%>; width: 600px;margin-left: 30px">
   &nbsp;&nbsp;이름 : <%=name%> <br>
    &nbsp;&nbsp;java :  <%= javaScore%><br>
    &nbsp;&nbsp;jsp : <%= jspScore%><br>
    &nbsp;&nbsp;spring :  <%= springScore%><br>
    &nbsp;&nbsp;핸드폰 :<%=hp1%>-<%=hp2%><br>
    &nbsp;&nbsp;총점 :  <%= total%><br>
    &nbsp;&nbsp;평균 :  <%= avg%><br>



</div>
</div>
</body>
<script>
</script>
</html>