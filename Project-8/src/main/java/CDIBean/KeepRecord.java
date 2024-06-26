/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package CDIBean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Set;
import javax.security.enterprise.CallerPrincipal;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.identitystore.CredentialValidationResult;

/**
 *
 * @author rohan
 */
@Named(value = "keepRecord")
@SessionScoped
public class KeepRecord implements Serializable {
    
    public static String username;  
    public static String password;  
    public static String role;  
    
    public static int uid;

    
    
    private static CredentialValidationResult result;
    private static CallerPrincipal principal;
   private static Set<String> roles;
   private static String token;

      private static String errorStatus;
   private static Credential credential;
    
    
    /**
     * Creates a new instance of KeepRecord
     */
    public KeepRecord() {
        username=null;
        password=null;
        role=null;
        credential=null;
        principal=null;
        errorStatus="";
        roles=null;
        token=null;
        result=null;
        uid=0;
        
    }

    public static String getRole() {
        return role;
    }

    public static void setRole(String role) {
        KeepRecord.role = role;
    }

    
    
    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        KeepRecord.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        KeepRecord.password = password;
    }

    public static int getUid() {
        return uid;
    }

    public static void setUid(int uid) {
        KeepRecord.uid = uid;
    }

 

    public static CredentialValidationResult getResult() {
        return result;
    }

    public static void setResult(CredentialValidationResult result) {
        KeepRecord.result = result;
    }

    public static CallerPrincipal getPrincipal() {
        return principal;
    }

    public static void setPrincipal(CallerPrincipal principal) {
        KeepRecord.principal = principal;
    }

    public static Set<String> getRoles() {
        return roles;
    }

    public static void setRoles(Set<String> roles) {
        KeepRecord.roles = roles;
    }

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        KeepRecord.token = token;
    }

    public static String getErrorStatus() {
        return errorStatus;
    }

    public static void setErrorStatus(String errorStatus) {
        KeepRecord.errorStatus = errorStatus;
    }

    public static Credential getCredential() {
        return credential;
    }

    public static void setCredential(Credential credential) {
        KeepRecord.credential = credential;
    }
    
    
    
    public static void reset(){
username=null;
        password=null;
        role=null;
        credential=null;
        principal=null;
        errorStatus="";
        roles=null;
        token=null;
        result=null;
        uid=0;
        
    }
    
}
