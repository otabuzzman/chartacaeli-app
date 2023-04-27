/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package org.chartacaeli.model;

/**
 * Composite chart parameter.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ShapeElliptical extends org.chartacaeli.model.AngleType 
implements java.io.Serializable
{

    /**
     * Discrete chart parameter.
     */
    private double proportion;

    /**
     * Keeps track of whether primitive field proportion has been
     * set already.
     */
    private boolean hasproportion;

    /**
     * Discrete chart parameter.
     */
    private double PA;

    /**
     * Keeps track of whether primitive field PA has been set
     * already.
     */
    private boolean hasPA;

    /**
     * Composite chart parameter.
     */
    private org.chartacaeli.model.Position position;

    public ShapeElliptical() {
        super();
    }

    /**
     */
    public void deletePA() {
        this.hasPA= false;
    }

    /**
     */
    public void deleteProportion() {
        this.hasproportion= false;
    }

    /**
     * Returns the value of field 'PA'. The field 'PA' has the
     * following description: Discrete chart parameter.
     * 
     * @return the value of field 'PA'.
     */
    public double getPA() {
        return this.PA;
    }

    /**
     * Returns the value of field 'position'. The field 'position'
     * has the following description: Composite chart parameter.
     * 
     * @return the value of field 'Position'.
     */
    public org.chartacaeli.model.Position getPosition() {
        return this.position;
    }

    /**
     * Returns the value of field 'proportion'. The field
     * 'proportion' has the following description: Discrete chart
     * parameter.
     * 
     * @return the value of field 'Proportion'.
     */
    public double getProportion() {
        return this.proportion;
    }

    /**
     * Method hasPA.
     * 
     * @return true if at least one PA has been added
     */
    public boolean hasPA() {
        return this.hasPA;
    }

    /**
     * Method hasProportion.
     * 
     * @return true if at least one Proportion has been added
     */
    public boolean hasProportion() {
        return this.hasproportion;
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
     * 
     * 
     * @param out
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void marshal(final java.io.Writer out) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Marshaller.marshal(this, out);
    }

    /**
     * 
     * 
     * @param handler
     * @throws java.io.IOException if an IOException occurs during
     * marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     */
    public void marshal(final org.xml.sax.ContentHandler handler) throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Marshaller.marshal(this, handler);
    }

    /**
     * Sets the value of field 'PA'. The field 'PA' has the
     * following description: Discrete chart parameter.
     * 
     * @param PA the value of field 'PA'.
     */
    public void setPA(final double PA) {
        this.PA = PA;
        this.hasPA = true;
    }

    /**
     * Sets the value of field 'position'. The field 'position' has
     * the following description: Composite chart parameter.
     * 
     * @param position the value of field 'position'.
     */
    public void setPosition(final org.chartacaeli.model.Position position) {
        this.position = position;
    }

    /**
     * Sets the value of field 'proportion'. The field 'proportion'
     * has the following description: Discrete chart parameter.
     * 
     * @param proportion the value of field 'proportion'.
     */
    public void setProportion(final double proportion) {
        this.proportion = proportion;
        this.hasproportion = true;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled org.chartacaeli.model.ShapeElliptical
     */
    public static org.chartacaeli.model.ShapeElliptical unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.chartacaeli.model.ShapeElliptical) org.exolab.castor.xml.Unmarshaller.unmarshal(org.chartacaeli.model.ShapeElliptical.class, reader);
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
