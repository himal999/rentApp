package lk.rent.app.config;/*
author :Himal
version : 0.0.1
*/

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({JPAConfig.class})
public class WebRootConfig {
}
