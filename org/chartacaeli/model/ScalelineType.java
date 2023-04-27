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
public abstract class ScalelineType extends org.chartacaeli.Peer 
implements java.io.Serializable
{

    /**
     * Discrete chart parameter.
     */
    private java.lang.String name;

    /**
     * Discrete chart parameter.
     */
    private double value;

    /**
     * Keeps track of whether primitive field value has been set
     * already.
     */
    private boolean hasvalue;

    /**
     * Chart feature element.
     */
    private java.util.Vector<org.chartacaeli.model.AnnotationStraight> annotationStraightList;

    public ScalelineType() {
        super();
        this.annotationStraightList = new java.util.Vector<org.chartacaeli.model.AnnotationStraight>();
    }

    /**
     * 
     * 
     * @param vAnnotationStraight
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAnnotationStraight(final org.chartacaeli.model.AnnotationStraight vAnnotationStraight) throws java.lang.IndexOutOfBoundsException {
        this.annotationStraightList.addElement(vAnnotationStraight);
    }

    /**
     * 
     * 
     * @param index
     * @param vAnnotationStraight
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAnnotationStraight(final int index,final org.chartacaeli.model.AnnotationStraight vAnnotationStraight) throws java.lang.IndexOutOfBoundsException {
        this.annotationStraightList.add(index, vAnnotationStraight);
    }

    /**
     */
    public void deleteValue() {
        this.hasvalue= false;
    }

    /**
     * Method enumerateAnnotationStraight.
     * 
     * @return an Enumeration over all
     * org.chartacaeli.model.AnnotationStraight elements
     */
    public java.util.Enumeration<? extends org.chartacaeli.model.AnnotationStraight> enumerateAnnotationStraight() {
        return this.annotationStraightList.elements();
    }

    /**
     * Method getAnnotationStraight.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * org.chartacaeli.model.AnnotationStraight at the given index
     */
    public org.chartacaeli.model.AnnotationStraight getAnnotationStraight(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.annotationStraightList.size()) {
            throw new IndexOutOfBoundsException("getAnnotationStraight: Index value '" + index + "' not in range [0.." + (this.annotationStraightList.size() - 1) + "]");
        }

        return annotationStraightList.get(index);
    }

    /**
     * Method getAnnotationStraight.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.chartacaeli.model.AnnotationStraight[] getAnnotationStraight() {
        org.chartacaeli.model.AnnotationStraight[] array = new org.chartacaeli.model.AnnotationStraight[0];
        return this.annotationStraightList.toArray(array);
    }

    /**
     * Method getAnnotationStraightCount.
     * 
     * @return the size of this collection
     */
    public int getAnnotationStraightCount() {
        return this.annotationStraightList.size();
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
     * Returns the value of field 'value'. The field 'value' has
     * the following description: Discrete chart parameter.
     * 
     * @return the value of field 'Value'.
     */
    public double getValue() {
        return this.value;
    }

    /**
     * Method hasValue.
     * 
     * @return true if at least one Value has been added
     */
    public boolean hasValue() {
        return this.hasvalue;
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
    public void removeAllAnnotationStraight() {
        this.annotationStraightList.clear();
    }

    /**
     * Method removeAnnotationStraight.
     * 
     * @param vAnnotationStraight
     * @return true if the object was removed from the collection.
     */
    public boolean removeAnnotationStraight(final org.chartacaeli.model.AnnotationStraight vAnnotationStraight) {
        boolean removed = annotationStraightList.remove(vAnnotationStraight);
        return removed;
    }

    /**
     * Method removeAnnotationStraightAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.chartacaeli.model.AnnotationStraight removeAnnotationStraightAt(final int index) {
        java.lang.Object obj = this.annotationStraightList.remove(index);
        return (org.chartacaeli.model.AnnotationStraight) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vAnnotationStraight
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setAnnotationStraight(final int index,final org.chartacaeli.model.AnnotationStraight vAnnotationStraight) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.annotationStraightList.size()) {
            throw new IndexOutOfBoundsException("setAnnotationStraight: Index value '" + index + "' not in range [0.." + (this.annotationStraightList.size() - 1) + "]");
        }

        this.annotationStraightList.set(index, vAnnotationStraight);
    }

    /**
     * 
     * 
     * @param vAnnotationStraightArray
     */
    public void setAnnotationStraight(final org.chartacaeli.model.AnnotationStraight[] vAnnotationStraightArray) {
        //-- copy array
        annotationStraightList.clear();

        for (int i = 0; i < vAnnotationStraightArray.length; i++) {
                this.annotationStraightList.add(vAnnotationStraightArray[i]);
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
     * Sets the value of field 'value'. The field 'value' has the
     * following description: Discrete chart parameter.
     * 
     * @param value the value of field 'value'.
     */
    public void setValue(final double value) {
        this.value = value;
        this.hasvalue = true;
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
