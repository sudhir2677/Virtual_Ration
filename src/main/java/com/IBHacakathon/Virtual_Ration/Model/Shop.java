package com.IBHacakathon.Virtual_Ration.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "shops")
@Getter
@Setter
public class Shop extends Auditable {


        String address;

        @OneToOne(fetch = FetchType.LAZY,
                cascade =  CascadeType.ALL,
                mappedBy = "shop")
        Vendor vendor;

        int storageCapacity;

        Double latitude;

        Double longitude;

        @Enumerated(EnumType.STRING)
        ShopStatus shopStatus;

        @ManyToMany
        @JsonBackReference
        @JoinTable( name = "user_shop",
                joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "shop_id", referencedColumnName = "id")
        )
        List<User> userList = new ArrayList<>();

        /*@OneToMany
        @JoinColumn(name = "id")
        List<ShopProduct> items_in_shop = new ArrayList<>();*/

        /*@AttributeOverrides({
                @AttributeOverride(name = "product_id", column = @Column(name = "id"))
        })*/
        @ElementCollection(fetch = FetchType.LAZY)
        @CollectionTable(name = "shop_product", joinColumns = @JoinColumn(name = "shop_id"))
        private Set<ShopProduct> items_in_shop = new HashSet<>();
}
