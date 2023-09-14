package com.game.obj;

import java.awt.*;

public class Bgobj extends Gameobj {
    //重写构造方法和paintself放法

    public Bgobj() {
        super();
    }

    public Bgobj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    @Override
    public void paintself(Graphics gImage) {
        super.paintself(gImage);
        y+=speed;
        if(y>=0){
            y=-400;
        }
    }
}
