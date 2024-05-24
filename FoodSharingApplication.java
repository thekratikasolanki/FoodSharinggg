package com.example.foodSharingg;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.io.IOException; // Import IOException

@SpringBootApplication
public class FoodSharingApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(FoodSharingApplication.class, args);

        // Execute the SQL script
        SQLScriptRunner sqlScriptRunner = new SQLScriptRunner(context.getBean(DataSource.class));
        try {
            sqlScriptRunner.runScript("schema.sql");
        } catch (SQLException | IOException e) { // Handle or declare IOException
            e.printStackTrace(); // Or handle the exception in a meaningful way
        }
    }
}

