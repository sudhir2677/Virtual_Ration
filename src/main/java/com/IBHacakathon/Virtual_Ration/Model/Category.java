package com.IBHacakathon.Virtual_Ration.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToOne;

@Getter
@Setter
public class Category extends Auditable {

    String itemName;
    Double priceBpl;
    Double priceApl;
}
