/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontroler;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sylwester
 */
@WebServlet("/addExhibit")
public class addExhibit extends HttpServlet implements java.io.Serializable {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
     
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        
        String nazwa = request.getParameter("imie");
        Lokalizacja lokalizacja = new Lokalizacja();
        Kategorie kategoria=new Kategorie();
        String opis=request.getParameter("opis");
        Date data_od = df.parse(req.getParameter("data_od"));

       
           

       
        
        try{
            
        }catch(Exception e){
      
            response.sendRedirect("error.jsp");
        }
 response.sendRedirect("panel_add.jsp");
    }
    
}
