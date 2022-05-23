package com.silver.namevalidator.NoiseWords;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "noisewords")
public class NoiseWordsController {

    private NoiseWordsService noiseWordsService;

    @Autowired
    public NoiseWordsController(NoiseWordsService noiseWordsService) {
        this.noiseWordsService = noiseWordsService;
    }

    @GetMapping
    public List<String> getAll(){
        return noiseWordsService.getAll();
    }
}
