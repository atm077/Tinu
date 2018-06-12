<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Java开发邮件群发系统</title>
		<style>
			*{
				margin: 0;
				padding: 0;
			}
			.header{
				width: 100%;
				color: #fff;
			}
			.header .h-con{
				width: 1000px;
				margin: 0 auto;
				margin-top: 24px;
			}
			.header .h-con span{
				font-size: 20px;
				font-family: "微软雅黑";
				font-weight: 700;
				float: none;
			}
			.con{
				width: 770px;
				height: 365px;
				margin: 100px 0 0 150px;
				line-height: 60px;
			}
			.con input{
				width: 400px;
				height: 30px;
			}
			.con textarea{
				width: 400px;
				height: 100px;
			}
			.con .c-btn{
				width: 408px;
				margin-left: 60px;
				border: none;
				outline: none;
				height: 40px;
			}
			.c-btn:hover{
				background: #2cc5e4;
			}
		</style>
	</head>
	<body>
		<div class="header">
			<div class="h-con">
				<img src="image/bd_logo1.png" width="" height="" alt="">
				<span>Java开发邮件群发系统</span>
			</div>
		</div>
		<form action="mail" method="post">
			<div class="con">
				<p>
					<span>收件人:</span><input type="text" name="m-name">
				</p>
				<p>
					<span>主&emsp;题:</span><input type="text" name="m-topci">
				</p>
				<p>
					<span>正&emsp;文:</span>
					<textarea class="c-con" name="m-con"></textarea>
				</p>
				<input type="submit" value="发送邮件" class="c-btn">
			</div>
		</form>
	</body>
</html>
