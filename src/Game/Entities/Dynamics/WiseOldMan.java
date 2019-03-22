package Game.Entities.Dynamics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Main.Handler;
import Resources.Images;

public class WiseOldMan extends BaseHostileEntity {

	Rectangle wiseOldMan;
	int width, height;

	public WiseOldMan(Handler handler, int xPosition, int yPosition, String state, String name1, String area, BufferedImage[] animFrames) {
		super(handler, yPosition, yPosition, state, name1, area, animFrames);
		width = 30;
		height = 30;
		speed = 1;
		type="WiseOldMan";
		this.setXOffset(xPosition);
		this.setYOffset(yPosition);

		this.foundState = state;
		wiseOldMan = new Rectangle();
	}

	@Override
	public void tick() {

		if(!Player.isinArea)super.tick();

	}
	@Override
	public void render(Graphics g) {
		super.render(g);

		Graphics2D g2 = (Graphics2D) g;


		if(handler.getArea().equals(this.Area)) {
			if (!Player.checkInWorld) {
				wiseOldMan = new Rectangle((int) (handler.getXDisplacement() + getXOffset()),
						(int) (handler.getYDisplacement() + getYOffset()), 45, 45);

			} else {
				wiseOldMan = new Rectangle((int) (handler.getXInWorldDisplacement() + getXOffset()),
						(int) (handler.getYInWorldDisplacement() + getYOffset()), 70, 70);

			}

			g2.setColor(Color.black);

			g.drawImage(Images.ghost,wiseOldMan.x,wiseOldMan.y,wiseOldMan.width,wiseOldMan.height,null);

			if (wiseOldMan.intersects(handler.getEntityManager().getPlayer().getCollision())) {
				handler.getEntityManager().getPlayer().facing = "Left";
			}
		}
	}
	@Override
	public Rectangle getCollision() {
		return wiseOldMan;
	}
}
