package cs550;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/manager")
public class ManagerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String ssn = req.getParameter("mgssn");
       CompanyDAO dao = CompanyDAO.getInstance();
       Boolean rs = dao.isManager(ssn);
       System.out.println(rs);
       if(rs == true) {
           RequestDispatcher dispatcher = req.getRequestDispatcher("employee_details.html");
           dispatcher.forward(req, resp);
       }
       else {
           RequestDispatcher dispatcher = req.getRequestDispatcher("error.html");
           dispatcher.forward(req, resp);

       }
    }

}
