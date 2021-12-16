package com.ipe.designpatterns.factorymethod.factory;

import com.ipe.designpatterns.factorymethod.adapter.DBAdapter;
import com.ipe.designpatterns.factorymethod.utils.UtilsProperties;
import java.sql.Connection;
import java.util.Properties;

/**
 *
 * @author Ronald
 */
public class DBFactory {
    private static final String PROP_FILE = "DBFactory.properties";
    private static final String DB_PROP_DEFAULT = "driverDBDefault";

    /**
     *
     * @return
     */
    public static DBAdapter getDefaultConnection() {
        DBAdapter dbDefaultAdapter = null;
        
           try {
               Properties prop = UtilsProperties.loadProperties(PROP_FILE);
               String managerDBName = prop.getProperty(DB_PROP_DEFAULT);
                  System.out.println("managerDBName: "+managerDBName);
                  dbDefaultAdapter = (DBAdapter)Class.forName(managerDBName).newInstance();
           } catch(Exception e) {
               e.printStackTrace();
           }
        
      return dbDefaultAdapter;
    }
    
    
}
