<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#box {
		overflow: hidden;
		margin-top: 10px;
	}
	#box div {
		float: left;
		width: 120px;
		height: 120px;
		border: 1px solid #eee;
		background-color: rgb(200, 200, 200);
	}
</style>
</head>
<body>
	<h1>배열</h1>
	
	<div>
		<button onclick="changeColor()">클릭하세요</button>
	</div>
	
	<div id="box">
		<div></div>
		<div></div>
		<div></div>
		<div></div>
		<div></div>
		<div></div>
		<div></div>
		<div></div>
	</div>
	<script type="text/javascript">
		function changeColor() {
			var boxs = document.querySelectorAll("#box div");
			
			for (var i=0; i<boxs.length; i++) {
				var div = boxs[i];
				
				var red = Math.trunc(Math.random()*255);
				var green = Math.trunc(Math.random()*255);
				var blue = Math.trunc(Math.random()*255);
				
				div.style.backgroundColor = 'rgb('+red+', '+green+', '+blue+')';
			}
		}
	</script>
</body>
</html>