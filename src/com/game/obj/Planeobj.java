package com.game.obj;

import com.game.gamewin;
import com.game.utils.gameutils;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Planeobj extends Gameobj {
    public static int planelife = 5;
    public static int miss=0;
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public Planeobj(Image planeimg, int x, int y, int width, int height, int speed, MouseAdapter mouseAdapter) {
        super();
    }

    public Planeobj(Image img, int x, int y, int width, int height, double speed, gamewin frame) {
        super(img, x, y, width, height, speed, frame);
        planelife=5;
        //飞机随着鼠标的移动而移动
        this.frame.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Planeobj.super.x=e.getX()-11;
                Planeobj.super.y=e.getY()-16;
            }
        });
    }

    @Override
    public void paintself(Graphics gImage) {
        super.paintself(gImage);
        //y-=speed;
        if(this.frame.bossobj !=null && this.getrect().intersects(this.frame.bossobj.getrect())&&gamewin.count >= miss + 100){
            if (planelife==1) {
                gamewin.state=3;
                miss = gamewin.count;
                //被击中爆炸图
                Explodeobj explodeobj=new Explodeobj(x,y);
                gameutils.explodeobjList.add(explodeobj);
                gameutils.removeobjList.add(explodeobj);

            } else if (planelife > 1) {
                planelife--;
                miss = gamewin.count;
                //被击中爆炸图
                Explodeobj explodeobj=new Explodeobj(x,y);
                gameutils.explodeobjList.add(explodeobj);
                gameutils.removeobjList.add(explodeobj);
            }
        }
    }

    @Override
    public Rectangle getrect() {
        return super.getrect();
    }
}