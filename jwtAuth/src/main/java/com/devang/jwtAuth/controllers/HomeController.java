package com.devang.jwtAuth.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.devang.jwtAuth.models.AppUsers;
import com.devang.jwtAuth.repos.MyUserRepository;
import com.devang.jwtAuth.services.JwtService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class HomeController {

    @Autowired
    MyUserRepository repo;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/resource")
    public String resource() {
        return "u've accessed the protected resource via JwtAuth";
    }

    @PostMapping("/login")
    public String login(@RequestBody String entity) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(entity);
            
            String username = jsonNode.get("username").asText();
            String password = jsonNode.get("password").asText();
            
            AppUsers user = repo.findUserByUsername(username);
            
            if (user != null && passwordEncoder.matches(password, user.getPassword())) {
                return new JwtService().generateToken(username);
            } else {
                return "Invalid username or password";
            }
        } catch (Exception e) {
            return "Error processing request: " + e.getMessage();
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody AppUsers user) {
        if (repo.findUserByUsername(user.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username taken");
        } else {
            repo.save(new AppUsers(user.getUsername(), passwordEncoder.encode(user.getPassword())));
            System.out.println(user.getUsername() + " added successfully");
            return ResponseEntity.ok(user.getUsername() + " registered successfully.");
        }
    }
}