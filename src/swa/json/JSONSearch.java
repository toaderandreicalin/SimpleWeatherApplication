/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swa.json;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author toader
 */
public class JSONSearch {
    public JSONSearch(){};
    
    
    public Boolean searchCheckJsonFile(BufferedReader in, String searchString) throws IOException{
        String inputLine = null; //verifica daca exista un parametru in buffer
        while((inputLine = in.readLine()) != null){
            if(inputLine.contains(searchString))
                return true;  
        }
        return false;
    }
}
