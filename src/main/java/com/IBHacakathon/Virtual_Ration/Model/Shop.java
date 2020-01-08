package com.Sutherland.Game.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "shops")
@Getter
@Setter
public class Shop extends Auditable {

        @NotBlank
        String address;
        @NotNull
        int storageCapacity;
        @NotNull
        Double latitude;
        @NotNull
        Double longitude;
        @NotNull
        Status shopStatus;
}
