package unoRedo;

import map.Tile;

public class TerrainPlacedEvent
{
    private Tile oldTileState;
    private Tile newTileState;

    public TerrainPlacedEvent(Tile oldTileState, Tile newTileState) {
        this.oldTileState = oldTileState;
        this.newTileState = newTileState;
    }

    public Tile getOldTileState() {
        return oldTileState;
    }

    public Tile getNewTileState() {
        return newTileState;
    }

}
