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
public class CatalogADC5050 extends org.chartacaeli.model.CatalogType 
implements java.io.Serializable
{

    /**
     * Composite chart parameter.
     */
    private java.util.Vector<org.chartacaeli.model.CatalogADC5050Record> catalogADC5050RecordList;

    public CatalogADC5050() {
        super();
        this.catalogADC5050RecordList = new java.util.Vector<org.chartacaeli.model.CatalogADC5050Record>();
    }

    /**
     * 
     * 
     * @param vCatalogADC5050Record
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCatalogADC5050Record(final org.chartacaeli.model.CatalogADC5050Record vCatalogADC5050Record) throws java.lang.IndexOutOfBoundsException {
        this.catalogADC5050RecordList.addElement(vCatalogADC5050Record);
    }

    /**
     * 
     * 
     * @param index
     * @param vCatalogADC5050Record
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCatalogADC5050Record(final int index,final org.chartacaeli.model.CatalogADC5050Record vCatalogADC5050Record) throws java.lang.IndexOutOfBoundsException {
        this.catalogADC5050RecordList.add(index, vCatalogADC5050Record);
    }

    /**
     * Method enumerateCatalogADC5050Record.
     * 
     * @return an Enumeration over all
     * org.chartacaeli.model.CatalogADC5050Record elements
     */
    public java.util.Enumeration<? extends org.chartacaeli.model.CatalogADC5050Record> enumerateCatalogADC5050Record() {
        return this.catalogADC5050RecordList.elements();
    }

    /**
     * Method getCatalogADC5050Record.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * org.chartacaeli.model.CatalogADC5050Record at the given index
     */
    public org.chartacaeli.model.CatalogADC5050Record getCatalogADC5050Record(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.catalogADC5050RecordList.size()) {
            throw new IndexOutOfBoundsException("getCatalogADC5050Record: Index value '" + index + "' not in range [0.." + (this.catalogADC5050RecordList.size() - 1) + "]");
        }

        return catalogADC5050RecordList.get(index);
    }

    /**
     * Method getCatalogADC5050Record.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.chartacaeli.model.CatalogADC5050Record[] getCatalogADC5050Record() {
        org.chartacaeli.model.CatalogADC5050Record[] array = new org.chartacaeli.model.CatalogADC5050Record[0];
        return this.catalogADC5050RecordList.toArray(array);
    }

    /**
     * Method getCatalogADC5050RecordCount.
     * 
     * @return the size of this collection
     */
    public int getCatalogADC5050RecordCount() {
        return this.catalogADC5050RecordList.size();
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
    public void removeAllCatalogADC5050Record() {
        this.catalogADC5050RecordList.clear();
    }

    /**
     * Method removeCatalogADC5050Record.
     * 
     * @param vCatalogADC5050Record
     * @return true if the object was removed from the collection.
     */
    public boolean removeCatalogADC5050Record(final org.chartacaeli.model.CatalogADC5050Record vCatalogADC5050Record) {
        boolean removed = catalogADC5050RecordList.remove(vCatalogADC5050Record);
        return removed;
    }

    /**
     * Method removeCatalogADC5050RecordAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.chartacaeli.model.CatalogADC5050Record removeCatalogADC5050RecordAt(final int index) {
        java.lang.Object obj = this.catalogADC5050RecordList.remove(index);
        return (org.chartacaeli.model.CatalogADC5050Record) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vCatalogADC5050Record
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCatalogADC5050Record(final int index,final org.chartacaeli.model.CatalogADC5050Record vCatalogADC5050Record) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.catalogADC5050RecordList.size()) {
            throw new IndexOutOfBoundsException("setCatalogADC5050Record: Index value '" + index + "' not in range [0.." + (this.catalogADC5050RecordList.size() - 1) + "]");
        }

        this.catalogADC5050RecordList.set(index, vCatalogADC5050Record);
    }

    /**
     * 
     * 
     * @param vCatalogADC5050RecordArray
     */
    public void setCatalogADC5050Record(final org.chartacaeli.model.CatalogADC5050Record[] vCatalogADC5050RecordArray) {
        //-- copy array
        catalogADC5050RecordList.clear();

        for (int i = 0; i < vCatalogADC5050RecordArray.length; i++) {
                this.catalogADC5050RecordList.add(vCatalogADC5050RecordArray[i]);
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
     * @return the unmarshaled org.chartacaeli.model.CatalogADC5050
     */
    public static org.chartacaeli.model.CatalogADC5050 unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.chartacaeli.model.CatalogADC5050) org.exolab.castor.xml.Unmarshaller.unmarshal(org.chartacaeli.model.CatalogADC5050.class, reader);
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
