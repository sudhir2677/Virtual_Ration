package com.IBHacakathon.Virtual_Ration.Controller;

import com.IBHacakathon.Virtual_Ration.Exception.ApiException;
import com.IBHacakathon.Virtual_Ration.Model.User;
import com.IBHacakathon.Virtual_Ration.Model.Vendor;
import com.IBHacakathon.Virtual_Ration.Service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/vendor")
public class VendorController {

    @Autowired
    VendorService vendorService;

    @GetMapping("/user/login/{emailId}/{password}")
    public Vendor userLogin(@PathVariable(value = "emailId") String emailId,
                            @PathVariable(value="password") String password,
                            HttpSession session) throws ApiException {

        Vendor vendor= vendorService.vendorLogin(emailId,password);
        if(vendor!=null){
            session.setAttribute("userId",vendor.getId());
        }
        return vendor;
    }



    @GetMapping("/{id}/getAllUser")
    public List<User> getAllUser(@PathVariable("id") Long id){
        return vendorService.getAllUser(id);
    }
}
