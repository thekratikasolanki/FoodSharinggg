package com.example.foodSharingg;


import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class SQLScriptRunner {

    private final DataSource dataSource;

    public SQLScriptRunner(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void runScript(String scriptPath) throws SQLException, IOException {
        try (Connection connection = dataSource.getConnection()) {
            Resource resource = new ClassPathResource(scriptPath);
            ScriptUtils.executeSqlScript(connection, resource);
        }
    }
}


