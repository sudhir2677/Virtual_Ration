package com.Sutherland.Game.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product extends Auditable {

    @NotBlank
    String productName;
    @NotNull
    Double price;
    @NotNull
    Double quantity;
    @NotNull
    Double vat;
}
