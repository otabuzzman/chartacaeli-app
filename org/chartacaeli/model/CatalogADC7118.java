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
public class CatalogADC7118 extends org.chartacaeli.model.CatalogType 
implements java.io.Serializable
{

    /**
     * Discrete chart parameter.
     */
    private java.lang.String index;

    /**
     * Composite chart parameter.
     */
    private java.util.Vector<org.chartacaeli.model.CatalogADC7118Record> catalogADC7118RecordList;

    public CatalogADC7118() {
        super();
        this.catalogADC7118RecordList = new java.util.Vector<org.chartacaeli.model.CatalogADC7118Record>();
    }

    /**
     * 
     * 
     * @param vCatalogADC7118Record
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCatalogADC7118Record(final org.chartacaeli.model.CatalogADC7118Record vCatalogADC7118Record) throws java.lang.IndexOutOfBoundsException {
        this.catalogADC7118RecordList.addElement(vCatalogADC7118Record);
    }

    /**
     * 
     * 
     * @param index
     * @param vCatalogADC7118Record
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCatalogADC7118Record(final int index,final org.chartacaeli.model.CatalogADC7118Record vCatalogADC7118Record) throws java.lang.IndexOutOfBoundsException {
        this.catalogADC7118RecordList.add(index, vCatalogADC7118Record);
    }

    /**
     * Method enumerateCatalogADC7118Record.
     * 
     * @return an Enumeration over all
     * org.chartacaeli.model.CatalogADC7118Record elements
     */
    public java.util.Enumeration<? extends org.chartacaeli.model.CatalogADC7118Record> enumerateCatalogADC7118Record() {
        return this.catalogADC7118RecordList.elements();
    }

    /**
     * Method getCatalogADC7118Record.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * org.chartacaeli.model.CatalogADC7118Record at the given index
     */
    public org.chartacaeli.model.CatalogADC7118Record getCatalogADC7118Record(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.catalogADC7118RecordList.size()) {
            throw new IndexOutOfBoundsException("getCatalogADC7118Record: Index value '" + index + "' not in range [0.." + (this.catalogADC7118RecordList.size() - 1) + "]");
        }

        return catalogADC7118RecordList.get(index);
    }

    /**
     * Method getCatalogADC7118Record.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.chartacaeli.model.CatalogADC7118Record[] getCatalogADC7118Record() {
        org.chartacaeli.model.CatalogADC7118Record[] array = new org.chartacaeli.model.CatalogADC7118Record[0];
        return this.catalogADC7118RecordList.toArray(array);
    }

    /**
     * Method getCatalogADC7118RecordCount.
     * 
     * @return the size of this collection
     */
    public int getCatalogADC7118RecordCount() {
        return this.catalogADC7118RecordList.size();
    }

    /**
     * Returns the value of field 'index'. The field 'index' has
     * the following description: Discrete chart parameter.
     * 
     * @return the value of field 'Index'.
     */
    public java.lang.String getIndex() {
        return this.index;
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
    public void removeAllCatalogADC7118Record() {
        this.catalogADC7118RecordList.clear();
    }

    /**
     * Method removeCatalogADC7118Record.
     * 
     * @param vCatalogADC7118Record
     * @return true if the object was removed from the collection.
     */
    public boolean removeCatalogADC7118Record(final org.chartacaeli.model.CatalogADC7118Record vCatalogADC7118Record) {
        boolean removed = catalogADC7118RecordList.remove(vCatalogADC7118Record);
        return removed;
    }

    /**
     * Method removeCatalogADC7118RecordAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.chartacaeli.model.CatalogADC7118Record removeCatalogADC7118RecordAt(final int index) {
        java.lang.Object obj = this.catalogADC7118RecordList.remove(index);
        return (org.chartacaeli.model.CatalogADC7118Record) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vCatalogADC7118Record
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCatalogADC7118Record(final int index,final org.chartacaeli.model.CatalogADC7118Record vCatalogADC7118Record) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.catalogADC7118RecordList.size()) {
            throw new IndexOutOfBoundsException("setCatalogADC7118Record: Index value '" + index + "' not in range [0.." + (this.catalogADC7118RecordList.size() - 1) + "]");
        }

        this.catalogADC7118RecordList.set(index, vCatalogADC7118Record);
    }

    /**
     * 
     * 
     * @param vCatalogADC7118RecordArray
     */
    public void setCatalogADC7118Record(final org.chartacaeli.model.CatalogADC7118Record[] vCatalogADC7118RecordArray) {
        //-- copy array
        catalogADC7118RecordList.clear();

        for (int i = 0; i < vCatalogADC7118RecordArray.length; i++) {
                this.catalogADC7118RecordList.add(vCatalogADC7118RecordArray[i]);
        }
    }

    /**
     * Sets the value of field 'index'. The field 'index' has the
     * following description: Discrete chart parameter.
     * 
     * @param index the value of field 'index'.
     */
    public void setIndex(final java.lang.String index) {
        this.index = index;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled org.chartacaeli.model.CatalogADC7118
     */
    public static org.chartacaeli.model.CatalogADC7118 unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.chartacaeli.model.CatalogADC7118) org.exolab.castor.xml.Unmarshaller.unmarshal(org.chartacaeli.model.CatalogADC7118.class, reader);
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
