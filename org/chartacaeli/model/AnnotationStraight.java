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
public class AnnotationStraight extends org.chartacaeli.model.AnnotationType 
implements java.io.Serializable
{

    /**
     * Discrete chart parameter.
     */
    private boolean radiant;

    /**
     * Keeps track of whether primitive field radiant has been set
     * already.
     */
    private boolean hasradiant;

    /**
     * Composite chart parameter.
     */
    private org.chartacaeli.model.Frame frame;

    public AnnotationStraight() {
        super();
    }

    /**
     */
    public void deleteRadiant() {
        this.hasradiant= false;
    }

    /**
     * Returns the value of field 'frame'. The field 'frame' has
     * the following description: Composite chart parameter.
     * 
     * @return the value of field 'Frame'.
     */
    public org.chartacaeli.model.Frame getFrame() {
        return this.frame;
    }

    /**
     * Returns the value of field 'radiant'. The field 'radiant'
     * has the following description: Discrete chart parameter.
     * 
     * @return the value of field 'Radiant'.
     */
    public boolean getRadiant() {
        return this.radiant;
    }

    /**
     * Method hasRadiant.
     * 
     * @return true if at least one Radiant has been added
     */
    public boolean hasRadiant() {
        return this.hasradiant;
    }

    /**
     * Returns the value of field 'radiant'. The field 'radiant'
     * has the following description: Discrete chart parameter.
     * 
     * @return the value of field 'Radiant'.
     */
    public boolean isRadiant() {
        return this.radiant;
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
     * Sets the value of field 'frame'. The field 'frame' has the
     * following description: Composite chart parameter.
     * 
     * @param frame the value of field 'frame'.
     */
    public void setFrame(final org.chartacaeli.model.Frame frame) {
        this.frame = frame;
    }

    /**
     * Sets the value of field 'radiant'. The field 'radiant' has
     * the following description: Discrete chart parameter.
     * 
     * @param radiant the value of field 'radiant'.
     */
    public void setRadiant(final boolean radiant) {
        this.radiant = radiant;
        this.hasradiant = true;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled
     * org.chartacaeli.model.AnnotationStraight
     */
    public static org.chartacaeli.model.AnnotationStraight unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.chartacaeli.model.AnnotationStraight) org.exolab.castor.xml.Unmarshaller.unmarshal(org.chartacaeli.model.AnnotationStraight.class, reader);
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
