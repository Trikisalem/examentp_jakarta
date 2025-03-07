<%@page import="java.sql.*" errorPage="error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Administrator</title>
    
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600&display=swap" rel="stylesheet">
    
    <style>
        :root {
            /* Color Palette */
            --primary-color: #3498db;
            --secondary-color: #2c3e50;
            --accent-color: #1abc9c;
            --background-light: #f9f9f9;
            --text-color: #333;
            --white: #ffffff;
            
            /* Typography */
            --font-main: 'Inter', 'Arial', sans-serif;
            --font-size-base: 16px;
            --font-size-large: 1.25rem;
            --font-size-small: 0.875rem;
            
            /* Spacing */
            --spacing-xs: 0.5rem;
            --spacing-sm: 1rem;
            --spacing-md: 1.5rem;
            --spacing-lg: 2rem;
            
            /* Shadows & Transitions */
            --box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            --transition-speed: 0.3s;
        }

        /* Reset & Base Styles */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: var(--font-main);
            background-color: var(--background-light);
            color: var(--text-color);
            line-height: 1.6;
            font-size: var(--font-size-base);
        }

        /* Typography */
        h1.page-header {
            color: var(--secondary-color);
            font-size: 2.5rem;
            margin-bottom: var(--spacing-md);
            font-weight: 600;
        }

        /* Layout */
        #wrapper {
            display: flex;
        }

        /* Navigation */
        .navbar-default {
            background-color: var(--secondary-color);
            padding: var(--spacing-sm) var(--spacing-md);
            box-shadow: var(--box-shadow);
        }

        .navbar-brand {
            color: var(--white);
            font-weight: bold;
            font-size: var(--font-size-large);
            text-decoration: none;
        }

        .navbar-nav {
            display: flex;
            list-style: none;
        }

        .navbar-nav li a {
            color: var(--white);
            padding: var(--spacing-sm);
            text-decoration: none;
            transition: background-color var(--transition-speed);
        }

        .navbar-nav li a:hover {
            background-color: var(--accent-color);
        }

        /* Side Navbar */
        .navbar-side {
            background-color: var(--secondary-color);
            width: 240px;
            height: 100vh;
            position: fixed;
            left: 0;
            top: 0;
            padding-top: var(--spacing-lg);
        }

        .navbar-side ul {
            list-style-type: none;
            padding: 0;
        }

        .navbar-side ul li a {
            display: block;
            padding: var(--spacing-sm);
            color: var(--white);
            text-decoration: none;
            transition: background-color var(--transition-speed);
        }

        .navbar-side ul li a:hover,
        .navbar-side ul li.active-menu a {
            background-color: var(--accent-color);
        }

        /* Page Wrapper */
        #page-wrapper {
            margin-left: 240px;
            flex-grow: 1;
            padding: var(--spacing-md);
        }

        /* Panels */
        .panel {
            background-color: var(--white);
            border-radius: 8px;
            box-shadow: var(--box-shadow);
            margin-bottom: var(--spacing-md);
            overflow: hidden;
        }

        .panel-heading {
            background-color: var(--primary-color);
            color: var(--white);
            padding: var(--spacing-sm);
            font-weight: bold;
        }

        .panel-body {
            padding: var(--spacing-md);
        }

        /* Buttons */
        .btn {
            display: inline-flex;
            align-items: center;
            padding: var(--spacing-sm) var(--spacing-md);
            border-radius: 6px;
            border: none;
            cursor: pointer;
            transition: 
                background-color var(--transition-speed),
                transform var(--transition-speed);
        }

        .btn-primary {
            background-color: var(--primary-color);
            color: var(--white);
        }

        .btn-primary:hover {
            background-color: color-mix(in srgb, var(--primary-color) 90%, white);
            transform: translateY(-2px);
        }

        /* Badge */
        .badge {
            background-color: var(--accent-color);
            color: var(--white);
            border-radius: 12px;
            padding: 2px 8px;
            font-size: var(--font-size-small);
            margin-left: var(--spacing-xs);
        }

        /* Responsive Design */
        @media screen and (max-width: 768px) {
            .navbar-side {
                width: 100%;
                height: auto;
                position: relative;
            }

            #page-wrapper {
                margin-left: 0;
            }
        }

        /* Dark Mode Support */
        @media (prefers-color-scheme: dark) {
            :root {
                --background-light: #121212;
                --text-color: #e0e0e0;
                --white: #1e1e1e;
            }
            
            body {
                background-color: var(--background-light);
                color: var(--text-color);
            }
            
            .panel {
                background-color: #1e1e1e;
            }
        }
    </style>
</head>

<body>
    <div id="wrapper">
        

        <nav class="navbar-side">
            <ul class="nav">
                <li><a class="active-menu" href="home.jsp"><i class="fa fa-dashboard"></i> Status</a></li>
                <li><a href="hotel.jsp"><i class="fa fa-desktop"></i> Hotel</a></li>
                <li><a href="profit.jsp"><i class="fa fa-qrcode"></i> RoomType</a></li>
                <li><a href="logout.jsp"><i class="fa fa-sign-out fa-fw"></i> Logout</a></li>
            </ul>
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-header">
                        Status <small>Room Booking</small>
                    </h1>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="panel">
                        <div class="panel-heading">
                            New Room Bookings
                        </div>
                        <div class="panel-body">
                            <button class="btn btn-primary" type="button">
                                New Room Bookings <span class="badge">0</span>
                            </button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="panel">
                        <div class="panel-heading">
                            Booked Rooms
                        </div>
                        <div class="panel-body">
                            <button class="btn btn-primary" type="button">
                                Booked Rooms <span class="badge">0</span>
                            </button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="panel">
                <div class="panel-heading">
                    Followers
                </div>
                <div class="panel-body">
                    <button class="btn btn-primary" type="button">
                        Followers <span class="badge">0</span>
                    </button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
