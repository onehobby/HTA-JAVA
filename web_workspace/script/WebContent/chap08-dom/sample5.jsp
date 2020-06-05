<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>DOM 연습</h1>
	
	<form>
		<div>
			<label>이름</label>
			<div><input type="text" name="username" id="user-name"></div>
		</div>
		<div>
			<label>아이디</label>
			<div><input type="text" name="userid" id="user-id"></div>
		</div>
		<div>
			<label>비밀번호</label>
			<div><input type="password" name="userpassword" id="user-pwd1"></div>
		</div>
		<div>
			<label>비밀번호 확인</label>
			<div><input type="password" name="userpassword2" id="user-pwd2"></div>
		</div>
		<div>
			<label>주소지</label>
			<div>
				<select name="useraddr" id="user-addr">
					<option value="" > 선택하세요</option>
					<option value="서울"> 서울특별시</option>
					<option value="경기"> 경기도</option>
					<option value="인천"> 인천광역시</option>
				</select>
			</div>
		</div>
		<div>
			<label>성별</label>
			<div>
				<label><input type="radio" name="gender" value="남" checked="checked" />남성</label>
				<label><input type="radio" name="gender" value="여" />여성</label>
			</div>
		</div>
		<div>
			<label>보유기술 (하나이상 선택하세요)</label>
			<div>
				<label><input type="checkbox" name="skill" value="java"/>자바</label>
				<label><input type="checkbox" name="skill" value="c"/>C, C++</label>
				<label><input type="checkbox" name="skill" value="python"/>파이썬</label>
				<label><input type="checkbox" name="skill" value="db"/>데이터베이스</label>
				<label><input type="checkbox" name="skill" value="network"/>네트워크</label>
			</div>
		</div>
		<div>
			<label>자기소개</label>
			<div><textarea name="userprofile" id="user-profile" rows="5"></textarea></div>
		</div>
		<div>
			<button type="button" onclick="checkFieldValue()">등록</button>
		</div>
	</form>
	
	<script type="text/javascript">
	function checkFieldValue() {
		// 입력필드의 값 읽어오기
		var userName = document.getElementById("user-name").value;
		console.log("사용자이름", userName);
		if (!userName) {
			alert("사용자 이름은 필수입력값입니다.");
			document.getElementById("user-name").focus();
			return;
		}
		
		var userId = document.getElementById("user-id").value;
		console.log("사용자 아이디", userId);
		if (!userId) {
			alert("사용자 아이디는 필수입력값입니다.");
			document.getElementById("user-id").focus();
			return;
		}
		
		// 비밀번호필드의 값 읽어오기
		var userPassword1 = document.getElementById("user-pwd1").value;
		var userPassword2 = document.getElementById("user-pwd2").value;
		console.log("사용자 비밀번호1", userPassword1)
		console.log("사용자 비밀번호2", userPassword2)
		if (!userPassword1) {
			alert("비밀번호는 필수입력값입니다.");
			document.getElementById("user-pwd1").focus();
			return;
		}
		if (userPassword1 != userPassword2) {
			alert("비밀번호가 서로 일치하지 않습니다.");
			document.getElementById("user-pwd1").value = "";
			document.getElementById("user-pwd2").value = "";
			document.getElementById("user-pwd1").focus();
			return;
		}
		
		// select박스의 선택된 값 읽어오기
		var userAddr = document.getElementById("user-addr").value;
		console.log("주소지", userAddr);
		if (!userAddr) {
			alert("주소지를 선택하세요");
			document.getElementById("user-addr").focus();
			return;
		}
		// 라디오버튼의 체크된 값 읽어오기
		//		* 성별의 경우 체크된 값을 읽어오는 것이 프로그램적으로 의미가 전혀 없음
		var radiobuttons = document.querySelectorAll("input[name=gender]");
		var checkedGenderValue;
		for (var i=0; i<radiobuttons.length; i++) {
			if (radiobuttons[i].checked) {
				
			}
		}
		console.log("성별", checkedGenderValue);
		
		// 체크박스의 체크된 값 읽어오기
		// 체크박스는 체크된 체크박스의 갯수가 프로그램에서 중요하게 다루어진다.
		var checkboxs = document.querySelectorAll("input[name=skill]");
		var checkedCheckboxCount = 0;
		for (var i=0; i<checkboxs.length; i++) {
			if (checkboxs[i].checked) {
				checkedCheckboxCount++;
			}
		}
		console.log("체크된 체크박스 갯수", checkedCheckboxCount);
		
		if (!checkedCheckboxCount) {
			alert("보유기술은 하나 이상 선택해야 합니다.");
			return;
		}
		// textarea의 값 읽어오기
		var userProfile = document.getElementById("user-profile").value;
		console.log("자기소개", userProfile);
		if (!userProfile) {
			alert("자기소개를 작성하세요");
			document.getElementById("user-profile").focus();
			return;
		}
		
		alert("모든 입력값이 유효합니다.")
	}
	</script>
</body>
</html>