package cs550;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/dependent")
public class DependentDetailsServelet  extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeBean employee = (EmployeeBean)req.getSession().getAttribute("employeeDetails");
        DependentBean db = new DependentBean();
        db.setName(req.getParameter("dependent_name"));
        db.setSex(req.getParameter("sex"));
        db.setDateOfBirth(req.getParameter("bdate"));
        db.setRelationship(req.getParameter("relationship"));
        employee.getDependentList().add(db);
        CompanyDAO dao = CompanyDAO.getInstance();
        dao.saveDependentDetails(db,employee.getSsn());
        if(req.getParameter("moredependent").equals("Y")) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("dependent_details.html");
            dispatcher.forward(req, resp);
        }
        else {
            req.getSession().setAttribute("employeeDetails", employee);
            RequestDispatcher dispatcher = req.getRequestDispatcher("report.jsp");
            dispatcher.forward(req, resp);

        }

    }


}
