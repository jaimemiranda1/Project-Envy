package Game.World.InWorldAreas;

import Main.GameSetUp;
import Main.Handler;
import Resources.Images;
import java.awt.*;
import java.util.ArrayList;

import Game.Entities.EntityManager;
import Game.Entities.Statics.LightStatue;
import Game.World.Walls;

public class TownArea extends BaseArea {

    Rectangle exit;
    Rectangle playerRect;
    public static boolean isInTown = false;

    private int imageWidth = 3682, imageHeight = 2104;
    public final static int playerXSpawn = -380, playerYSpawn = -1180
    		;

    private Rectangle background = new Rectangle(3000, 3000);

    public static ArrayList<InWorldWalls> townWalls;

    public TownArea(Handler handler, EntityManager entityManager) {
        super(handler, entityManager);
        name="Town";
        handler.setXInWorldDisplacement(playerXSpawn);
        handler.setYInWorldDisplacement(playerYSpawn);

        playerRect = new Rectangle((int) handler.getWidth() / 2 - 5, (int) (handler.getHeight() / 2) + 300, 70, 70);

        this.entityManager = entityManager;
        
        townWalls = new ArrayList<>();
        AddWalls();

    }

    public void tick() {
        super.tick();

        for (Walls w : townWalls) {
            w.tick();
        }
        if(!GameSetUp.LOADING) {
            entityManager.tick();
        }

    }

    @Override
    public void render(Graphics g) {
        super.render(g);


        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.black);
        g2.fill(background);

        g.drawImage(Images.TownMap, handler.getXInWorldDisplacement(), handler.getYInWorldDisplacement(), null);

        if (GameSetUp.DEBUGMODE) {
            for (Walls w : townWalls) {

                if (w.getType().equals("Wall"))
                    g2.setColor(Color.black);
                else
                    g2.setColor(Color.PINK);

                w.render(g2);
            }
        }


        entityManager.render(g);

    }

    private void AddWalls() {

    	townWalls.add(new InWorldWalls(handler, 1601, 1099, 1188, 664, "Wall"));	//House with pond
    	townWalls.add(new InWorldWalls(handler, 2947, 1099, 540, 662, "Wall"));		//House in bottom right corner
    	townWalls.add(new InWorldWalls(handler, 0, 1939, 3682, 165, "Wall"));		//Bottom Corner
    	townWalls.add(new InWorldWalls(handler, 3393, 1713, 289, 239, "Wall"));		//Right Corner
    	townWalls.add(new InWorldWalls(handler, 3487, 1001, 195, 807, "Wall"));		//
    	townWalls.add(new InWorldWalls(handler, 3487, 0, 195, 846, "Wall"));		//
    	townWalls.add(new InWorldWalls(handler, 2111, 0, 1383, 752, "Wall"));		//House in top right corner
    	townWalls.add(new InWorldWalls(handler, 0, 0, 1917, 922, "Wall"));			//House in top left
    	townWalls.add(new InWorldWalls(handler, 0, 917, 254, 1187, "Wall"));		//Left Corner
    	townWalls.add(new InWorldWalls(handler, 245, 1093, 249, 211, "Wall"));		//
    	townWalls.add(new InWorldWalls(handler, 253, 1229, 119, 169, "Wall"));		//
    	townWalls.add(new InWorldWalls(handler, 1917, 0, 197, 84, "Wall"));			//Bench on top
    	townWalls.add(new InWorldWalls(handler, 491, 1213, 193, 53, "Wall"));		//Bench in park
    	townWalls.add(new InWorldWalls(handler, 1115, 1131, 57, 59, "Wall"));		//Pole near park
    	townWalls.add(new InWorldWalls(handler, 807, 1687, 377, 285, "Wall"));		//Trees near park on the bottom
    	townWalls.add(new InWorldWalls(handler, 3609, 845, 73, 171, "Exit"));		//Exit the cave, topish right corner
    	
    }

    @Override
    public ArrayList<InWorldWalls> getWalls() {
        return townWalls;
    }
}




