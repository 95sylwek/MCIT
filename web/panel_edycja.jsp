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
        <title>Panel edycja </title>

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
                        <h2 class="section-heading text-uppercase">edytuj użytkownika</h2>
                        <h3 class="section-subheading text-muted"></h3>
                    </div>
                </div>

                <div class="modal-body">
                    <form class="form-horizontal" action="editUser" method="post">
                        <jsp:useBean id="user" class="Kontroler.Osoba" scope="request">                           
                            <% String id = session.getAttribute("edit_id_user").toString();
                                 %> 
                                 <p> <input type="text" class="form-control d-none" name="id" value="<%out.print(id);%>" > </p>

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
                                    <input type="text" class="form-control" name="telefon" value="<% out.print(user.getTelefon(id)); %>">
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

                            <!-- do poprawy na pozniej (rozwijany wybor stanowiska, domyslne aktualen stanowisko) -->
                            <div class="form-group">
                                <div class="col-sm-10"> 
                                    <label for="stanowiako">Stanowisko:</label>                                
                                    <select name="stanowisko" class="form-control"  >
                                        <jsp:useBean id="stanowisko" class="Kontroler.Stanowisko" scope="request">
                                            <option value="<% out.print(user.getStanowisko(id).getIdStanowisko()); %>"><% out.print(user.getStanowisko(id).getNazwa()); %></option>
                                            <% for (Model.Stanowisko cos : stanowisko.getStanowiska()) {
                                                    if (cos.getIdStanowisko() != user.getStanowisko(id).getIdStanowisko()) {
                                            %>                                            
                                            <option value="<% out.print(cos.getIdStanowisko()); %>"><% out.print(cos.getNazwa());%> </option>
                                            <% }
                                                }%>
                                        </jsp:useBean>             
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
                            </form>
                        </jsp:useBean>                            
                    
                </div>
            </div>
        </section>


        <!-- Footer -->
        <%@include file="footer.jsp" %>
        <%}%>