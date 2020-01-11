package com.IBHacakathon.Virtual_Ration.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "vendors")
@Getter
@Setter
public class Vendor extends Auditable {


    String name;

    String emailId;

    String password;

    String address;

    @OneToOne
    @JoinColumn(name = "shop_id", nullable = false)
    Shop shop;

}
