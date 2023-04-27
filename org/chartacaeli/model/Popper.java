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
public class Popper extends org.chartacaeli.Peer 
implements java.io.Serializable
{

    /**
     * Composite chart parameter.
     */
    private org.chartacaeli.model.Position position;

    /**
     * Composite chart parameter.
     */
    private org.chartacaeli.model.Cartesian cartesian;

    public Popper() {
        super();
    }

    /**
     * Returns the value of field 'cartesian'. The field
     * 'cartesian' has the following description: Composite chart
     * parameter.
     * 
     * @return the value of field 'Cartesian'.
     */
    public org.chartacaeli.model.Cartesian getCartesian() {
        return this.cartesian;
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
     * Sets the value of field 'cartesian'. The field 'cartesian'
     * has the following description: Composite chart parameter.
     * 
     * @param cartesian the value of field 'cartesian'.
     */
    public void setCartesian(final org.chartacaeli.model.Cartesian cartesian) {
        this.cartesian = cartesian;
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
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled org.chartacaeli.model.Popper
     */
    public static org.chartacaeli.model.Popper unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.chartacaeli.model.Popper) org.exolab.castor.xml.Unmarshaller.unmarshal(org.chartacaeli.model.Popper.class, reader);
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
