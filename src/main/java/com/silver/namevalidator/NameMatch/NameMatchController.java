package com.silver.namevalidator.NameMatch;

import com.silver.namevalidator.Blacklist.BlacklistService;
import com.silver.namevalidator.NoiseWords.NoiseWordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "namematch")
public class NameMatchController {
    private final BlacklistService blacklistService;
    private final NoiseWordsService noiseWordsService;

    @Autowired
    public NameMatchController(BlacklistService blacklistService, NoiseWordsService noiseWordsService) {
        this.blacklistService = blacklistService;
        this.noiseWordsService = noiseWordsService;
    }

    @GetMapping(path = "{inputName}")
    List<String> getMatches(@PathVariable("inputName") String inputName){
        return NameMatchLogic.getMatchingNames(
                inputName,
                blacklistService.getAll(),
                noiseWordsService.getAll()
                );
    }
}
