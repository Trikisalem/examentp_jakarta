/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.97
 * Generated at: 2024-12-18 02:38:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;
import javax.servlet.http.HttpSession;

public final class agent_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_packages = new java.util.LinkedHashSet<>(7);
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(2);
    _jspx_imports_classes.add("javax.servlet.http.HttpSession");
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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"fr\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>Gestion des agents</title>\r\n");
      out.write("    <style>\r\n");
      out.write("        /* Global Styles */\r\n");
      out.write("        body {\r\n");
      out.write("            font-family: 'Roboto', Arial, sans-serif;\r\n");
      out.write("            background-color: #f5f5f5;\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            padding: 0;\r\n");
      out.write("            color: #333;\r\n");
      out.write("            box-sizing: border-box;\r\n");
      out.write("        }\r\n");
      out.write("        h1 {\r\n");
      out.write("            color: #0066cc; /* Couleur personnalisée pour le titre */\r\n");
      out.write("            font-size: 2.5rem;\r\n");
      out.write("            margin-top: 30px;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            font-weight: 600;\r\n");
      out.write("        }\r\n");
      out.write("        .container {\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            max-width: 1100px;\r\n");
      out.write("            margin: 30px auto;\r\n");
      out.write("            padding: 20px;\r\n");
      out.write("            background-color: #fff;\r\n");
      out.write("            border-radius: 12px;\r\n");
      out.write("            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);\r\n");
      out.write("            overflow: hidden;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        /* Form Styles */\r\n");
      out.write("        .form-container {\r\n");
      out.write("            margin-bottom: 40px;\r\n");
      out.write("        }\r\n");
      out.write("        .form-container h2 {\r\n");
      out.write("            font-size: 1.5rem;\r\n");
      out.write("            color: #4285f4;\r\n");
      out.write("            margin-bottom: 20px;\r\n");
      out.write("        }\r\n");
      out.write("        .form-container input[type=\"text\"],\r\n");
      out.write("        .form-container input[type=\"password\"],\r\n");
      out.write("        .form-container input[type=\"email\"] {\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            padding: 12px;\r\n");
      out.write("            margin-bottom: 16px;\r\n");
      out.write("            border: 1px solid #ddd;\r\n");
      out.write("            border-radius: 6px;\r\n");
      out.write("            font-size: 1rem;\r\n");
      out.write("            background-color: #f9f9f9;\r\n");
      out.write("            box-sizing: border-box;\r\n");
      out.write("            transition: border 0.3s ease;\r\n");
      out.write("        }\r\n");
      out.write("        .form-container input[type=\"text\"]:focus,\r\n");
      out.write("        .form-container input[type=\"password\"]:focus,\r\n");
      out.write("        .form-container input[type=\"email\"]:focus {\r\n");
      out.write("            border-color: #4285f4;\r\n");
      out.write("            box-shadow: 0 0 10px rgba(66, 133, 244, 0.2);\r\n");
      out.write("        }\r\n");
      out.write("        .form-container button {\r\n");
      out.write("            padding: 12px 20px;\r\n");
      out.write("            background-color: #4285f4;\r\n");
      out.write("            color: #fff;\r\n");
      out.write("            font-size: 1rem;\r\n");
      out.write("            border: none;\r\n");
      out.write("            border-radius: 6px;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("            transition: background-color 0.3s ease;\r\n");
      out.write("            width: 100%;\r\n");
      out.write("        }\r\n");
      out.write("        .form-container button:hover {\r\n");
      out.write("            background-color: #357ae8;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        /* Table Styles */\r\n");
      out.write("        table {\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            margin-top: 20px;\r\n");
      out.write("            border-collapse: collapse;\r\n");
      out.write("        }\r\n");
      out.write("        th {\r\n");
      out.write("            background-color: #4285f4;\r\n");
      out.write("            color: #fff;\r\n");
      out.write("            font-size: 1.1rem;\r\n");
      out.write("            padding: 15px;\r\n");
      out.write("        }\r\n");
      out.write("        td {\r\n");
      out.write("            font-size: 1rem;\r\n");
      out.write("            padding: 12px;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            border: 1px solid #ddd;\r\n");
      out.write("        }\r\n");
      out.write("        td.actions a {\r\n");
      out.write("            padding: 8px 16px;\r\n");
      out.write("            margin: 5px;\r\n");
      out.write("            border-radius: 6px;\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("            display: inline-block;\r\n");
      out.write("            font-size: 0.9rem;\r\n");
      out.write("            color: #fff;\r\n");
      out.write("            background-color: #4285f4;\r\n");
      out.write("            transition: transform 0.3s ease, background-color 0.3s ease;\r\n");
      out.write("        }\r\n");
      out.write("        td.actions a:hover {\r\n");
      out.write("            background-color: #357ae8;\r\n");
      out.write("            transform: translateY(-2px);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        /* Button Styles */\r\n");
      out.write("        .back-button {\r\n");
      out.write("            background-color: #4285f4;\r\n");
      out.write("            color: white;\r\n");
      out.write("            padding: 12px 20px;\r\n");
      out.write("            border-radius: 6px;\r\n");
      out.write("            font-size: 1rem;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("            border: none;\r\n");
      out.write("            margin-top: 30px;\r\n");
      out.write("            transition: background-color 0.3s ease;\r\n");
      out.write("            width: 100%;\r\n");
      out.write("        }\r\n");
      out.write("        .back-button:hover {\r\n");
      out.write("            background-color: #357ae8;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        /* Responsive Design */\r\n");
      out.write("        @media (max-width: 768px) {\r\n");
      out.write("            .container {\r\n");
      out.write("                padding: 15px;\r\n");
      out.write("            }\r\n");
      out.write("            .form-container input[type=\"text\"],\r\n");
      out.write("            .form-container input[type=\"password\"],\r\n");
      out.write("            .form-container input[type=\"email\"],\r\n");
      out.write("            .form-container button {\r\n");
      out.write("                width: 100%;\r\n");
      out.write("            }\r\n");
      out.write("            table {\r\n");
      out.write("                font-size: 0.9rem;\r\n");
      out.write("            }\r\n");
      out.write("            td.actions a {\r\n");
      out.write("                font-size: 0.8rem;\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <h1>Gestion des agents</h1>\r\n");
      out.write("\r\n");
      out.write("        ");
 
            if (session == null || session.getAttribute("user") == null) {
                // Si la session n'existe pas ou l'attribut "user" est absent, rediriger vers login.jsp
                response.sendRedirect("index.jsp");
                return;
            }
        
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"form-container\">\r\n");
      out.write("            \r\n");
      out.write("            <form method=\"post\" action=\"agent.jsp\">\r\n");
      out.write("                <input type=\"hidden\" name=\"agentId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.agentId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                <input type=\"text\" name=\"username\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.username}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"Nom d'utilisateur\" required><br>\r\n");
      out.write("                <input type=\"password\" name=\"password\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.password}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"Mot de passe\" required><br>\r\n");
      out.write("                <input type=\"email\" name=\"email\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.email}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"Email\" required><br>\r\n");
      out.write("                <button type=\"submit\" name=\"action\" value=\"save\">Sauvegarder</button>\r\n");
      out.write("            </form>\r\n");
      out.write("          <button class=\"back-button\" onclick=\"window.location.href='index.jsp';\">logout</button>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <h2>Liste des agents</h2>\r\n");
      out.write("        <table>\r\n");
      out.write("            <thead>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <th>ID</th>\r\n");
      out.write("                    <th>Nom d'utilisateur</th>\r\n");
      out.write("                    <th>Email</th>\r\n");
      out.write("                    <th>Actions</th>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </thead>\r\n");
      out.write("            <tbody>\r\n");
      out.write("            ");

                // Connexion à la base de données
                String url = "jdbc:mysql://localhost:3306/hotel_management";
                String user = "root"; // Changez selon votre configuration
                String pass = "triki"; // Changez selon votre configuration
                Connection conn = null;
                PreparedStatement ps = null;
                ResultSet rs = null;

                try {
                    // Chargement du driver MySQL
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn = DriverManager.getConnection(url, user, pass);

                    String action = request.getParameter("action");
                    String id = request.getParameter("agentId");
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
                    String email = request.getParameter("email");

                    if ("save".equals(action)) {
                        if (id != null && !id.isEmpty()) {
                            // Mise à jour
                            ps = conn.prepareStatement("UPDATE Account SET username = ?, password = ?, email = ? WHERE id = ?");
                            ps.setString(1, username);
                            ps.setString(2, password);
                            ps.setString(3, email);
                            ps.setInt(4, Integer.parseInt(id));
                        } else {
                            // Ajout
                            ps = conn.prepareStatement("INSERT INTO Account (username, password, email, role) VALUES (?, ?, ?, 'agent')");
                            ps.setString(1, username);
                            ps.setString(2, password);
                            ps.setString(3, email);
                        }
                        ps.executeUpdate();
                        response.sendRedirect("agent.jsp");
                    } else if ("delete".equals(action)) {
                        // Suppression
                        ps = conn.prepareStatement("DELETE FROM Account WHERE id = ?");
                        ps.setInt(1, Integer.parseInt(request.getParameter("id")));
                        ps.executeUpdate();
                        response.sendRedirect("agent.jsp");
                    }

                    // Liste des agents
                    ps = conn.prepareStatement("SELECT id, username, email FROM Account WHERE role = 'agent'");
                    rs = ps.executeQuery();
                    while (rs.next()) {
            
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>");
      out.print( rs.getInt("id") );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( rs.getString("username") );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( rs.getString("email") );
      out.write("</td>\r\n");
      out.write("                <td class=\"actions\">\r\n");
      out.write("                    <a href=\"agent.jsp?action=edit&agentId=");
      out.print( rs.getInt("id") );
      out.write("&username=");
      out.print( rs.getString("username") );
      out.write("&email=");
      out.print( rs.getString("email") );
      out.write("\" class=\"edit\">Modifier</a>\r\n");
      out.write("                    <a href=\"agent.jsp?action=delete&id=");
      out.print( rs.getInt("id") );
      out.write("\" class=\"delete\" onclick=\"return confirm('Êtes-vous sûr de vouloir supprimer cet agent ?')\">Supprimer</a>\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            ");

                    }
                } catch (Exception e) {
                    out.println("<p style='color:red;'>Erreur : " + e.getMessage() + "</p>");
                    e.printStackTrace();
                } finally {
                    try { if (rs != null) rs.close(); } catch (Exception ignored) {}
                    try { if (ps != null) ps.close(); } catch (Exception ignored) {}
                    try { if (conn != null) conn.close(); } catch (Exception ignored) {}
                }
            
      out.write("\r\n");
      out.write("            </tbody>\r\n");
      out.write("        </table>\r\n");
      out.write("    </div>\r\n");
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
