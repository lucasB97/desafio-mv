package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CollaboratorDAO;
import model.CollaboratorModel;

@WebServlet(urlPatterns = { "/CollaboratorController", "/main", "/insert", "/select", "/update","/delete" })
public class CollaboratorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CollaboratorDAO dao = new CollaboratorDAO();
	CollaboratorModel collaborator = new CollaboratorModel();

	public CollaboratorController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/main")) {
			list(request, response);
		} else if (action.equals("/insert")) {
			newCollaborator(request, response);
		} else if (action.equals("/select")) {
			listCollaborator(request, response);
		} else if (action.equals("/update")) {
			editCollaborator(request, response);
		} else if (action.equals("/delete")) {
			removeCollaborator(request, response);
		}else {
			response.sendRedirect("index.html");
		}
	}

	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<CollaboratorModel> list = dao.listCollaborator();
		request.setAttribute("collaborators", list);
		RequestDispatcher rd = request.getRequestDispatcher("breakFastList.jsp");
		rd.forward(request, response);
	}

	protected void newCollaborator(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		collaborator.setcontributorName(request.getParameter("contributorName"));
		collaborator.setCpf(request.getParameter("cpf"));
		collaborator.setbreakfastFood(request.getParameter("breakfastFood"));
		dao.insertCollaborator(collaborator);
		response.sendRedirect("main");
	}

	protected void listCollaborator(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		collaborator.setId(id);
		dao.selectCollaborator(collaborator);
		request.setAttribute("id", collaborator.getId());
		request.setAttribute("contributorName", collaborator.getcontributorName());
		request.setAttribute("cpf", collaborator.getCpf());
		request.setAttribute("breakfastFood", collaborator.getbreakfastFood());
		RequestDispatcher rd = request.getRequestDispatcher("editCollaborator.jsp");
		rd.forward(request, response);
	}

	protected void editCollaborator(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		collaborator.setId(request.getParameter("id"));
		collaborator.setCpf(request.getParameter("cpf"));
		collaborator.setcontributorName(request.getParameter("contributorName"));
		collaborator.setbreakfastFood(request.getParameter("breakfastFood"));
		dao.updateCollaborator(collaborator);
		response.sendRedirect("main");
	}
	
	protected void removeCollaborator(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		collaborator.setId(request.getParameter("id"));
		dao.deleteCollaborator(collaborator);
		response.sendRedirect("main");
	}
	
}
