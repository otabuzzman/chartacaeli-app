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
public abstract class DialType extends org.chartacaeli.Peer 
implements java.io.Serializable
{

    /**
     * Discrete chart parameter.
     */
    private java.lang.String name;

    /**
     * Discrete chart parameter.
     */
    private long division;

    /**
     * Keeps track of whether primitive field division has been set
     * already.
     */
    private boolean hasdivision;

    /**
     * Discrete chart parameter.
     */
    private boolean reflect;

    /**
     * Keeps track of whether primitive field reflect has been set
     * already.
     */
    private boolean hasreflect;

    /**
     * Discrete chart parameter.
     */
    private java.lang.String baseline;

    private org.chartacaeli.model.DialTypeChoice dialTypeChoice;

    /**
     * Composite chart parameter.
     */
    private java.util.Vector<org.chartacaeli.model.Scaleline> scalelineList;

    /**
     * Chart feature class.
     */
    private java.util.Vector<org.chartacaeli.model.Annotation> annotationList;

    public DialType() {
        super();
        this.scalelineList = new java.util.Vector<org.chartacaeli.model.Scaleline>();
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
     * 
     * 
     * @param vScaleline
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addScaleline(final org.chartacaeli.model.Scaleline vScaleline) throws java.lang.IndexOutOfBoundsException {
        this.scalelineList.addElement(vScaleline);
    }

    /**
     * 
     * 
     * @param index
     * @param vScaleline
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addScaleline(final int index,final org.chartacaeli.model.Scaleline vScaleline) throws java.lang.IndexOutOfBoundsException {
        this.scalelineList.add(index, vScaleline);
    }

    /**
     */
    public void deleteDivision() {
        this.hasdivision= false;
    }

    /**
     */
    public void deleteReflect() {
        this.hasreflect= false;
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
     * Method enumerateScaleline.
     * 
     * @return an Enumeration over all
     * org.chartacaeli.model.Scaleline elements
     */
    public java.util.Enumeration<? extends org.chartacaeli.model.Scaleline> enumerateScaleline() {
        return this.scalelineList.elements();
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
     * Returns the value of field 'baseline'. The field 'baseline'
     * has the following description: Discrete chart parameter.
     * 
     * @return the value of field 'Baseline'.
     */
    public java.lang.String getBaseline() {
        return this.baseline;
    }

    /**
     * Returns the value of field 'dialTypeChoice'.
     * 
     * @return the value of field 'DialTypeChoice'.
     */
    public org.chartacaeli.model.DialTypeChoice getDialTypeChoice() {
        return this.dialTypeChoice;
    }

    /**
     * Returns the value of field 'division'. The field 'division'
     * has the following description: Discrete chart parameter.
     * 
     * @return the value of field 'Division'.
     */
    public long getDivision() {
        return this.division;
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
     * Returns the value of field 'reflect'. The field 'reflect'
     * has the following description: Discrete chart parameter.
     * 
     * @return the value of field 'Reflect'.
     */
    public boolean getReflect() {
        return this.reflect;
    }

    /**
     * Method getScaleline.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the org.chartacaeli.model.Scaleline at
     * the given index
     */
    public org.chartacaeli.model.Scaleline getScaleline(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.scalelineList.size()) {
            throw new IndexOutOfBoundsException("getScaleline: Index value '" + index + "' not in range [0.." + (this.scalelineList.size() - 1) + "]");
        }

        return scalelineList.get(index);
    }

    /**
     * Method getScaleline.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.chartacaeli.model.Scaleline[] getScaleline() {
        org.chartacaeli.model.Scaleline[] array = new org.chartacaeli.model.Scaleline[0];
        return this.scalelineList.toArray(array);
    }

    /**
     * Method getScalelineCount.
     * 
     * @return the size of this collection
     */
    public int getScalelineCount() {
        return this.scalelineList.size();
    }

    /**
     * Method hasDivision.
     * 
     * @return true if at least one Division has been added
     */
    public boolean hasDivision() {
        return this.hasdivision;
    }

    /**
     * Method hasReflect.
     * 
     * @return true if at least one Reflect has been added
     */
    public boolean hasReflect() {
        return this.hasreflect;
    }

    /**
     * Returns the value of field 'reflect'. The field 'reflect'
     * has the following description: Discrete chart parameter.
     * 
     * @return the value of field 'Reflect'.
     */
    public boolean isReflect() {
        return this.reflect;
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
     */
    public void removeAllScaleline() {
        this.scalelineList.clear();
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
     * Method removeScaleline.
     * 
     * @param vScaleline
     * @return true if the object was removed from the collection.
     */
    public boolean removeScaleline(final org.chartacaeli.model.Scaleline vScaleline) {
        boolean removed = scalelineList.remove(vScaleline);
        return removed;
    }

    /**
     * Method removeScalelineAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.chartacaeli.model.Scaleline removeScalelineAt(final int index) {
        java.lang.Object obj = this.scalelineList.remove(index);
        return (org.chartacaeli.model.Scaleline) obj;
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
     * Sets the value of field 'baseline'. The field 'baseline' has
     * the following description: Discrete chart parameter.
     * 
     * @param baseline the value of field 'baseline'.
     */
    public void setBaseline(final java.lang.String baseline) {
        this.baseline = baseline;
    }

    /**
     * Sets the value of field 'dialTypeChoice'.
     * 
     * @param dialTypeChoice the value of field 'dialTypeChoice'.
     */
    public void setDialTypeChoice(final org.chartacaeli.model.DialTypeChoice dialTypeChoice) {
        this.dialTypeChoice = dialTypeChoice;
    }

    /**
     * Sets the value of field 'division'. The field 'division' has
     * the following description: Discrete chart parameter.
     * 
     * @param division the value of field 'division'.
     */
    public void setDivision(final long division) {
        this.division = division;
        this.hasdivision = true;
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
     * Sets the value of field 'reflect'. The field 'reflect' has
     * the following description: Discrete chart parameter.
     * 
     * @param reflect the value of field 'reflect'.
     */
    public void setReflect(final boolean reflect) {
        this.reflect = reflect;
        this.hasreflect = true;
    }

    /**
     * 
     * 
     * @param index
     * @param vScaleline
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setScaleline(final int index,final org.chartacaeli.model.Scaleline vScaleline) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.scalelineList.size()) {
            throw new IndexOutOfBoundsException("setScaleline: Index value '" + index + "' not in range [0.." + (this.scalelineList.size() - 1) + "]");
        }

        this.scalelineList.set(index, vScaleline);
    }

    /**
     * 
     * 
     * @param vScalelineArray
     */
    public void setScaleline(final org.chartacaeli.model.Scaleline[] vScalelineArray) {
        //-- copy array
        scalelineList.clear();

        for (int i = 0; i < vScalelineArray.length; i++) {
                this.scalelineList.add(vScalelineArray[i]);
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
