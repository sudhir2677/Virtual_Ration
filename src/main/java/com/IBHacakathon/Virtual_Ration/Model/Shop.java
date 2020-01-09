package com.IBHacakathon.Virtual_Ration.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shops")
@Getter
@Setter
public class Shop extends Auditable {

        @NotBlank
        String address;

        @OneToOne
        Vendor vendor;
        //String GST_no;
        ShopStatus open_closed;
        @NotNull
        int storageCapacity;
        @NotNull
        Double latitude;
        @NotNull
        Double longitude;
        @NotNull
        ShopStatus shopStatus;

        @OneToMany(mappedBy = "")
        List<User> userList = new ArrayList<>();
        List<ShopProduct> items_in_shop = new ArrayList<>();

}
