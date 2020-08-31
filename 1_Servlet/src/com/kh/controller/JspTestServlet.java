package com.kh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JspTestServlet
 */
@WebServlet("/test3.do")
public class JspTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JspTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// post 방식은 값 뽑기전에 UTF-8 인코딩 작업
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");			// "홍길동"	// ""
		String gender = request.getParameter("gender");		// "M" "F"	// null
		int age = Integer.parseInt(request.getParameter("age"));// "20"->20	 / "" --> 오류뜸  
		String city = request.getParameter("city");				// "서울"
		Double height = Double.parseDouble(request.getParameter("height"));	// "170" --> 170.0
		String[] foods = request.getParameterValues("food");			// ["한식", "양식"] / null
		
		// > service > Dao > sql 실행
		//< return결과<		<
		// 응답페이지 만들어줄것
		
		// 응답페이지를 만들어서 사용자에게 출력했던 servlet이 하는 일을 jsp에게 떠넘길것 
		
		// 위임시 필요한 객체 : RequestDispatcher 클래스 
		
		
		// 응답페이지(JSP)에 필요한 데이터를 주섬주섬 담아서 보내줘야됨!! 
		// 주섬주섬담기위한 공간 : request의 attribute영역 (키-밸류 세트로 담아내야됨)
		// request.setAttribute("키값", 밸류값);
		request.setAttribute("name", name);
		request.setAttribute("gender", gender);
		request.setAttribute("age", age);
		request.setAttribute("city", city);
		request.setAttribute("height", height);
		request.setAttribute("foods", foods);	
		
		
		// 응답할 뷰 jsp 선택
		RequestDispatcher view = request.getRequestDispatcher("views/responsePage.jsp");
		
		// 포워딩 
		view.forward(request, response);

	
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
