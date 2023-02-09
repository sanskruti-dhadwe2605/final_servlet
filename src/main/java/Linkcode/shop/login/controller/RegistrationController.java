package Linkcode.shop.login.controller;

import Linkcode.shop.implementation.RegistrationImpl;
import Linkcode.shop.login.model.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegistrationController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String name=request.getParameter("name");
		String Email=request.getParameter("email");
		int mobileno=Integer.parseInt(request.getParameter("mobilenumber"));
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String Repass=request.getParameter("re-enterpassword");
		PrintWriter out=response.getWriter();
		List<Registeration> lst=new ArrayList<Registeration>();
		RegistrationImpl udao=new RegistrationImpl();
		
		if(password.equals(Repass)) {
			Registeration u=new Registeration(name, Email, mobileno, username,password, Repass);
			lst.add(u);
			int i=udao.create(lst);
			
			if(i>0) {
				out.print("Record Saved");
			}else {
				out.print("Record NOT Saved");
			}
			
		}else {
			out.print("<h3>***..Confirm Password doesnt match..***</h3>");    		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
