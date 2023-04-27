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
public abstract class TextType extends org.chartacaeli.Peer 
implements java.io.Serializable
{

    /**
     * Discrete chart parameter.
     */
    private java.lang.String name;

    /**
     * Discrete chart parameter.
     */
    private java.lang.String value;

    /**
     * Composite chart parameter.
     */
    private java.util.Vector<org.chartacaeli.model.Superscript> superscriptList;

    /**
     * Composite chart parameter.
     */
    private java.util.Vector<org.chartacaeli.model.Subscript> subscriptList;

    public TextType() {
        super();
        this.superscriptList = new java.util.Vector<org.chartacaeli.model.Superscript>();
        this.subscriptList = new java.util.Vector<org.chartacaeli.model.Subscript>();
    }

    /**
     * 
     * 
     * @param vSubscript
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSubscript(final org.chartacaeli.model.Subscript vSubscript) throws java.lang.IndexOutOfBoundsException {
        this.subscriptList.addElement(vSubscript);
    }

    /**
     * 
     * 
     * @param index
     * @param vSubscript
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSubscript(final int index,final org.chartacaeli.model.Subscript vSubscript) throws java.lang.IndexOutOfBoundsException {
        this.subscriptList.add(index, vSubscript);
    }

    /**
     * 
     * 
     * @param vSuperscript
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSuperscript(final org.chartacaeli.model.Superscript vSuperscript) throws java.lang.IndexOutOfBoundsException {
        this.superscriptList.addElement(vSuperscript);
    }

    /**
     * 
     * 
     * @param index
     * @param vSuperscript
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSuperscript(final int index,final org.chartacaeli.model.Superscript vSuperscript) throws java.lang.IndexOutOfBoundsException {
        this.superscriptList.add(index, vSuperscript);
    }

    /**
     * Method enumerateSubscript.
     * 
     * @return an Enumeration over all
     * org.chartacaeli.model.Subscript elements
     */
    public java.util.Enumeration<? extends org.chartacaeli.model.Subscript> enumerateSubscript() {
        return this.subscriptList.elements();
    }

    /**
     * Method enumerateSuperscript.
     * 
     * @return an Enumeration over all
     * org.chartacaeli.model.Superscript elements
     */
    public java.util.Enumeration<? extends org.chartacaeli.model.Superscript> enumerateSuperscript() {
        return this.superscriptList.elements();
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
     * Method getSubscript.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the org.chartacaeli.model.Subscript at
     * the given index
     */
    public org.chartacaeli.model.Subscript getSubscript(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.subscriptList.size()) {
            throw new IndexOutOfBoundsException("getSubscript: Index value '" + index + "' not in range [0.." + (this.subscriptList.size() - 1) + "]");
        }

        return subscriptList.get(index);
    }

    /**
     * Method getSubscript.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.chartacaeli.model.Subscript[] getSubscript() {
        org.chartacaeli.model.Subscript[] array = new org.chartacaeli.model.Subscript[0];
        return this.subscriptList.toArray(array);
    }

    /**
     * Method getSubscriptCount.
     * 
     * @return the size of this collection
     */
    public int getSubscriptCount() {
        return this.subscriptList.size();
    }

    /**
     * Method getSuperscript.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the org.chartacaeli.model.Superscript
     * at the given index
     */
    public org.chartacaeli.model.Superscript getSuperscript(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.superscriptList.size()) {
            throw new IndexOutOfBoundsException("getSuperscript: Index value '" + index + "' not in range [0.." + (this.superscriptList.size() - 1) + "]");
        }

        return superscriptList.get(index);
    }

    /**
     * Method getSuperscript.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.chartacaeli.model.Superscript[] getSuperscript() {
        org.chartacaeli.model.Superscript[] array = new org.chartacaeli.model.Superscript[0];
        return this.superscriptList.toArray(array);
    }

    /**
     * Method getSuperscriptCount.
     * 
     * @return the size of this collection
     */
    public int getSuperscriptCount() {
        return this.superscriptList.size();
    }

    /**
     * Returns the value of field 'value'. The field 'value' has
     * the following description: Discrete chart parameter.
     * 
     * @return the value of field 'Value'.
     */
    public java.lang.String getValue() {
        return this.value;
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
    public void removeAllSubscript() {
        this.subscriptList.clear();
    }

    /**
     */
    public void removeAllSuperscript() {
        this.superscriptList.clear();
    }

    /**
     * Method removeSubscript.
     * 
     * @param vSubscript
     * @return true if the object was removed from the collection.
     */
    public boolean removeSubscript(final org.chartacaeli.model.Subscript vSubscript) {
        boolean removed = subscriptList.remove(vSubscript);
        return removed;
    }

    /**
     * Method removeSubscriptAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.chartacaeli.model.Subscript removeSubscriptAt(final int index) {
        java.lang.Object obj = this.subscriptList.remove(index);
        return (org.chartacaeli.model.Subscript) obj;
    }

    /**
     * Method removeSuperscript.
     * 
     * @param vSuperscript
     * @return true if the object was removed from the collection.
     */
    public boolean removeSuperscript(final org.chartacaeli.model.Superscript vSuperscript) {
        boolean removed = superscriptList.remove(vSuperscript);
        return removed;
    }

    /**
     * Method removeSuperscriptAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.chartacaeli.model.Superscript removeSuperscriptAt(final int index) {
        java.lang.Object obj = this.superscriptList.remove(index);
        return (org.chartacaeli.model.Superscript) obj;
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
     * @param vSubscript
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSubscript(final int index,final org.chartacaeli.model.Subscript vSubscript) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.subscriptList.size()) {
            throw new IndexOutOfBoundsException("setSubscript: Index value '" + index + "' not in range [0.." + (this.subscriptList.size() - 1) + "]");
        }

        this.subscriptList.set(index, vSubscript);
    }

    /**
     * 
     * 
     * @param vSubscriptArray
     */
    public void setSubscript(final org.chartacaeli.model.Subscript[] vSubscriptArray) {
        //-- copy array
        subscriptList.clear();

        for (int i = 0; i < vSubscriptArray.length; i++) {
                this.subscriptList.add(vSubscriptArray[i]);
        }
    }

    /**
     * 
     * 
     * @param index
     * @param vSuperscript
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSuperscript(final int index,final org.chartacaeli.model.Superscript vSuperscript) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.superscriptList.size()) {
            throw new IndexOutOfBoundsException("setSuperscript: Index value '" + index + "' not in range [0.." + (this.superscriptList.size() - 1) + "]");
        }

        this.superscriptList.set(index, vSuperscript);
    }

    /**
     * 
     * 
     * @param vSuperscriptArray
     */
    public void setSuperscript(final org.chartacaeli.model.Superscript[] vSuperscriptArray) {
        //-- copy array
        superscriptList.clear();

        for (int i = 0; i < vSuperscriptArray.length; i++) {
                this.superscriptList.add(vSuperscriptArray[i]);
        }
    }

    /**
     * Sets the value of field 'value'. The field 'value' has the
     * following description: Discrete chart parameter.
     * 
     * @param value the value of field 'value'.
     */
    public void setValue(final java.lang.String value) {
        this.value = value;
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
