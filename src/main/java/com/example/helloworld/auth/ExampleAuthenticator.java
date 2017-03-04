package com.example.helloworld.auth;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.example.helloworld.core.User;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

public class ExampleAuthenticator implements Authenticator<BasicCredentials, User> {
    
    @Override
    public Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException {
        if ("secret".equals(credentials.getPassword())) {
        	Set<String> roles = new HashSet<>();
        	roles.add("guest");
        	
            return Optional.of(new User(credentials.getUsername(), roles));
        }
        return Optional.empty();
    }
}
