package org.marianaduarte.tema07;

import java.util.List;
import java.util.Arrays;

public class Conversor {

    private List<String> numbersRoman = Arrays.asList("0","I","II","III","IV","V","VI","VII","VIII","IX","X","XI","XII","XII","XIV","XV","XVI", "XVII", "XVIII", "XIX", "XX");

    public Integer convertRomanToInteger(String numRoman){
        for (int i = 0; i < numbersRoman.size(); i++){
            if(numRoman != null && numbersRoman.get(i).equalsIgnoreCase(numRoman) && numRoman.matches("[a-zA-Z]+")){
                return i;
            }
        }
        return null;
    }

    public String convertIntegerToRoman(Integer num){
        for(int i=0;i<numbersRoman.size();i++){
            if(num > 0 && num < 21 && num != null && num == i){
                return numbersRoman.get(i);
            }
        }
        return null;
    }

}
