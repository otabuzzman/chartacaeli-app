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
public class CatalogADC7237 extends org.chartacaeli.model.CatalogType 
implements java.io.Serializable
{

    /**
     * Composite chart parameter.
     */
    private java.util.Vector<org.chartacaeli.model.CatalogADC7237Record> catalogADC7237RecordList;

    public CatalogADC7237() {
        super();
        this.catalogADC7237RecordList = new java.util.Vector<org.chartacaeli.model.CatalogADC7237Record>();
    }

    /**
     * 
     * 
     * @param vCatalogADC7237Record
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCatalogADC7237Record(final org.chartacaeli.model.CatalogADC7237Record vCatalogADC7237Record) throws java.lang.IndexOutOfBoundsException {
        this.catalogADC7237RecordList.addElement(vCatalogADC7237Record);
    }

    /**
     * 
     * 
     * @param index
     * @param vCatalogADC7237Record
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCatalogADC7237Record(final int index,final org.chartacaeli.model.CatalogADC7237Record vCatalogADC7237Record) throws java.lang.IndexOutOfBoundsException {
        this.catalogADC7237RecordList.add(index, vCatalogADC7237Record);
    }

    /**
     * Method enumerateCatalogADC7237Record.
     * 
     * @return an Enumeration over all
     * org.chartacaeli.model.CatalogADC7237Record elements
     */
    public java.util.Enumeration<? extends org.chartacaeli.model.CatalogADC7237Record> enumerateCatalogADC7237Record() {
        return this.catalogADC7237RecordList.elements();
    }

    /**
     * Method getCatalogADC7237Record.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * org.chartacaeli.model.CatalogADC7237Record at the given index
     */
    public org.chartacaeli.model.CatalogADC7237Record getCatalogADC7237Record(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.catalogADC7237RecordList.size()) {
            throw new IndexOutOfBoundsException("getCatalogADC7237Record: Index value '" + index + "' not in range [0.." + (this.catalogADC7237RecordList.size() - 1) + "]");
        }

        return catalogADC7237RecordList.get(index);
    }

    /**
     * Method getCatalogADC7237Record.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.chartacaeli.model.CatalogADC7237Record[] getCatalogADC7237Record() {
        org.chartacaeli.model.CatalogADC7237Record[] array = new org.chartacaeli.model.CatalogADC7237Record[0];
        return this.catalogADC7237RecordList.toArray(array);
    }

    /**
     * Method getCatalogADC7237RecordCount.
     * 
     * @return the size of this collection
     */
    public int getCatalogADC7237RecordCount() {
        return this.catalogADC7237RecordList.size();
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
    public void removeAllCatalogADC7237Record() {
        this.catalogADC7237RecordList.clear();
    }

    /**
     * Method removeCatalogADC7237Record.
     * 
     * @param vCatalogADC7237Record
     * @return true if the object was removed from the collection.
     */
    public boolean removeCatalogADC7237Record(final org.chartacaeli.model.CatalogADC7237Record vCatalogADC7237Record) {
        boolean removed = catalogADC7237RecordList.remove(vCatalogADC7237Record);
        return removed;
    }

    /**
     * Method removeCatalogADC7237RecordAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.chartacaeli.model.CatalogADC7237Record removeCatalogADC7237RecordAt(final int index) {
        java.lang.Object obj = this.catalogADC7237RecordList.remove(index);
        return (org.chartacaeli.model.CatalogADC7237Record) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vCatalogADC7237Record
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCatalogADC7237Record(final int index,final org.chartacaeli.model.CatalogADC7237Record vCatalogADC7237Record) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.catalogADC7237RecordList.size()) {
            throw new IndexOutOfBoundsException("setCatalogADC7237Record: Index value '" + index + "' not in range [0.." + (this.catalogADC7237RecordList.size() - 1) + "]");
        }

        this.catalogADC7237RecordList.set(index, vCatalogADC7237Record);
    }

    /**
     * 
     * 
     * @param vCatalogADC7237RecordArray
     */
    public void setCatalogADC7237Record(final org.chartacaeli.model.CatalogADC7237Record[] vCatalogADC7237RecordArray) {
        //-- copy array
        catalogADC7237RecordList.clear();

        for (int i = 0; i < vCatalogADC7237RecordArray.length; i++) {
                this.catalogADC7237RecordList.add(vCatalogADC7237RecordArray[i]);
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
     * @return the unmarshaled org.chartacaeli.model.CatalogADC7237
     */
    public static org.chartacaeli.model.CatalogADC7237 unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.chartacaeli.model.CatalogADC7237) org.exolab.castor.xml.Unmarshaller.unmarshal(org.chartacaeli.model.CatalogADC7237.class, reader);
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
