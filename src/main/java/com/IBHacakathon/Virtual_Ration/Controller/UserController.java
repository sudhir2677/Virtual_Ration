package com.IBHacakathon.Virtual_Ration.Controller;

import com.IBHacakathon.Virtual_Ration.Exception.ApiException;
import com.IBHacakathon.Virtual_Ration.Model.User;
import com.IBHacakathon.Virtual_Ration.Repository.UserRepository;
import com.IBHacakathon.Virtual_Ration.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class UserController {

    //for login
    @Autowired
    UserService userService;

    @GetMapping("/user/login/{emailId}/{password}")
    public User userLogin(@PathVariable(value = "emailId") String emailId,
                          @PathVariable(value="password") String password,
                          HttpSession session) throws ApiException{

         User user = userService.userLogin(emailId,password);
         if(user!=null){
             session.setAttribute("userId",user.getId());
         }
        return user;
    }

    // for updating uder address
    // Pass string object
    @PutMapping("/user/changeAddress")
    public User userChangeAddress(@RequestBody User user, HttpSession session) throws ApiException {
         Long id = (Long)session.getAttribute("userId");
         return userService.changeAddress(user.getAddress(),id);
    }


    // for updating user longitude and latitude
    // pass latitude and longitude in object
    @PutMapping("/user/coordinates")
    public User userChangeCoordinates(@RequestBody User user , HttpSession session) throws ApiException{

        return userService.changeCoordinates(user.getLatitude(),user.getLongitute(),Long.parseLong((String)session.getAttribute("userId")));
    }

    //for logout
    @GetMapping("/user/logout")
    public String logout(HttpSession session){
        session.removeAttribute("userId");
        return "logout successfully!!";
    }


    @PostMapping("/user/register")
    public Integer registerUser(@RequestBody User user){
        return userService.register(user);
    }
}
