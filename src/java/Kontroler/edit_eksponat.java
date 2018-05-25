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
@WebServlet("/edit_eksponat")
public class edit_eksponat extends HttpServlet implements java.io.Serializable {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try {
            String id = request.getParameter("id");
            String nazwa = request.getParameter("nazwa");
            Lokalizacja lokalizacja = new Lokalizacja();
            String lok = request.getParameter("lokalizacja");
            Kategorie kategoria = new Kategorie();
            String kat = request.getParameter("kategoria");
            Kontroler.Producenci producent = new Kontroler.Producenci();
            String pro = request.getParameter("producenci");

            String opis = request.getParameter("opis");
            Date data_od = df.parse(request.getParameter("rokpow"));
            Date data_do = df.parse(request.getParameter("rokzakpro"));

            Eksponat eksponat = new Eksponat();

            Integer x = Integer.parseInt(id);

            eksponat.edit(id, nazwa, opis, data_od, data_do, kategoria.getKategoria(kat), lokalizacja.getLoklaizacja(lok), producent.getProducent(pro));
            String link = "singleekspo.jsp?id=" + id;
            response.sendRedirect(link);

        } catch (Exception e) {
            System.err.println(e.getMessage());
            response.sendRedirect("error.jsp");
        }

    }

}
