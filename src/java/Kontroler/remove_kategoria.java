/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontroler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sylwester
 */
@WebServlet("/remove_kategoria")
public class remove_kategoria extends HttpServlet implements java.io.Serializable{
       protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        
 
      try{  
        String id = request.getParameter("remove_kategoria");
        Kategorie kat = new Kategorie();
        kat.remove(id);
              } catch (Exception e) {
            System.err.println(e.getMessage());
            response.sendRedirect("error.jsp");
        }
    response.sendRedirect("all_ekspo.jsp");
}
}