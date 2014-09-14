package player;

import input.Input;
import level.LoadLevel;
import level.tile.Tile;
import gfx.Render;
import gfx.Sprite;

public class Player 
{
	public int x, y;
	private LoadLevel loadLevel;
	private Sprite sprite;
	private Input input;
	private boolean walking;
	public static int won = 0;
	
	public Player(LoadLevel loadLevel, int x, int y, Input input)
	{
		this.loadLevel = loadLevel;
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.player;
		walking = true;
	}
	
	public void setXY(int x, int y)
	{
		this.x = x;
		this.y = y;
		walking = true;
	}
	
	public void update()
	{
		int xa = 0, ya = 0;
		if(walking)
		{
			if (input.up) ya -= 2;
			if (input.down) ya += 2;
			if (input.left) xa -= 2;
			if (input.right) xa += 2;
		}

		if(xa != 0 || ya != 0)
		{
			move(xa, ya);
		}
	}
	
	public void update2()
	{
		if (input.R)
		{
			setXY((1 * 32), (14 * 32));
			Player.won = 0;
		}
	}
	
	public void render(Render render)
	{
		render.renderPlayer(x, y, sprite);
	}
	
	public void move(int xa, int ya)
	{
		if(xa != 0 && ya != 0)
		{
			move(xa, 0);
			move(0, ya);
			return;
		}
				
		if(!collision(xa, ya))
		{
			 x += xa;
			 y += ya;
		}
	}
	
	public boolean collision(int xa, int ya)
	{
		boolean solid = false;
		for(int c = 0; c < 4; c++)
		{	
			int xt = ((x + xa) + (((c % 2) * 17) + 7)) >> 5;
			int yt = ((y + ya) + (((c / 2) * 16)  + 8)) >> 5;
			
			if (loadLevel.getTile(xt, yt).solid()) solid = true;
			if (solid) walking = false;
			if (loadLevel.getTile(xt, yt) == Tile.block)
			{
				won = 1;
			}
			if (loadLevel.getTile(xt, yt) == Tile.finish)
			{
				won = 2;
			}
		}
		
		return solid;
	}
	
}
