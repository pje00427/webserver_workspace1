<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>피자 주문 페이지</h1>
	
	<h2>오늘의 날짜</h2>
	<%@ include file="includePage.jsp" %>
	
    <form action="/2_JSP/confirmPizza.do" method="post">
		<fieldset>
            <legend>주문자 정보</legend>
            <table>
                <tr>
                    <th>이름</th>
                    <td><input type="text" name="userName" required></td>
                </tr>
                <tr>
                    <th>전화번호</th>
                    <td><input type="tel" name="phone" required></td>
                </tr>
                <tr>
                    <th>주소</th>
                    <td><input type="text" name="address" required></td>
                </tr>
                <tr>
                    <th>요청사항</th>
                    <td><textarea name="message"></textarea></td>
                </tr>
            </table>
        
        </fieldset>
        
		<fieldset>
            <legend>주문 정보</legend>
            <table>
                <tr>
                    <th>피자</th>
                    <td>
                        <select name="pizza">
                            <option value="콤비네이션피자">콤비네이션피자</option>
                            <option value="치즈피자">치즈피자</option>
                            <option value="포테이토피자">포테이토피자</option>
                            <option value="고구마피자">고구마피자</option>
                            <option value="불고기피자">불고기피자</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>토핑</th>
                    <td>
                        <input type="checkbox" name="topping" value="치즈토핑"> 고구마무스
                        <input type="checkbox" name="topping" value="콘크림무스"> 콘크림무스
                        <input type="checkbox" name="topping" value="파인애플토핑"> 파인애플토핑
                        <input type="checkbox" name="topping" value="치즈토핑"> 치즈토핑
                        <input type="checkbox" name="topping" value="치즈크러스트"> 치즈크러스트
                        <input type="checkbox" name="topping" value="치즈바이트"> 치즈바이트
                    </td>
                </tr>
                <tr>
                    <th>사이드</th>
                    <td>
                        <input type="checkbox" name="topping" value="콜라">콜라
                        <input type="checkbox" name="topping" value="사이다">사이다
                        <input type="checkbox" name="topping" value="핫소스">핫소스
                        <br>
                        <input type="checkbox" name="topping" value="피클">피클
                        <input type="checkbox" name="topping" value="파마산치즈가루">파마산치즈가루
                        <input type="checkbox" name="topping" value="갈릭소스">갈릭소스
                        <Br>
                        <input type="checkbox" name="topping" value="치즈오븐스파게티">치즈오븐스파게티
                        <input type="checkbox" name="topping" value="웨지감자">웨지감자
                        <input type="checkbox" name="topping" value="치킨스틱">치킨스틱

                    </td>
                </tr>
            </table>
        </fieldset>
        <br>
		<button type="submit">주문</button>
	</form>  

</body>
</html>