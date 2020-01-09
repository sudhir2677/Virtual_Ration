package com.IBHacakathon.Virtual_Ration.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

        @OneToOne(mappedBy = "shop")
        Vendor vendor;
        //String GST_no;
        @NotNull
        int storageCapacity;
        @NotNull
        Double latitude;
        @NotNull
        Double longitude;
        @NotNull
        @Enumerated(EnumType.STRING)
        ShopStatus shopStatus;

        @ManyToMany
        @JsonBackReference
        @JoinTable( name = "user_shop",
                joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "shop_id", referencedColumnName = "id")
        )
        List<User> userList = new ArrayList<>();

        @OneToMany
        @JoinColumn(name = "id")
        List<ShopProduct> items_in_shop = new ArrayList<>();

}
