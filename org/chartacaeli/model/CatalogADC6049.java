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
public class CatalogADC6049 extends org.chartacaeli.model.CatalogType 
implements java.io.Serializable
{

    /**
     * Composite chart parameter.
     */
    private java.util.Vector<org.chartacaeli.model.CatalogADC6049Record> catalogADC6049RecordList;

    public CatalogADC6049() {
        super();
        this.catalogADC6049RecordList = new java.util.Vector<org.chartacaeli.model.CatalogADC6049Record>();
    }

    /**
     * 
     * 
     * @param vCatalogADC6049Record
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCatalogADC6049Record(final org.chartacaeli.model.CatalogADC6049Record vCatalogADC6049Record) throws java.lang.IndexOutOfBoundsException {
        this.catalogADC6049RecordList.addElement(vCatalogADC6049Record);
    }

    /**
     * 
     * 
     * @param index
     * @param vCatalogADC6049Record
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCatalogADC6049Record(final int index,final org.chartacaeli.model.CatalogADC6049Record vCatalogADC6049Record) throws java.lang.IndexOutOfBoundsException {
        this.catalogADC6049RecordList.add(index, vCatalogADC6049Record);
    }

    /**
     * Method enumerateCatalogADC6049Record.
     * 
     * @return an Enumeration over all
     * org.chartacaeli.model.CatalogADC6049Record elements
     */
    public java.util.Enumeration<? extends org.chartacaeli.model.CatalogADC6049Record> enumerateCatalogADC6049Record() {
        return this.catalogADC6049RecordList.elements();
    }

    /**
     * Method getCatalogADC6049Record.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * org.chartacaeli.model.CatalogADC6049Record at the given index
     */
    public org.chartacaeli.model.CatalogADC6049Record getCatalogADC6049Record(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.catalogADC6049RecordList.size()) {
            throw new IndexOutOfBoundsException("getCatalogADC6049Record: Index value '" + index + "' not in range [0.." + (this.catalogADC6049RecordList.size() - 1) + "]");
        }

        return catalogADC6049RecordList.get(index);
    }

    /**
     * Method getCatalogADC6049Record.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.chartacaeli.model.CatalogADC6049Record[] getCatalogADC6049Record() {
        org.chartacaeli.model.CatalogADC6049Record[] array = new org.chartacaeli.model.CatalogADC6049Record[0];
        return this.catalogADC6049RecordList.toArray(array);
    }

    /**
     * Method getCatalogADC6049RecordCount.
     * 
     * @return the size of this collection
     */
    public int getCatalogADC6049RecordCount() {
        return this.catalogADC6049RecordList.size();
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
    public void removeAllCatalogADC6049Record() {
        this.catalogADC6049RecordList.clear();
    }

    /**
     * Method removeCatalogADC6049Record.
     * 
     * @param vCatalogADC6049Record
     * @return true if the object was removed from the collection.
     */
    public boolean removeCatalogADC6049Record(final org.chartacaeli.model.CatalogADC6049Record vCatalogADC6049Record) {
        boolean removed = catalogADC6049RecordList.remove(vCatalogADC6049Record);
        return removed;
    }

    /**
     * Method removeCatalogADC6049RecordAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.chartacaeli.model.CatalogADC6049Record removeCatalogADC6049RecordAt(final int index) {
        java.lang.Object obj = this.catalogADC6049RecordList.remove(index);
        return (org.chartacaeli.model.CatalogADC6049Record) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vCatalogADC6049Record
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCatalogADC6049Record(final int index,final org.chartacaeli.model.CatalogADC6049Record vCatalogADC6049Record) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.catalogADC6049RecordList.size()) {
            throw new IndexOutOfBoundsException("setCatalogADC6049Record: Index value '" + index + "' not in range [0.." + (this.catalogADC6049RecordList.size() - 1) + "]");
        }

        this.catalogADC6049RecordList.set(index, vCatalogADC6049Record);
    }

    /**
     * 
     * 
     * @param vCatalogADC6049RecordArray
     */
    public void setCatalogADC6049Record(final org.chartacaeli.model.CatalogADC6049Record[] vCatalogADC6049RecordArray) {
        //-- copy array
        catalogADC6049RecordList.clear();

        for (int i = 0; i < vCatalogADC6049RecordArray.length; i++) {
                this.catalogADC6049RecordList.add(vCatalogADC6049RecordArray[i]);
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
     * @return the unmarshaled org.chartacaeli.model.CatalogADC6049
     */
    public static org.chartacaeli.model.CatalogADC6049 unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.chartacaeli.model.CatalogADC6049) org.exolab.castor.xml.Unmarshaller.unmarshal(org.chartacaeli.model.CatalogADC6049.class, reader);
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
