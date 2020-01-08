package com.Sutherland.Game.Model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usershops")
public class UserShop {

    @NotNull
    Long userId;
    @NotNull
    Long shopId;

}
