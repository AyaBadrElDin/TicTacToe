package com.av.tictactoe;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.media.MediaPlayer;
import android.nfc.NfcAdapter;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SoundEffectConstants;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.av.tictactoe.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding activityMainBinding;
    ArrayList<Integer> addXorOList = new ArrayList<>();
    HashMap<Integer, String> checkWinOrLoseList = new HashMap<>();
    ArrayList<String> playerArrayList = new ArrayList<>();
    Player player = new Player();
    ImageButton imageButtonOne;
    ImageButton imageButtonTwo;
    ImageButton imageButtonThree;

    ImageButton imageButtonFour;
    ImageButton imageButtonFive;
    ImageButton imageButtonSix;

    ImageButton imageButtonSeven;
    ImageButton imageButtonEight;
    ImageButton imageButtonNine;
    boolean isWin = false;
    int xIsWin = 0;
    int oIsWin =  0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        addXorOList.add(0);
        setupUI();

        playerArrayList.add("");//0
        playerArrayList.add("");//1
        playerArrayList.add("");//2
        playerArrayList.add("");//3
        playerArrayList.add("");//4
        playerArrayList.add("");//5
        playerArrayList.add("");//6
        playerArrayList.add("");//7
        playerArrayList.add("");//8


    }

    private void setupUI() {

        activityMainBinding.imgBtnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                imageButtonOne = activityMainBinding.imgBtnOne;


                checkAndAdd(imageButtonOne, 0);
            }
        });

        activityMainBinding.imgBtnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageButtonTwo = (ImageButton) activityMainBinding.imgBtnTwo;
                checkAndAdd(imageButtonTwo, 1);
            }
        });
        activityMainBinding.imgBtnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                imageButtonThree = (ImageButton) activityMainBinding.imgBtnThree;
                checkAndAdd(imageButtonThree, 2);
            }
        });

        activityMainBinding.imgBtnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageButtonFour = (ImageButton) activityMainBinding.imgBtnFour;
                checkAndAdd(imageButtonFour, 3);
            }
        });

        activityMainBinding.imgBtnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageButtonFive = (ImageButton) activityMainBinding.imgBtnFive;
                checkAndAdd(imageButtonFive, 4);
            }
        });
        activityMainBinding.imgBtnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                imageButtonSix = (ImageButton) activityMainBinding.imgBtnSix;
                checkAndAdd(imageButtonSix, 5);
            }
        });

        activityMainBinding.imgBtnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageButtonSeven = (ImageButton) activityMainBinding.imgBtnSeven;
                checkAndAdd(imageButtonSeven, 6);
            }
        });

        activityMainBinding.imgBtnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageButtonEight = (ImageButton) activityMainBinding.imgBtnEight;
                checkAndAdd(imageButtonEight, 7);
            }
        });
        activityMainBinding.imgBtnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                imageButtonNine = (ImageButton) activityMainBinding.imgBtnNine;
                checkAndAdd(imageButtonNine, 8);
            }
        });


    }

    private void checkAndAdd(ImageButton view, int numberOfBox) {
        if(!isWin)
        if (view.getDrawable() == null) {
            int getLastIndex = addXorOList.get(addXorOList.size() - 1);
            if (getLastIndex == 0) {
                view.setImageDrawable(getResources().getDrawable(R.drawable.ic_o_icon));
                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.click_1);
                mp.start();
                addXorOList.add(1);
                playerArrayList.set(numberOfBox, "O");
                checkWhoWinTheGameXorOPlayer();
            } else {
                view.setImageDrawable(getResources().getDrawable(R.drawable.ic_x_icon));
                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.click_2);
                mp.start();
                addXorOList.add(0);
                playerArrayList.set(numberOfBox, "X");
                checkWhoWinTheGameXorOPlayer();

            }
        }
    }

    private void checkWhoWinTheGameXorOPlayer() {

        // Check who is win on horizontal way
        //----------------------------- Horizontal Way (Start) -----------------------//
        // case 1
        if (playerArrayList.get(0) == "X" && playerArrayList.get(1) == "X" && playerArrayList.get(2) == "X") {
             isWin = true;
             alertUserWhoWin("Player X is Win","X");
        }
        if (playerArrayList.get(0) == "O" && playerArrayList.get(1) == "O" && playerArrayList.get(2) == "O") {
            isWin = true;
             alertUserWhoWin("Player O is Win","O");
        }


        // case 2
        if (playerArrayList.get(3) == "X" && playerArrayList.get(4) == "X" && playerArrayList.get(5) == "X") {
            isWin = true;
            alertUserWhoWin("Player X is Win","X");

        }
        if (playerArrayList.get(3) == "O" && playerArrayList.get(4) == "O" && playerArrayList.get(5) == "O") {
            isWin = true;
            alertUserWhoWin("Player O is Win","O");
        }


        // case 3
        if (playerArrayList.get(6) == "X" && playerArrayList.get(7) == "X" && playerArrayList.get(8) == "X") {
            isWin = true;
            alertUserWhoWin("Player X is Win","X");

        }
        if (playerArrayList.get(6) == "O" && playerArrayList.get(7) == "O" && playerArrayList.get(8) == "O") {
            isWin = true;
            alertUserWhoWin("Player O is Win","O");

        }
        /*************************************************************************************************/


        // Check who is win on vertical way
        //----------------------------- Vertical Way (Start) -----------------------//
        // case 1
        if (playerArrayList.get(0) == "X" && playerArrayList.get(3) == "X" && playerArrayList.get(6) == "X") {
            isWin = true;
            alertUserWhoWin("Player X is Win","X");
        }
        if (playerArrayList.get(0) == "O" && playerArrayList.get(3) == "O" && playerArrayList.get(6) == "O") {
            isWin = true;
            alertUserWhoWin("Player O is Win","O");
        }


        // case 2
        if (playerArrayList.get(1) == "X" && playerArrayList.get(4) == "X" && playerArrayList.get(7) == "X") {
            isWin = true;
            alertUserWhoWin("Player X is Win","X");

        }
        if (playerArrayList.get(1) == "O" && playerArrayList.get(4) == "O" && playerArrayList.get(7) == "O") {
            isWin = true;
            alertUserWhoWin("Player O is Win","O");
        }


        // case 3
        if (playerArrayList.get(2) == "X" && playerArrayList.get(5) == "X" && playerArrayList.get(8) == "X") {
            isWin = true;
            alertUserWhoWin("Player X is Win","X");
        }
        if (playerArrayList.get(2) == "O" && playerArrayList.get(5) == "O" && playerArrayList.get(8) == "O") {
            isWin = true;
            alertUserWhoWin("Player O is Win","O");


        }
        /***************************************************************************************************************/


        // Check who is win on cross way
        //----------------------------- Cross Way (Start) -----------------------//
        // case 1
        if (playerArrayList.get(0) == "X" && playerArrayList.get(4) == "X" && playerArrayList.get(8) == "X") {
            isWin = true;
            alertUserWhoWin("Player X is Win","X");

        }
        if (playerArrayList.get(0) == "O" && playerArrayList.get(4) == "O" && playerArrayList.get(8) == "O") {
            isWin = true;
            alertUserWhoWin("Player O is Win","O");

        }


        // case 2
        if (playerArrayList.get(2) == "X" && playerArrayList.get(4) == "X" && playerArrayList.get(6) == "X") {
            isWin = true;
            alertUserWhoWin("Player X is Win","X");

        }
        if (playerArrayList.get(2) == "O" && playerArrayList.get(4) == "O" && playerArrayList.get(6) == "O") {
            isWin = true;
            alertUserWhoWin("Player O is Win","O");

        }


    }



    public void clearAllXAndO(View view) {

        try {
            if (imageButtonOne.getDrawable() != null || imageButtonTwo.getDrawable() != null ||
                    imageButtonThree.getDrawable() != null || imageButtonFour.getDrawable() != null ||
                    imageButtonFive.getDrawable() != null || imageButtonSix.getDrawable() != null ||
                    imageButtonSeven.getDrawable() != null || imageButtonEight.getDrawable() != null ||
                    imageButtonNine.getDrawable() != null) {

                clearAllWithImage();

            }

        } catch (Exception e) {
            //  Toast.makeText(MainActivity.this, "All is empty", Toast.LENGTH_SHORT).show();
            clearAll();
        }


    }


    public void clearAllWithImage() {

        isWin = false;

        imageButtonOne.setImageDrawable(null);
        imageButtonTwo.setImageDrawable(null);
        imageButtonThree.setImageDrawable(null);
        imageButtonFour.setImageDrawable(null);
        imageButtonFive.setImageDrawable(null);
        imageButtonSix.setImageDrawable(null);
        imageButtonSeven.setImageDrawable(null);
        imageButtonEight.setImageDrawable(null);
        imageButtonNine.setImageDrawable(null);

        addXorOList.clear();
        addXorOList.add(0);
        playerArrayList.clear();

        playerArrayList.add("");//0
        playerArrayList.add("");//1
        playerArrayList.add("");//2
        playerArrayList.add("");//3
        playerArrayList.add("");//4
        playerArrayList.add("");//5
        playerArrayList.add("");//6
        playerArrayList.add("");//7
        playerArrayList.add("");//8

    }

    public void clearAll() {
        isWin = false;

        addXorOList.clear();
        addXorOList.add(0);
        playerArrayList.clear();

        playerArrayList.add("");//0
        playerArrayList.add("");//1
        playerArrayList.add("");//2
        playerArrayList.add("");//3
        playerArrayList.add("");//4
        playerArrayList.add("");//5
        playerArrayList.add("");//6
        playerArrayList.add("");//7
        playerArrayList.add("");//8
    }

    public void alertUserWhoWin(String messageWin, final String xOrO) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("         " + messageWin)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                        if(xOrO.equals("X")){
                            xIsWin = xIsWin + 1;
                            activityMainBinding.tvPlayerX.setText(String.valueOf(xIsWin));
                        }

                        if(xOrO.equals("O")){
                            oIsWin = oIsWin + 1;
                            activityMainBinding.tvPlayerO.setText(String.valueOf(oIsWin));

                        }

                        try {
                            if (imageButtonOne.getDrawable() != null || imageButtonTwo.getDrawable() != null ||
                                    imageButtonThree.getDrawable() != null || imageButtonFour.getDrawable() != null ||
                                    imageButtonFive.getDrawable() != null || imageButtonSix.getDrawable() != null ||
                                    imageButtonSeven.getDrawable() != null || imageButtonEight.getDrawable() != null ||
                                    imageButtonNine.getDrawable() != null) {

                                clearAllWithImage();

                            }

                        } catch (Exception e) {
                            //  Toast.makeText(MainActivity.this, "All is empty", Toast.LENGTH_SHORT).show();
                            clearAll();
                        }

                        dialog.cancel();
                    }
                })
                .show();
    }


}