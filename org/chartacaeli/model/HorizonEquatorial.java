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
public class HorizonEquatorial extends org.chartacaeli.model.HorizonType 
implements java.io.Serializable
{

    /**
     * Chart feature class.
     */
    private java.util.Vector<org.chartacaeli.model.Catalog> catalogList;

    public HorizonEquatorial() {
        super();
        this.catalogList = new java.util.Vector<org.chartacaeli.model.Catalog>();
    }

    /**
     * 
     * 
     * @param vCatalog
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCatalog(final org.chartacaeli.model.Catalog vCatalog) throws java.lang.IndexOutOfBoundsException {
        this.catalogList.addElement(vCatalog);
    }

    /**
     * 
     * 
     * @param index
     * @param vCatalog
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCatalog(final int index,final org.chartacaeli.model.Catalog vCatalog) throws java.lang.IndexOutOfBoundsException {
        this.catalogList.add(index, vCatalog);
    }

    /**
     * Method enumerateCatalog.
     * 
     * @return an Enumeration over all
     * org.chartacaeli.model.Catalog elements
     */
    public java.util.Enumeration<? extends org.chartacaeli.model.Catalog> enumerateCatalog() {
        return this.catalogList.elements();
    }

    /**
     * Method getCatalog.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the org.chartacaeli.model.Catalog at
     * the given index
     */
    public org.chartacaeli.model.Catalog getCatalog(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.catalogList.size()) {
            throw new IndexOutOfBoundsException("getCatalog: Index value '" + index + "' not in range [0.." + (this.catalogList.size() - 1) + "]");
        }

        return catalogList.get(index);
    }

    /**
     * Method getCatalog.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.chartacaeli.model.Catalog[] getCatalog() {
        org.chartacaeli.model.Catalog[] array = new org.chartacaeli.model.Catalog[0];
        return this.catalogList.toArray(array);
    }

    /**
     * Method getCatalogCount.
     * 
     * @return the size of this collection
     */
    public int getCatalogCount() {
        return this.catalogList.size();
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
    public void removeAllCatalog() {
        this.catalogList.clear();
    }

    /**
     * Method removeCatalog.
     * 
     * @param vCatalog
     * @return true if the object was removed from the collection.
     */
    public boolean removeCatalog(final org.chartacaeli.model.Catalog vCatalog) {
        boolean removed = catalogList.remove(vCatalog);
        return removed;
    }

    /**
     * Method removeCatalogAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.chartacaeli.model.Catalog removeCatalogAt(final int index) {
        java.lang.Object obj = this.catalogList.remove(index);
        return (org.chartacaeli.model.Catalog) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vCatalog
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCatalog(final int index,final org.chartacaeli.model.Catalog vCatalog) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.catalogList.size()) {
            throw new IndexOutOfBoundsException("setCatalog: Index value '" + index + "' not in range [0.." + (this.catalogList.size() - 1) + "]");
        }

        this.catalogList.set(index, vCatalog);
    }

    /**
     * 
     * 
     * @param vCatalogArray
     */
    public void setCatalog(final org.chartacaeli.model.Catalog[] vCatalogArray) {
        //-- copy array
        catalogList.clear();

        for (int i = 0; i < vCatalogArray.length; i++) {
                this.catalogList.add(vCatalogArray[i]);
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
     * @return the unmarshaled
     * org.chartacaeli.model.HorizonEquatorial
     */
    public static org.chartacaeli.model.HorizonEquatorial unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.chartacaeli.model.HorizonEquatorial) org.exolab.castor.xml.Unmarshaller.unmarshal(org.chartacaeli.model.HorizonEquatorial.class, reader);
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
