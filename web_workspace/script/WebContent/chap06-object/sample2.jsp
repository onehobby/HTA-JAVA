<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>객체</h1>
	
	<script type="text/javascript">
		var x = {
			a: 10,						// 프로퍼티
			b: 20,						// 프로퍼티
			plus: function() {			// 메소드
				console.log("더하기 실행");
				console.log(this.a+this.b);
			},
			minus: function() {			//메소드
				console.log("빼기 실행");
				console.log(this.a-this.b);
			}
		}
		
		// 객체의 메소드 실행
		x.plus();
		x.minus();
		
		// 객체에 새로운 메소드를 추가하기
		x.multiple = function() {
			console.log("곱하기 실행");
			console.log(this.a*this.b);
		}
		
		x.multiple();
	</script>
</body>
</html>