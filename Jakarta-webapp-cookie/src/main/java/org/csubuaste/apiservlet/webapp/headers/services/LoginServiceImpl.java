package org.csubuaste.apiservlet.webapp.headers.services;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.Optional;

public class LoginServiceImpl implements ILoginService{
    @Override
    public Optional<String> getUsername(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies()!=null?request.getCookies():new Cookie[0];
        return Arrays.stream(cookies)
                .filter(x->"username".equals(x.getName()))
                //.map(c->c.getValue())
                .map(Cookie::getValue)
                .findAny();
    }
}
