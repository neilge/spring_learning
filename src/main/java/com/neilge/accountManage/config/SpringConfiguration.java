package com.neilge.accountManage.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Neo
 * @since 09/21/2020-10:51 PM
 */
@ComponentScan("com.neilge.accountManage")
@PropertySource("classpath:jdbcConfig.properties")
@Import(JdbcConfig.class)
public class SpringConfiguration {
}
