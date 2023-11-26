package studentWithJsp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentWithJsp.dao.StudentDao;
import studentWithJsp.dto.Student;

public class SignupServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String address=req.getParameter("address");
		long phone=Long.parseLong(req.getParameter("phone"));
		String course=req.getParameter("course");
		
		Double dfees = Double.parseDouble(getServletContext().getInitParameter("developmentfees"));
		Double tfees = Double.parseDouble(getServletContext().getInitParameter("testingfees"));
		
		Student student = new Student();
		student.setName(name);
		student.setEmail(email);
		student.setPassword(password);
		student.setAddress(address);
		student.setPhone(phone);
		student.setCourse(course);
		
		if(course.equals("Development")) {
			student.setFees(dfees);
		}else {
			student.setFees(tfees);
		}
		
		
		StudentDao studentDao = new StudentDao();
		List<Student> list =studentDao.getAllStudents();
		boolean value =true;
		for(Student st:list) {
			if(email.equals(st.getEmail())) {
				value=false;
				break;
			}
		}
		
		if(value) {
			//email is available,email is not present in db
			studentDao.signUpStudent(student);
			req.setAttribute("message", "signedup successfully please login");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);
		}else {
			req.setAttribute("message", "soory email already exist in db");
			RequestDispatcher dispatcher = req.getRequestDispatcher("Signup.jsp");
			dispatcher.include(req, resp);
		}
		
	}
}
