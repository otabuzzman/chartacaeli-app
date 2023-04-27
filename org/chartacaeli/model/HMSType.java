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
public abstract class HMSType extends org.chartacaeli.Peer 
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
    private int hrs;

    /**
     * Keeps track of whether primitive field hrs has been set
     * already.
     */
    private boolean hashrs;

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

    public HMSType() {
        super();
    }

    /**
     */
    public void deleteHrs() {
        this.hashrs= false;
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
     * Returns the value of field 'hrs'. The field 'hrs' has the
     * following description: Discrete chart parameter.
     * 
     * @return the value of field 'Hrs'.
     */
    public int getHrs() {
        return this.hrs;
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
     * Method hasHrs.
     * 
     * @return true if at least one Hrs has been added
     */
    public boolean hasHrs() {
        return this.hashrs;
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
     * Sets the value of field 'hrs'. The field 'hrs' has the
     * following description: Discrete chart parameter.
     * 
     * @param hrs the value of field 'hrs'.
     */
    public void setHrs(final int hrs) {
        this.hrs = hrs;
        this.hashrs = true;
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
