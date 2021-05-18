package me.synology.jstieler.hancockapp.controller;

import me.synology.jstieler.hancockapp.models.AuthenticationRequest;
import me.synology.jstieler.hancockapp.models.AuthenticationResponse;
import me.synology.jstieler.hancockapp.models.User;
import me.synology.jstieler.hancockapp.repository.UserRepository;
import me.synology.jstieler.hancockapp.security.MyUserDetailsService;
import me.synology.jstieler.hancockapp.service.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class AuthController {

    @Autowired
    AuthenticationManager manager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    MyUserDetailsService userDetailsService;

    @Autowired
    UserRepository userRepo;

    int sizeOfSalt = 20;

    @RequestMapping(value="/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken (@RequestBody AuthenticationRequest request) throws Exception{

        try {
            manager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password");
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);

        return ok(new AuthenticationResponse(token));
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public ResponseEntity<?> registerUser (@RequestBody User user){
        if (userRepo.existsById(user.getEmail()))
           return ResponseEntity.badRequest().body("E-Mail address already in Database.");

        BCryptPasswordEncoder passwordEncoder =  new BCryptPasswordEncoder();
        String salt = userDetailsService.createNewSalt(sizeOfSalt);
        String encodedPassword = passwordEncoder.encode(salt + user.getPassword());
        user.setSalt(salt);
        user.setPassword(encodedPassword);

        userRepo.save(user);

        String token = "hello";

        return ResponseEntity.ok(new AuthenticationResponse(token));
    }


}
