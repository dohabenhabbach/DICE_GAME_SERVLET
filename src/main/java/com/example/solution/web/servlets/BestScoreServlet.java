package com.example.solution.web.servlets;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.solution.bo.User;
import com.example.solution.web.helpers.GameContextManagement;


@WebServlet("/back/bestScore")
public class BestScoreServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		GameContextManagement contextGame = GameContextManagement.getInstance(getServletContext());

		// On récupére tous les utilisateurs
		List<User> users = contextGame.getAllUsers();

		// On stocke dans la requete (comme attribut) les utilisateurs. Cette
		// liste a une durée de vie = à la durée de vie de la requete. Donc elle
		// n'existera plus à la fin du cycle de vie de la requete
		request.setAttribute("users", users);

		// On redirige vers la vue (redirection coté serveur)
		//pour sécuriser les vues des accès directes nous avons choisi de les mettres dans /WEB-INF
		getServletContext().getRequestDispatcher("/WEB-INF/vues/back/bestScore.jsp").forward(request, response);

	}

}
