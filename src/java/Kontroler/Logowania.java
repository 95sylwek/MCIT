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
import Model.Osoba;

@WebServlet("/Logowania")
public class Logowania extends HttpServlet implements java.io.Serializable {

 
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        // request.getRequestDispatcher("link.html").include(request, response);

        String email = request.getParameter("inputEmail");
        String password = request.getParameter("inputPassword");

        Kontroler.Osoba osoba = new Kontroler.Osoba(); 
        Model.Osoba user = new Osoba();
        HttpSession session = request.getSession();
        
        try{
        if(osoba.checkUser(email, password)!= null){
            user = osoba.checkUser(email, password);
            session.setAttribute("id", user.getIdOsoba());
            session.setAttribute("idStanowisko", user.getStanowisko().getIdStanowisko());
            if (user.getStanowisko().getIdStanowisko() == 2) {
                response.sendRedirect("panel_admin.jsp");
            } else {
                response.sendRedirect("admin.jsp");
            }
            
        }else{
            response.sendRedirect("index.jsp");
        }
        }catch(Exception e){
            response.sendRedirect("error.jsp");
        }

    }

    public static void main(String[] args) {
        
    }
}