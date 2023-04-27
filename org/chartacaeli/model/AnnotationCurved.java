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
public class AnnotationCurved extends org.chartacaeli.model.AnnotationType 
implements java.io.Serializable
{

    /**
     * Discrete chart parameter.
     */
    private double distance;

    /**
     * Keeps track of whether primitive field distance has been set
     * already.
     */
    private boolean hasdistance;

    public AnnotationCurved() {
        super();
    }

    /**
     */
    public void deleteDistance() {
        this.hasdistance= false;
    }

    /**
     * Returns the value of field 'distance'. The field 'distance'
     * has the following description: Discrete chart parameter.
     * 
     * @return the value of field 'Distance'.
     */
    public double getDistance() {
        return this.distance;
    }

    /**
     * Method hasDistance.
     * 
     * @return true if at least one Distance has been added
     */
    public boolean hasDistance() {
        return this.hasdistance;
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
     * Sets the value of field 'distance'. The field 'distance' has
     * the following description: Discrete chart parameter.
     * 
     * @param distance the value of field 'distance'.
     */
    public void setDistance(final double distance) {
        this.distance = distance;
        this.hasdistance = true;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled org.chartacaeli.model.AnnotationCurve
     */
    public static org.chartacaeli.model.AnnotationCurved unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.chartacaeli.model.AnnotationCurved) org.exolab.castor.xml.Unmarshaller.unmarshal(org.chartacaeli.model.AnnotationCurved.class, reader);
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
