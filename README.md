<h1> DICE GAME USING JAVA SERVLET </h1><br>
<h1 style="color:blue"> Description </h1><br>
<h4>Developed using Java servlets, the Dice Game is a web-based game that challenges players to test their luck and strategic skills. Players roll virtual dice and accumulate points based on their rolls. The game is designed with a user-friendly interface, allowing players to easily navigate and enjoy the game.</h4><br>
<h1 style="color:blue"> Dice Game Rules </h1><br>
Players will roll 3 dice, numbered 1 to 6, one at a time in any order. 
A player cannot roll the same die more than once during the game, or the game will end and the player will receive a score of -1. <br>
If the result obtained for die number 1 is strictly lower than the result obtained for die number 2 and the result obtained for die number 2 is strictly lower than the result obtained for die number 3, then the player receives a score equal to the sum of the results obtained for the 3 dices. <br>
If the result obtained for die number 1 is strictly higher than the result obtained for die number 2 and the result obtained for die number 2 is strictly higher than the result obtained for die number 3 then the player receives a score equal to the product results obtained for the 3 dices Otherwise it receives a zero score . <br>
The application must stop the game once we can conclude about the score, for example if we get 5 for die number 1 and 6 for die number 2 then there is no point in waiting for the result of die number 3, because the score will be equal to 0 regardless of the result of the 3rd die .
<h1 style="color:blue"> Interface </h1><br>
<h3> Inscription Form </h3> <br>
An inscription form is a web-based form that allows users to register for an account on a website or application. The form typically includes fields for the user's name, login, password, and confirm-password. <br>
<br><img width="814" alt="image" src="https://user-images.githubusercontent.com/108173949/230521991-94987553-0191-4fc0-9b29-db3d797d96e9.png"> 
<h3> Login Form </h3> <br>
A login form is a web-based form that allows users to access their account on a website or application. The form typically includes fields for the user's login and password.<br>
The login field requires the user to enter their username or email address that they used during registration to create their account. This field typically includes a validation process to ensure that the entered login credentials are valid.<br>
The password field requires the user to enter their secure password that they used during registration to create their account. The password field is typically masked to prevent others from seeing the entered text.<br>
Once the user has completed both fields, they can submit the login form to access their account. The form will then check whether the entered login and password exist or not. If the entered login credentials exist, the user will be redirected to their account dashboard. If the entered login credentials do not exist or are incorrect, the user will receive an error message and be prompted to try again. <br>
<br><img width="850" alt="image" src="https://user-images.githubusercontent.com/108173949/230522106-74b42d98-ffc2-451b-8254-37f834cd1fe3.png"> 
<h3> Game home </h3> <br>
The game home interface is a web-based interface that allows players to access a dice game. The interface typically includes options for Deconnexion, Reinitialization, Best Score, and an input for the number of dice to roll.<br>
The Deconnexion option allows the player to log out of their account and end their current game session. This option is typically located in the upper right corner of the interface and provides a convenient way to exit the game.<br>
The Reinitialization option allows the player to reset the game and start a new round. This option is typically located in the center of the interface and is labeled as "Reinitialization" .<br>
The Best Score option allows the player to view the best score of all players who have played the game. This option is typically located in the upper left corner of the interface and is labeled as "Best Score" .<br>
The input for the number of dice to roll allows the player to choose how many dice they want to roll during their turn. This input is typically located in the center of the interface and is labeled as "Number of Dice" . The player can enter any number between 1 and the maximum number of dice allowed in the game.<br>
Overall, the game home interface provides players with easy access to important game options and information. The Deconnexion and Reinitialization options allow players to control their game session, while the Best Score option provides motivation to achieve high scores. The input for the number of dice to roll allows players to customize their game experience and add an extra layer of strategy to the game.<br>
<br><img width="748" alt="image" src="https://user-images.githubusercontent.com/108173949/230522189-2afee2a6-6681-4a81-b18a-d153f748a752.png">  
<h3> Score </h3> <br>
The score interface is a web-based interface that displays the scores of players who have played a dice game. The interface typically includes a table that shows the name of each player and their corresponding score.<br>
The table is organized into columns, with one column for the player's name and one column for their score. Each row in the table represents one player and their score.<br>
<br><img width="917" alt="image" src="https://user-images.githubusercontent.com/108173949/230522574-6b916f10-fdec-464e-8c35-eb742561305a.png">
<h1>Tools used </h1><br>
- IDE: 
IntelliJ  

-Package: 
jakarta.servlet 

-Server: 
Tomcat 10.1





