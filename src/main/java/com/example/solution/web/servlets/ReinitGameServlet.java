package com.example.solution.web.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.example.solution.bo.GameState;

@WebServlet("/back/ReinitGameServlet")
public class ReinitGameServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		GameState gs = (GameState) session.getAttribute("gameState");

		if (gs != null) {

			gs.reinit();
		}

		// reinit result avec une valeur impossible pour le dé
		session.setAttribute("result", -2);

		getServletContext().getRequestDispatcher("/WEB-INF/vues/back/userHome.jsp").forward(request, response);

		return;

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
