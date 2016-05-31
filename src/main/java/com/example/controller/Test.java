package com.example.controller;

import com.example.entity.AppSetting;
import com.example.repository.AppSettingRepository;
import com.example.util.AppSettingUtil;
import com.example.yaml.Country;
import com.example.ListCountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Test {

    @Autowired
    private ListCountry listCountry;

    @Autowired
    private AppSettingUtil appSettingUtil;

    @RequestMapping("/test")
    public ResponseEntity<List<Country>> test(){
        List<Country> country = listCountry.getCountry();
        for (Country listCountry : country) {
            System.out.println(listCountry.getId());
            System.out.println(listCountry.getCode());
            List<String> type = listCountry.getDocument().getType();
            for (String s : type) {
                System.out.println(s);
            }
        }
        return new ResponseEntity<>(listCountry.getCountry(), HttpStatus.OK);

    }

    @RequestMapping("/db")
    public ResponseEntity<Object> db(){
        String cryptoClientKeyName = appSettingUtil.getCryptoClientKeyName();
        return new ResponseEntity<>(cryptoClientKeyName, HttpStatus.OK);
    }
}
