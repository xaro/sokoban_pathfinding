package com.poo.sobokan.pathfind;

public class Movement {
    Character direction;

    // Current position after the movement
    Position pos;

    // Previous movement
    Movement parent;

    // Constructor used for the first movement
    public Movement(Position pos, Character direction) {
        this.pos = pos;
        this.direction = direction;
        this.parent = null;
    }

    public Movement(Position pos, Character direction, Movement parent) {
        this.pos = pos;
        this.direction = direction;
        this.parent = parent;
    }
}
