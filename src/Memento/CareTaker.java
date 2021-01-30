package Memento;
import java.util.Stack;

public class CareTaker {
	
    private Stack<Memento> Undo = new Stack<Memento>();
    private Stack<Memento> Redo = new Stack<Memento>();

    public void addToUndo(Memento memento){
        Undo.push(memento);
    }

    public void addToRedo(Memento memento){
        Redo.push(memento);
    }

    public void deleteUndo(){
        while (!Undo.isEmpty()){
            Undo.pop();
        }
    }

    public void deleteRedo(){
        while (!Redo.isEmpty()){
           	Redo.pop();
        }
    }

    public Memento popUndo(){
        return Undo.pop();
    }

    public Memento popRedo(){
        return Redo.pop();
    }

    //Check if Undo Available
    public Stack<Memento> getFromUndo() {
        return Undo;
    }

    //Check if Redo Available
    public Stack<Memento> getFromRedo() {
        return Redo;
    }
}