package Main.mvc.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/tour/main.do")
public class MainController extends HttpServlet {
	private String m;
	

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		m= request.getParameter("m");
		if(m != null) {
			switch(m) {
			case "spain": spain(request,response); break;
			case "hanoi": hanoi(request,response); break;
			case "tokyo": tokyo(request,response); break;
			case "content": getQna(request,response); break;
			}		
		}
	}
	private void spain(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("스페인");
		String view = "product.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	private void hanoi(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("하노이");
		String view = "product.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	private void tokyo(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("도쿄");
		String view = "product.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	protected void getQna(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("스페인");
		String view = "product.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

}
