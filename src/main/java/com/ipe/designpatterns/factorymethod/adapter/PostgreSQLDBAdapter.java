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
public class PostgreSQLDBAdapter implements DBAdapter {
    private static final String PROP_FILE = "DBPostgreSQL.properties";
    
    static {
        try {
            // Load the Driver one time
            new org.postgresql.Driver();
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
            connection = DriverManager.getConnection(preparedConnection);
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
        String user = prop.getProperty(DB_ATTRIBS.DB_USER);
        String password = prop.getProperty(DB_ATTRIBS.DB_PASSWORD);
        
        String connectionStr = "jdbc:postgresql://"+host+":"+port+"/"+database+
                               "?user="+user+"&password="+password;
        
      return connectionStr;
    }
    
}
