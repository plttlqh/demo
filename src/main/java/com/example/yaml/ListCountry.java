package com.example.yaml;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.Valid;
import java.util.List;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(locations = "classpath:/server_country.yml")
public class ListCountry {
    @Valid
    private List<Country> country;

    public List<Country> getCountry() {
        return country;
    }

    public void setCountry(List<Country> country) {
        this.country = country;
    }
}
