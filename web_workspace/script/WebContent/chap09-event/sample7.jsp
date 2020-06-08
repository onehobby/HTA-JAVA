<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div {
		width: 200px;
		background-color: black;
		color: white;
		font-weight: bolder;
		padding: 16px;
		margin-left: -180px;
		transition: margin 1s;
	}
	li {
		width: 70px;
		cursor: pointer;
	}
</style>
</head>
<body>
	<h1>이벤트 버블링</h1>
	
	<div id="menu-box" onclick="toggleMenu()">
		<h3>메뉴</h3>
		<ul>
			<li onclick="viewContent(event, '국내도서')">국내도서</li>
			<li onclick="viewContent(event, '해외도서')">해외도서</li>
			<li onclick="viewContent(event, '음반')">음반</li>
			<li onclick="viewContent(event, '영화')">영화</li>
		</ul>
	</div>
	
	<script type="text/javascript">
		var menuBoxVisible = false;
		
		function toggleMenu() {
			
			var menuBox = document.getElementById("menu-box");
			
			if (menuBoxVisible) {
				menuBox.style.marginLeft = "-180px";
				menuBoxVisible = false;
			} else {
				menuBox.style.marginLeft = "-10px";
				menuBoxVisible = true;
			}
		}
		
		function viewContent(event, menu) {
			event.stopPropagation();
			alert(menu + "컨텐츠를 표시합니다.")
		}
		
	</script>
</body>
</html>