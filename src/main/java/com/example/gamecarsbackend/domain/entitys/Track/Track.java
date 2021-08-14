package com.example.gamecarsbackend.domain.entitys.Track;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Track {
    @Id
    private String trackId;
    private Integer trackDistance;
    private String gameId;
    private String podiumId;
}
