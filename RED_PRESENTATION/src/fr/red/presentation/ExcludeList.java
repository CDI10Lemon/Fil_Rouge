package fr.red.presentation;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.red.service.ExcludeServiceLocal;
import fr.red.entity.Exclude;

@WebServlet("/ExcludeList")
public class ExcludeList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	ExcludeServiceLocal excludeService;

	public ExcludeList() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		List<Exclude> findAll = excludeService.findAll();
		request.setAttribute("excludes", findAll);
		request.getRequestDispatcher("/WEB-INF/excludeList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
