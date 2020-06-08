<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div {
		padding: 50px;
		border: 2px solid black;
	}
</style>
</head>
<body>
	<h1>마우스 이벤트</h1>
	
	<div onmouseenter="box1enter()"
		 onmouseleave="box1leave()"
		 onmouseover="box1over()"
		 onmouseout="box1out()">
		<div onmouseenter="box2enter()"
		 	 onmouseleave="box2leave()"
		 	 onmouseover="box2over()"
		 	 onmouseout="box2out()"></div>
	</div>
	
	<script type="text/javascript">
	
	/*
		mouseenter, mouseleave: 마우스가 해당 엘리먼트의 경계 안에 있는지 아닌지에 따라 이벤트 발생여부가 결정된다.
		mouseover, mouseout: 마우스가 해당 엘리먼트위에 위치하고 있는지 아닌지에 따라 이벤트 발생여부가 결정된다.
		* 보통 onmouseenter와 onmouseleave를 자주 사용함.
	*/
		function box1enter() {console.log("box1", "enter")}
		function box1leave() {console.log("box1", "leave")}
		function box1over() {console.log("box1", "over")}
		function box1out() {console.log("box1", "out")}
		function box2enter() {console.log("box2", "enter")}
		function box2leave() {console.log("box2", "leave")}
		function box2over() {console.log("box2", "over")}
		function box2out() {console.log("box2", "out")}
	</script>
</body>
</html>