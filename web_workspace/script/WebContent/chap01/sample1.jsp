<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--
	Internal javascript 방식,  
 -->
<script type="text/javascript">
	function myfunction() {
		alert("함수가 실행됨");
		
		String x = 10;
	}
</script>
</head>
<body>
	<h1>javascript 포함시키기</h1>
	
	<p>
		<button onclick="myfunction()">실행</button>
		<button onclick="yourfunction()">실행</button>
	</p>

<script type="text/javascript">
	function yourfunction() {
		alert("두번째 함수가 실행됨")
	}
</script>
</body>
</html>