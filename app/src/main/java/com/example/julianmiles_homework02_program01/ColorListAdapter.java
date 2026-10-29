/// ================================================================
/// Author: Julian Miles
/// 10/29/2026
/// color slider mobile program
/// ColorListAdapter: adapter that enables saved colors to be displayed in the list view
/// =============================================
package com.example.julianmiles_homework02_program01;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class ColorListAdapter extends BaseAdapter
{
    Context context;
    ArrayList<colorInfo> listOfColorBlocks;
    /// Constructor
    public ColorListAdapter(Context c, ArrayList<colorInfo> ls)
    {
        context = c;
        listOfColorBlocks = ls;
    }

    @Override
    public int getCount() {
        return listOfColorBlocks.size();
    }

    @Override
    public Object getItem(int position) {
        return listOfColorBlocks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override /// The cell maker, the gui guy
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null)
        {/// if the view hasn't been told what to do/look like yet, make it
            LayoutInflater nInflater = (LayoutInflater) context.getSystemService(MainActivity.LAYOUT_INFLATER_SERVICE);
            view = nInflater.inflate(R.layout.colorlistcell, null);
        }
        ///assign the ui
        TextView redText = view.findViewById(R.id.redInfoText);
        TextView greenText = view.findViewById(R.id.greenInfoText);
        TextView blueText = view.findViewById(R.id.blueInfoText);
        TextView hexText = view.findViewById(R.id.hexInfoText);
        ///assign this for the background color
        ConstraintLayout colorMain = view.findViewById(R.id.colorMain);
        /// get data to assign to text
        colorInfo newColorBlock = listOfColorBlocks.get(position);
        //// vvv these throw a fit if they are passed an int only, adding the "" appeases them
        redText.setText("Red  :" + newColorBlock.getRedVal());
        greenText.setText("Green: " +newColorBlock.getGreenVal());
        blueText.setText("Blue : " +newColorBlock.getBlueVal());
        hexText.setText("Hex: " +newColorBlock.getHexCode());
        ///set background color, copied from main's updateColorOfBackground()
        int colorCode = Color.rgb(newColorBlock.getRedVal(),newColorBlock.getGreenVal(),newColorBlock.getBlueVal());
        colorMain.setBackgroundColor(colorCode);
        ///invert the color of the text if the background is too dark
        float avgVal = newColorBlock.getRedVal()+newColorBlock.getGreenVal()+newColorBlock.getBlueVal();
        avgVal = avgVal/3;
        if(avgVal>125)
        {
            redText.setTextColor(Color.BLACK);
            greenText.setTextColor(Color.BLACK);
            blueText.setTextColor(Color.BLACK);
            hexText.setTextColor(Color.BLACK);
        }
        else
        {
            redText.setTextColor(Color.WHITE);
            greenText.setTextColor(Color.WHITE);
            blueText.setTextColor(Color.WHITE);
            hexText.setTextColor(Color.WHITE);
        }
        return view;
    }
}
