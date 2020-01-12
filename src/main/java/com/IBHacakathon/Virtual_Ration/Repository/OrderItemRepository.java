package com.IBHacakathon.Virtual_Ration.Repository;

import com.IBHacakathon.Virtual_Ration.Model.OrderedItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderedItem, Long> {
}
