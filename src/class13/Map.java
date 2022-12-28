package class13;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Map extends Canvas{
	public interface GameEndListener {
    	void gameClear();
        void gameOver();
    }

	private int mapSize;
	public final int mapWidth;
    public final int mapHeight;
    private Avatar[][] field;
    private GameEndListener listener;
   
    private Number1 number1;
    private Number2 number2;
    private Number3 number3;
    private Number4 number4;
    private Number5 number5;
    private Number6 number6;
    private Number7 number7;
    private Number8 number8;
    private Number9 number9;
    private Number10 number10;
    private Number11 number11;
    private Number12 number12;
    private Number13 number13;
    private Number14 number14;
    private Number15 number15;
    private Number16 number16;
    private Number17 number17;
    private Number18 number18;
    private Number19 number19;
    private Number20 number20;
    private Number21 number21;
    private Number22 number22;
    private Number23 number23;
    private Number24 number24;
    
    public Map(int mapWidth, int mapHeight, int size,int level) {
        super(mapWidth * size, mapHeight * size);

        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.mapSize = size;

        field = new Avatar[mapHeight][mapWidth];
        for (int i = 0; i < mapWidth; i++) {
            for (int j = 0; j < mapHeight; j++) {
                field[j][i] = null;
            }
        }
       
        while (true) {
        	 int xx = (int) (mapWidth * Math.random());
             int yy = (int) (mapHeight * Math.random());
            if (field[yy][xx] != null) {
                continue;
            }
            number1 = new Number1(new Point(xx, yy));
            field[yy][xx] = number1;
            break;
        }
        while (true) {
        	 int xx = (int) (mapWidth * Math.random());
             int yy = (int) (mapHeight * Math.random());
            if (field[yy][xx] != null) {
                continue;
            }
            number2 = new Number2(new Point(xx, yy));
            field[yy][xx] = number2;
            break;
        }
        while (true) {
        	 int xx = (int) (mapWidth * Math.random());
             int yy = (int) (mapHeight * Math.random());
            if (field[yy][xx] != null) {
                continue;
            }
            number3 = new Number3(new Point(xx, yy));
            field[yy][xx] = number3;
            break;
        }
        while (true) {
        	 int xx = (int) (mapWidth * Math.random());
             int yy = (int) (mapHeight * Math.random());
            if (field[yy][xx] != null) {
                continue;
            }
            number4 = new Number4(new Point(xx, yy));
            field[yy][xx] = number4;
            break;
        }
        while (true) {
        	 int xx = (int) (mapWidth * Math.random());
             int yy = (int) (mapHeight * Math.random());
            if (field[yy][xx] != null) {
                continue;
            }
            number5 = new Number5(new Point(xx, yy));
            field[yy][xx] = number5;
            break;
        }
        while (true) {
        	 int xx = (int) (mapWidth * Math.random());
             int yy = (int) (mapHeight * Math.random());
            if (field[yy][xx] != null) {
                continue;
            }
            number6 = new Number6(new Point(xx, yy));
            field[yy][xx] = number6;
            break;
        }
        while (true) {
        	 int xx = (int) (mapWidth * Math.random());
             int yy = (int) (mapHeight * Math.random());
            if (field[yy][xx] != null) {
                continue;
            }
            number7 = new Number7(new Point(xx, yy));
            field[yy][xx] = number7;
            break;
        }
        while (true) {
        	 int xx = (int) (mapWidth * Math.random());
             int yy = (int) (mapHeight * Math.random());
            if (field[yy][xx] != null) {
                continue;
            }
            number8 = new Number8(new Point(xx, yy));
            field[yy][xx] = number8;
            break;
        }
        if(level==2||level==3) {
        	 while (true) {
            	 int xx = (int) (mapWidth * Math.random());
                 int yy = (int) (mapHeight * Math.random());
                if (field[yy][xx] != null) {
                    continue;
                }
                number9 = new Number9(new Point(xx, yy));
                field[yy][xx] = number9;
                break;
            }
        	 while (true) {
            	 int xx = (int) (mapWidth * Math.random());
                 int yy = (int) (mapHeight * Math.random());
                if (field[yy][xx] != null) {
                    continue;
                }
                number10 = new Number10(new Point(xx, yy));
                field[yy][xx] = number10;
                break;
            }
        	 while (true) {
            	 int xx = (int) (mapWidth * Math.random());
                 int yy = (int) (mapHeight * Math.random());
                if (field[yy][xx] != null) {
                    continue;
                }
                number11 = new Number11(new Point(xx, yy));
                field[yy][xx] = number11;
                break;
            }
        	 while (true) {
            	 int xx = (int) (mapWidth * Math.random());
                 int yy = (int) (mapHeight * Math.random());
                if (field[yy][xx] != null) {
                    continue;
                }
                number12 = new Number12(new Point(xx, yy));
                field[yy][xx] = number12;
                break;
            }
        	 while (true) {
            	 int xx = (int) (mapWidth * Math.random());
                 int yy = (int) (mapHeight * Math.random());
                if (field[yy][xx] != null) {
                    continue;
                }
                number13 = new Number13(new Point(xx, yy));
                field[yy][xx] = number13;
                break;
            }
        	 while (true) {
            	 int xx = (int) (mapWidth * Math.random());
                 int yy = (int) (mapHeight * Math.random());
                if (field[yy][xx] != null) {
                    continue;
                }
                number14 = new Number14(new Point(xx, yy));
                field[yy][xx] = number14;
                break;
            }
        	 while (true) {
            	 int xx = (int) (mapWidth * Math.random());
                 int yy = (int) (mapHeight * Math.random());
                if (field[yy][xx] != null) {
                    continue;
                }
                number15 = new Number15(new Point(xx, yy));
                field[yy][xx] = number15;
                break;
            }
        }
        if(level==3) {
        	 while (true) {
            	 int xx = (int) (mapWidth * Math.random());
                 int yy = (int) (mapHeight * Math.random());
                if (field[yy][xx] != null) {
                    continue;
                }
                number16 = new Number16(new Point(xx, yy));
                field[yy][xx] = number16;
                break;
            }
        	 while (true) {
            	 int xx = (int) (mapWidth * Math.random());
                 int yy = (int) (mapHeight * Math.random());
                if (field[yy][xx] != null) {
                    continue;
                }
                number17 = new Number17(new Point(xx, yy));
                field[yy][xx] = number17;
                break;
            }
        	 while (true) {
            	 int xx = (int) (mapWidth * Math.random());
                 int yy = (int) (mapHeight * Math.random());
                if (field[yy][xx] != null) {
                    continue;
                }
                number18 = new Number18(new Point(xx, yy));
                field[yy][xx] = number18;
                break;
            }
        	 while (true) {
            	 int xx = (int) (mapWidth * Math.random());
                 int yy = (int) (mapHeight * Math.random());
                if (field[yy][xx] != null) {
                    continue;
                }
                number19 = new Number19(new Point(xx, yy));
                field[yy][xx] = number19;
                break;
            }
        	 while (true) {
            	 int xx = (int) (mapWidth * Math.random());
                 int yy = (int) (mapHeight * Math.random());
                if (field[yy][xx] != null) {
                    continue;
                }
                number20 = new Number20(new Point(xx, yy));
                field[yy][xx] = number20;
                break;
            }
        	 while (true) {
            	 int xx = (int) (mapWidth * Math.random());
                 int yy = (int) (mapHeight * Math.random());
                if (field[yy][xx] != null) {
                    continue;
                }
                number21 = new Number21(new Point(xx, yy));
                field[yy][xx] = number21;
                break;
            }
        	 while (true) {
            	 int xx = (int) (mapWidth * Math.random());
                 int yy = (int) (mapHeight * Math.random());
                if (field[yy][xx] != null) {
                    continue;
                }
                number22 = new Number22(new Point(xx, yy));
                field[yy][xx] = number22;
                break;
            }
        	 while (true) {
            	 int xx = (int) (mapWidth * Math.random());
                 int yy = (int) (mapHeight * Math.random());
                if (field[yy][xx] != null) {
                    continue;
                }
                number23 = new Number23(new Point(xx, yy));
                field[yy][xx] = number23;
                break;
            }
        	 while (true) {
            	 int xx = (int) (mapWidth * Math.random());
                 int yy = (int) (mapHeight * Math.random());
                if (field[yy][xx] != null) {
                    continue;
                }
                number24 = new Number24(new Point(xx, yy));
                field[yy][xx] = number24;
                break;
            }
        }
        
    }
    public void setGameEndListener(GameEndListener listener) {
        this.listener = listener;
    }
    public Avatar[][] getField() {
        return field;
    }

    public void setField(Avatar[][] field,int level) {
        if (field == null) return;

        this.field = field;
  
        for (int j = 0; j < mapHeight; j++) {
            for (int i = 0; i < mapWidth; i++) {
                Avatar a = field[j][i];
                
                if (a instanceof Number1) {
                    number1=(Number1)a;
                }
                else if (a instanceof Number2) {
                    number2=(Number2)a;
                }
                else if (a instanceof Number3) {
                    number3=(Number3)a;
                }
                else if (a instanceof Number4) {
                    number4=(Number4)a;
                }
                else if (a instanceof Number5) {
                    number5=(Number5)a;
                }
                else if (a instanceof Number6) {
                    number6=(Number6)a;
                }
                else if (a instanceof Number7) {
                    number7=(Number7)a;
                }
                else if (a instanceof Number8) {
                    number8=(Number8)a;
                }
                if(level==2||level==3) {
                	if (a instanceof Number9) {
                        number9=(Number9)a;
                    }
                    else if (a instanceof Number10) {
                        number10=(Number10)a;
                    }
                    else if (a instanceof Number11) {
                        number11=(Number11)a;
                    }
                    else if (a instanceof Number12) {
                        number12=(Number12)a;
                    }
                    else if (a instanceof Number13) {
                        number13=(Number13)a;
                    }
                    else if (a instanceof Number14) {
                        number14=(Number14)a;
                    }
                    else if (a instanceof Number15) {
                        number15=(Number15)a;
                    }
                }
                if(level==3) {
                	if (a instanceof Number16) {
                        number16=(Number16)a;
                    }
                    else if (a instanceof Number17) {
                        number17=(Number17)a;
                    }
                    else if (a instanceof Number18) {
                        number18=(Number18)a;
                    }
                    else if (a instanceof Number19) {
                        number19=(Number19)a;
                    }
                    else if (a instanceof Number20) {
                        number20=(Number20)a;
                    }
                    else if (a instanceof Number21) {
                        number21=(Number21)a;
                    }
                    else if (a instanceof Number22) {
                        number22=(Number22)a;
                    }
                    else if (a instanceof Number23) {
                        number23=(Number23)a;
                    }
                    else if (a instanceof Number24) {
                        number24=(Number24)a;
                    }
                }
            }
        }

        paint(level);
    }
    public void paint(int level) {
        GraphicsContext gc = getGraphicsContext2D();

        // ”wŒi‚ğ•`‰æ
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, this.getWidth(), this.getHeight());

        gc.drawImage(number1.image,
                number1.getPositionX() * mapSize,
                number1.getPositionY() * mapSize,
                mapSize,
                mapSize);
        gc.drawImage(number2.image,
                number2.getPositionX() * mapSize,
                number2.getPositionY() * mapSize,
                mapSize,
                mapSize);
        gc.drawImage(number3.image,
                number3.getPositionX() * mapSize,
                number3.getPositionY() * mapSize,
                mapSize,
                mapSize);
        gc.drawImage(number4.image,
                number4.getPositionX() * mapSize,
                number4.getPositionY() * mapSize,
                mapSize,
                mapSize);
        gc.drawImage(number5.image,
                number5.getPositionX() * mapSize,
                number5.getPositionY() * mapSize,
                mapSize,
                mapSize);
        gc.drawImage(number6.image,
                number6.getPositionX() * mapSize,
                number6.getPositionY() * mapSize,
                mapSize,
                mapSize);
        gc.drawImage(number7.image,
                number7.getPositionX() * mapSize,
                number7.getPositionY() * mapSize,
                mapSize,
                mapSize);
        gc.drawImage(number8.image,
                number8.getPositionX() * mapSize,
                number8.getPositionY() * mapSize,
                mapSize,
                mapSize);
        if(level==2||level==3) {
        	gc.drawImage(number9.image,
                    number9.getPositionX() * mapSize,
                    number9.getPositionY() * mapSize,
                    mapSize,
                    mapSize);
            gc.drawImage(number10.image,
                    number10.getPositionX() * mapSize,
                    number10.getPositionY() * mapSize,
                    mapSize,
                    mapSize);
            gc.drawImage(number11.image,
                    number11.getPositionX() * mapSize,
                    number11.getPositionY() * mapSize,
                    mapSize,
                    mapSize);
            gc.drawImage(number12.image,
                    number12.getPositionX() * mapSize,
                    number12.getPositionY() * mapSize,
                    mapSize,
                    mapSize);
            gc.drawImage(number13.image,
                    number13.getPositionX() * mapSize,
                    number13.getPositionY() * mapSize,
                    mapSize,
                    mapSize);
            gc.drawImage(number14.image,
                    number14.getPositionX() * mapSize,
                    number14.getPositionY() * mapSize,
                    mapSize,
                    mapSize);
            gc.drawImage(number15.image,
                    number15.getPositionX() * mapSize,
                    number15.getPositionY() * mapSize,
                    mapSize,
                    mapSize);
        }
        if(level==3) {
        	gc.drawImage(number16.image,
                    number16.getPositionX() * mapSize,
                    number16.getPositionY() * mapSize,
                    mapSize,
                    mapSize);
            gc.drawImage(number17.image,
                    number17.getPositionX() * mapSize,
                    number17.getPositionY() * mapSize,
                    mapSize,
                    mapSize);
            gc.drawImage(number18.image,
                    number18.getPositionX() * mapSize,
                    number18.getPositionY() * mapSize,
                    mapSize,
                    mapSize);
            gc.drawImage(number19.image,
                    number19.getPositionX() * mapSize,
                    number19.getPositionY() * mapSize,
                    mapSize,
                    mapSize);
            gc.drawImage(number20.image,
                    number20.getPositionX() * mapSize,
                    number20.getPositionY() * mapSize,
                    mapSize,
                    mapSize);
            gc.drawImage(number21.image,
                    number21.getPositionX() * mapSize,
                    number21.getPositionY() * mapSize,
                    mapSize,
                    mapSize);
            gc.drawImage(number22.image,
                    number22.getPositionX() * mapSize,
                    number22.getPositionY() * mapSize,
                    mapSize,
                    mapSize);
            gc.drawImage(number23.image,
                    number23.getPositionX() * mapSize,
                    number23.getPositionY() * mapSize,
                    mapSize,
                    mapSize);
            gc.drawImage(number24.image,
                    number24.getPositionX() * mapSize,
                    number24.getPositionY() * mapSize,
                    mapSize,
                    mapSize);
        }
    }
    public void moveNumver1(int key) {
        move(number1, key);
    }
    public void moveNumver2(int key) {
        move(number2, key);
    }
    public void moveNumver3(int key) {
        move(number3, key);
    }
    public void moveNumver4(int key) {
        move(number4, key);
    }
    public void moveNumver5(int key) {
        move(number5, key);
    }
    public void moveNumver6(int key) {
        move(number6, key);
    }
    public void moveNumver7(int key) {
        move(number7, key);
    }
    public void moveNumver8(int key) {
        move(number8, key);
    }
    public void moveNumver9(int key) {
        move(number9, key);
    }
    public void moveNumver10(int key) {
        move(number10, key);
    }
    public void moveNumver11(int key) {
        move(number11, key);
    }
    public void moveNumver12(int key) {
        move(number12, key);
    }
    public void moveNumver13(int key) {
        move(number13, key);
    }
    public void moveNumver14(int key) {
        move(number14, key);
    }
    public void moveNumver15(int key) {
        move(number15, key);
    }
    public void moveNumver16(int key) {
        move(number16, key);
    }
    public void moveNumver17(int key) {
        move(number17, key);
    }
    public void moveNumver18(int key) {
        move(number18, key);
    }
    public void moveNumver19(int key) {
        move(number19, key);
    }
    public void moveNumver20(int key) {
        move(number20, key);
    }
    public void moveNumver21(int key) {
        move(number21, key);
    }
    public void moveNumver22(int key) {
        move(number22, key);
    }
    public void moveNumver23(int key) {
        move(number23, key);
    }
    public void moveNumver24(int key) {
        move(number24, key);
    }
    private void move(Creature creature, int key) {
        // “®•¨‚ÌˆÊ’u‚ğ—\‚ßƒNƒŠƒA‚µ‚Ä‚¨‚­
        field[creature.position.y][creature.position.x] = null;

        Avatar avatar = nextAvatar(creature, key);
        if (avatar == null) {
            creature.move(key);
        }
        
        // “®•¨‚ÌˆÊ’u‚ğ‹L˜^‚·‚é
        field[creature.position.y][creature.position.x] = creature;
    }

    public Avatar nextAvatar(Avatar avatar, int key) {
        int newValue;
        switch (key) {
            case 6:
                newValue = avatar.position.x + 1;
                if (newValue < mapWidth) {
                    return field[avatar.position.y][newValue];
                }
                break;

            case 4:
                newValue = avatar.position.x - 1;
                if (0 <= newValue) {
                    return field[avatar.position.y][newValue];
                }
                break;

            case 8:
                newValue = avatar.position.y - 1;
                if (0 <= newValue) {
                    return field[newValue][avatar.position.x];
                }
                break;

            case 2:
                newValue = avatar.position.y + 1;
                if (newValue < mapHeight) {
                    return field[newValue][avatar.position.x];
                }
                break;
        }
		return avatar;//avatar‚Í‚Ä‚«‚Æ‚¤
    }



    
}
