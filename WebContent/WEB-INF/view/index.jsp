<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="bean.info"%>
<!DOCTYPE html>
<html>
<head>
<p><a href="/JavaScriptKadai/delete">管理画面はこちら</a></p>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TOPページ</title>
</head>
<body>
	<form action="/JavaScriptKadai/Insert" method="get" id="form">

		<p>名前</p>
		<input type="text" name="name" id="name">
		<p>メールアドレス</p>
		<input type="text" name="mail" id="mail">
		<p>内容</p>
		<textarea class="line_box" name="text"></textarea>
		<input type="submit" value="投稿" >
	</form>
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
	</tr>
	</table>
	<p><br><br><br></p>
<%	}%>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.min.js">
    </script>
    <script>
    $('#form').submit(function(){

    	var name = document.getElementById("name").value;
    	var mail = document.getElementById("mail").value;
    	console.log(name,mail);

    	if ( name == "" || mail == "") {
    		alert("入力内容に不備があります");
    		return false;
    	}else{
    		return true;
        }

    });

    </script>
</html>