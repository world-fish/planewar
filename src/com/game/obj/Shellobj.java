package com.game.obj;

import com.game.gamewin;
import com.game.utils.gameutils;

import java.awt.*;

public class Shellobj extends Gameobj{
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public Shellobj() {
        super();
    }

    public Shellobj(Image img, int x, int y, int width, int height, double speed, gamewin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintself(Graphics gImage) {
        super.paintself(gImage);
        y-=speed;
//        我方子弹的越界消失，条件y<0时，，改变后的坐标为-100，100
        if(y<0){
            this.x=-100;
            this.y=100;
            gameutils.removeobjList.add(this);
        }
        //检测子弹碰撞 bullet
        for (Bulletobj bulletobj: gameutils.bulletobjList) {
            if (this.getrect().intersects(bulletobj.getrect())) {
                Explodeobj explodeobj=new Explodeobj(x,y);
                gameutils.explodeobjList.add(explodeobj);
                gameutils.removeobjList.add(explodeobj);
                //删除子弹
                bulletobj.x=-100;
                bulletobj.y=100;
                this.x=-100;
                this.y=100;
                gameutils.removeobjList.add(bulletobj);
                gameutils.removeobjList.add(this);
            }
        }
        //检测子弹碰撞 canister1
        for (Canisterobj1 canisterobj1: gameutils.canisterobj1List) {
            if (this.getrect().intersects(canisterobj1.getrect())) {
                Explodeobj explodeobj=new Explodeobj(x,y);
                gameutils.explodeobjList.add(explodeobj);
                gameutils.removeobjList.add(explodeobj);
                //删除子弹
                canisterobj1.x=-100;
                canisterobj1.y=100;
                this.x=-100;
                this.y=100;
                gameutils.removeobjList.add(canisterobj1);
                gameutils.removeobjList.add(this);
            }
        }
        //检测子弹碰撞 canister2
        for (Canisterobj2 canisterobj2: gameutils.canisterobj2List) {
            if (this.getrect().intersects(canisterobj2.getrect())) {
                Explodeobj explodeobj=new Explodeobj(x,y);
                gameutils.explodeobjList.add(explodeobj);
                gameutils.removeobjList.add(explodeobj);
                //删除子弹
                canisterobj2.x=-100;
                canisterobj2.y=100;
                this.x=-100;
                this.y=100;
                gameutils.removeobjList.add(canisterobj2);
                gameutils.removeobjList.add(this);
            }
        }
        //检测子弹碰撞 canister3
        for (Canisterobj3 canisterobj3: gameutils.canisterobj3List) {
            if (this.getrect().intersects(canisterobj3.getrect())) {
                Explodeobj explodeobj=new Explodeobj(x,y);
                gameutils.explodeobjList.add(explodeobj);
                gameutils.removeobjList.add(explodeobj);
                //删除子弹
                canisterobj3.x=-100;
                canisterobj3.y=100;
                this.x=-100;
                this.y=100;
                gameutils.removeobjList.add(canisterobj3);
                gameutils.removeobjList.add(this);
            }
        }

    }

    @Override
    public Rectangle getrect() {
        return super.getrect();
    }
}
