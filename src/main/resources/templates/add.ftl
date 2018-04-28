<html>
<head>
	<title>发送消息</title>
</head>
<center>
<body>
	<h1>发送消息</h1>
	<form action="/jms/add"  method="post">
		<p>发送的消息:<input type="text" name="text"/> </p>
		<p><input type="submit" value="发送"/></p>
	</form>
	<h1>消息列表</h1>
    <#list MessageList as Message>
		<tr>
            <td>时间：${Message.date}<br/></td>
            <td>原文：${Message.text}<br/></td>
            <td>译文：${Message.translation}<br/><br/><br/></td>
        </tr>
	</#list>
</body>
</center>
</html>