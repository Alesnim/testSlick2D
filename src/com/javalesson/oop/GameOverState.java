package com.javalesson.oop;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameOverState extends BasicGameState {

    @Override
    public int getID() {
        return 77;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        Image back = null;
        try {
            back = new Image("./resource/back.png").getScaledCopy(gameContainer.getWidth(),
                    gameContainer.getHeight());
        } catch (SlickException e) {
            e.printStackTrace();
        }
        graphics.drawImage(back, 0,0);


        graphics.drawString("Game Over", 100, 200);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

    }
}
