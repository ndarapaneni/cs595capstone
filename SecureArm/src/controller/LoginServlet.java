package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegistrationDao;
import daoImpl.RegistrationDaoImpl;
import domain.Register;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String emailid = request.getParameter("emailid");
	    String password = request.getParameter("password");
	  
	  
	    if (emailid ==""|| password == "") {

	    	String message="Invalid Login  Please register if not an user or try again";
			request.setAttribute("message",message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/loginfailure.jsp");
			dispatcher.forward( request, response ); 
	    
	    }
	    
	    try{
	    	RegistrationDao regdao=new RegistrationDaoImpl();
	    	//Register reg=new Register();
			
				int regid = regdao.validateLogin(emailid,password);
			
	    	HttpSession session=request.getSession();
	    	if(regid!=0){
	    	session.setAttribute("regid",regid);
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("/services.jsp");
	    	dispatcher.forward( request, response );
	    	}
	    
	    	else{
	    	String message="Invalid Login  Please register if not an user or try again";
	    	request.setAttribute("message",message);
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("/loginfailure.jsp");
	    	dispatcher.forward( request, response ); 
	    	}
	    }
	    catch(Exception ex){
	    	ex.printStackTrace();
	    }
	    
		}

	

	}


