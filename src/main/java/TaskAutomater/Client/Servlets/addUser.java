package TaskAutomater.Client.Servlets;

import java.io.IOException;
import javax.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TaskAutomater.Converter.UserConverter;
import TaskAutomater.Model.UserModel;

/**
 * Servlet implementation class addUser
 */
@WebServlet("/addUser")
public class addUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public addUser() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname, firstName, lastName, email;
		uname = request.getParameter("uname");
		firstName = request.getParameter("firstName");
		lastName = request.getParameter("lastName");
		email  = request.getParameter("email");
		if ((uname == null || uname.equals(""))
				|| (email == null || email.equals(""))) {
			request.setAttribute("error", "Mandatory Parameters Missing");
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/users.jsp");
			rd.forward(request, response);
		} else {
			UserModel user = new UserModel();
			user.setEmail(email);
			user.setFname(firstName);
			user.setLname(lastName);
			user.setUname(uname);
			UserConverter conv = new UserConverter();
			//insert this user to mongo
			conv.toUserModel(user);
		}
		doGet(request, response);
	}

}
