package com.IBHacakathon.Virtual_Ration.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
    Integer noOfFamilyMember;
    CardType cardType;
    String address;
    Double longitute;
    Double latitude;

    @OneToOne(mappedBy = "id")
    Shop shop_registered_to;

    @OneToOne(mappedBy = "user")
    Order ration_ordered;

    @OneToMany(mappedBy = "")
    List<Shop> shops_he_hasbeenRegisteredTo = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    List<Order> orders_he_has_done = new ArrayList<>();
}
