package com.ipe.designpatterns.factorymethod.utils;

import java.io.*;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Properties utility to read configuration file
 * @author Ronald
 */
public class UtilsProperties {
    private static final Logger LOG = Logger.getLogger(Properties.class.getCanonicalName());
    
    /**
     *
     * @param attribName
     * @return
     */
    public static Properties loadProperties(String attribName) {
       Properties prop = new Properties();
       FileInputStream input = null;
       
        try {
            String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
            String pathFile = rootPath+attribName;
            
              input = new FileInputStream(pathFile);
                
                if (input.available() > 0) {
                    prop.load(input);
                } else {
                    LOG.warning("property file '" + attribName + "' not found in the classpath");
                    throw new FileNotFoundException("property file '" + attribName + "' not found in the classpath");
                }
        } catch(Exception e) {
            LOG.warning("Exception reading properties file. "+e.getMessage());
        } finally {
            try {
                if (input != null) { input.close(); }
            } catch(Exception ex) {
            }
        }
        
        
      return prop;
    }
    
}
