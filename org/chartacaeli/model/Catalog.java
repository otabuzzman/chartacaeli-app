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
public class Catalog extends org.chartacaeli.Peer 
implements java.io.Serializable
{

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Chart feature element.
     */
    private org.chartacaeli.model.CatalogADC1239H catalogADC1239H;

    /**
     * Chart feature element.
     */
    private org.chartacaeli.model.CatalogADC1239T catalogADC1239T;

    /**
     * Chart feature element.
     */
    private org.chartacaeli.model.CatalogADC5050 catalogADC5050;

    /**
     * Chart feature element.
     */
    private org.chartacaeli.model.CatalogADC5109 catalogADC5109;

    /**
     * Chart feature element.
     */
    private org.chartacaeli.model.CatalogADC6049 catalogADC6049;

    /**
     * Chart feature element.
     */
    private org.chartacaeli.model.CatalogADC7118 catalogADC7118;

    /**
     * Chart feature element.
     */
    private org.chartacaeli.model.CatalogADC7237 catalogADC7237;

    /**
     * Chart feature element.
     */
    private org.chartacaeli.model.CatalogDS9 catalogDS9;

    public Catalog() {
        super();
    }

    /**
     * Returns the value of field 'catalogADC1239H'. The field
     * 'catalogADC1239H' has the following description: Chart
     * feature element.
     * 
     * @return the value of field 'CatalogADC1239H'.
     */
    public org.chartacaeli.model.CatalogADC1239H getCatalogADC1239H() {
        return this.catalogADC1239H;
    }

    /**
     * Returns the value of field 'catalogADC1239T'. The field
     * 'catalogADC1239T' has the following description: Chart
     * feature element.
     * 
     * @return the value of field 'CatalogADC1239T'.
     */
    public org.chartacaeli.model.CatalogADC1239T getCatalogADC1239T() {
        return this.catalogADC1239T;
    }

    /**
     * Returns the value of field 'catalogADC5050'. The field
     * 'catalogADC5050' has the following description: Chart
     * feature element.
     * 
     * @return the value of field 'CatalogADC5050'.
     */
    public org.chartacaeli.model.CatalogADC5050 getCatalogADC5050() {
        return this.catalogADC5050;
    }

    /**
     * Returns the value of field 'catalogADC5109'. The field
     * 'catalogADC5109' has the following description: Chart
     * feature element.
     * 
     * @return the value of field 'CatalogADC5109'.
     */
    public org.chartacaeli.model.CatalogADC5109 getCatalogADC5109() {
        return this.catalogADC5109;
    }

    /**
     * Returns the value of field 'catalogADC6049'. The field
     * 'catalogADC6049' has the following description: Chart
     * feature element.
     * 
     * @return the value of field 'CatalogADC6049'.
     */
    public org.chartacaeli.model.CatalogADC6049 getCatalogADC6049() {
        return this.catalogADC6049;
    }

    /**
     * Returns the value of field 'catalogADC7118'. The field
     * 'catalogADC7118' has the following description: Chart
     * feature element.
     * 
     * @return the value of field 'CatalogADC7118'.
     */
    public org.chartacaeli.model.CatalogADC7118 getCatalogADC7118() {
        return this.catalogADC7118;
    }

    /**
     * Returns the value of field 'catalogADC7237'. The field
     * 'catalogADC7237' has the following description: Chart
     * feature element.
     * 
     * @return the value of field 'CatalogADC7237'.
     */
    public org.chartacaeli.model.CatalogADC7237 getCatalogADC7237() {
        return this.catalogADC7237;
    }

    /**
     * Returns the value of field 'catalogDS9'. The field
     * 'catalogDS9' has the following description: Chart feature
     * element.
     * 
     * @return the value of field 'CatalogDS9'.
     */
    public org.chartacaeli.model.CatalogDS9 getCatalogDS9() {
        return this.catalogDS9;
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
     * Sets the value of field 'catalogADC1239H'. The field
     * 'catalogADC1239H' has the following description: Chart
     * feature element.
     * 
     * @param catalogADC1239H the value of field 'catalogADC1239H'.
     */
    public void setCatalogADC1239H(final org.chartacaeli.model.CatalogADC1239H catalogADC1239H) {
        this.catalogADC1239H = catalogADC1239H;
        this._choiceValue = catalogADC1239H;
    }

    /**
     * Sets the value of field 'catalogADC1239T'. The field
     * 'catalogADC1239T' has the following description: Chart
     * feature element.
     * 
     * @param catalogADC1239T the value of field 'catalogADC1239T'.
     */
    public void setCatalogADC1239T(final org.chartacaeli.model.CatalogADC1239T catalogADC1239T) {
        this.catalogADC1239T = catalogADC1239T;
        this._choiceValue = catalogADC1239T;
    }

    /**
     * Sets the value of field 'catalogADC5050'. The field
     * 'catalogADC5050' has the following description: Chart
     * feature element.
     * 
     * @param catalogADC5050 the value of field 'catalogADC5050'.
     */
    public void setCatalogADC5050(final org.chartacaeli.model.CatalogADC5050 catalogADC5050) {
        this.catalogADC5050 = catalogADC5050;
        this._choiceValue = catalogADC5050;
    }

    /**
     * Sets the value of field 'catalogADC5109'. The field
     * 'catalogADC5109' has the following description: Chart
     * feature element.
     * 
     * @param catalogADC5109 the value of field 'catalogADC5109'.
     */
    public void setCatalogADC5109(final org.chartacaeli.model.CatalogADC5109 catalogADC5109) {
        this.catalogADC5109 = catalogADC5109;
        this._choiceValue = catalogADC5109;
    }

    /**
     * Sets the value of field 'catalogADC6049'. The field
     * 'catalogADC6049' has the following description: Chart
     * feature element.
     * 
     * @param catalogADC6049 the value of field 'catalogADC6049'.
     */
    public void setCatalogADC6049(final org.chartacaeli.model.CatalogADC6049 catalogADC6049) {
        this.catalogADC6049 = catalogADC6049;
        this._choiceValue = catalogADC6049;
    }

    /**
     * Sets the value of field 'catalogADC7118'. The field
     * 'catalogADC7118' has the following description: Chart
     * feature element.
     * 
     * @param catalogADC7118 the value of field 'catalogADC7118'.
     */
    public void setCatalogADC7118(final org.chartacaeli.model.CatalogADC7118 catalogADC7118) {
        this.catalogADC7118 = catalogADC7118;
        this._choiceValue = catalogADC7118;
    }

    /**
     * Sets the value of field 'catalogADC7237'. The field
     * 'catalogADC7237' has the following description: Chart
     * feature element.
     * 
     * @param catalogADC7237 the value of field 'catalogADC7237'.
     */
    public void setCatalogADC7237(final org.chartacaeli.model.CatalogADC7237 catalogADC7237) {
        this.catalogADC7237 = catalogADC7237;
        this._choiceValue = catalogADC7237;
    }

    /**
     * Sets the value of field 'catalogDS9'. The field 'catalogDS9'
     * has the following description: Chart feature element.
     * 
     * @param catalogDS9 the value of field 'catalogDS9'.
     */
    public void setCatalogDS9(final org.chartacaeli.model.CatalogDS9 catalogDS9) {
        this.catalogDS9 = catalogDS9;
        this._choiceValue = catalogDS9;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled org.chartacaeli.model.Catalog
     */
    public static org.chartacaeli.model.Catalog unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.chartacaeli.model.Catalog) org.exolab.castor.xml.Unmarshaller.unmarshal(org.chartacaeli.model.Catalog.class, reader);
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
