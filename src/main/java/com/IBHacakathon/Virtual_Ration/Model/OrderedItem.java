package com.IBHacakathon.Virtual_Ration.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ordereditem")
@Getter
@Setter
public class OrderedItem extends Auditable {

    String productName;

    Double price;

    Double quantity;

    @ManyToOne
    @JoinColumn
    Order order;
}
