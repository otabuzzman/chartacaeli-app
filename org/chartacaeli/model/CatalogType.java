/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package org.chartacaeli.model;

/**
 * 
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public abstract class CatalogType extends org.chartacaeli.Peer 
implements java.io.Serializable
{

    /**
     * Discrete chart parameter.
     */
    private java.lang.String name;

    /**
     * Discrete chart parameter.
     */
    private java.lang.String url;

    /**
     * Composite chart parameter.
     */
    private java.util.Vector<org.chartacaeli.model.Artwork> artworkList;

    /**
     * Composite chart parameter.
     */
    private java.util.Vector<org.chartacaeli.model.Sign> signList;

    public CatalogType() {
        super();
        this.artworkList = new java.util.Vector<org.chartacaeli.model.Artwork>();
        this.signList = new java.util.Vector<org.chartacaeli.model.Sign>();
    }

    /**
     * 
     * 
     * @param vArtwork
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addArtwork(final org.chartacaeli.model.Artwork vArtwork) throws java.lang.IndexOutOfBoundsException {
        this.artworkList.addElement(vArtwork);
    }

    /**
     * 
     * 
     * @param index
     * @param vArtwork
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addArtwork(final int index,final org.chartacaeli.model.Artwork vArtwork) throws java.lang.IndexOutOfBoundsException {
        this.artworkList.add(index, vArtwork);
    }

    /**
     * 
     * 
     * @param vSign
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSign(final org.chartacaeli.model.Sign vSign) throws java.lang.IndexOutOfBoundsException {
        this.signList.addElement(vSign);
    }

    /**
     * 
     * 
     * @param index
     * @param vSign
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSign(final int index,final org.chartacaeli.model.Sign vSign) throws java.lang.IndexOutOfBoundsException {
        this.signList.add(index, vSign);
    }

    /**
     * Method enumerateArtwork.
     * 
     * @return an Enumeration over all
     * org.chartacaeli.model.Artwork elements
     */
    public java.util.Enumeration<? extends org.chartacaeli.model.Artwork> enumerateArtwork() {
        return this.artworkList.elements();
    }

    /**
     * Method enumerateSign.
     * 
     * @return an Enumeration over all org.chartacaeli.model.Sign
     * elements
     */
    public java.util.Enumeration<? extends org.chartacaeli.model.Sign> enumerateSign() {
        return this.signList.elements();
    }

    /**
     * Method getArtwork.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the org.chartacaeli.model.Artwork at
     * the given index
     */
    public org.chartacaeli.model.Artwork getArtwork(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.artworkList.size()) {
            throw new IndexOutOfBoundsException("getArtwork: Index value '" + index + "' not in range [0.." + (this.artworkList.size() - 1) + "]");
        }

        return artworkList.get(index);
    }

    /**
     * Method getArtwork.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.chartacaeli.model.Artwork[] getArtwork() {
        org.chartacaeli.model.Artwork[] array = new org.chartacaeli.model.Artwork[0];
        return this.artworkList.toArray(array);
    }

    /**
     * Method getArtworkCount.
     * 
     * @return the size of this collection
     */
    public int getArtworkCount() {
        return this.artworkList.size();
    }

    /**
     * Returns the value of field 'name'. The field 'name' has the
     * following description: Discrete chart parameter.
     * 
     * @return the value of field 'Name'.
     */
    public java.lang.String getName() {
        return this.name;
    }

    /**
     * Method getSign.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the org.chartacaeli.model.Sign at the
     * given index
     */
    public org.chartacaeli.model.Sign getSign(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.signList.size()) {
            throw new IndexOutOfBoundsException("getSign: Index value '" + index + "' not in range [0.." + (this.signList.size() - 1) + "]");
        }

        return signList.get(index);
    }

    /**
     * Method getSign.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.chartacaeli.model.Sign[] getSign() {
        org.chartacaeli.model.Sign[] array = new org.chartacaeli.model.Sign[0];
        return this.signList.toArray(array);
    }

    /**
     * Method getSignCount.
     * 
     * @return the size of this collection
     */
    public int getSignCount() {
        return this.signList.size();
    }

    /**
     * Returns the value of field 'url'. The field 'url' has the
     * following description: Discrete chart parameter.
     * 
     * @return the value of field 'Url'.
     */
    public java.lang.String getUrl() {
        return this.url;
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
     */
    public void removeAllArtwork() {
        this.artworkList.clear();
    }

    /**
     */
    public void removeAllSign() {
        this.signList.clear();
    }

    /**
     * Method removeArtwork.
     * 
     * @param vArtwork
     * @return true if the object was removed from the collection.
     */
    public boolean removeArtwork(final org.chartacaeli.model.Artwork vArtwork) {
        boolean removed = artworkList.remove(vArtwork);
        return removed;
    }

    /**
     * Method removeArtworkAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.chartacaeli.model.Artwork removeArtworkAt(final int index) {
        java.lang.Object obj = this.artworkList.remove(index);
        return (org.chartacaeli.model.Artwork) obj;
    }

    /**
     * Method removeSign.
     * 
     * @param vSign
     * @return true if the object was removed from the collection.
     */
    public boolean removeSign(final org.chartacaeli.model.Sign vSign) {
        boolean removed = signList.remove(vSign);
        return removed;
    }

    /**
     * Method removeSignAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.chartacaeli.model.Sign removeSignAt(final int index) {
        java.lang.Object obj = this.signList.remove(index);
        return (org.chartacaeli.model.Sign) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vArtwork
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setArtwork(final int index,final org.chartacaeli.model.Artwork vArtwork) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.artworkList.size()) {
            throw new IndexOutOfBoundsException("setArtwork: Index value '" + index + "' not in range [0.." + (this.artworkList.size() - 1) + "]");
        }

        this.artworkList.set(index, vArtwork);
    }

    /**
     * 
     * 
     * @param vArtworkArray
     */
    public void setArtwork(final org.chartacaeli.model.Artwork[] vArtworkArray) {
        //-- copy array
        artworkList.clear();

        for (int i = 0; i < vArtworkArray.length; i++) {
                this.artworkList.add(vArtworkArray[i]);
        }
    }

    /**
     * Sets the value of field 'name'. The field 'name' has the
     * following description: Discrete chart parameter.
     * 
     * @param name the value of field 'name'.
     */
    public void setName(final java.lang.String name) {
        this.name = name;
    }

    /**
     * 
     * 
     * @param index
     * @param vSign
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSign(final int index,final org.chartacaeli.model.Sign vSign) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.signList.size()) {
            throw new IndexOutOfBoundsException("setSign: Index value '" + index + "' not in range [0.." + (this.signList.size() - 1) + "]");
        }

        this.signList.set(index, vSign);
    }

    /**
     * 
     * 
     * @param vSignArray
     */
    public void setSign(final org.chartacaeli.model.Sign[] vSignArray) {
        //-- copy array
        signList.clear();

        for (int i = 0; i < vSignArray.length; i++) {
                this.signList.add(vSignArray[i]);
        }
    }

    /**
     * Sets the value of field 'url'. The field 'url' has the
     * following description: Discrete chart parameter.
     * 
     * @param url the value of field 'url'.
     */
    public void setUrl(final java.lang.String url) {
        this.url = url;
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
