<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>To Do</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<%@ include file="nav.jsp" %>
	<!-- Content -->
	<div class="row mb-3">
		<div class="col-12">
			<div class="card">
				<div class="card-header">전체 일정</div>
				<div class="card-body">
					<div class="row">
						<c:forEach var="todo" items="${todos }">
							<div class="col-4 mb-2">
								<div class="card">
									<div class="card-header d-flex justify-content-between">
										<div>${todo.title }</div> 
										<div><span id="card-todo-status-${todo.no }" class="badge ${todo.statusClass }">${todo.status }</span></div>
									</div>
									<div class="card-body">
										<div class="row mb-3">
											<div class="col-9">
												<small>${todo.content }</small>
											</div>
											<div class="col-3">
												<button type="button" class="btn btn-outline-secondary btn-sm" onclick="openTodoDetailModal(${todo.no}); detail(${todo.no })">상세</button>
											</div>
										</div>
										<div class="d-flex justify-content-between">
											<span class="text-secondary font-weight-bold">${todo.userName }</span>											
											<strong><fmt:formatDate value="${todo.day }"/></strong>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					<div class="row">
						<div class="col-12 text-center"><button class="btn btn-outline-dark btn"> 더보기 </button></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 상세정보 모달창 -->
	<div class="modal" id="modal-todo-detail">
		<div class="modal-dialog modal-lg">
 			<div class="modal-content">
   				<div class="modal-header">
     				<h4 class="modal-title">상세 정보</h4>
     				<button type="button" class="close" data-dismiss="modal">&times;</button>
   				</div>
   				<div class="modal-body">
     				<div class="row">
     					<div class="col-12">
     						<table class="table table-bordered table-sm">
     							<colgroup>
     								<col width="15%">
     								<col width="35%">
     								<col width="15%">
     								<col width="35%">
     							</colgroup>
     							<tbody>
     								<tr>
     									<th>번호</th>
     									<td id="modal-todo-no"></td>
     									<th>제목</th>
     									<td colspan="3" id="modal-todo-title"></td>
     								</tr>
     								<tr>
     									<th>작성자</th>
     									<td id="modal-todo-username"></td>
     									<th>등록일</th>
     									<td id="modal-todo-day"></td>
     								</tr>
     								<tr>
     									<th>상태</th>
     									<td id="modal-todo-status"></td>
     									<th>완료일자</th>
     									<td id="modal-todo-completed-day"></td>
     								</tr>
     								<tr>
     									<th style="vertical-align: middle;">내용</th>
     									<td colspan="3" id="modal-todo-content"></td>
     								</tr>
     							</tbody>
     						</table>
     					</div>
     				</div>
   				</div>
   				<div class="modal-footer">
   					<span id="btn-todo-modify" style="display: none">
   					<button type="button" class="btn btn-success btn-sm" onclick="updateTodoStatus('처리완료')">처리완료</button>
     				<button type="button" class="btn btn-info btn-sm" onclick="updateTodoStatus('처리중')">처리중</button>
     				<button type="button" class="btn btn-secondary btn-sm" onclick="updateTodoStatus('보류')">보류</button>
     				<button type="button" class="btn btn-danger btn-sm" onclick="updateTodoStatus('삭제')">삭제</button>
     				</span>
     				<button type="button" class="btn btn-outline-dark btn-sm" data-dismiss="modal">닫기</button>
   				</div>
 			</div>
		</div>
	</div>
	
	<%@ include file="footer.jsp" %>
</div>
<script type="text/javascript">

	function openTodoDetailModal(todoNo) {
		$("#modal-todo-detail").modal('show');
	}
	
	function detail(todoNo) {
		
		
		//button.style.display = "none";
		
		var xhr = new XMLHttpRequest();
		
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4 && xhr.status == 200) {
				var text = xhr.responseText;
				var resData = JSON.parse(text);
				
				document.querySelector("#modal-todo-no").textContent = resData.no;
				
				var button = document.querySelector("#btn-todo-modify");
				
				if (resData.canModify) {
					button.style.display = "block";
				} else {
					button.style.display = "none";
				}
				
				document.querySelector("#modal-todo-title").textContent = resData.title
				document.querySelector("#modal-todo-username").textContent = resData.userId
				document.querySelector("#modal-todo-day").textContent = resData.createDate
				document.querySelector("#modal-todo-status").textContent = resData.status
				document.querySelector("#modal-todo-completed-day").textContent = resData.completedDay
				document.querySelector("#modal-todo-content").innerHTML = '<small>resData.content</small>';
				
				
				
				/*
				var button = document.querySelector("#modal-todo-button");
								
				var buttonlist = '<button type="button" class="btn btn-success btn-sm">처리완료</button>'
								+ '<button type="button" class="btn btn-info btn-sm">처리중</button>'
								+ '<button type="button" class="btn btn-secondary btn-sm">보류</button>'
								+ '<button type="button" class="btn btn-danger btn-sm">취소</button>'
								+ '<button type="button" class="btn btn-primary btn-sm">처리예정</button>'
								+ '<button type="button" class="btn btn-outline-dark btn-sm" data-dismiss="modal">닫기</button>'
								
				if (resData.canModify) {
					
					button.innerHTML = buttonlist;
					
				} else if (!resData.canModify) {
					
					button.innerHTML = '<button type="button" class="btn btn-outline-dark btn-sm" data-dismiss="modal">닫기</button>'
				}
								
				*/
				
			}			
		}
		
		xhr.open("get", "todo/detail.hta?todono=" + todoNo);
		
		xhr.send();
	}
	
	function updateTodoStatus(status) {
		
		var todoNo = document.querySelector("#modal-todo-no").textContent;
		
		var data = "status=" + status + "&todono=" + todoNo
		
		var xhr = new XMLHttpRequest();
		
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4 && xhr.status == 200) {
				var text = xhr.responseText;
				var resData = JSON.parse(text);
				
				document.querySelector("#modal-todo-status").textContent = resData.status;
				document.querySelector("#modal-todo-completed-day").textContent = resData.completedDay;
				
				var el = document.querySelector("#card-todo-status-" + todoNo);
				el.textContent = resData.status;
				
				el.className = "badge " + resData.statusClass;
				
				
			}
		}
		xhr.open("post", "/todo/updatestatus.hta");
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhr.send(data);
		
	}
	
</script>
</body>
</html>
