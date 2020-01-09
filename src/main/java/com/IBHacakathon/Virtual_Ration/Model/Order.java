package com.IBHacakathon.Virtual_Ration.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order extends  Auditable {

    @NotNull
    User user;

    List<OrderedItem> orderedItemList = new ArrayList<>();

    @NotNull
    DeliveryType deliveryType;
}
