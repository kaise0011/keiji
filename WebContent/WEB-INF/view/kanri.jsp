<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="bean.info"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者ページ</title>
<p><a href="/JavaScriptKadai/index">掲示板へ</a></p>
</head>
<body>
 <table>
<%
ArrayList<info> keiji = (ArrayList<info>)request.getAttribute("keiji");
	for(int i = 0;i < keiji.size();i++){
		info k = keiji.get(i);%>
	<tr>
		<td><%=k.getId() %></td>
		<td><%=k.getName() %></td>
		<td><%=k.getMail() %></td>
		<td><%=k.getTime()  %></td>
	</tr>
	</table>
	<table>
	<tr>
		<td><%=k.getText() %></td>
		<td>
		<form action="/JavaScriptKadai/del" method="get">
		<input type="hidden" name="id"value=<%=k.getId() %>>
		<input type="submit" value ="削除"></input>
		</form>
		</td>
		<td><form action="/JavaScriptKadai/update" method="get">
		<input type="hidden" name="id"value=<%=k.getId() %>>
		<input type="hidden" name="time" value=<%=k.getTime() %>>
		<textarea  name="text"></textarea>
		<input type="submit" value ="編集"></input>
		</form>
		</td>
	</tr>
	</table>
	<p><br><br><br></p>
<%	}%>
</body>
</html>