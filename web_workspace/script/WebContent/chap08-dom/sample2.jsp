<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>HTML DOM 연습</h1>
	
	<div>
		<h3>메뉴</h3>
		<ul id="drink-list"></ul>
	</div>
	
	<div>
		<h3>메뉴</h3>
		<ul id="alcol-list"></ul>
	</div>
	
	
	<script type="text/javascript">
		var drinkMenu = ["커피", "주스", "차", "탄산음료"];
		var alcolMenu = [{name:"소주", price:4000}, {name:"맥주", price:5000}, 
						 {name:"위스키", price:100000}, {name:"막걸리", price:7000}];
		
		var drinkUL = document.getElementById("drink-list");
		var alcolUL = document.querySelector("#alcol-list");
		
		/*
		for (var i=0; i<drinkMenu.length; i++) {
		var li = document.createElement("li");
		var content = document.createTextNode(drinkMenu[i]);
		li.appendChild(content);
		
		drinkUL.appendChild(li);
		}
		*/
		
		var drinkMenuChildren = "";
		for (var i=0; i<drinkMenu.length; i++) {
			drinkMenuChildren += "<li>" + drinkMenu[i]+ "</li>";
		}
		
		drinkUL.innerHTML = drinkMenuChildren;
		
		var htmlContent = "";
		for (var i=0; i<alcolMenu.length; i++) {
			var menu = alcolMenu[i];	// menu ---> {name:"소주", price:4000};
			var 이름 = menu.name;
			var 가격 = menu.price;
			
			htmlContent += "<li>"+이름+" "+가격+"원</li>"
		}
		
		alcolUL.innerHTML = htmlContent;
		
	</script>
	
</body>
</html>