<%@page import="Model.Eksponaty"%>
<%@page import="Kontroler.Eksponat"%>
<%@page import="Kontroler.Kategorie"%>
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
                <a class="navbar-brand js-scroll-trigger" href="#page-top">MHKI</a>
                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fa fa-bars"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav text-uppercase ml-auto">
                        <% if (session.getAttribute("idStanowisko").equals(1) || session.getAttribute("idStanowisko").equals(2)) { %>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="#uzytkownik">Edytuj użytkownika</a>
                        </li>
                        <% } %>
                        <% if (session.getAttribute("idStanowisko").equals(3) || session.getAttribute("idStanowisko").equals(2)) { %>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="#eksponat">Edytuj eksponat</a>
                        </li>
                        <% } %>
                        <% if (session.getAttribute("idStanowisko").equals(2)) { %>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="#producent">Edytuj producenta</a>
                        </li>
                        <% } %>
                        <% if (session.getAttribute("idStanowisko").equals(2)) { %>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="#lokalizacja">Edytuj lokalizacje</a>
                        </li>
                        <% } %>
                        <% if (session.getAttribute("idStanowisko").equals(2)) { %>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="#kategoria">Edytuj kategorie</a>
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
                    <div class="intro-lead-in">Modyfikacje</div>

                </div>
            </div>
        </header>

        <!--userow-->
        <section class="bg-light" id="uzytkownik">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <h2 class="section-heading text-uppercase">Edycja użytkowników</h2>
                        <h3 class="section-subheading text-muted"></h3>
                    </div>
                </div>
                <center><div class="row">
                        <jsp:useBean id="osoba" class="Kontroler.Osoba" scope="request">
                            <%
                                for (Model.Osoba cos : osoba.getOsoby()) {
                            %>

                            <div class="form-group" > 
                                <div class="col-sm-offset-2 col-sm-10">    

                                    <p ><% out.print(cos.getImie()); %><p> 

                                    <div class="form-group"> 
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <div class="col-lg-12 text-center">
                                                <form action="show_edit" method="POST">
                                                    <input class="d-none" type="text" name="edit_id_user" value="<% out.print(cos.getIdOsoba());%>" />
                                                    <button type="submit" class="btn btn-default">Edytuj</button>
                                                </form>
                                                <br><button type="submit" class="btn btn-default">Usuń</button><br><br><br>
                                            </div>
                                        </div>
                                    </div>        
                                </div>
                            </div> 
                            <% } %>
                        </jsp:useBean>
                    </div></center>
            </div>
        </section>

        <!--Eksponaty--> 
        <section class="bg-light" id="eksponat">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <h2 class="section-heading text-uppercase">Edycja eksponatów</h2>
                        <h3 class="section-subheading text-muted"></h3>
                    </div>
                </div>
                <center><div class="row">
                        <jsp:useBean id="eksponat" class="Kontroler.Kategorie" scope="request">
                            <%
                                for (Model.Kategorie cos : eksponat.getKategorie()) {
                                    
                            %>
                            <a href=" panel_przej_ekspo.jsp?id=<% out.print(cos.getIdKategoria()); %>"><% out.print(cos.getNazwa()); %> </a>
<!--                                <form action="show_ekspo" method="GET">
                                    <% //response.sendRedirect("panel_przej_ekspo.jsp"+cos.getIdKategoria()); %>
                                    <input class="d-none" type="text" name="id_kat" value="<% out.print(cos.getIdKategoria());%>" />
                                    <button type="submit" class="btn btn-default"><% out.print(cos.getNazwa()); %></button>

                           
                                     
                                </form>-->
\


                            <% } %>
                        </jsp:useBean>
                    </div></center>
            </div>
        </section>



        <!--Producent-->
        <section id="producent" >
            <center> <div class="container">
                    <div class="row">
                        <div class="col-lg-12 text-center">
                            <h2 class="section-heading text-uppercase">Edycja producenta</h2>
                            <h3 class="section-subheading text-muted"></h3>                       
                        </div>
                    </div>
                    <center><div class="row">
                            <jsp:useBean id="producent" class="Kontroler.Producenci" scope="request">
                                <%
                                    for (Model.Producenci pro : producent.getProducenci()) {
                                %>

                                <div class="col-md-4 col-sm-6 portfolio-item">
                                    <a class="portfolio-link" data-toggle="modal" href="#<% out.print(pro.getIdProducent());%>">

                                        <div class="portfolio-caption">
                                            <h4><% out.print(pro.getNazwa()); %></h4>                                 

                                        </div>
                                    </a>

                                </div>


                                <% } %>
                            </jsp:useBean>
                        </div></center>

                </div>
            </center>
        </section>

        <!--Wydarzenie-->
        <section id="lokalizacja" class="bg-light">
            <center> <div class="container">
                    <div class="row">
                        <div class="col-lg-12 text-center">
                            <h2 class="section-heading text-uppercase" >Edycja lokalizacji</h2> 
                            <h3 class="section-subheading text-muted"></h3> 
                        </div>
                    </div>
                    <center><div class="row">
                            <jsp:useBean id="wydarzenia" class="Kontroler.Lokalizacja" scope="request">
                                <%
                                    for (Model.Loklaizacja wyd : wydarzenia.getLoklaizacje()) {
                                %>

                                <div class="col-md-4 col-sm-6 portfolio-item">
                                    <a    href=" panel_edycja_lok.jsp?id=<% out.print(wyd.getIdLokalizacja()); %>"><%out.print(wyd.getNazwa()); %> </a>

                       

                                </div>


                                <% } %>
                            </jsp:useBean>
                        </div></center>

                </div>
            </center>
        </section>

        <!--Kategoria-->
        <section id="kategoria" >
            <center> <div class="container">
                    <div class="row">
                        <div class="col-lg-12 text-center">
                            <h2 class="section-heading text-uppercase" >Edycja kategorii</h2>                        
                        </div>
                    </div>

                    <center><div class="row">
                            <jsp:useBean id="kat" class="Kontroler.Kategorie" scope="request">
                                <%
                                    for (Model.Kategorie kate : kat.getKategorie()) {
                                %>

                                <div class="col-md-4 col-sm-6 portfolio-item">
                                    <a class="portfolio-link" data-toggle="modal" href="#<% out.print(kate.getIdKategoria());%>">
                   

                                        <div class="portfolio-caption">
                                            <h4> <a href=" panel_edycja_kat.jsp?id=<% out.print(kate.getIdKategoria()); %>"><% out.print(kate.getNazwa()); %> </a></h4>                                 

                                        </div>
                                    </a>

                                </div>


                                <% } %>
                            </jsp:useBean>
                        </div></center>

                </div>
            </center>
        </section>


        <!-- Contact -->
        <section id="contact">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <h2 class="section-heading text-uppercase">Kontakt</h2>
                        <h3 class="section-subheading text-muted"></h3>
                    </div>
                </div>


            </div>
        </section>



        <!-- Footer -->
        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-md-4">
                        <span class="copyright">Copyright &copy; MUZEUM TEAM </span>
                    </div>


                </div>
            </div>
        </footer>

        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Plugin JavaScript -->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Contact form JavaScript -->
        <script src="js/jqBootstrapValidation.js"></script>
        <script src="js/contact_me.js"></script>

        <!-- Custom scripts for this template -->
        <script src="js/agency.min.js"></script>

    </body>
</html>
<% }%>