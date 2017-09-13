package dev.paie.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import dev.paie.spring.DataSourceMySQLConfig;
import dev.paie.spring.EntityManagerConfig;
import dev.paie.spring.TransactionManagerConfig;

//@ComponentScan({"dev.paie.web.controller","dev.paie.service","dev.paie.util","dev.paie.spring","dev.paie.entite"})
@Configuration
@ComponentScan({ "dev.paie" })
@EnableJpaRepositories({ "dev.paie.repository" })
@ImportResource(value = { "classpath:cotisations-imposables.xml","classpath:cotisations-non-imposables.xml" ,"classpath:entreprises.xml","classpath:grades.xml","classpath:profils-remuneration.xml"})
@Import({ DataSourceMySQLConfig.class, EntityManagerConfig.class, TransactionManagerConfig.class })

public class ServicesConfig {

}