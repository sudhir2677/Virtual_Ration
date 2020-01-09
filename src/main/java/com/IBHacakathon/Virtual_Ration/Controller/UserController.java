package com.IBHacakathon.Virtual_Ration.Controller;

import com.IBHacakathon.Virtual_Ration.Exception.ApiException;
import com.IBHacakathon.Virtual_Ration.Model.User;
import com.IBHacakathon.Virtual_Ration.Service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;
    @GetMapping("/user/login/{emailId}/{password}")
    public User userLogin(@PathVariable(value = "emailId") String emailId,
                          @PathVariable(value="password") String password,
                          HttpSession session) throws ApiException{
         userService = new UserService();
         User user = userService.userLogin(emailId,password);
         if(user!=null){
             session.setAttribute("userId",user.getId());
         }
        return user;
    }

    @PutMapping("/user/changeAddress")
    public User userChangeAddress(@RequestBody String address,HttpSession session) throws ApiException {
         userService = new UserService();
         return userService.changeAddress(address,Long.parseLong((String)session.getAttribute("userId")));
    }

    @GetMapping("/user/logout")
    public String logout(HttpSession session){
        session.removeAttribute("userId");
        return "logout successfully!!";
    }


}
