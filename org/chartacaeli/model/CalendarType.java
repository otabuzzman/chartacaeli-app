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
public abstract class CalendarType extends org.chartacaeli.Peer 
implements java.io.Serializable
{

    /**
     * Composite chart parameter.
     */
    private org.chartacaeli.model.YMD YMD;

    /**
     * Composite chart parameter.
     */
    private org.chartacaeli.model.Time time;

    public CalendarType() {
        super();
    }

    /**
     * Returns the value of field 'time'. The field 'time' has the
     * following description: Composite chart parameter.
     * 
     * @return the value of field 'Time'.
     */
    public org.chartacaeli.model.Time getTime() {
        return this.time;
    }

    /**
     * Returns the value of field 'YMD'. The field 'YMD' has the
     * following description: Composite chart parameter.
     * 
     * @return the value of field 'YMD'.
     */
    public org.chartacaeli.model.YMD getYMD() {
        return this.YMD;
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
     * Sets the value of field 'time'. The field 'time' has the
     * following description: Composite chart parameter.
     * 
     * @param time the value of field 'time'.
     */
    public void setTime(final org.chartacaeli.model.Time time) {
        this.time = time;
    }

    /**
     * Sets the value of field 'YMD'. The field 'YMD' has the
     * following description: Composite chart parameter.
     * 
     * @param YMD the value of field 'YMD'.
     */
    public void setYMD(final org.chartacaeli.model.YMD YMD) {
        this.YMD = YMD;
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
