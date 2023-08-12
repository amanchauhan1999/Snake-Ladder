package com.example.snakeandladder;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;


public class player {
     private Circle coin;
     private int currPosition;
     private String name;
     static Board gameBoard = new Board();

   public player(int tilesize, Color coinColor , String playerName){
       coin = new Circle( tilesize /2);
       coin.setFill(coinColor);
       currPosition=0;
       movePlayer(1);
       name=playerName;
   }
   public void movePlayer(int diceValue){
       if(currPosition+diceValue<=100)
            currPosition += diceValue;

       TranslateTransition secondMove=null ,firstMoves = translateAnimation(diceValue);
       translateAnimation(diceValue);

       int newPos = gameBoard.getNewPosition(currPosition);
       if (newPos!=currPosition&&newPos!=-1){
           currPosition=newPos;
//
          secondMove=translateAnimation(6);
       }
       if(secondMove==null){
           firstMoves.play();
       }else{
           SequentialTransition sequentialTransition = new SequentialTransition(firstMoves,new PauseTransition(Duration.millis(700)),secondMove);
           sequentialTransition.play();
       }
   }

   private TranslateTransition translateAnimation(int diceValue){
       TranslateTransition animate = new TranslateTransition(Duration.millis(200*diceValue),coin);
       animate.setToX(gameBoard.getXCoordinate(currPosition));
       animate.setToY(gameBoard.getYCoordinate(currPosition));
       animate.setAutoReverse(false);
       return animate;
   }
    boolean isWinner(){
       if (currPosition==100){
           return true;
       }
           return false;
    }
    public int getCurrPosition() {
        return currPosition;
    }

    public String getName() {
        return name;
    }

    public Circle getCoin() {
       return coin;
    }
}
