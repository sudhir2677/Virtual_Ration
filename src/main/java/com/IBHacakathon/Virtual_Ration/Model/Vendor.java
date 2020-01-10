package com.IBHacakathon.Virtual_Ration.Model;

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

    @NotBlank
    String name;
    @NotBlank
    String emailId;

    String password;

    @NotBlank
    String address;

    @OneToOne
    @JoinColumn(name = "vendor")
    Shop shop;

}
