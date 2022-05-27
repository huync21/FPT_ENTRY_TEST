/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author LENOVO
 */
public class Problem1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // input
        Scanner sc = new Scanner(System.in);
        System.out.println("Type in text:");
        String text = sc.nextLine();
        
        // process
        int maxLength = 0;
        String longestWord = null;
        if(text.isEmpty()){ // validation 
            System.out.println("Please type in a none empty string!");
        }
        else{
            StringTokenizer stringTokenizer = new StringTokenizer(text);
            while(stringTokenizer.hasMoreTokens()){
                String word = stringTokenizer.nextToken();
                
                /**
                 * Including case first longest word, 
                 * if the word's length is larger than 
                 * maxLength, then assign to longestWord 
                 */
                if(word.length() > maxLength){ 
                    maxLength = word.length();
                    longestWord = word;
                }
            }
            // output
            System.out.println(longestWord);
        }
        
        
    }
    
}
