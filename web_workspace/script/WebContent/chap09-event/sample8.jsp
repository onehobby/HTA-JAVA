<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table {
		width: 100%;
		border: 1px solid #ddd;
		border-collapse: collapse;
	}
	th, td {
		padding: 14px;
		text-align: left;
		border: 1px solid #ddd;
	}
</style>
</head>
<body onload="changeDisplayStyle('.form-group', 'none')">
	<h1>checkbox, radio, select 관련 이벤트</h1>
	<!--
		checkbox. radio, select은 onchange이벤트를 컨트롤한다 
	 -->
	<p>체크박스, 라디오버튼의 체크상태가 변경될 때 마다 onchange 이벤트 발생</p>
	<p>select의 옵션항목이 새로 선택될 때 마다 onchange 이벤트 발생</p>
	
	<h3>체크박스</h3>
	<div>
		<label><input type="checkbox" name="" onchange="toggleField(event)"/>개인정보 활용동의</label>
		<div class="form-group">
			<label>전화번호</label>
			<div><input type="text" name="tel"/></div>
		</div>
		<div class="form-group">
			<label>이메일</label>
			<div><input type="text" name="email"/></div>
		</div>
	</div>
	
	<h3>라디오버튼</h3>
	<div>
		<label><input type="radio" name="type" value="전체" checked="checked" onchange="changeCourseDisplay(event)"/>전체</label>
		<label><input type="radio" name="type" value="교양" onchange="changeCourseDisplay(event)"/>교양과목</label>
		<label><input type="radio" name="type" value="전선" onchange="changeCourseDisplay(event)"/>전공선택</label>
		<label><input type="radio" name="type" value="전필" onchange="changeCourseDisplay(event)"/>전공필수</label>
	</div>
	<h3>셀렉터 박스</h3>
	<div>
		<label>과정구분:</label>
		<select onchange="changeCourseDisplay(event)">
			<option value="전체">전체과목</option>
			<option value="교양">교양과목</option>
			<option value="전선">전공선택 과목</option>
			<option value="전필">전공필수 과목</option>
		</select>	
	</div>
	<table id="course-table">
		<thead>
			<tr>
				<th>구분</th>
				<th>과정명</th>
				<th>학과</th>
				<th>담당교수</th>
			</tr>
		</thead>
		<tbody>
			<tr data-type="교양">
				<td>교양</td>
				<td>영어회화 기초</td>
				<td>영어영문학과</td>
				<td>홍길동 교수</td>
			</tr>
			<tr data-type="전선">
				<td>전공선택</td>
				<td>전자기학</td>
				<td>전자공학과</td>
				<td>이순신 교수</td>
			</tr>
			<tr data-type="전선">
				<td>전공선택</td>
				<td>공업수학 심화</td>
				<td>전자공학과</td>
				<td>홍길동 교수</td>
			</tr>
			<tr data-type="전필">
				<td>전공필수</td>
				<td>기초 전기/전자실험</td>
				<td>전자공학과</td>
				<td>김유신 교수</td>
			</tr>
			<tr data-type="전선">
				<td>전공선택</td>
				<td>대학수학</td>
				<td>수학과</td>
				<td>강감찬 교수</td>
			</tr>
			<tr data-type="전필">
				<td>전공필수</td>
				<td>회로이론</td>
				<td>전자공학과</td>
				<td>김유신 교수</td>
			</tr>
			<tr data-type="교양">
				<td>교양</td>
				<td>직업의 세계</td>
				<td>경영학과</td>
				<td>류관순 교수</td>
			</tr>
		</tbody>
	</table>
	
	<script type="text/javascript">
		// 라디오 버튼을 선택할 때 마다 해당되는 과목들이 표시되게 하기 
		function changeCourseDisplay(event) {
			var radioButton = event.target;
			var courseType = radioButton.value;
			console.log("선택된 과정구분", courseType);
			
			hideAllCourse();
			showCourse(courseType)
		}
		
		function hideAllCourse() {
		 	var rows = document.querySelectorAll("#course-table tbody tr");
		 	for (var i=0; i<rows.length; i++) {
		 		var row = rows[i];
		 		row.style.display = 'none';
		 	}
		}
		
		function showCourse(courseType) {
			var rows = document.querySelectorAll("#course-table tbody tr");
		 	for (var i=0; i<rows.length; i++) {
		 		var row = rows[i];
		 		if (courseType === "전체") {
		 			row.style.display = "";
		 			continue;
		 		}
		 		var rowCourseType = row.getAttribute("data-type");
		 		if(courseType === rowCourseType) {
		 			row.style.display = "";
		 		}
		 	}
		}
	
		// 체크박스의 체크여부에 따라서 개인정보 입력폼이 show/hide되게 하기
		function toggleField(event) {
			var checkbox = event.target;	// event.target에는 이벤트가 발생된 엘리먼트 객체가 들어있다.
			console.log("체크여부", checkbox.checked);
			
			if (checkbox.checked) {
				changeDisplayStyle(".form-group", "block");
			} else {
				changeDisplayStyle(".form-group", "none");
			}
		}
		
		function changeDisplayStyle(selector, displayValue) {
			var elements = document.querySelectorAll(selector);
			for (var i=0; i<elements.length; i++) {
				var el = elements[i];
				el.style.display = displayValue;
			}
		}
		
	</script>
</body>
</html>