package control;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberBean;
import model.MemberDAO;


@WebServlet("/MemberListCon.do")
public class MemberListCon extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//데이터 베이스에 연결하여 회원의 모든 정보를 리턴
		MemberDAO mdao = new MemberDAO();
		//백터타입으로 넘어오고 데이터타입은 Memberbean
		Vector<MemberBean> v = mdao.getAllMember();
		
		request.setAttribute("v", v); //백터를 jsp쪽으로 넘겨준다.
		
		RequestDispatcher dis = request.getRequestDispatcher("MemberList.jsp");
		dis.forward(request, response);
		
	}
}
