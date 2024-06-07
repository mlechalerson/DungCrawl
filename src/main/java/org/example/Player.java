package org.example;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{

    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();


    }
    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";

    }

    public void getPlayerImage(){
        try{

            left = ImageIO.read(getClass().getResourceAsStream("/Player/goku-1.png-removebg-preview.png"));
            right = ImageIO.read(getClass().getResourceAsStream("/Player/goku-2.png-removebg-preview.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void update(){
        if(keyH.upPressed) {
            y -= speed;
        }else if (keyH.downPressed){
            y += speed;
        }else if (keyH.leftPressed){
            direction = "left";
            x -= speed;
        }else if (keyH.rightPressed){
            direction = "right";
            x += speed;
        }
    }
    public void draw(Graphics2D g2){
//        g2.setColor(Color.white);
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);
        BufferedImage image = null;

        switch (direction){
            case "left":
                image = left;
                break;
            case "right":
                image = right;
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
