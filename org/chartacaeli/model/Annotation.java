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
public class Annotation extends org.chartacaeli.Peer 
implements java.io.Serializable
{

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Chart feature element.
     */
    private org.chartacaeli.model.AnnotationStraight annotationStraight;

    /**
     * Chart feature element.
     */
    private org.chartacaeli.model.AnnotationCurved annotationCurved;

    public Annotation() {
        super();
    }

    /**
     * Returns the value of field 'annotationCurved'. The field
     * 'annotationCurved' has the following description: Chart
     * feature element.
     * 
     * @return the value of field 'AnnotationCurved'.
     */
    public org.chartacaeli.model.AnnotationCurved getAnnotationCurved() {
        return this.annotationCurved;
    }

    /**
     * Returns the value of field 'annotationStraight'. The field
     * 'annotationStraight' has the following description: Chart
     * feature element.
     * 
     * @return the value of field 'AnnotationStraight'.
     */
    public org.chartacaeli.model.AnnotationStraight getAnnotationStraight() {
        return this.annotationStraight;
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
     * Sets the value of field 'annotationCurved'. The field
     * 'annotationCurved' has the following description: Chart
     * feature element.
     * 
     * @param annotationCurved the value of field 'annotationCurved'
     */
    public void setAnnotationCurved(final org.chartacaeli.model.AnnotationCurved annotationCurved) {
        this.annotationCurved = annotationCurved;
        this._choiceValue = annotationCurved;
    }

    /**
     * Sets the value of field 'annotationStraight'. The field
     * 'annotationStraight' has the following description: Chart
     * feature element.
     * 
     * @param annotationStraight the value of field
     * 'annotationStraight'.
     */
    public void setAnnotationStraight(final org.chartacaeli.model.AnnotationStraight annotationStraight) {
        this.annotationStraight = annotationStraight;
        this._choiceValue = annotationStraight;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled org.chartacaeli.model.Annotation
     */
    public static org.chartacaeli.model.Annotation unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.chartacaeli.model.Annotation) org.exolab.castor.xml.Unmarshaller.unmarshal(org.chartacaeli.model.Annotation.class, reader);
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
