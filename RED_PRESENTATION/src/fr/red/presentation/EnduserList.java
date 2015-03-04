package fr.red.presentation;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.red.service.EnduserServiceLocal;
import fr.red.entity.Enduser;

@WebServlet("/EnduserList")
public class EnduserList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	EnduserServiceLocal enduserService;

	public EnduserList() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		List<Enduser> findAll = enduserService.findAll();
		request.setAttribute("endusers", findAll);
		request.getRequestDispatcher("/WEB-INF/enduserList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
