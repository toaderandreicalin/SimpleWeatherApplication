/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swa.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author toader
 */
public class LocationParse {
    String API_KEY = "ed6d29776d26d1d73ed9564802e54201"; 
    String API_CITYNAME = "http://api.openweathermap.org/data/2.5/weather?q=";
    String API_CITYID = "http://api.openweathermap.org/data/2.5/weather?id=";
    int lat, lon, zipCode, countryCode;
    String API_COORDINATES = "http://api.openweathermap.org/data/2.5/weather?lat=" + "///" + "&lon=" + "///"; // gresit. va returna mereu val lat lon 0
    String API_CDATA_URL = "http://openweathermap.org/help/city_list.txt";

    public LocationParse(){ // se poate implementa cu overflow
        this.API_KEY = API_KEY;
        this.API_CITYNAME = API_CITYNAME;
        this.API_CITYID = API_CITYID;
        this.API_COORDINATES = API_COORDINATES;
        this.API_CDATA_URL = API_CDATA_URL;
    }

     public String[] lineSplit(String s){
        String[] sArray = null;
        if(s.contains("///")){    
            sArray = s.split("///");
        }
        return sArray;
    }
    
    public String setUrlCity(String city) throws MalformedURLException{
        String URL_CITYNAME = new String(API_CITYNAME + city);
        return URL_CITYNAME;
    }
    
    public String setUrlCoordinates(int lat, int lon) throws MalformedURLException{
        String[] sArray;
        sArray = lineSplit(API_COORDINATES);
        String URL_COORDINATES = new String(sArray[1] + lat + sArray[2] + lon);  // nu cred a e bine
        return URL_COORDINATES;
    }
    
    public String appendUrlKey(String currentUrl) throws MalformedURLException{
        String keyUrl = new String(currentUrl + "&APPID=" + API_KEY);
        return keyUrl;
    }
    
    public Reader parsePage(URL currentUrl) throws IOException{
        Reader in = new BufferedReader(
        new InputStreamReader(currentUrl.openStream()));
        return in;
    }
    
    
}
