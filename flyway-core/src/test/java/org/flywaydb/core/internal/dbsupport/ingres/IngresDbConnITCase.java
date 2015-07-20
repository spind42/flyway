/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.flywaydb.core.internal.dbsupport.ingres;

import java.sql.Connection;
import java.util.Properties;
import javax.sql.DataSource;
import org.flywaydb.core.internal.util.jdbc.DriverDataSource;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Stephan Spindler -stephan@spindler.priv.at-
 */
public class IngresDbConnITCase {
    
    
        
    @Test
    public void connCheck() throws Exception {
        String user = "ingres";
        String password = "ingres";
        String url = "jdbc:ingres://fedingres:II7/ingres";

        
        
        DriverDataSource driverDataSource = new DriverDataSource(Thread.currentThread().getContextClassLoader(), null, url, user, password);
        
        Connection connection = driverDataSource.getConnection();
        
        Assert.assertNotNull(connection);
    }
    
   

}
