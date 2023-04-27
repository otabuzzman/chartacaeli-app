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
public abstract class BodyStellarType extends org.chartacaeli.Peer 
implements java.io.Serializable
{

    /**
     * Discrete chart parameter.
     */
    private java.lang.String name;

    /**
     * Discrete chart parameter.
     */
    private double turn;

    /**
     * Keeps track of whether primitive field turn has been set
     * already.
     */
    private boolean hasturn;

    /**
     * Discrete chart parameter.
     */
    private double spin;

    /**
     * Keeps track of whether primitive field spin has been set
     * already.
     */
    private boolean hasspin;

    /**
     * Chart feature class.
     */
    private java.util.Vector<org.chartacaeli.model.Annotation> annotationList;

    /**
     * Composite chart parameter.
     */
    private org.chartacaeli.model.Position position;

    /**
     * Composite chart parameter.
     */
    private org.chartacaeli.model.Script script;

    public BodyStellarType() {
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
    public void deleteSpin() {
        this.hasspin= false;
    }

    /**
     */
    public void deleteTurn() {
        this.hasturn= false;
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
     * Returns the value of field 'position'. The field 'position'
     * has the following description: Composite chart parameter.
     * 
     * @return the value of field 'Position'.
     */
    public org.chartacaeli.model.Position getPosition() {
        return this.position;
    }

    /**
     * Returns the value of field 'script'. The field 'script' has
     * the following description: Composite chart parameter.
     * 
     * @return the value of field 'Script'.
     */
    public org.chartacaeli.model.Script getScript() {
        return this.script;
    }

    /**
     * Returns the value of field 'spin'. The field 'spin' has the
     * following description: Discrete chart parameter.
     * 
     * @return the value of field 'Spin'.
     */
    public double getSpin() {
        return this.spin;
    }

    /**
     * Returns the value of field 'turn'. The field 'turn' has the
     * following description: Discrete chart parameter.
     * 
     * @return the value of field 'Turn'.
     */
    public double getTurn() {
        return this.turn;
    }

    /**
     * Method hasSpin.
     * 
     * @return true if at least one Spin has been added
     */
    public boolean hasSpin() {
        return this.hasspin;
    }

    /**
     * Method hasTurn.
     * 
     * @return true if at least one Turn has been added
     */
    public boolean hasTurn() {
        return this.hasturn;
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
     * Sets the value of field 'position'. The field 'position' has
     * the following description: Composite chart parameter.
     * 
     * @param position the value of field 'position'.
     */
    public void setPosition(final org.chartacaeli.model.Position position) {
        this.position = position;
    }

    /**
     * Sets the value of field 'script'. The field 'script' has the
     * following description: Composite chart parameter.
     * 
     * @param script the value of field 'script'.
     */
    public void setScript(final org.chartacaeli.model.Script script) {
        this.script = script;
    }

    /**
     * Sets the value of field 'spin'. The field 'spin' has the
     * following description: Discrete chart parameter.
     * 
     * @param spin the value of field 'spin'.
     */
    public void setSpin(final double spin) {
        this.spin = spin;
        this.hasspin = true;
    }

    /**
     * Sets the value of field 'turn'. The field 'turn' has the
     * following description: Discrete chart parameter.
     * 
     * @param turn the value of field 'turn'.
     */
    public void setTurn(final double turn) {
        this.turn = turn;
        this.hasturn = true;
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
