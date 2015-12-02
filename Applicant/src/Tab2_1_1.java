

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Tab2_1_1
 */
@WebServlet("/Tab2_1_1")
public class Tab2_1_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tab2_1_1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String ques = request.getParameter("q1");
		
		PrintWriter bw1 = new  PrintWriter(new FileWriter("C:\\Users\\Avadh Yadav\\Downloads\\workspace\\Applicant\\src\\Input.txt",true));
    	bw1.print(ques + ",");                         
        bw1.close();
		String unique_id = null;
		Integer counter = 0,abc = 0;
		File f = new File("C:\\Users\\Avadh Yadav\\Downloads\\workspace\\Applicant\\src\\Test.txt");
		if(!f.exists()){
			counter = 201500001;
			unique_id = "201500001";
			String ava = ""+counter;
			ava = "C:\\Users\\Avadh Yadav\\Downloads\\workspace\\Applicant\\src\\".concat(ava);
			ava = ava.concat(".txt");
			PrintWriter bw = new  PrintWriter(new FileWriter(ava,true));
			bw.println("");
	    	
	    	bw.println("Are you applying for ECE PhD?	" + ques);
	    	
	    	
			bw.close();
		}
		else{
			try {
				Scanner in = new Scanner(new File("C:\\Users\\Avadh Yadav\\Downloads\\workspace\\Applicant\\src\\Test.txt"));
				if(in.hasNextLine())
				{
					abc = in.nextInt();
					System.out.println(abc);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	counter = abc+1;
    		unique_id = "" + counter;
    		
    		String ava = ""+counter;
			ava = "C:\\Users\\Avadh Yadav\\Downloads\\workspace\\Applicant\\src\\".concat(ava);
			ava = ava.concat(".txt");
			
			PrintWriter bw = new  PrintWriter(new FileWriter(ava,true));
			bw.println("");
	    	
	    	bw.println("Are you applying for ECE PhD?	" + ques);
	    	
	    	
			bw.close();
		}
		
		
		if(ques.equals("yes"))
		{
			String site = new String("/Applicant/Tab2_1_2.html");
		    response.setStatus(response.SC_MOVED_TEMPORARILY);
		    response.setHeader("Location", site);
		}
		else if(ques.equals("no"))
		{
			String pref1 = "";
			String pref2 = "";
			String pref3 = "";
			String pref4 = "";
			PrintWriter bw = new  PrintWriter(new FileWriter("C:\\Users\\Avadh Yadav\\Downloads\\workspace\\Applicant\\src\\Input.txt",true));
	    	bw.print(pref1 + "," + pref2 + "," + pref3 + "," + pref4 + ",");                         
	        bw.close();
			String site = new String("/Applicant/Tab2_2_1.html");
		    response.setStatus(response.SC_MOVED_TEMPORARILY);
		    response.setHeader("Location", site);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
