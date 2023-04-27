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
public class CatalogADC5109 extends org.chartacaeli.model.CatalogType 
implements java.io.Serializable
{

    /**
     * Composite chart parameter.
     */
    private java.util.Vector<org.chartacaeli.model.CatalogADC5109Record> catalogADC5109RecordList;

    public CatalogADC5109() {
        super();
        this.catalogADC5109RecordList = new java.util.Vector<org.chartacaeli.model.CatalogADC5109Record>();
    }

    /**
     * 
     * 
     * @param vCatalogADC5109Record
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCatalogADC5109Record(final org.chartacaeli.model.CatalogADC5109Record vCatalogADC5109Record) throws java.lang.IndexOutOfBoundsException {
        this.catalogADC5109RecordList.addElement(vCatalogADC5109Record);
    }

    /**
     * 
     * 
     * @param index
     * @param vCatalogADC5109Record
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCatalogADC5109Record(final int index,final org.chartacaeli.model.CatalogADC5109Record vCatalogADC5109Record) throws java.lang.IndexOutOfBoundsException {
        this.catalogADC5109RecordList.add(index, vCatalogADC5109Record);
    }

    /**
     * Method enumerateCatalogADC5109Record.
     * 
     * @return an Enumeration over all
     * org.chartacaeli.model.CatalogADC5109Record elements
     */
    public java.util.Enumeration<? extends org.chartacaeli.model.CatalogADC5109Record> enumerateCatalogADC5109Record() {
        return this.catalogADC5109RecordList.elements();
    }

    /**
     * Method getCatalogADC5109Record.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * org.chartacaeli.model.CatalogADC5109Record at the given index
     */
    public org.chartacaeli.model.CatalogADC5109Record getCatalogADC5109Record(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.catalogADC5109RecordList.size()) {
            throw new IndexOutOfBoundsException("getCatalogADC5109Record: Index value '" + index + "' not in range [0.." + (this.catalogADC5109RecordList.size() - 1) + "]");
        }

        return catalogADC5109RecordList.get(index);
    }

    /**
     * Method getCatalogADC5109Record.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.chartacaeli.model.CatalogADC5109Record[] getCatalogADC5109Record() {
        org.chartacaeli.model.CatalogADC5109Record[] array = new org.chartacaeli.model.CatalogADC5109Record[0];
        return this.catalogADC5109RecordList.toArray(array);
    }

    /**
     * Method getCatalogADC5109RecordCount.
     * 
     * @return the size of this collection
     */
    public int getCatalogADC5109RecordCount() {
        return this.catalogADC5109RecordList.size();
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
     */
    public void removeAllCatalogADC5109Record() {
        this.catalogADC5109RecordList.clear();
    }

    /**
     * Method removeCatalogADC5109Record.
     * 
     * @param vCatalogADC5109Record
     * @return true if the object was removed from the collection.
     */
    public boolean removeCatalogADC5109Record(final org.chartacaeli.model.CatalogADC5109Record vCatalogADC5109Record) {
        boolean removed = catalogADC5109RecordList.remove(vCatalogADC5109Record);
        return removed;
    }

    /**
     * Method removeCatalogADC5109RecordAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.chartacaeli.model.CatalogADC5109Record removeCatalogADC5109RecordAt(final int index) {
        java.lang.Object obj = this.catalogADC5109RecordList.remove(index);
        return (org.chartacaeli.model.CatalogADC5109Record) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vCatalogADC5109Record
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCatalogADC5109Record(final int index,final org.chartacaeli.model.CatalogADC5109Record vCatalogADC5109Record) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.catalogADC5109RecordList.size()) {
            throw new IndexOutOfBoundsException("setCatalogADC5109Record: Index value '" + index + "' not in range [0.." + (this.catalogADC5109RecordList.size() - 1) + "]");
        }

        this.catalogADC5109RecordList.set(index, vCatalogADC5109Record);
    }

    /**
     * 
     * 
     * @param vCatalogADC5109RecordArray
     */
    public void setCatalogADC5109Record(final org.chartacaeli.model.CatalogADC5109Record[] vCatalogADC5109RecordArray) {
        //-- copy array
        catalogADC5109RecordList.clear();

        for (int i = 0; i < vCatalogADC5109RecordArray.length; i++) {
                this.catalogADC5109RecordList.add(vCatalogADC5109RecordArray[i]);
        }
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled org.chartacaeli.model.CatalogADC5109
     */
    public static org.chartacaeli.model.CatalogADC5109 unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.chartacaeli.model.CatalogADC5109) org.exolab.castor.xml.Unmarshaller.unmarshal(org.chartacaeli.model.CatalogADC5109.class, reader);
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
