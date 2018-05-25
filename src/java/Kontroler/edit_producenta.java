/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontroler;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Sylwester
 */

@WebServlet("/edit_producenta")
public class edit_producenta extends HttpServlet implements java.io.Serializable{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            String id = request.getParameter("id");
            String nazwa = request.getParameter("nazwa");        
            String opis = request.getParameter("opis");
            Date data_od = df.parse(request.getParameter("rokpow"));
            Date data_do = df.parse(request.getParameter("rokzak"));
     
          
            Producenci producenci = new Producenci();
            producenci.edit(id, nazwa, opis, data_od, data_do);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            response.sendRedirect("error.jsp");
        }
        
        response.sendRedirect("all_ekspo.jsp");
}
}