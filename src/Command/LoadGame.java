package Command;

import System.Game;

public class LoadGame implements Command {
	
    private Game Game;

    public LoadGame(Game Game){
        this.Game = Game;
    }

    @Override
    public void execute() {
        Game.load();
    }
}
