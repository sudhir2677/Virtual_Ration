package com.IBHacakathon.Virtual_Ration.Service;

import com.IBHacakathon.Virtual_Ration.Exception.ApiException;
import com.IBHacakathon.Virtual_Ration.Model.User;
import com.IBHacakathon.Virtual_Ration.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;

import java.util.Objects;

public class UserService {

    @Autowired
    UserRepository userRepository;

    public User userLogin(String email,String password) throws ApiException{
        User user = userRepository.findByEmailAndPassword(email,password);
        if(Objects.isNull(user)){
            throw new ApiException("User Not Found");
        }
        return user;
    }


    public User changeAddress(String address,Long Id) throws ApiException {
        User user = userRepository.findById(Id).get();
        if(Objects.isNull(user))
            throw new ApiException("User not found");
         user.setAddress(address);
         userRepository.save(user);
         return user;
    }
}
