/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassPackage;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;

/**
 *
 * @author rohan
 */
public class KeyGenrator {
    
    private static SecretKey sk = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    
    public static  String genratetoken(String username){
//        SecretKey sk;
//        sk= Keys.secretKeyFor(SignatureAlgorithm.HS512);
        return  Jwts.builder().setSubject(username).signWith(sk).compact();
    }
    
    public static boolean verifytoken(String token){
//        SecretKey secratekey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
        Jws<Claims> c=Jwts.parser().setSigningKey(sk).parseClaimsJws(token);
        return true;
    }
    
}
