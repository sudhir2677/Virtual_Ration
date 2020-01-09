package com.IBHacakathon.Virtual_Ration.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "shopproduct")
@Getter
@Setter
public class ShopProduct extends Auditable{
    Long shopId;
    String productName;
    int quantity;
}
