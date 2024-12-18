<%@page import="java.sql.*" errorPage="error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                    <li>
                        <a class="active-menu" href="settings.jsp"><i class="fa fa-dashboard"></i>Room Status</a>
                    </li>
                    <li>
                        <a href="room.jsp"><i class="fa fa-plus-circle"></i>Add Room</a>
                    </li>
                    <li>
                        <a href="roomdel.jsp"><i class="fa fa-pencil-square-o"></i> Delete Room</a>
                    </li>
                </ul>
            </div>
        </nav>
        
        <div id="page-wrapper">
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">
                            Available <small> Rooms</small>
                        </h1>
                    </div>
                </div>

                <!-- Room Types (hardcoded or from another source) -->
                <div class="row">
                    <!-- Example Room Entries (without database query) -->
                    <div class="col-md-3 col-sm-12 col-xs-12">
                        <div class='panel panel-primary text-center no-boder bg-color-blue'>
                            <div class='panel-body'>
                                <i class='fa fa-users fa-5x'></i>
                                <h3>Double Bed</h3>
                            </div>
                            <div class='panel-footer back-footer-blue'>
                                Superior Room
                            </div>
                        </div>
                    </div>

                    <div class="col-md-3 col-sm-12 col-xs-12">
                        <div class='panel panel-primary text-center no-boder bg-color-green'>
                            <div class='panel-body'>
                                <i class='fa fa-users fa-5x'></i>
                                <h3>Single Bed</h3>
                            </div>
                            <div class='panel-footer back-footer-green'>
                                Deluxe Room
                            </div>
                        </div>
                    </div>

                    <div class="col-md-3 col-sm-12 col-xs-12">
                        <div class='panel panel-primary text-center no-boder bg-color-brown'>
                            <div class='panel-body'>
                                <i class='fa fa-users fa-5x'></i>
                                <h3>Queen Bed</h3>
                            </div>
                            <div class='panel-footer back-footer-brown'>
                                Guest House
                            </div>
                        </div>
                    </div>

                    <div class="col-md-3 col-sm-12 col-xs-12">
                        <div class='panel panel-primary text-center no-boder bg-color-red'>
                            <div class='panel-body'>
                                <i class='fa fa-users fa-5x'></i>
                                <h3>King Bed</h3>
                            </div>
                            <div class='panel-footer back-footer-red'>
                                Single Room
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>

    <!-- JS Scripts-->
    <script src="assets/js/jquery-1.10.2.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/jquery.metisMenu.js"></script>
    <script src="assets/js/custom-scripts.js"></script>
</body>
</html>