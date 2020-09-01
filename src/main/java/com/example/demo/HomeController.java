package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.stream.Collectors;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHome(ModelMap map){
        map.put("gifs",Gif.GIFS);
        return "home";
    }

    // name = który jest zmienny

    @GetMapping ("/gif/{name}")
        public String getGif(@PathVariable String name, ModelMap map){
        for ( Gif i  : Gif.GIFS ) {
            if ( i.getName().equals(name) )
            map.put("gif", i);
        }
        return "gif-details";
    }
    @GetMapping("/favorites")
    public String getFavorites(ModelMap map){
        map.put("gifs",Gif.GIFS.stream().filter(gif -> gif.isFavorite())
                .collect(Collectors.toList()));
        return "favorites";
    }


}

// @PathVariable zamienia automatycznie ze ścieżki, która się zmienia
// /gif/mike  -> String name = "mike"
// na zmienną Javową o nazwie name
