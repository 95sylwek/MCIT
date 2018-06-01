/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontroler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.http.fileupload.IOUtils;

/**
 *
 * @author Sylwester
 */
@WebServlet("/addExhibit")
public class addExhibit extends HttpServlet implements java.io.Serializable {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html");

        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
       
        try {
            String nazwa = request.getParameter("nazwa");
            System.out.println(nazwa+"nazwa");
            Lokalizacja lokalizacja = new Lokalizacja();
            String lok = request.getParameter("lokalizacja");
            System.out.println(lok+"lok");
            Kategorie kategoria = new Kategorie();
            String kat = request.getParameter("kategoria");
            System.out.println(kat+"kat");
            Producenci producent = new Producenci();
            String pro = request.getParameter("producenci");
            System.out.println(pro+"pro");

            String opis = request.getParameter("opis");
            System.out.println(opis+"opis");
            Date data_od = df.parse(request.getParameter("rokpow"));
            System.out.println(data_od+"rok1");
            Date data_do = df.parse(request.getParameter("rokzakpro"));
            System.out.println(data_do+"rok2");
            String zdj = request.getParameter("zdj");
            System.out.println(zdj+"zdj");

            Eksponat eksponat = new Eksponat(nazwa, opis, data_od, data_do, zdj, kategoria.getKategoria(kat), lokalizacja.getLoklaizacja(lok), producent.getProducent(pro));
            response.sendRedirect("panel_add.jsp");
        } catch (Exception e) {
            System.err.println(e.toString());
            response.sendRedirect("error.jsp");
        }        
    }
}
