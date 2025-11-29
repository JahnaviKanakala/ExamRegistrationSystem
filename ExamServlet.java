import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class ExamServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM exams");

            req.setAttribute("examList", rs);
            req.getRequestDispatcher("exams.jsp").forward(req, res);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
