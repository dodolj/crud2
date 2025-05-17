package org.example.model;

import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class User {

    private UUID id;
    private String name;
    private String password;
}