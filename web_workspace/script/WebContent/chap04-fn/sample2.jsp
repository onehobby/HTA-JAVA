<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>자바스크립트 함수</h1>
	<script type="text/javascript">
		
		// 매개변수와 return문이 있는 익명함수(이름없는 함수)를 변수 plus에 대입했다.
		var plus = function(num1, num2) {
			var result = num1 + num2;
			return result;
		}
		
		// 매개변수가 있는 익명함수를 변수 notice에 대입했다.
		var notice = function(message) {
			alert("메세지: " + message)
		}
		
		var x = plus(100,200);
		console.log("결과값", x)
		
		notice("함수 만들기 참 쉽다.")
		
	</script>
</body>
</html>