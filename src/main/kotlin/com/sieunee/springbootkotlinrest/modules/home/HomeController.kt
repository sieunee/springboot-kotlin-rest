package com.sieunee.springbootkotlinrest.modules.home

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController {

    @GetMapping("/")
    fun index() = "Hello World !"
}