/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.97
 * Generated at: 2024-12-17 23:34:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/C:/Users/user/Desktop/backend/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/hotel/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153377882000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1734448720554L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(6);
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "Les JSPs ne permettent que GET, POST ou HEAD. Jasper permet aussi OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"fr\">\r\n");
      out.write("<head>\r\n");
      out.write("  <meta charset=\"UTF-8\">\r\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("  <title>Connexion</title>\r\n");
      out.write("  <style>\r\n");
      out.write("    /* Global Styles */\r\n");
      out.write("    body {\r\n");
      out.write("      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\r\n");
      out.write("      background-color: #f0f4f8; /* Arrière-plan gris clair pour un contraste agréable */\r\n");
      out.write("      display: flex;\r\n");
      out.write("      justify-content: center;\r\n");
      out.write("      align-items: center;\r\n");
      out.write("      height: 100vh;\r\n");
      out.write("      margin: 0;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .login-container {\r\n");
      out.write("      background-color: #ffffff;\r\n");
      out.write("      padding: 30px;\r\n");
      out.write("      border-radius: 15px;\r\n");
      out.write("      box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);\r\n");
      out.write("      width: 350px;\r\n");
      out.write("      text-align: center;\r\n");
      out.write("      transition: transform 0.3s ease;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .login-container:hover {\r\n");
      out.write("      transform: scale(1.05);\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .logo {\r\n");
      out.write("      margin-bottom: 20px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .logo img {\r\n");
      out.write("      width: 100px;\r\n");
      out.write("      height: auto;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    h1 {\r\n");
      out.write("      color: #007BFF; /* Bleu clair utilisé pour le texte */\r\n");
      out.write("      font-size: 24px;\r\n");
      out.write("      margin-bottom: 10px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    p {\r\n");
      out.write("      color: #555;\r\n");
      out.write("      font-size: 14px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .login-container input {\r\n");
      out.write("      width: 100%;\r\n");
      out.write("      padding: 12px;\r\n");
      out.write("      margin: 12px 0;\r\n");
      out.write("      border: 1px solid #ddd;\r\n");
      out.write("      border-radius: 8px;\r\n");
      out.write("      font-size: 16px;\r\n");
      out.write("      box-sizing: border-box;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .login-container input:focus {\r\n");
      out.write("      border-color: #007BFF; /* Bleu clair lors du focus */\r\n");
      out.write("      outline: none;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .login-container button {\r\n");
      out.write("      width: 100%;\r\n");
      out.write("      padding: 14px;\r\n");
      out.write("      background-color: #007BFF; /* Bleu clair pour le bouton */\r\n");
      out.write("      color: white;\r\n");
      out.write("      border: none;\r\n");
      out.write("      border-radius: 8px;\r\n");
      out.write("      cursor: pointer;\r\n");
      out.write("      font-size: 16px;\r\n");
      out.write("      transition: background-color 0.3s, transform 0.3s;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .login-container button:hover {\r\n");
      out.write("      background-color: #0056b3; /* Bleu plus foncé au survol */\r\n");
      out.write("      transform: translateY(-3px);\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .login-container button:active {\r\n");
      out.write("      background-color: #004085; /* Bleu encore plus foncé lors du clic */\r\n");
      out.write("      transform: translateY(1px);\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .login-container a {\r\n");
      out.write("      display: block;\r\n");
      out.write("      margin-top: 10px;\r\n");
      out.write("      text-decoration: none;\r\n");
      out.write("      color: #007BFF;\r\n");
      out.write("      font-size: 14px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .login-container a:hover {\r\n");
      out.write("      text-decoration: underline;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .back-button {\r\n");
      out.write("      background-color: #f1f5f9; /* Gris clair pour le bouton de retour */\r\n");
      out.write("      color: #007BFF;\r\n");
      out.write("      border-radius: 8px;\r\n");
      out.write("      padding: 12px 20px;\r\n");
      out.write("      cursor: pointer;\r\n");
      out.write("      margin-top: 20px;\r\n");
      out.write("      border: none;\r\n");
      out.write("      transition: background-color 0.3s;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .back-button:hover {\r\n");
      out.write("      background-color: #e2e8f0; /* Gris plus foncé au survol */\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("  </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("  <div class=\"login-container\">\r\n");
      out.write("    <div class=\"logo\">\r\n");
      out.write("      <img src=\"https://upload.wikimedia.org/wikipedia/commons/2/2f/Google_2015_logo.svg\" alt=\"Logo\">\r\n");
      out.write("    </div>\r\n");
      out.write("    <h1>Connexion</h1>\r\n");
      out.write("    <p>Connectez-vous pour accéder à votre compte</p>\r\n");
      out.write("    <form method=\"post\" action=\"\">\r\n");
      out.write("      <input type=\"text\" name=\"user\" placeholder=\"Nom d'utilisateur\" required>\r\n");
      out.write("      <input type=\"password\" name=\"pass\" placeholder=\"Mot de passe\" required>\r\n");
      out.write("      <button type=\"submit\" name=\"submit\">Se connecter</button>\r\n");
      out.write("    </form>\r\n");
      out.write("    <a href=\"#\">Mot de passe oublié ?</a>\r\n");
      out.write("\r\n");
      out.write("    <!-- Bouton Retour vers la page précédente -->\r\n");
      out.write("    <button class=\"back-button\" onclick=\"window.history.back()\">Retour</button>\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write("  ");
      out.write("\r\n");
      out.write("  ");

    if (request.getParameter("submit") != null) {
      String username = request.getParameter("user");
      String password = request.getParameter("pass");

      Connection conn = null;
      PreparedStatement ps = null;
      ResultSet rs = null;

      try {
        // Charger le driver MySQL
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Connexion à la base de données
        String dbUrl = "jdbc:mysql://localhost:3306/hotel_management"; // Utilisez le nom correct de votre base de données
        String dbUsername = "root"; // Votre nom d'utilisateur MySQL
        String dbPassword = "triki"; // Votre mot de passe MySQL

        conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

        // Préparer la requête pour vérifier les identifiants
        String sql = "SELECT * FROM Account WHERE username = ? AND password = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, username); // Utilisez le nom d'utilisateur pour la vérification
        ps.setString(2, password);

        rs = ps.executeQuery();

        if (rs.next()) {
          // Si l'utilisateur existe, récupérer son rôle et rediriger
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
  
      out.write("\r\n");
      out.write("          <script>\r\n");
      out.write("            alert(\"Nom d'utilisateur ou mot de passe incorrect\");\r\n");
      out.write("          </script>\r\n");
      out.write("  ");

        }

      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      } catch (SQLException e) {
        e.printStackTrace();
      } finally {
        // Fermer la connexion à la base de données
        try {
          if (rs != null) rs.close();
          if (ps != null) ps.close();
          if (conn != null) conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
  
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
