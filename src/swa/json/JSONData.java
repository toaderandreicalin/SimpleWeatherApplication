/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swa.json;

import java.io.BufferedReader;
import java.io.Reader;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 *
 * @author toader
 */
public class JSONData {
    JSONObject jsonObj = new JSONObject();
    LocationParse locationParse = new LocationParse();
    String curTemp = "main.temp";
    String pressure = "main.pressure";
    String minTemp = "main.temp_min";
    String maxTemp = "main.temp_max";
    
    public JSONData(JSONObject jsonObj){
        this.jsonObj = jsonObj;
        this.locationParse = locationParse;
        this.curTemp = curTemp;
    }
    
    public JSONObject createJSONObject(Reader in){
        JSONTokener jsonTokener = new JSONTokener(in);
        JSONObject jsonObj = new JSONObject(jsonTokener);
        return jsonObj;
    }
    
    public double getLat(){
        return jsonObj.getJSONObject("coord").getDouble("lat");
    }
    
    public double getLon(){
        return jsonObj.getJSONObject("coord").getDouble("lon");
    }
    
    public double getCurrentTemperature(){
        return jsonObj.getJSONObject("main").getDouble("temp");
    }
     
    public double getPressure(){
        return jsonObj.getJSONObject("main").getDouble("pressure");
    }
    
    public double getHumidity(){
        return jsonObj.getJSONObject("main").getDouble("humidity");
    }
    
    public double getMinTemp(){
        return (double) jsonObj.getDouble(minTemp);
    }
    
    public double getMaxTemp(){
        return (double) jsonObj.getDouble(maxTemp);
    }
    
    public double getVisibility(){
        return jsonObj.getDouble("visibility");
    }
}
