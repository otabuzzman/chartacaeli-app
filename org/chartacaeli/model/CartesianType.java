/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package org.chartacaeli.model;

/**
 * 
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public abstract class CartesianType extends org.chartacaeli.Peer 
implements java.io.Serializable
{

    /**
     * Discrete chart parameter.
     */
    private double x;

    /**
     * Keeps track of whether primitive field x has been set already
     */
    private boolean hasx;

    /**
     * Discrete chart parameter.
     */
    private double y;

    /**
     * Keeps track of whether primitive field y has been set already
     */
    private boolean hasy;

    /**
     * Discrete chart parameter.
     */
    private double z;

    /**
     * Keeps track of whether primitive field z has been set already
     */
    private boolean hasz;

    public CartesianType() {
        super();
    }

    /**
     */
    public void deleteX() {
        this.hasx= false;
    }

    /**
     */
    public void deleteY() {
        this.hasy= false;
    }

    /**
     */
    public void deleteZ() {
        this.hasz= false;
    }

    /**
     * Returns the value of field 'x'. The field 'x' has the
     * following description: Discrete chart parameter.
     * 
     * @return the value of field 'X'.
     */
    public double getX() {
        return this.x;
    }

    /**
     * Returns the value of field 'y'. The field 'y' has the
     * following description: Discrete chart parameter.
     * 
     * @return the value of field 'Y'.
     */
    public double getY() {
        return this.y;
    }

    /**
     * Returns the value of field 'z'. The field 'z' has the
     * following description: Discrete chart parameter.
     * 
     * @return the value of field 'Z'.
     */
    public double getZ() {
        return this.z;
    }

    /**
     * Method hasX.
     * 
     * @return true if at least one X has been added
     */
    public boolean hasX() {
        return this.hasx;
    }

    /**
     * Method hasY.
     * 
     * @return true if at least one Y has been added
     */
    public boolean hasY() {
        return this.hasy;
    }

    /**
     * Method hasZ.
     * 
     * @return true if at least one Z has been added
     */
    public boolean hasZ() {
        return this.hasz;
    }

    /**
     * Method isValid.
     * 
     * @return true if this object is valid according to the schema
     */
    public boolean isValid() {
        try {
            validate();
        } catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    }

    /**
     * Sets the value of field 'x'. The field 'x' has the following
     * description: Discrete chart parameter.
     * 
     * @param x the value of field 'x'.
     */
    public void setX(final double x) {
        this.x = x;
        this.hasx = true;
    }

    /**
     * Sets the value of field 'y'. The field 'y' has the following
     * description: Discrete chart parameter.
     * 
     * @param y the value of field 'y'.
     */
    public void setY(final double y) {
        this.y = y;
        this.hasy = true;
    }

    /**
     * Sets the value of field 'z'. The field 'z' has the following
     * description: Discrete chart parameter.
     * 
     * @param z the value of field 'z'.
     */
    public void setZ(final double z) {
        this.z = z;
        this.hasz = true;
    }

    /**
     * 
     * 
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void validate() throws org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    }

}
