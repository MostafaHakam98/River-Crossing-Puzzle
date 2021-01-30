package Memento;

import System.Game;

public class Originator {
	
    private Game Game;

    public void setGame(Game Game){
        this.Game = Game;
    }

    public Game getGame(){
        return this.Game;
    }

    public Memento saveGameMemento(){
        return new Memento(Game);
    }

    public Game getGameMemento(Memento memento){
        Game = memento.getState();
        return Game;
    }
}
