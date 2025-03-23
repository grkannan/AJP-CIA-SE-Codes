import java.sql.*; 
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raguram
 */
public class JDBC_select extends HttpServlet {
    public void init(ServletConfig sc) throws ServletException {
        super.init(sc);
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDBC_select.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String r = request.getParameter("rno");

        out.println("<html><body>");
        
        String query = "SELECT * FROM APP.STUD WHERE RNO = ?";
        
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/newrk", "root", " ");
             PreparedStatement ps = con.prepareStatement(query)) {
            
            ps.setString(1, r);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                String n = rs.getString("name");
                String m1 = rs.getString("mark1");
                String m2 = rs.getString("mark2");
                String m3 = rs.getString("mark3");
                String tot = rs.getString("total");
                String avg = rs.getString("average");
                
                out.println("Name: " + n + "<br>");
                out.println("Mark 1: " + m1 + "<br>");
                out.println("Mark 2: " + m2 + "<br>");
                out.println("Mark 3: " + m3 + "<br>");
                out.println("Total: " + tot + "<br>");
                out.println("Average: " + avg + "<br>");
            } else {
                out.println("No records found for RNO: " + r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBC_select.class.getName()).log(Level.SEVERE, null, ex);
            out.println("Error retrieving data."+ex);
        }
        
        out.println("</body></html>");
    }
}
