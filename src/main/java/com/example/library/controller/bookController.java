package com.example.library.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.service.bookService;

@RestController
@RequestMapping("/books")
public class bookController {

    private bookService bookService1;
}
