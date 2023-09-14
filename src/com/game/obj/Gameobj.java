package com.game.obj;

import com.game.gamewin;

import java.awt.*;
//游戏类父类的编写
public class Gameobj {
    Image img;
    int x;
    int y;
    int width;
    int height;
    double speed;//移动速度
    gamewin frame;//窗口的引用

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Gameobj(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public gamewin getFrame() {
        return frame;
    }

    public void setFrame(gamewin frame) {
        this.frame = frame;
    }
    //有参构造和无参构造函数
    public Gameobj() {
    }

    public Gameobj(Image img, int x, int y, double speed) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public Gameobj(Image img, int x, int y, int width, int height, double speed, gamewin frame) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.frame = frame;
    }
    //绘制自身
    public void paintself(Graphics gImage){
        gImage.drawImage(img,x,y,null);
    }
    //绘制矩形的方法用来碰撞检测
    public Rectangle getrect(){
        return new Rectangle(x,y,width,height);
    }
}
