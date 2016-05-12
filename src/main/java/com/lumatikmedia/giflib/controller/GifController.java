package com.lumatikmedia.giflib.controller;

import com.lumatikmedia.giflib.data.GifRepository;
import com.lumatikmedia.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by mgulley on 5/10/2016.
 */

@Controller
public class GifController {
    @Autowired // Dependency Injection (D.I.)
    private GifRepository gifRepository;

    @RequestMapping(value = "/")
    public String listGifs(ModelMap modelMap) {
        List<Gif> allGifs = gifRepository.getAllGifs();
        modelMap.put("gifs", allGifs);
        return "home"; // Thymeleaf knows this means home.html
    }

    /*@RequestMapping(value = "/gif")
    @ResponseBody // we delete this on the method above since we need Thymeleaf to handle it
    public String sniffGifs() {
        return "How bout dem GIFs? JJJJJIIIIIIFFFFFFFFF!!!!";
    }*/

/*    @RequestMapping("/gif")
    public String gifDetails(ModelMap modelMap) {
        Gif gif = new Gif("android-explosion", LocalDate.of(2016, 5, 10), "Mike Gulley", true);
        modelMap.put("gif", gif);
        return "gif-details";
    }*/

    // URL example => http://localhost:8080/gif/andoid-explosion
    @RequestMapping("/gif/{name}")
    public String gifDetails(@PathVariable String name, ModelMap modelMap) {
        Gif gif = gifRepository.findByName(name);
        modelMap.put("gif", gif);
        return "gif-details";
    }

    @RequestMapping("/favorites")
    public String favGifs(ModelMap modelMap) {
        List<Gif> favGifs = gifRepository.findFavorites();
        modelMap.put("favGifs", favGifs);

        return "favorites";
    }

}
