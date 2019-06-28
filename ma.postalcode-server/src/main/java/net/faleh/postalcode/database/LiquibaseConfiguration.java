package net.faleh.postalcode.database;


import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;

import liquibase.integration.spring.SpringLiquibase;

public class LiquibaseConfiguration {

    @Bean
    public SpringLiquibase liquibase(DataSource datasource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:database/changeLog.xml");
        liquibase.setDataSource(datasource);
        return liquibase;
    }
}
