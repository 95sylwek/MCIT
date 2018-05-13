<%@page import="Kontroler.Kategorie"%>
<%@page import="Kontroler.Lokalizacja"%>
<%@page  contentType="text/html" pageEncoding="UTF-8" %>

    



 <%@include file="menu.jsp" %>
    <!-- Header -->
    <header class="masthead">
      <div class="container">
        <div class="intro-text">
          <div class="intro-lead-in">Muzeum Historii Komputerów i Informatyki</div>
          <a class="btn btn-primary btn-xl text-uppercase js-scroll-trigger" href="#services">Wydarzenia</a>
          
          
        </div>
      </div>
    </header>

    <!-- Services -->
    <section id="services">
      <div class="container">
        <div class="row">
        
          <div class="col-lg-12 text-center">
            <h2 class="section-heading text-uppercase">Gdzie zobaczysz nasze eksponaty?</h2>
            <h3 class="section-subheading text-muted"></h3>
          </div>
        </div>
        <%
            int i=1;
               try{ 
                   Lokalizacja lokalizacja =new Lokalizacja ();
                   for (Model.Loklaizacja cos : lokalizacja.getLoklaizacje()){   
        %>
        
        <h4 ><% out.print(cos.getNazwa()); %></h4> 
               <p class="text-muted"><% out.print(cos.getOpis()); %></p><br>
               <% }
                }catch(Exception e){ out.print("pusta baza"); }%>
      </div>     
    </section>

    <!-- Portfolio Grid -->
    <section class="bg-light" id="portfolio">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 text-center">
            <h2 class="section-heading text-uppercase">Kategorie</h2>
            <h3 class="section-subheading text-muted"></h3>
          </div>
        </div>
           <div class="row">
                  <%
            
               try{ 
                   Kategorie kategoria =new Kategorie ();
                   for (Model.Kategorie cos : kategoria.getKategorie()){   
        %>
               
          <div class="col-md-4 col-sm-6 portfolio-item">
              <a class="portfolio-link" data-toggle="modal" href="#<% out.print(cos.getIdKategoria());%>">
              <div class="portfolio-hover"> 
              </div>
                <div class="portfolio-caption">
                <h4><% out.print(cos.getNazwa()); %></h4>
                </div>
            </a>
          </div>

 
               <% }
                }catch(Exception e){ out.print("pusta baza"); }%>
                </div>
          
          

      </div>
    </section>

    <!-- About -->
    <section id="about">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 text-center">
            <h2 class="section-heading text-uppercase">O nas</h2>
            <h3 class="section-subheading text-muted"></h3>
          </div>
        </div>
        <div class="row">
          <div class="col-lg-12">  
                </div>
                
            <h4>Dziś Muzeum w Katowicach ma skatalogowanych ponad 3900 komputerów</h4>
                        <br>
                        Odwiedzając nasze wystawy, przeżyją Państwo niebywałą podróż w czasie - nasza ekspozycja przeniesie 
                        Was w czasie o ponad 40 lat w przeszłość. 40 lat, które wydają się być okresem krótkim, dobrze zapisanym w pamięci. 
                        Trzeba jednak zdawać sobie sprawę, że 40 lat w Informatyce to kilka wieków w Architekturze. Mamy nadzieję, 
                        że 2 godziny przewidziane standardowo na podróż w czasie z naszym przewodnikiem, 
                        dostarczą Państwu wielu niezapomnianych wrażeń, a tym samym zaowocują chęcią powracania do naszej 
                        ekspozycji zarówno pamięcią, jak i osobiście.

                        W magazynie muzealnym mamy zgromadzonych ponad 3900 eksponatów, 
                        z czego przygotowanych do Państwa dyspozycji jest już ponad 550 komputerów. 
                        Nie spoczywamy na laurach i stale przygotowujemy kolejne.
                    
                    </h4>
                    
                 
                  <div class="timeline-body">
                    <p class="text-muted"></p>
                  </div>
                </div>
              </li>
             
            </ul>
          </div>
        </div>
      </div>
    </section>
    
    <!-- Login -->
    
    

    <!-- Portfolio Modals -->
    <!-- Modal 1 -->
                      <%
            
               try{ 
                   Kategorie kategoria =new Kategorie ();
                   for (Model.Kategorie cos : kategoria.getKategorie()){   
        %>
               
        <div class="portfolio-modal modal fade" id="<% out.print(cos.getIdKategoria());%>" tabindex="-1" role="dialog" aria-hidden="true">
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
                      <% out.print(cos.getOpis()); %>
                  </p>
                  <p class="item-intro text-muted"></p>
            
                 
                  <button class="btn btn-primary" data-dismiss="modal" type="button">
                   
                    Przejdź do eksponatów </button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    
       <% }
                }catch(Exception e){ out.print("pusta baza"); }%>
               

  <%@include file="footer.jsp" %>

</html>
