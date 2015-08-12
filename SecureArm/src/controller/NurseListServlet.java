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

import dao.NurseDao;
import dao.PatientDao;
import daoImpl.NurseDaoImpl;
import daoImpl.PatientDaoImpl;
import domain.Nurse;
import domain.Patient;

/**
 * Servlet implementation class NurseListServlet
 */
@WebServlet("/NurseListServlet")
public class NurseListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NurseListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<Nurse> nurseList;
   		NurseDao dao=new NurseDaoImpl();
		try{
		nurseList = dao.getAllNurses();
		//System.out.println(deptList.size());
		request.getSession().setAttribute("nurseList",nurseList);
		
		
		ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/nurselist.jsp");
        dispatch.forward(request, response);
        
        }
		catch(Exception ex){
			ex.printStackTrace();
	}
 }

		
		
	}

	


