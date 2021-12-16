package com.ipe.designpatterns.factorymethod.adapter;

import java.sql.Connection;

/**
 *
 * @author Ronald
 */
public interface DBAdapter {
    // to get the Connection type of jdbc

    /**
     *
     * @return
     */
    public Connection getConnection();
}
