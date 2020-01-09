package com.IBHacakathon.Virtual_Ration.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "shopproduct")
@Getter
@Setter
public class ShopProduct extends Auditable{
    @JoinColumn(name = "itemName")
    Category category;
    int quantity;
}
