package com.IBHacakathon.Virtual_Ration.Controller;

import com.IBHacakathon.Virtual_Ration.Repository.SuperCategoryRepository;
import com.IBHacakathon.Virtual_Ration.Service.PopulateCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dev")
public class PopulateSuperDB {

    @Autowired
    SuperCategoryRepository superCategoryRepository;

    @GetMapping("/category")
    public void populateCategory(){
        PopulateCategoryService populateCategoryService = new PopulateCategoryService();
        populateCategoryService.populateCategory();
    }
}
