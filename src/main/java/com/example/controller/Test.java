package com.example.controller;

import com.example.yaml.Country;
import com.example.yaml.ListCountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Test {

    @Autowired
    private ListCountry listCountry;

    @RequestMapping("/test")
    public List<Country> test(){
        List<Country> country = listCountry.getCountry();
        for (Country listCountry : country) {
            System.out.println(listCountry.getId());
            System.out.println(listCountry.getCode());
            List<String> type = listCountry.getDocument().getType();
            for (String s : type) {
                System.out.println(s);
            }
        }
        return listCountry.getCountry();

    }
}
