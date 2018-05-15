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
 * @author Radek
 */
@WebServlet("/show_edit")
public class show_edit extends HttpServlet implements java.io.Serializable{
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        
 
        
        String id = request.getParameter("edit_id_user");
        HttpSession session = request.getSession();
        System.err.println(id);
        session.setAttribute("edit_id_user", id);
        
         response.sendRedirect("panel_edycja.jsp");
  
        
        
    }
}