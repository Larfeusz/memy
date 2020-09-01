package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class Gif {
    private String name;
    private boolean favorite;
    private Category category;


    // android-explosion
    public String getFilePath(){
        return "/gifs/"+name+".gif";
    }
    public static List<Gif> GIFS = new ArrayList<>();
    // SUMALACJA BAZY DANYCH, BEZ BAZY DAMYCH
    // SŁUŻY DO INICJALIZACJI ZMIENNYCH STATYCZNYCH
    // WYKOWANY NA SAMYM POCZĄTKU UROCHOMIENIA PLIKU
    static {
        GIFS.add(new Gif("android-explosion",true,Category.categoryList.get(0)));
        GIFS.add(new Gif("ben-and-mike",false,Category.categoryList.get(1)));
        GIFS.add(new Gif("book-dominos",true,Category.categoryList.get(1)));
        GIFS.add(new Gif("compiler-bot",false,Category.categoryList.get(0)));
        GIFS.add(new Gif("cowboy-coder",true,Category.categoryList.get(2)));
        GIFS.add(new Gif("infinite-andrew",true,Category.categoryList.get(2)));
    }
}