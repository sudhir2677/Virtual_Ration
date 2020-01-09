package com.IBHacakathon.Virtual_Ration.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "category")
@Getter
@Setter
public class SuperCategory extends Auditable{
    String itemName;
    Double priceBpl;
    Double priceApl;
    int quantity;
}
