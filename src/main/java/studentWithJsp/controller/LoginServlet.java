package studentWithJsp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentWithJsp.dao.StudentDao;
import studentWithJsp.dto.Student;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		StudentDao studentDao = new StudentDao();
		List<Student> students =studentDao.getAllStudents();
		boolean value = false;
		
		String studentPassword = null;
		
		for(Student student:students) {
			if(email.equals(student.getEmail())) {
				//email is present so we can continue
				value=true;
				studentPassword=student.getPassword();
				break;
			}
		}
		
		
		if(value) {
			//email matches so we need to check password
			
			if(password.equals(studentPassword)) {
				//login success
				PrintWriter printWriter = resp.getWriter();
				printWriter.print("login success");
			}else {
				//password not matched
				req.setAttribute("message", "invalid password");
				RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
				dispatcher.include(req, resp);
			}
		}
		
		else {
			//email is not matched
			req.setAttribute("message", "invalid email");
			RequestDispatcher dispatcher =req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
		}
		
		
		
		
		
		
	}
}
