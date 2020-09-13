package mailProtocol;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/mail"})
public class MailProtocol extends HttpServlet {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String to = request.getParameter("to");
        String subject = request.getParameter("subject");
        String message =  request.getParameter("message");
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        out.println( SendMail.send(to,subject, message, user, pass));
    }   
}