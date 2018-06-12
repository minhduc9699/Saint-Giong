import base.GameObjectManager;
import game.background.Background;
import game.player.Player;
import input.KeyboardInput;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {

    BufferedImage backBuffered;
    Graphics graphics;
    Player player;


    public GameCanvas() {

        this.setSize(1024,600);
        this.setupBackbuffered();
        this.setupCharacter();
        this.setupPlayer();
        this.setVisible(true);
    }

    private void setupBackbuffered(){
        this.backBuffered = new BufferedImage(1024,600,BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

    public void runAll(){

        GameObjectManager.instance.runAll();
        KeyboardInput.instance.reset();

    }


    public void setupCharacter(){
        GameObjectManager.instance.add(new Background());
    }

    @Override
    protected void paintComponent(Graphics g){
        g.drawImage(this.backBuffered,0,0,null);

    }

    public void setupPlayer(){
        this.player = new Player();
        this.player.position.set(500,300);
        GameObjectManager.instance.add(this.player);

    }

    public void renderAll(){
        GameObjectManager.instance.renderAll(this.graphics);
        this.repaint();

    }


}
