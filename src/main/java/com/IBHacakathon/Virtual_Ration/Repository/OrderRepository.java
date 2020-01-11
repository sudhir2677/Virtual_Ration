package com.IBHacakathon.Virtual_Ration.Repository;

import com.IBHacakathon.Virtual_Ration.Model.Order;
import com.IBHacakathon.Virtual_Ration.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findAllByUser(User user);
}
