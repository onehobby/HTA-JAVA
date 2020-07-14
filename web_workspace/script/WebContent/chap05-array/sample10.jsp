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
	
	<h3>배열의 값을 정렬하기</h3>
	
<script type="text/javascript">
	var numbers = [10, 50, 15, 27, 86, 6, 9, 25, 63];
	
	// item1과 item2를 비교해서 양수가 나오면 item1이 큼
	// item1과 item2를 비교해서 음수가 나오면 item2가 큼
	// 결과값이 음수, 양수인지를 판단해서 자동으로 오름차순 정렬해줌
	// 내림차순 정렬을 원하는 경우 item1과 item2의 순서를 바꾼다.
	// 혹은 오름차순 정렬된 배열에 reverse() 함수를 적용한다.
	// reverse()는 정렬된 배열에 역순으로 정렬해준다.
	numbers.sort(function(item1, item2) {
		return item1 - item2;
	});
	console.log("오름차순 정렬된 배열 :", numbers);
	console.log("내림차순 정렬된 배열 :", numbers.reverse());
	
	// 성적순으로 정렬했을 때 1~3등까지 포함되는 학생의 이름을 조회하기 
	var students = [
		{name:"홍길동", score:74},
		{name:"김유신", score:59},
		{name:"강감찬", score:90},
		{name:"이순신", score:60},
		{name:"류관순", score:100},
	];
	
	var highScorestudentName = students.sort(function(student1, student2) {
		return student1.score - student2.score;
	}).reverse().map(function(student, index) {
		return {rank: index+1, name:student.name};
	}).filter(function (student, index) {
		return index <= 2;
	})
	
	console.log("성적 상위학생", highScorestudentName);

	

	
</script>
</div>
</body>
</html>