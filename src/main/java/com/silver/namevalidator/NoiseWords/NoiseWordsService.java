package com.silver.namevalidator.NoiseWords;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoiseWordsService {
    private NoiseWordsRepository noiseWordsRepository;

    public NoiseWordsService(NoiseWordsRepository noiseWordsRepository) {
        this.noiseWordsRepository = noiseWordsRepository;
    }

    public List<String> getAll(){
        return noiseWordsRepository.getData();
    }
}
