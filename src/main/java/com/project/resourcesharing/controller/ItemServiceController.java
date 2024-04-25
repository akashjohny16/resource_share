package com.project.resourcesharing.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.resourcesharing.Service.ItemServiceService;
import com.project.resourcesharing.Service.UserService;
import com.project.resourcesharing.model.ItemService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Controller
@RequestMapping("/service")
@Slf4j
public class ItemServiceController {
    
      @Autowired
      ItemServiceService itemServiceService;

    @PostMapping("/addService")
    public String addItemService(@RequestBody ItemService itemService) {

            log.info("add a service");
            Integer updatedCount = itemServiceService.addItemService(itemService);
            if(updatedCount ==1)
            return "User Added";
       
        return "error in adding service";
    }





    @GetMapping("/itemservice/all")
    public List<ItemService> getAllItemServices() {
   
            log.info("getting all services");
          
       return  itemServiceService.getAllItemServices();

    } 

    @PostMapping("/upload")
    public void uploadFile(@RequestParam("file") MultipartFile file) {
       System.out.println("LLL");
        try {
            String content = new String(file.getBytes());
            System.out.println(content); // Assuming JsonFormatter is defined elsewhere
         
        } catch (Exception e) {
            
        }
    }



}
