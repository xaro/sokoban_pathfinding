package com.poo.sobokan.pathfind;

public class Position {
    private int posX;
    private int posY;

    static public Position findStartPosition() {
        int i = 0;
        for (String row : Main.board) {
            if(row.indexOf('@') != -1) {
                return new Position(row.indexOf('@'), i);
            }
            i++;
        }
        return null;
    }

    public Position(int x, int y) {
        setPosX(x);
        setPosY(y);
    }

    public Position(Position pos) {
        setPosX(pos.getPosX());
        setPosY(pos.getPosY());
    }

    public boolean isGoal() {
        return (Main.board.get(getPosY()).charAt(getPosX()) == '.');
    }

    public boolean isWall() {
        return (Main.board.get(getPosY()).charAt(getPosX()) == '#');
    }

    public boolean isValidMovementSpace() {
        return (isEmpty() || isGoal());
    }

    public boolean isEmpty() {
        (Main.board.get(getPosY()).charAt(getPosX()) == ' ');
    }

    public void print() {
        System.out.print("(" + getPosX() + ", "+ getPosY() +")\n");
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public boolean equals(Position pos) {
        if (pos == null)
            return false;
        if (pos == this)
            return false;
        if (pos.getPosY() == getPosY() && pos.getPosX() == getPosX())
            return true;
        return false;
    }

    public Position getNeighbour(Character direction) {
        int x = posX;
        int y = posY;
        switch (direction) {
            case 'U':
                y = posY - 1;
                break;
            case 'D':
                y = posY + 1;
                break;
            case 'L':
                x = posX - 1;
                break;
            case 'R':
                x = posX + 1;
                break;
        }

        return new Position(x, y);
    }

    public boolean isVisited() {
        for (Position pos : Main.visitedNodes) {
            if(pos.equals(this))
                return true;
        }
        return false;
    }
}
