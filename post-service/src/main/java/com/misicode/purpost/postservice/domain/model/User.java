package com.misicode.purpost.postservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {
    private String idUser;
    private String username;
    private String names;
    private String surnames;
}
