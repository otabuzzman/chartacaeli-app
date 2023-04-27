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
public abstract class YMDType extends org.chartacaeli.Peer 
implements java.io.Serializable
{

    /**
     * Discrete chart parameter.
     */
    private long y;

    /**
     * Keeps track of whether primitive field y has been set already
     */
    private boolean hasy;

    /**
     * Discrete chart parameter.
     */
    private long m;

    /**
     * Keeps track of whether primitive field m has been set already
     */
    private boolean hasm;

    /**
     * Discrete chart parameter.
     */
    private long d;

    /**
     * Keeps track of whether primitive field d has been set already
     */
    private boolean hasd;

    public YMDType() {
        super();
    }

    /**
     */
    public void deleteD() {
        this.hasd= false;
    }

    /**
     */
    public void deleteM() {
        this.hasm= false;
    }

    /**
     */
    public void deleteY() {
        this.hasy= false;
    }

    /**
     * Returns the value of field 'd'. The field 'd' has the
     * following description: Discrete chart parameter.
     * 
     * @return the value of field 'D'.
     */
    public long getD() {
        return this.d;
    }

    /**
     * Returns the value of field 'm'. The field 'm' has the
     * following description: Discrete chart parameter.
     * 
     * @return the value of field 'M'.
     */
    public long getM() {
        return this.m;
    }

    /**
     * Returns the value of field 'y'. The field 'y' has the
     * following description: Discrete chart parameter.
     * 
     * @return the value of field 'Y'.
     */
    public long getY() {
        return this.y;
    }

    /**
     * Method hasD.
     * 
     * @return true if at least one D has been added
     */
    public boolean hasD() {
        return this.hasd;
    }

    /**
     * Method hasM.
     * 
     * @return true if at least one M has been added
     */
    public boolean hasM() {
        return this.hasm;
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
     * Sets the value of field 'd'. The field 'd' has the following
     * description: Discrete chart parameter.
     * 
     * @param d the value of field 'd'.
     */
    public void setD(final long d) {
        this.d = d;
        this.hasd = true;
    }

    /**
     * Sets the value of field 'm'. The field 'm' has the following
     * description: Discrete chart parameter.
     * 
     * @param m the value of field 'm'.
     */
    public void setM(final long m) {
        this.m = m;
        this.hasm = true;
    }

    /**
     * Sets the value of field 'y'. The field 'y' has the following
     * description: Discrete chart parameter.
     * 
     * @param y the value of field 'y'.
     */
    public void setY(final long y) {
        this.y = y;
        this.hasy = true;
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
