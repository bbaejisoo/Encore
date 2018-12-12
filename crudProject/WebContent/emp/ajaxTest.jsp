<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>	/* submit을 클릭하면 스크립트를 실행하고 서버에 다녀와라 */
function func(){
	//alert("자바스크립트가 수행");
	var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				document.getElementById("demo").innerHTML = this.responseText;
    }
	};
	var param = "empid=" + document.getElementById("empid").value;
	alert(param);
	xhttp.open("GET", "getEmpInfo.go?"+param);		//갈 준비하는 것이고
	xhttp.send();									//보내는 것이 send이다.
}
</script>
</head>
<body>
<form action="getEmpInfo.go" > 									<!-- onsubmit="func();" -->	<!-- onsubmit은 함수를 실행 된다음에 서버에 다녀와라는 의미 --> 
	<input type="number" id="empid" name="empid"><br>			<!-- id를 입력하고 버튼으로 이름얻기를 연습하려한다.-->
	<input type="button"  value="이름얻기" onclick="func();"> 	<!-- "submit" -->
</form>
<hr>
직원이름 : <div id ="demo">여기~~~</div>
</body>
</html>