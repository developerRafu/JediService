package com.example.jediservice.controllers;

import com.example.jediservice.models.Jedi;
import com.example.jediservice.models.enums.Status;
import com.example.jediservice.services.JediService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("jedis")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class JediController {
    private final JediService service;

    @GetMapping
    public ResponseEntity<List<Jedi>> get(
            @RequestParam(required = false) Integer midi,
            @RequestParam(required = false) String mestre,
            @RequestParam(required = false) Status status
    ) {
        return ResponseEntity.ok().body(service.listar(midi, mestre, status));
    }
}
