package com.nouhoun.springboot.jwt.integration.controller;

import com.nouhoun.springboot.jwt.integration.domain.RandomCity;
import com.nouhoun.springboot.jwt.integration.domain.User;
import com.nouhoun.springboot.jwt.integration.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by nydiarra on 06/05/17.
 */
@RestController
@RequestMapping("/springjwt")
public class ResourceController {
    private final GenericService genericService;

    public ResourceController(GenericService genericService) {
        this.genericService = genericService;
    }

    @GetMapping("/cities")
    @PreAuthorize("hasAnyAuthority('ADMIN_USER', 'STANDARD_USER')")
    public List<RandomCity> getAllRandomCities() {
        return genericService.findAllRandomCities();
    }

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public List<User> getAllUsers() {
        return genericService.findAllUsers();
    }
}
