/**
 * Copyright 2010-2015 Axel Fontaine
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.flywaydb.core.internal.dbsupport.ingres;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import org.flywaydb.core.internal.dbsupport.DbSupport;
import org.flywaydb.core.internal.dbsupport.JdbcTemplate;
import org.flywaydb.core.internal.dbsupport.Schema;
import org.flywaydb.core.internal.dbsupport.SqlStatementBuilder;

/**
 * Ingres specific DB support
 * @author Stephan Spindler -stephan@spindler.priv.at-
 */
public class IngresDbSupport extends DbSupport {

        /**
     * Creates a new instance.
     *
     * @param connection The connection to use.
     */
    public IngresDbSupport(Connection connection) {
        super(new JdbcTemplate(connection, Types.NULL));
    }


    public String getScriptLocation() {
        return "org/flyway/core/internal/dbsupport/ingres/";
    }

    public String getCurrentUserFunction() {
        return "current_user";
    }

    @Override
    protected String doGetCurrentSchema() throws SQLException {
        // Schemas are not actually supported by Ingres. Returning the user name.
        return jdbcTemplate.queryForString("SELECT current_user");
    }

    @Override
    protected void doSetCurrentSchema(Schema schema) throws SQLException {
        // Schemas are not actually supported by Ingres.
    }

    public boolean supportsDdlTransactions() {
        return true;
    }

    public String getBooleanTrue() {
        return "TRUE";
    }

    public String getBooleanFalse() {
        return "FALSE";
    }

    public SqlStatementBuilder createSqlStatementBuilder() {
        return new IngresSqlStatementBuilder();
    }

    @Override
    public String doQuote(String identifier) {
        return "\"" + identifier + "\"";
    }

    @Override
    public Schema getSchema(String name) {
        return new IngresSchema(jdbcTemplate, this, name);
    }

    @Override
    public boolean catalogIsSchema() {
        return false;
    }

    @Override
    public String getDbName() {
        return "INGRES";
    }
    
}
