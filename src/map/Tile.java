package map;

import java.awt.*;

/**
 * Created by sarb on 5/27/17.
 */
public class Tile
{
    private Terrains terrainType;
    private int x,y;
    private Object filler;

    public Tile(Terrains terrainType, int x, int y)
    {
        this.terrainType = terrainType;
        this.x = x;
        this.y = y;
        this.filler = null;
    }

    public Polygon getPolygon(int xRoot, int yRoot, int size, int cotang)
    {
        Polygon polygon = new Polygon();

        int relX = ( (x - xRoot) * size ) + size/2  + (y%2)*size/2 ;
        int relY = (y - yRoot) * size / (2* cotang);

        polygon.addPoint(relX, relY);
        polygon.addPoint( relX - size/2, relY + size/(2*cotang));
        polygon.addPoint(relX, relY + size/cotang);
        polygon.addPoint(relX + size/2, relY + size/(2*cotang));

        return polygon;
    }

    public Terrains getTerrainType()
    {
        return terrainType;
    }

    public void setTerrainType(Terrains terrainType)
    {
        this.terrainType = terrainType;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public Object getFiller()
    {
        return filler;
    }

    public void setEmpty(Object filler)
    {
        filler = filler;
    }
}
