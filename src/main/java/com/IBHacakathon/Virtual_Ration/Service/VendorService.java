package com.IBHacakathon.Virtual_Ration.Service;

import com.IBHacakathon.Virtual_Ration.Exception.ApiException;
import com.IBHacakathon.Virtual_Ration.Model.Shop;
import com.IBHacakathon.Virtual_Ration.Model.User;
import com.IBHacakathon.Virtual_Ration.Model.Vendor;
import com.IBHacakathon.Virtual_Ration.Repository.ShopRepository;
import com.IBHacakathon.Virtual_Ration.Repository.UserRepository;
import com.IBHacakathon.Virtual_Ration.Repository.VendorRepository;
import com.IBHacakathon.Virtual_Ration.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class VendorService {

    @Autowired
    VendorRepository vendorRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ShopRepository shopRepository;

    public List<User> getAllUser(Long id) {
        Vendor vendor = vendorRepository.findById(id).orElse(null);
        Shop shop = vendor.getShop();
        //shop.getUserList();
        Shop shop1 =shopRepository.findById(shop.getId()).orElse(null);
        return shop1.getUserList();
    }

    public Vendor vendorLogin(String emailId, String password) throws ApiException {
        Vendor vendor = vendorRepository.findByEmailAndPassword(emailId, password);
        //    User user = userRepository.findById(1L).get();
        if (Objects.isNull(vendor)) {
            throw new ApiException("User Not Found");
        }
        return vendor;

    }
    public Vendor addVendor(Vendor vendor) {
        Vendor newVendor = new Vendor();
        newVendor.setName(vendor.getName());
        newVendor.setEmailId(vendor.getEmailId());
        Shop newShop = new Shop();


        return newVendor;
    }
}
