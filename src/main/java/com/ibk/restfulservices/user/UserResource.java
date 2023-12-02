package com.ibk.restfulservices.user;

import com.ibk.restfulservices.service.UserDaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    private UserDaoService service;
    public UserResource(UserDaoService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();

    }
    @GetMapping("/users/{id}")
    public User retrieveUsers(@PathVariable int id) {

        User user = service.findOne(id);
        if (user == null)
            throw new UserNotFoundException("id :" + id);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUsers(@PathVariable int id) {
        service.deleteById(id);

    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
       User savedUser = service.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(null).build();

    }
}

