package com.IBHacakathon.Virtual_Ration.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomString {

    public static String generateString(int length){
        List<Character> alphabet = generator();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i=0;i<length;i++){
            sb.append(alphabet.get(random.nextInt(alphabet.size())));
        }
        return sb.toString();
    }

    public static List<Character> generator(){
        List<Character> list = new ArrayList<>();
        for(int i='a';i<='z';i++){
            list.add((char)i);
        }
        for(int i='A';i<='Z';i++){
            list.add((char)i);
        }
        for(int i=0;i<=9;i++){
            list.add((char)(i+'0'));
        }
        return list;
    }
}
