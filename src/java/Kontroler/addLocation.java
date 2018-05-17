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
@WebServlet("/addLocation")
public class addLocation extends HttpServlet implements java.io.Serializable{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            String nazwa = request.getParameter("lokalizacja");        
            String opis = request.getParameter("opis");
            Date data_od = df.parse(request.getParameter("dataod"));
            Date data_do = df.parse(request.getParameter("datado"));
            
            System.out.println(nazwa);
          
            Lokalizacja lokalizacja = new Lokalizacja(nazwa, opis, data_od, data_do);
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
            response.sendRedirect("error.jsp");
        }
        
        response.sendRedirect("panel_add.jsp");
}
}
