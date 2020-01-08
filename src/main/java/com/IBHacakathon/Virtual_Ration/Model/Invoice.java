package com.Sutherland.Game.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "invoices")
@Setter
@Getter
public class Invoice extends Auditable {

    @NotNull
    Long orderId;

}
