/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.97
 * Generated at: 2024-12-17 15:46:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      			"error.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\" />\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n");
      out.write("    <title>Administrator</title>\r\n");
      out.write("    \r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("    \r\n");
      out.write("    <style>\r\n");
      out.write("        :root {\r\n");
      out.write("            /* Color Palette */\r\n");
      out.write("            --primary-color: #3498db;\r\n");
      out.write("            --secondary-color: #2c3e50;\r\n");
      out.write("            --accent-color: #1abc9c;\r\n");
      out.write("            --background-light: #f9f9f9;\r\n");
      out.write("            --text-color: #333;\r\n");
      out.write("            --white: #ffffff;\r\n");
      out.write("            \r\n");
      out.write("            /* Typography */\r\n");
      out.write("            --font-main: 'Inter', 'Arial', sans-serif;\r\n");
      out.write("            --font-size-base: 16px;\r\n");
      out.write("            --font-size-large: 1.25rem;\r\n");
      out.write("            --font-size-small: 0.875rem;\r\n");
      out.write("            \r\n");
      out.write("            /* Spacing */\r\n");
      out.write("            --spacing-xs: 0.5rem;\r\n");
      out.write("            --spacing-sm: 1rem;\r\n");
      out.write("            --spacing-md: 1.5rem;\r\n");
      out.write("            --spacing-lg: 2rem;\r\n");
      out.write("            \r\n");
      out.write("            /* Shadows & Transitions */\r\n");
      out.write("            --box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);\r\n");
      out.write("            --transition-speed: 0.3s;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        /* Reset & Base Styles */\r\n");
      out.write("        * {\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            padding: 0;\r\n");
      out.write("            box-sizing: border-box;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        body {\r\n");
      out.write("            font-family: var(--font-main);\r\n");
      out.write("            background-color: var(--background-light);\r\n");
      out.write("            color: var(--text-color);\r\n");
      out.write("            line-height: 1.6;\r\n");
      out.write("            font-size: var(--font-size-base);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        /* Typography */\r\n");
      out.write("        h1.page-header {\r\n");
      out.write("            color: var(--secondary-color);\r\n");
      out.write("            font-size: 2.5rem;\r\n");
      out.write("            margin-bottom: var(--spacing-md);\r\n");
      out.write("            font-weight: 600;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        /* Layout */\r\n");
      out.write("        #wrapper {\r\n");
      out.write("            display: flex;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        /* Navigation */\r\n");
      out.write("        .navbar-default {\r\n");
      out.write("            background-color: var(--secondary-color);\r\n");
      out.write("            padding: var(--spacing-sm) var(--spacing-md);\r\n");
      out.write("            box-shadow: var(--box-shadow);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .navbar-brand {\r\n");
      out.write("            color: var(--white);\r\n");
      out.write("            font-weight: bold;\r\n");
      out.write("            font-size: var(--font-size-large);\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .navbar-nav {\r\n");
      out.write("            display: flex;\r\n");
      out.write("            list-style: none;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .navbar-nav li a {\r\n");
      out.write("            color: var(--white);\r\n");
      out.write("            padding: var(--spacing-sm);\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("            transition: background-color var(--transition-speed);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .navbar-nav li a:hover {\r\n");
      out.write("            background-color: var(--accent-color);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        /* Side Navbar */\r\n");
      out.write("        .navbar-side {\r\n");
      out.write("            background-color: var(--secondary-color);\r\n");
      out.write("            width: 240px;\r\n");
      out.write("            height: 100vh;\r\n");
      out.write("            position: fixed;\r\n");
      out.write("            left: 0;\r\n");
      out.write("            top: 0;\r\n");
      out.write("            padding-top: var(--spacing-lg);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .navbar-side ul {\r\n");
      out.write("            list-style-type: none;\r\n");
      out.write("            padding: 0;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .navbar-side ul li a {\r\n");
      out.write("            display: block;\r\n");
      out.write("            padding: var(--spacing-sm);\r\n");
      out.write("            color: var(--white);\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("            transition: background-color var(--transition-speed);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .navbar-side ul li a:hover,\r\n");
      out.write("        .navbar-side ul li.active-menu a {\r\n");
      out.write("            background-color: var(--accent-color);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        /* Page Wrapper */\r\n");
      out.write("        #page-wrapper {\r\n");
      out.write("            margin-left: 240px;\r\n");
      out.write("            flex-grow: 1;\r\n");
      out.write("            padding: var(--spacing-md);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        /* Panels */\r\n");
      out.write("        .panel {\r\n");
      out.write("            background-color: var(--white);\r\n");
      out.write("            border-radius: 8px;\r\n");
      out.write("            box-shadow: var(--box-shadow);\r\n");
      out.write("            margin-bottom: var(--spacing-md);\r\n");
      out.write("            overflow: hidden;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .panel-heading {\r\n");
      out.write("            background-color: var(--primary-color);\r\n");
      out.write("            color: var(--white);\r\n");
      out.write("            padding: var(--spacing-sm);\r\n");
      out.write("            font-weight: bold;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .panel-body {\r\n");
      out.write("            padding: var(--spacing-md);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        /* Buttons */\r\n");
      out.write("        .btn {\r\n");
      out.write("            display: inline-flex;\r\n");
      out.write("            align-items: center;\r\n");
      out.write("            padding: var(--spacing-sm) var(--spacing-md);\r\n");
      out.write("            border-radius: 6px;\r\n");
      out.write("            border: none;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("            transition: \r\n");
      out.write("                background-color var(--transition-speed),\r\n");
      out.write("                transform var(--transition-speed);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .btn-primary {\r\n");
      out.write("            background-color: var(--primary-color);\r\n");
      out.write("            color: var(--white);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .btn-primary:hover {\r\n");
      out.write("            background-color: color-mix(in srgb, var(--primary-color) 90%, white);\r\n");
      out.write("            transform: translateY(-2px);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        /* Badge */\r\n");
      out.write("        .badge {\r\n");
      out.write("            background-color: var(--accent-color);\r\n");
      out.write("            color: var(--white);\r\n");
      out.write("            border-radius: 12px;\r\n");
      out.write("            padding: 2px 8px;\r\n");
      out.write("            font-size: var(--font-size-small);\r\n");
      out.write("            margin-left: var(--spacing-xs);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        /* Responsive Design */\r\n");
      out.write("        @media screen and (max-width: 768px) {\r\n");
      out.write("            .navbar-side {\r\n");
      out.write("                width: 100%;\r\n");
      out.write("                height: auto;\r\n");
      out.write("                position: relative;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            #page-wrapper {\r\n");
      out.write("                margin-left: 0;\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        /* Dark Mode Support */\r\n");
      out.write("        @media (prefers-color-scheme: dark) {\r\n");
      out.write("            :root {\r\n");
      out.write("                --background-light: #121212;\r\n");
      out.write("                --text-color: #e0e0e0;\r\n");
      out.write("                --white: #1e1e1e;\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            body {\r\n");
      out.write("                background-color: var(--background-light);\r\n");
      out.write("                color: var(--text-color);\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            .panel {\r\n");
      out.write("                background-color: #1e1e1e;\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    <div id=\"wrapper\">\r\n");
      out.write("        \r\n");
      out.write("\r\n");
      out.write("        <nav class=\"navbar-side\">\r\n");
      out.write("            <ul class=\"nav\">\r\n");
      out.write("                <li><a class=\"active-menu\" href=\"home.jsp\"><i class=\"fa fa-dashboard\"></i> Status</a></li>\r\n");
      out.write("                <li><a href=\"hotel.jsp\"><i class=\"fa fa-desktop\"></i> Hotel</a></li>\r\n");
      out.write("                <li><a href=\"profit.jsp\"><i class=\"fa fa-qrcode\"></i> RoomType</a></li>\r\n");
      out.write("                <li><a href=\"logout.jsp\"><i class=\"fa fa-sign-out fa-fw\"></i> Logout</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </nav>\r\n");
      out.write("\r\n");
      out.write("        <div id=\"page-wrapper\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-md-12\">\r\n");
      out.write("                    <h1 class=\"page-header\">\r\n");
      out.write("                        Status <small>Room Booking</small>\r\n");
      out.write("                    </h1>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-md-12\">\r\n");
      out.write("                    <div class=\"panel\">\r\n");
      out.write("                        <div class=\"panel-heading\">\r\n");
      out.write("                            New Room Bookings\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"panel-body\">\r\n");
      out.write("                            <button class=\"btn btn-primary\" type=\"button\">\r\n");
      out.write("                                New Room Bookings <span class=\"badge\">0</span>\r\n");
      out.write("                            </button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-md-12\">\r\n");
      out.write("                    <div class=\"panel\">\r\n");
      out.write("                        <div class=\"panel-heading\">\r\n");
      out.write("                            Booked Rooms\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"panel-body\">\r\n");
      out.write("                            <button class=\"btn btn-primary\" type=\"button\">\r\n");
      out.write("                                Booked Rooms <span class=\"badge\">0</span>\r\n");
      out.write("                            </button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"panel\">\r\n");
      out.write("                <div class=\"panel-heading\">\r\n");
      out.write("                    Followers\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"panel-body\">\r\n");
      out.write("                    <button class=\"btn btn-primary\" type=\"button\">\r\n");
      out.write("                        Followers <span class=\"badge\">0</span>\r\n");
      out.write("                    </button>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
