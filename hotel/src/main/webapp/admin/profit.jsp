<%@page import="java.sql.*" errorPage="error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Hotel Management</title>

    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600&display=swap" rel="stylesheet">

    <style>
        :root {
            --primary-color: #3498db;
            --secondary-color: #2c3e50;
            --accent-color: #1abc9c;
            --background-light: #f9f9f9;
            --text-color: #333;
            --white: #ffffff;
        }

        * {
            margin: 1.6px;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Inter', 'Arial', sans-serif;
            background-color: var(--background-light);
            color: var(--text-color);
            line-height: 1.6;
            font-size: 16px;
        }

        h1.page-header {
            color: var(--secondary-color);
            font-size: 2.5rem;
            margin-bottom: 1.5rem;
            font-weight: 600;
        }

        #wrapper {
            display: flex;
        }

        .navbar-side {
            background-color: var(--secondary-color);
            width: 240px;
            height: 100vh;
            position: fixed;
            left: 0;
            top: 0;
            padding-top: 2rem;
        }

        .navbar-side ul {
            list-style-type: none;
            padding: 0;
        }

        .navbar-side ul li a {
            display: block;
            padding: 1rem;
            color: var(--white);
            text-decoration: none;
            transition: background-color 0.3s;
        }

        .navbar-side ul li a:hover {
            background-color: var(--accent-color);
        }

        #page-wrapper {
            margin-left: 240px;
            flex-grow: 1;
            padding: 1.5rem;
        }

        .panel {
            background-color: var(--white);
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            margin-bottom: 1.5rem;
            overflow: hidden;
        }

        .panel-heading {
            background-color: var(--primary-color);
            color: var(--white);
            padding: 1rem;
            font-weight: bold;
        }

        .panel-body {
            padding: 1.5rem;
        }

        .btn {
            display: inline-flex;
            align-items: center;
            padding: 0.5rem 1rem;
            border-radius: 6px;
            border: none;
            cursor: pointer;
            background-color: var(--primary-color);
            color: var(--white);
            transition: background-color 0.3s, transform 0.3s;
        }

        .btn:hover {
            background-color: color-mix(in srgb, var(--primary-color) 90%, white);
            transform: translateY(-2px);
        }

        .table {
            width: 100%;
            margin-top: 2rem;
            border-collapse: collapse;
        }

        .table th, .table td {
            padding: 1rem 1.5rem; /* Ajuste la distance entre les lignes */
            border: 1px solid #ddd;
            text-align: left;
            vertical-align: middle;
        }

        /* Style pour le formulaire de recherche */
        .search-container {
            margin-bottom: 20px;
            display: flex; /* Aligner les éléments sur la même ligne */
            justify-content: space-between;
            align-items: center;
            width: 100%;
        }

        .form-control {
            height: 35px;
            font-size: 12px;
            flex: 1;
            max-width: 400px;
        }

        .search-button-container {
            display: flex;
            justify-content: flex-end;
            width: 150px; /* Limite la largeur du bouton */
        }

        /* Style pour le bouton Add Room */
        .add-hotel-container {
            margin-top: 5px;  
            display: flex;
            justify-content: flex-end;
            margin-bottom: 20px;
        }

        @media screen and (max-width: 768px) {
            .navbar-side {
                width: 100%;
                position: relative;
            }

            #page-wrapper {
                margin-left: 0;
            }
        }

        .table th {
            padding: 1rem 1.5rem;
        }

        .btn {
            height: 35px;
            padding: 0 1rem;
            font-size: 1rem;
        }

        /* Alignement des boutons dans le conteneur */
        .button-container {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
            width: 100%; /* Permet de prendre toute la largeur */
        }

        .search-button-container, .add-room-container {
            display: flex;
            justify-content: space-between;
            align-items: center;
            width: 45%; /* Les deux boutons prennent environ 45% de l'espace */
        }

        .search-container button {
            width: 100%; /* Le bouton Search prend toute la largeur disponible */
        }
    </style>
</head>
<body>
    <div id="wrapper">
        <nav class="navbar-side">
            <ul class="nav">
                <li><a href="home.jsp"><i class="fa fa-dashboard"></i> Status</a></li>
                <li><a class="active-menu" href="hotel.jsp"><i class="fa fa-desktop"></i> Hotel</a></li>
                <li><a href="profit.jsp"><i class="fa fa-qrcode"></i> RoomType</a></li>
                <li><a href="logout.jsp"><i class="fa fa-sign-out fa-fw"></i> Logout</a></li>
            </ul>
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-header">
                         <small>Manage Room</small>
                    </h1>
                </div>
            </div>

            <!-- Conteneur des boutons -->
            <div class="button-container">
                <!-- Formulaire de recherche avant le bouton "Add Room" -->
                <div class="search-container">
                    <form method="get" action="profit.jsp">
                        <div class="row" style="width: 100%; display: flex; justify-content: space-between;">
                            <div class="col-md-8" style="flex: 1;">
                                <input type="text" class="form-control" name="search"  
                                    value="<%= request.getParameter("search") != null ? request.getParameter("search") : "" %>">
                            </div>
                            <div class="col-md-4 search-button-container">
                                <button type="submit" class="btn">Search</button>
                            </div>
                        </div>
                    </form>
                </div>

                <!-- Bouton "Add Room" après la recherche -->
                <div class="add-room-container">
                    <a href="addRoom.jsp" class="btn">Add Room</a>
                </div>
            </div>

            <div class="panel">
                <div class="panel-heading">
                    Room List
                </div>
                <div class="panel-body">
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Room Type</th>
                                <th>Capacity</th>
                                <th>Price</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                String searchParam = request.getParameter("search");
                                String url = "jdbc:mysql://localhost:3306/hotel_management";
                                String user = "root";
                                String password = "triki";

                                Connection conn = null;
                                PreparedStatement stmt = null;
                                ResultSet rs = null;

                                try {
                                    Class.forName("com.mysql.cj.jdbc.Driver");
                                    conn = DriverManager.getConnection(url, user, password);

                                    String sql = "SELECT id, label, capacity, price FROM RoomType";
                                    if (searchParam != null && !searchParam.trim().isEmpty()) {
                                        sql += " WHERE label LIKE ?";
                                    }

                                    stmt = conn.prepareStatement(sql);

                                    if (searchParam != null && !searchParam.trim().isEmpty()) {
                                        stmt.setString(1, "%" + searchParam + "%");
                                    }

                                    rs = stmt.executeQuery();

                                    while (rs.next()) {
                                        int id = rs.getInt("id");
                                        String label = rs.getString("label");
                                        int capacity = rs.getInt("capacity");
                                        double price = rs.getDouble("price");
                            %>
                            <tr>
                                <td><%= id %></td>
                                <td><%= label %></td>
                                <td><%= capacity %></td>
                                <td><%= price %></td>
                                <td>
                                    <a href="editRoom.jsp?id=<%= id %>" class="btn">Update</a>
                                    <a href="deleteRoom.jsp?id=<%= id %>" class="btn">Delete</a>
                                </td>
                            </tr>
                            <%
                                    }
                                } catch (SQLException | ClassNotFoundException e) {
                                    e.printStackTrace();
                                } finally {
                                    try {
                                        if (rs != null) rs.close();
                                        if (stmt != null) stmt.close();
                                        if (conn != null) conn.close();
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                }
                            %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
