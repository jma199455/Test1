package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberBean;
import model.MemberDAO;

/**
 * Servlet implementation class MemberJoinProc
 */
@WebServlet("/proc.do")
public class MemberJoinProc extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//한글처리
		request.setCharacterEncoding("euc-kr");
		
		MemberBean bean = new MemberBean();
		bean.setId(request.getParameter("id"));
		//패스워드르 먼저 받아와야함
		String pass1 = request.getParameter("pass1");
		String pass2 = request.getParameter("pass2");
		
		
		bean.setPass1(pass1);
		bean.setPass2(pass2);
		bean.setEmail(request.getParameter("email"));
		bean.setTel(request.getParameter("tel"));
		
		//hobby배열이기 때문에
		String[] arr = request.getParameterValues("hobby");
		String data = "";
		//hobby배열이기 때문에 for문사용
		for (String string : arr) {
			data += string + " " ; //하나의 스트링으로 데이터 연결
		}
		bean.setHobby(data);
		bean.setJob(request.getParameter("job"));
		bean.setAge(request.getParameter("age"));
		bean.setInfo(request.getParameter("info"));
		
		//패스워드가 같은 경우에만 데이터 베이스에 저장
		if(pass1.equals(pass2)) {
			//데이터베이스 객체 선언
			MemberDAO mdao = new MemberDAO();
			mdao.insertMember(bean);
			//컨트롤러에서 또다른 컨트롤러를 호출해주어야한다.!
			RequestDispatcher dis = request.getRequestDispatcher("MemberListCon.do");
			dis.forward(request, response);
			
		}else {
			
			//자바스크립트를 사용할 수 없으므로 request객체사용해서 에러페이지 jsp쪽으로 떠넘겨 준다.
			request.setAttribute("msg", "패스워드가 일치하지 않습니다.");
			RequestDispatcher dis = request.getRequestDispatcher("LoginError.jsp");
			dis.forward(request, response);
		}
		

		
		
	}
	
}
