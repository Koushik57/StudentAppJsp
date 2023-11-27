package studentWithJsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentWithJsp.dao.StudentDao;
import studentWithJsp.dto.Student;
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id =Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String address=req.getParameter("address");
		long phone=Long.parseLong(req.getParameter("phone"));
		String course=req.getParameter("course");
		
		Double dfees = Double.parseDouble(getServletContext().getInitParameter("developmentfees"));
		Double tfees = Double.parseDouble(getServletContext().getInitParameter("testingfees"));
		
		Student student = new Student();
		student.setId(id);
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
		
		StudentDao dao = new StudentDao();
		dao.UpdateStudent(student);
		
		req.setAttribute("list", dao.getAllStudents());
		RequestDispatcher dispatcher = req.getRequestDispatcher("display.jsp");
		dispatcher.forward(req, resp);
	}
}
