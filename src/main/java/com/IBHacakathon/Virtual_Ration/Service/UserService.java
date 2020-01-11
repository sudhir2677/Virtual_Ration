package com.IBHacakathon.Virtual_Ration.Service;

import com.IBHacakathon.Virtual_Ration.Exception.ApiException;
import com.IBHacakathon.Virtual_Ration.Model.Order;
import com.IBHacakathon.Virtual_Ration.Model.User;
import com.IBHacakathon.Virtual_Ration.Repository.OrderRepository;
import com.IBHacakathon.Virtual_Ration.Repository.UserRepository;
import com.IBHacakathon.Virtual_Ration.Utility.MailService;
import com.IBHacakathon.Virtual_Ration.Utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MailService mailService;

    @Autowired
    OrderRepository orderRepository;

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

    public Integer register(User user) {
        User newUser = userRepository.findByRationCard(user.getRationCard());
        if(newUser == null)return 0;
        if(!newUser.getEmail().equals(user.getEmail())){
            return 0;
        }
        newUser.setIsRegisteredUser(true);

        int passwordLength = 8;
        String password = RandomString.generateString(passwordLength);

        newUser.setPassword(password);
        userRepository.save(newUser);

        String subject = "Password for PDS virtual ration";
        String message = "Thank you for login <br> Your new Generated password is: "+password;
        mailService.sendMail(newUser.getEmail(), subject, message);
        return 1;
    }

    public User addUser(User user) {
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setNoOfFamilyMember(user.getNoOfFamilyMember());
        newUser.setRationCard(user.getRationCard());
        newUser.setCardType(user.getCardType());
        userRepository.save(newUser);
        return user;
    }

    public Boolean checkIsRationBookedThisMonth(Long id){
        User user = userRepository.findById(id).get();
        List<Order> orders = orderRepository.findAllByUser(user);
        LocalDateTime localDateTime = LocalDateTime.now();
        String todayMonth = DateTimeFormatter.ofPattern("MMYYYY", Locale.ENGLISH).format(localDateTime);
        for (Order order: orders) {
            String lastDate = DateTimeFormatter.ofPattern("MMYYYY", Locale.ENGLISH).format((TemporalAccessor)order.getCreatedAt());
            if(lastDate.equals(todayMonth)){
                return true;
            }
        }
        return false;
    }

    public 

}
