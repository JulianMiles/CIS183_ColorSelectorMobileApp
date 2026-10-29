/// ================================================================
/// Author: Julian Miles
/// 10/29/2026
/// color slider mobile program
/// Main - is main
/// =============================================
package com.example.julianmiles_homework02_program01;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity
{
    // Global Vars ==================================
    ConstraintLayout main;
    //holds the rgb values from the sliders
    int redVal = 255; //255 = white = default
    int greenVal = 255;
    int blueVal = 255;
    String hexCode = "#FFFFFF";
    TextView sliderRedText;
    TextView sliderGreenText;
    TextView sliderBlueText;
    TextView sliderHexText;
    SeekBar seekBarRed;
    SeekBar seekBarGreen;
    SeekBar seekBarBlue;
    Button saveColorButton;
    ArrayList<colorInfo> listOfColors = new ArrayList<>();
    ColorListAdapter clAdapter;

    ListView ListViewColorInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        /// this function has all of the stuff that connects xml to java
        setupUi();






    }

    public void setupUi()
    {
        //Assign UI ========================================
        sliderRedText = findViewById(R.id.sliderRedText);
        sliderGreenText = findViewById(R.id.sliderGreenText);
        sliderBlueText = findViewById(R.id.sliderBlueText);
        seekBarRed = findViewById(R.id.seekBarRed);
        seekBarGreen = findViewById(R.id.seekBarGreen);
        seekBarBlue = findViewById(R.id.seekBarBlue);
        saveColorButton = findViewById(R.id.saveColorButton);

        main = findViewById(R.id.main);
        ListViewColorInfo = findViewById(R.id.ListViewColorInfo);



        clAdapter = new ColorListAdapter(this, listOfColors);
        ListViewColorInfo.setAdapter(clAdapter);

        seekBarRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar SeekBar, int progress, boolean fromUser){
                redVal = progress;
                sliderRedText.setText("Red: " + progress);//update text
                updateColorOfBackground();
            }
            @Override///function throws a fit if start and stop parts are not here
            public void onStartTrackingTouch(SeekBar Seekbar){

            }
            @Override
            public void onStopTrackingTouch(SeekBar Seekbar){

            }
        });
        seekBarGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar SeekBar, int progress, boolean fromUser){
                greenVal = progress;
                sliderGreenText.setText("Green: " + progress);
                updateColorOfBackground();
            }
            @Override
            public void onStartTrackingTouch(SeekBar Seekbar){

            }
            @Override
            public void onStopTrackingTouch(SeekBar Seekbar){

            }
        });
        seekBarBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar SeekBar, int progress, boolean fromUser){
                blueVal = progress;
                sliderBlueText.setText("Blue: " + progress);
                updateColorOfBackground();
            }
            @Override
            public void onStartTrackingTouch(SeekBar Seekbar){

            }
            @Override
            public void onStopTrackingTouch(SeekBar Seekbar){

            }
        });
        saveColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {/// add the color to the db
                colorInfo newColor = new colorInfo(redVal,greenVal,blueVal,hexCode);
                listOfColors.add(newColor);
                seekBarRed.setProgress(255);
                seekBarGreen.setProgress(255);
                seekBarBlue.setProgress(255);
                clAdapter.notifyDataSetChanged();
            }
        });



    }
    public void updateColorOfBackground()
    {
        int colorCode = Color.rgb(redVal,greenVal,blueVal);
        hexCode = String.format("#%06X",(0xFFFFFF & colorCode));
        main.setBackgroundColor(colorCode);

        sliderHexText = findViewById(R.id.sliderHexText);
        sliderHexText.setText("Hex " +hexCode);

        float avgVal = redVal+greenVal+blueVal;
        avgVal = avgVal/3;

        if(avgVal>125)
        {
            sliderRedText.setTextColor(Color.BLACK);
            sliderGreenText.setTextColor(Color.BLACK);
            sliderBlueText.setTextColor(Color.BLACK);
            sliderHexText.setTextColor(Color.BLACK);
        }
        else
        {
            sliderRedText.setTextColor(Color.WHITE);
            sliderGreenText.setTextColor(Color.WHITE);
            sliderBlueText.setTextColor(Color.WHITE);
            sliderHexText.setTextColor(Color.WHITE);
        }




    }
}
