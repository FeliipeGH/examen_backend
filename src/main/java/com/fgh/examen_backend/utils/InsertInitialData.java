package com.fgh.examen_backend.utils;


import com.fgh.examen_backend.services.InsertionInitialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InsertInitialData implements CommandLineRunner {

    @Autowired
    private InsertionInitialService insertInitialService;

    @Override
    public void run(String... args) {
        if (!insertInitialService.existData()) {
            insertInitialService.insertData();
        }
    }
}
