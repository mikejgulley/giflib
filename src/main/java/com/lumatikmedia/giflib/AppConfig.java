package com.lumatikmedia.giflib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by mgulley on 5/4/2016.
 */

@EnableAutoConfiguration
@ComponentScan // this tells Spring to look for controllers in current package
public class AppConfig {
    public static void main (String[] args) {
        SpringApplication.run(AppConfig.class, args);
    }
}
