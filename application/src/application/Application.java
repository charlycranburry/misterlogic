/*
 * This Programm can give you the results of a given logic formula
 */

package application;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.*;

/**
 * @version 1.0.0
 * @author Patrick Hromniak
 */
public class Application {

    /**
     * @param args the command line arguments
     * 
     */
    
    private static ArrayList<String> formulas = new ArrayList();
    private static final String[] definedOperators = {"AND","OR","->","<->","!"};
    
    public static void main(String[] args) {
        
        Scanner reader = new Scanner(System.in);
        
        while(reader.hasNextLine()) {
            
            switch (reader.nextLine()) {
                case "save":
                    formulas.add(reader.nextLine());
                    break;
                case "print":
                    for(int i = 0; i <= formulas.size() - 1; i++){
                        System.out.println("FORMEL " + i + ": " + formulas.get(i));
                    }   break;
                case "check":
                    for(int i = 0; i <= formulas.size() - 1; i++) {
                        if(bracketValidator(formulas.get(i)) > 0) {
                            System.out.println(formulas.get(i) + " hat eine valide Klammerung.");
                        }
                        else {
                            System.out.println(formulas.get(i) + " KEINE valide Klammerung!");
                        }
                    }   break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("...");
                    break;
            }
        }
    }
    
     /**
     * Tells you if a logic formula has valid () patterns or not.
     * @param formula a String which is read in by the Scanner and is probably a logic formula
     * @return Returns a value which is either the Depth of () or 0 if it is not valid
     */

    public static int bracketValidator(String formula){
        
        int depth = 0;
        int groupsOpen = 0;
        
        boolean open = false;
        
        for(int i = 0; i <= formula.length() - 1; i++) {
            if(formula.charAt(i) == '(' && open == false) {
                open = true;
                depth++;
                groupsOpen++;
            }
            else if(formula.charAt(i) == '(' && open == true) {
                groupsOpen++;
                depth++;
            }
            else if(formula.charAt(i) == ')' && open == true) {

                if(groupsOpen > 0) {
                    groupsOpen--;
                }
                else {
                    open = false;
                }
            }
        }
        
        if(groupsOpen > 0) {
            return 0;
        }
        
        return depth;  
    }
    
     /**
     * Tells you if a logic formula is valid or not by the given OPERATORS
     * @param formula a String which is read in by the Scanner and is probably a logic formula.
     * @return Returns a boolean value if your logic formular is valid or not.
     */   
    
    public static boolean logicFormulaValidator(String formula,int depth){
        
        // Find the last ( and get its position in String
        int count = 0;
        for(int i = 0; i <= formula.length() - 1; i++){
            if(formula.charAt(i) == '(') {
                count++;
            }
        }
        // ##############################################
    }
    
}
