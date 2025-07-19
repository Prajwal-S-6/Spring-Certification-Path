package com.spring.boot.custom.metrics.controller;

import com.spring.boot.custom.metrics.storage.DbStorageService;
import com.spring.boot.custom.metrics.storage.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController {

    @Autowired
    private DbStorageService dbStorageService;

    @Autowired
    private FileStorageService fileStorageService;


    @PutMapping("db/storage")
    public int storeIDb(@RequestBody String content){
       return dbStorageService.store(content);
    }

    @PutMapping("file/storage")
    public int storeInFile(@RequestBody String content){
        return fileStorageService.store(content);
    }
}
