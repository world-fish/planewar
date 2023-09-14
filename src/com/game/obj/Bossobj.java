package com.game.obj;

import com.game.gamewin;
import com.game.utils.gameutils;

import java.awt.*;

public class Bossobj extends Gameobj{

    //定义敌方boss的生命值
    public static int life=150;

    public Bossobj(Image img, int x, int y, int width, int height, double speed, gamewin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintself(Graphics gImage) {
        super.paintself(gImage);
        //控制敌方boss在整个窗口中
        if(x>550 || x<0){
            speed=-speed;
        }
        x+=speed;
        for(Shellobj shellobj: gameutils.shellobjList){
            //检测子弹和敌方boss碰撞
            if(this.getrect().intersects(shellobj.getrect())){
                //子弹击中敌方飞机爆炸图
                Explodeobj explodeobj=new Explodeobj(shellobj.x,y+20);
                gameutils.explodeobjList.add(explodeobj);
                gameutils.removeobjList.add(explodeobj);
                shellobj.setX(-100);
                shellobj.setY(100);
                gameutils.removeobjList.add(shellobj);
                life-=7;

            }
            if(life<=0){
                gamewin.state=4;//表明游戏通关
            }
            //血条的白色背景
            gImage.setColor(Color.white);
            gImage.fillRect(20,40,300,10);
            //血条的绘制
            gImage.setColor(Color.red);
            gImage.fillRect(20,40,life*2,10);
            //一个整数除以另一个整数，如果结果为小于一，它会算为0
//            gImage.fillRect(20,40,life/10 *100,50);

        }
    }

    @Override
    public Rectangle getrect() {
        return super.getrect();
    }
}
