import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class RegisterExamServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int examId = Integer.parseInt(req.getParameter("exam_id"));
        HttpSession session = req.getSession();
        int studentId = (int) session.getAttribute("student_id");

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO registrations VALUES (reg_seq.NEXTVAL, ?, ?)"
            );

            ps.setInt(1, studentId);
            ps.setInt(2, examId);
            ps.executeUpdate();

            res.sendRedirect("ExamServlet");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
