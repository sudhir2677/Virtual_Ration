package com.IBHacakathon.Virtual_Ration.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User extends Auditable{

    String name;
    String email;
    int noOfFamilyMember;
    CardType cardType;
    String address;
    Double longitute;
    Double latitude;

}
