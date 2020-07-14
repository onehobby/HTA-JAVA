<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title></title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<h1>배열의 주요 메소드</h1>
	
	<h3>배열의 요소를 반복해서 꺼내기</h3>
	
<script type="text/javascript">
	var scores = [60, 30, 100, 70, 59];
	
	console.log("for문을 사용해서 배열의 값을 출력하기")
	for (var i=0; i < scores.length; i++) {
		console.log(scores[i]);
	}
	
	console.log("for~in문을 사용해서 배열의 값 출력하기");
	for ( var index in scores) {
		console.log(index, scores[index]);
	}
	
	console.log("forEach문을 사용해서 배열의 값을 출력하기");
	// ****** 자주사용 ******
	// item에 배열의 값이 차례로 담긴다.
	// 배열의 크기만큼 forEach문이 실행된다.
	// 배열의 크기만큼 index번호가 생성된다.
	scores.forEach(function(item, index) {
		console.log(item, index);
	})
</script>
</div>
</body>
</html>