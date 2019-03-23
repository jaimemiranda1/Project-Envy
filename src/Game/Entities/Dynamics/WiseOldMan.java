package Game.Entities.Dynamics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.sun.glass.events.KeyEvent;

import Game.GameStates.FightState;
import Input.KeyManager;
import Main.Handler;
import Resources.Images;


public class WiseOldMan extends BaseHostileEntity {

	Rectangle wiseOldMan;
	int width, height;
	public static boolean talking;
	public static boolean activeQuest;
	public static boolean canUseSkill = false;
	

	public WiseOldMan(Handler handler, int xPosition, int yPosition, String state, String name1, String area, BufferedImage[] animFrames) {
		super(handler, yPosition, yPosition, state, name1, area, animFrames);
		width = 100;
		height = 100;
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
		g.setFont(new Font("Arial",Font.BOLD,28));
		Graphics2D g2 = (Graphics2D) g;


		if(handler.getArea().equals("Town")) {
			if (!Player.checkInWorld) {
				wiseOldMan = new Rectangle((int) (handler.getXDisplacement() + getXOffset()),
						(int) (handler.getYDisplacement() + getYOffset()), 45, 45);

			} else {
				wiseOldMan = new Rectangle((int) (handler.getXInWorldDisplacement() + getXOffset()),
						(int) (handler.getYInWorldDisplacement() + getYOffset()), 80, 80);
				

			}

			g2.setColor(Color.BLACK);

			g.drawImage(Images.oldMan[0],wiseOldMan.x,wiseOldMan.y,wiseOldMan.width,wiseOldMan.height,null);
			
			if(BaseHostileEntity.playerInRange && !talking) {
					g.drawImage(Images.Talk,wiseOldMan.x,wiseOldMan.y - 100,wiseOldMan.width,wiseOldMan.height - 10,null);
				}
			if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_E) && BaseHostileEntity.playerInRange) {
				talking = true;
				activeQuest = true;
				
				}
			
			
			if(talking && BaseHostileEntity.playerInRange && !FightState.unlockedSkill ) {
				
				g.drawString("Greetings traveler, slay Jovan,", wiseOldMan.x - 120,wiseOldMan.y - 75);
				g.drawString(" and I shall bestow upon thee, magic powers!", wiseOldMan.x - 230, wiseOldMan.y -50);
			}
			else if( talking && FightState.unlockedSkill && BaseHostileEntity.playerInRange) {
				
				handler.getEntityManager().getPlayer().setSkill("Freeze");
				g.drawString("Welcome back traveler, I see you have completed my quest.", wiseOldMan.x - 300,wiseOldMan.y - 75);
				g.drawString("As promised, here are thy macgical POWERSS! Go to the CAVE now.", wiseOldMan.x - 360, wiseOldMan.y -50);
				canUseSkill = true;
				
			}
			
			else if(!BaseHostileEntity.playerInRange) {
				talking = false;
			}
			
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
