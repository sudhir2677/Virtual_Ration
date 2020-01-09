package com.IBHacakathon.Virtual_Ration.Service;

import com.IBHacakathon.Virtual_Ration.Model.SuperCategory;
import com.IBHacakathon.Virtual_Ration.Repository.SuperCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PopulateCategoryService {

    @Autowired
    SuperCategoryRepository superCategoryRepository;
    public void populateCategory(){
        SuperCategory rice = new SuperCategory("Rice",2.0,4.0,2);
        SuperCategory wheat = new SuperCategory("Wheat",5.0,10.0,4);
        SuperCategory sugar = new SuperCategory("Sugar",10.0,15.0,1);
        superCategoryRepository.save(rice);
        superCategoryRepository.save(wheat);
        superCategoryRepository.save(sugar);
    }
}
