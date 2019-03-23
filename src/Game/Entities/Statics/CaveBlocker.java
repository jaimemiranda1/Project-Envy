package Game.Entities.Statics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import Game.Entities.Dynamics.Player;
import Game.GameStates.FightState;
import Main.GameSetUp;
import Main.Handler;
import Resources.Images;

public class CaveBlocker extends BaseStaticEntity {
	Rectangle collision;
	int width, height;
	private Rectangle detector;
	public boolean playerInRange;
	public boolean open = false;
	
	public CaveBlocker(Handler handler, int xPosition, int yPosition) {
		super(handler, xPosition, yPosition);
		width = 50;
		height = 50;
		
		this.setXOffset(xPosition);
		this.setYOffset(yPosition);

		
		collision = new Rectangle();
		detector = new Rectangle();

	}
	
	
	@Override
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		open = PlayerDetected();
		
		

		if(!open || !handler.getEntityManager().getPlayer().getSkill().equals("Freeze")) {
		g.drawImage(Images.caveBlocker, (int)(handler.getXDisplacement() + xPosition),(int)( handler.getYDisplacement() + yPosition), width, height, null);
		collision = new Rectangle((int)(handler.getXDisplacement() + xPosition + 5), (int)(handler.getYDisplacement() + yPosition + 20), width * 2, height * 2);
		}
		
		
	
	}
	
	private boolean PlayerDetected() {

		detector = this.getCollision();

		detector.setRect(detector.getX() - detector.getWidth() * 2, detector.getY() - detector.getHeight() * 2,
				detector.getWidth() * 4, detector.getHeight() * 4);

		playerInRange = handler.getEntityManager().getPlayer().getCollision().intersects(detector);
		
		if(playerInRange && handler.getEntityManager().getPlayer().getSkill().equals("Freeze")) {
		
			return true;
		}
		return open;
		
		

		
	}
	
	@Override
	public Rectangle getCollision() {
		return collision;
	}
	
	@Override
	public double getXOffset() {
		return xPosition;
	}
	
	
}
