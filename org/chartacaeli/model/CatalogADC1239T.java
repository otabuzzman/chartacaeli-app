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
public class CatalogADC1239T extends org.chartacaeli.model.CatalogType 
implements java.io.Serializable
{

    /**
     * Composite chart parameter.
     */
    private java.util.Vector<org.chartacaeli.model.CatalogADC1239TRecord> catalogADC1239TRecordList;

    public CatalogADC1239T() {
        super();
        this.catalogADC1239TRecordList = new java.util.Vector<org.chartacaeli.model.CatalogADC1239TRecord>();
    }

    /**
     * 
     * 
     * @param vCatalogADC1239TRecord
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCatalogADC1239TRecord(final org.chartacaeli.model.CatalogADC1239TRecord vCatalogADC1239TRecord) throws java.lang.IndexOutOfBoundsException {
        this.catalogADC1239TRecordList.addElement(vCatalogADC1239TRecord);
    }

    /**
     * 
     * 
     * @param index
     * @param vCatalogADC1239TRecord
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCatalogADC1239TRecord(final int index,final org.chartacaeli.model.CatalogADC1239TRecord vCatalogADC1239TRecord) throws java.lang.IndexOutOfBoundsException {
        this.catalogADC1239TRecordList.add(index, vCatalogADC1239TRecord);
    }

    /**
     * Method enumerateCatalogADC1239TRecord.
     * 
     * @return an Enumeration over all
     * org.chartacaeli.model.CatalogADC1239TRecord elements
     */
    public java.util.Enumeration<? extends org.chartacaeli.model.CatalogADC1239TRecord> enumerateCatalogADC1239TRecord() {
        return this.catalogADC1239TRecordList.elements();
    }

    /**
     * Method getCatalogADC1239TRecord.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * org.chartacaeli.model.CatalogADC1239TRecord at the given inde
     */
    public org.chartacaeli.model.CatalogADC1239TRecord getCatalogADC1239TRecord(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.catalogADC1239TRecordList.size()) {
            throw new IndexOutOfBoundsException("getCatalogADC1239TRecord: Index value '" + index + "' not in range [0.." + (this.catalogADC1239TRecordList.size() - 1) + "]");
        }

        return catalogADC1239TRecordList.get(index);
    }

    /**
     * Method getCatalogADC1239TRecord.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.chartacaeli.model.CatalogADC1239TRecord[] getCatalogADC1239TRecord() {
        org.chartacaeli.model.CatalogADC1239TRecord[] array = new org.chartacaeli.model.CatalogADC1239TRecord[0];
        return this.catalogADC1239TRecordList.toArray(array);
    }

    /**
     * Method getCatalogADC1239TRecordCount.
     * 
     * @return the size of this collection
     */
    public int getCatalogADC1239TRecordCount() {
        return this.catalogADC1239TRecordList.size();
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
    public void removeAllCatalogADC1239TRecord() {
        this.catalogADC1239TRecordList.clear();
    }

    /**
     * Method removeCatalogADC1239TRecord.
     * 
     * @param vCatalogADC1239TRecord
     * @return true if the object was removed from the collection.
     */
    public boolean removeCatalogADC1239TRecord(final org.chartacaeli.model.CatalogADC1239TRecord vCatalogADC1239TRecord) {
        boolean removed = catalogADC1239TRecordList.remove(vCatalogADC1239TRecord);
        return removed;
    }

    /**
     * Method removeCatalogADC1239TRecordAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.chartacaeli.model.CatalogADC1239TRecord removeCatalogADC1239TRecordAt(final int index) {
        java.lang.Object obj = this.catalogADC1239TRecordList.remove(index);
        return (org.chartacaeli.model.CatalogADC1239TRecord) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vCatalogADC1239TRecord
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCatalogADC1239TRecord(final int index,final org.chartacaeli.model.CatalogADC1239TRecord vCatalogADC1239TRecord) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.catalogADC1239TRecordList.size()) {
            throw new IndexOutOfBoundsException("setCatalogADC1239TRecord: Index value '" + index + "' not in range [0.." + (this.catalogADC1239TRecordList.size() - 1) + "]");
        }

        this.catalogADC1239TRecordList.set(index, vCatalogADC1239TRecord);
    }

    /**
     * 
     * 
     * @param vCatalogADC1239TRecordArray
     */
    public void setCatalogADC1239TRecord(final org.chartacaeli.model.CatalogADC1239TRecord[] vCatalogADC1239TRecordArray) {
        //-- copy array
        catalogADC1239TRecordList.clear();

        for (int i = 0; i < vCatalogADC1239TRecordArray.length; i++) {
                this.catalogADC1239TRecordList.add(vCatalogADC1239TRecordArray[i]);
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
     * @return the unmarshaled org.chartacaeli.model.CatalogADC1239T
     */
    public static org.chartacaeli.model.CatalogADC1239T unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.chartacaeli.model.CatalogADC1239T) org.exolab.castor.xml.Unmarshaller.unmarshal(org.chartacaeli.model.CatalogADC1239T.class, reader);
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
