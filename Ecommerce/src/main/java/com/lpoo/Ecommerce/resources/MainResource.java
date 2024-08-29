package com.lpoo.Ecommerce.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainResource {

    @GetMapping("/main")
    public String home() {
        return "main"; 
    }
}
