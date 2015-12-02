
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.scribe.builder.ServiceBuilder;
import org.scribe.oauth.OAuthService;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    	private static final String CLIENT_ID = "887540913921-pk0hcfhopgfvihrvk46jtoj5egp21tj8.apps.googleusercontent.com"; 
	   private static final String CLIENT_SECRET = "SPNB77zTXKmUXOP9rL1gDBKu";
	  
	   @Override 
	   protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {				 
			   
			      ServiceBuilder builder= new ServiceBuilder(); 
			      OAuthService service = builder.provider(Google2APi.class) 
			         .apiKey(CLIENT_ID)           
			         .apiSecret(CLIENT_SECRET)    
			         .callback("http://localhost:8080/PhD-Admission/OAuth2CallbackServlet")
			      .scope("https://mail.google.com/" + 
			               "https://www.googleapis.com/auth/plus.login" + 
			               "https://www.googleapis.com/auth/plus.me")  
			         .debug() 
			         .build(); //Now build the call
			      HttpSession sess = req.getSession(); 
			      sess.setAttribute("oauth2Service", service);
			      res.sendRedirect(service.getAuthorizationUrl(null)); 
			   } 
	
		/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("email");
		if(email.isEmpty()!=true) {
			request.getRequestDispatcher("Personalinfo.html").forward(request, response);
		} else {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			out.println("Try Again!");
			request.getRequestDispatcher("LoginPage.html").include(request, response);
		}
		
	}

}


	