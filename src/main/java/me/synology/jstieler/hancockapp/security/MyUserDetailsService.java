package me.synology.jstieler.hancockapp.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    @Deprecated
    public UserDetails loadUserByUsername (String userName) throws UsernameNotFoundException {
        return new User("foo", "foo", new ArrayList<>()); //Hardcoded user. dont use in live version
    }

    public void registerUser(User user){

    }

    public String createNewSalt(int len) {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }
}
