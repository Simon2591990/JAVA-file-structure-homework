package com.codeclan.example.file_structure_homework.components;

import com.codeclan.example.file_structure_homework.models.File;
import com.codeclan.example.file_structure_homework.models.Folder;
import com.codeclan.example.file_structure_homework.models.User;
import com.codeclan.example.file_structure_homework.repositories.FileRepository;
import com.codeclan.example.file_structure_homework.repositories.FolderRepository;
import com.codeclan.example.file_structure_homework.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.ApplicationArguments;

import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    FolderRepository folderRepository;
    @Autowired
    FileRepository fileRepository;

    public DataLoader(){}

    public void run(ApplicationArguments args){
        User simon = new User("Simon");
        userRepository.save(simon);
        User laura = new User("Laura");
        userRepository.save(laura);
        Folder games = new Folder("Games", laura);
        folderRepository.save(games);
        laura.addFolder(games);
        userRepository.save(laura);
        File civ = new File("Civilisation 6", "exe", 20000,games);
        fileRepository.save(civ);
        File stardew = new File("Stardew Valley", "exe", 400, games);
        fileRepository.save(stardew);
    }
}
