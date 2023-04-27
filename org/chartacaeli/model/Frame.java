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
public class Frame extends org.chartacaeli.Peer 
implements java.io.Serializable
{

    /**
     * Discrete chart parameter.
     */
    private java.lang.String anchor;

    /**
     * Discrete chart parameter.
     */
    private java.lang.String number;

    public Frame() {
        super();
    }

    /**
     * Returns the value of field 'anchor'. The field 'anchor' has
     * the following description: Discrete chart parameter.
     * 
     * @return the value of field 'Anchor'.
     */
    public java.lang.String getAnchor() {
        return this.anchor;
    }

    /**
     * Returns the value of field 'number'. The field 'number' has
     * the following description: Discrete chart parameter.
     * 
     * @return the value of field 'Number'.
     */
    public java.lang.String getNumber() {
        return this.number;
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
     * Sets the value of field 'anchor'. The field 'anchor' has the
     * following description: Discrete chart parameter.
     * 
     * @param anchor the value of field 'anchor'.
     */
    public void setAnchor(final java.lang.String anchor) {
        this.anchor = anchor;
    }

    /**
     * Sets the value of field 'number'. The field 'number' has the
     * following description: Discrete chart parameter.
     * 
     * @param number the value of field 'number'.
     */
    public void setNumber(final java.lang.String number) {
        this.number = number;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled org.chartacaeli.model.Frame
     */
    public static org.chartacaeli.model.Frame unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.chartacaeli.model.Frame) org.exolab.castor.xml.Unmarshaller.unmarshal(org.chartacaeli.model.Frame.class, reader);
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
