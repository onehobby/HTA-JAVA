<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>논리 연산자 사용하기</h1>
	
	<script type="text/javascript">
		var grade = '';
		var orderPrice = 1000000;
		
		var result1 = (grade != '' || orderPrice > 500000);
		var result2 = (grade || orderPrice > 500000);
		
		console.log("결과1", result1);
		console.log("결과2", result2);
		
		grade = "vip";
		
		var result1 = (grade != '' || orderPrice > 500000);
		var result2 = (grade || orderPrice > 500000);
		
		console.log("결과1", result1);
		console.log("결과2", result2);
		
		if (grade != '' || orderPrice > 500000) {
			console.log("사은품 지급하세요.");
		}
		
		if (grade || orderPrice > 500000) {
			console.log("사은품 지급하세요.");
		}
		
		grade = '';
		orderPrice = 300000;
		if (grade != '' || orderPrice > 500000) {
			console.log("사은품 지급하세요.")
		} else {
			console.log("사은품 지급대상이 아닙니다.")
		}
		if (grade || orderPrice > 500000) {
			console.log("사은품 지급하세요.")
		} else {
			console.log("사은품 지급대상이 아닙니다.")
		}
		
		if ('a') {
			console.log("값이 있음");
		} else {
			console.log("값이 없음");
		}
	</script>
</body>
</html>