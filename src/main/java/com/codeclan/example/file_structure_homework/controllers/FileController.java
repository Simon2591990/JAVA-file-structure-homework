package com.codeclan.example.file_structure_homework.controllers;

import com.codeclan.example.file_structure_homework.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {
    @Autowired
    FileRepository fileRepository;

    @GetMapping(value = "/files")
    public ResponseEntity getAllFiles(){
        return new ResponseEntity(fileRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/files/{id}")
    public ResponseEntity getFile(@PathVariable Long id){
        return new ResponseEntity(fileRepository.findById(id), HttpStatus.OK);
    }
}
