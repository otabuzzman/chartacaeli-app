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
public class HorizonLocal extends org.chartacaeli.model.HorizonType 
implements java.io.Serializable
{

    /**
     * Composite chart parameter.
     */
    private org.chartacaeli.model.Oblique oblique;

    /**
     * Composite chart parameter.
     */
    private org.chartacaeli.model.Time time;

    public HorizonLocal() {
        super();
    }

    /**
     * Returns the value of field 'oblique'. The field 'oblique'
     * has the following description: Composite chart parameter.
     * 
     * @return the value of field 'Oblique'.
     */
    public org.chartacaeli.model.Oblique getOblique() {
        return this.oblique;
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
     * Sets the value of field 'oblique'. The field 'oblique' has
     * the following description: Composite chart parameter.
     * 
     * @param oblique the value of field 'oblique'.
     */
    public void setOblique(final org.chartacaeli.model.Oblique oblique) {
        this.oblique = oblique;
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
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled org.chartacaeli.model.HorizonLocal
     */
    public static org.chartacaeli.model.HorizonLocal unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.chartacaeli.model.HorizonLocal) org.exolab.castor.xml.Unmarshaller.unmarshal(org.chartacaeli.model.HorizonLocal.class, reader);
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
