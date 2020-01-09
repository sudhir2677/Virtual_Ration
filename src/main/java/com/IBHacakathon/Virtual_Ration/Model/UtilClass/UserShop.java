package com.IBHacakathon.Virtual_Ration.Model.UtilClass;

import com.IBHacakathon.Virtual_Ration.Model.Auditable;

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
