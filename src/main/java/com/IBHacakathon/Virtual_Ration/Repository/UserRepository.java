package com.IBHacakathon.Virtual_Ration.Repository;

import com.IBHacakathon.Virtual_Ration.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {
     User findByEmailAndPassword(String email, String password);

     User findByRationCard(String rationCard);

    User findByEmail(String mailId);
}
