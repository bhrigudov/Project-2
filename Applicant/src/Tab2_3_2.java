

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Tab2_3_2
 */
@WebServlet("/Tab2_3_2")
public class Tab2_3_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tab2_3_2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		String exam = request.getParameter("exam");
		String subject = request.getParameter("subject");
		String year = request.getParameter("year");
		String score = request.getParameter("score");
		String rank = request.getParameter("rank");
		
		PrintWriter bw2 = new  PrintWriter(new FileWriter("C:\\Users\\Avadh Yadav\\Downloads\\workspace\\Applicant\\src\\Input.txt",true));
    	bw2.print(exam + "," + subject + "," + year + "," + score + "," + rank + ",");                         
        bw2.close();
        
        
		String site = new String("/Applicant/Tab2_4_1.html");
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
