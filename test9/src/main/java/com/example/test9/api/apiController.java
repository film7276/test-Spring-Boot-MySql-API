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

    /* ถ้าเรียก localhost:8080/userinfo ให้โชว์ข้อมูลทั้งหมดในตาราง "userinfo"  */
    @GetMapping("/userinfo")
    public List<user> getAllUser() {
        return userRepository.findAll();
    }

    /* ถ้าเรียก localhost:8080/userinfo/1(เลขIDของข้อมูล) ให้นำเลขมาค้นหา และโชว์ข้อมูลที่เรียก */
    @GetMapping("/userinfo/{id}")
    public user getUserById(@PathVariable(value = "id") Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
    }

    /* อัพเดทเบอร์โทร(PUT) localhost:8080/userinfo/1(เลขIDของข้อมูล) ส่งค่าเบอร์โทรใหม่{"tel": "0123456789"} */
    @PutMapping("/userinfo/{id}")
    public user updateUser(@PathVariable(value = "id") Long userId,
                           @Valid @RequestBody user userDetails) {

        user user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));

        user.setTel(userDetails.getTel());

        user updatedUser = userRepository.save(user);
        return updatedUser;
    }
}
