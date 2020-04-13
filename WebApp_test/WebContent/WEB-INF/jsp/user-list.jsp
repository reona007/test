<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.UserBean, model.UserDAO, java.util.List" %>
<%
UserBean user = (UserBean)session.getAttribute("user");
List<UserBean> userList = (List<UserBean>)request.getAttribute("userList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>一覧表示</title>
</head>
<body>
<jsp:include page = "/WEB-INF/jsp/header.jsp"/>
<h2>ユーザー一覧</h2>
<table>
<tr><th>ユーザID</th><th>氏名</th><th>年齢</th></tr>
<% for(UserBean dao : userList){ %>
<tr><td><% dao.getId(); %></td><td><% dao.getName(); %></td><td><% dao.getAge(); %></td></tr><br>
<% } %>
</table>
<a href = "/WEB-INF/jsp/menu.jsp">メニューに戻る</a>
<jsp:include page="/WEB-INF/jsp/footer.jsp"/>
</body>
</html>