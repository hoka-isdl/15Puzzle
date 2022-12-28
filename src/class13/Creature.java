package class13;

import java.awt.Point;

class Creature extends Avatar {
	private Map map;

    public Creature(Point p, String avatarImage) {
        super(p, avatarImage);
    }
    
    public void move(int key) {
       
        switch (key) {
            case 6:
            	position.x++;
                break;
            case 4:
                position.x--;
                break;
            case 8:
                position.y--;
                break;
            case 2:
                position.y++;
                break;
        }
    }
}
