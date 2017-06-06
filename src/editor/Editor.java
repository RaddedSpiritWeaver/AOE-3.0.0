package editor;

import map.Map;
import map.Terrains;
import map.Tile;
import unoRedo.Arrangement;
import unoRedo.TerrainPlacedEvent;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

/**
 * Created by sarb on 5/29/17.
 */
public class Editor implements KeyListener
{

    private Map map;
    private Arrangement arrangement;

    private int[][] oddNeighbors = { {1,-1}, {1,1}, {0,-1}, {0,-2}, {1,0}, {0,2}, {0,1}, {-1,0} };
    private int[][] evenNeighbors = { {-1,-1}, {-1,1}, {0,-1}, {0,-2}, {1,0}, {0,2}, {0,1}, {-1,0} };

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        Terrains terrainType = Terrains.DEEP_WATER;
        switch (e.getKeyChar())
        {
            case 's':
                terrainType = Terrains.SHALLOW_WATER;
                break;
            case 'd':
                terrainType = Terrains.DEEP_WATER;
                break;
            case 'x':
                terrainType = Terrains.GRASS;
                break;
            case 'a':
                terrainType = Terrains.SAND;
                break;
            case 'm':
                terrainType = Terrains.MOUNTAIN;
                break;
            case 'p':
                terrainType = Terrains.PEAK;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }

    public void changeTerrain(Terrains terrain, int x,int y)
    {
        arrangement.openEventCache();
        placeTerrain(terrain,x,y);
        arrangement.closeEventPatch();
    }

    private void placeTerrain(Terrains terrain, int x, int y)
    {
        map.getTile(x, y).setTerrainType(terrain);
        arrangement.pushEvent( new TerrainPlacedEvent(map.getTile(x,y),terrain) );

        int[][] neighbors;
        if ( y%2 == 0 )
            neighbors = evenNeighbors;
        else
            neighbors = oddNeighbors;

        for (int i = 0; i < 8; i++)
        {
            Tile tile = map.getTile(x + neighbors[i][0],y + neighbors[i][1]);

            if ( tile.getTerrainType().getIndex() >= 0 && tile.getTerrainType().getIndex() < terrain.getIndex()-1 )
                placeTerrain( Terrains.getTerrain( terrain.getIndex() -1 ),x + neighbors[i][0],y + neighbors[i][1] );
            else if ( tile.getTerrainType().getIndex() < 6 && tile.getTerrainType().getIndex() > terrain.getIndex()+1 )
                placeTerrain( Terrains.getTerrain( terrain.getIndex() -1 ),x + neighbors[i][0],y + neighbors[i][1] );
        }
    }

    private void placeTerrain
}
