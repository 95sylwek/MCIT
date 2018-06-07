<!DOCTYPE html>
<%@page  contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="Kontroler.Logowania"%>
<%
    if ((session.getAttribute("id") == null) || (session.getAttribute("id") == "0")) {
        response.sendRedirect("index.jsp");
    } else {
%>
<html lang="en">


    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Panel administratora </title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template -->
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
        <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

        <!-- Custom styles for this template -->
        <link href="css/agency.min.css" rel="stylesheet">

    </head>

    <body id="page-top">

        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand js-scroll-trigger" href="index.jsp">MHKI</a>
                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fa fa-bars"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav text-uppercase ml-auto">
                        <li class="nav-item">

                            <form action="panel_search.jsp" method="GET" style=" margin-top: 10px ">
                                <input type="text" placeholder="Wyszukaj..." name="search">
                                <button type="submit"><i class="fa fa-search"></i></button>
                            </form>

                        </li>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="panel_add.jsp">Dodaj</a>
                        </li>
                        <% if (session.getAttribute("idStanowisko").equals(1) || session.getAttribute("idStanowisko").equals(2)) { %>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="all_ekspo.jsp">Edycja/usuń</a>
                        </li>
                        <% } %>
                        <li class="nav-item">
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="#contact">Kontakt</a>
                        </li>
                        <jsp:useBean id="user" class="Kontroler.Osoba" scope="request">
                            <% String cos2 = session.getAttribute("id").toString(); %>
                            <li class="nav-item">
                                <a class="nav-link js-scroll-trigger"><%out.print(user.getImie(cos2)); %></a>  
                            </li>

                        

                        <li class="nav-item">
                            <form action="Wyloguj" method="post">
                                <button type="submit" formaction="Wyloguj" class="btn btn-primary"  data-target=".bd-example-modal-sm">Wyloguj</button>
                            </form>
                        </li>




                        <div class="search-container">

                        </div>
                    </ul>


                </div>
            </div>

        </nav>

        <!-- Header -->
        <header class="masthead">
            <div class="container">
                <div class="intro-text">
                    <div class="intro-lead-in"><%out.print("Jesteś zalogowany jako: "+user.getImie(cos2)+" "+user.getNazwisko(cos2));%><br><br>
                        <%out.print("Uprawnienia: " +user.getStanowisko(cos2).getNazwa());  %>
                    </div>

</jsp:useBean>

                </div>
            </div>
        </header>







        <%@include file="footer.jsp" %>
        <%}%>