<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import = "model.UserBean" %>

<% UserBean user = (UserBean)session.getAttribute("user");%>
<p>ログインユーザー：<%= user.getId() %></p>
