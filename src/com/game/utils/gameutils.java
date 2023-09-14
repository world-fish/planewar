package com.game.utils;

import com.game.obj.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class gameutils {
    //背景图片
    public static Image bgimg =Toolkit.getDefaultToolkit().getImage("image/背景.jpeg");
    //boss图片
    public static Image bossimg =Toolkit.getDefaultToolkit().getImage("image/boss.png");
    //爆炸图片
    public static Image explodeimg =Toolkit.getDefaultToolkit().getImage("image/explode/e11.gif");
    //我方飞机图片
    public static Image planeimg =Toolkit.getDefaultToolkit().getImage("image/plane.png");
    //我方子弹图片
    public static Image shellimg =Toolkit.getDefaultToolkit().getImage("image/shell.png");
    //敌方boss子弹图片
    public static Image bulletimg =Toolkit.getDefaultToolkit().getImage("image/boss子弹.png");
    //敌方boss的喷子
    public static Image canisterimg1 =Toolkit.getDefaultToolkit().getImage("image/canister.png");
    public static Image canisterimg2 =Toolkit.getDefaultToolkit().getImage("image/canister.png");
    public static Image canisterimg3 =Toolkit.getDefaultToolkit().getImage("image/canister.png");
    //敌方飞机的图片
    public static Image enemyimg =Toolkit.getDefaultToolkit().getImage("image/enemy.png");
    //小boss图片
    public static Image littleimg =Toolkit.getDefaultToolkit().getImage("image/little.png");
    //turn飞机图片
    public static Image turnimg =Toolkit.getDefaultToolkit().getImage("image/turn.png");
    //暂停时的图片
    public static Image tcbgImag=Toolkit.getDefaultToolkit().createImage("image/背景.jpeg");
    //要删除元素的集合
    public static List<Gameobj> removeobjList =new ArrayList<>();

    //所有物体游戏的集合
    public static List<Gameobj> gameobjList =new ArrayList<>();
    //我方子弹的集合
    public static List<Shellobj> shellobjList =new ArrayList<>();
    //敌方飞机的集合
    public static List<Enemyobj> enemyobjList =new ArrayList<>();
    //小boss集合
    public static List<Littleobj> littleobjList =new ArrayList<>();
    //turn飞机的集合
    public static List<Turnobj> turnobjList =new ArrayList<>();
    //敌方boss方子弹的集合
    public static List<Bulletobj> bulletobjList =new ArrayList<>();
    //敌方boss喷子子弹的合集
    public static List<Canisterobj1> canisterobj1List =new ArrayList<>();
    public static List<Canisterobj2> canisterobj2List =new ArrayList<>();
    public static List<Canisterobj3> canisterobj3List =new ArrayList<>();
    //爆炸图片的集合
    public static List<Explodeobj> explodeobjList =new ArrayList<>();
    //绘制字符串的工具类
    public static  void drawWord(Graphics gImage,String str,Color color,int size,int x,int y){
        gImage.setColor(color);
        gImage.setFont(new Font("仿宋",Font.BOLD,size));
        gImage.drawString(str,x,y);
    }

}
