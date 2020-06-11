package com.javalesson.oop;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.BlobbyTransition;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.state.transition.RotateTransition;

public class StateTwo extends BasicGameState {
    @Override
    public int getID() {
        return 1;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

    }

    @Override
    public void update(GameContainer container, StateBasedGame sbg, int i) throws SlickException {
        if (container.getInput().isKeyPressed(Input.KEY_A)) {
            sbg.enterState(0, new BlobbyTransition(), new FadeInTransition());
        } else if (container.getInput().isKeyPressed(Input.KEY_X)) {
            sbg.enterState(77);
        }
    }
}
