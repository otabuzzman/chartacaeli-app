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
public abstract class CatalogRecordType extends org.chartacaeli.Peer 
implements java.io.Serializable
{

    /**
     * Discrete chart parameter.
     */
    private java.lang.String name;

    /**
     * Discrete chart parameter.
     */
    private java.lang.String select;

    /**
     * Chart feature class.
     */
    private java.util.Vector<org.chartacaeli.model.Annotation> annotationList;

    public CatalogRecordType() {
        super();
        this.annotationList = new java.util.Vector<org.chartacaeli.model.Annotation>();
    }

    /**
     * 
     * 
     * @param vAnnotation
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAnnotation(final org.chartacaeli.model.Annotation vAnnotation) throws java.lang.IndexOutOfBoundsException {
        this.annotationList.addElement(vAnnotation);
    }

    /**
     * 
     * 
     * @param index
     * @param vAnnotation
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAnnotation(final int index,final org.chartacaeli.model.Annotation vAnnotation) throws java.lang.IndexOutOfBoundsException {
        this.annotationList.add(index, vAnnotation);
    }

    /**
     * Method enumerateAnnotation.
     * 
     * @return an Enumeration over all
     * org.chartacaeli.model.Annotation elements
     */
    public java.util.Enumeration<? extends org.chartacaeli.model.Annotation> enumerateAnnotation() {
        return this.annotationList.elements();
    }

    /**
     * Method getAnnotation.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the org.chartacaeli.model.Annotation at
     * the given index
     */
    public org.chartacaeli.model.Annotation getAnnotation(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.annotationList.size()) {
            throw new IndexOutOfBoundsException("getAnnotation: Index value '" + index + "' not in range [0.." + (this.annotationList.size() - 1) + "]");
        }

        return annotationList.get(index);
    }

    /**
     * Method getAnnotation.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.chartacaeli.model.Annotation[] getAnnotation() {
        org.chartacaeli.model.Annotation[] array = new org.chartacaeli.model.Annotation[0];
        return this.annotationList.toArray(array);
    }

    /**
     * Method getAnnotationCount.
     * 
     * @return the size of this collection
     */
    public int getAnnotationCount() {
        return this.annotationList.size();
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
     * Returns the value of field 'select'. The field 'select' has
     * the following description: Discrete chart parameter.
     * 
     * @return the value of field 'Select'.
     */
    public java.lang.String getSelect() {
        return this.select;
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
    public void removeAllAnnotation() {
        this.annotationList.clear();
    }

    /**
     * Method removeAnnotation.
     * 
     * @param vAnnotation
     * @return true if the object was removed from the collection.
     */
    public boolean removeAnnotation(final org.chartacaeli.model.Annotation vAnnotation) {
        boolean removed = annotationList.remove(vAnnotation);
        return removed;
    }

    /**
     * Method removeAnnotationAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.chartacaeli.model.Annotation removeAnnotationAt(final int index) {
        java.lang.Object obj = this.annotationList.remove(index);
        return (org.chartacaeli.model.Annotation) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vAnnotation
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setAnnotation(final int index,final org.chartacaeli.model.Annotation vAnnotation) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.annotationList.size()) {
            throw new IndexOutOfBoundsException("setAnnotation: Index value '" + index + "' not in range [0.." + (this.annotationList.size() - 1) + "]");
        }

        this.annotationList.set(index, vAnnotation);
    }

    /**
     * 
     * 
     * @param vAnnotationArray
     */
    public void setAnnotation(final org.chartacaeli.model.Annotation[] vAnnotationArray) {
        //-- copy array
        annotationList.clear();

        for (int i = 0; i < vAnnotationArray.length; i++) {
                this.annotationList.add(vAnnotationArray[i]);
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
     * Sets the value of field 'select'. The field 'select' has the
     * following description: Discrete chart parameter.
     * 
     * @param select the value of field 'select'.
     */
    public void setSelect(final java.lang.String select) {
        this.select = select;
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
