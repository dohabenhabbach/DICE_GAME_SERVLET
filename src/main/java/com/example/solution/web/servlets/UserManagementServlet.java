package com.example.solution.web.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.example.solution.bo.Message;
import com.example.solution.bo.User;
import com.example.solution.web.helpers.GameContextManagement;

@WebServlet("/UserManagementServlet")
public class UserManagementServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String createUserFormPage = "/WEB-INF/vues/pages/formInscription.jsp";

		ServletContext cntx = getServletContext();

		// On affiche le formulaire d'ajout
		if (request.getParameter("create") != null) {
			cntx.getRequestDispatcher(createUserFormPage).forward(request, response);
			// fin
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String errorPage = "/WEB-INF/vues/pages/error.jsp";
		String loginForm = "/WEB-INF/vues/pages/loginForm.jsp";
		ServletContext cntx = getServletContext();

		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		User user = new User(nom, prenom, login, password, 0, 0);

		GameContextManagement gameContext = GameContextManagement.getInstance(getServletContext());

		List<Message> messages = new ArrayList<Message>();

		// On teste si un utilisateur existe avec le login choisi

		if (gameContext.getUserByLogin(login) != null) {

			// Ajouter des message d'erreur dans la requete
			messages.add(new Message("Login existe déjà", Message.WARN));
			request.setAttribute("messages", messages);

			cntx.getRequestDispatcher(errorPage).forward(request, response);
			return;

		}

		// On ajoute l'utilisateur
		gameContext.insertUser(user);

		// On redirige vers la page login avec un message de succès
		messages.add(new Message("Utilisateur correctement ajouté", Message.INFO));
		
		// On enregistre la liste des messages comme attributs de requete
		request.setAttribute("messages", messages);

		// On redirige vers la vue
		cntx.getRequestDispatcher(loginForm).forward(request, response);

	}

}