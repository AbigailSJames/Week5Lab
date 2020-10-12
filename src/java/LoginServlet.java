
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 818736
 */
public class LoginServlet extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        HttpSession session = request.getSession();
        String action = request.getParameter("logout");
        if (action!=null && action.equals("logout")){
            session.invalidate();
            session = request.getSession();
            
        }
        
        String username = request.getParameter("username");
        String pswd = request.getParameter("pswd");
        
              
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String username = request.getParameter("username");
        String pswd = request.getParameter("pswd");
        
       if (username == null || username.equals("") || pswd == null || pswd.equals("")){
            request.setAttribute("username", username);
        request.setAttribute("pswd", pswd);
        request.setAttribute("invalid", "Please fill out out the username and the password");
        }
       else{
           AccountService accserv = new AccountService();
           String accservlogin = accserv.login(username, pswd);
       }
    }


}


class AccountService{
    
    protected String login(String username, String password){
        String accept;
        if(username.equals("abe")&& password.equals("passwd")){
             accept =null;
        }
        else{
             accept = "Failed authentication";
        }
        return accept;
    }
    

}