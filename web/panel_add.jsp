<%@page import="Kontroler.Logowania"%>
<%@page  contentType="text/html" pageEncoding="UTF-8" %>
<%
    if ((session.getAttribute("id") == null) || (session.getAttribute("id") == "0")) {
        response.sendRedirect("index.jsp");
    } else {
%>
<!DOCTYPE html>
<html lang="pl">
    <head>
        <meta charset="ISO-8859-1">
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
                <a class="navbar-brand js-scroll-trigger" href="#page-top">MHKI</a>
                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fa fa-bars"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav text-uppercase ml-auto">
                        <% if (session.getAttribute("idStanowisko").equals(1) || session.getAttribute("idStanowisko").equals(2)) { %>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="#uzytkownik">Dodaj użytkownika</a>
                        </li>
                        <% } %>
                        <% if (session.getAttribute("idStanowisko").equals(3) || session.getAttribute("idStanowisko").equals(2)) { %>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="#eksponat">Dodaj eksponat</a>
                        </li>
                        <% } %>
                        <% if (session.getAttribute("idStanowisko").equals(2)) { %>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="#producent">Dodaj producenta</a>
                        </li>
                        <% } %>
                        <% if (session.getAttribute("idStanowisko").equals(2)) { %>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="#lokalizacja">Dodaj lokalizacje</a>
                        </li>
                        <% } %>
                        <% if (session.getAttribute("idStanowisko").equals(2)) { %>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="#kategoria">Dodaj kategorie</a>
                        </li>
                        <% } %>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="panel_admin.jsp">Wróć</a>  
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
                    <div class="intro-lead-in">Panel Dodawania</div>
                </div>
            </div>
        </header>

        <%  if ((session.getAttribute("idStanowisko").equals(1)) || (session.getAttribute("idStanowisko").equals(2))) {      %>
        <!-- Dodaj uzytkownika -->
        <section id="uzytkownik">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <h2 class="section-heading text-uppercase">Dodaj użytkownika</h2>
                        <h3 class="section-subheading text-muted"></h3>
                    </div>
                </div>

                <div class="modal-body">
                    <form class="form-horizontal" action="addUser" method="POST" accept-charset="ISO-8859-1">

                        <div class="form-group">
                            <div class="col-sm-10">
                                <label for="imie">Imie:</label>
                                <input type="text" class="form-control" name="imie" placeholder="Wpisz imie" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-10">
                                <label for="nazwisko">Nazwisko:</label>
                                <input type="text" class="form-control" name="nazwisko" placeholder="Wpisz nazwisko" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-10">
                                <label for="adres">Adres:</label>
                                <input type="text" class="form-control" name="adres" placeholder="Wpisz adres">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-10">
                                <label for="nr_tel">Numer telefonu:</label>
                                <input type="text" class="form-control" name="telefon" placeholder="Wpisz numer telefonu">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-10">
                                <label for="email">Email:</label>
                                <input type="email" class="form-control" name="email" placeholder="Wpisz email" required>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-10"> 
                                <label for="pwd">Hasło:</label>
                                <input type="password" class="form-control" name="pass" placeholder="Wpisz hasło" required>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-10"> 
                                <label for="stanowiako">Stanowisko:</label>                                
                                <select name="stanowisko" class="form-control"  >
                                    <jsp:useBean id="stanowisko" class="Kontroler.Stanowisko" scope="request">
                                        <option value="">Wybierz stanowisko</option>
                                        <% for (Model.Stanowisko cos : stanowisko.getStanowiska()) { %>
                                        <option value="<% out.print(cos.getIdStanowisko()); %>"><% out.print(cos.getNazwa());%> </option>
                                        <% } %>
                                    </jsp:useBean>
                                </select>
                            </div>
                        </div>

                        <div class="form-group"> 
                            <div class="col-sm-offset-2 col-sm-10">
                                <div class="col-lg-12 text-center">
                                    <button type="submit" class="btn btn-default">Dodaj użytkownika</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>

            </div>

        </section>
        <% } %>

        <!-- Dodaj Eksponat -->
        <% if ((session.getAttribute("idStanowisko").equals(3)) || (session.getAttribute("idStanowisko").equals(2))) { %>
        <section class="bg-light" id="eksponat">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <h2 class="section-heading text-uppercase">Dodaj Eksponat</h2>
                        <h3 class="section-subheading text-muted"></h3>
                    </div>
                </div>

                <div class="modal-body">
                    <form class="form-horizontal" action="addExhibit"  method="POST" accept-charset="ISO-8859-1">

                        <div class="form-group">
                            <div class="col-sm-10">
                                <label for="imie">Nazwa:</label>
                                <input type="text" class="form-control" name="nazwa" placeholder="Wpisz nazwe" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-10"> 
                                <label for="lokalizacja">Lokalizacja:</label>                                
                                <select name="lokalizacja" class="form-control"  >
                                    <jsp:useBean id="lokalizacja" class="Kontroler.Lokalizacja" scope="request">
                                        <option value="">Wybierz lokalizacje</option>
                                        <% for (Model.Loklaizacja lok : lokalizacja.getLoklaizacje()) { %>
                                        <option value="<% out.print(lok.getIdLokalizacja()); %>"><% out.print(lok.getNazwa());%> </option>
                                        <% } %>
                                    </jsp:useBean>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-10"> 
                                <label for="kategoria">Kategoria:</label>                                
                                <select name="kategoria" class="form-control"  >
                                    <jsp:useBean id="kategoria" class="Kontroler.Kategorie" scope="request">
                                        <option value="">Wybierz kategorie</option>
                                        <% for (Model.Kategorie kat : kategoria.getKategorie()) { %>
                                        <option value="<% out.print(kat.getIdKategoria()); %>"><% out.print(kat.getNazwa());%> </option>
                                        <% } %>
                                    </jsp:useBean>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-10"> 
                                <label for="producenci">Producent:</label>                                
                                <select name="producenci" class="form-control"  >
                                    <jsp:useBean id="produ" class="Kontroler.Producenci" scope="request">
                                        <option value="">Wybierz producenta</option>
                                        <% for (Model.Producenci prod : produ.getProducenci()) { %>
                                        <option value="<% out.print(prod.getIdProducent()); %>"><% out.print(prod.getNazwa());%> </option>
                                        <% } %>
                                    </jsp:useBean>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-10">
                                <label for="opis">Opis:</label>
                                <textarea class="form-control" name="opis" placeholder="Wpisz opis" rows="4" cols="50"></textarea>                                
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-10">
                                <label for="rokpow">Data powstania:</label>
                                <input type="date" class="form-control" name="rokpow">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-10">
                                <label for="rokzakpro">Data zakończenia produkcji:</label>
                                <input type="date" class="form-control" name="rokzakpro">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-10">
                                <label for="zdj">Wybierz plik zdjęcia:</label>
                                <input type="file" class="form-control" name="zdj">
                            </div>
                        </div>

                        <div class="form-group"> 
                            <div class="col-sm-offset-2 col-sm-10">
                                <div class="col-lg-12 text-center">
                                    <button type="submit" class="btn btn-default" value = "submit" >Dodaj eksponat</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>

            </div>
        </section>
        <% } %>
        <!-- Dodaj producenta -->
        <% if ((session.getAttribute("idStanowisko").equals(2))) { %>
        <section id="producent">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <h2 class="section-heading text-uppercase">Dodaj producenta</h2>
                        <h3 class="section-subheading text-muted"></h3>
                    </div>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" action="addProducent"  method="POST" accept-charset="ISO-8859-1">

                        <div class="form-group">
                            <div class="col-sm-10">
                                <label for="imie">Nazwa:</label>
                                <input type="text" class="form-control" name="nazwa" placeholder="Wpisz nazwe" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-10">
                                <label for="opis">Opis:</label>
                                <textarea class="form-control" name="opis" placeholder="Wpisz opis" rows="4" cols="50"></textarea>                                
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-10">
                                <label for="rokpow">Data powstania:</label>
                                <input type="date" class="form-control" name="rokpow">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-10">
                                <label for="rokzak">Data zakończenia:</label>
                                <input type="date" class="form-control" name="rokzak">
                            </div>
                        </div>
                        <div class="form-group"> 
                            <div class="col-sm-offset-2 col-sm-10">
                                <div class="col-lg-12 text-center">
                                    <button type="submit" class="btn btn-default">Dodaj producenta</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </section>
        <% } %>

        <!-- Dodaj lokalizacje -->
        <% if ((session.getAttribute("idStanowisko").equals(2))) { %>
        <section id="lokalizacja">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <h2 class="section-heading text-uppercase">Dodaj lokalizacje</h2>
                        <h3 class="section-subheading text-muted"></h3>
                    </div>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" action="addLocation"  method="POST" accept-charset="ISO-8859-1">

                        <div class="form-group">
                            <div class="col-sm-10">
                                <label for="imie">Nazwa:</label>
                                <input type="text" class="form-control" name="lokalizacja" placeholder="Wpisz nazwe" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-10">
                                <label for="opis">Opis:</label>
                                <textarea class="form-control" name="opis" placeholder="Wpisz opis" rows="4" cols="50"></textarea>                                
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-10">
                                <label for="dataod">Data od:</label>
                                <input type="date" class="form-control" name="dataod">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-10">
                                <label for="datado">Data do:</label>
                                <input type="date" class="form-control" name="datado">
                            </div>
                        </div>
                        <div class="form-group"> 
                            <div class="col-sm-offset-2 col-sm-10">
                                <div class="col-lg-12 text-center">
                                    <button type="submit" class="btn btn-default">Dodaj lokalizacje</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </section>
        <% } %>

        <!-- Dodaj kategorie -->
        <% if ((session.getAttribute("idStanowisko").equals(2))) { %>
        <section id="kategoria">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <h2 class="section-heading text-uppercase">Dodaj kategorie</h2>
                        <h3 class="section-subheading text-muted"></h3>
                    </div>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" action="addCategory"  method="POST" accept-charset="ISO-8859-1">

                        <div class="form-group">
                            <div class="col-sm-10">
                                <label for="imie">Nazwa:</label>
                                <input type="text" class="form-control" name="nazwa" placeholder="Wpisz nazwe" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-10">
                                <label for="opis">Opis:</label>
                                <textarea class="form-control" name="opis" placeholder="Wpisz opis" rows="4" cols="50"></textarea>                                
                            </div>
                        </div>
                        <div class="form-group"> 
                            <div class="col-sm-offset-2 col-sm-10">
                                <div class="col-lg-12 text-center">
                                    <button type="submit" class="btn btn-default">Dodaj kategorie</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </section>
        <% } %>
        <%@include file="footer.jsp" %>
        <%}%>