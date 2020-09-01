package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
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

    @GetMapping("/categories")
    public String getCategories(ModelMap map){
        map.put("categories",Category.categoryList);
        return "categories";
    }

    @GetMapping("/category/{name}")
    public String getCategory(@PathVariable String name, ModelMap map){
        Category category = null;
        for (Category category1: Category.categoryList){
            if (category1.getName().equals(name)){
                category = category1;
            }
        }
        map.put("category",category);

        List<Gif> gifs = new ArrayList<>();
            for ( Gif gif : Gif.GIFS ) {
            if (gif.getCategory().getName().equals(name)){
                gifs.add(gif);
            }
        }
        map.put("gifs",gifs);
        return "category";
    }
    // @RequestParam -> oznacza, że paraetr będzie wysłany do adresu url o nazwie "name"
    // /gifs/search?name=ben

    @GetMapping("/gifs/search")
    public String searchGifs (@RequestParam String name, ModelMap map){

        List<Gif> gifs = new ArrayList<>();
        for (Gif gif : Gif.GIFS){
            if ( gif.getName().contains(name)){
                gifs.add(gif);
            }
        }
        map.put("gifs", gifs);
        return "home";
    }
}



// @PathVariable zamienia automatycznie ze ścieżki, która się zmienia
// /gif/mike  -> String name = "mike"
// na zmienną Javową o nazwie name
