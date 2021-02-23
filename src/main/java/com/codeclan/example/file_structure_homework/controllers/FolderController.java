package com.codeclan.example.file_structure_homework.controllers;

import com.codeclan.example.file_structure_homework.models.Folder;
import com.codeclan.example.file_structure_homework.repositories.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FolderController {

    @Autowired
    FolderRepository folderRepository;

    @GetMapping(value = "/folders")
    public ResponseEntity getAllFolders(){
        return new ResponseEntity(folderRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/folders/{id}")
    public ResponseEntity getFolder(@PathVariable Long id){
        return new ResponseEntity(folderRepository.findById(id), HttpStatus.OK);
    }
    @PostMapping(value = "/folders")
    public ResponseEntity postFolder(@RequestBody Folder folder){
        folderRepository.save(folder);
        return new ResponseEntity(folder, HttpStatus.CREATED);
    }
}
