package com.example.buoi9.controller;

import com.example.buoi9.dto.UserDTO;
import com.example.buoi9.enums.EnumRole;
import com.example.buoi9.jwt.JwtUtils;
import com.example.buoi9.model.Role;
import com.example.buoi9.model.User;
import com.example.buoi9.repo.RoleRepository;
import com.example.buoi9.repo.UserRepository;
import com.example.buoi9.request.LoginRequest;
import com.example.buoi9.response.UserResponse;
import com.example.buoi9.service.UserDetailImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {


        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                        loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailImp userDetailImp = (UserDetailImp) authentication.getPrincipal();
        try {
            String accessToken = jwtUtils.generateTokenByUsername(userDetailImp.getUsername());
            String refreshToken = jwtUtils.generateRefreshTokenByUsername(userDetailImp.getUsername());
            return ResponseEntity.ok(new UserResponse(
                    userDetailImp.getId(),
                    userDetailImp.getFullName(),
                    accessToken,
                    refreshToken,
                    userDetailImp.getAuthorities()
            ));
        } catch (Exception e) {
            return ResponseEntity.ok("Login failed : " + e.getMessage());
        }
    }

    @PostMapping("/create_new_user")
    public ResponseEntity<?> createNewUser(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setFullName(userDTO.getFullName());
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        Role role = roleRepository.findRoleByRoleName(EnumRole.ROLE_USER);
        user.setRole(role);
        return ResponseEntity.ok().body(userRepository.save(user));
    }
    @GetMapping("/user/get_user_by_id/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            return ResponseEntity.ok().body("User not found with id : " + id);
        }
        return ResponseEntity.ok().body(user.get());
    }
    @GetMapping("/admin/get_all_user")
    public ResponseEntity<?> getAllUser() {
        return ResponseEntity.ok().body(userRepository.findAll());
    }
}
