package com.Sutherland.Game.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order extends  Auditable {

    @NotNull
    Long userId;
    @NotNull
    Long shopId;
    @NotNull
    DeliveryType deliveryType;

}
