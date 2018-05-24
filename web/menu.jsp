<%-- 
    Document   : menu
    Created on : 2018-05-11, 12:42:11
    Author     : Radek
--%>
<%@page import="Kontroler.Logowania"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Muzeum Histprii Komputerów i Informatyki</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

    <!-- Custom styles for this template -->
    <link href="css/agency.css" rel="stylesheet">

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
                        <a class="nav-link js-scroll-trigger" href="#services">Wydarzenia</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="#portfolio">Kategorie</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="#about">O nas</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="#contact">Kontakt</a>
                    </li>
                    <% if ((session.getAttribute("id") == null) || (session.getAttribute("id") == "0")) { %>
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" data-toggle="modal" data-target="#exampleModal" data-whatever="@getbootstrap">Zaloguj</a> 
                    </li>
                    <% } else { %>
                    <jsp:useBean id="user" class="Kontroler.Osoba" scope="request">
                        <% String cos2 = session.getAttribute("id").toString(); %>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="panel_admin.jsp"><%out.print(user.getImie(cos2)); %></a>  
                        </li>
                        <% }%>
                    </jsp:useBean>
                    <div class="search-container">
                    </div>
                </ul>
            </div>
        </div>
    </nav>

    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Logowanie</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="Logowania" method="post" class="form-login">
                        <div class="form-group">
                            <label for="recipient-name" class="col-form-label">Email:</label>
                            <input id="inputEmail" name="inputEmail" class="form-control" placeholder="Email" required="" autofocus="" type="email" required>
                        </div>
                        <div class="form-group">
                            <label for="recipient-name" class="col-form-label">Hasło:</label>
                            <input id="inputPassword" name="inputPassword" class="form-control" placeholder="Password" required="" type="password" required>
                        </div>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Zaloguj</button>
                    </form>
                </div>
                <div class="modal-footer">
                </div>
            </div>
        </div>
    </div>
</html>
