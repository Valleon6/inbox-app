package com.valleon.inboxapp;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.File;


@Configuration
@Getter
@Setter
@ConfigurationProperties(prefix = "datastax.astra")
public class DataStaxAstraProperties {


    private File secureConnectBundle;

}
