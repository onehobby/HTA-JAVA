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
	var numbers = [1, 2, 3, 4, 5, 6];
	
	// 배열의 값을 제곱한 값을 가지는 새로운 배열을 만들기(map())
	var numbers2 = numbers.map(function (item, index) {
		return item*item;
	});
	
	console.log(numbers2);
	
	// 장학금을 받는 학생의 이름을 조회하기
	var students = [
		{name:"홍길동", score:74},
		{name:"김유신", score:59},
		{name:"강감찬", score:90},
		{name:"이순신", score:60},
		{name:"류관순", score:100},
	];
	
	var highScoreStudentName = students.filter(function (student, index) {
		return student.score >= 90;
	}).map(function(student, index) {
		return student.name;
	});
	
	console.log("장학금 수여 대상자 :", highScoreStudentName);
	
</script>
</div>
</body>
</html>