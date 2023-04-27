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
public class Horizon extends org.chartacaeli.Peer 
implements java.io.Serializable
{

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Chart feature element.
     */
    private org.chartacaeli.model.HorizonEquatorial horizonEquatorial;

    /**
     * Chart feature element.
     */
    private org.chartacaeli.model.HorizonLocal horizonLocal;

    /**
     * Chart feature element.
     */
    private org.chartacaeli.model.HorizonEcliptical horizonEcliptical;

    /**
     * Chart feature element.
     */
    private org.chartacaeli.model.HorizonGalactic horizonGalactic;

    public Horizon() {
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
     * Returns the value of field 'horizonEcliptical'. The field
     * 'horizonEcliptical' has the following description: Chart
     * feature element.
     * 
     * @return the value of field 'HorizonEcliptical'.
     */
    public org.chartacaeli.model.HorizonEcliptical getHorizonEcliptical() {
        return this.horizonEcliptical;
    }

    /**
     * Returns the value of field 'horizonEquatorial'. The field
     * 'horizonEquatorial' has the following description: Chart
     * feature element.
     * 
     * @return the value of field 'HorizonEquatorial'.
     */
    public org.chartacaeli.model.HorizonEquatorial getHorizonEquatorial() {
        return this.horizonEquatorial;
    }

    /**
     * Returns the value of field 'horizonGalactic'. The field
     * 'horizonGalactic' has the following description: Chart
     * feature element.
     * 
     * @return the value of field 'HorizonGalactic'.
     */
    public org.chartacaeli.model.HorizonGalactic getHorizonGalactic() {
        return this.horizonGalactic;
    }

    /**
     * Returns the value of field 'horizonLocal'. The field
     * 'horizonLocal' has the following description: Chart feature
     * element.
     * 
     * @return the value of field 'HorizonLocal'.
     */
    public org.chartacaeli.model.HorizonLocal getHorizonLocal() {
        return this.horizonLocal;
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
     * Sets the value of field 'horizonEcliptical'. The field
     * 'horizonEcliptical' has the following description: Chart
     * feature element.
     * 
     * @param horizonEcliptical the value of field
     * 'horizonEcliptical'.
     */
    public void setHorizonEcliptical(final org.chartacaeli.model.HorizonEcliptical horizonEcliptical) {
        this.horizonEcliptical = horizonEcliptical;
        this._choiceValue = horizonEcliptical;
    }

    /**
     * Sets the value of field 'horizonEquatorial'. The field
     * 'horizonEquatorial' has the following description: Chart
     * feature element.
     * 
     * @param horizonEquatorial the value of field
     * 'horizonEquatorial'.
     */
    public void setHorizonEquatorial(final org.chartacaeli.model.HorizonEquatorial horizonEquatorial) {
        this.horizonEquatorial = horizonEquatorial;
        this._choiceValue = horizonEquatorial;
    }

    /**
     * Sets the value of field 'horizonGalactic'. The field
     * 'horizonGalactic' has the following description: Chart
     * feature element.
     * 
     * @param horizonGalactic the value of field 'horizonGalactic'.
     */
    public void setHorizonGalactic(final org.chartacaeli.model.HorizonGalactic horizonGalactic) {
        this.horizonGalactic = horizonGalactic;
        this._choiceValue = horizonGalactic;
    }

    /**
     * Sets the value of field 'horizonLocal'. The field
     * 'horizonLocal' has the following description: Chart feature
     * element.
     * 
     * @param horizonLocal the value of field 'horizonLocal'.
     */
    public void setHorizonLocal(final org.chartacaeli.model.HorizonLocal horizonLocal) {
        this.horizonLocal = horizonLocal;
        this._choiceValue = horizonLocal;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled org.chartacaeli.model.Horizon
     */
    public static org.chartacaeli.model.Horizon unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.chartacaeli.model.Horizon) org.exolab.castor.xml.Unmarshaller.unmarshal(org.chartacaeli.model.Horizon.class, reader);
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
