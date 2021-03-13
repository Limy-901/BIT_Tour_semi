package Login.mvc.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Domain.Member;
import Login.mvc.model.LoginCase;
import Login.mvc.model.LoginService;


@WebServlet("/tour/login/login.do")
// �� ��Ʈ�ѷ��� ���ؼ� index.jsp�� ������ �ȴ�. ������ ��Ʈ�ѷ��� ���ϱ�!
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String m="";	
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		m= request.getParameter("m");
		if(m != null) {
			m= m.trim();
			System.out.println("m: "+m);
			switch(m) {
				case "login": login(request,response); break;
				case "join": join(request,response); break;
				case "findId": findId(request,response); break;
				case "findPwd": findPwd(request,response); break;
				case "check": check(request,response); break;
				case "insert": insert(request,response); break;
				case "foundId": foundId(request,response); break;
				case "foundPwd" : foundPwd(request,response); break;
				case "joinMsg" : joinMsg(request,response); break;
			}
		}else {
			login(request, response);
		}
	}
	private void login(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String view = "login.jsp";
		response.sendRedirect(view);
/*		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);*/
	}
	private void join(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String view = "join.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	private void joinMsg(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String email = request.getParameter("email");
		System.out.println();
		if(email !=null) email = email.trim();
		
		LoginService service = LoginService.getInstance();
		int rCode = service.joinS(email);
		request.setAttribute("rCode", rCode);
		System.out.println(rCode);
		String view = "join_msg.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	private void findId(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String view = "findId.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	private void foundId(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		if(name !=null) name = name.trim();
		if(phone !=null) phone = phone.trim();
		System.out.println("�̸������޾ƿ�");

		LoginService service = LoginService.getInstance();
		String rCode = service.findIdS(name, phone);
		//System.out.println("name: "+name+phone);
	
		HttpSession session = request.getSession();
		session.setAttribute("FoundID", rCode);
		String view = "foundId.jsp";
		response.sendRedirect(view);
	}
		
	private void findPwd(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String view = "findPwd.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	private void foundPwd(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		if(phone !=null) phone = phone.trim();
		if(email !=null) email = email.trim();
		System.out.println("�̸������޾ƿ�");
		System.out.println("phone: "+ phone);

		LoginService service = LoginService.getInstance();
		String rCode = service.findPwdS(phone, email);
		System.out.println("phone: "+phone);
	
		HttpSession session = request.getSession();
		session.setAttribute("FoundPWD", rCode);
		System.out.println(rCode);
		String view = "foundPwd.jsp";
		response.sendRedirect(view);
	}
	private void check(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String email = request.getParameter("email");		
		String pwd = request.getParameter("pwd");		
		String name = request.getParameter("name");		
		if(email != null) email = email.trim();
		if(pwd != null) pwd = pwd.trim();
		
		
		LoginService service = LoginService.getInstance();
		int rCode = service.checkMember(email, pwd);
		request.setAttribute("rCode", rCode);
		
		
		if(rCode == LoginCase.PASS) {
			System.out.println("pass �Ȱ���");
			HttpSession session = request.getSession();
			Member m = service.getMemberS(email); 
			session.setAttribute("loginPassUser", m);
			session.setAttribute("email", email);

		}else {
		System.out.println("pass�� �����ʰ� ���ܷ� ���͹��ȴ�.");
		}
		
		String view = "login_msg.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	private void insert(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {		
		String email = request.getParameter("email");
		System.out.println("email: "+ email);
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String nickname = request.getParameter("nickname");
		String phone = request.getParameter("phone");
		//long tripno = request.getLong("tripno");
		String withdrawal = request.getParameter("withdrawal");
		
		Member dto = new Member(-1, email, pwd, name, nickname, phone,  null, -1, null, withdrawal);
		LoginService service = LoginService.getInstance();
    	int rCode=service.insertS(dto, email); //rCode�� �����̴� 
    	request.setAttribute("rCode", rCode);
    	System.out.println(rCode);
    	String view = "join_msg.jsp";
    	RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	

}
