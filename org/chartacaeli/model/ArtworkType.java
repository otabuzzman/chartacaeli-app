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
public abstract class ArtworkType extends org.chartacaeli.Peer 
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
    private java.util.Vector<org.chartacaeli.model.Popper> popperList;

    public ArtworkType() {
        super();
        this.popperList = new java.util.Vector<org.chartacaeli.model.Popper>();
    }

    /**
     * 
     * 
     * @param vPopper
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPopper(final org.chartacaeli.model.Popper vPopper) throws java.lang.IndexOutOfBoundsException {
        this.popperList.addElement(vPopper);
    }

    /**
     * 
     * 
     * @param index
     * @param vPopper
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPopper(final int index,final org.chartacaeli.model.Popper vPopper) throws java.lang.IndexOutOfBoundsException {
        this.popperList.add(index, vPopper);
    }

    /**
     * Method enumeratePopper.
     * 
     * @return an Enumeration over all org.chartacaeli.model.Popper
     * elements
     */
    public java.util.Enumeration<? extends org.chartacaeli.model.Popper> enumeratePopper() {
        return this.popperList.elements();
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
     * Method getPopper.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the org.chartacaeli.model.Popper at the
     * given index
     */
    public org.chartacaeli.model.Popper getPopper(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.popperList.size()) {
            throw new IndexOutOfBoundsException("getPopper: Index value '" + index + "' not in range [0.." + (this.popperList.size() - 1) + "]");
        }

        return popperList.get(index);
    }

    /**
     * Method getPopper.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.chartacaeli.model.Popper[] getPopper() {
        org.chartacaeli.model.Popper[] array = new org.chartacaeli.model.Popper[0];
        return this.popperList.toArray(array);
    }

    /**
     * Method getPopperCount.
     * 
     * @return the size of this collection
     */
    public int getPopperCount() {
        return this.popperList.size();
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
    public void removeAllPopper() {
        this.popperList.clear();
    }

    /**
     * Method removePopper.
     * 
     * @param vPopper
     * @return true if the object was removed from the collection.
     */
    public boolean removePopper(final org.chartacaeli.model.Popper vPopper) {
        boolean removed = popperList.remove(vPopper);
        return removed;
    }

    /**
     * Method removePopperAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.chartacaeli.model.Popper removePopperAt(final int index) {
        java.lang.Object obj = this.popperList.remove(index);
        return (org.chartacaeli.model.Popper) obj;
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
     * @param vPopper
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setPopper(final int index,final org.chartacaeli.model.Popper vPopper) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.popperList.size()) {
            throw new IndexOutOfBoundsException("setPopper: Index value '" + index + "' not in range [0.." + (this.popperList.size() - 1) + "]");
        }

        this.popperList.set(index, vPopper);
    }

    /**
     * 
     * 
     * @param vPopperArray
     */
    public void setPopper(final org.chartacaeli.model.Popper[] vPopperArray) {
        //-- copy array
        popperList.clear();

        for (int i = 0; i < vPopperArray.length; i++) {
                this.popperList.add(vPopperArray[i]);
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
