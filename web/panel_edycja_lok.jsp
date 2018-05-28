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

        <!-- Edytuj uzytkownika -->
        <section id="uzytkownik">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <h2 class="section-heading text-uppercase">Edytuj lokalizacje</h2>
                        <h3 class="section-subheading text-muted"></h3>
                    </div>
                </div>

                <div class="modal-body">
                    <form class="form-horizontal" action="edit_lokalizacji" method="post">
                        <jsp:useBean id="lokalizacja" class="Kontroler.Lokalizacja" scope="request">                           
                            <% String sid = request.getParameter("id"); 
                        
                    
                        Model.Loklaizacja lok =lokalizacja.getLoklaizacja(sid); %>                           
<p> <input type="text" class="form-control d-none" name="id" value="<%out.print(sid);%>" > </p>
                            <div class="form-group">
                                <div class="col-sm-10">
                                    <label for="imie">Nazwa:</label>
                                    <p> <input type="text" class="form-control" name="nazwa" value="<% out.print(lok.getNazwa()); %>" > </p>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-10">
                                    <label for="nazwisko">Opis:</label>
                                    <input type="text" class="form-control" name="opis" value="<% out.print(lok.getOpis()); %>">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-10">
                                    <label for="adres">Data od:</label>
                                    <input type="date" class="form-control" name="dataod" value="<% out.print(lokalizacja.getDataOd(sid)); %>">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-10">
                                    <label for="nr_tel">Data do:</label>
                                    <input type="date" class="form-control" name="datado" value="<% out.print(lokalizacja.getDataDo(sid)); %>">
                                </div>
                            </div>
                            
                            
                            <div class="form-group"> 
                                <div class="col-sm-offset-2 col-sm-10">
                                    <div class="col-lg-12 text-center">
                                        <button type="submit" class="btn btn-default">Edytuj lokalizacje</button>
                                    
                                </form>
                      <form action="remove_lokalizacja" method="POST">
                    <input class="d-none" type="text" name="remove_lokalizacja" value="<% out.print(lok.getIdLokalizacja());%>" />
                    <br><button type="submit" class="btn btn-default">Usuń</button><br><br><br>
                    </div>
                                </div>
                            </div>
                </form>
                        </jsp:useBean>                            
                    
                </div>
            </div>
        </section>


        <!-- Footer -->
        <%@include file="footer.jsp" %>
        <%}%>