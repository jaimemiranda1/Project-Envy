package Game.Entities.Statics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import Game.GameStates.FightState;
import Main.GameSetUp;
import Main.Handler;
import Resources.Images;

public class CaveBlocker extends BaseStaticEntity {
	Rectangle collision;
	int width, height;
	
	public CaveBlocker(Handler handler, int xPosition, int yPosition) {
		super(handler, xPosition, yPosition);
		width = 50;
		height = 50;
		
		this.setXOffset(xPosition);
		this.setYOffset(yPosition);

		
		collision = new Rectangle();
	}
	
	
	@Override
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		if(!FightState.unlockedSkill) {
		g.drawImage(Images.caveBlocker, (int)(handler.getXDisplacement() + xPosition),(int)( handler.getYDisplacement() + yPosition), width, height, null);
		collision = new Rectangle((int)(handler.getXDisplacement() + xPosition + 5), (int)(handler.getYDisplacement() + yPosition + 20), width * 2, height * 2);
		}
		
		
	
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
