package com.Sutherland.Game.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "items")
@Getter
@Setter
public class Item extends Auditable {

    @NotNull
    Long invoice_id;
    @NotNull
    Long product_id;

}
