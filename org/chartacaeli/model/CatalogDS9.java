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
public class CatalogDS9 extends org.chartacaeli.model.CatalogType 
implements java.io.Serializable
{

    /**
     * Composite chart parameter.
     */
    private java.util.Vector<org.chartacaeli.model.CatalogDS9Record> catalogDS9RecordList;

    public CatalogDS9() {
        super();
        this.catalogDS9RecordList = new java.util.Vector<org.chartacaeli.model.CatalogDS9Record>();
    }

    /**
     * 
     * 
     * @param vCatalogDS9Record
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCatalogDS9Record(final org.chartacaeli.model.CatalogDS9Record vCatalogDS9Record) throws java.lang.IndexOutOfBoundsException {
        this.catalogDS9RecordList.addElement(vCatalogDS9Record);
    }

    /**
     * 
     * 
     * @param index
     * @param vCatalogDS9Record
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCatalogDS9Record(final int index,final org.chartacaeli.model.CatalogDS9Record vCatalogDS9Record) throws java.lang.IndexOutOfBoundsException {
        this.catalogDS9RecordList.add(index, vCatalogDS9Record);
    }

    /**
     * Method enumerateCatalogDS9Record.
     * 
     * @return an Enumeration over all
     * org.chartacaeli.model.CatalogDS9Record elements
     */
    public java.util.Enumeration<? extends org.chartacaeli.model.CatalogDS9Record> enumerateCatalogDS9Record() {
        return this.catalogDS9RecordList.elements();
    }

    /**
     * Method getCatalogDS9Record.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * org.chartacaeli.model.CatalogDS9Record at the given index
     */
    public org.chartacaeli.model.CatalogDS9Record getCatalogDS9Record(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.catalogDS9RecordList.size()) {
            throw new IndexOutOfBoundsException("getCatalogDS9Record: Index value '" + index + "' not in range [0.." + (this.catalogDS9RecordList.size() - 1) + "]");
        }

        return catalogDS9RecordList.get(index);
    }

    /**
     * Method getCatalogDS9Record.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.chartacaeli.model.CatalogDS9Record[] getCatalogDS9Record() {
        org.chartacaeli.model.CatalogDS9Record[] array = new org.chartacaeli.model.CatalogDS9Record[0];
        return this.catalogDS9RecordList.toArray(array);
    }

    /**
     * Method getCatalogDS9RecordCount.
     * 
     * @return the size of this collection
     */
    public int getCatalogDS9RecordCount() {
        return this.catalogDS9RecordList.size();
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
    public void removeAllCatalogDS9Record() {
        this.catalogDS9RecordList.clear();
    }

    /**
     * Method removeCatalogDS9Record.
     * 
     * @param vCatalogDS9Record
     * @return true if the object was removed from the collection.
     */
    public boolean removeCatalogDS9Record(final org.chartacaeli.model.CatalogDS9Record vCatalogDS9Record) {
        boolean removed = catalogDS9RecordList.remove(vCatalogDS9Record);
        return removed;
    }

    /**
     * Method removeCatalogDS9RecordAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.chartacaeli.model.CatalogDS9Record removeCatalogDS9RecordAt(final int index) {
        java.lang.Object obj = this.catalogDS9RecordList.remove(index);
        return (org.chartacaeli.model.CatalogDS9Record) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vCatalogDS9Record
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCatalogDS9Record(final int index,final org.chartacaeli.model.CatalogDS9Record vCatalogDS9Record) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.catalogDS9RecordList.size()) {
            throw new IndexOutOfBoundsException("setCatalogDS9Record: Index value '" + index + "' not in range [0.." + (this.catalogDS9RecordList.size() - 1) + "]");
        }

        this.catalogDS9RecordList.set(index, vCatalogDS9Record);
    }

    /**
     * 
     * 
     * @param vCatalogDS9RecordArray
     */
    public void setCatalogDS9Record(final org.chartacaeli.model.CatalogDS9Record[] vCatalogDS9RecordArray) {
        //-- copy array
        catalogDS9RecordList.clear();

        for (int i = 0; i < vCatalogDS9RecordArray.length; i++) {
                this.catalogDS9RecordList.add(vCatalogDS9RecordArray[i]);
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
     * @return the unmarshaled org.chartacaeli.model.CatalogDS9
     */
    public static org.chartacaeli.model.CatalogDS9 unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.chartacaeli.model.CatalogDS9) org.exolab.castor.xml.Unmarshaller.unmarshal(org.chartacaeli.model.CatalogDS9.class, reader);
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
