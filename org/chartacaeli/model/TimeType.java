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
public abstract class TimeType extends org.chartacaeli.Peer 
implements java.io.Serializable
{

    /**
     * Discrete chart parameter.
     */
    private java.lang.String standard;

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Composite chart parameter.
     */
    private org.chartacaeli.model.HMS HMS;

    /**
     * Composite chart parameter.
     */
    private org.chartacaeli.model.Rational rational;

    public TimeType() {
        super();
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
     * Returns the value of field 'HMS'. The field 'HMS' has the
     * following description: Composite chart parameter.
     * 
     * @return the value of field 'HMS'.
     */
    public org.chartacaeli.model.HMS getHMS() {
        return this.HMS;
    }

    /**
     * Returns the value of field 'rational'. The field 'rational'
     * has the following description: Composite chart parameter.
     * 
     * @return the value of field 'Rational'.
     */
    public org.chartacaeli.model.Rational getRational() {
        return this.rational;
    }

    /**
     * Returns the value of field 'standard'. The field 'standard'
     * has the following description: Discrete chart parameter.
     * 
     * @return the value of field 'Standard'.
     */
    public java.lang.String getStandard() {
        return this.standard;
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
     * Sets the value of field 'HMS'. The field 'HMS' has the
     * following description: Composite chart parameter.
     * 
     * @param HMS the value of field 'HMS'.
     */
    public void setHMS(final org.chartacaeli.model.HMS HMS) {
        this.HMS = HMS;
        this._choiceValue = HMS;
    }

    /**
     * Sets the value of field 'rational'. The field 'rational' has
     * the following description: Composite chart parameter.
     * 
     * @param rational the value of field 'rational'.
     */
    public void setRational(final org.chartacaeli.model.Rational rational) {
        this.rational = rational;
        this._choiceValue = rational;
    }

    /**
     * Sets the value of field 'standard'. The field 'standard' has
     * the following description: Discrete chart parameter.
     * 
     * @param standard the value of field 'standard'.
     */
    public void setStandard(final java.lang.String standard) {
        this.standard = standard;
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
