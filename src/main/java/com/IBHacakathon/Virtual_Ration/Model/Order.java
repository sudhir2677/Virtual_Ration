package com.IBHacakathon.Virtual_Ration.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order extends  Auditable {

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ration_ordered")
    @JsonBackReference
    User user;

    @OneToMany
    @JoinColumn(name = "id")
    List<OrderedItem> orderedItemList = new ArrayList<>();

    @NotNull
    DeliveryType deliveryType;
}
