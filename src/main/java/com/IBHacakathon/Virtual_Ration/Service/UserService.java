package com.IBHacakathon.Virtual_Ration.Service;

import com.IBHacakathon.Virtual_Ration.Exception.ApiException;
import com.IBHacakathon.Virtual_Ration.Model.User;
import com.IBHacakathon.Virtual_Ration.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User userLogin(String email,String password) throws ApiException{
        User user = userRepository.findByEmailAndPassword(email,password);
    //    User user = userRepository.findById(1L).get();
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

    public User changeCoordinates(Double latitude, Double longitude, long userId) throws ApiException {
        User user = userRepository.findById(userId).get();
        if(Objects.isNull(user))
            throw new ApiException("User not found");
        user.setLatitude(latitude);
        user.setLongitute(longitude);
        userRepository.save(user);
        return user;
    }

    public User addUser(String name, Integer familyMember) {
        User user = new User();
        user.setNoOfFamilyMember(familyMember);
        user.setName(name);
        userRepository.save(user);
        return user;
    }
}
