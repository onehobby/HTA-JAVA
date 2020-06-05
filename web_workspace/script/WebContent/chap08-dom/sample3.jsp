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
				<th>번호</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>이메일</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<tr id="contact-100">
				<td>100</td>
				<td>홍길동</td>
				<td>010-1234-5678</td>
				<td>hong@gmail.com</td>
				<td><button onclick="removeRow(100)">삭제</button></td>
			</tr>
			<tr id="contact-101">
				<td>101</td>
				<td>김유신</td>
				<td>010-1111-1111</td>
				<td>kim@gmail.com</td>
				<td><button onclick="removeRow(101)">삭제</button></td>
			</tr>
			<tr id="contact-102">
				<td>102</td>
				<td>강감찬</td>
				<td>010-2222-2222</td>
				<td>kang@gmail.com</td>
				<td><button onclick="removeRow(102)">삭제</button></td>
			</tr>
		</tbody>
	</table>
	<script type="text/javascript">
		var body = document.querySelector("#contact-table tbody");
		
		function removeRow(no) {
			var row = document.getElementById("contact-" + no);
			body.removeChild(row);
		}
		
	</script>
	
	<%-- 
		<%
		List<Contact> contacts = contactDao.getAllContacts();
		for (Contact contact : contacts) {
		%>
			<tr id="contact-<%=contact.getNo()%>">
				<td><%=contact.getNo()%></td>
				<td><%=contact.getName()%></td>
				<td><%=contact.getTel()%></td>
				<td><%=contact.getEmail()%></td>
				<td><button onclick="removeRow(<%=contact.getNo()%>)"삭제</button></td>				
		<%
			}
		%>
	--%>
	
</body>
</html>