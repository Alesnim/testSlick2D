package com.javalesson.oop;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class StateStart extends BasicGameState {
    Image[] sprites = new Image[4];
    Animation animation;

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        SpriteSheet spriteSheet = new SpriteSheet("./resource/cat.png",50, 50 );
        for (int i=0; i < 4; i ++){
            sprites[i] = spriteSheet.getSprite(i, 0);
        }
        animation = new Animation(sprites, 100);
    }




    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
            graphics.drawString("State 0" , 50, 100);
            graphics.drawAnimation(animation, 14f, 54f);
    }

    @Override
    public void update(GameContainer container, StateBasedGame sbg, int i) throws SlickException {
        if (container.getInput().isKeyPressed(Input.KEY_A)) {
            sbg.enterState(1);
        }
    }
}
