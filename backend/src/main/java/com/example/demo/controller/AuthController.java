package com.example.demo.controller;


import com.example.demo.dto.LoginRequestDto;
import com.example.demo.entity.JwtResponse;
import com.example.demo.jwt_token.JwtUtils;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.IUserService;
import com.example.demo.service.Impl.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {


    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    IUserService iUserService;


    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    IUserRepository iUserRepository;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginRequestDto loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

//        IUserRepository.changeStatus(1,userDetails.getUserId());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getUserId(),
                userDetails.getUsername(),
                userDetails.getUserTime(),
                userDetails.getCustomer(),
                roles));
    }

//    @PatchMapping("singout/{employeeId}")
//    public ResponseEntity<Void> logout(@PathVariable(name = "employeeId") Long employeeId) {
//        accountRepository.changeStatus(0,employeeId);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

}
