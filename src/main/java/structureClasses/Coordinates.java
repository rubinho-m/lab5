/**

 The Coordinates class represents the coordinates of a ticket point.
 It provides methods to access and modify the x and y coordinates.
 */

package structureClasses;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
@XmlAccessorType(XmlAccessType.FIELD)
public class Coordinates {
    /**
     * The x coordinate of the point.
     */
    @XmlElement(name = "x")
    private float x;

    /**
     * The y coordinate of the point.
     */
    @XmlElement(name = "y")
    private int y;

    /**
     * Sets the x coordinate of the point.
     *
     * @param x the x coordinate of the point
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Sets the y coordinate of the point.
     *
     * @param y the y coordinate of the point
     */
    public void setY(int y) {
        this.y = y;
    }

}
