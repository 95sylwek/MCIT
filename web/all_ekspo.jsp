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
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="#uzy">Edycja użytkownika</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="#">Edycja eksponatu</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="#producent">Edycja producenta</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="#lokalizacja">Edycja lokalizacji</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="#kategoria">Edycja kategorii</a>
                        </li> 
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

        <section class="bg-light" id="portfolio">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <h2 class="section-heading text-uppercase">Wszystkie eksponaty</h2>
                        <h3 class="section-subheading text-muted"></h3>
                    </div>
                </div>
                <div class="row">
                    <jsp:useBean id="eksponat" class="Kontroler.Eksponat" scope="request">
                        <%
                            for (Model.Eksponaty cos : eksponat.getEksponaty()) {
                        %>

                        <div class="col-md-4 col-sm-6 portfolio-item">
                            <a class="portfolio-link" data-toggle="modal" href="#<% out.print(cos.getIdEksponat());%>">
                                <div class="portfolio-hover"> 
                                </div>
                                <div class="portfolio-caption">
                                    <h4><% out.print(cos.getNazwa()); %></h4>
                                </div>
                            </a>
                        </div>


                        <% } %>
                    </jsp:useBean>
                </div>
            </div>
        </section>

        <section id="uzy">
            <center> <div class="container">
                    <div class="row">
                        <div class="col-lg-12 text-center">
                            <h2 class="section-heading text-uppercase" >Edycja użytkownika</h2>                        
                        </div>
                    </div>
                    <div class="modal-body">
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
                                                <button type="submit" class="btn btn-default">Usuń</button>
                                            </div>
                                        </div>
                                    </div>        
                                </div>
                            </div> 
                            <% } %>
                        </jsp:useBean>
                    </div>
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

        <!-- Modal 1 -->
        <jsp:useBean id="eksponat1" class="Kontroler.Eksponat" scope="request">
            <%
                for (Model.Eksponaty cos : eksponat1.getEksponaty()) {
            %>

            <div class="portfolio-modal modal fade" id="<% out.print(cos.getIdEksponat());%>" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="close-modal" data-dismiss="modal">
                            <div class="lr">
                                <div class="rl"></div>
                            </div>
                        </div>
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-8 mx-auto">
                                    <div class="modal-body">
                                        <!-- Project Details Go Here -->
                                        <h2 class="text-uppercase"><% out.print(cos.getNazwa()); %></h2>
                                        <p>
                                            <% out.print(cos.getZdj()); %>
                                            <img src="data:image/jpeg;base64, <% out.print(cos.getZdj());  %> ">
                                        </p>
                                        <p class="item-intro text-muted"></p>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <% }%>
        </jsp:useBean>

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
<% } %>