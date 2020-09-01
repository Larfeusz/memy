package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data // lombok
public class Gif {

    private boolean favorite;

    public boolean isFavorite() {
        return favorite;
    }

    private String name;
    public String getFilePath (){
        return "/gifs/"+name+".gif";
    }

    public String getName() {
        return name;
    }

    public Gif( String name, boolean favorite) {
        this.name = name;
        this.favorite = favorite;
    }

    public Gif(String name) {
        this.name = name;
    }
    // Model mam służy do przekazywania zmiennej do HTML

    public static List<Gif> GIFS = new ArrayList<>();
    // Nie możemy zrobić GIFS.add , bo zmienna jest statyczna
    // żeby zainicjalizować zmienną statyczną (wszystkie gify z folderu "gifs" dodać do tablicy
    // to musimy użyć bloku statycznego

    static {
        GIFS.add(new Gif("android-explosion",true));
        GIFS.add(new Gif("ben-and-mike",false));
        GIFS.add(new Gif("book-dominos",true));
        GIFS.add(new Gif("compiler-bot", false));
        GIFS.add(new Gif("cowboy-coder", true));
        GIFS.add(new Gif("infinite-andrew",true));

     // to powyżej, to jest taka nasza baza danych, bez bazy danych

    }
}
