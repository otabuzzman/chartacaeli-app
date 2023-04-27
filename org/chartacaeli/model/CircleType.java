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
public abstract class CircleType extends org.chartacaeli.Peer 
implements java.io.Serializable
{

    /**
     * Discrete chart parameter.
     */
    private java.lang.String name;

    /**
     * Discrete chart parameter.
     */
    private boolean fieldofview = false;

    /**
     * Keeps track of whether primitive field fieldofview has been
     * set already.
     */
    private boolean hasfieldofview;

    /**
     * Discrete chart parameter.
     */
    private java.lang.String importance;

    private org.chartacaeli.model.Alpha alpha;

    private org.chartacaeli.model.Omega omega;

    /**
     * Composite chart parameter.
     */
    private org.chartacaeli.model.DialDeg dialDeg;

    /**
     * Chart feature class.
     */
    private java.util.Vector<org.chartacaeli.model.Annotation> annotationList;

    public CircleType() {
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
     */
    public void deleteFieldofview() {
        this.hasfieldofview= false;
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
     * Returns the value of field 'alpha'.
     * 
     * @return the value of field 'Alpha'.
     */
    public org.chartacaeli.model.Alpha getAlpha() {
        return this.alpha;
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
     * Returns the value of field 'dialDeg'. The field 'dialDeg'
     * has the following description: Composite chart parameter.
     * 
     * @return the value of field 'DialDeg'.
     */
    public org.chartacaeli.model.DialDeg getDialDeg() {
        return this.dialDeg;
    }

    /**
     * Returns the value of field 'fieldofview'. The field
     * 'fieldofview' has the following description: Discrete chart
     * parameter.
     * 
     * @return the value of field 'Fieldofview'.
     */
    public boolean getFieldofview() {
        return this.fieldofview;
    }

    /**
     * Returns the value of field 'importance'. The field
     * 'importance' has the following description: Discrete chart
     * parameter.
     * 
     * @return the value of field 'Importance'.
     */
    public java.lang.String getImportance() {
        return this.importance;
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
     * Returns the value of field 'omega'.
     * 
     * @return the value of field 'Omega'.
     */
    public org.chartacaeli.model.Omega getOmega() {
        return this.omega;
    }

    /**
     * Method hasFieldofview.
     * 
     * @return true if at least one Fieldofview has been added
     */
    public boolean hasFieldofview() {
        return this.hasfieldofview;
    }

    /**
     * Returns the value of field 'fieldofview'. The field
     * 'fieldofview' has the following description: Discrete chart
     * parameter.
     * 
     * @return the value of field 'Fieldofview'.
     */
    public boolean isFieldofview() {
        return this.fieldofview;
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
     * Sets the value of field 'alpha'.
     * 
     * @param alpha the value of field 'alpha'.
     */
    public void setAlpha(final org.chartacaeli.model.Alpha alpha) {
        this.alpha = alpha;
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
     * Sets the value of field 'dialDeg'. The field 'dialDeg' has
     * the following description: Composite chart parameter.
     * 
     * @param dialDeg the value of field 'dialDeg'.
     */
    public void setDialDeg(final org.chartacaeli.model.DialDeg dialDeg) {
        this.dialDeg = dialDeg;
    }

    /**
     * Sets the value of field 'fieldofview'. The field
     * 'fieldofview' has the following description: Discrete chart
     * parameter.
     * 
     * @param fieldofview the value of field 'fieldofview'.
     */
    public void setFieldofview(final boolean fieldofview) {
        this.fieldofview = fieldofview;
        this.hasfieldofview = true;
    }

    /**
     * Sets the value of field 'importance'. The field 'importance'
     * has the following description: Discrete chart parameter.
     * 
     * @param importance the value of field 'importance'.
     */
    public void setImportance(final java.lang.String importance) {
        this.importance = importance;
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
     * Sets the value of field 'omega'.
     * 
     * @param omega the value of field 'omega'.
     */
    public void setOmega(final org.chartacaeli.model.Omega omega) {
        this.omega = omega;
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
