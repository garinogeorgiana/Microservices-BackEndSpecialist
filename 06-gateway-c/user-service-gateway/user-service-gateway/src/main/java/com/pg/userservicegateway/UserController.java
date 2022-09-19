package com.pg.userservicegateway;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping("/detail")
    public ResponseEntity<?>detail(){
        return new ResponseEntity<>("User empty", HttpStatus.OK);
    }
}
