<!DOCTYPE html>
<%@page  contentType="text/html" pageEncoding="UTF-8" %>
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
                    <div class="intro-lead-in">Panel Dodawania</div>
                </div>
            </div>
        </header>

        <!-- Dodaj uzytkownika -->
        <section id="uzytkownik">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <h2 class="section-heading text-uppercase">edytuj użytkownika</h2>
                        <h3 class="section-subheading text-muted"></h3>
                    </div>
                </div>

                <div class="modal-body">
                    <form class="form-horizontal" action="#">
                        <jsp:useBean id="user" class="Kontroler.Osoba" scope="session">

                            <%
                            String id = session.getAttribute("edit_id_user").toString();
                                                       
                            
                             %>
                             

                            <div class="form-group">
                                <div class="col-sm-10">
                                    <label for="imie">Imie:</label>
                                    <p> <input type="text" class="form-control" name="imie" value="<% out.print(user.getImie(id)); %>" > </p>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-10">
                                    <label for="nazwisko">Nazwisko:</label>
                                    <input type="text" class="form-control" name="nazwisko" value="<% out.print(user.getImie(id)); %>">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-10">
                                    <label for="adres">Adres:</label>
                                    <input type="text" class="form-control" name="adres" value="<% out.print(user.getNazwisko(id)); %>">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-10">
                                    <label for="nr_tel">Numer telefonu:</label>
                                    <input type="text" class="form-control" name="nazwisko" value="<% out.print(user.getTelefon(id)); %>">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-10">
                                    <label for="email">Email:</label>
                                    <input type="email" class="form-control" name="email" value="<% out.print(user.getEmail(id)); %>">
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-sm-10"> 
                                    <label for="pwd">Hasło:</label>
                                    <input type="password" class="form-control" name="pass" value="<% out.print(user.getOsoba(id).getHaslo()); %>">
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-sm-10"> 
                                    <label for="stanowiako">Stanowisko:</label>                                
                                    <select name="stanowisko" class="form-control"  >
                                        <option value="<% out.print(user.getOsoba(id).getStanowisko().getNazwa()); %>"></option>              
                                    </select>
                                </div>
                            </div>

                            <div class="form-group"> 
                                <div class="col-sm-offset-2 col-sm-10">
                                    <div class="col-lg-12 text-center">
                                        <button type="submit" class="btn btn-default">Edytuj użytkownika</button>
                                    </div>
                                </div>
                            </div>
                                   
                        </jsp:useBean>                            
                    </form>
                </div>

            </div>

        </section>

        <!-- Dodaj Eksponat -->
        <section class="bg-light" id="eksponat">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <h2 class="section-heading text-uppercase">Dodaj Eksponat</h2>
                        <h3 class="section-subheading text-muted"></h3>
                    </div>
                </div>

                <div class="modal-body">
                    <form class="form-horizontal" action="#">

                        <div class="form-group">
                            <div class="col-sm-10">
                                <label for="imie">Nazwa:</label>
                                <input type="text" class="form-control" name="imie" placeholder="Wpisz nazwe" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-10"> 
                                <label for="lokalizacja">Lokalizacja:</label>                                
                                <select name="lokalizacja" class="form-control"  >
                                    <option value="">Wybierz lokalizacja</option>
                                    <option>1 opcja </option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-10"> 
                                <label for="kategoria">Kategoria:</label>                                
                                <select name="kategoria" class="form-control"  >
                                    <option value="">Wybierz kategorie</option>
                                    <option>1 opcja </option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-10"> 
                                <label for="producent">Producent:</label>                                
                                <select name="producent" class="form-control"  >
                                    <option value="">Wybierz producenta</option>
                                    <option>1 opcja </option>
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
                                    <button type="submit" class="btn btn-default">Dodaj eksponat</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>

            </div>
        </section>

        <!-- Dodaj producenta -->
        <section id="producent">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <h2 class="section-heading text-uppercase">Dodaj producenta</h2>
                        <h3 class="section-subheading text-muted"></h3>
                    </div>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" action="#">

                        <div class="form-group">
                            <div class="col-sm-10">
                                <label for="imie">Nazwa:</label>
                                <input type="text" class="form-control" name="imie" placeholder="Wpisz nazwe" required>
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


        <!-- Dodaj lokalizacje -->
        <section id="lokalizacja">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <h2 class="section-heading text-uppercase">Dodaj lokalizacje</h2>
                        <h3 class="section-subheading text-muted"></h3>
                    </div>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" action="#">

                        <div class="form-group">
                            <div class="col-sm-10">
                                <label for="imie">Nazwa:</label>
                                <input type="text" class="form-control" name="imie" placeholder="Wpisz nazwe" required>
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


        <!-- Dodaj kategorie -->
        <section id="kategoria">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <h2 class="section-heading text-uppercase">Dodaj kategorie</h2>
                        <h3 class="section-subheading text-muted"></h3>
                    </div>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" action="#">

                        <div class="form-group">
                            <div class="col-sm-10">
                                <label for="imie">Nazwa:</label>
                                <input type="text" class="form-control" name="imie" placeholder="Wpisz nazwe" required>
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

        <!-- Dodaj stanowisko -->
        <section id="stanowisko">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <h2 class="section-heading text-uppercase">Dodaj stanowisko</h2>
                        <h3 class="section-subheading text-muted"></h3>
                    </div>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" action="#">

                        <div class="form-group">
                            <div class="col-sm-10">
                                <label for="imie">Nazwa:</label>
                                <input type="text" class="form-control" name="imie" placeholder="Wpisz nazwe" required>
                            </div>
                        </div>
                        <div class="form-group"> 
                            <div class="col-sm-offset-2 col-sm-10">
                                <div class="col-lg-12 text-center">
                                    <button type="submit" class="btn btn-default">Dodaj stanowisko</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
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

        <!-- Portfolio Modals -->

        <!-- Modal 1 -->
        <div class="portfolio-modal modal fade" id="portfolioModal1" tabindex="-1" role="dialog" aria-hidden="true">
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
                                    <h2 class="text-uppercase">Eksponat 1</h2>
                                    <p class="item-intro text-muted"></p>
                                    <img class="img-fluid d-block mx-auto" src="img/portfolio/z1.jpg" alt="">
                                    <p> Opis eksponatu Opis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatu</p>

                                    <button class="btn btn-primary" data-dismiss="modal" type="button">
                                        <i class="fa fa-times"></i>
                                        Zamknij okno</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal 2 -->
        <div class="portfolio-modal modal fade" id="portfolioModal2" tabindex="-1" role="dialog" aria-hidden="true">
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
                                    <h2 class="text-uppercase">Eksponat 2</h2>
                                    <p class="item-intro text-muted"></p>
                                    <img class="img-fluid d-block mx-auto" src="img/portfolio/z1.jpg" alt="">
                                    <p>Opis eksponatu Opis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatu</p>

                                    <button class="btn btn-primary" data-dismiss="modal" type="button">
                                        <i class="fa fa-times"></i>
                                        Zamknij okno</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal 3 -->
        <div class="portfolio-modal modal fade" id="portfolioModal3" tabindex="-1" role="dialog" aria-hidden="true">
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
                                    <h2 class="text-uppercase">Eksponat 3</h2>
                                    <p class="item-intro text-muted"></p>
                                    <img class="img-fluid d-block mx-auto" src="img/portfolio/z1.jpg" alt="">
                                    <p>Opis eksponatu Opis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatu</p>

                                    <button class="btn btn-primary" data-dismiss="modal" type="button">
                                        <i class="fa fa-times"></i>
                                        Zamknij okno</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal 4 -->
        <div class="portfolio-modal modal fade" id="portfolioModal4" tabindex="-1" role="dialog" aria-hidden="true">
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
                                    <h2 class="text-uppercase">Eksponat 4</h2>
                                    <p class="item-intro text-muted"></p>
                                    <img class="img-fluid d-block mx-auto" src="img/portfolio/z1.jpg" alt="">
                                    <p>Opis eksponatu Opis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatu</p>

                                    <button class="btn btn-primary" data-dismiss="modal" type="button">
                                        <i class="fa fa-times"></i>
                                        Zamknij okno</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal 5 -->
        <div class="portfolio-modal modal fade" id="portfolioModal5" tabindex="-1" role="dialog" aria-hidden="true">
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
                                    <h2 class="text-uppercase">Eksponat 5</h2>
                                    <p class="item-intro text-muted"></p>
                                    <img class="img-fluid d-block mx-auto" src="img/portfolio/z1.jpg" alt="">
                                    <p>Opis eksponatu Opis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatu</p>

                                    <button class="btn btn-primary" data-dismiss="modal" type="button">
                                        <i class="fa fa-times"></i>
                                        Zamknij okno</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal 6 -->
        <div class="portfolio-modal modal fade" id="portfolioModal6" tabindex="-1" role="dialog" aria-hidden="true">
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
                                    <h2 class="text-uppercase">Eksponat 6</h2>
                                    <p class="item-intro text-muted"></p>
                                    <img class="img-fluid d-block mx-auto" src="img/portfolio/z1.jpg" alt="">
                                    <p>Opis eksponatu Opis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatuOpis eksponatu</p>

                                    <button class="btn btn-primary" data-dismiss="modal" type="button">
                                        <i class="fa fa-times"></i>
                                        Zamknij okno</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

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
<%}%>