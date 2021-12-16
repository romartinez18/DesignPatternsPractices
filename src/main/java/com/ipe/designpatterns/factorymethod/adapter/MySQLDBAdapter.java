package com.ipe.designpatterns.factorymethod.adapter;

import com.ipe.designpatterns.factorymethod.utils.DB_ATTRIBS;
import com.ipe.designpatterns.factorymethod.utils.UtilsProperties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author Ronald
 */
public class MySQLDBAdapter implements DBAdapter {
    
    private final String PROP_FILE = "DBMySQL.properties";
    private String username = "";
    private String password = "";
    
    static {
        try {
            // Load the Driver one time
            new com.mysql.jdbc.Driver();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 
     * @return
     */
    @Override
    public Connection getConnection() {
        String preparedConnection = createConnection();
        Connection connection = null;
        
        try {
            connection = DriverManager.getConnection(preparedConnection, 
                                                     this.username,
                                                     this.password);
        } catch(Exception e) {
            e.printStackTrace();
        }
        
      return connection;
    }
    
    private String createConnection() {
        Properties prop = UtilsProperties.loadProperties(PROP_FILE);
        String host = prop.getProperty(DB_ATTRIBS.DB_HOST);
        String port = prop.getProperty(DB_ATTRIBS.DB_PORT);
        String database = prop.getProperty(DB_ATTRIBS.DB_DATABASE);
        
            this.username = prop.getProperty(DB_ATTRIBS.DB_USER);
            this.password = prop.getProperty(DB_ATTRIBS.DB_PASSWORD);
            String connectionStr = "jdbc:mysql://"+host+":"+port+"/"+database;
            
            System.out.println("Connecting to "+connectionStr);
            
      return connectionStr;
    }
    
}
