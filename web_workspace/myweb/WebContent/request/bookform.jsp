<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>책정보 등록 폼</h1>
	
	<h2>신규 책정보를 입력하세요</h2>
	<form action="bookregister.jsp" method="post">
		<!--
			제목, 저자, 장르, 출판사, 가격, 할인가격, 입고수량을
			입력받는 폼을 만드시오. 
		 -->
		 <div>
			 <div><label>제목</label></div>
			 <div><input type="text" name="title"></div>
		 </div>
		 <div>
			 <div><label>저자</label></div>
			 <div><input type="text" name="writer"></div>
		 </div>
		 <div>
			 <div><label>장르</label></div>
			 <div>
			 	<select name="genre">
			 		<option value="소설">소설</option>
			 		<option value="수필">수필</option>
			 		<option value="IT">IT</option>
			 	</select>
			 </div>
		 </div>
		 <div>
			 <div><label>출판사</label></div>
			 <div><input type="text" name="publisher"></div>
		 </div>
		 <div>
			 <div><label>가격</label></div>
			 <div><input type="number" name="price"></div>
		 </div>
		 <div>
			 <div><label>할인가격</label></div>
			 <div><input type="number" name="discountprice"></div>
		 </div>
		 <div>
			 <div><label>입고수량</label></div>
			 <div><input type="number" name="stock"></div>
		 </div>
		 <div>
		 	<button type="submit">입력</button>
		 </div>
	</form>
</body>
</html>