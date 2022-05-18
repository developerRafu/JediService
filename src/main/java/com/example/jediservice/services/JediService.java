package com.example.jediservice.services;

import com.example.jediservice.models.Jedi;
import com.example.jediservice.models.enums.Status;
import com.example.jediservice.repoistories.JediRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class JediService {
    private final JediRepository repository;

    public List<Jedi> listar(Integer midi, String mestre, Status status) {
        return repository.findAllByFilter(midi, mestre, status);
    }
}
