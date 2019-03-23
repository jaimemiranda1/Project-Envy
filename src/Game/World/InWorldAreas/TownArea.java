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
    public final static int playerXSpawn = -2300, playerYSpawn = -340
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
        
        this.entityManager.AddEntity(handler.newOldMan(Images.oldMan,handler,497,1290,"Jaime","WiseOldMan","InWorldState","Town" ));
        
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

        g2.setColor(Color.BLACK);
        entityManager.render(g);

    }

    private void AddWalls() {

    	townWalls.add(new InWorldWalls(handler, 0, 0, 1863, 451, "Wall"));		//Top left trees
    	townWalls.add(new InWorldWalls(handler, 1015, 443, 671, 261, "Wall")); 	//House in top left
    	townWalls.add(new InWorldWalls(handler, 527, 479, 49, 411, "Wall"));	//Left fence of top house
    	townWalls.add(new InWorldWalls(handler, 563, 481, 473, 189, "Wall"));	//Top fence and trees of top house
    	townWalls.add(new InWorldWalls(handler, 537, 811, 563, 87, "Wall"));	//Bottom fence of top house
    	townWalls.add(new InWorldWalls(handler, 1287, 849, 31, 35, "Wall"));	//Mailbox of top house
    	townWalls.add(new InWorldWalls(handler, 1527, 789, 123, 89, "Wall"));	//Sign of top house
    	townWalls.add(new InWorldWalls(handler, 1831, 793, 53, 65, "Wall"));	//Pole in top house
    	townWalls.add(new InWorldWalls(handler, 0, 375, 90, 237, "Wall"));		//Left Trees near top house
    	townWalls.add(new InWorldWalls(handler, 0, 563, 418, 353, "Wall"));		//
    	townWalls.add(new InWorldWalls(handler, 1679, 439, 185, 45, "Wall"));	//Bush in the right of top house
    	townWalls.add(new InWorldWalls(handler, 0, 767, 201, 1337, "Wall"));	//Left trees
    	townWalls.add(new InWorldWalls(handler, 201, 1083, 331, 185, "Wall"));	//Top trees near park
    	townWalls.add(new InWorldWalls(handler, 169, 1259, 197, 141, "Wall"));	//Trees next to bench on park
    	townWalls.add(new InWorldWalls(handler, 191, 1937, 365, 167, "Wall"));	//Trees in the bottom of park
    	townWalls.add(new InWorldWalls(handler, 497, 1995, 3185, 109, "Wall"));	//Trees in the bottom
    	townWalls.add(new InWorldWalls(handler, 815, 1683, 365, 299, "Wall"));	//Trees right corner of park
    	townWalls.add(new InWorldWalls(handler, 481, 1221, 207, 55, "Wall"));	//Bench in park
    	townWalls.add(new InWorldWalls(handler, 1123, 1129, 43, 59, "Wall"));	//Pole in park
    	townWalls.add(new InWorldWalls(handler, 925, 1097, 37, 29, "Wall"));	//Sign in park
    	townWalls.add(new InWorldWalls(handler, 1795, 1119, 945, 505, "Wall"));	//House with pond
    	townWalls.add(new InWorldWalls(handler, 2227, 1645, 513, 83, "Wall"));	//Bottom fence of house with pond
    	townWalls.add(new InWorldWalls(handler, 1815, 1691, 31, 33, "Wall"));	//Mailbox in house with pond
    	townWalls.add(new InWorldWalls(handler, 1709, 1111, 47, 65, "Wall"));	//Pole in house with pond
    	townWalls.add(new InWorldWalls(handler, 1639, 1487, 153, 125, "Wall"));	//Bush next to house with pond
    	townWalls.add(new InWorldWalls(handler, 1551, 1923, 49, 63, "Wall"));	//Pole in the bottom
    	townWalls.add(new InWorldWalls(handler, 3051, 1919, 49, 67, "Wall"));	//Other pole in the bottom (right)
    	townWalls.add(new InWorldWalls(handler, 2967, 1679, 41, 27, "Wall"));	//Sign in right house
    	townWalls.add(new InWorldWalls(handler, 3023, 1105, 659, 483, "Wall"));	//Right house
    	townWalls.add(new InWorldWalls(handler, 3391, 1571, 291, 409, "Wall"));	//Tress on the right side of right house
    	townWalls.add(new InWorldWalls(handler, 3493, 1013, 189, 179, "Wall"));	//Bottom fence near entrance/exit
    	townWalls.add(new InWorldWalls(handler, 3493, 725, 189, 115, "Wall"));	//Top fence near entrance/exit
    	townWalls.add(new InWorldWalls(handler, 3027, 639, 655, 81, "Wall"));	//Bottom fence in top right house
    	townWalls.add(new InWorldWalls(handler, 2185, 0, 1500, 607, "Wall"));	//Top right house
    	townWalls.add(new InWorldWalls(handler, 2425, 673, 31, 37, "Wall"));	//Mailbox in top right house
    	townWalls.add(new InWorldWalls(handler, 2195, 681, 31, 23, "Wall"));	//Sign in top right house
    	townWalls.add(new InWorldWalls(handler, 1853, 0, 323, 124, "Wall"));	//Top bench
    	townWalls.add(new InWorldWalls(handler, 3609, 845, 73, 171, "Exit"));	//Exit the town, topish right corner
    	
    }

    @Override
    public ArrayList<InWorldWalls> getWalls() {
        return townWalls;
    }
}




