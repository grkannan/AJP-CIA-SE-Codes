import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Raguram
 */
public class cooks extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Cookie c[] = request.getCookies();
        if(c!=null){
            for (Cookie cookie : c) {
                String name = cookie.getName();
                String value = cookie.getValue();
                out.println(name + " => " + value);
            }
        }
        String name = request.getParameter("rno");
        if(name!=null && name.length()>0){
            String value = request.getParameter("name");
            Cookie cookie = new Cookie(name, value);
            response.addCookie(cookie);
            out.println("<html><body>");
            out.println("<h1>Cookie Info: </h1>");
            out.println("Cookie Name : " + name);
            out.println("Value : " + value);
            out.println("</body></html>");
        }
    }
}
