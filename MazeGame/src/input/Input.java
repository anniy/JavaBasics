package input;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener
{
	private boolean keys[] = new boolean[128];
	public boolean up, down, left, right, R;

	public void update()
	{
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_LEFT]|| keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
		R = keys[KeyEvent.VK_R];
	}
	
	public void keyPressed(KeyEvent event) 
	{
		keys[event.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent event) 
	{
		keys[event.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent event) 
	{

	}

}
