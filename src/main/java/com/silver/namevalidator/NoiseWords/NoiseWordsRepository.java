package com.silver.namevalidator.NoiseWords;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NoiseWordsRepository {
    private List<String> noiseWordsData = List.of(
            "to",
            "the",
            "and"
    );

    public List<String> getData(){
        return noiseWordsData;
    }
}
