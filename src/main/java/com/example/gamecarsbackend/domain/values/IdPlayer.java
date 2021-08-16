package com.example.gamecarsbackend.domain.values;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;
@Getter
@AllArgsConstructor
public class IdPlayer {
    private final String id;



    public static IdPlayer of(String id) {
        return new IdPlayer(id);
    }


}
