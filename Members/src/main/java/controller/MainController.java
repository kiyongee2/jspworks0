package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.Member;
import member.MemberDAO;

@WebServlet("*.do")  //경로를 .do로 끝나도록 설정
public class MainController extends HttpServlet {
	
	private static final long serialVersionUID = 4L;
	
	MemberDAO memberDAO;  //MemberDAO 객체 선언

	public void init(ServletConfig config) throws ServletException {
		memberDAO = new MemberDAO();  //객체 생성
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//command 패턴으로 url 설정하기
		String uri = request.getRequestURI();
		System.out.println(uri);
		String command = uri.substring(uri.lastIndexOf('/'));
		System.out.println(uri.lastIndexOf('/'));
		System.out.println("command: " + command);
		
		String nextPage = null;
		
		if(command.equals("/memberList.do")) { //회원 목록 조회
			ArrayList<Member> memberList = memberDAO.getMemberList();
			
			//모델 생성 및 보내기
			request.setAttribute("memberList", memberList);
			nextPage = "memberList.jsp";
		}else if(command.equals("/memberForm.do")) {
			nextPage = "memberForm.jsp";
		}
		
		//포워딩
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher(nextPage);
		
		dispatcher.forward(request, response);
	}

}
