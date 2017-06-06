package map;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sarb on 5/27/17.
 */
public enum Terrains
{
    DEEP_WATER(new Color(0,0,255,255),null,0),
    SHALLOW_WATER(new Color(0,204,204,255),null,1),
    SAND(new Color(255,153,51,255),null,2),
    GRASS(new Color(102,204,0,255),null,3),
    MOUNTAIN(new Color(204,102,0,255),null,4),
    PEAK(new Color(102,51,0,255),null,5);

    private Color color;
    private ImageIcon imageIcon;
    private int index;

    Terrains(Color color, ImageIcon imageIcon, int index)
    {
        this.color = color;
        this.imageIcon = imageIcon;
        this.index = index;
    }

    public static Terrains getTerrain(int index)
    {
        switch (index)
        {
            case 0:
                return DEEP_WATER;
            case 1:
                return SHALLOW_WATER;
            case 2:
                return SAND;
            case 3:
                return GRASS;
            case 4:
                return MOUNTAIN;
            case 5:
                return PEAK;
            default:
                return null;
        }
    }

    public int getIndex()
    {
        return index;
    }
}
