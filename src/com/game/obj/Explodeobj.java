package com.game.obj;

import java.awt.*;

public class Explodeobj extends Gameobj{

    static Image[] pic=new Image[16];
    //爆炸图只显示一次
    int explodeCount=0;
    static {
        for (int i=0;i<pic.length;i++){
            pic[i]=Toolkit.getDefaultToolkit().getImage("image/explode/e"+(i+1)+".gif");
        }
    }
    public Explodeobj(int x, int y) {
        super(x, y);
    }

    @Override
    public void paintself(Graphics gImage) {

        if(explodeCount<16){
            //绘制数组中的图片
            img=pic[explodeCount];
            super.paintself(gImage);
            explodeCount++;
        }
    }
}
