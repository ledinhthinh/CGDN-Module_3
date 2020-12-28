package controller;

import common.Validate;
import data.*;
import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    private EmployeeDAO employeeDAO = new EmployeeDAO();
    private PositionDAO positionDAO = new PositionDAO();
    private EducationDegreeDAO educationDegreeDAO = new EducationDegreeDAO();
    private DivisionDAO divisionDAO = new DivisionDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertEmployee(request, response);
                    break;
                case "edit":
                    updateEmployee(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String employee_id = request.getParameter("employee_id");
        String message1 = Validate.validateEmId(employee_id);
        String employee_name = request.getParameter("employee_name");
        String message2 = Validate.validateName(employee_name);
        String employee_birthday = request.getParameter("employee_birthday");
        String message3 = Validate.validateDate(employee_birthday);
        String employee_id_card = request.getParameter("employee_id_card");
        String message4 = Validate.validateIdCard(employee_id_card);
        String employee_salary = request.getParameter("employee_salary");
        String message5 = Validate.validateAmount(employee_salary);
        String employee_phone = request.getParameter("employee_phone");
        String message6 = Validate.validatePhone(employee_phone);
        String employee_email = request.getParameter("employee_email");
        String message7 = Validate.validateEmail(employee_email);
        String employee_address = request.getParameter("employee_address");
        Position position = positionDAO.selectPositionNote(Integer.parseInt(request.getParameter("position_id")));
        EducationDegree educationDegree = educationDegreeDAO.selectEducationDegreeNote(Integer.parseInt(request.getParameter("education_degree_id")));
        Division division = divisionDAO.selectDivisionNote(Integer.parseInt(request.getParameter("division_id")));
        Employee newEmployee = new Employee(employee_id, employee_name, employee_birthday, employee_id_card, employee_salary,
                employee_phone, employee_email, employee_address, position, educationDegree, division);


        try {
            if (message1 == null && message2 == null&&message3 == null&&message4 == null&&message5 == null&&message6==null&&message7==null) {
                EmployeeDAO.insertEmployee(newEmployee);
                response.sendRedirect("/employee");
            }else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
                request.setAttribute("employee",newEmployee);
                request.setAttribute("message1",message1);
                request.setAttribute("message2",message2);
                request.setAttribute("message3",message3);
                request.setAttribute("message4",message4);
                request.setAttribute("message5",message5);
                request.setAttribute("message6",message6);
                request.setAttribute("message7",message7);
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        listCustomer(request,response);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
//        dispatcher.forward(request, response);
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String employee_id = request.getParameter("employee_id");
        String employee_name = request.getParameter("employee_name");
        String employee_birthday = request.getParameter("employee_birthday");
        String employee_id_card = request.getParameter("employee_id_card");
        String employee_salary = request.getParameter("employee_salary");
        String employee_phone = request.getParameter("employee_phone");
        String employee_email = request.getParameter("employee_email");
        String employee_address = request.getParameter("employee_address");
        Position position = positionDAO.selectPositionNote(Integer.parseInt(request.getParameter("position_id")));
        EducationDegree education_degree = educationDegreeDAO.selectEducationDegreeNote(Integer.parseInt(request.getParameter("education_degree_id")));
        Division division = divisionDAO.selectDivisionNote(Integer.parseInt(request.getParameter("division_id")));
        Employee book = new Employee(employee_id, employee_name, employee_birthday, employee_id_card, employee_salary,
                employee_phone, employee_email, employee_address, position, education_degree, division);

        EmployeeDAO.updateEmployee(book);
        response.sendRedirect("/employee");
//        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");
//        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteEmployee(request, response);
                    break;
                default:
                    listEmployee(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Employee> listEm = EmployeeDAO.selectAllEmployees();
        List<Position> listPos = positionDAO.selectAllPosition();
        List<EducationDegree> listEdu = educationDegreeDAO.selectAllEducationDegree();
        List<Division> listDiv = divisionDAO.selectAllDivision();
        request.setAttribute("listEm", listEm);
        request.setAttribute("listPos", listPos);
        request.setAttribute("listEdu", listEdu);
        request.setAttribute("listDiv", listDiv);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String employee_id = request.getParameter("id");
        Employee employee = employeeDAO.selectEmployee(employee_id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/edit.jsp");
        request.setAttribute("employee", employee);
        dispatcher.forward(request, response);

    }


    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String employee_id = request.getParameter("id");
        employeeDAO.deleteEmployee(employee_id);
        response.sendRedirect("/employee");

//        List<Customer> listCustomer = CustomerDAO.selectAllCustomers();
//        request.setAttribute("listCustomer", listCustomer);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
//        dispatcher.forward(request, response);
    }

}
