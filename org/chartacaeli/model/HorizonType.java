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
public abstract class HorizonType extends org.chartacaeli.Peer 
implements java.io.Serializable
{

    /**
     * Discrete chart parameter.
     */
    private java.lang.String name;

    /**
     * Discrete chart parameter.
     */
    private java.lang.String practicality;

    /**
     * Chart feature element.
     */
    private java.util.Vector<org.chartacaeli.model.AnnotationStraight> annotationStraightList;

    /**
     * Chart feature class.
     */
    private java.util.Vector<org.chartacaeli.model.Circle> circleList;

    /**
     * Chart feature class.
     */
    private java.util.Vector<org.chartacaeli.model.Body> bodyList;

    public HorizonType() {
        super();
        this.annotationStraightList = new java.util.Vector<org.chartacaeli.model.AnnotationStraight>();
        this.circleList = new java.util.Vector<org.chartacaeli.model.Circle>();
        this.bodyList = new java.util.Vector<org.chartacaeli.model.Body>();
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
     * 
     * 
     * @param vBody
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addBody(final org.chartacaeli.model.Body vBody) throws java.lang.IndexOutOfBoundsException {
        this.bodyList.addElement(vBody);
    }

    /**
     * 
     * 
     * @param index
     * @param vBody
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addBody(final int index,final org.chartacaeli.model.Body vBody) throws java.lang.IndexOutOfBoundsException {
        this.bodyList.add(index, vBody);
    }

    /**
     * 
     * 
     * @param vCircle
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCircle(final org.chartacaeli.model.Circle vCircle) throws java.lang.IndexOutOfBoundsException {
        this.circleList.addElement(vCircle);
    }

    /**
     * 
     * 
     * @param index
     * @param vCircle
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCircle(final int index,final org.chartacaeli.model.Circle vCircle) throws java.lang.IndexOutOfBoundsException {
        this.circleList.add(index, vCircle);
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
     * Method enumerateBody.
     * 
     * @return an Enumeration over all org.chartacaeli.model.Body
     * elements
     */
    public java.util.Enumeration<? extends org.chartacaeli.model.Body> enumerateBody() {
        return this.bodyList.elements();
    }

    /**
     * Method enumerateCircle.
     * 
     * @return an Enumeration over all org.chartacaeli.model.Circle
     * elements
     */
    public java.util.Enumeration<? extends org.chartacaeli.model.Circle> enumerateCircle() {
        return this.circleList.elements();
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
     * Method getBody.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the org.chartacaeli.model.Body at the
     * given index
     */
    public org.chartacaeli.model.Body getBody(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.bodyList.size()) {
            throw new IndexOutOfBoundsException("getBody: Index value '" + index + "' not in range [0.." + (this.bodyList.size() - 1) + "]");
        }

        return bodyList.get(index);
    }

    /**
     * Method getBody.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.chartacaeli.model.Body[] getBody() {
        org.chartacaeli.model.Body[] array = new org.chartacaeli.model.Body[0];
        return this.bodyList.toArray(array);
    }

    /**
     * Method getBodyCount.
     * 
     * @return the size of this collection
     */
    public int getBodyCount() {
        return this.bodyList.size();
    }

    /**
     * Method getCircle.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the org.chartacaeli.model.Circle at the
     * given index
     */
    public org.chartacaeli.model.Circle getCircle(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.circleList.size()) {
            throw new IndexOutOfBoundsException("getCircle: Index value '" + index + "' not in range [0.." + (this.circleList.size() - 1) + "]");
        }

        return circleList.get(index);
    }

    /**
     * Method getCircle.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.chartacaeli.model.Circle[] getCircle() {
        org.chartacaeli.model.Circle[] array = new org.chartacaeli.model.Circle[0];
        return this.circleList.toArray(array);
    }

    /**
     * Method getCircleCount.
     * 
     * @return the size of this collection
     */
    public int getCircleCount() {
        return this.circleList.size();
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
     * Returns the value of field 'practicality'. The field
     * 'practicality' has the following description: Discrete chart
     * parameter.
     * 
     * @return the value of field 'Practicality'.
     */
    public java.lang.String getPracticality() {
        return this.practicality;
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
     */
    public void removeAllBody() {
        this.bodyList.clear();
    }

    /**
     */
    public void removeAllCircle() {
        this.circleList.clear();
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
     * Method removeBody.
     * 
     * @param vBody
     * @return true if the object was removed from the collection.
     */
    public boolean removeBody(final org.chartacaeli.model.Body vBody) {
        boolean removed = bodyList.remove(vBody);
        return removed;
    }

    /**
     * Method removeBodyAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.chartacaeli.model.Body removeBodyAt(final int index) {
        java.lang.Object obj = this.bodyList.remove(index);
        return (org.chartacaeli.model.Body) obj;
    }

    /**
     * Method removeCircle.
     * 
     * @param vCircle
     * @return true if the object was removed from the collection.
     */
    public boolean removeCircle(final org.chartacaeli.model.Circle vCircle) {
        boolean removed = circleList.remove(vCircle);
        return removed;
    }

    /**
     * Method removeCircleAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.chartacaeli.model.Circle removeCircleAt(final int index) {
        java.lang.Object obj = this.circleList.remove(index);
        return (org.chartacaeli.model.Circle) obj;
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
     * 
     * 
     * @param index
     * @param vBody
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setBody(final int index,final org.chartacaeli.model.Body vBody) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.bodyList.size()) {
            throw new IndexOutOfBoundsException("setBody: Index value '" + index + "' not in range [0.." + (this.bodyList.size() - 1) + "]");
        }

        this.bodyList.set(index, vBody);
    }

    /**
     * 
     * 
     * @param vBodyArray
     */
    public void setBody(final org.chartacaeli.model.Body[] vBodyArray) {
        //-- copy array
        bodyList.clear();

        for (int i = 0; i < vBodyArray.length; i++) {
                this.bodyList.add(vBodyArray[i]);
        }
    }

    /**
     * 
     * 
     * @param index
     * @param vCircle
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCircle(final int index,final org.chartacaeli.model.Circle vCircle) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.circleList.size()) {
            throw new IndexOutOfBoundsException("setCircle: Index value '" + index + "' not in range [0.." + (this.circleList.size() - 1) + "]");
        }

        this.circleList.set(index, vCircle);
    }

    /**
     * 
     * 
     * @param vCircleArray
     */
    public void setCircle(final org.chartacaeli.model.Circle[] vCircleArray) {
        //-- copy array
        circleList.clear();

        for (int i = 0; i < vCircleArray.length; i++) {
                this.circleList.add(vCircleArray[i]);
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
     * Sets the value of field 'practicality'. The field
     * 'practicality' has the following description: Discrete chart
     * parameter.
     * 
     * @param practicality the value of field 'practicality'.
     */
    public void setPracticality(final java.lang.String practicality) {
        this.practicality = practicality;
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
