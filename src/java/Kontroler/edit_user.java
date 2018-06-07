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
@WebServlet("/editUser")
public class edit_user extends HttpServlet implements java.io.Serializable{
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String id =request.getParameter("id").toString();
                
        String imie = request.getParameter("imie");
        String nazwisko = request.getParameter("nazwisko");
        String adres=request.getParameter("adres");
        String telefon=request.getParameter("telefon");
        String email=request.getParameter("email");
        String password=request.getParameter("pass");
        Stanowisko stanowisko=new Stanowisko();
       
          

       
        
        try{
            Osoba osoba=new Osoba();
            osoba.edit(id, imie, nazwisko, adres, telefon, password, email, stanowisko.getStanowisko(request.getParameter("stanowisko")));
          
            response.sendRedirect("all_ekspo.jsp");
            
        }catch(Exception e){
            System.err.println(e.getMessage());
            response.sendRedirect("error.jsp");
        }
 
    }
    
}
