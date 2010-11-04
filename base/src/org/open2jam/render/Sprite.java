package org.open2jam.render;

/**
 * A sprite to be displayed on the screen. Note that a sprite
 * contains no state information, i.e. its just the image and 
 * not the location. This allows us to use a single sprite in
 * lots of different places without having to store multiple 
 * copies of the image.
 * 
 * @author Kevin Glass
 */
public interface Sprite {

	public SpriteID getID();

	/**
	 * Get the width of the drawn sprite
	 * 
	 * @return The width in pixels of this sprite
	 */
	public int getWidth();

	/**
	 * Get the height of the drawn sprite
	 * 
	 * @return The height in pixels of this sprite
	 */
	public int getHeight();
	
	/**
	 * Draw the sprite onto the graphics context provided
	 * 
	 * @param x The x location at which to draw the sprite
	 * @param y The y location at which to draw the sprite
	 */
	public void draw(int x,int y);

	/** draw the sprite.
	** the same as draw(int,int)
	** but attempts to draw at the closest point
	*/
	public void draw(double x, double y);
}