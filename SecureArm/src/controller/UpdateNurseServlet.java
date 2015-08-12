package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NurseDao;
import daoImpl.NurseDaoImpl;

/**
 * Servlet implementation class UpdateNurseServlet
 */
@WebServlet("/UpdateNurseServlet")
public class UpdateNurseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNurseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
		
		int deviceId=Integer.parseInt(request.getParameter("deviceid"));
		String nurseemail=request.getParameter("nurseemail");
		NurseDao dao=new NurseDaoImpl();
		try{	
		 dao.updateNurse(deviceId, nurseemail);
		request.setAttribute("deviceId",deviceId);
		String message="Record updated Successfully";
		request.setAttribute("message", message);
		
		ServletContext context = getServletContext();
		RequestDispatcher dispatch = context.getRequestDispatcher("/updatedemailresult.jsp");
		dispatch.forward(request, response);
		}
		catch(Exception ex){
		ex.printStackTrace();
		}
	

	}

}
