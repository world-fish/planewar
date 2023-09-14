package com.game;

import com.game.obj.*;
import com.game.utils.gameutils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static com.game.obj.Bossobj.life;
import static com.game.utils.gameutils.*;

public class gamewin extends JFrame {
    //游戏状态 0未开始 1进行中 2暂停 3游戏失败 4游戏通关
    public static int state=0;//游戏的默认状态
    //计分数
    public static  int score=0;
    Image offSreenimage=null;
    int width=600;
    int height=600;
    //游戏的重绘次数
    public static int count=1;
    //敌机出现的数量
    int enemyCount=0;

    //背景图图像的移动
    Bgobj bgobj=new Bgobj(gameutils.bgimg,0,-400,0.5);
    //我方飞机的对象
    public Planeobj planeobj =new Planeobj(gameutils.planeimg,290,550,30,40,0,this);
    //boss对象
    public Bossobj bossobj =null;

    public void launch(){
        //设置窗口大小
        this.setSize(width,height);
        //设置界面置顶
        setAlwaysOnTop(true);
        //设置窗口位置居中
        this.setLocationRelativeTo(null);
        //用户不能调整界面
        setResizable(false);
        //设置关闭模式
        setDefaultCloseOperation(3);
        //设置窗口标题
        this.setTitle("飞机大战");

        //设置窗口是否可见
        this.setVisible(true);

        gameobjList.add(bgobj);
        gameobjList.add(planeobj);

        //鼠标点击
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //在未开始并且点击鼠标左键
                if(e.getButton()==1&&state==0){
                    state=1;
                    repaint();
                }
                else if (e.getButton() == 1 && (state == 3 || state == 4)) {
                    count=1;
                    enemyCount=0;
                    score=0;

                    removeobjList.clear();
                    gameobjList.clear();
                    shellobjList.clear();
                    enemyobjList.clear();
                    bulletobjList.clear();
                    explodeobjList.clear();
                    gameobjList.add(bgobj);
                    gameobjList.add(planeobj);
//                    bulletimg = null;
                    //boss对象
                    bossobj =null;
                    Planeobj.planelife=5;
                    life=150;
                    state=1;
                    repaint();
                }
            }
        });

        //游戏的暂停功能
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //按下空格键，空格键的代码为32
                if(e.getKeyCode() == 32){
                    switch (state){
                        case 1:
                            state=2;
                            break;
                        case 2:
                            state=1;
                            break;
                        default:
                    }
                } else if (e.getKeyCode() == 90) {
                    Planeobj.planelife++;
                } else if (e.getKeyCode() == 81) {
                    removeobjList.clear();

                } else if (e.getKeyCode() == 69) {

                }
            }
        });
        while(true){
            if(state==1){
                create();
                repaint();
            }
//            if (state == 2) {
//                removeAll();
//                System.out.println(111);
////                System.out.println("绘制菜单");
//                if(offSreenimage==null){
//                    offSreenimage=createImage(width,height);
//                }
//                //获取offScrenimage的画笔对象
//                Graphics g=offSreenimage.getGraphics();
//                //填充一个宽六百，高六百的区域
//                g.fillRect(0,0,width,height);
//                g.drawImage(bgimg,0,0,null);
//                gameutils.drawWord(g,"菜  单",Color.WHITE,80,125,83);
//                gameutils.drawWord(g,"重新游戏",Color.WHITE,30,185,216);
//                gameutils.drawWord(g,"退出游戏",Color.WHITE,30,185,306);
//                gameutils.drawWord(g,"一键通关",Color.WHITE,30,185,403);
//                gameutils.drawWord(g,"关于我们",Color.WHITE,30,185,506);
//                g.drawImage(offSreenimage,0,0,null);
//                repaint();
//            }

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        if(offSreenimage==null){
            offSreenimage=createImage(width,height);
        }
        //获取offScrenimage的画笔对象
        Graphics gimage=offSreenimage.getGraphics();
        //填充一个宽六百，高六百的区域
        gimage.fillRect(0,0,width,height);
        //游戏未开始
        if(state==0){
            gimage.drawImage(gameutils.bgimg,0,0,null);
            gimage.drawImage(gameutils.bossimg,230,100,null);
            gimage.drawImage(gameutils.planeimg,290,400,null);
            gameutils.drawWord(gimage,"点击开始游戏",Color.yellow,40,180,300);
            //            gimage.setColor(Color.yellow);
//            gimage.setFont(new Font("仿宋",Font.BOLD,40));
//            gimage.drawString("点击开始游戏",180,300);

        }
        //游戏开始
        if(state==1){
            gameobjList.addAll(gameutils.explodeobjList);

            for(int i = 0; i< gameobjList.size(); i++){
                gameobjList.get(i).paintself(gimage);
            }
            gameobjList.removeAll(removeobjList);
        }
        //游戏失败
        if(state==3) {
            gimage.drawImage(gameutils.explodeimg, planeobj.getX() - 35, planeobj.getY() - 50, null);
            gameutils.drawWord(gimage,"GAME OVER",Color.red,40,180,250);
//            gimage.setColor(Color.red);
//            gimage.setFont(new Font("仿宋", Font.BOLD, 40));
//            gimage.drawString("GAME OVER", 180, 300);
            gameutils.drawWord(gimage,"点击界面后重新开始",Color.red,40,110,300);
        }
        //游戏通关
        if(state==4) {
            gimage.drawImage(gameutils.explodeimg, bossobj.getX() + 35, bossobj.getY() + 50, null);
            gameutils.drawWord(gimage, " Game Win", Color.red, 40, 180, 250);
            gameutils.drawWord(gimage,"点击界面后重新开始",Color.red,40,110,300);
        }
        //绘制得分
        gameutils.drawWord(gimage,score+"分",Color.green,30,30,80);
        //绘制生命值
        gameutils.drawWord(gimage,"血量："+Planeobj.planelife,Color.red,30,30,560);

        //把新图片一次性绘制到主窗口中
        g.drawImage(offSreenimage,0,0,null);
        count++;

    }
    //创建方法用来批量生成子弹和敌机
    void create(){
        //我方子弹  除以10是为了控制子弹的速率
        if(count%10==0){
            shellobjList.add(new Shellobj(gameutils.shellimg,planeobj.getX()+4,planeobj.getY()-16,14,29,15,this));
            gameobjList.add(shellobjList.get(shellobjList.size()-1));
        }
        //敌方战机
        if(count%10==0){
            enemyobjList.add(new Enemyobj(enemyimg,(int)(Math.random()*12)*50,0,50,50,4,this));
            gameobjList.add(enemyobjList.get(enemyobjList.size()-1));
            enemyCount++;
        }
        //小boss
        if (count%20==0){
            littleobjList.add(new Littleobj(littleimg,(int)(Math.random()*12)*50,0,40,40,8,this));
            gameobjList.add(littleobjList.get(littleobjList.size()-1));
        }
        //turn飞机
        if (count%40==0){
            turnobjList.add(new Turnobj(turnimg,(int)(Math.random()*12)*50,0,40,40,3,this));
            gameobjList.add(turnobjList.get(turnobjList.size()-1));
        }
        //敌方boss子弹
        //直到boss出现的时候才会生成子弹
        if (life <= 50) {
//            if(count%20==0 && bossobj !=null){
//                gameutils.bulletobjList.add(new Bulletobj(gameutils.bulletimg,bossobj.getX()+70,bossobj.getY()+87,20,47,5,this));
//                gameobjList.add(gameutils.bulletobjList.get(gameutils.bulletobjList.size()-1));
//            }
            if(count%30==0 && bossobj !=null) {
                canisterobj1List.add(new Canisterobj1(canisterimg1,bossobj.getX()+70,bossobj.getY()+87,20,20,4,this));
                gameobjList.add(canisterobj1List.get(canisterobj1List.size()-1));
                canisterobj2List.add(new Canisterobj2(canisterimg2,bossobj.getX()+70,bossobj.getY()+87,20,20,4,this));
                gameobjList.add(canisterobj2List.get(canisterobj2List.size()-1));
                canisterobj3List.add(new Canisterobj3(canisterimg3,bossobj.getX()+70,bossobj.getY()+87,20,20,4,this));
                gameobjList.add(canisterobj3List.get(canisterobj3List.size()-1));
            }
        } else if (life>=100) {
            if(count%20==0 && bossobj !=null) {
                gameutils.bulletobjList.add(new Bulletobj(gameutils.bulletimg, bossobj.getX() + 70, bossobj.getY() + 87, 20, 47, 6, this));
                gameobjList.add(gameutils.bulletobjList.get(gameutils.bulletobjList.size() - 1));
            }
        } else if (life < 100 && life > 50) {
            if(count%15==0 && bossobj !=null) {
                gameutils.bulletobjList.add(new Bulletobj(gameutils.bulletimg, bossobj.getX() + 70, bossobj.getY() + 87, 20, 47, 6, this));
                gameobjList.add(gameutils.bulletobjList.get(gameutils.bulletobjList.size() - 1));
            }
        }
        if( score>30 && bossobj == null ){
            bossobj=new Bossobj(gameutils.bossimg,250,80,145,107,4,this);
            gameobjList.add(bossobj);
        }
    }



    public static void main(String[] args) {
        gamewin Gamewin=new gamewin();
        Gamewin.launch();
    }

}
