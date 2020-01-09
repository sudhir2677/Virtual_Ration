package com.IBHacakathon.Virtual_Ration.Repository;

import com.IBHacakathon.Virtual_Ration.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    public User findByEmailAndPassword(String email, String password);
}
