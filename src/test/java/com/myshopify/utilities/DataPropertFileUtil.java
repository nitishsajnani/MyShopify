package com.myshopify.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * This is the utility class for data Read/Write
 *
 *
 *
 */
public class DataPropertFileUtil {

    private static String defaultDataFile = "src/test/resources/testdata/data.properties";
    
   

    /**
     *
     * This method will get the properties pulled from a file located relative to the base dir
     * @param Property property name for which value has to be fetched
     * @return String value of the property
     * 
     */
    public static String getProperty(String Property) {
        try {
            Properties prop = ResourceLoader.loadProperties(defaultDataFile);
            return prop.getProperty(Property);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    /**
     * 
     * This method will get the properties pulled from a file located relative to the base dir
     * 
     * @param propFile complete or relative (to base dir) file location of the properties file 
     * @param Property property name for which value has to be fetched 
     * @return String value of the property
     */
    public static String getProperty(String propFile, String Property) {
        try {
            Properties prop = ResourceLoader.loadProperties(propFile);
            return prop.getProperty(Property);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }    
    
    /**
    *
    * This method will write the property value against a key into a file located relative to the base dir
    * @param Property property name for which value has to be written
    * @param Value property value to be written
    * 
    */
       
    public static void setProperty(String Property, String Value) {
    	Properties props ;
		try {
			if(!(Value.equals(null) || Value.equals(""))) {
			props = new Properties();
			InputStream inPropFile = new FileInputStream(defaultDataFile);
			props.load(inPropFile);
			inPropFile.close();
			OutputStream outPropFile = new FileOutputStream(defaultDataFile);
			props.setProperty(Property, Value);
			props.store(outPropFile, null);
			outPropFile.close();
		}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
   
}
