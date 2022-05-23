package com.silver.namevalidator.Blacklist;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlacklistRepository {
    private List<String> blacklistData = List.of(
            "Mari Maasikas",
            "Osama Bin Laden",
            "Vladimir Putin",
            "Aleksandr Lukašenko",
            "Mari-Liis Vaarikas",
            "Mari Vaarikas"
    );

    public List<String> getData(){
        return blacklistData;
    }
}
