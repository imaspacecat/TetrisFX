package com.dubiner.tetrisfx;

import javafx.scene.shape.Rectangle;

public class RectangleMod extends Rectangle {
    private int flag;

    public RectangleMod(int flag, int i1, int i2, int i3, int i4){
        super(i1, i2, i3, i4);

        this.flag = flag;
    }

    public int getFlag(){
        return flag;
    }

    public void setFlag(int flag){
        this.flag = flag;
    }
}
