package com.example.test9.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Optional<user> getUserById(@PathVariable(value = "id") Long userId) {
        return userRepository.findById(userId);
    }
}
