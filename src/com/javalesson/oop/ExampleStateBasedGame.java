package com.javalesson.oop;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Базовый класс игры основанной на сценах или состояниях
 *
 */
public class ExampleStateBasedGame extends StateBasedGame {
    public ExampleStateBasedGame(String name) {
        super(name);
    }

    /**
     * @param container
     * @throws SlickException
     * Метод в котором мы объявляем все состояния игры
     */
    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        this.addState(new StateStart());
        this.addState(new StateTwo());
        this.addState(new GameOverState());

        container.setTargetFrameRate(60);
        container.setAlwaysRender(true);
        container.setVSync(true);
    }


    public static void main(String[] args) throws SlickException {
        AppGameContainer container = new AppGameContainer(new ExampleStateBasedGame("State Base"));
        container.setDisplayMode(640, 480, false);
        container.start();
    }
}
