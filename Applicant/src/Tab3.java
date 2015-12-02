

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Tab3
 */
@WebServlet("/Tab3")
public class Tab3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tab3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String present_date = dateFormat.format(date);
        
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        Date time1 = new Date();
        String present_time = timeFormat.format(time1);
        System.out.println(present_date + " " + present_time);
        
        Integer counter = 0, abc = 0;
        String unique_id = null;
        
        File f = new File("C:\\Users\\Avadh Yadav\\Downloads\\workspace\\Applicant\\src\\Test.txt");
        if(!f.exists())
    	{
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			counter = 20150001;
			try {
		    	
		    	PrintWriter bw = new  PrintWriter(new FileWriter("C:\\Users\\Avadh Yadav\\Downloads\\workspace\\Applicant\\src\\Test.txt",true));
		    	bw.println(counter);
		        bw.println();
		        bw.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		        
		    }	
			unique_id = "20150001";
    	}
        else
        {
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
    		PrintWriter writer = null;
			try {
				writer = new PrintWriter("C:\\Users\\Avadh Yadav\\Downloads\\workspace\\Applicant\\src\\Test.txt");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	writer.print("");
        	writer.close();
        	
        	try {
    	    	
    	    	PrintWriter bw = new  PrintWriter(new FileWriter("C:\\Users\\Avadh Yadav\\Downloads\\workspace\\Applicant\\src\\Test.txt",true));
    	    	bw.println(counter);
    	        bw.println();
    	        bw.close();
    	    } catch (IOException e) {
    	        e.printStackTrace();
    	        
    	    }
        }
        
        System.out.println("Unique id generated is : " + counter);
        
        PrintWriter bw2 = new  PrintWriter(new FileWriter("C:\\Users\\Avadh Yadav\\Downloads\\workspace\\Applicant\\src\\Input.txt",true));
    	bw2.print(present_date +  " " + present_time + "," + counter);                         
        bw2.close();
        
        Scanner sc = new Scanner("");
		try {
			sc = new Scanner(new File("C:\\Users\\Avadh Yadav\\Downloads\\workspace\\Applicant\\src\\Input.txt"));
//			System.out.println("file found");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File Not Found");
			e.printStackTrace();
		}
		if(sc.hasNextLine())
		{
			String[] heading = sc.nextLine().split(",");
			System.out.println(heading[0]);
			PrintWriter bw3 = new  PrintWriter(new FileWriter("C:\\Users\\Avadh Yadav\\Downloads\\workspace\\Applicant\\src\\Final.txt",true));
	    	bw3.println(heading[0] + "," + heading[1] + "," + heading[2] + "," + heading[3] + "," + heading[4] + "," + heading[14] + "," + heading[15] + "," + heading[16] + "," + heading[5] + "," + heading[6] + "," + heading[7] + "," + heading[8] + "," + heading[9] + "," + heading[10] + "," + heading[11] + "," + heading[12] + "," + heading[13] + "," + heading[17] + "," + heading[19] + "," + heading[18] + "," + heading[20] + "," + heading[21] + "," + heading[22] + "," + heading[23] + "," + heading[24] + "," + heading[25] + "," + heading[26] + "," + heading[27] + "," + heading[28] + "," + heading[29] + "," + heading[30] + "," + heading[32] + "," + heading[33] + "," + heading[34] + "," + heading[35] + "," + heading[36] + "," + heading[37] + "," + heading[38] + "," + heading[39] + "," + heading[40] + "," + heading[41] + "," + heading[42] + "," + heading[43] + "," + heading[44] + "," + heading[45] + "," + heading[46] + "," + heading[47] + "," + heading[48] + "," + heading[49] + "," + heading[50] + "," + heading[51] + "," + heading[52] + "," + heading[53] + "," + heading[54] + "," + heading[55] + "," + heading[56] + "," + heading[57] + "," + heading[31] + "," + heading[58] + "," + heading[59]);                
	        bw3.close();
		}
        
        
        
        
		String site = new String("/Applicant/Thanks.jsp");
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
