/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.capp.java;
import java.util.Scanner; // for console input 
import java.util.regex.*; // for regex validation 
/**
 *
 * @author ASHI
 */
public class CAPP {
    private String username;
    private String password;
    private String cellphone;
    
    //Constructor 
    public CAPP(String username, String password, String cellphone) {
        this.username = username;
        this.password = password;
        this.cellphone = cellphone;
    }
    
    //Username validation
    public boolean checkUserName() {
        return username.contains("_") && username.length() <= 5;
    }
    
    //Password validation 
    public boolean checkPasswordComplexity() {
        boolean length = password.length() >=8;
        boolean capital = password.matches(" .*[A-Z].*");
        boolean number = password.matches(".*[0-9].*");
        boolean special = password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
        return length && capital && number && special;
    }
    
    //Cellphone validation 
    public boolean checkCellPhoneNumber() {
        Pattern pattern = Pattern.compile("^\\+\\d{1,3}\\d{10}$");
        Matcher matcher = pattern.matcher(cellphone);
        return matcher.matches();
    }
    
    //Registration messaging 
    public String registerUser() {    
        if (!checkUserName()) {
            return "Username is not correctly formatted; please ensure that your username contains and is no more than five characters in length";
        }
        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number,and a special character.";
        }
        if (!checkCellPhoneNumber()) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
        return "User registered successfully!";
    }
    
    //Login check 
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return this.username.equals(enteredUsername)&& this.password.equals(enteredPassword);
    }
    
    // Login status messaging 
    public String returnLoginStatus(String enteredUsername, String enteredPassword, String firstName, String lastName) {
        if (loginUser(enteredUsername,enteredPassword)) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
    
    // Main program 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //Registration 
        System.out.println("=== Registration ===");
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        
        System.out.print("Enter cell phone number (+countrycodexxxxxxxxxx");
        String cellphone = sc.nextLine();
        
        CAPPJAVA user = new CAPPJAVA(username, password, cellphone);
        System.out.println(user.registerUser());
        
        //Login 
        System.out.println("\n=== Login ===");
        System.out.print("Enter username: ");
        String loginUsername = sc.nextLine();
        
        System.out.print("Enter password: ");
        String loginPassword = sc.nextLine();
        
        System.out.print("Enter first name: ");
        String firstName = sc.nextLine();
        
        System.out.print("Enter last name:  ");
        String lastName = sc.nextLine();
        System.out.println(user.returnLoginStatus(loginUsername, loginPassword, firstName, lastName));
    }
}
        
        
        
        
            
            
            
        
        
        

   
    

