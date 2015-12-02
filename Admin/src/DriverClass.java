

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static java.lang.System.*;
/**
 * Servlet implementation class DriverClass
 */
@WebServlet("/DriverClass")
public class DriverClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DriverClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out2 = response.getWriter();
		
		System.out.println("Entered !");
		
		Functions f = new Functions();
		String email, name, enroll_id, category, gender, phyDis, dob, 
				phd, gDeg, pgDeg, xBoard, xiiBoard, gDept, pgDept, gUni, 
				pgUni, gState, pgState, xPercen, xiiPercen, gPercen, pgPercen, 
				gateScore, applicationDatedFrom, applicationDatedUpto;
		String dobToggle,
				xBoardLT, xBoardE, xBoardGT, xBoardPer,
				xiiBoardLT, xiiBoardE, xiiBoardGT, xiiBoardPer,
				gMarksLT, gMarksE, gMarksGT, gMarksPer,
				pgMarksLT, pgMarksE, pgMarksGT, pgMarksPer,
				gateScoreLT, gateScoreE, gateScoreGT, gateScorePer;

		f.TempParse("/Users/Bhrigu/Desktop/Codes/JavaWeb/PhD-Admissions/src/Data/input.csv", "/Users/Bhrigu/Desktop/Codes/JavaWeb/PhD-Admissions/src/applicant_info/");
		
		name = request.getParameter("name");
		email = request.getParameter("email");
		enroll_id = request.getParameter("enroll_id");
		category = request.getParameter("category");
		gender = request.getParameter("gender");
		phyDis = request.getParameter("phyDis");
		dobToggle = request.getParameter("dobToggle");
		dob = request.getParameter("dob");
		
		phd = request.getParameter("phd");
		gDeg = request.getParameter("gDeg");
		pgDeg = request.getParameter("pgDeg");
		xBoard = request.getParameter("xBoard");
		xiiBoard = request.getParameter("xiiBoard");
		gDept = request.getParameter("gDept");
		pgDept = request.getParameter("pgDept");
		gUni = request.getParameter("gUni");
		pgUni = request.getParameter("pgUni");
		gState = request.getParameter("gState");
		pgState = request.getParameter("pgState");
		xPercen = request.getParameter("xPercen");
		xiiPercen = request.getParameter("xiiPercen");
		gPercen = request.getParameter("gPercen");
		pgPercen = request.getParameter("pgPercen");
		gateScore = request.getParameter("gateScore");
		
		xBoardLT = request.getParameter("xBoardLT");
		xBoardE = request.getParameter(" xBoardE");
		xBoardGT = request.getParameter(" xBoardGT");
		xBoardPer = request.getParameter(" xBoardPer");
		xiiBoardLT = request.getParameter(" xiiBoardLT");
		xiiBoardE = request.getParameter(" xiiBoardE");
		xiiBoardGT = request.getParameter(" xiiBoardGT");
		xiiBoardPer = request.getParameter(" xiiBoardPer");
		gMarksLT = request.getParameter(" gMarksLT");
		gMarksE = request.getParameter(" gMarksE");
		gMarksGT = request.getParameter(" gMarksGT");
		gMarksPer = request.getParameter(" gMarksPer");
		pgMarksLT = request.getParameter(" pgMarksLT");
		pgMarksE = request.getParameter(" pgMarksE");
		pgMarksGT = request.getParameter(" pgMarksGT");
		pgMarksPer = request.getParameter(" pgMarksPer");
		gateScoreLT = request.getParameter(" gateScoreLT");
		gateScoreE = request.getParameter(" gateScoreE");
		gateScoreGT = request.getParameter(" gateScoreGT");
		gateScorePer = request.getParameter(" gateScorePer");
		
		applicationDatedFrom = request.getParameter("applicationDatedFrom");
		applicationDatedUpto = request.getParameter("applicationDatedUpto");
				
		f.textFieldFunc(email,"email");
		f.textFieldFunc(name,"name");
		f.func_enroll_no(enroll_id);
		f.menuFunc(category,"category");
		f.func_gender(gender);
		f.func_phyDis(phyDis);
		try {
			int c = f.func_dob(dob, dobToggle);
			if(c==-1) 	out2.println("Please choose a toggle option!");
			else if(c==0) 	out2.println("Date is not in back!");
			out2.println("<br>");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		f.menuFunc(phd,"phd");
		f.menuFunc(gDeg,"gDeg");
		f.menuFunc(pgDeg,"pgDeg");
		f.menuFunc(xBoard,"xBoard");
		f.menuFunc(xiiBoard,"xiiBoard");
		f.menuFunc(gDept,"gDept");
		f.menuFunc(pgDept,"pgDept");
		
		if(f.checkBoxFunc("xPercen", xBoardLT, xBoardE, xBoardGT, xBoardPer, 0, 100)==false)
			out2.print("invalid entry in X Board marks!<br>");
		if(f.checkBoxFunc("xiiPercen", xiiBoardLT, xiiBoardE, xiiBoardGT, xiiBoardPer, 0, 100)==false)
			out2.print("invalid entry in XII Board marks! <br>");
		if(f.checkBoxFunc("gPercen", gMarksLT, gMarksE, gMarksGT, gMarksPer, 0, 100)==false)
			out2.print("invalid entry in Graduation marks! <br>");
		if(f.checkBoxFunc("pgPercen", pgMarksLT, pgMarksE, pgMarksGT, pgMarksPer, 0, 100)==false)
			out2.print("invalid entry in Post Graduation marks! <br>");
		if(f.checkBoxFunc("gateScore", gateScoreLT, gateScoreE, gateScoreGT, gateScorePer, 0, 1000)==false)
			out2.print("invalid entry in Gate score! <br>");
		
		try {
			f.dateFunc(applicationDatedFrom, "from");
			f.dateFunc(applicationDatedUpto, "upto");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		f.PrintSelectedIds();
		
		if(f.flag==true) {
			//request.getRequestDispatcher("FilteredPage.html").forward(request, response);
			PrintResult pr = new PrintResult();
			
			pr.initVariables(request, response, f.selected_ids, f.hash_map);
		} else {
			request.getRequestDispatcher("FilterOptions.html").include(request, response);
		}
	}

}
