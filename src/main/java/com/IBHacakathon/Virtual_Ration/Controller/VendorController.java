package com.IBHacakathon.Virtual_Ration.Controller;

import com.IBHacakathon.Virtual_Ration.Exception.ApiException;
import com.IBHacakathon.Virtual_Ration.Model.Shop;
import com.IBHacakathon.Virtual_Ration.Model.ShopProduct;
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
            session.setAttribute("vendorId",vendor.getId());
        }
        return vendor;
    }



    @GetMapping("/{id}/getAllUser")
    public List<User> getAllUser(@PathVariable("id") Long id,
                                 HttpSession session) {
        Long id1 = (Long)session.getAttribute("vendorId");
        if(id1 == null) return null;
        return vendorService.getAllUser(id);
    }

    @GetMapping("/{id}")
    public Shop getShop(@PathVariable("id") Long id,
                        HttpSession session){
        Long id1 = (Long)session.getAttribute("vendorId");
        if(id1 == null) return null;
        return vendorService.getShop(id);
    }

    // Vendor can add , edit , delete and update their shop’s other items also.
    @PostMapping("/{id}")
    public ShopProduct addProduct(@PathVariable("id") Long id,
                                  @RequestBody ShopProduct shopProduct,
                                  HttpSession session){
        Long id1 = (Long)session.getAttribute("vendorId");
        if(id1 == null) return null;
        return vendorService.addProduct(id1, shopProduct);
    }
}
