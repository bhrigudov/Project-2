

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileUtils;

/**
 * Servlet implementation class PrintResult
 */
@WebServlet("/PrintResult")
public class PrintResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ArrayList<String> selected_ids = new ArrayList<String>();
	private static HashMap<String, HashMap<String, String>> hash_map = new HashMap<String, HashMap<String, String>>();
	       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrintResult() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fileName = request.getParameter("filename");
		String fullPath = "/Users/Bhrigu/Desktop/Codes/JavaWeb/PhD-Admissions/src/applicant_info/"+fileName;
		File f = new File(fullPath);
		
		Desktop.getDesktop().edit(f);
		
		showResult(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	void initVariables( HttpServletRequest request, HttpServletResponse response, ArrayList<String> selected_ids, HashMap<String, HashMap<String, String>> hash_map) throws ServletException, IOException {
		this.selected_ids = selected_ids;
		this.hash_map = hash_map;
		
		showResult(request, response);
	}
	
	private void showResult(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//initVariables(selected_ids, hash_map);

		out.print("<form action=\"BackButtonController\" method=\"get\">");
			out.print("<input type=\"submit\" name=\"back\" value=\"Back\">");
		out.print("</form>");

		out.print("<h1>Filtered Result</h1>");
		
		out.print("<table>");
		
		out.print("<th>Enrollment ID</th>");
		out.print("<th>Name</th>");
		out.print("<th>Link to Data</th>");
		
		String applicantName;
		for(String id : selected_ids) {
			applicantName = hash_map.get(id).get("name");
			
			out.print("<tr>");
			
			out.print("<td>" +id+ "</td>");
			out.print("<td>" +applicantName + "</td>");
			out.print("<td>");
				out.print("<form action=\"PrintResult\" method=\"get\">");
					out.print("<input type=\"hidden\" name=\"filename\" value=\""+id+".txt"+"\">");
					out.print("<input type=\"submit\" value=\"open CV\">");
				out.print("</form>");
			out.print("</td>");
			
			out.print("</tr");
			out.print("<br>");
		}
		
		out.print("</table>");
		out.print("</form>");
	}

}
