package com.prs.SnakeAndLadder.model;

import lombok.Getter;

@Getter
public abstract class BoardEntity {
    private final Integer start;
    private final Integer end;

    protected BoardEntity(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    public abstract void message();
}
