/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author akisk
 */
@Controller
public class TestController {
    
    @GetMapping("/")
    public String welcomePage(){
        return "index";
    }
    @GetMapping("/createRecipe")
    public String createRecipe(){
        return "createRecipe";
    }
}
