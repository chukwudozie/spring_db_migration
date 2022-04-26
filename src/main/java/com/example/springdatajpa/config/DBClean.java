package com.example.springdatajpa.config;

import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * This class configures the cleaning and rebuilding of databases using flyway
 */
@Profile("clean")
@Configuration
public class DBClean {

    /**
     *This method uses the flyway tool to drop everything in the database
     */
    @Bean
    public FlywayMigrationStrategy clean(){
        return flyway -> {
            flyway.clean();// drops all the database objects and rebuilds from flyway migration
            flyway.migrate();
            // other flyway methods can be run here as well
        };
    }
}
