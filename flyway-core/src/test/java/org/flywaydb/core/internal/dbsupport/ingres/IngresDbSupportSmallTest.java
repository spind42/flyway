/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.flywaydb.core.internal.dbsupport.ingres;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Stephan Spindler -stephan@spindler.priv.at-
 */
public class IngresDbSupportSmallTest {
 
    @Test
    public void doQuote() {
        IngresDbSupport dbSupport = new IngresDbSupport(null);
        assertEquals("\"abc\"", dbSupport.doQuote("abc"));
    }
    
}
