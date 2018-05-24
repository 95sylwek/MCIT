/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontroler;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/show_ekspo")
public class show_ekspo extends HttpServlet implements java.io.Serializable{
    

//    public void doGet(HttpServletRequest request,
//              HttpServletResponse response)    throws ServletException, IOException {
//        PrintWriter out = response.getWriter();
//
//        String parametr1 = request.getParameter("id_kat");
//        out.println("Wczytanie 3 parametrow z zadania :");
//        out.println(parametr1);
//        response.sendRedirect("panel_przej_ekspo.jsp");
//
//    }
}