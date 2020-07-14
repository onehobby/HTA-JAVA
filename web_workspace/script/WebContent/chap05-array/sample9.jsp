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
	
<script type="text/javascript">
	var scores = [80, 50, 90, 100, 54, 72, 82, 34];
	
	// 점수의 합계를 계산하기
	var sum = 0;
	for (var i=0; i<scores.length; i++) {
		sum += scores[i];
	}
	
	console.log("합계: ", sum);
	
	// reduce(function(합계, 요소){}, 초기값) 함수는
	// 해당 배열의 집계결과를 반환한다.
	var sum = scores.reduce(function(sum, num) {
		return sum += num
	}, 0);
	
	console.log("합계: ", sum);
	
</script>
</div>
</body>
</html>