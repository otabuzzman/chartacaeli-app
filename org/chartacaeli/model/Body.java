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
public class Body extends org.chartacaeli.Peer 
implements java.io.Serializable
{

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Chart feature element.
     */
    private org.chartacaeli.model.BodyStellar bodyStellar;

    /**
     * Chart feature element.
     */
    private org.chartacaeli.model.BodyAreal bodyAreal;

    /**
     * Chart feature element.
     */
    private org.chartacaeli.model.BodyPlanet bodyPlanet;

    /**
     * Chart feature element.
     */
    private org.chartacaeli.model.BodyMoon bodyMoon;

    /**
     * Chart feature element.
     */
    private org.chartacaeli.model.BodySun bodySun;

    /**
     * Chart feature element.
     */
    private org.chartacaeli.model.BodyElliptical bodyElliptical;

    /**
     * Chart feature element.
     */
    private org.chartacaeli.model.BodyParabolical bodyParabolical;

    public Body() {
        super();
    }

    /**
     * Returns the value of field 'bodyAreal'. The field
     * 'bodyAreal' has the following description: Chart feature
     * element.
     * 
     * @return the value of field 'BodyAreal'.
     */
    public org.chartacaeli.model.BodyAreal getBodyAreal() {
        return this.bodyAreal;
    }

    /**
     * Returns the value of field 'bodyElliptical'. The field
     * 'bodyElliptical' has the following description: Chart
     * feature element.
     * 
     * @return the value of field 'BodyElliptical'.
     */
    public org.chartacaeli.model.BodyElliptical getBodyElliptical() {
        return this.bodyElliptical;
    }

    /**
     * Returns the value of field 'bodyMoon'. The field 'bodyMoon'
     * has the following description: Chart feature element.
     * 
     * @return the value of field 'BodyMoon'.
     */
    public org.chartacaeli.model.BodyMoon getBodyMoon() {
        return this.bodyMoon;
    }

    /**
     * Returns the value of field 'bodyParabolical'. The field
     * 'bodyParabolical' has the following description: Chart
     * feature element.
     * 
     * @return the value of field 'BodyParabolical'.
     */
    public org.chartacaeli.model.BodyParabolical getBodyParabolical() {
        return this.bodyParabolical;
    }

    /**
     * Returns the value of field 'bodyPlanet'. The field
     * 'bodyPlanet' has the following description: Chart feature
     * element.
     * 
     * @return the value of field 'BodyPlanet'.
     */
    public org.chartacaeli.model.BodyPlanet getBodyPlanet() {
        return this.bodyPlanet;
    }

    /**
     * Returns the value of field 'bodyStellar'. The field
     * 'bodyStellar' has the following description: Chart feature
     * element.
     * 
     * @return the value of field 'BodyStellar'.
     */
    public org.chartacaeli.model.BodyStellar getBodyStellar() {
        return this.bodyStellar;
    }

    /**
     * Returns the value of field 'bodySun'. The field 'bodySun'
     * has the following description: Chart feature element.
     * 
     * @return the value of field 'BodySun'.
     */
    public org.chartacaeli.model.BodySun getBodySun() {
        return this.bodySun;
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
     * Sets the value of field 'bodyAreal'. The field 'bodyAreal'
     * has the following description: Chart feature element.
     * 
     * @param bodyAreal the value of field 'bodyAreal'.
     */
    public void setBodyAreal(final org.chartacaeli.model.BodyAreal bodyAreal) {
        this.bodyAreal = bodyAreal;
        this._choiceValue = bodyAreal;
    }

    /**
     * Sets the value of field 'bodyElliptical'. The field
     * 'bodyElliptical' has the following description: Chart
     * feature element.
     * 
     * @param bodyElliptical the value of field 'bodyElliptical'.
     */
    public void setBodyElliptical(final org.chartacaeli.model.BodyElliptical bodyElliptical) {
        this.bodyElliptical = bodyElliptical;
        this._choiceValue = bodyElliptical;
    }

    /**
     * Sets the value of field 'bodyMoon'. The field 'bodyMoon' has
     * the following description: Chart feature element.
     * 
     * @param bodyMoon the value of field 'bodyMoon'.
     */
    public void setBodyMoon(final org.chartacaeli.model.BodyMoon bodyMoon) {
        this.bodyMoon = bodyMoon;
        this._choiceValue = bodyMoon;
    }

    /**
     * Sets the value of field 'bodyParabolical'. The field
     * 'bodyParabolical' has the following description: Chart
     * feature element.
     * 
     * @param bodyParabolical the value of field 'bodyParabolical'.
     */
    public void setBodyParabolical(final org.chartacaeli.model.BodyParabolical bodyParabolical) {
        this.bodyParabolical = bodyParabolical;
        this._choiceValue = bodyParabolical;
    }

    /**
     * Sets the value of field 'bodyPlanet'. The field 'bodyPlanet'
     * has the following description: Chart feature element.
     * 
     * @param bodyPlanet the value of field 'bodyPlanet'.
     */
    public void setBodyPlanet(final org.chartacaeli.model.BodyPlanet bodyPlanet) {
        this.bodyPlanet = bodyPlanet;
        this._choiceValue = bodyPlanet;
    }

    /**
     * Sets the value of field 'bodyStellar'. The field
     * 'bodyStellar' has the following description: Chart feature
     * element.
     * 
     * @param bodyStellar the value of field 'bodyStellar'.
     */
    public void setBodyStellar(final org.chartacaeli.model.BodyStellar bodyStellar) {
        this.bodyStellar = bodyStellar;
        this._choiceValue = bodyStellar;
    }

    /**
     * Sets the value of field 'bodySun'. The field 'bodySun' has
     * the following description: Chart feature element.
     * 
     * @param bodySun the value of field 'bodySun'.
     */
    public void setBodySun(final org.chartacaeli.model.BodySun bodySun) {
        this.bodySun = bodySun;
        this._choiceValue = bodySun;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled org.chartacaeli.model.Body
     */
    public static org.chartacaeli.model.Body unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.chartacaeli.model.Body) org.exolab.castor.xml.Unmarshaller.unmarshal(org.chartacaeli.model.Body.class, reader);
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
