package com.example.codefellowship.controllers;

import com.example.codefellowship.models.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.security.core.context.*;
import org.springframework.security.crypto.password.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.*;

import java.security.*;
import java.util.*;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public RedirectView registerUser(String username,String password, String firstName, String lastName, String bio, String favoriteFood){

        AppUser newUser = new AppUser(username,passwordEncoder.encode(password),firstName,lastName,bio,favoriteFood);

        userRepository.save(newUser);

        Authentication authentication = new UsernamePasswordAuthenticationToken(newUser, null, new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new RedirectView("/myprofile");
    }
    @GetMapping("/signup")
    public String getRegistrationPage(){
        return "register";
    }

    @GetMapping("/myprofile")
    public String profilePage(Principal p, Model m){

        if(p != null){

            AppUser user = userRepository.findByUsername(p.getName());

            m.addAttribute("username",user.getUsername());

            m.addAttribute("firstName",user.getFirstName());

            m.addAttribute("lastName",user.getLastName());

            m.addAttribute("bio",user.getBio());

            m.addAttribute("favoriteFood",user.getFavoriteFood());

            m.addAttribute("posts",user.getPosts());
        }

        return "myprofile";
    }

    @GetMapping("/users")
    public String viewUsers(Principal p,Model m){
        List<AppUser> users = userRepository.findAll();
        users.remove(userRepository.findByUsername(p.getName()));
        m.addAttribute("users",users);
        return "users";
    }
    @PostMapping("/view")
    public String viewUser(long id, Model m){

        AppUser user = userRepository.findById(id).get();

        m.addAttribute("username",user.getUsername());

        m.addAttribute("firstName",user.getFirstName());

        m.addAttribute("lastName",user.getLastName());

        m.addAttribute("bio",user.getBio());

        m.addAttribute("favoriteFood",user.getFavoriteFood());

        m.addAttribute("posts",user.getPosts());

        m.addAttribute("id",user.getId());

        return "profile";
    }
    @GetMapping("/view/{id}")
    public String viewUserGet(@PathVariable long id, Model m){

        AppUser user = userRepository.findById(id).get();

        m.addAttribute("username",user.getUsername());

        m.addAttribute("firstName",user.getFirstName());

        m.addAttribute("lastName",user.getLastName());

        m.addAttribute("bio",user.getBio());

        m.addAttribute("favoriteFood",user.getFavoriteFood());

        m.addAttribute("posts",user.getPosts());

        m.addAttribute("id",user.getId());

        return "profile";
    }

    @PostMapping("/follow")
    public RedirectView followUser(long id, Principal p){

        AppUser user = userRepository.findByUsername(p.getName());
        AppUser userToFollow = userRepository.findById(id).get();
        user.addUserToFollow(userToFollow);
        userRepository.save(user);
        return new RedirectView("/feed");
    }

}
