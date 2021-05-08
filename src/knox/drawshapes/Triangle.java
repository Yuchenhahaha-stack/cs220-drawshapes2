package knox.drawshapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Triangle extends AbstractShape
{
    protected int width;
    
    public Triangle(Point center, int width, Color color){
    	super(new Point(center.x, center.y), color);
        boundingBox = new BoundingBox(center.x, center.x + width, center.y, center.y + width);
        this.width = width;
    }
    
    /* (non-Javadoc)
     * @see drawshapes.sol.Shape#draw(java.awt.Graphics)
     */
    @Override
    public void draw(Graphics g) {
        if (isSelected()){
            g.setColor(color.darker());
        } else {
            g.setColor(getColor());
        }
        int [] x = {getAnchorPoint().x, getAnchorPoint().x+width/2, getAnchorPoint().x+width};
        int [] y = {getAnchorPoint().y, getAnchorPoint().y+width, getAnchorPoint().y};
        g.fillPolygon(x,y,3);
    }

    public String toString() {
        return String.format("Triangle (%d, %d) width=%d height=%d color=%s selected? %s", 
                getAnchorPoint().x,
                getAnchorPoint().y,
                width,
                Util.colorToString(getColor()),
                selected);
    }
    
    public String encode() {
    	return String.format("Triangle %d %d %d %d %s %s", 
                getAnchorPoint().x,
                getAnchorPoint().y,
                width,
                Util.colorToString(getColor()),
                selected);
    }
    
	@Override
	public void scale(double factor) {
		this.width = (int)(this.width * factor);
	}
	

}
