package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DeleteApiController {

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id, @RequestParam String account) {
        System.out.println(id);
        System.out.println(account);

        //delete 리소스 삭제 
    }
}
