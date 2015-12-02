

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
 * Servlet implementation class Tab1
 */
@WebServlet("/Tab1")
public class Tab1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tab1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		System.out.println("sfgefewfsfesgrdgdrgd");
		String phd = request.getParameter("phd");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String enroll_no = request.getParameter("enroll_no");
		String aoc = request.getParameter("aoc");
		String mobile = request.getParameter("mobile");
		String gender = request.getParameter("gender");
		String category = request.getParameter("category");
		String disabled = request.getParameter("disabled");
		String dob = request.getParameter("dob");
		System.out.println(dob);
		String defense = request.getParameter("defense");
		String father = request.getParameter("father");
		String nationality = request.getParameter("nationality");
		String padd = request.getParameter("padd");
		String pcode = request.getParameter("pcode");
		
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
			bw.println("Personal Information");
	    	bw.println("");
	    	bw.println("Enrollment Number: 			"+ enroll_no);
	    	bw.println("Name: 					"+ name);
	    	bw.println("Email: 					"+ email);
	    	bw.println("Mobile No.: 				"+ mobile);
	    	bw.println("Correspondance Address: 		"+ aoc);
	    	bw.println("Permanent Address: 			"+ padd);
	    	bw.println("Pin Code: 				"+ pcode);
	    	bw.println("DOB: 					"+ dob);
	    	bw.println("Father's Name: 				"+ father);
	    	bw.println("Gender: 				"+ gender);
	    	bw.println("Is Disabled: 				"+ disabled);
	    	bw.println("Is a Child/Widow or army personnel:	"+ defense);
	    	bw.println("Nationality: 				"+ nationality);
	    	bw.println("Category: 				"+ category);
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
			bw.println("Personal Information");
	    	bw.println("");
	    	bw.println("Enrollment Number: 			"+ enroll_no);
	    	bw.println("Name: 					"+ name);
	    	bw.println("Email: 					"+ email);
	    	bw.println("Mobile No.: 				"+ mobile);
	    	bw.println("Correspondance Address: 		"+ aoc);
	    	bw.println("Permanent Address: 			"+ padd);
	    	bw.println("Pin Code: 				"+ pcode);
	    	bw.println("DOB: 					"+ dob);
	    	bw.println("Father's Name: 				"+ father);
	    	bw.println("Gender: 				"+ gender);
	    	bw.println("Is Disabled: 				"+ disabled);
	    	bw.println("Is a Child/Widow or army personnel:	"+ defense);
	    	bw.println("Nationality: 				"+ nationality);
	    	bw.println("Category: 				"+ category);
			bw.close();
		}
		
		File r = new File("C:\\Users\\Avadh Yadav\\Downloads\\workspace\\Applicant\\src\\Input.txt");
		if(!r.exists())
		{
			
			try {
				r.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			PrintWriter bw3 = new  PrintWriter(new FileWriter("C:\\Users\\Avadh Yadav\\Downloads\\workspace\\Applicant\\src\\Final.txt",true));
	    	bw3.println("Email,Name,Address of Correspondence,Mobile,PhD Stream,PhD Area Preference 1,PhD Area Preference 2,PhD Area Preference 3,Gender,Category,Physically Disabled,DOB,Children/War Widows of Defence Personnel killed/Disabled in Action,Father's Name,Nationality,Permanent Address,Pin Code,Xth Board,Xth Marks (%),Year of Passing Xth,XIIth Board,XIIth Marks (%),Year of Passing XIIth,Graduation Degree,Graduation Department,Graduation College,Graduation University,Graduation City,Graduation State,Year of Graduation,Grad CGPA or Marks,Applying for ECE PhD,ECE PhD Subject Preference 1,ECE PhD Subject Preference 2,ECE PhD Subject Preference 3,ECE PhD Subject Preference 4,Completed Post Grad,Post Grad Degree,Post Grad Department,Post Grad College,Post Grad Thesis,Post Grad City,Post Grad State,Year of Post Grad,Post Grad CGPA or Marks,Other Academic Degrees,Exam Name,Subject,Year,Score,Rank,Taken GATE Exam,GATE Area,Year of Graduation,Marks(%),Score,Rank,Achievements,Timestamp,EnrollmentNo");                
	        bw3.close();
			
			try {
		    	
		    	PrintWriter bw = new  PrintWriter(new FileWriter("C:\\Users\\Avadh Yadav\\Downloads\\workspace\\Applicant\\src\\Input.txt",true));
		    	bw.print(email + "," + name + "," + aoc + "," + mobile + "," + phd + "," + gender + "," + category + "," + disabled + "," + dob + "," + defense + "," + father + "," + nationality + "," + padd + "," + pcode + ",");                         
		        bw.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		        
		    }
		}
		else
		{
			Scanner in = new Scanner(new File("C:\\Users\\Avadh Yadav\\Downloads\\workspace\\Applicant\\src\\Input.txt"));
			PrintWriter writer = null;
			try {
				writer = new PrintWriter("C:\\Users\\Avadh Yadav\\Downloads\\workspace\\Applicant\\src\\Input.txt");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	writer.print("");
        	writer.close();
        	try {
		    	
		    	PrintWriter bw = new  PrintWriter(new FileWriter("C:\\Users\\Avadh Yadav\\Downloads\\workspace\\Applicant\\src\\Input.txt",true));
		    	bw.print(email + "," + name + "," + aoc + "," + mobile + "," + phd + "," + gender + "," + category + "," + disabled + "," + dob + "," + defense + "," + father + "," + nationality + "," + padd + "," + pcode + ",");                         
		        bw.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		        
		    }
		}
		
		if(phd.compareTo("cs") == 0)
		{
			String site = new String("/Applicant/Tab1_1.html");
		    response.setStatus(response.SC_MOVED_TEMPORARILY);
		    response.setHeader("Location", site);
		}
		else if(phd.compareTo("ece") == 0)
		{
			String site = new String("/Applicant/Tab1_2.html");
		    response.setStatus(response.SC_MOVED_TEMPORARILY);
		    response.setHeader("Location", site);
		}
		else if(phd.compareTo("cb") == 0)
		{
			String site = new String("/Applicant/Tab1_3.html");
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
