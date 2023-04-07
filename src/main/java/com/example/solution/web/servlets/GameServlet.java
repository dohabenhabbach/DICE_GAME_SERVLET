package com.example.solution.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.example.solution.bo.GameState;
import com.example.solution.bo.Message;
import com.example.solution.bo.User;
import com.example.solution.web.helpers.GameContextManagement;

@WebServlet("/back/GameServlet")
public class GameServlet extends HttpServlet {


	protected void play(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// On récupère la session de l'utilisateur en cours
		HttpSession session = request.getSession();

		// On récupère de la session, les informations du joueur en cours
		User user = (User) session.getAttribute("user");
		// On réinitialise le score de l'utilisateur à zéro
		user.setScore(0);

		// Pour gérer les données de l'application dans le ServletContext
		GameContextManagement gameContext = GameContextManagement.getInstance(getServletContext());

		// Cette objet est déjà inséré dans la session au moment de login
		GameState gameState = (GameState) session.getAttribute("gameState");

		if (user.getCompteurLancer() == 3) {
			if (!gameState.isGameOver()) {
				// On ajoute un message d'information
				gameState.addMessage(new Message("Game Over", Message.INFO));

				// On vérifie s'il faut mettre à jour le meilleur score pour ce joueur
				if (user.getScore() > user.getBestScore()) {

					// Si oui, alors mise à jour des données dans la session
					user.setBestScore(user.getScore());

					// Mise à jour des données dans le contexte de l'application
					gameContext.updateScore(user);
				}

				// On indique que le jeu est terminé
				gameState.setGameOver(true);
				gameState.reinit();

			}

			// On redirige vers la vue par une redirection au niveau du serveur
			getServletContext().getRequestDispatcher("/WEB-INF/vues/back/userHome.jsp").forward(request, response);

			// On arrête l'exécution
			return;
		}

		// On récupère le numéro de dé choisi par le joueur
		String diceNumberParam = request.getParameter("diceNumber");
		if (diceNumberParam == null) {
			// Si aucun dé n'est choisi, on renvoie un message d'erreur
			gameState.addMessage(new Message("Vous devez choisir un dé.", Message.ERROR));
			getServletContext().getRequestDispatcher("/WEB-INF/vues/back/userHome.jsp").forward(request, response);
			return;
		}

		// On vérifie que le numéro de dé choisi est valide (entre 1 et 3)
		int diceNumber;
		try {
			diceNumber = Integer.parseInt(diceNumberParam);
			if (diceNumber < 1 || diceNumber > 3) {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {
			// Si le numéro de dé est invalide, on renvoie un message d'erreur
			gameState.addMessage(new Message("Le numéro de dé choisi est invalide.", Message.ERROR));
			getServletContext().getRequestDispatcher("/WEB-INF/vues/back/userHome.jsp").forward(request, response);
			return;
		}
		// On vérifie que le dé n'a pas déjà été lancé
		if (gameState.getDiceResults().containsKey(diceNumber)) {
			gameState.addMessage(new Message("Vous avez déjà lancé le dé n°" + diceNumber + ".", Message.ERROR));

			// On vérifie si tous les dés ont été lancés
			if (gameState.getDiceResults().size() == 3) {
				// Si tous les dés ont été lancés, on termine le jeu
				gameState.addMessage(new Message("Game Over", Message.INFO));
				user.setScore(-1);
				gameState.setGameOver(true);
			}

			getServletContext().getRequestDispatcher("/WEB-INF/vues/back/userHome.jsp").forward(request, response);
			return;
		}
		// On incrémente le compteur de lancées pour le joueur en cours
		user.setCompteurLancer(user.getCompteurLancer() + 1);
		int diceResult = 0;


		// On simule le lancement du dé choisi par le joueur
		Random random = new Random();
		diceResult = random.nextInt(6) + (int) 1;
		gameState.addMessage(new Message("Vous avez lancé le dé n°" + diceNumber + " et obtenu le chiffre " + diceResult + ".", Message.INFO));

		// On ajoute le résultat du dé dans l'état de la partie
		gameState.getDiceResults().put(diceNumber, diceResult);


// On incrémente le compteur de lancer de dés du joueur
		user.setCompteurLancer(user.getCompteurLancer() + 1);

// On vérifie si tous les dés ont été lancés
		if (gameState.getDiceResults().size() == 3) {
// Si tous les dés ont été lancés, on détermine le score
			List<Integer> diceValues = new ArrayList<>(gameState.getDiceResults().values());
			Collections.sort(diceValues);
			if (diceValues.get(0) < diceValues.get(1) && diceValues.get(1) < diceValues.get(2)) {
				// Les valeurs des dés sont triées dans l'ordre croissant
				user.setScore(diceValues.get(0) + diceValues.get(1) + diceValues.get(2));
			} else if (diceValues.get(0) > diceValues.get(1) && diceValues.get(1) > diceValues.get(2)) {
				// Les valeurs des dés sont triées dans l'ordre décroissant
				user.setScore(diceValues.get(0) * diceValues.get(1) * diceValues.get(2));
			} else {
				// Les valeurs des dés ne sont pas triées dans l'ordre croissant ou décroissant
				user.setScore(0);
				gameState.addMessage(new Message("Game Over", Message.INFO));
				gameState.setGameOver(true);
			}

// On vérifie s'il faut mettre à jour le meilleur score pour ce joueur
			if (user.getScore() > user.getBestScore()) {
				// Si oui, alors mise à jour des données dans la session
				user.setBestScore(user.getScore());

				// Mise à jour des données dans le contexte de l'application
				gameContext.updateScore(user);
			}
		}
		session.setAttribute("result", diceResult);
		// On redirige vers la vue par une redirection au niveau du serveur
		getServletContext().getRequestDispatcher("/WEB-INF/vues/back/userHome.jsp").forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		play(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		play(request, response);

	}

}
