/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontroler;

import Model.Eksponaty_;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.codec.binary.Base64;

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
        
        try {
            String nazwa = request.getParameter("nazwa");
            Lokalizacja lokalizacja = new Lokalizacja();
            String lok = request.getParameter("lokalizacja");
            Kategorie kategoria = new Kategorie();
            String kat = request.getParameter("kategoria");
            Producenci producent = new Producenci();
            String pro = request.getParameter("producenci");
            
            String opis = request.getParameter("opis");
            Date data_od = df.parse(request.getParameter("rokpow"));
            Date data_do = df.parse(request.getParameter("rokzakpro"));
            String zdj = request.getParameter("zdj");
            
             File f =  new File("C:/test/test.jpg");
             String encodstring = encodeFileToBase64Binary(f);
             System.out.println(encodstring);
            
            
            
            
            Eksponat eksponat = new Eksponat(nazwa, opis, data_od, data_do, encodstring, kategoria.getKategoria(kat), lokalizacja.getLoklaizacja(lok), producent.getProducent(pro));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            response.sendRedirect("error.jsp");
        }
        
        response.sendRedirect("panel_add.jsp");
    }
           private static String encodeFileToBase64Binary(File file){
            String encodedfile = null;
            try {
                FileInputStream fileInputStreamReader = new FileInputStream(file);
                byte[] bytes = new byte[(int)file.length()];
                fileInputStreamReader.read(bytes);
                encodedfile = new String(Base64.encodeBase64(bytes), "UTF-8");
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return encodedfile;
        }
}
