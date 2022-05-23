package com.silver.namevalidator.NameMatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NameMatchLogic {
    private static String nameDelimiters = "[ ,-]";
    private static Double matchPercentThreshold = 0.66;

    private static List<String> nameToParts(String name, List<String> noiseWords){
        List<String> nameParts = new ArrayList<String>(Arrays.asList(name.split(nameDelimiters))); //split name to list of name parts
        nameParts.removeIf(x -> x.isEmpty()); //remove empty parts from name
        nameParts.removeIf(x -> noiseWords.contains(x)); //remove noise words from name
        return nameParts;
    }

    private static Integer getMatchesCountBetweenLists(List<String> list1, List<String> list2){
        Integer matches = 0;

        for (String list1Element: list1) {
            //check if list1 element is in list2, ignore case
            if(list2.stream().anyMatch(x -> x.toLowerCase().equals(list1Element.toLowerCase()))){
                matches++;
            }
        }
        //bin laden <> osama bin laden = 2 matches
        return matches;
    }

    public static List<String> getMatchingNames(
            String inputName,
            List<String> blackListNames,
            List<String> noiseWords
    ){
        List<String> result = new ArrayList<String>();
        List<String> inputNameParts = nameToParts(inputName, noiseWords); //split name to list of name parts

        for (String blackName: blackListNames) {
            List<String> blackNameParts = nameToParts(blackName, noiseWords); //split name to list of name parts

            Integer matches = getMatchesCountBetweenLists(blackNameParts, inputNameParts); //get how many matches name parts of input name and blacklist name have
            Integer total = blackNameParts.size() > inputNameParts.size() ? blackNameParts.size() : inputNameParts.size(); //depending on which has more names, is total

            Double matchPercent = (double)matches / total;
            //if match percent is bigger than threshold, it's a match
            //bin laden <> osama bin laden = 2/3 = 0.66
            if(matchPercent >= matchPercentThreshold){
                result.add(blackName);
            }
        }

        return result;
    }
}
