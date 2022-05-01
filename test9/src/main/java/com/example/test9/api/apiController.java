package com.example.test9.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class apiController {
    @Autowired
    userRepository userRepository;
    /* ถ้าเรียก /userinfo ให้โชว์ข้อมูลทั้งหมดในตาราง "userinfo"  */
    @GetMapping("/userinfo")
    public List<user> getAllUser() {
        return userRepository.findAll();
    }
    /* ถ้าเรียก /userinfo/เลขของข้อมูล ให้นำเลขมาค้นหา และโชว์ข้อมูลที่เรียก */
    @GetMapping("/userinfo/{id}")
    public user getUserById(@PathVariable(value = "id") Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
    }

    @PutMapping("/userinfo/{id}")
    public user updateUser(@PathVariable(value = "id") Long userId,
                           @Valid @RequestBody user userDetails) {

        user user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));

        user.setTel(userDetails.getTel());

        user updatedUser = userRepository.save(user);
        return updatedUser;
    }

    /*public Optional<user> getUserById(@PathVariable(value = "id") Long userId) {
        return userRepository.findById(userId);
    }*/


}
