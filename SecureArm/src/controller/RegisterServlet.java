package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegistrationDao;
import daoImpl.RegistrationDaoImpl;
import domain.Register;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String firstname = request.getParameter("firstname");
	    String lastname = request.getParameter("lastname");
	    String emailid=request.getParameter("emailid");
	    String password=request.getParameter("password");
	    String phonenumber=request.getParameter("phonenumber");
	    String type=request.getParameter("type");
	    
	    Register reg=new Register();
	    
	    reg.setFirstName(firstname);
	    reg.setLastName(lastname);
	    reg.setEmailId(emailid);
	    reg.setPassword(password);
	    reg.setPhoneNumber(Integer.parseInt(phonenumber));
	    reg.setType(type);
	    RegistrationDao regdao=new RegistrationDaoImpl();
	    if ( firstname == null || password == null || lastname==null || emailid==null ||phonenumber==null ||type==null) {

	    	String message="Invalid values. Try again";
			request.setAttribute("message",message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/loginFailure.jsp");
			dispatcher.forward( request, response ); 
	    }
	    else{
	    	try{
	    	regdao.createnewUser(reg);
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
	    	dispatcher.forward( request, response );
	    	}catch(Exception ex){
	    		ex.printStackTrace();
	    	}
	    }
	}


	}


