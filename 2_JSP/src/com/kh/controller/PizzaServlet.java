package com.kh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PizzaServlet
 */
@WebServlet("/confirmPizza.do")
public class PizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PizzaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1) 전달값 중에 한글이 있을 경우 대비 인코딩 UTF-8 (post방식일 때만)
		request.setCharacterEncoding("UTF-8");
		// 2) 요청시 전달값 뽑기 (request parameter영역으로부터)
		//	request.getParameter("키값") : 밸류 (String 타입)
		//	request.getParameterValues("키값") : 밸류값들(String[])
		//  만일 키값에 해당하는게 없을 경우 : null로반환 
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String message = request.getParameter("message"); // "빨리가져다주세요" / ""
		
		String pizza = request.getParameter("pizza");
		String[] toppings = request.getParameterValues("topping");//["",""]/ null
		String[] sides = request.getParameterValues("side");
		
		// 3) 요청 처리(Service로 전달)
		int price = 0;
		
		switch(pizza) {
		case "콤비네이션피자" : price += 5000; break;
		case "치즈피자" : price += 6000; break;
		case "포테이토피자 " :
		case "고구마피자" : price += 7000; break;
		case "불고기피자" : price += 8000; break;
			}
		if(toppings != null) {
			for(int i=0; i<toppings.length; i++) {
				switch(toppings[i]) {
				case "고구마무스" :
				case "콘크림무스" : price += 1500; break;
				case "파인애플토핑":
				case "치즈크러스트" :
				case "치즈바이트" : price += 3000; break;
				}
			}
		}
		
		if(sides != null) {
			for(int i=0; i<sides.length; i++) {
				switch(sides[i]) {
				case "콜라" :
				case "사이다" : price += 2000; break;
				case "피클" :
				case "핫소스":
				case "파마산치즈가루":
				case "갈릭소스": price += 500; break;
				case "치즈오븐스파게티": price += 3000; break;
				case "치킨스틱" : price += 4000; break;
				
 				}
			}
		}
		
		// 4) 반환받은 결과를 가지고 사용자가 보게될 응답페이지 만들기 혹은 jsp위임 
		// 응답데이터 -> request의 attribute에 담기 
		request.setAttribute("userName", userName);
		request.setAttribute("phone", phone);
		request.setAttribute("address", address);
		request.setAttribute("message", message);
		request.setAttribute("pizza", pizza);
		request.setAttribute("toppings", toppings);
		request.setAttribute("sides", sides);
		request.setAttribute("price", price);
		
		RequestDispatcher view = request.getRequestDispatcher("views/05_pizzaPayment.jsp");
		
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
