package com.fgh.examen_backend.controllers;

import com.fgh.examen_backend.dto.Welcome;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mainController")
@CrossOrigin(origins = "*")
public class MainController {

    @RequestMapping(method = RequestMethod.GET, value = "/getWelcome")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    public ResponseEntity<?> getWelcome() {
        return new ResponseEntity<>(new Welcome(), HttpStatus.OK);
    }
}