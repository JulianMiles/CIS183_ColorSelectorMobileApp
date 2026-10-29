/// ================================================================
/// Author: Julian Miles
/// 10/29/2026
/// color slider mobile program
/// ColorInfo: class that holds the specific information regarding a color
/// =============================================
package com.example.julianmiles_homework02_program01;

public class colorInfo {///the packet of info that ColorListAdapter.java uses to create a list entry
    int redVal;
    int greenVal;
    int blueVal;
    String hexCode;
    ///constructor
    public colorInfo(int R,int G,int B,String hex)
    {
        this.blueVal = B;
        this.hexCode = hex;
        this.redVal = R;
        this.greenVal = G;
    }
    /// getters, should have no need for setters
    public int getGreenVal() {
        return greenVal;
    }
    public int getRedVal() {
        return redVal;
    }
    public int getBlueVal() {
        return blueVal;
    }
    public String getHexCode()
    {
        return hexCode;
    }

}
