<%@ page import="java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Connexion</title>
  <style>
    /* Global Styles */
    body {
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      background-color: #f0f4f8; /* Arri�re-plan gris clair pour un contraste agr�able */
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      margin: 0;
    }

    .login-container {
      background-color: #ffffff;
      padding: 30px;
      border-radius: 15px;
      box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
      width: 350px;
      text-align: center;
      transition: transform 0.3s ease;
    }

    .login-container:hover {
      transform: scale(1.05);
    }

    .logo {
      margin-bottom: 20px;
    }

    .logo img {
      width: 100px;
      height: auto;
    }

    h1 {
      color: #007BFF; /* Bleu clair utilis� pour le texte */
      font-size: 24px;
      margin-bottom: 10px;
    }

    p {
      color: #555;
      font-size: 14px;
    }

    .login-container input {
      width: 100%;
      padding: 12px;
      margin: 12px 0;
      border: 1px solid #ddd;
      border-radius: 8px;
      font-size: 16px;
      box-sizing: border-box;
    }

    .login-container input:focus {
      border-color: #007BFF; /* Bleu clair lors du focus */
      outline: none;
    }

    .login-container button {
      width: 100%;
      padding: 14px;
      background-color: #007BFF; /* Bleu clair pour le bouton */
      color: white;
      border: none;
      border-radius: 8px;
      cursor: pointer;
      font-size: 16px;
      transition: background-color 0.3s, transform 0.3s;
    }

    .login-container button:hover {
      background-color: #0056b3; /* Bleu plus fonc� au survol */
      transform: translateY(-3px);
    }

    .login-container button:active {
      background-color: #004085; /* Bleu encore plus fonc� lors du clic */
      transform: translateY(1px);
    }

    .login-container a {
      display: block;
      margin-top: 10px;
      text-decoration: none;
      color: #007BFF;
      font-size: 14px;
    }

    .login-container a:hover {
      text-decoration: underline;
    }

    .back-button {
      background-color: #f1f5f9; /* Gris clair pour le bouton de retour */
      color: #007BFF;
      border-radius: 8px;
      padding: 12px 20px;
      cursor: pointer;
      margin-top: 20px;
      border: none;
      transition: background-color 0.3s;
    }

    .back-button:hover {
      background-color: #e2e8f0; /* Gris plus fonc� au survol */
    }

  </style>
</head>
<body>

  <div class="login-container">
    <div class="logo">
      <img src="https://upload.wikimedia.org/wikipedia/commons/2/2f/Google_2015_logo.svg" alt="Logo">
    </div>
    <h1>Connexion</h1>
    <p>Connectez-vous pour acc�der � votre compte</p>
    <form method="post" action="">
      <input type="text" name="user" placeholder="Nom d'utilisateur" required>
      <input type="password" name="pass" placeholder="Mot de passe" required>
      <button type="submit" name="submit">Se connecter</button>
    </form>
    <a href="#">Mot de passe oubli� ?</a>

    <!-- Bouton Retour vers la page pr�c�dente -->
    <button class="back-button" onclick="window.history.back()">Retour</button>
  </div>

  <%-- Logique JSP pour g�rer la connexion avec la base de donn�es --%>
  <%
    if (request.getParameter("submit") != null) {
      String username = request.getParameter("user");
      String password = request.getParameter("pass");

      Connection conn = null;
      PreparedStatement ps = null;
      ResultSet rs = null;

      try {
        // Charger le driver MySQL
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Connexion � la base de donn�es
        String dbUrl = "jdbc:mysql://localhost:3306/hotel_management"; // Utilisez le nom correct de votre base de donn�es
        String dbUsername = "root"; // Votre nom d'utilisateur MySQL
        String dbPassword = "triki"; // Votre mot de passe MySQL

        conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

        // Pr�parer la requ�te pour v�rifier les identifiants
        String sql = "SELECT * FROM Account WHERE username = ? AND password = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, username); // Utilisez le nom d'utilisateur pour la v�rification
        ps.setString(2, password);

        rs = ps.executeQuery();

        if (rs.next()) {
          // Si l'utilisateur existe, r�cup�rer son r�le et rediriger
          String role = rs.getString("role");
          session.setAttribute("user", username);
          if ("agent".equals(role)) {
            response.sendRedirect("home.jsp");
          } else if ("admin".equals(role)) {
            response.sendRedirect("agent.jsp");
          } else {
            response.sendRedirect("home.jsp");
          }
        } else {
          // Si les identifiants sont incorrects
  %>
          <script>
            alert("Nom d'utilisateur ou mot de passe incorrect");
          </script>
  <%
        }

      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      } catch (SQLException e) {
        e.printStackTrace();
      } finally {
        // Fermer la connexion � la base de donn�es
        try {
          if (rs != null) rs.close();
          if (ps != null) ps.close();
          if (conn != null) conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
  %>

</body>
</html>


