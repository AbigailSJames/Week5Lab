package servlets;


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
        String action = request.getParameter("action");
        if (action!=null && action.equals("logout")){
            session.invalidate();
            session = request.getSession();
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        {
           
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
              
        
        

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
       String username = request.getParameter("username");
        String pswd = request.getParameter("pswd");
        
       if (username == null || username.equals("") || pswd == null || pswd.equals("")){
            request.setAttribute("username", username);
            request.setAttribute("pswd", pswd);
            request.setAttribute("invalid", "Please fill out out the username and the password");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
       else{
           AccountService accserv = new AccountService();
           User accservlogin = accserv.login(username, pswd);
           if (accservlogin.getPassword() == null ){
               
               getServletContext().getRequestDispatcher("/WEB-INF/home.java").forward(request, response);
               session.setAttribute("username" , username);
               
           }
           else{
                request.setAttribute("username", username);
                request.setAttribute("pswd", pswd);
                request.setAttribute("invalid", "Please fill out out the username and the password");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
       }
    }


}


class AccountService{
    
    public User login(String username, String password){
        User accept = new User(username, password);
        if(username.equals("abe")&& password.equals("password")){
            accept.setUsername("abe");
             accept.setPassword(null);
        }
        else if(username.equals("barb")&& password.equals("password")){
            accept.setUsername("barb");
             accept.setPassword(null);
        }
        else{
             accept = null;
        }
        return accept;
    }
    }

}

class User{
    
    String username;
    String password;
    
    public User(String username, String password){
        this.username = username;
        this.password = password;
        
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    

}