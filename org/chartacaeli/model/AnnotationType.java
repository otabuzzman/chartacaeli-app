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
public abstract class AnnotationType extends org.chartacaeli.Peer 
implements java.io.Serializable
{

    /**
     * Discrete chart parameter.
     */
    private java.lang.String name;

    /**
     * Discrete chart parameter.
     */
    private java.lang.String anchor;

    /**
     * Discrete chart parameter.
     */
    private java.lang.String reverse;

    /**
     * Composite chart parameter.
     */
    private java.util.Vector<org.chartacaeli.model.Script> scriptList;

    public AnnotationType() {
        super();
        this.scriptList = new java.util.Vector<org.chartacaeli.model.Script>();
    }

    /**
     * 
     * 
     * @param vScript
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addScript(final org.chartacaeli.model.Script vScript) throws java.lang.IndexOutOfBoundsException {
        this.scriptList.addElement(vScript);
    }

    /**
     * 
     * 
     * @param index
     * @param vScript
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addScript(final int index,final org.chartacaeli.model.Script vScript) throws java.lang.IndexOutOfBoundsException {
        this.scriptList.add(index, vScript);
    }

    /**
     * Method enumerateScript.
     * 
     * @return an Enumeration over all org.chartacaeli.model.Script
     * elements
     */
    public java.util.Enumeration<? extends org.chartacaeli.model.Script> enumerateScript() {
        return this.scriptList.elements();
    }

    /**
     * Returns the value of field 'anchor'. The field 'anchor' has
     * the following description: Discrete chart parameter.
     * 
     * @return the value of field 'Anchor'.
     */
    public java.lang.String getAnchor() {
        return this.anchor;
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
     * Returns the value of field 'reverse'. The field 'reverse'
     * has the following description: Discrete chart parameter.
     * 
     * @return the value of field 'Reverse'.
     */
    public java.lang.String getReverse() {
        return this.reverse;
    }

    /**
     * Method getScript.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the org.chartacaeli.model.Script at the
     * given index
     */
    public org.chartacaeli.model.Script getScript(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.scriptList.size()) {
            throw new IndexOutOfBoundsException("getScript: Index value '" + index + "' not in range [0.." + (this.scriptList.size() - 1) + "]");
        }

        return scriptList.get(index);
    }

    /**
     * Method getScript.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.chartacaeli.model.Script[] getScript() {
        org.chartacaeli.model.Script[] array = new org.chartacaeli.model.Script[0];
        return this.scriptList.toArray(array);
    }

    /**
     * Method getScriptCount.
     * 
     * @return the size of this collection
     */
    public int getScriptCount() {
        return this.scriptList.size();
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
    public void removeAllScript() {
        this.scriptList.clear();
    }

    /**
     * Method removeScript.
     * 
     * @param vScript
     * @return true if the object was removed from the collection.
     */
    public boolean removeScript(final org.chartacaeli.model.Script vScript) {
        boolean removed = scriptList.remove(vScript);
        return removed;
    }

    /**
     * Method removeScriptAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.chartacaeli.model.Script removeScriptAt(final int index) {
        java.lang.Object obj = this.scriptList.remove(index);
        return (org.chartacaeli.model.Script) obj;
    }

    /**
     * Sets the value of field 'anchor'. The field 'anchor' has the
     * following description: Discrete chart parameter.
     * 
     * @param anchor the value of field 'anchor'.
     */
    public void setAnchor(final java.lang.String anchor) {
        this.anchor = anchor;
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
     * Sets the value of field 'reverse'. The field 'reverse' has
     * the following description: Discrete chart parameter.
     * 
     * @param reverse the value of field 'reverse'.
     */
    public void setReverse(final java.lang.String reverse) {
        this.reverse = reverse;
    }

    /**
     * 
     * 
     * @param index
     * @param vScript
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setScript(final int index,final org.chartacaeli.model.Script vScript) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.scriptList.size()) {
            throw new IndexOutOfBoundsException("setScript: Index value '" + index + "' not in range [0.." + (this.scriptList.size() - 1) + "]");
        }

        this.scriptList.set(index, vScript);
    }

    /**
     * 
     * 
     * @param vScriptArray
     */
    public void setScript(final org.chartacaeli.model.Script[] vScriptArray) {
        //-- copy array
        scriptList.clear();

        for (int i = 0; i < vScriptArray.length; i++) {
                this.scriptList.add(vScriptArray[i]);
        }
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
