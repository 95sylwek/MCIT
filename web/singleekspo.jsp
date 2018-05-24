<%@page import="Model.Kategorie"%>
<%@page  contentType="text/html" pageEncoding="UTF-8" %>
<%
    if ((session.getAttribute("id") == null) || (session.getAttribute("id") == "0")) {
        response.sendRedirect("index.jsp");
    } else {
%>
<!DOCTYPE html>
<html lang="pl">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Panel Dodawania </title>

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
                            <a class="nav-link js-scroll-trigger" href="all_ekspo.jsp">Wróć</a>  
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
                    <div class="intro-lead-in">Panel edycji</div>
                </div>
            </div>
        </header>


        <section>
            <jsp:useBean id="eksponat" class="Kontroler.Eksponat" scope="request">

                <% String sid = request.getParameter("id");
                    int x = Integer.parseInt(sid);
                    Model.Eksponaty ek = eksponat.getEksponat(x);


                %>     


                <p><% out.print(ek.getNazwa()); %></p>
                <p><% out.print(ek.getLoklaizacja().getNazwa()); %></p>
                <p><% out.print(ek.getKategoria().getNazwa()); %></p>
                <p><% out.print(ek.getPooducent().getNazwa()); %></p>
                <p><% out.print(ek.getOpis()); %></p>
                <p><% out.print(ek.getRokpow()); %></p>
                <p><% out.print(ek.getRokzak()); %></p>

                <% if (session.getAttribute("idStanowisko") != null && session.getAttribute("idStanowisko").equals(2)) { %>
                <a href=" panel_edycja_ekspo.jsp?id=<% out.print(ek.getIdEksponat()); %>">Edytuj </a>

                <form action="remove_ekspo" method="POST">
                    <input class="d-none" type="text" name="remove_ekspo" value="<% out.print(ek.getIdEksponat());%>" />
                    <br><button type="submit" class="btn btn-default">Usuń</button><br><br><br>
                </form>
                <% } %>


            </jsp:useBean>

        </section>

        <%@include file="footer.jsp" %>
        <% }%>