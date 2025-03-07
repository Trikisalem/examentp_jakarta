<%@page import="java.sql.*" errorPage="error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%!
    PreparedStatement ps;
    ResultSet rs;
%>
<%
    Connection c = (Connection) application.getAttribute("connection");
%>

<%
    String rsql = "SELECT id FROM room";
    ps = c.prepareStatement(rsql);
    rs = ps.executeQuery();
%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>SUNRISE HOTEL</title>
    <!-- Bootstrap Styles-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>
    <div id="wrapper">
        <nav class="navbar navbar-default top-navbar" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="home.jsp">MAIN MENU</a>
            </div>

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a></li>
                        <li><a href="settings.jsp"><i class="fa fa-gear fa-fw"></i> Settings</a></li>
                        <li class="divider"></li>
                        <li><a href="logout.jsp"><i class="fa fa-sign-out fa-fw"></i> Logout</a></li>
                    </ul>
                </li>
            </ul>
        </nav>

        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                    <li><a href="settings.jsp"><i class="fa fa-dashboard"></i>Room Status</a></li>
                    <li><a href="room.jsp"><i class="fa fa-plus-circle"></i>Add Room</a></li>
                    <li><a class="active-menu" href="roomdel.jsp"><i class="fa fa-pencil-square-o"></i> Delete Room</a></li>
                </ul>
            </div>
        </nav>

        <div id="page-wrapper">
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">
                            DELETE ROOM <small></small>
                        </h1>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12 col-sm-12">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                Delete room
                            </div>
                            <div class="panel-body">
                                <form name="form" method="post">
                                    <div class="form-group">
                                        <label>Select the Room ID *</label>
                                        <select name="id" class="form-control" required>
                                            <option value selected ></option>
                                            <% while(rs.next()) { 
                                                int value = rs.getInt("id"); %>
                                                <option value="<%=value%>"><%=value%></option>
                                            <% } %>
                                        </select>
                                    </div>
                                    <input type="submit" name="del" value="Delete Room" class="btn btn-primary">
                                </form>
                                
                                <%
                                    if(request.getParameter("del") != null) {
                                        try {
                                            int did = Integer.parseInt(request.getParameter("id"));

                                            // Utilisation de requ�tes pr�par�es pour �viter les injections SQL
                                            String sql = "DELETE FROM room WHERE id = ?";
                                            ps = c.prepareStatement(sql);
                                            ps.setInt(1, did);  // Remplacer "?" par l'ID de la chambre
                                            int i = ps.executeUpdate();
                                            
                                            if(i > 0) {
                                                response.sendRedirect("roomdel.jsp");
                                            } else {
                                                out.println("<script>alert('Error deleting room')</script>");
                                            }
                                        } catch (SQLException e) {
                                            e.printStackTrace();
                                            out.println("<script>alert('An error occurred. Please try again later.')</script>");
                                        } catch (NumberFormatException e) {
                                            out.println("<script>alert('Invalid room ID')</script>");
                                        }
                                    }
                                %>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <%
                        String sql = "SELECT * FROM room";
                        ps = c.prepareStatement(sql);
                        rs = ps.executeQuery();

                        while(rs.next()) {
                            String type = rs.getString("type");
                            int id = rs.getInt("id");
                            String bedding = rs.getString("bedding");

                            // Affichage de chaque type de chambre avec une couleur diff�rente
                            if(type.equalsIgnoreCase("Superior Room")) { %>
                                <div class='col-md-3 col-sm-12 col-xs-12'>
                                    <div class='panel panel-primary text-center no-boder bg-color-blue'>
                                        <div class='panel-body'>
                                            <i class='fa fa-users fa-5x'></i>
                                            <h3><%=bedding%></h3>
                                        </div>
                                        <div class='panel-footer back-footer-blue'>
                                            <%=type%> (<%=id%>)
                                        </div>
                                    </div>
                                </div>
                            <% } else if (type.equalsIgnoreCase("Deluxe Room")) { %>
                                <div class='col-md-3 col-sm-12 col-xs-12'>
                                    <div class='panel panel-primary text-center no-boder bg-color-green'>
                                        <div class='panel-body'>
                                            <i class='fa fa-users fa-5x'></i>
                                            <h3><%=bedding%></h3>
                                        </div>
                                        <div class='panel-footer back-footer-green'>
                                            <%=type%> (<%=id%>)
                                        </div>
                                    </div>
                                </div>
                            <% } else if(type.equalsIgnoreCase("Guest House")) { %>
                                <div class='col-md-3 col-sm-12 col-xs-12'>
                                    <div class='panel panel-primary text-center no-boder bg-color-brown'>
                                        <div class='panel-body'>
                                            <i class='fa fa-users fa-5x'></i>
                                            <h3><%=bedding%></h3>
                                        </div>
                                        <div class='panel-footer back-footer-brown'>
                                            <%=type%> (<%=id%>)
                                        </div>
                                    </div>
                                </div>
                            <% } else if(type.equalsIgnoreCase("Single Room")) { %>
                                <div class='col-md-3 col-sm-12 col-xs-12'>
                                    <div class='panel panel-primary text-center no-boder bg-color-red'>
                                        <div class='panel-body'>
                                            <i class='fa fa-users fa-5x'></i>
                                            <h3><%=bedding%></h3>
                                        </div>
                                        <div class='panel-footer back-footer-red'>
                                            <%=type%> (<%=id%>)
                                        </div>
                                    </div>
                                </div>
                            <% } 
                        }
                    %>
                </div>
            </div>
        </div>

    </div>

    <!-- JS Scripts-->
    <!-- jQuery Js -->
    <script src="assets/js/jquery-1.10.2.js"></script>
    <!-- Bootstrap Js -->
    <script src="assets/js/bootstrap.min.js"></script>
    <!-- Metis Menu Js -->
    <script src="assets/js/jquery.metisMenu.js"></script>
    <!-- Custom Js -->
    <script src="assets/js/custom-scripts.js"></script>
</body>
</html>
