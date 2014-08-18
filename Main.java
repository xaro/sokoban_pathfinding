package com.poo.sobokan.pathfind;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class Main {
    public static Vector<String> board;
    public static Queue<Position> visitedNodes;

    public static void main(String[] args) throws IOException {
        board = new Vector<String>();
        Queue<Movement> queue = new LinkedList<Movement>();
        boolean goalFound = false;

        visitedNodes = new LinkedList<Position>();

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        String line;
        while(br.ready()) {
            line = br.readLine();
            board.add(line);
        }

        for (String row : Main.board) {
            if(row.indexOf('+') != -1) {
                System.out.println();
                return;
            }
        }

        // Do a breadth first search through the map
        queue.add(new Movement(Position.findStartPosition(), null));
        visitedNodes.add(Position.findStartPosition());

        while (!queue.isEmpty()) {
            Movement movement = queue.remove();

            if(movement.pos.isGoal()) {
                goalFound = true;

                // Backtrack the movements
                String output = new String();
                while (movement.parent != null) {
                    output += movement.direction;
                    movement = movement.parent;
                }

                // Reverse the output as we want the order to be Start -> Goal
                System.out.println(new StringBuffer(output).reverse().toString());
                break;
            } else {
                if(movement.pos.getNeighbour('U').isValidMovementSpace() && !movement.pos.getNeighbour('U').isVisited()) {
                    visitedNodes.add(movement.pos.getNeighbour('U'));
                    queue.add(new Movement(movement.pos.getNeighbour('U'), 'U', movement));
                }
                if(movement.pos.getNeighbour('D').isValidMovementSpace() && !movement.pos.getNeighbour('D').isVisited()) {
                    visitedNodes.add(movement.pos.getNeighbour('D'));
                    queue.add(new Movement(movement.pos.getNeighbour('D'), 'D', movement));
                }
                if(movement.pos.getNeighbour('R').isValidMovementSpace() && !movement.pos.getNeighbour('R').isVisited()) {
                    visitedNodes.add(movement.pos.getNeighbour('R'));
                    queue.add(new Movement(movement.pos.getNeighbour('R'), 'R', movement));
                }
                if(movement.pos.getNeighbour('L').isValidMovementSpace() && !movement.pos.getNeighbour('L').isVisited()) {
                    visitedNodes.add(movement.pos.getNeighbour('L'));
                    queue.add(new Movement(movement.pos.getNeighbour('L'), 'L', movement));
                }
            }
        }

        if (!goalFound)
            System.out.println("no path");
    }
}