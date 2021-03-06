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

        <title>Panel edytuj/usuń </title>

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
                        <% if (session.getAttribute("idStanowisko").equals(1) || session.getAttribute("idStanowisko").equals(2)) { %>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="#uzytkownik">Edytuj/Usuń użytkownika</a>
                        </li>
                        <% } %>
                        <% if (session.getAttribute("idStanowisko").equals(2)) { %>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="#eksponat">Edytuj/Usuń eksponat</a>
                        </li>
                        <% } %>
                        <% if (session.getAttribute("idStanowisko").equals(2)) { %>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="#producent">Edytuj/Usuń producenta</a>
                        </li>
                        <% } %>
                        <% if (session.getAttribute("idStanowisko").equals(2)) { %>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="#lokalizacja">Edytuj/Usuń lokalizacje</a>
                        </li>
                        <% } %>
                        <% if (session.getAttribute("idStanowisko").equals(2)) { %>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="#kategoria">Edytuj/Usuń kategorie</a>
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
        <jsp:useBean id="osoba" class="Kontroler.Osoba" scope="request">
            <% if (session.getAttribute("idStanowisko").equals(1) || session.getAttribute("idStanowisko").equals(2)) { %>
            <section class="bg-light" id="uzytkownik">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12 text-center">
                            <h2 class="section-heading text-uppercase">Edycja użytkowników</h2>
                            <h3 class="section-subheading text-muted"></h3>
                        </div>
                    </div>
                    <div class="row">

                        <%
                            for (Model.Osoba cos : osoba.getOsoby()) {
                        %>
                        <% if (((session.getAttribute("idStanowisko").equals(2)) && cos.getIdOsoba() != 1) || (session.getAttribute("idStanowisko").equals(1))) { %>


                        <div class="col-md-4 col-sm-6 portfolio-item">   
                            <center>

                                    <a ><% out.print(cos.getImie()+" "+cos.getNazwisko()); %></a>

                             
                                   <form action="show_edit" method="POST">
                                       <h4><p <% out.print(cos.getImie()); %></p></h4>
                                        <input class="d-none" type="text" name="edit_id_user" value="<% out.print(cos.getIdOsoba());%>" />
                                         <button type="submit" class="btn btn-default">Edytuj</button>
                                    </form> 
                                    <form action="remove_user" method="POST">
                                        <input class="d-none" type="text" name="remove_id_user" value="<% out.print(cos.getIdOsoba());%>" />
                                        <br><button type="submit" class="btn btn-default">Usuń</button><br><br><br>
                                    </form>
                            </center>
                            </div>

                        <% } %>
                        <% } %>
                    </div>
                </div>
            </section>
        </jsp:useBean>
        <% } %>
        <% if (session.getAttribute("idStanowisko").equals(2)) { %>
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
                            <div class="col-md-4 col-sm-6 portfolio-item">
                                <h4> <a href=" panel_przej_ekspo.jsp?id=<% out.print(cos.getIdKategoria()); %>"><% out.print(cos.getNazwa()); %> </a></h4>
                                <!--                                <form action="show_ekspo" method="GET">
                                <% //response.sendRedirect("panel_przej_ekspo.jsp"+cos.getIdKategoria()); %>
                                <input class="d-none" type="text" name="id_kat" value="<% out.print(cos.getIdKategoria());%>" />
                                <button type="submit" class="btn btn-default"><% out.print(cos.getNazwa()); %></button>

                       
                                 
                            </form>-->
                            </div>


                            <% } %>
                        </jsp:useBean>
                    </div></center>
            </div>
        </section>

        <% } %>
        <% if (session.getAttribute("idStanowisko").equals(2)) { %>
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


                                    <div class="portfolio-caption">                                           
                                        <h4>  <a href="panel_edycja_producenta.jsp?id=<% out.print(pro.getIdProducent());%>"><% out.print(pro.getNazwa()); %></h4>
                                    </div>
                                    </a>

                                </div>


                                <% } %>
                            </jsp:useBean>
                        </div></center>

                </div>
            </center>
        </section>
        <% } %>
        <% if (session.getAttribute("idStanowisko").equals(2)) { %>
        <!--Lokalizacje-->
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
                                    <h4> <a    href=" panel_edycja_lok.jsp?id=<% out.print(wyd.getIdLokalizacja()); %>"><%out.print(wyd.getNazwa()); %> </a></h4>



                                </div>


                                <% } %>
                            </jsp:useBean>
                        </div></center>

                </div>
            </center>
        </section>
        <% } %>
        <% if (session.getAttribute("idStanowisko").equals(2)) { %>
        <!--Kategoria-->
        <section class="bg-light" id="kategoria">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <h2 class="section-heading text-uppercase">Kategorie</h2>
                        <h3 class="section-subheading text-muted"></h3>
                    </div>
                </div>
                <center><div class="row">
                        <jsp:useBean id="kat" class="Kontroler.Kategorie" scope="request">
                            <%
                                for (Model.Kategorie kate : kat.getKategorie()) {
                            %>

                            <div class="col-md-4 col-sm-6 portfolio-item">
                                <a class="portfolio-link" data-toggle="modal" href="#<% out.print(kate.getIdKategoria());%>">


                                    <div class="portfolio-caption" class="portfolio-hover">
                                        <h4> <a href=" panel_edycja_kat.jsp?id=<% out.print(kate.getIdKategoria()); %>"><% out.print(kate.getNazwa()); %> </a></h4>                                 

                                    </div>
                                </a>

                            </div>


                            <% } %>
                        </jsp:useBean>
                    </div></center>
            </div>
        </div>

    </section>
    <% } %>

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
