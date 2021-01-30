package Command;

import System.Game;

public class SaveGame implements Command {
    private Game Game;

    public SaveGame(Game Game){
        this.Game = Game;
    }

    @Override
    public void execute() {
        Game.save();
    }
}