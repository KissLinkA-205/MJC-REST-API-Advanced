package com.epam.esm.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

/**
 * Class {@code DaoConfig} contains spring configuration for dao subproject.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
@Configuration
@EntityScan(basePackages = "com.epam.esm")
public class DaoConfig {
}
