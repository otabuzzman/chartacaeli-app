/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package org.chartacaeli.model;

/**
 * Chart feature class.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Circle extends org.chartacaeli.Peer 
implements java.io.Serializable
{

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Chart feature element.
     */
    private org.chartacaeli.model.CircleParallel circleParallel;

    /**
     * Chart feature element.
     */
    private org.chartacaeli.model.CircleMeridian circleMeridian;

    /**
     * Chart feature element.
     */
    private org.chartacaeli.model.CircleSouthernPolar circleSouthernPolar;

    /**
     * Chart feature element.
     */
    private org.chartacaeli.model.CircleNorthernPolar circleNorthernPolar;

    /**
     * Chart feature element.
     */
    private org.chartacaeli.model.CircleSouthernTropic circleSouthernTropic;

    /**
     * Chart feature element.
     */
    private org.chartacaeli.model.CircleNorthernTropic circleNorthernTropic;

    public Circle() {
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
     * Returns the value of field 'circleMeridian'. The field
     * 'circleMeridian' has the following description: Chart
     * feature element.
     * 
     * @return the value of field 'CircleMeridian'.
     */
    public org.chartacaeli.model.CircleMeridian getCircleMeridian() {
        return this.circleMeridian;
    }

    /**
     * Returns the value of field 'circleNorthernPolar'. The field
     * 'circleNorthernPolar' has the following description: Chart
     * feature element.
     * 
     * @return the value of field 'CircleNorthernPolar'.
     */
    public org.chartacaeli.model.CircleNorthernPolar getCircleNorthernPolar() {
        return this.circleNorthernPolar;
    }

    /**
     * Returns the value of field 'circleNorthernTropic'. The field
     * 'circleNorthernTropic' has the following description: Chart
     * feature element.
     * 
     * @return the value of field 'CircleNorthernTropic'.
     */
    public org.chartacaeli.model.CircleNorthernTropic getCircleNorthernTropic() {
        return this.circleNorthernTropic;
    }

    /**
     * Returns the value of field 'circleParallel'. The field
     * 'circleParallel' has the following description: Chart
     * feature element.
     * 
     * @return the value of field 'CircleParallel'.
     */
    public org.chartacaeli.model.CircleParallel getCircleParallel() {
        return this.circleParallel;
    }

    /**
     * Returns the value of field 'circleSouthernPolar'. The field
     * 'circleSouthernPolar' has the following description: Chart
     * feature element.
     * 
     * @return the value of field 'CircleSouthernPolar'.
     */
    public org.chartacaeli.model.CircleSouthernPolar getCircleSouthernPolar() {
        return this.circleSouthernPolar;
    }

    /**
     * Returns the value of field 'circleSouthernTropic'. The field
     * 'circleSouthernTropic' has the following description: Chart
     * feature element.
     * 
     * @return the value of field 'CircleSouthernTropic'.
     */
    public org.chartacaeli.model.CircleSouthernTropic getCircleSouthernTropic() {
        return this.circleSouthernTropic;
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
     * Sets the value of field 'circleMeridian'. The field
     * 'circleMeridian' has the following description: Chart
     * feature element.
     * 
     * @param circleMeridian the value of field 'circleMeridian'.
     */
    public void setCircleMeridian(final org.chartacaeli.model.CircleMeridian circleMeridian) {
        this.circleMeridian = circleMeridian;
        this._choiceValue = circleMeridian;
    }

    /**
     * Sets the value of field 'circleNorthernPolar'. The field
     * 'circleNorthernPolar' has the following description: Chart
     * feature element.
     * 
     * @param circleNorthernPolar the value of field
     * 'circleNorthernPolar'.
     */
    public void setCircleNorthernPolar(final org.chartacaeli.model.CircleNorthernPolar circleNorthernPolar) {
        this.circleNorthernPolar = circleNorthernPolar;
        this._choiceValue = circleNorthernPolar;
    }

    /**
     * Sets the value of field 'circleNorthernTropic'. The field
     * 'circleNorthernTropic' has the following description: Chart
     * feature element.
     * 
     * @param circleNorthernTropic the value of field
     * 'circleNorthernTropic'.
     */
    public void setCircleNorthernTropic(final org.chartacaeli.model.CircleNorthernTropic circleNorthernTropic) {
        this.circleNorthernTropic = circleNorthernTropic;
        this._choiceValue = circleNorthernTropic;
    }

    /**
     * Sets the value of field 'circleParallel'. The field
     * 'circleParallel' has the following description: Chart
     * feature element.
     * 
     * @param circleParallel the value of field 'circleParallel'.
     */
    public void setCircleParallel(final org.chartacaeli.model.CircleParallel circleParallel) {
        this.circleParallel = circleParallel;
        this._choiceValue = circleParallel;
    }

    /**
     * Sets the value of field 'circleSouthernPolar'. The field
     * 'circleSouthernPolar' has the following description: Chart
     * feature element.
     * 
     * @param circleSouthernPolar the value of field
     * 'circleSouthernPolar'.
     */
    public void setCircleSouthernPolar(final org.chartacaeli.model.CircleSouthernPolar circleSouthernPolar) {
        this.circleSouthernPolar = circleSouthernPolar;
        this._choiceValue = circleSouthernPolar;
    }

    /**
     * Sets the value of field 'circleSouthernTropic'. The field
     * 'circleSouthernTropic' has the following description: Chart
     * feature element.
     * 
     * @param circleSouthernTropic the value of field
     * 'circleSouthernTropic'.
     */
    public void setCircleSouthernTropic(final org.chartacaeli.model.CircleSouthernTropic circleSouthernTropic) {
        this.circleSouthernTropic = circleSouthernTropic;
        this._choiceValue = circleSouthernTropic;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled org.chartacaeli.model.Circle
     */
    public static org.chartacaeli.model.Circle unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.chartacaeli.model.Circle) org.exolab.castor.xml.Unmarshaller.unmarshal(org.chartacaeli.model.Circle.class, reader);
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
