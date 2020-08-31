package com.kh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestGetServlet
 */
@WebServlet("/test1.do")
public class RequestGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestGetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * get 방식으로 요청했으면 내부적으로 자동으로 이 doGet()메소드가 호출 될 거 임
		 * 
		 * 첫번째 매개변수인 HttpServletRequest request 에는 사용자가 요청한 내용들을 받아주는 용도
		 * 두번째 매개변수인 HttpServletRequest response 에는 요청 처리후 나중에 사용자에게 응답을 해줄때 사용할 용도
		 * 
		 * request : 요청시 전달 된 내용 (사용자가 입력한 값들, 요청전송방식, 요청한 사용자의 ip 등등)
		 * response : 요청 처리 후 응답을 할 때 사용하게되는 객체
		 */
		/*
		 * 요청을 처리하기 위해서 전달된 값을 뽑아야됨 (request 에 parameter 공간에 담겨있음)
		 * > request 안의 파라미터 영역안에 데이터가 (키=밸류) 형태로 담겨있음(name속성값 = value값)
		 * 
		 * 따라서 request로 담겨있는 전달값 뽑는 메소드
		 * > request.getParameter("키값") : 그에 해당하는 value 값 반환 (단, 무조건 String으로 반환)"20" --파싱--> 20
		 * > request.getParameterValues("키값") : 그에 해당하는 value값들이 배열(string[])에 담겨 반환
		 */
		String name = request.getParameter("name"); 			// "홍길동" 	 / ""
		String gender = request.getParameter("gender"); 		// "M" "F"   / null
		int age = Integer.parseInt(request.getParameter("age"));// "20"->20	 / "" --> 오류뜸  
		String city = request.getParameter("city");				// "서울"
		Double height = Double.parseDouble(request.getParameter("height"));	// "170" --> 170.0
		String[] foods = request.getParameterValues("food");			// ["한식", "양식"] / null
		
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
		
		// ** 자바코드 수정했으면 무조건 서버리스타트 해야됨
		// 요청 처리 : > service > DAO > sql실행
//		int result = new MemberService().insertMember(name, gender, age, city, height,foods)
				
		// 요청처리 다했다는 가정 하에 응답 페이지 만들기 !
		
		// servlet 이 하는 역할은 요청처리 다하고 나서 그에 해당하는 응답페이지를 만들어서 사용자에게 출력하는 역할 함 
		// 즉, 여기 java 코드 내에서 사용자가 보게 될 응답 html 만드는 구문을 작성해야됨 
		
		// 장점 : java코드 내에 작성하기 때문에 반복문이나, 조건문, 유용한 메소드 같은 걸 활용 할 수 있음
		// 단점 : 복잡하다 혹시나 html을 수정하고자 했을 때 수정을 java 코드내에서 자바코드를 수정하는 거기 때문에
		//		다시 반영시키고자 한다면 서버 재실행 해야됨
		
		// * response 객체를 통해 사용자에게 html(응답화면) 전달
		
		// 1) 이제부터 내가 전달한 내용은 문서형태의 html이고 문자셋은 utf-8 이야 라는 걸 지정 
		response.setContentType("text/html; charset=utf-8");
		
		// 2) 응답하고자 하는 사용자 (요청했던 사용자)와의 스트림 (클라이언트와의 길)
		PrintWriter out = response.getWriter();
		
		// 3) 그 스트림을 (out)을 통해 html 문서를 한줄씩 출력
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
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
