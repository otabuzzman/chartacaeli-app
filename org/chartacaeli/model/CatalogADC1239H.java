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
public class CatalogADC1239H extends org.chartacaeli.model.CatalogType 
implements java.io.Serializable
{

    /**
     * Composite chart parameter.
     */
    private java.util.Vector<org.chartacaeli.model.CatalogADC1239HRecord> catalogADC1239HRecordList;

    public CatalogADC1239H() {
        super();
        this.catalogADC1239HRecordList = new java.util.Vector<org.chartacaeli.model.CatalogADC1239HRecord>();
    }

    /**
     * 
     * 
     * @param vCatalogADC1239HRecord
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCatalogADC1239HRecord(final org.chartacaeli.model.CatalogADC1239HRecord vCatalogADC1239HRecord) throws java.lang.IndexOutOfBoundsException {
        this.catalogADC1239HRecordList.addElement(vCatalogADC1239HRecord);
    }

    /**
     * 
     * 
     * @param index
     * @param vCatalogADC1239HRecord
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCatalogADC1239HRecord(final int index,final org.chartacaeli.model.CatalogADC1239HRecord vCatalogADC1239HRecord) throws java.lang.IndexOutOfBoundsException {
        this.catalogADC1239HRecordList.add(index, vCatalogADC1239HRecord);
    }

    /**
     * Method enumerateCatalogADC1239HRecord.
     * 
     * @return an Enumeration over all
     * org.chartacaeli.model.CatalogADC1239HRecord elements
     */
    public java.util.Enumeration<? extends org.chartacaeli.model.CatalogADC1239HRecord> enumerateCatalogADC1239HRecord() {
        return this.catalogADC1239HRecordList.elements();
    }

    /**
     * Method getCatalogADC1239HRecord.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * org.chartacaeli.model.CatalogADC1239HRecord at the given inde
     */
    public org.chartacaeli.model.CatalogADC1239HRecord getCatalogADC1239HRecord(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.catalogADC1239HRecordList.size()) {
            throw new IndexOutOfBoundsException("getCatalogADC1239HRecord: Index value '" + index + "' not in range [0.." + (this.catalogADC1239HRecordList.size() - 1) + "]");
        }

        return catalogADC1239HRecordList.get(index);
    }

    /**
     * Method getCatalogADC1239HRecord.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.chartacaeli.model.CatalogADC1239HRecord[] getCatalogADC1239HRecord() {
        org.chartacaeli.model.CatalogADC1239HRecord[] array = new org.chartacaeli.model.CatalogADC1239HRecord[0];
        return this.catalogADC1239HRecordList.toArray(array);
    }

    /**
     * Method getCatalogADC1239HRecordCount.
     * 
     * @return the size of this collection
     */
    public int getCatalogADC1239HRecordCount() {
        return this.catalogADC1239HRecordList.size();
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
    public void removeAllCatalogADC1239HRecord() {
        this.catalogADC1239HRecordList.clear();
    }

    /**
     * Method removeCatalogADC1239HRecord.
     * 
     * @param vCatalogADC1239HRecord
     * @return true if the object was removed from the collection.
     */
    public boolean removeCatalogADC1239HRecord(final org.chartacaeli.model.CatalogADC1239HRecord vCatalogADC1239HRecord) {
        boolean removed = catalogADC1239HRecordList.remove(vCatalogADC1239HRecord);
        return removed;
    }

    /**
     * Method removeCatalogADC1239HRecordAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.chartacaeli.model.CatalogADC1239HRecord removeCatalogADC1239HRecordAt(final int index) {
        java.lang.Object obj = this.catalogADC1239HRecordList.remove(index);
        return (org.chartacaeli.model.CatalogADC1239HRecord) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vCatalogADC1239HRecord
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCatalogADC1239HRecord(final int index,final org.chartacaeli.model.CatalogADC1239HRecord vCatalogADC1239HRecord) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.catalogADC1239HRecordList.size()) {
            throw new IndexOutOfBoundsException("setCatalogADC1239HRecord: Index value '" + index + "' not in range [0.." + (this.catalogADC1239HRecordList.size() - 1) + "]");
        }

        this.catalogADC1239HRecordList.set(index, vCatalogADC1239HRecord);
    }

    /**
     * 
     * 
     * @param vCatalogADC1239HRecordArray
     */
    public void setCatalogADC1239HRecord(final org.chartacaeli.model.CatalogADC1239HRecord[] vCatalogADC1239HRecordArray) {
        //-- copy array
        catalogADC1239HRecordList.clear();

        for (int i = 0; i < vCatalogADC1239HRecordArray.length; i++) {
                this.catalogADC1239HRecordList.add(vCatalogADC1239HRecordArray[i]);
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
     * @return the unmarshaled org.chartacaeli.model.CatalogADC1239H
     */
    public static org.chartacaeli.model.CatalogADC1239H unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.chartacaeli.model.CatalogADC1239H) org.exolab.castor.xml.Unmarshaller.unmarshal(org.chartacaeli.model.CatalogADC1239H.class, reader);
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
