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
public class DialTypeChoice extends org.chartacaeli.Peer 
implements java.io.Serializable
{

    /**
     * Composite chart parameter.
     */
    private org.chartacaeli.model.ScalebaseNone scalebaseNone;

    /**
     * Composite chart parameter.
     */
    private org.chartacaeli.model.ScalebaseLine scalebaseLine;

    /**
     * Composite chart parameter.
     */
    private org.chartacaeli.model.ScalebaseRail scalebaseRail;

    public DialTypeChoice() {
        super();
    }

    /**
     * Returns the value of field 'scalebaseLine'. The field
     * 'scalebaseLine' has the following description: Composite
     * chart parameter.
     * 
     * @return the value of field 'ScalebaseLine'.
     */
    public org.chartacaeli.model.ScalebaseLine getScalebaseLine() {
        return this.scalebaseLine;
    }

    /**
     * Returns the value of field 'scalebaseNone'. The field
     * 'scalebaseNone' has the following description: Composite
     * chart parameter.
     * 
     * @return the value of field 'ScalebaseNone'.
     */
    public org.chartacaeli.model.ScalebaseNone getScalebaseNone() {
        return this.scalebaseNone;
    }

    /**
     * Returns the value of field 'scalebaseRail'. The field
     * 'scalebaseRail' has the following description: Composite
     * chart parameter.
     * 
     * @return the value of field 'ScalebaseRail'.
     */
    public org.chartacaeli.model.ScalebaseRail getScalebaseRail() {
        return this.scalebaseRail;
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
     * Sets the value of field 'scalebaseLine'. The field
     * 'scalebaseLine' has the following description: Composite
     * chart parameter.
     * 
     * @param scalebaseLine the value of field 'scalebaseLine'.
     */
    public void setScalebaseLine(final org.chartacaeli.model.ScalebaseLine scalebaseLine) {
        this.scalebaseLine = scalebaseLine;
    }

    /**
     * Sets the value of field 'scalebaseNone'. The field
     * 'scalebaseNone' has the following description: Composite
     * chart parameter.
     * 
     * @param scalebaseNone the value of field 'scalebaseNone'.
     */
    public void setScalebaseNone(final org.chartacaeli.model.ScalebaseNone scalebaseNone) {
        this.scalebaseNone = scalebaseNone;
    }

    /**
     * Sets the value of field 'scalebaseRail'. The field
     * 'scalebaseRail' has the following description: Composite
     * chart parameter.
     * 
     * @param scalebaseRail the value of field 'scalebaseRail'.
     */
    public void setScalebaseRail(final org.chartacaeli.model.ScalebaseRail scalebaseRail) {
        this.scalebaseRail = scalebaseRail;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled org.chartacaeli.model.DialTypeChoice
     */
    public static org.chartacaeli.model.DialTypeChoice unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.chartacaeli.model.DialTypeChoice) org.exolab.castor.xml.Unmarshaller.unmarshal(org.chartacaeli.model.DialTypeChoice.class, reader);
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
