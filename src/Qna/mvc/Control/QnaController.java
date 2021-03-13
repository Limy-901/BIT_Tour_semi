package Qna.mvc.Control;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Domain.Qna;
import Qna.mvc.model.QnaService;
import Qna.mvc.vo.ListResult;


@WebServlet("/tour/qna.do")
public class QnaController extends HttpServlet {
	String m = null;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		System.out.println("1");
		m = request.getParameter("m");
		System.out.println("2 m: " +m);
		if(m.equals("list")) list(request, response);
		else if(m.equals("content")) getQna(request, response); 
		else if(m.equals("update")) getQna(request, response);
		else if(m.equals("write")) write(request, response);
		else if(m.equals("update")) DBupdate(request, response);
		else if(m.equals("delete")) delete(request, response);
		else if(m.equals("insert")) insert(request, response);
		else list(request, response);
	}

	/* QnA 페이지 리스트 */
	private void list(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		System.out.println("list");
		String cpStr = request.getParameter("cp");
		String psStr = request.getParameter("ps");
		HttpSession session = request.getSession();
		int cp = 1;
		int ps = 5;
		if(cpStr == null) {
			Object cpObj = session.getAttribute("cp");
			if(cpObj != null) cp = (Integer)cpObj;
		}else {
			cpStr = cpStr.trim();
			cp = Integer.parseInt(cpStr);
		}
		session.setAttribute("cp", cp);
		if(psStr == null) { 
			Object psObj = session.getAttribute("ps");
			if(psObj != null) ps = (Integer)psObj; 
		}else { 
			psStr = psStr.trim();
			int psParam = Integer.parseInt(psStr);
			Object psObj = session.getAttribute("ps");
			if(psObj != null) { 
				int psSession = (Integer)psObj;
				if(psSession != psParam) { 
					cp = 1;
					session.setAttribute("cp", cp);
				}
			}else {
				if(ps!=psParam) {
					cp = 1; 
					session.setAttribute("cp", cp);
				}
			}
			ps = psParam;
		}
		QnaService service = QnaService.getInstance();
		ListResult listResult = service.getListResult(cp, ps);
		request.setAttribute("listResult", listResult);
		if(listResult.getList().size() == 0 && cp>1) {
			response.sendRedirect("qna.do?m=list&cp="+(cp-1));
		}else {
			String view = "qnaList.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}
	}
	
	/* no 값 확인 */
	private long getNo(HttpServletRequest request) {
		String noStr = request.getParameter("no");
		long no = 0L;
		if(noStr == null) {
			return -1L;
		}else {
			noStr = noStr.trim();
			try {
				no = Integer.parseInt(noStr);
				return no;
			}catch(NumberFormatException ne) {
				return -1L;
			}
		}
	}
	
	/* 해당 no의 데이터 뽑기 -> Content or Update */
	private void getQna(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException{
		long no = getNo(request);
		System.out.println("3 no: " +no);
		if(no != -1L) {
			QnaService service = QnaService.getInstance();
			Qna qna = service.getQna(no);
			request.setAttribute("qna", qna);
			String view = "";
			if(m.equals("content")) {
				view = "qnaContent.jsp";
			}else {
				view = "qnaUpdate.jsp";
			}
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}else {
			System.out.println("else");
			String view = "qna.do";
			response.sendRedirect(view);
		}
	}
	
	/* 입력 값으로 DB 업데이트 */
	private void DBupdate(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException{
		long no = getNo(request);		
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		Qna qna = new Qna(no,-1L,subject,content,null,-1,-1,-1,null);
		QnaService service = QnaService.getInstance();
		service.DBupdate(qna);
		
		String view = "qna.do";
		response.sendRedirect(view);
	}
	
	/* 입력 폼으로 이동 */
	private void write(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException{
		String view = "qnaWrite.jsp";
		response.sendRedirect(view);
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException{
		long no = getNo(request);
		if(no != -1L) {
			QnaService service = QnaService.getInstance();
			service.del(no);
		}
		String view = "qna.do";
		response.sendRedirect(view);
	}
	private void insert(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException{
		HttpSession session = request.getSession(true);
		
		// 새글일 경우.
		long memNo = (long) session.getAttribute("member_no");
		String nick = (String) session.getAttribute("nick");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		Qna qna = new Qna(-1L,memNo,subject,content,null,-1,0,0,nick);
		QnaService service = QnaService.getInstance();
		service.insertNew(qna);
		
		
	}
}
