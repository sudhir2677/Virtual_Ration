package com.IBHacakathon.Virtual_Ration.Service;

import com.IBHacakathon.Virtual_Ration.Exception.ApiException;
import com.IBHacakathon.Virtual_Ration.Model.*;
import com.IBHacakathon.Virtual_Ration.Repository.ShopProductRepository;
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

    @Autowired
    ShopProductRepository shopProductRepository;

    public List<User> getAllUser(Long id) {
        Vendor vendor = vendorRepository.findById(id).orElse(null);
        Shop shop = vendor.getShop();
        //shop.getUserList();
        Shop shop1 =shopRepository.findById(shop.getId()).orElse(null);
        return shop1.getUserList();
    }

    public Vendor vendorLogin(String emailId, String password) throws ApiException {
        Vendor vendor = vendorRepository.findByEmailIdAndPassword(emailId, password);
        //    User user = userRepository.findById(1L).get();
        if (Objects.isNull(vendor)) {
            throw new ApiException("User Not Found");
        }
        return vendor;
    }


    public Shop getShop(Long id) {
        Vendor vendor = vendorRepository.findById(id).orElse(null);
        Shop shop = vendor.getShop();
        //shop.getUserList();
        Shop shop1 =shopRepository.findById(shop.getId()).orElse(null);
        return shop1;
    }

    public ShopProduct addProduct(Long id, ShopProduct shopProduct) {
        Vendor vendor = vendorRepository.findById(id).orElse(null);
        Shop shop = vendor.getShop();
        ShopProduct product = new ShopProduct();
        product.setItemName(shopProduct.getItemName());
        product.setQuantity(shopProduct.getQuantity());

        shopProductRepository.save(product);


        shop.getItems_in_shop().add(product);
        shopRepository.save(shop);
        return shopProduct;
    }


    public Vendor addVendor(Vendor vendor) {

        Shop newShop = new Shop();
        newShop.setAddress(vendor.getShop().getAddress());
        newShop.setStorageCapacity(vendor.getShop().getStorageCapacity());
        shopRepository.save(newShop);

        Vendor newVendor = new Vendor();
        newVendor.setName(vendor.getName());
        newVendor.setEmailId(vendor.getEmailId());
        newVendor.setAddress((vendor.getAddress()));
        newVendor.setShop(newShop);
        vendorRepository.save(newVendor);
        return newVendor;
    }
}
