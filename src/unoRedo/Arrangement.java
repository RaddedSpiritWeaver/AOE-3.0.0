package unoRedo;


import editor.Editor;

import java.util.EmptyStackException;
import java.util.Stack;

public class Arrangement
{

    private Stack<MyEventPack> undo;
    private Stack<MyEventPack> redo;
    private Editor theEditor;
    public MyEventPack eventCach;

    public Arrangement(Editor e)
    {
        this.theEditor = e;
        eventCach = new MyEventPack();
        undo = new Stack<>();
        redo = new Stack<>();
    }

    private void surfAPack(MyEventPack eventPack,boolean undo){
        for(TerrainPlacedEvent event : eventPack.getTerrainChanges()){
            if(undo){
                theEditor.placeTileFromArrangement(event.getOldTileState().getTerrainType(),event.getOldTileState().getX(),event.getOldTileState().getY());

            }
            else{
                theEditor.placeTileFromArrangement(event.getNewTileState().getTerrainType(),event.getNewTileState().getX(),event.getNewTileState().getY());

            }
        }
    }

    public void pushEvent(TerrainPlacedEvent e){
        eventCach.addEvent(e);
    }
    public void openEventCach(){
        this.eventCach = new MyEventPack();
    }
    public void closeEventCach(){
        undo.push(this.eventCach);
        openEventCach(); // aammm alan serfan event chach ro new kardam bejasg mishe hamin evnet cach ro clear kard ...
    }


    public void undo()
    {
        try
        {

            MyEventPack tempEventPack = undo.pop();
            redo.push(tempEventPack);
            surfAPack(tempEventPack,true);
            ////////API

        }catch (EmptyStackException e){
            System.out.printf("nothing to undo ... ");
        }
    }

    public void redo()
    {
        try
        {
            MyEventPack tempEventPack = redo.pop();
            undo.push(tempEventPack);
            surfAPack(tempEventPack,false);
            ////////API

        }catch (EmptyStackException e){

            System.out.println("Nothing to redo ...");
        }
    }

    public void undoPush(MyEventPack eventPack){
        undo.push(eventPack);
    }

    public void clearRedo()
    {
        redo.clear();
    }

}
