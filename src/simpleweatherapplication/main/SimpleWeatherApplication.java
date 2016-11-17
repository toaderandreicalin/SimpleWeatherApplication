/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleweatherapplication.main;

import java.io.IOException;
//import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.*;
import swa.json.JSONData;
import swa.json.LocationParse;

/**
 *
 * @author toader
 */
public class SimpleWeatherApplication {
    //static URL curUrl;

    public SimpleWeatherApplication() throws MalformedURLException {
        //this.curUrl = curUrl;
    }
    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) throws IOException {

        LocationParse locationParse = new LocationParse();
        String urlAddress = new String(locationParse.setUrlCity("Detroit"));
        URL urlKey = new URL(locationParse.appendUrlKey(urlAddress));
        System.out.println(urlKey);
        Reader in = locationParse.parsePage(urlKey);
        
        JSONTokener jsonTokener = new JSONTokener(in);
        JSONObject jsonObj = new JSONObject(jsonTokener);
        JSONData jsonpars = new JSONData(jsonObj);

        System.out.println(jsonpars.getLat());
        System.out.println(jsonpars.getLon());
        System.out.println(jsonpars.getVisibility());
       // System.out.println(json.getJSONObject("main").getDouble("temp"));
    }
    
}
