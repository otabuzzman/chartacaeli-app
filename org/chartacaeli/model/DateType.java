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
public abstract class DateType extends org.chartacaeli.Peer 
implements java.io.Serializable
{

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Composite chart parameter.
     */
    private org.chartacaeli.model.Calendar calendar;

    /**
     * Composite chart parameter.
     */
    private org.chartacaeli.model.JD JD;

    public DateType() {
        super();
    }

    /**
     * Returns the value of field 'calendar'. The field 'calendar'
     * has the following description: Composite chart parameter.
     * 
     * @return the value of field 'Calendar'.
     */
    public org.chartacaeli.model.Calendar getCalendar() {
        return this.calendar;
    }

    /**
     * Returns the value of field 'choiceValue'. The field
     * 'choiceValue' has the following description: Internal choice
     * value storage
     * 
     * @return the value of field 'ChoiceValue'.
     */
    public java.lang.Object getChoiceValue() {
        return this._choiceValue;
    }

    /**
     * Returns the value of field 'JD'. The field 'JD' has the
     * following description: Composite chart parameter.
     * 
     * @return the value of field 'JD'.
     */
    public org.chartacaeli.model.JD getJD() {
        return this.JD;
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
     * Sets the value of field 'calendar'. The field 'calendar' has
     * the following description: Composite chart parameter.
     * 
     * @param calendar the value of field 'calendar'.
     */
    public void setCalendar(final org.chartacaeli.model.Calendar calendar) {
        this.calendar = calendar;
        this._choiceValue = calendar;
    }

    /**
     * Sets the value of field 'JD'. The field 'JD' has the
     * following description: Composite chart parameter.
     * 
     * @param JD the value of field 'JD'.
     */
    public void setJD(final org.chartacaeli.model.JD JD) {
        this.JD = JD;
        this._choiceValue = JD;
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
