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
public abstract class SignType extends org.chartacaeli.Peer 
implements java.io.Serializable
{

    /**
     * Discrete chart parameter.
     */
    private java.lang.String name;

    /**
     * Chart feature class.
     */
    private org.chartacaeli.model.Annotation annotation;

    /**
     * Composite chart parameter.
     */
    private java.util.Vector<org.chartacaeli.model.Position> positionList;

    /**
     * Composite chart parameter.
     */
    private org.chartacaeli.model.Limb limb;

    public SignType() {
        super();
        this.positionList = new java.util.Vector<org.chartacaeli.model.Position>();
    }

    /**
     * 
     * 
     * @param vPosition
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPosition(final org.chartacaeli.model.Position vPosition) throws java.lang.IndexOutOfBoundsException {
        this.positionList.addElement(vPosition);
    }

    /**
     * 
     * 
     * @param index
     * @param vPosition
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPosition(final int index,final org.chartacaeli.model.Position vPosition) throws java.lang.IndexOutOfBoundsException {
        this.positionList.add(index, vPosition);
    }

    /**
     * Method enumeratePosition.
     * 
     * @return an Enumeration over all
     * org.chartacaeli.model.Position elements
     */
    public java.util.Enumeration<? extends org.chartacaeli.model.Position> enumeratePosition() {
        return this.positionList.elements();
    }

    /**
     * Returns the value of field 'annotation'. The field
     * 'annotation' has the following description: Chart feature
     * class.
     * 
     * @return the value of field 'Annotation'.
     */
    public org.chartacaeli.model.Annotation getAnnotation() {
        return this.annotation;
    }

    /**
     * Returns the value of field 'limb'. The field 'limb' has the
     * following description: Composite chart parameter.
     * 
     * @return the value of field 'Limb'.
     */
    public org.chartacaeli.model.Limb getLimb() {
        return this.limb;
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
     * Method getPosition.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the org.chartacaeli.model.Position at
     * the given index
     */
    public org.chartacaeli.model.Position getPosition(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.positionList.size()) {
            throw new IndexOutOfBoundsException("getPosition: Index value '" + index + "' not in range [0.." + (this.positionList.size() - 1) + "]");
        }

        return positionList.get(index);
    }

    /**
     * Method getPosition.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.chartacaeli.model.Position[] getPosition() {
        org.chartacaeli.model.Position[] array = new org.chartacaeli.model.Position[0];
        return this.positionList.toArray(array);
    }

    /**
     * Method getPositionCount.
     * 
     * @return the size of this collection
     */
    public int getPositionCount() {
        return this.positionList.size();
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
    public void removeAllPosition() {
        this.positionList.clear();
    }

    /**
     * Method removePosition.
     * 
     * @param vPosition
     * @return true if the object was removed from the collection.
     */
    public boolean removePosition(final org.chartacaeli.model.Position vPosition) {
        boolean removed = positionList.remove(vPosition);
        return removed;
    }

    /**
     * Method removePositionAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.chartacaeli.model.Position removePositionAt(final int index) {
        java.lang.Object obj = this.positionList.remove(index);
        return (org.chartacaeli.model.Position) obj;
    }

    /**
     * Sets the value of field 'annotation'. The field 'annotation'
     * has the following description: Chart feature class.
     * 
     * @param annotation the value of field 'annotation'.
     */
    public void setAnnotation(final org.chartacaeli.model.Annotation annotation) {
        this.annotation = annotation;
    }

    /**
     * Sets the value of field 'limb'. The field 'limb' has the
     * following description: Composite chart parameter.
     * 
     * @param limb the value of field 'limb'.
     */
    public void setLimb(final org.chartacaeli.model.Limb limb) {
        this.limb = limb;
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
     * @param vPosition
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setPosition(final int index,final org.chartacaeli.model.Position vPosition) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.positionList.size()) {
            throw new IndexOutOfBoundsException("setPosition: Index value '" + index + "' not in range [0.." + (this.positionList.size() - 1) + "]");
        }

        this.positionList.set(index, vPosition);
    }

    /**
     * 
     * 
     * @param vPositionArray
     */
    public void setPosition(final org.chartacaeli.model.Position[] vPositionArray) {
        //-- copy array
        positionList.clear();

        for (int i = 0; i < vPositionArray.length; i++) {
                this.positionList.add(vPositionArray[i]);
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
