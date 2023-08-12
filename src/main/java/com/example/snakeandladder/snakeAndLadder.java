package com.example.snakeandladder;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class snakeAndLadder extends Application {
    public static final int tilesize = 40, height=10,widhth=10;
    public static final int buttonLine=height*tilesize+50,infoLine = buttonLine-30;
    private final dice Dice = new dice();
    private player player1,player2;

    private boolean gameStarted = false,PlayerOneTurn=true,PlayerTwoTurn=false;
    private Pane createContent(){
        Pane root = new Pane();
        root.setPrefSize(widhth*tilesize,height*tilesize+100);


        for (int i = 0; i < height ; i++){
            for (int j = 0 ; j < widhth ; j++){
                tile Tile = new tile(tilesize);
                root.getChildren().add(Tile);
                Tile.setTranslateX(j*tilesize);
                Tile.setTranslateY(i*tilesize);
            }
        }
        Image img = new Image("C:\\Users\\amanc\\IdeaProjects\\snakeAndLadder\\src\\main\\ladder&snakes.jpg");
        ImageView board = new ImageView();
        board.setImage(img);
        board.setFitHeight(height*tilesize);
        board.setFitWidth(widhth*tilesize);


        //Buttons

        Button playerOneButton = new Button("Player 1");
        Button playerTwoButton = new Button("Player 2");
        Button start = new Button("Start");


        playerOneButton.setTranslateY(buttonLine);
        playerOneButton.setTranslateX(20);
        playerTwoButton.setTranslateY(buttonLine);
        playerTwoButton.setTranslateX(300);
        start.setTranslateY(buttonLine);
        start.setTranslateX(160);

        //InfoDisplay

        Label playerOneLabel = new Label("Your turn!");
        Label playerTwoLabel = new Label("Your turn!");
        Label diceLabel = new Label("Start the Game");


        playerOneLabel.setTranslateY(infoLine);
        playerOneLabel.setTranslateX(20);
        playerTwoLabel.setTranslateY(infoLine);
        playerTwoLabel.setTranslateX(300);
        diceLabel.setTranslateY(infoLine);
        diceLabel.setTranslateX(160);

        player1 = new player(tilesize, Color.BLACK,"Player 1");
        player2 = new player(tilesize-10,Color.WHITE,"Player 2");

        //player action

        playerOneButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (gameStarted){
                    if (PlayerOneTurn){
                        int diceValue = Dice.getRolledDiceValue();
                        diceLabel.setText("Dice Value :"+diceValue);
                        player1.movePlayer(diceValue);
                        //winning condition
                        if(player1.isWinner()){
                            diceLabel.setText("Winner is "+player1.getName());

                            PlayerOneTurn = false;
                            playerOneButton.setDisable(true);
                            playerOneLabel.setText("");

                            PlayerTwoTurn = true;
                            playerTwoButton.setDisable(true);
                            playerTwoLabel.setText("");
                            start.setDisable(false);
                            start.setText("Restart Game");
                            gameStarted=false;
                        }
                        else{
                        PlayerOneTurn = false;
                        playerOneButton.setDisable(true);
                        playerOneLabel.setText("");

                        PlayerTwoTurn = true;
                        playerTwoButton.setDisable(false);
                        playerTwoLabel.setText("Your Turn "+player2.getName());
                        }
                    }
                }
            }
        });

        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gameStarted = true;
                diceLabel.setText("Game Started");
                start.setDisable(true);
                PlayerOneTurn=true;
                playerOneButton.setDisable(false);
                playerOneLabel.setText("Your Turn "+player1.getName());
                PlayerTwoTurn=false;
                playerTwoLabel.setText("");
                playerTwoButton.setDisable(true);
            }
        });

playerTwoButton.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent actionEvent) {
        if (gameStarted){
            if (PlayerTwoTurn){
                int diceValue = Dice.getRolledDiceValue();
                diceLabel.setText("Dice Value :"+diceValue);
                player2.movePlayer(diceValue);
                //winning condition
                if (player2.isWinner()){
                    diceLabel.setText("Winner is "+player2.getName());

                    PlayerOneTurn = false;
                    playerOneButton.setDisable(true);
                    playerOneLabel.setText("");

                    PlayerTwoTurn = true;
                    playerTwoButton.setDisable(true);
                    playerTwoLabel.setText("");

                    start.setDisable(false);
                    start.setText("Restart Game");
                    gameStarted = false;
                }else {
                    PlayerOneTurn = true;
                    playerOneButton.setDisable(false);
                    playerOneLabel.setText("Your Turn "+player1.getName());

                    PlayerTwoTurn = false;
                    playerTwoButton.setDisable(true);
                    playerTwoLabel.setText("Your Turn "+player2.getName());
                }
            }
        }
    }
});
        root.getChildren().addAll(board,playerOneButton,playerTwoButton,start,playerOneLabel,playerTwoLabel,diceLabel,player1.getCoin(),player2.getCoin());

        return root;
    }
    @Override
    public void start(Stage stage) {

        Scene scene = new Scene(createContent());
        stage.setTitle("Snake And Ladder");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();

    }
}