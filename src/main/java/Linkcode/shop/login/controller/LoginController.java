package Linkcode.shop.login.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Linkcode.shop.implementation.LoginDao;
import Linkcode.shop.implementation.loginImplematation;
import Linkcode.shop.login.model.Login;


/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String s1=request.getParameter("username");
		String s2=request.getParameter("password");
		PrintWriter out=response.getWriter();
		LoginDao ls=new loginImplematation();
		Linkcode.shop.login.model.Login lobj=new Linkcode.shop.login.model.Login(s1,s2);
		List<Login> lst=new ArrayList<Login>();
		lst.add(lobj);
		String msg=ls.validateUser(lst);
		if(msg.equals("valid")) {
			response.sendRedirect("Dashboard.html");
		}
		else {
			HttpSession session=request.getSession();
			session.setAttribute("msg", msg);
			
			response.sendRedirect("Login.html");
			
		}
		if(s1.equals("admin")) {
			if(s2.equals("admin")) {
				response.sendRedirect("Admin.html");
			}
		}
		
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
