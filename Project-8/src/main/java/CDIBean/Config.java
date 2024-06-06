/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package CDIBean;

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 *
 * @author rohan
 */
@CustomFormAuthenticationMechanismDefinition(loginToContinue = @LoginToContinue(loginPage = "login.jsf"))
@DatabaseIdentityStoreDefinition(dataSourceLookup = "jdbc/projectpool",
        callerQuery = "SELECT Password FROM UserTB WHERE Username = ?",
       groupsQuery = "SELECT Rolename FROM RoleTB WHERE RoleID IN (SELECT RoleID FROM UserTB WHERE Username = ?)",
       hashAlgorithm = Pbkdf2PasswordHash.class,
       priority = 30
        )
@Named(value = "config")
@ApplicationScoped
public class Config {

    /**
     * Creates a new instance of Config
     */
    public Config() {
    }
    
}
