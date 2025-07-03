package org.csubuaste.apiservlet.webapp.headers.services;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

public interface ILoginService {
    Optional<String> getUsername(HttpServletRequest request);
}
