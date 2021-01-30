package Memento;

import System.Game;

public class Memento {
	
    private Game Game;

    public Memento(Game Game){
        this.Game = Game;
    }

    public Game getState(){
        return Game;
    }
}
