package com.IBHacakathon.Virtual_Ration.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User extends Auditable{

    String name;
    String email;
    String password;
    Integer noOfFamilyMember;

    @Enumerated(EnumType.STRING)
    CardType cardType;
    String address;
    Double longitute;
    Double latitude;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @JsonIgnore
    Shop shop_registered_to;*/

    @OneToOne(mappedBy = "user")
    Order ration_ordered;

    @ManyToMany
    @JoinTable( name = "user_shop",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "shop_id", referencedColumnName = "id")
    )
    List<Shop> shops_he_hasbeenRegisteredTo = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    List<Order> orders_he_has_done = new ArrayList<>();
}
