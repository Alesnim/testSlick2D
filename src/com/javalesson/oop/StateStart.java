package com.javalesson.oop;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class StateStart extends BasicGameState {
    Image[] sprites = new Image[6];
    Animation animation;
    Image platform;
    Animation ruby;


    int x = 14;
    int y = 24;
    private boolean walk;

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        SpriteSheet spriteSheet = new SpriteSheet("./resource/character.png", 32, 32);
        SpriteSheet rubs = new SpriteSheet("./resource/ruby2.png", 24, 24);
        for (int i = 0; i < 6; i++) {
            sprites[i] = spriteSheet.getSprite(i, 0).getScaledCopy(2f);
        }

        animation = new Animation(sprites, 100);


        platform = new Image("./resource/platform.png");
        ruby = new Animation(rubs, 100);

        ruby.setPingPong(true);
    }


    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.drawString("State 0", 50, 100);
        for (int x = 0; x < 4; x++) {
            platform.draw(100 + (x * platform.getWidth()), 140);
        }
        if (walk) {
            graphics.drawAnimation(animation, x, y);
        } else {
            graphics.drawImage(sprites[0], x, y);
        }
        ruby.draw(100, 300);

    }

    @Override
    public void update(GameContainer container, StateBasedGame sbg, int i) throws SlickException {
        if (container.getInput().isKeyPressed(Input.KEY_A)) {
            sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
        } else if (container.getInput().isKeyPressed(Input.KEY_X)) {
            sbg.enterState(77);
        }


        if (container.getInput().isKeyDown(Input.KEY_D)) {
            x += 0.2f * i;
            walk = true;
        } else if (container.getInput().isKeyDown(Input.KEY_S)) {
            y += 0.1f * i;
            walk = true;
        } else {
            walk = false;
        }


    }
}
