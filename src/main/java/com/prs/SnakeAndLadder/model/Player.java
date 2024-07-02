package com.prs.SnakeAndLadder.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {

    private final String playerId;
    private Integer position;

    public Player(String playerId) {
        this.playerId = playerId;
        this.position = 0;
    }

    @Override
    public String toString() {
        return playerId + "'s position: " + position;
    }
}
