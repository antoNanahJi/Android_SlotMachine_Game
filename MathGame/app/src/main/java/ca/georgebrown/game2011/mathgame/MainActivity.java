package ca.georgebrown.game2011.mathgame;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public int playerMoney = 1000;
    int winnings = 0;
    int jackpot = 5000;
    int turn = 0;
    int playerBet = 0;
    int winNumber = 0;
    int lossNumber = 0;
    int winRatio = 0;
    int grapes = 0;
    int bananas = 0;
    int oranges = 0;
    int cherries = 0;
    int bars = 0;
    int bells = 0;
    int sevens = 0;
    int blanks = 0;
    ImageView iv1;
    ImageView iv2;
    ImageView iv3;

    TextView jackpotText;
    TextView playerMoneyText;
    TextView playerBetText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jackpotText = (TextView) findViewById(R.id.Jackpot);
        jackpotText.setText("Jackpot: "+String.valueOf(jackpot) );

        playerMoneyText = (TextView) findViewById(R.id.PlayerMoney);
        playerMoneyText.setText("Player Money: "+String.valueOf(playerMoney));

        playerBetText = (TextView) findViewById(R.id.PlayerBet);
        playerBetText.setText("Player Bet: "+String.valueOf(playerBet));


        iv1 = (ImageView)findViewById(R.id.Image1);
        iv2 = (ImageView)findViewById(R.id.Image2);
        iv3 = (ImageView)findViewById(R.id.Image3);
       // Toast.makeText(this, "onCreate completed", Toast.LENGTH_LONG).show();
        Button quit = (Button) findViewById(R.id.quit);
        ButtonListener quitListener = new ButtonListener();
        quit.setOnClickListener(quitListener);

        Button spin = (Button) findViewById(R.id.Spin);
        spin.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
             Spin();

            }
        });

        Button restart = (Button) findViewById(R.id.ReStart);
        restart.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                resetAll();
            }
        });

        Button bet1 = (Button) findViewById(R.id.Bet1);
        bet1.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){

                if(playerBet<playerMoney) //Statement that checks if the intended bet amount is less then the wallet amount
                playerBet+=1;             //Changes the amount being bet per spin to 1
                else                      //Displays message that the player does not have the money needed to make that bet amount
                  Toast.makeText(getApplicationContext(),"You don't have enough money to place that bet.",Toast.LENGTH_LONG).show();
                playerBetText.setText("Player Bet: "+String.valueOf(playerBet));
            }
        });

        Button bet2 = (Button) findViewById(R.id.Bet5);
        bet2.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){

                if(playerBet<playerMoney)
                    playerBet+=5;        //Changes the amount being bet per spin to 5
                else
                    Toast.makeText(getApplicationContext(),"You don't have enough money to place that bet.",Toast.LENGTH_LONG).show();
                playerBetText.setText("Player Bet: "+String.valueOf(playerBet));
            }
        });

        Button bet3 = (Button) findViewById(R.id.Bet10);
        bet3.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){

                if(playerBet<playerMoney)
                    playerBet+=10;      //Changes the amount being bet per spin to 10
                else
                    Toast.makeText(getApplicationContext(),"You don't have enough money to place that bet.",Toast.LENGTH_LONG).show();
                playerBetText.setText("Player Bet: "+String.valueOf(playerBet));
            }
        });

        Button bet4 = (Button) findViewById(R.id.Bet20);
        bet4.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){

                if(playerBet<playerMoney)
                    playerBet+=20;      //Changes the amount being bet per spin to 20
                else
                    Toast.makeText(getApplicationContext(),"You don't have enough money to place that bet.",Toast.LENGTH_LONG).show();
                playerBetText.setText("Player Bet: "+String.valueOf(playerBet));
            }
        });

        Button bet5 = (Button) findViewById(R.id.Bet50);
        bet5.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){

                if(playerBet<playerMoney)
                    playerBet+=50;      //Changes the amount being bet per spin to 50
                else
                    Toast.makeText(getApplicationContext(),"You don't have enough money to place that bet.",Toast.LENGTH_LONG).show();
                playerBetText.setText("Player Bet: "+String.valueOf(playerBet));
            }
        });

        Button bet6 = (Button) findViewById(R.id.Bet100);
        bet6.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){

                if(playerBet<playerMoney)
                    playerBet+=100;     //Changes the amount being bet per spin to 100
                else
                    Toast.makeText(getApplicationContext(),"You don't have enough money to place that bet.",Toast.LENGTH_LONG).show();
                playerBetText.setText("Player Bet: "+String.valueOf(playerBet));
            }
        });


    }

    @Override
    protected void onRestart() {
        super.onRestart();
       // Toast.makeText(this, "onRestart completed", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
      //  Toast.makeText(this, "onPause completed", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
       // Toast.makeText(this, "onResume completed", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Toast.makeText(this, "onStop completed", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
      //  Toast.makeText(this, "onDestroy completed", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
       // Toast.makeText(this, "onStart completed", Toast.LENGTH_LONG).show();

    }


    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            finish();
        }
    }

    void resetFruitTally() {
        grapes = 0;
        bananas = 0;
        oranges = 0;
        cherries = 0;
        bars = 0;
        bells = 0;
        sevens = 0;
        blanks = 0;
    }

    void resetAll() {       //Resets all elements back to being the desired starting amounts
        playerMoney = 1000;
        winnings = 0;
        jackpot = 5000;
        turn = 0;
        playerBet = 0;
        winNumber = 0;
        lossNumber = 0;
        winRatio = 0;


        jackpotText.setText("Jackpot: "+String.valueOf(jackpot));
        playerMoneyText.setText("Player Money: " +String.valueOf(playerMoney));
        playerBetText.setText("Player Bet: "+String.valueOf(playerBet));

        iv1.setImageResource(R.drawable.star);
        iv2.setImageResource(R.drawable.star);
        iv3.setImageResource(R.drawable.star);
    }

    void checkJackPot() {
    /* compare two random values */
        double jackPotTry = Math.floor(Math.random() * 51 + 1);
        double jackPotWin = Math.floor(Math.random() * 51 + 1);
        if (jackPotTry == jackPotWin) {                                //Checks to see if the spin matches the jackpot win
            Toast.makeText(this, "You Won the $" + jackpot + " Jackpot!!", Toast.LENGTH_LONG).show();
            jackpotText.setText("Jackpot: "+String.valueOf(jackpot)); //Displays the jackpot win to the user
            playerMoney += jackpot;                                   //Adds the jackpot amount to the players wallet
            jackpot = 1000;
        }
    }
    /* Utility function to show a win message and increase player money */
    void showWinMessage() {
        playerMoney += winnings;
        playerMoneyText.setText("Player Money: "+String.valueOf(playerMoney));
        //$("div#winOrLose>p").text("You Won: $" + winnings);
        Toast.makeText(this, "You Won: $" + winnings, Toast.LENGTH_LONG).show();
       resetFruitTally();
        checkJackPot();
    }

    /* Utility function to show a loss message and reduce player money */
    void showLossMessage() {
        playerMoney -= playerBet;
        playerMoneyText.setText("Player Money: "+String.valueOf(playerMoney));
        //$("div#winOrLose>p").text("You Lost!");
        Toast.makeText(this, "You Lost!" , Toast.LENGTH_LONG).show();
       resetFruitTally();
    }
    boolean checkRange(int value, int lowerBounds, int upperBounds) {
        if (value >= lowerBounds && value <= upperBounds) {
            return true;
        } else {
            return false;
        }
    }

    void Reels() {
        //String[] betLine = new String[100];
        for (int spin = 0; spin < 3; spin++)
        {
            int outCome = (int) Math.floor((Math.random() * 65) + 1);

            if (checkRange(outCome, 1, 27)) {// 41.5% probability
                //betLine[spin] = "blank";
                if(spin==0)iv1.setImageResource(R.drawable.xyz);
                else if(spin==1)iv2.setImageResource(R.drawable.xyz);
                else if(spin==2)iv3.setImageResource(R.drawable.xyz);
                blanks++;
            }
            else if (checkRange(outCome, 28, 37)) { // 15.4% probability
                //betLine[spin] = "Grapes";
                if(spin==0)iv1.setImageResource(R.drawable.grapes);
                else if(spin==1)iv2.setImageResource(R.drawable.grapes);
                else if(spin==2)iv3.setImageResource(R.drawable.grapes);
                grapes++;
            }
            else if( checkRange(outCome, 38, 46)){ // 13.8% probability
                //betLine[spin] = "Banana";
                if(spin==0)iv1.setImageResource(R.drawable.banana);
                else if(spin==1)iv2.setImageResource(R.drawable.banana);
                else if(spin==2)iv3.setImageResource(R.drawable.banana);
                bananas++;
            }
            else if(checkRange(outCome, 47, 54)) { // 12.3% probability
                //    betLine[spin] = "Orange";
                if(spin==0)iv1.setImageResource(R.drawable.orange);
                else if(spin==1)iv2.setImageResource(R.drawable.orange);
                else if(spin==2)iv3.setImageResource(R.drawable.orange);
                oranges++;
            }
            else if (checkRange(outCome, 55, 59)) { //  7.7% probability
               // betLine[spin] = "Cherry";
                if(spin==0)iv1.setImageResource(R.drawable.cherry);
                else if(spin==1)iv2.setImageResource(R.drawable.cherry);
                else if(spin==2)iv3.setImageResource(R.drawable.cherry);
                cherries++;
            }
            else if( checkRange(outCome, 60, 62)) { //  4.6% probability
                // betLine[spin] = "Bar";
                if(spin==0)iv1.setImageResource(R.drawable.bar);
                else if(spin==1)iv2.setImageResource(R.drawable.bar);
                else if(spin==2)iv3.setImageResource(R.drawable.bar);
                bars++;
            }
            else if( checkRange(outCome, 63, 64)) { //  3.1% probability
               // betLine[spin] = "Bell";
                if(spin==0)iv1.setImageResource(R.drawable.bell);
                else if(spin==1)iv2.setImageResource(R.drawable.bell);
                else if(spin==2)iv3.setImageResource(R.drawable.bell);
                bells++;
            }
            else if(checkRange(outCome, 65, 65)){ //  1.5% probability
                // betLine[spin] = "Seven";
                if(spin==0)iv1.setImageResource(R.drawable.num7);
                else if(spin==1)iv2.setImageResource(R.drawable.num7);
                else if(spin==2)iv3.setImageResource(R.drawable.num7);
                 sevens++;
            }
        }
    }

    /* This function calculates the player's winnings, if any */
    void determineWinnings() {
        if (blanks == 0) {
            if (grapes == 3) {
                winnings = playerBet * 10;
            } else if (bananas == 3) {
                winnings = playerBet * 20;
            } else if (oranges == 3) {
                winnings = playerBet * 30;
            } else if (cherries == 3) {
                winnings = playerBet * 40;
            } else if (bars == 3) {
                winnings = playerBet * 50;
            } else if (bells == 3) {
                winnings = playerBet * 75;
            } else if (sevens == 3) {
                winnings = playerBet * 100;
            } else if (grapes == 2) {
                winnings = playerBet * 2;
            } else if (bananas == 2) {
                winnings = playerBet * 2;
            } else if (oranges == 2) {
                winnings = playerBet * 3;
            } else if (cherries == 2) {
                winnings = playerBet * 4;
            } else if (bars == 2) {
                winnings = playerBet * 5;
            } else if (bells == 2) {
                winnings = playerBet * 10;
            } else if (sevens == 2) {
                winnings = playerBet * 20;
            } else if (sevens == 1) {
                winnings = playerBet * 5;
            } else {
                winnings = playerBet * 1;
            }
            winNumber++;
             showWinMessage();
        } else {
            lossNumber++;
            showLossMessage();
        }

    }


    /* When the player clicks the spin button the game kicks off */
    void Spin() {
        if (playerMoney == 0) {
            Toast.makeText(getApplicationContext(), "You ran out of Money! Do you want to play again?", Toast.LENGTH_LONG).show();
           // resetAll();
            //showPlayerStats();
            checkJackPot();
        } else if (playerBet > playerMoney) {
            Toast.makeText(getApplicationContext(),"You don't have enough money to place that bet.",Toast.LENGTH_LONG).show();
        } else if (playerBet < 0){
            Toast.makeText(getApplicationContext(), "All bets must be a positive $ amount.", Toast.LENGTH_LONG).show();
        } else if (playerBet <= playerMoney && playerBet != 0) {
            MediaPlayer ring = MediaPlayer.create(MainActivity.this, R.raw.spinsound);
            ring.start();
            Reels();
            determineWinnings();
            turn++;
            //showPlayerStats();
        } else {
            Toast.makeText(getApplicationContext(), "Please enter a valid bet amount", Toast.LENGTH_LONG).show();
        }
    }

};

