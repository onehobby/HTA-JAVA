<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전역객체</h1>
	
	<script type="text/javascript">
		var AAA = 10;
		function AAA1() {
			console.log(this);
		}
	</script>
</body>
</html>