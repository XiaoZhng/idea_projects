package com.boot.controller;

import com.boot.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Alonso
 */
@RestController
@RequestMapping("/msg")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("{id}")
    public Integer msg(@PathVariable Integer id){
        Integer integer = messageService.doMessage();
        return integer;
    }
}
