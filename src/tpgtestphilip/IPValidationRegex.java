/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgtestphilip;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author User
 */
public class IPValidationRegex {

    public static void filterIPAddresses() throws IOException {

        BufferedReader br;
        String thisLine; 
        //Regex for validating Ip Address
        Pattern regex = Pattern.compile("^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
        
        try {
            //Reads file from resources folder
            br = new BufferedReader(new FileReader("resources/ipaddresses.txt"));
            while ((thisLine = br.readLine()) != null) {
                Matcher matcher = regex.matcher(thisLine);
                while(matcher.find()){
                    //If the IP Adress is valid, print the address.
                    System.out.println(thisLine);
                }
                
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Could not find text file of ip addresses");
            ex.printStackTrace();
        }
    }
            
}
