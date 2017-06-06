package unoRedo;


import java.util.Vector;

public class MyEventPack {

    private Vector<TerrainPlacedEvent> terrainChanges;
    private Vector<Object> changedObjects;

    public MyEventPack() {
        this.terrainChanges = new Vector<>();
        this.changedObjects = new Vector<>();
    }

    public void addEvent(TerrainPlacedEvent myEvent)
    {
        terrainChanges.add(myEvent);
    }

    public void addObject(Object object)
    {
        changedObjects.add(object);
    }

    public Vector<TerrainPlacedEvent> getTerrainChanges() {
        return terrainChanges;
    }

    public Vector<Object> getChangedObjects() {
        return changedObjects;
    }
}
