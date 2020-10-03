package com.example.demo.controller;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ServerMetaData;

@RestController
@RequestMapping("/")
public class HomePageController {

    @Autowired
    private ServerMetaData serverMaintainer;

    @GetMapping
    public ServerMetaData getHomePage() {
        return serverMaintainer;
    }

    @GetMapping("/meta")
    public String getMetaData() {
        return new ServerMetaData().toString();
    }
}

@JsonSerialize
class EmptyJsonResponse { }