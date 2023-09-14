package com.game.obj;

import com.game.gamewin;
import com.game.utils.gameutils;

import java.awt.*;

public class Turnobj extends Gameobj{

    public Turnobj() {
    }

    public Turnobj(Image img, int x, int y, int width, int height, double speed, gamewin frame) {
        super(img, x, y, width, height, speed, frame);
        if ((int) Math.round(Math.random()) == 1) {
            setSpeed(-speed);
        }
    }

    @Override
    public void paintself(Graphics gImage) {
        super.paintself(gImage);
        y+=Math.abs(speed);
        if(x>550 || x<0){
            speed=-speed;
        }
        x+=2*speed;
        //敌我飞机的碰撞检测
        if(this.getrect().intersects(this.frame.planeobj.getrect())) {
            if (Planeobj.planelife == 1) {
                gamewin.state = 3;
                Planeobj.miss = gamewin.count;
                //被击中爆炸图
                Explodeobj explodeobj = new Explodeobj(x, y);
                gameutils.explodeobjList.add(explodeobj);
                gameutils.removeobjList.add(explodeobj);
                this.x = -100;
                this.y = 100;
                gameutils.removeobjList.add(this);
            } else if (Planeobj.planelife > 1) {
                Planeobj.planelife--;
                Planeobj.miss = gamewin.count;
                //被击中爆炸图
                Explodeobj explodeobj = new Explodeobj(x, y);
                gameutils.explodeobjList.add(explodeobj);
                gameutils.removeobjList.add(explodeobj);
                this.x = -100;
                this.y = 100;
                gameutils.removeobjList.add(this);
            }
        }

        //子弹和敌方飞机碰撞的检测
        for (Shellobj shellobj: gameutils.shellobjList) {
            if (this.getrect().intersects(shellobj.getrect())) {
                //子弹击中敌方飞机爆炸图
                Explodeobj explodeobj = new Explodeobj(x, y);
                gameutils.explodeobjList.add(explodeobj);
                gameutils.removeobjList.add(explodeobj);
//            shellobj.setX(-100);
//            shellobj.setY(100);
                //改变当前敌机的坐标
                shellobj.x=-100;
                shellobj.y=100;
                this.x=-100;
                this.y=100;
                gameutils.removeobjList.add(shellobj);
                gameutils.removeobjList.add(this);
                //加分数
                gamewin.score++;
            }
        }
        //敌方飞机超出窗口，判断条件y>600，调整坐标为-200，200
        if(y>600) {
            this.x = -300;
            this.y = 300;
            gameutils.removeobjList.add(this);
        }
    }

    @Override
    public Rectangle getrect() {
        return super.getrect();
    }


}
