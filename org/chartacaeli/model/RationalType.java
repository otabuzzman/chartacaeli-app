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
public abstract class RationalType extends org.chartacaeli.Peer 
implements java.io.Serializable
{

    /**
     * Discrete chart parameter.
     */
    private double value;

    /**
     * Keeps track of whether primitive field value has been set
     * already.
     */
    private boolean hasvalue;

    public RationalType() {
        super();
    }

    /**
     */
    public void deleteValue() {
        this.hasvalue= false;
    }

    /**
     * Returns the value of field 'value'. The field 'value' has
     * the following description: Discrete chart parameter.
     * 
     * @return the value of field 'Value'.
     */
    public double getValue() {
        return this.value;
    }

    /**
     * Method hasValue.
     * 
     * @return true if at least one Value has been added
     */
    public boolean hasValue() {
        return this.hasvalue;
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
     * Sets the value of field 'value'. The field 'value' has the
     * following description: Discrete chart parameter.
     * 
     * @param value the value of field 'value'.
     */
    public void setValue(final double value) {
        this.value = value;
        this.hasvalue = true;
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
