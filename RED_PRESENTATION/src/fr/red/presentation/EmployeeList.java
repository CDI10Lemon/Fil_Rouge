package fr.red.presentation;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.red.service.EmployeeServiceLocal;
import fr.red.entity.Employee;
import fr.red.entity.User;

/**
 * Servlet implementation class AllPersonne
 */
@WebServlet("/EmployeeList")
public class EmployeeList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	EmployeeServiceLocal employeeService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		List<Employee> findAll = employeeService.findAll();
		request.setAttribute("employees", findAll);
		request.getRequestDispatcher("/WEB-INF/employeeList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}