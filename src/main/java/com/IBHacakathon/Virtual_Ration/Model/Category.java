package com.IBHacakathon.Virtual_Ration.Model;

import javax.persistence.ManyToOne;

public class Category extends Auditable {

    String itemName;
    Double priceBpl;
    Double priceApl;
}
