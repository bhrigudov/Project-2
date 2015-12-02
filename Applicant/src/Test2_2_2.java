

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test2_2_2
 */
@WebServlet("/Test2_2_2")
public class Test2_2_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test2_2_2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String college = request.getParameter("college");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String department = request.getParameter("department");
		String degree = request.getParameter("degree");
		String thesis = request.getParameter("thesis");
		String yopg = request.getParameter("yopg");
		String cgpa1 = request.getParameter("cgpa1");
		String cgpa2 = request.getParameter("cgpa2");
		String marks = request.getParameter("marks");
		
		
		String site = new String("/Applicant/Tab2_3_1.html");
	    response.setStatus(response.SC_MOVED_TEMPORARILY);
	    response.setHeader("Location", site);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
