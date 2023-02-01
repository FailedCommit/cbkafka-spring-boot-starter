package com.chargebee.cbkafkaspringbootstarter;

import org.springframework.stereotype.Service;

@Service
public class MYDummyLibrary {
    public String message() {
        return "Hi, I am your new Library";
    }
}
