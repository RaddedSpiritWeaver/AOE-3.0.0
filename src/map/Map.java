package map;

/**
 * Created by sarb on 5/29/17.
 */
public class Map
{
    private Tile tiles[][];
    private int widthCoord;
    private int heightCoord;

    public Map(int widthCoord, int heightCoord)
    {
        this.widthCoord = widthCoord;
        this.heightCoord = heightCoord;

        tiles = new Tile[widthCoord][heightCoord];
        for (int i = 0; i < widthCoord; i++)
            for (int j = 0; j < heightCoord; j++)
                tiles[i][j] = new Tile(Terrains.GRASS,i,j);
    }

    public void setTile(Tile tile, int x, int y)
    {
        tiles[x][y] = tile;
    }

    public Tile getTile(int x, int y)
    {
        return tiles[x][y];
    }

}
