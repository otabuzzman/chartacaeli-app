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
public abstract class DMSType extends org.chartacaeli.Peer 
implements java.io.Serializable
{

    /**
     * Discrete chart parameter.
     */
    private boolean neg;

    /**
     * Keeps track of whether primitive field neg has been set
     * already.
     */
    private boolean hasneg;

    /**
     * Discrete chart parameter.
     */
    private int deg;

    /**
     * Keeps track of whether primitive field deg has been set
     * already.
     */
    private boolean hasdeg;

    /**
     * Discrete chart parameter.
     */
    private int min;

    /**
     * Keeps track of whether primitive field min has been set
     * already.
     */
    private boolean hasmin;

    /**
     * Discrete chart parameter.
     */
    private double sec;

    /**
     * Keeps track of whether primitive field sec has been set
     * already.
     */
    private boolean hassec;

    public DMSType() {
        super();
    }

    /**
     */
    public void deleteDeg() {
        this.hasdeg= false;
    }

    /**
     */
    public void deleteMin() {
        this.hasmin= false;
    }

    /**
     */
    public void deleteNeg() {
        this.hasneg= false;
    }

    /**
     */
    public void deleteSec() {
        this.hassec= false;
    }

    /**
     * Returns the value of field 'deg'. The field 'deg' has the
     * following description: Discrete chart parameter.
     * 
     * @return the value of field 'Deg'.
     */
    public int getDeg() {
        return this.deg;
    }

    /**
     * Returns the value of field 'min'. The field 'min' has the
     * following description: Discrete chart parameter.
     * 
     * @return the value of field 'Min'.
     */
    public int getMin() {
        return this.min;
    }

    /**
     * Returns the value of field 'neg'. The field 'neg' has the
     * following description: Discrete chart parameter.
     * 
     * @return the value of field 'Neg'.
     */
    public boolean getNeg() {
        return this.neg;
    }

    /**
     * Returns the value of field 'sec'. The field 'sec' has the
     * following description: Discrete chart parameter.
     * 
     * @return the value of field 'Sec'.
     */
    public double getSec() {
        return this.sec;
    }

    /**
     * Method hasDeg.
     * 
     * @return true if at least one Deg has been added
     */
    public boolean hasDeg() {
        return this.hasdeg;
    }

    /**
     * Method hasMin.
     * 
     * @return true if at least one Min has been added
     */
    public boolean hasMin() {
        return this.hasmin;
    }

    /**
     * Method hasNeg.
     * 
     * @return true if at least one Neg has been added
     */
    public boolean hasNeg() {
        return this.hasneg;
    }

    /**
     * Method hasSec.
     * 
     * @return true if at least one Sec has been added
     */
    public boolean hasSec() {
        return this.hassec;
    }

    /**
     * Returns the value of field 'neg'. The field 'neg' has the
     * following description: Discrete chart parameter.
     * 
     * @return the value of field 'Neg'.
     */
    public boolean isNeg() {
        return this.neg;
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
     * Sets the value of field 'deg'. The field 'deg' has the
     * following description: Discrete chart parameter.
     * 
     * @param deg the value of field 'deg'.
     */
    public void setDeg(final int deg) {
        this.deg = deg;
        this.hasdeg = true;
    }

    /**
     * Sets the value of field 'min'. The field 'min' has the
     * following description: Discrete chart parameter.
     * 
     * @param min the value of field 'min'.
     */
    public void setMin(final int min) {
        this.min = min;
        this.hasmin = true;
    }

    /**
     * Sets the value of field 'neg'. The field 'neg' has the
     * following description: Discrete chart parameter.
     * 
     * @param neg the value of field 'neg'.
     */
    public void setNeg(final boolean neg) {
        this.neg = neg;
        this.hasneg = true;
    }

    /**
     * Sets the value of field 'sec'. The field 'sec' has the
     * following description: Discrete chart parameter.
     * 
     * @param sec the value of field 'sec'.
     */
    public void setSec(final double sec) {
        this.sec = sec;
        this.hassec = true;
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
