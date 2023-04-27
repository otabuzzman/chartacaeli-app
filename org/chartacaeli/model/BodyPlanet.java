/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package org.chartacaeli.model;

/**
 * Chart feature element.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class BodyPlanet extends org.chartacaeli.model.BodyOrbitalType 
implements java.io.Serializable
{

    /**
     * Discrete chart parameter.
     */
    private java.lang.String type;

    private boolean geocentric;

    /**
     * Keeps track of whether primitive field geocentric has been
     * set already.
     */
    private boolean hasgeocentric;

    public BodyPlanet() {
        super();
    }

    /**
     */
    public void deleteGeocentric() {
        this.hasgeocentric= false;
    }

    /**
     * Returns the value of field 'geocentric'.
     * 
     * @return the value of field 'Geocentric'.
     */
    public boolean getGeocentric() {
        return this.geocentric;
    }

    /**
     * Returns the value of field 'type'. The field 'type' has the
     * following description: Discrete chart parameter.
     * 
     * @return the value of field 'Type'.
     */
    public java.lang.String getType() {
        return this.type;
    }

    /**
     * Method hasGeocentric.
     * 
     * @return true if at least one Geocentric has been added
     */
    public boolean hasGeocentric() {
        return this.hasgeocentric;
    }

    /**
     * Returns the value of field 'geocentric'.
     * 
     * @return the value of field 'Geocentric'.
     */
    public boolean isGeocentric() {
        return this.geocentric;
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
     * Sets the value of field 'geocentric'.
     * 
     * @param geocentric the value of field 'geocentric'.
     */
    public void setGeocentric(final boolean geocentric) {
        this.geocentric = geocentric;
        this.hasgeocentric = true;
    }

    /**
     * Sets the value of field 'type'. The field 'type' has the
     * following description: Discrete chart parameter.
     * 
     * @param type the value of field 'type'.
     */
    public void setType(final java.lang.String type) {
        this.type = type;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled org.chartacaeli.model.BodyPlanet
     */
    public static org.chartacaeli.model.BodyPlanet unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.chartacaeli.model.BodyPlanet) org.exolab.castor.xml.Unmarshaller.unmarshal(org.chartacaeli.model.BodyPlanet.class, reader);
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
