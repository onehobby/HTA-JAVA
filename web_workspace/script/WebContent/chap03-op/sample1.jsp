<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비교 연산자</title>
</head>
<body>
	<h1>비교 연산자</h1>	
	<script type="text/javascript">
		var x = 10;
		
		console.log("x == 10", x == 10);		// true
		console.log("x == '10'", x == '10');	// true
		
		console.log("x === 10", x === 10);		// true
		console.log("x === '10'", x === '10');	// false
		
		/*
			==
				타입과 값이 같으면 true
				타입이 다른 경우 같은 타입으로 변환 후 값이 같으면 true
			===
				타입과 값이 모두 같은 경우만 true
				
			* 비교 연산에서 ==보다는 ===사용을 권장한다.
		*/
		
		var y = 5;
		
		console.log("y != 5", y != 5);		//false
		console.log("y != '5'", y != '5');	//false
		console.log("y != '8'", y != '8');	//true
		
		console.log("y !== 5", y !== 5);	//false
		console.log("y !== '5'", y !== '5');//true
		console.log("y !== '8'", y !== '8');//true
		
		/*
			!=
				타입과 값이 같으면 false
				타입이 다른 경우 같은 타입으로 변환 후 값이 같으면 false
			!==
				타입이 다르거나 값이 다르면 true
				(타입도 같고 값도 같은 경우면 false)
		*/
		
		var str1 = "abc";
		var str2 = 'abc';
		
		console.log("str == str2", str == str2);
		console.log("str === str2", str === str2);
		/*
			문자열 비교할 때 == 혹은 ===을 이용해서 비교한다.
			자바의 equals()를 사용하지 않는다.
		*/
		
		
	</script>
</body>
</html>