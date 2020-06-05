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
	
		<table id="contact-table" style="width: 100%;" border="1">
		<thead>
			<tr>
				<th><input type="checkbox" name="checkall" onchange="toggleChecked()"></th>
				<th>번호</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>이메일</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<tr id="contact-100">
				<td><input type="checkbox" name="no" value="100" onchange="changeAllCheckbox()"></td>
				<td>100</td>
				<td>홍길동</td>
				<td>010-1234-5678</td>
				<td>hong@gmail.com</td>
				<td><button onclick="removeRow(100)">삭제</button></td>
			</tr>
			<tr id="contact-101">
				<td><input type="checkbox" name="no" value="101" onchange="changeAllCheckbox()"></td>
				<td>101</td>
				<td>김유신</td>
				<td>010-1111-1111</td>
				<td>kim@gmail.com</td>
				<td><button onclick="removeRow(101)">삭제</button></td>
			</tr>
			<tr id="contact-102">
				<td><input type="checkbox" name="no" value="102" onchange="changeAllCheckbox()"></td>
				<td>102</td>
				<td>강감찬</td>
				<td>010-2222-2222</td>
				<td>kang@gmail.com</td>
				<td><button onclick="removeRow(102)">삭제</button></td>
			</tr>
			<tr id="contact-103">
				<td><input type="checkbox" name="no" value="103" onchange="changeAllCheckbox()"></td>
				<td>103</td>
				<td>이순신</td>
				<td>010-3333-3333</td>
				<td>kang@gmail.com</td>
				<td><button onclick="removeRow(103)">삭제</button></td>
			</tr>
			<tr id="contact-104">
				<td><input type="checkbox" name="no" value="104" onchange="changeAllCheckbox()"></td>
				<td>104</td>
				<td>류관순</td>
				<td>010-4444-4444</td>
				<td>kang@gmail.com</td>
				<td><button onclick="removeRow(104)">삭제</button></td>
			</tr>
		</tbody>
	</table>
	
	<div>
		<button onclick="removeCheckedRows()">선택삭제</button>
		<button onclick="removeAllRows()">전체삭제</button>
	</div>
	
	<script type="text/javascript">
	
		var body = document.querySelector("#contact-table tbody");	
		
		// 전달받은 번호에 해당하는 연락처행을 삭제한다.
		function removeRow(no) {
			// 지정된 아이디의 tr을 조회한다
			var row = document.querySelector("#contact-" + no)
			// tbody의 자식엘리먼트 중에서 해당 tr을 삭제한다.
			body.removeChild(row)
		}
		
		// 체크박스가 체크된 행의 데이터를 삭제하기
		function removeCheckedRows() {
			// 모든 체크박스를 조회한다.
			var checkboxs = document.querySelectorAll("input[name=no]");
			for (var i=0; i<checkboxs.length; i++) {	// 체크박스를 순회하면서
				var checkbox = checkboxs[i];
				if (checkbox.checked) {				// 체크박스가 체크된 경우
					var no = checkbox.value;		// 그 체크박스의 value값을 조회한다.
					//console.log("선택된 체크박스 번호", no);
					removeRow(no);					// 위에서 정의한 함수를 사용해서 해당번호의 행을 삭제한다.
				}
			}
		}
		
		function removeAllRows() {
			body.innerHTML = "";
		}
		
		// 제목줄의 전체체크박스의 체크상태가 변경될 때 마다
		// 연락처행의 체크박스를 전체선택/전체해제한다.
		function toggleChecked() {
			// 제목줄의 체크박스를 조회한다.
			var checkbox = document.querySelector("input[name=checkall]");
			// 제목줄의 체크박스 체크상태를 조회한다.
			var checkedStatus = checkbox.checked;
			//console.log("현재 체크상태", checkedStatus);
			// 연락처행의 모든 체크박스를 조회한다.
			var checkboxs = document.querySelectorAll("input[name=no]");
			for (var i=0; i<checkboxs.length; i++) {	//연락처행의 체크박스를 순회하면서
				checkboxs[i].checked = checkedStatus;	// 제목줄의 체크박스 체크상태와 같게 만든다.
			}
		}
		
		// 체크박스를 선택/해제할 때마다 제목줄의 전체체크박스의 상태를 변경한다.
		function changeAllCheckbox() {
			var checkboxs = document.querySelectorAll("input[name=no]");
			
			var totalCheckboxCount = checkboxs.length;	// 전체 체크박스 갯수
			var checkedCount = 0;						// 체크된 체크박스 갯수
			for (var i=0; i<checkboxs.length; i++) {
				if (checkboxs[i].checked) {				// 체크박스가 체크된 상태
					checkedCount++;						// 체크된 체크박스 갯수를 1 증가시킨다.
				}
			}
			// 연락처행의 체크박스 갯수와 체크된 체크박스 갯수가 동일하면
			// 모두 체크된 경우고, 그 외는 하나이상 체크되지 않은 상황이다.
			var checkbox = document.querySelector("input[name=checkall]"); // 제목줄 체크박스
			if (totalCheckboxCount == checkedCount) {
				checkbox.checked = true;
			} else {
				checkbox.checked = false;
			}
		}
	</script>
</body>
</html>