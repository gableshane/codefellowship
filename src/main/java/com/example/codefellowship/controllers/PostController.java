package com.example.codefellowship.controllers;

import com.example.codefellowship.models.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.*;

import java.security.*;
import java.util.*;

@Controller
public class PostController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @PostMapping("/post")
    public RedirectView createPost(String body, Principal p, Model m){
        AppUser poster = userRepository.findByUsername(p.getName());
        Post newPost = new Post(body,poster);
        postRepository.save(newPost);
        return new RedirectView("/myprofile");
    }
    @GetMapping("/feed")
    public String showFeed(Principal p, Model m){
        AppUser user = userRepository.findByUsername(p.getName());
        List<AppUser> usersUserIsFollowing = user.getUsersThatIAmFollowing();
        m.addAttribute("usersUserIsFollowing",usersUserIsFollowing);
        return "feed";
    }
}
