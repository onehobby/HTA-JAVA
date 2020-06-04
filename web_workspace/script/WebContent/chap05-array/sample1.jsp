<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onload="changeList('영화순위')">
	<h1>배열 연습하기</h1>
	
	<div>
		<button onclick="changeList('영화순위')">영화순위</button>
		<button onclick="changeList('도서순위')">도서순위</button>
		<button onclick="changeList('음반순위')">음반순위</button>
	</div>
	
	<div>
		<h3 id="list-title"></h3>
		<ol id="item-list"></ol>
	</div>
	
	<script type="text/javascript">
		var movies = ["침입자", "언더워터", "위대한 쇼맨", "프리즌 이스케이프", "카페 벨에포크"];
		var books = ["The having", "애쓰지 않고 편안하게", "코로나 투자 전쟁", "기억1", "보통의 언어들"];
		var musics = ["아이즈원", "백예린", "슬기로운 의사생활", "서은광", "트와이스"]
		
		function changeList(title) {
			var items = null;
			
			if (title == '영화순위') {
				items = movies;
			} else if (title == '도서순위') {
				items = books;
			} else if (title == '음반순위') {
				items = musics;
			}
			
			var contents = "";
			for (var i=0; i<items.length; i++) {
				var itemName = items[i];
				contents += "<li>"+itemName+"</li>";
			}
			
			var h3el = document.querySelector("#list-title");
			var olel = document.querySelector("#item-list");
			
			h3el.textContent = title;
			olel.innerHTML = contents;
		}
		
		/*
		var contents = "";
		contents += "<li>"+movies[0]+"</li>";
		contents += "<li>"+movies[1]+"</li>";
		contents += "<li>"+movies[2]+"</li>";
		contents += "<li>"+movies[3]+"</li>";
		contents += "<li>"+movies[4]+"</li>";
		
		// HTML 문서에서 아이디가 movie-list인 엘리먼트를 조회하기
		var el = document.querySelector("#movie-list");
		// 조회된 엘리먼트의 내부 HTML 컨텐츠를 contents에 저장된 내용으로 변경하기
		el.innerHTML = contents;
		*/
	</script>
</body>
</html>