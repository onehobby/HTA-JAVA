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
	
	<h3>배열에 요소 추가/삭제하기</h3>
	
<script type="text/javascript">
	var fruits = ["사과","망고"];
	
	// 배열의 끝에 요소를 추가하기
	// ****** 자주사용 ******
	fruits.push("오렌지");
	fruits.push("복숭아");
	console.log(fruits);
	
	// 배열의 앞에 요소를 추가하기
	fruits.unshift("딸기");
	fruits.unshift("토마토");
	console.log(fruits);
	
	// 배열의 끝에서 요소를 꺼내고, 꺼낸요소를 배열에서 삭제하기
	var item = fruits.pop();
	console.log(item);
	console.log(item, fruits);
	
	// 배열의 앞에서 요소를 꺼내고, 꺼낸요소를 배열에서 삭제하기
	item = fruits.shift();
	console.log(item, fruits);
	
	
	
	var names = ["이순신", "을지문덕", "김유신", "강감찬"];
	// 지정된 인덱스의 요소 삭제하기
	// * 자주사용 *
	names.splice(2, 1); // splice(시작인덱스, 삭제할 갯수) : 시작인덱스부터 몇개 삭제할건지
	console.log(names);
	
	// splice(시작인덱스, 삭제할 갯수, 추가할 요소);
	var names = ["이순신", "을지문덕", "김유신", "강감찬"];
	names.splice(1, 0, '류관순', '세종대왕');	// splice(시작인덱스, 삭제할 갯수, 추가할 요소);
	console.log(names);
</script>
</div>
</body>
</html>