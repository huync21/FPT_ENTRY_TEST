/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem2.exceptions;

/**
 *
 * @author LENOVO
 */
public class EmptyInputException extends Exception{

    @Override
    public String toString() {
        return "This field cannot be empty";
    }
    
}
