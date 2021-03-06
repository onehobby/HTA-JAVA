<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.tab {
		overflow: hidden;
		border: 1px solid #ccc;
		background-color: #f1f1f1;
	}
	.tab button {
		background-color: inherit;
		float: left;
		border: none;
		outline: none;
		cursor: pointer;
		padding: 14px 16px;
		transition: 0.3s;
		font-size: 17px;
	}
	.tab button:hover {
		background-color: #ddd;
	}
	
	.tab button.active {
		background-color: #ccc;
	}
	.tabcontent {
		display: none;
		padding: 6px 12px;
		border: 1px solid #ccc;
		border-top: none;
	}
</style>
</head>
<body>
	<h1>이벤트 처리</h1>
	
	<div class="tab">
		<button class="tablinks" onclick="openContent('news')" id="news">뉴스</button>
		<button class="tablinks" onclick="openContent('sport')" id="sports">스포츠</button>
		<button class="tablinks" onclick="openContent('ent')" id="ent">연예</button>
	</div>
	
	<div id="news-content" class="tabcontent">
		<h3>뉴스</h3>
		<p>교육부 "법 고쳐 방역지침 어기는 학원 제재"</p>
		<p>교육부 "법 고쳐 방역지침 어기는 학원 제재"</p>
		<p>교육부 "법 고쳐 방역지침 어기는 학원 제재"</p>
		<p>교육부 "법 고쳐 방역지침 어기는 학원 제재"</p>
		<p>교육부 "법 고쳐 방역지침 어기는 학원 제재"</p>
	</div>
	<div id="sports-content" class="tabcontent">
		<h3>스포츠</h3>
		<p>오승환의 불펜피칭 40구, 허삼영 감독 "준비끝났다."</p>
		<p>오승환의 불펜피칭 40구, 허삼영 감독 "준비끝났다."</p>
		<p>오승환의 불펜피칭 40구, 허삼영 감독 "준비끝났다."</p>
		<p>오승환의 불펜피칭 40구, 허삼영 감독 "준비끝났다."</p>
		<p>오승환의 불펜피칭 40구, 허삼영 감독 "준비끝났다."</p>
	</div>
	<div id="ent-content" class="tabcontent">
		<h3>연예</h3>
		<p>미스트롯' 시즌2로 돌아온다...'</p>
		<p>미스트롯' 시즌2로 돌아온다...'</p>
		<p>미스트롯' 시즌2로 돌아온다...'</p>
		<p>미스트롯' 시즌2로 돌아온다...'</p>
		<p>미스트롯' 시즌2로 돌아온다...'</p>
	</div>
	
	<script type="text/javascript">
		function openContent(tabId) {
			var contents = document.querySelectorAll(".tabcontent");
			
			for (var i=0; i<contents.length; i++) {
				contents[i].style.display = "none";
			}
			
			var contentId = "#" + tabId + "-content";
			var content = document.querySelector(contentId);
			content.style.display = 'block';
		}
	</script>
	
</body>
</html>