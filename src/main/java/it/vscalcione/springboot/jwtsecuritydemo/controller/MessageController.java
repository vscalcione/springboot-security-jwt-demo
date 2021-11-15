package it.vscalcione.springboot.jwtsecuritydemo.controller;

import it.vscalcione.springboot.jwtsecuritydemo.model.JwtRequest;
import it.vscalcione.springboot.jwtsecuritydemo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String getMessage() {
        return "Spring Boot with JWT";
    }

    @PostMapping("/generateToken")
    public String generateToken(@RequestBody JwtRequest request) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(), request.getPassword()
                    ));
        } catch (Exception e) {
            throw new Exception("Invalid Credentials");
        }
        return jwtUtil.generateToken(request.getUsername());
    }
}
