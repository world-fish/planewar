package com.game.obj;

import com.game.gamewin;
import com.game.utils.gameutils;

import java.awt.*;

public class Canisterobj2 extends Gameobj{
    public Canisterobj2(Image img, int x, int y, int width, int height, double speed, gamewin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintself(Graphics gImage) {
        super.paintself(gImage);
        y+=2*speed;
        //敌方boss子弹超出窗口，判断为y>600，调整坐标为-300,300
        if(y>600) {
            this.x = -300;
            this.y = 300;
            gameutils.removeobjList.add(this);
        }
        //敌方boss子弹和我方飞机的碰撞检测
        if(this.getrect().intersects(this.frame.planeobj.getrect())&&gamewin.count >=Planeobj.miss + 100){
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
            }
        }
    }

    @Override
    public Rectangle getrect() {
        return super.getrect();
    }
}
