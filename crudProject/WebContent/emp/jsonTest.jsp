<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function call() {
		//JSON : JavaScript Object Notation	(문자열 데이터로 네트워크 통신하여 데이터를 서로 교환을 한다.)
		var obj = {"name" : "아메리카노", "price" : "10000원"};
		here.innerHTML = obj.name + "<br>" + obj.price;
		
		var str = JSON.stringify(obj);					//이런 형태는 없다.
		here.innerHTML += "<br>" + str;					//자바스크립트 오브젝트를 문자열로 바꾼것
		here.innerHTML += str.name + "<br>" + str.price;	//이런 형태는 없다.
		
		var obj2 = JSON.parse(str);
		here.innerHTML += "<br>" + obj2.name + "<br>" + obj2.price;
		
	}
</script>
</head>
<body>
<h1>JSON 연습</h1>
<button onclick="call();">JSON얻기</button>
<div id="here">여기여기</div>
</body>
</html>