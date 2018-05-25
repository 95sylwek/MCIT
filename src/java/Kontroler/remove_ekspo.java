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
@WebServlet("/remove_ekspo")
public class remove_ekspo extends HttpServlet implements java.io.Serializable {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        try {
            String id = request.getParameter("remove_ekspo");
            Eksponat ek = new Eksponat();
            Kategorie kat = new Kategorie();
            Integer x = Integer.parseInt(id);
            //kat.getKategoria(x.toString()).getEksponatyCollection().remove(ek);
            //ek = null;

            String link = "panel_przej_ekspo.jsp?id=" + ek.getEksponat(x).getKategoria().getIdKategoria();

            ek.remove(id);
            response.sendRedirect(link);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            response.sendRedirect("error.jsp");
        }

    }
}
