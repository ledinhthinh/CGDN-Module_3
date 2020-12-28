package controller;

import common.Validate;
import data.CustomerDAO;
import data.CustomerTypeDAO;
import data.ICustomerDAO;
import data.ICustomerTypeDAO;
import model.Customer;
import model.CustomerType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet" ,urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    private ICustomerDAO iCustomerDAO;
    private CustomerDAO customerDAO = new CustomerDAO();
    private CustomerTypeDAO customerTypeDAO = new CustomerTypeDAO();
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
                    insertCustomer(request, response);
                    break;
                case "edit":
                    updateCustomer(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String customer_id = request.getParameter("customer_id");
        String message1 = Validate.validateCusId(customer_id);
        String customer_name = request.getParameter("customer_name");
        String message2 = Validate.validateName(customer_name);
        String customer_birthday = request.getParameter("customer_birthday");
        String message3 = Validate.validateDate(customer_birthday);
        String customer_gender = request.getParameter("customer_gender");
        String customer_id_card = request.getParameter("customer_id_card");
        String message4 = Validate.validateIdCard(customer_id_card);
        String customer_phone = request.getParameter("customer_phone");
        String message5 = Validate.validatePhone(customer_phone);
        String customer_email = request.getParameter("customer_email");
        String message6 = Validate.validateEmail(customer_email);
        String customer_address = request.getParameter("customer_address");
//        String customer_type_id = request.getParameter("customer_type_id");
        CustomerType customer_type_id = customerTypeDAO.selectTypeNote(Integer.parseInt(request.getParameter("customer_type_id")));
        Customer newCustomer = new Customer(customer_id,customer_name, customer_birthday, customer_gender, customer_id_card,
                customer_phone, customer_email, customer_address, customer_type_id);
//        System.out.println(message);
        try {
            if (message1 == null && message2 == null&&message3 == null&&message4 == null&&message5 == null&&message6==null) {
                CustomerDAO.insertCustomer(newCustomer);
                response.sendRedirect("/customer");
            }else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
                request.setAttribute("customer",newCustomer);
                request.setAttribute("message1",message1);
                request.setAttribute("message2",message2);
                request.setAttribute("message3",message3);
                request.setAttribute("message4",message4);
                request.setAttribute("message5",message5);
                request.setAttribute("message6",message6);
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


//        listCustomer(request,response);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
//        dispatcher.forward(request, response);
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String customer_id = request.getParameter("id");
        String customer_name = request.getParameter("name");
        String customer_birthday = request.getParameter("birthday");
        String customer_gender = request.getParameter("gender");
        String customer_id_card = request.getParameter("id_card");
        String customer_phone = request.getParameter("phone");
        String customer_email = request.getParameter("email");
        String customer_address = request.getParameter("address");
//        String customer_type_id = request.getParameter("customer_type_id");
        CustomerType customer_type_id = customerTypeDAO.selectTypeNote(Integer.parseInt(request.getParameter("customer_type_id")));

        Customer book = new Customer(customer_id,customer_name, customer_birthday, customer_gender, customer_id_card,
                customer_phone, customer_email, customer_address, customer_type_id);
        CustomerDAO.updateCustomer(book);
        response.sendRedirect("/customer");
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
                    deleteCustomer(request, response);
                    break;
                default:
                    listCustomer(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Customer> listCus = CustomerDAO.selectAllCustomers();
        List<CustomerType> listCusType = customerTypeDAO.selectAllCustomerType();
        request.setAttribute("listCus", listCus);
        request.setAttribute("listCustype",listCusType);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Customer customer = new Customer();
        request.setAttribute("customer",customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String customer_id = request.getParameter("id");
        Customer customer = customerDAO.selectCustomer(customer_id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        request.setAttribute("customer", customer);
        dispatcher.forward(request, response);

    }


    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String customer_id =request.getParameter("id");
        CustomerDAO.deleteCustomer(customer_id);
        response.sendRedirect("/customer");

//        List<Customer> listCustomer = CustomerDAO.selectAllCustomers();
//        request.setAttribute("listCustomer", listCustomer);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
//        dispatcher.forward(request, response);
    }
//    private void listCustomerByKeyword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String name = request.getParameter("keyword");
//        List<Customer> customerList = customerService.getCusByName(name);
//        request.setAttribute("listCus", customerList);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
//        dispatcher.forward(request, response);
//    }

}
