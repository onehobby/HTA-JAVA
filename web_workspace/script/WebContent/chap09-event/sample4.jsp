<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>키보드 이벤트</h1>
	<input type="text" id="field" onkeydown="fn1(event)"
								  onkeypress="fn2(event)"
								  onkeyup="fn3(event)">
								  
	<input type="text" id="field-2" onkeyup="valueCheck()" />
	<p id="message"></p>
								  
	<script type="text/javascript">
		function valueCheck() {
			var text = document.getElementById("field-2").value;
			var el = document.getElementById("message");
			
			if (text.length < 8) {
				el.textContent = "길이가 너무 짧습니다.";
				el.style.color = "red";
				return;
			}
			
			var level = 0;
			if (/[a-zA-Z]{1,}/.test(text)) {
				level++;
			}
			if (/[0-9]{1,}/.test(text)) {
				level++;
			}
			if (/[!@$%&*_=+]{1,}/.test(text)) {
				level++;
			}
			
			if (level == 1) {
				el.textContent = "암호가 너무 단순합니다.";
				el.style.color = "red";
			} else if (level == 2) {
				el.textContent = "암호가 조금 복잡합니다.";
				el.style.color = "yellow";
			}  else if (level == 3) {
				el.textContent = "암호가 매우 복잡합니다.";
				el.style.color = "green";
			}
		}
			
	
	
		var el = document.getElementById("field");
		function fn1(event) {
			console.log("fn1", "keydown...", event.which, el.value)
		}
		
		function fn2(event) {
			console.log("fn2", "keypress...", event.which, el.value)
			
		}
		
		function fn3(event) {
			console.log("fn3", "keyup...", event.which, el.value)
			
		}
		
	</script>
</body>
</html>