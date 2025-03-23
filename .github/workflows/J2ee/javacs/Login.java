import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String u = request.getParameter("uname");
        String p = request.getParameter("pass");
        out.println(u + " => " + p);
        if(u.equals("name") && p.equals("pass"))
            response.sendRedirect("http://localhost:8080/Practice_App/LoggedIn.html");
        else{
            out.println("<script>{alert(\"Incorrect Username or Password*\");}</script>");
            response.sendRedirect("http://localhost:8080/Practice_App/index.html?m=0");
        }
        
    }
}
