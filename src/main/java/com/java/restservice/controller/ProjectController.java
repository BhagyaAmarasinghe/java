package com.java.restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.restservice.entity.Project;
import com.java.restservice.repository.ProjectRepository;

import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/projects")
public class ProjectController {

    @Autowired
    private ProjectRepository repository;

    @GetMapping
    public Iterable<Project> findAll() {
        return repository.findAll();
    }

    @PostMapping(consumes = "application/json")
    public Project create(@RequestBody Project project) {
        return repository.save(project);
    }


}
