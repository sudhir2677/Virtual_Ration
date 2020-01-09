package com.IBHacakathon.Virtual_Ration.Model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usershops")
public class UserShop extends Auditable {

    @NotNull
    Long userId;
    @NotNull
    Long shopId;

}
