package com.dhf.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dhf.model.Food;
import com.dhf.service.FoodService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping(value = "/kitchen")
public class FoodListController {

    @Reference(interfaceClass = FoodService.class,version = "1.0.0",check = false)
    private FoodService foodService;

    @RequestMapping(value = "/foodlist")
    public String foodLists(Model model){
     HashMap<String, ArrayList<String>> food = foodService.selectFoodAll();
     Set<String> keySet = food.keySet();
     List<String> sort = new ArrayList<>();
     Iterator iterator = keySet.iterator();

     while(iterator.hasNext()){
         String key = (String) iterator.next();
         sort.add(key);
     }
     model.addAttribute("sort",sort);
     model.addAttribute("food",food);

     return "foodlist";
    }
    @RequestMapping(value = "/familylist")
    public String famliyLists(Model model){
        HashMap<String, ArrayList<String>> food = foodService.selectFoodAll();
        Set<String> keySet = food.keySet();
        List<String> sort = new ArrayList<>();
        Iterator iterator = keySet.iterator();

        while(iterator.hasNext()){
            String key = (String) iterator.next();
            sort.add(key);
        }
        model.addAttribute("sort",sort);
        model.addAttribute("food",food);

        return "familylist";
    }

}
