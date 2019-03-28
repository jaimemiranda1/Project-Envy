package Game.Entities.Statics;

import java.awt.Graphics;
import java.awt.Rectangle;

import Game.Entities.Dynamics.Player;
import Game.World.InWorldAreas.TownArea;
import Main.Handler;
import Resources.Images;

public class Portal extends BaseStaticEntity {

	Rectangle collision;
	int width, height;

	public Portal(Handler handler, int xPosition, int yPosition) {
		super(handler, xPosition, yPosition);
		width = 30;
		height = 30;

		this.setXOffset(xPosition);
		this.setYOffset(yPosition);


		collision = new Rectangle();
	}


	@Override
	public void render(Graphics g) {
		if(!Player.isinArea && !TownArea.isInTown)
		g.drawImage(Images.darkHole, (int)(handler.getXInWorldDisplacement() + xPosition),(int)( handler.getYInWorldDisplacement() + yPosition), width, height, null);
	}

	@Override
	public Rectangle getCollision() {
		return collision;
	}

}
