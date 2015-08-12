package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeviceReadingDao;
import dao.PatientDao;
import daoImpl.DeviceReadingDaoImpl;
import daoImpl.PatientDaoImpl;
import domain.DeviceReading;
import domain.Patient;

/**
 * Servlet implementation class DeviceDetailServlet
 */
@WebServlet("/DeviceDetailServlet")
public class DeviceDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeviceDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<DeviceReading> detailsList;
   		DeviceReadingDao dao=new DeviceReadingDaoImpl();
		try{
		detailsList = dao.getAll();
		//System.out.println(deptList.size());
		request.getSession().setAttribute("detailsList",detailsList);
		
		
		ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/devicedetailslist.jsp");
        dispatch.forward(request, response);
        
        }
		catch(Exception ex){
			ex.printStackTrace();
	}
 }

	
	

	}

	

