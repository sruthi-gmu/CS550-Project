package cs550;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employee")
public class EmployeeDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeBean employee = new EmployeeBean();
        employee.setFirstName(req.getParameter("fname"));
        employee.setMiddleInitials(req.getParameter("minit"));
        employee.setLastName(req.getParameter("lname"));
        employee.setSsn(req.getParameter("ssn"));
        employee.setDateOfBirth(req.getParameter("bdate"));
        employee.setAddress(req.getParameter("address"));
        employee.setSex(req.getParameter("sex"));
        employee.setSalary(req.getParameter("salary"));
        employee.setSupervisorSsn(req.getParameter("superssn"));
        employee.setDepartmentNumber(req.getParameter("dno"));
        CompanyDAO dao = CompanyDAO.getInstance();
        dao.saveEmployeeDetails(employee);
        req.getSession().setAttribute("employeeDetails", employee);
        RequestDispatcher dispatcher = req.getRequestDispatcher("job_details.html");
        dispatcher.forward(req, resp);

    }

    }
