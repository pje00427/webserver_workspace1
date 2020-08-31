package com.kh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestPostServlet
 */
@WebServlet("/test2.do")
public class RequestPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		System.out.println("doget 실행");
		
		
		// 요청시 전달값은 request의 parameter 영역안에 담겨있음 !
		// POST 방식 같은 경우request 담겨있는 값을 뽑기 전에 인코딩을 UTF-8으로 지정해야 한다.
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name"); 			// "김말똥" 	//  ""
		String gender = request.getParameter("gender");			// "M","F"	// null
		int age = Integer.parseInt(request.getParameter("age"));// "20"->20 // ""오류 (NumberFormationException)
		String city = request.getParameter("city");
		double height = Double.parseDouble(request.getParameter("height")); // "170" -> 170.0
		String[] foods = request.getParameterValues("food");	// ["한식","분식"] / null;
		
		System.out.println("name : " +  name);
		System.out.println("gender: " +gender);
		System.out.println("age : " + age);
		System.out.println("city : " + city);
		System.out.println("height : "+ height);
		
		if(foods != null) {
			for(int i=0; i<foods.length; i++) {
				System.out.println("foods["+ i + "]" + foods[i]);
			}
		}else {
			System.out.println("좋아하는 음식 없음");
		}
		// 요청처리 다했다는 가정 하에 응답 페이지 만들기 !
		// 1) 앞으로 내가 출력할 내용은 문서형태의 html이고, 문자셋은 utf-8이야 
		response.setContentType("text/html; charset=UTF-8");
		// 2) 요청햇던 사용자와의 스트림 생성 
		PrintWriter out = response.getWriter();
		
		// 3) 스트림으로 html문서를 한줄씩 출력 
		out.println("<html>");
		out.println("<head>");
		out.println("<title>개인정보출력화면</title>");
		out.println("<style>");
		out.println("h2{color:red;}");
		out.println("#name{color:orange; font-weight:bold;}");
		out.println("#age{color:yellow;}");
		out.println("#city{color:blue;}");
		out.println("#height{color:green;}");
		out.println("#gender{color:purple;}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>개인정보 결과(get)화면</h2>");
		
		out.printf("<span id='name'>%s</span>님은", name);
		out.printf("<span id='age'>%d</span>살이며,", age);
		out.printf("<span id='city'>%s</span>에 사는", city);
		out.printf("키는 <span id='height'>%.1f</span>cm이고", height);
		out.print("성별은");
		if(gender != null) {
			if(gender.equals("M")) {
				out.print("<span id='gender'>남자</span>입니다.<br>");
			}else{
				out.print("<span id='gender'>여자</span>입니다.<br>");
			}
		}else {
			out.print("선택을 안했습니다.");
		}
		
		out.print("좋아하는 음식은");
		
		
		if(foods != null) {
			out.print("<ul>");
			for(int i=0; i<foods.length; i++) {
				out.printf("<li>%s</li>", foods[i]);
			}
			out.print("</ul>");
		}else {
			out.print("없습니다.");
		}
		
		out.println("</body>");
		out.println("</html>");
		
		// Servlet : JAVA 코드 내에 html을 기술
		// JSP (Java Server Page): html 내에 JAVA코드 기술 가능
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("dopost 실행되나?");
		doGet(request, response);
		
	}

}
