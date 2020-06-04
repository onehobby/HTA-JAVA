<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>배열</h1>
	
	<div>
		<h3>로또번호를 뽑아보세요 <button onclick="generateLotto()">번호추첨</button></h3>
		<div id="lotto-box"></div>
	</div>
	<script type="text/javascript">
		function generateLotto() {
			var lotto = [];		// 빈 배열을 생성
			
			/*
			for (var i=0; i<6; i++) {
				var number = Math.trunc(Math.random()*45 + 1);
				lotto[i] = number;
			}
			*/
			
			for (var i=0; i<6; i++) {
				var number = Math.trunc(Math.random()*45 + 1);
				lotto.push(number);
			}
			
			var el = document.querySelector("#lotto-box");
			el.textContent = lotto.join(', '); 
		}
	</script>
</body>
</html>