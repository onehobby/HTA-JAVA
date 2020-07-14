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
	
	<h3>배열의 요소를 필터링하기</h3>
</div>
<script type="text/javascript">
	var scores = [59, 80, 100, 24, 67, 92];
	
	// filter(콜백함수) : 콜백함수가 true를 반환하는 요소만 포함하는 새로운
	// 배열이 최종적으로 반환된다.
	var highScores = scores.filter(function(item, index) {
		return item >= 80;
	});
	console.log(highScores);
	
	// 고득점자(80점 이상) 수 조회하기
	var highScoreCount = scores.filter(function(item, index) {
		return item >= 80;
	}).length;
	console.log("고득점자 수 :", highScoreCount);
	
	// 장학금을 받는 학생만 필터링하기(점수가 90점 이상)
	var students = [
		{name:"홍길동", score:74},
		{name:"김유신", score:59},
		{name:"강감찬", score:90},
		{name:"이순신", score:60},
		{name:"류관순", score:100},
	];
	
	var highScoreStudents = students.filter(function(student, index) {
		return student.score >= 90;
	});
	
	console.log("장학금 수령 대상자", highScoreStudents);
	
	highScoreStudents.forEach(function(student, index) {
		console.log(student, index);
	})
</script>
</body>
</html>