package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PatientDao;
import daoImpl.PatientDaoImpl;
import domain.Patient;

/**
 * Servlet implementation class PatientListServlet
 */
@WebServlet("/PatientListServlet")
public class PatientListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
List<Patient> patientList;
   		PatientDao dao=new PatientDaoImpl();
		try{
		patientList = dao.getAllPatients();
		//System.out.println(deptList.size());
		request.getSession().setAttribute("patientList",patientList);
		
		
		ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/patientlist.jsp");
        dispatch.forward(request, response);
        
        }
		catch(Exception ex){
			ex.printStackTrace();
	}
 }

	
	}

	


