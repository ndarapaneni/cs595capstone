package controller;

import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeviceReadingDao;
import daoImpl.DeviceReadingDaoImpl;
import domain.DeviceReading;

/**
 * Servlet implementation class PatientDetailsServlet
 */
@WebServlet("/PatientDetailsServlet")
public class PatientDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DeviceReading read= new DeviceReading();
		DeviceReadingDao dao=new DeviceReadingDaoImpl();
		try{
			String patientid=request.getParameter("patientid");
			
		if(patientid.trim().length() == 0){System.out.println("enter valid value ");}
						
		     read  = dao.getAll(Integer.parseInt(patientid));
			
			//request.getSession().setAttribute("empId",empId);
			request.getSession().setAttribute("patientdetails",read);
			
			ServletContext context = getServletContext();
			RequestDispatcher dispatch = context.getRequestDispatcher("/patientdetails.jsp");
			dispatch.forward(request, response);
        }
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}	

	}

	

