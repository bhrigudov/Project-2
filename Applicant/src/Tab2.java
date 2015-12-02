

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Tab2
 */
@WebServlet("/Tab2")
public class Tab2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tab2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String x = request.getParameter("xp");
		String xp = request.getParameter("x");
		String yopx = request.getParameter("yopx");
		String xii = request.getParameter("xii");
		String xiip = request.getParameter("xiip");
		String yopxii = request.getParameter("yopxii");
		String degree = request.getParameter("degree");
		String department = request.getParameter("department");
		String college = request.getParameter("college");
		String university = request.getParameter("university");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String yog = request.getParameter("yog");
		String cgpa = request.getParameter("cgpa");
		String cgpa1 = request.getParameter("cgpa1");
		String cgpa2 = request.getParameter("cgpa2");
		String marks = request.getParameter("marks");
		String achievements = request.getParameter("achievements");
		System.out.println(achievements);
		String cv = request.getParameter("CV");
		String resume = request.getParameter("Resume");
		System.out.println(cv+" " + resume);
		String total = null;
		if(request.getParameter("cgpa").equals("CGPA")){
			total = request.getParameter("cgpa1");
		}
		else{
			total = request.getParameter("marks");
		}
		
		/////////////////////////////////////////////////////////////
		Integer counter1 = 0,abc1 = 0;
		String unique_id1 = null;
		File f1 = new File("C:\\Users\\Avadh Yadav\\Downloads\\workspace\\Applicant\\src\\Test.txt");
		if(!f1.exists()){
			counter1 = 201500001;
			unique_id1 = "" + 201500001;
		}
		else{
			try {
				Scanner in = new Scanner(new File("C:\\Users\\Avadh Yadav\\Downloads\\workspace\\Applicant\\src\\Test.txt"));
				if(in.hasNextLine())
				{
					abc1 = in.nextInt();
					System.out.println(abc1);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	counter1 = abc1+1;
    		unique_id1 = "" + counter1;
		}
		
		/////////////////////////////////////////////////////////////
		File sourceFile = new File(cv);

		File destFile = new File("C:\\Users\\Avadh Yadav\\Downloads\\workspace\\Applicant\\src\\CV\\" + unique_id1 + ".pdf");

		/* verify whether file exist in source location */
		if (!sourceFile.exists()) {
			System.out.println("Source File Not Found!");
		}

		/* if file not exist then create one */
		if (!destFile.exists()) {
			try {
				destFile.createNewFile();
				
				System.out.println("Destination file doesn't exist. Creating one!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		FileChannel source = null;
		FileChannel destination = null;

		try {

			/**
			 * getChannel() returns unique FileChannel object associated a file
			 * output stream.
			 */
			source = new FileInputStream(sourceFile).getChannel();

			destination = new FileOutputStream(destFile).getChannel();

			if (destination != null && source != null) {
				destination.transferFrom(source, 0, source.size());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			if (source != null) {
				try {
					source.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (destination != null) {
				try {
					destination.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		//////////////////////////////////////////////////////////////
		
		File sourceFile1 = new File(resume);

		File destFile1 = new File("C:\\Users\\Avadh Yadav\\Downloads\\workspace\\Applicant\\src\\SOP\\" + unique_id1 + ".pdf");

		/* verify whether file exist in source location */
		if (!sourceFile1.exists()) {
			System.out.println("Source File Not Found!");
		}

		/* if file not exist then create one */
		if (!destFile1.exists()) {
			try {
				destFile1.createNewFile();
				
				System.out.println("Destination file doesn't exist. Creating one!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		FileChannel source1 = null;
		FileChannel destination1 = null;

		try {

			/**
			 * getChannel() returns unique FileChannel object associated a file
			 * output stream.
			 */
			source1 = new FileInputStream(sourceFile1).getChannel();

			destination1 = new FileOutputStream(destFile1).getChannel();

			if (destination1 != null && source1 != null) {
				destination1.transferFrom(source1, 0, source1.size());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			if (source1 != null) {
				try {
					source1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (destination1 != null) {
				try {
					destination1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		///////////////////////////////////////////////////////////////////////////////////
		
		PrintWriter bw1 = new  PrintWriter(new FileWriter("C:\\Users\\Avadh Yadav\\Downloads\\workspace\\Applicant\\src\\Input.txt",true));
    	bw1.print(x + "," + xp + "," + yopx + "," + xii + "," + xiip + "," + yopxii + "," + degree + "," + department + "," + college + "," + university + "," + city + "," + state + "," + yog + "," + total + "," + achievements + ",");                         
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
	    	bw.println("");
	    	bw.println("");
	    	bw.println("Educational Information");
	    	bw.println("");
	    	bw.println("");
	    	bw.println("Xth Board: 			"+ x);
	    	bw.println("Xth Board(%): 			"+ xp);
	    	bw.println("Year of Passing Xth: 			"+ yopx);
	    	bw.println("XIIth Board: 			"+ xii);
	    	bw.println("XIIth Board(%): 			"+ xiip);
	    	bw.println("Year of Passing XIIth: 			"+ yopxii);
	    	bw.println("");
	    	bw.println("");
	    	bw.println("");
	    	bw.println("Graduation Information");
	    	bw.println("");
	    	bw.println("");
	    	bw.println("Degree 			" + degree);
	    	bw.println("Department			" + department);
	    	bw.println("College				" + college);
	    	bw.println("University			" + university);
	    	bw.println("City				" + city);
	    	bw.println("State			" + state);
	    	bw.println("Year of Graduation			" + yog);
	    	bw.println("Achievements		" + achievements);
	    	
	    	
	    	
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
	    	bw.println("");
	    	bw.println("");
	    	bw.println("Educational Information");
	    	bw.println("");
	    	bw.println("");
	    	bw.println("Xth Board: 			"+ x);
	    	bw.println("Xth Board(%): 			"+ xp);
	    	bw.println("Year of Passing Xth: 			"+ yopx);
	    	bw.println("XIIth Board: 			"+ xii);
	    	bw.println("XIIth Board(%): 			"+ xiip);
	    	bw.println("Year of Passing XIIth: 			"+ yopxii);
	    	bw.println("");
	    	bw.println("");
	    	bw.println("");
	    	bw.println("Graduation Information");
	    	bw.println("");
	    	bw.println("");
	    	bw.println("Degree 			" + degree);
	    	bw.println("Department			" + department);
	    	bw.println("College				" + college);
	    	bw.println("University			" + university);
	    	bw.println("City				" + city);
	    	bw.println("State			" + state);
	    	bw.println("Year of Graduation			" + yog);
	    	bw.println("Achievements		" + achievements);
	    	
			bw.close();
		}
		
		
		
		String site = new String("/Applicant/Tab2_1_1.html");
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
