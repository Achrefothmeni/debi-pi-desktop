/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package debo;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import user.module.User;
import user.module.UserLoginController;


/**
 *
 * @author dell
 */
public class Authentication {
    
    public static boolean isAuthenticated = false;
    
    public static User authenticatedUser = null;    
        
    public static boolean checkPass(String plainPassword, String inputPassword) {
       return plainPassword.equals(inputPassword);
    }
    
    public static void logout(){
        Authentication.isAuthenticated = false;
        authenticatedUser = null;
    }
    
}
