/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgtestphilip;

import java.io.IOException;

/**
 *
 * @author Philip Shi 05/09/2017
 */
public class TPGTestPhilip {

    /**
     * @param args the command line arguments
     * //Main method for calling other methods
     */
    public static void main(String[] args) throws IOException {
        //Question 1
        System.out.println("Question 1");
        IPValidationRegex.filterIPAddresses();
        
        //Question 2
        System.out.println("Question 2");
        Student student = new Student();
        student.sortStudents();
        
        //Question 3
        System.out.println("Question 3");
        System.out.println("Attempted but not working, commented out.");
        TimingTool.measureTime();
       
    }
    
}
