package com.example.snakeandladder;

import javafx.util.Pair;

import java.util.ArrayList;

public class Board {
    ArrayList<Pair<Integer,Integer>>positionCoordinates;

    ArrayList<Integer> snakeLadderPosition;
    public Board(){
        positionCoordinates=new ArrayList<>();
        populatePositionCoordinates();
        populateSnakeLadder();
    }
    private void populatePositionCoordinates(){
        positionCoordinates.add(new Pair<> (0,0));
        for (int i = 0; i < snakeAndLadder.height; i++) {
            for (int j = 0; j < snakeAndLadder.widhth; j++) {
                // x coordinates
                int xCoordinate;
                if (i % 2 == 0) {
                    xCoordinate = j * snakeAndLadder.tilesize + snakeAndLadder.tilesize / 2;
                } else {
                    xCoordinate = snakeAndLadder.tilesize * snakeAndLadder.height - (j * snakeAndLadder.tilesize) - snakeAndLadder.tilesize / 2;
                }
                // y coordinates
                int yCoordinate = snakeAndLadder.tilesize * snakeAndLadder.height - (i * snakeAndLadder.tilesize) - snakeAndLadder.tilesize / 2;

                positionCoordinates.add(new Pair<>(xCoordinate, yCoordinate));
            }
            }
        }

        private void populateSnakeLadder(){
        snakeLadderPosition = new ArrayList<>();
            for (int i = 0; i < 101; i++) {
                snakeLadderPosition.add(i);
            }
            snakeLadderPosition.set(3,24);
            snakeLadderPosition.set(6,33);
            snakeLadderPosition.set(20,43);
            snakeLadderPosition.set(34,56);
            snakeLadderPosition.set(50,68);
            snakeLadderPosition.set(58,87);
            snakeLadderPosition.set(62,83);
            snakeLadderPosition.set(72,91);
            snakeLadderPosition.set(32,9);
            snakeLadderPosition.set(35,4);
            snakeLadderPosition.set(59,25);
            snakeLadderPosition.set(73,31);
            snakeLadderPosition.set(93,55);
            snakeLadderPosition.set(96,63);
            snakeLadderPosition.set(98,41);


        }
        public int getNewPosition(int currPos){
        if (currPos>0&&currPos<=100){
            return snakeLadderPosition.get(currPos);
        }return -1;
        }
        int getXCoordinate(int position) {
            if (position >= 1 && position <= 100)
                return positionCoordinates.get(position).getKey();
            return -1;
        }
        int getYCoordinate(int position){
            if (position>=1&&position<=100)
                 return positionCoordinates.get(position).getValue();

            return -1;
        }

//    public static void main(String[] args) {
//         Board board = new Board();
//        for (int i = 0; i < board.positionCoordinates.size(); i++) {
//            System.out.println(i + "  $  X :" + board.positionCoordinates.get(i).getKey() );
//        }
//    }
}
