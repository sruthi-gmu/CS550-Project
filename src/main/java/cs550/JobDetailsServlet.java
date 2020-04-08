package cs550;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/job")
public class JobDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeBean employee = (EmployeeBean)req.getSession().getAttribute("employeeDetails");
        ProjectBean pr = new ProjectBean();

            pr.setP1("Product X");
            pr.setHr1(req.getParameter("p1"));

            pr.setP2("Product Y");
            pr.setHr2(req.getParameter("p2"));

            pr.setP3("Product Z");
            pr.setHr3(req.getParameter("p3"));

            pr.setP10("Computerization");
            pr.setHr10(req.getParameter("p10"));

            pr.setP20("Reorganization");
            pr.setHr20(req.getParameter("p20"));

            pr.setP30("Newbenifits");
            pr.setHr30(req.getParameter("p30"));

        employee.setProject(pr);
        CompanyDAO dao = CompanyDAO.getInstance();
        dao.saveJobDetails(pr,employee.getSsn());
        req.getParameter("dependent");


        if(req.getParameter("dependent").equals("yes")) {
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
