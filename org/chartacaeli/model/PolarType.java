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
public abstract class PolarType extends org.chartacaeli.Peer 
implements java.io.Serializable
{

    /**
     * Composite chart parameter.
     */
    private org.chartacaeli.model.Phi phi;

    /**
     * Composite chart parameter.
     */
    private org.chartacaeli.model.Rad rad;

    public PolarType() {
        super();
    }

    /**
     * Returns the value of field 'phi'. The field 'phi' has the
     * following description: Composite chart parameter.
     * 
     * @return the value of field 'Phi'.
     */
    public org.chartacaeli.model.Phi getPhi() {
        return this.phi;
    }

    /**
     * Returns the value of field 'rad'. The field 'rad' has the
     * following description: Composite chart parameter.
     * 
     * @return the value of field 'Rad'.
     */
    public org.chartacaeli.model.Rad getRad() {
        return this.rad;
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
     * Sets the value of field 'phi'. The field 'phi' has the
     * following description: Composite chart parameter.
     * 
     * @param phi the value of field 'phi'.
     */
    public void setPhi(final org.chartacaeli.model.Phi phi) {
        this.phi = phi;
    }

    /**
     * Sets the value of field 'rad'. The field 'rad' has the
     * following description: Composite chart parameter.
     * 
     * @param rad the value of field 'rad'.
     */
    public void setRad(final org.chartacaeli.model.Rad rad) {
        this.rad = rad;
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
