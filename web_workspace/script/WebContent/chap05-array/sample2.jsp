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
		<form>
			<div>
				<label>경력사항</label>
				<input type="text" name="career" value="한빛학원"/>
			</div>
			<div>
				<label>경력사항</label>
				<input type="text" name="career" value="새빛학원"/>
			</div>
			<div>
				<label>경력사항</label>
				<input type="text" name="career" value="별빛학원"/>
			</div>
			<div>
				<button type="submit">제출</button>
			</div>
		</form>		
	</div>
	<script type="text/javascript">
		// input태그 중에서 name속성이 career인 모든 엘리먼트를 반환한다.
		// 조회된 엘리먼트는 유사배열인 NodeList에 담겨서 반환한다.
		// NodeList는 배열은 아니지만 배열처럼 노드리스트.length로 길이를 알아낼 수 있고,
		// 						배열처럼 노드리스트.[인덱스]로 하나씩 꺼낼 수 있다.
		// "input[name='career']" 의 의미에 관해서 CSS 선택자 참조
		var inputs = document.querySelectorAll("input[name='career']");
		
		for (var index=0; index<inputs.length; index++) {
			var inputEl = inputs[index];
			var companyName = inputEl.value;
			console.log('경력사항', companyName);
		}
		
	</script>
</body>
</html>