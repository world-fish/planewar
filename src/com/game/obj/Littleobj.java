package com.game.obj;

import com.game.gamewin;
import com.game.utils.gameutils;

import java.awt.*;

public class Littleobj extends Gameobj{

    public Littleobj() {
    }

    public Littleobj(Image img, int x, int y, int width, int height, double speed, gamewin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintself(Graphics gImage) {
        super.paintself(gImage);
        y+=speed;
        //敌我飞机的碰撞检测
        if(this.getrect().intersects(this.frame.planeobj.getrect())){
            if (Planeobj.planelife==1) {
                gamewin.state=3;
                Planeobj.miss = gamewin.count;
                //被击中爆炸图
                Explodeobj explodeobj=new Explodeobj(x,y);
                gameutils.explodeobjList.add(explodeobj);
                gameutils.removeobjList.add(explodeobj);
                this.x=-100;
                this.y=100;
                gameutils.removeobjList.add(this);
            } else if (Planeobj.planelife > 1) {
                Planeobj.planelife--;
                Planeobj.miss = gamewin.count;
                //被击中爆炸图
                Explodeobj explodeobj=new Explodeobj(x,y);
                gameutils.explodeobjList.add(explodeobj);
                gameutils.removeobjList.add(explodeobj);
                this.x=-100;
                this.y=100;
                gameutils.removeobjList.add(this);
            }        }
        //敌方飞机超出窗口，判断条件y>600，调整坐标为-200，200
        if(y>600){
            this.x=-300;
            this.y=300;
            gameutils.removeobjList.add(this);
        }
        //子弹和敌方飞机碰撞的检测
        for (Shellobj shellobj: gameutils.shellobjList) {
            if(this.getrect().intersects(shellobj.getrect())){
                shellobj.x=-100;
                shellobj.y=100;
                gameutils.removeobjList.add(shellobj);
                //子弹击中敌方飞机爆炸图
//                Explodeobj explodeobj=new Explodeobj(x,y);
//                gameutils.explodeobjList.add(explodeobj);
//                gameutils.removeobjList.add(explodeobj);
            }

        }
    }

    @Override
    public Rectangle getrect() {
        return super.getrect();
    }
}
