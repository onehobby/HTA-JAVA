<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div {
		padding: 30px;
		border: 2px solid black;
	}
</style>
</head>
<body>
	<h1>이벤트 버블링</h1>
	<div onclick="box1()">
		<div onclick="box2()">
			<div onclick="box3(event)">
				
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		function box1() {
			console.log("box1함수가 실행됨");
		}
		
		function box2() {
			console.log("box2함수가 실행됨");
		}
		
		function box3(event) {
			console.log("box3함수가 실행됨");
			event.stopPropagation();
		}
	</script>
	
</body>
</html>