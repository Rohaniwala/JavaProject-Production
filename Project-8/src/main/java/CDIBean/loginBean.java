/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package CDIBean;

//import CBean.TempData;
import ClassPackage.KeyGenrator;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rohan
 */
@Named(value = "loginBean")
@RequestScoped
public class loginBean {

    @Inject
    SecurityContext ctx;

    private String username;
    private String password;
    private String role;

    private AuthenticationStatus auth;
    @PersistenceContext(unitName = "my_persistence_unit")
    EntityManager em;

    /**
     * Creates a new instance of loginBean
     */
    public loginBean() {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String login() {
//        Credential c = new UsernamePasswordCredential(username, password);
//        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
//        auth = ctx.authenticate(request, response, AuthenticationParameters.withParams().credential(c));
//        if (auth.equals(auth.SUCCESS)) {
//            KeepRecord.setUsername(username);
//            KeepRecord.setPassword(password);
//
////            KeepRecord.setUid(em.createNamedQuery("UserTB.findIDByUsername").setParameter("username", username).getFirstResult());
//
//            String token=KeyGenrator.genratetoken(username);
//            Cookie ck=new Cookie("Admin", token);
//            ck.setMaxAge(8000);
//            ck.setSecure(true);
//            ck.setHttpOnly(true);
//            response.addCookie(ck);
//            if (ctx.isCallerInRole("Admin")) {
//                role = "Admin";
//                KeepRecord.setRole(role);
//
//                return "ProductDisplayAdmin.jsf";
//
//            } else if (ctx.isCallerInRole("User")) {
//
//                role = "User";
//                KeepRecord.setRole(role);
//
//                return "Display.jsf";
//
//            }
//        }
//        return "login.jsf";

Credential c = new UsernamePasswordCredential(username, password);
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        auth = ctx.authenticate(request, response, AuthenticationParameters.withParams().credential(c));
        if (auth.equals(auth.SUCCESS)) {
            KeepRecord.setUsername(username);
            KeepRecord.setPassword(password);
            
            String token=KeyGenrator.genratetoken(username);
            Cookie ck=new Cookie("JWtToken", token);
            
            int uid = (int) em.createNamedQuery("UserTB.findIDByUsername").setParameter("username", username).getSingleResult();
            
            KeepRecord.setUid(uid);
//            TempData.uid = uid;
//                        KeepRecord.setUid(uid);
                TempData.Loginuid = uid;
                
            System.out.println("uid"+uid);
                        
            ck.setMaxAge(8000);
            ck.setSecure(true);
            ck.setHttpOnly(true);
            response.addCookie(ck);

            if (ctx.isCallerInRole("Admin")) {
                role = "Admin";
                return "ProductDisplayAdmin.jsf";
            } else if (ctx.isCallerInRole("User")) {
                role = "User";
                return "Display.jsf";
            }
        }
        return "login.jsf";
    }

    public String logout() throws ServletException {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        session.invalidate();
        request.logout();
        KeepRecord.reset();
        return "login.jsf";
    }
}
