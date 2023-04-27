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
public abstract class ChartType extends org.chartacaeli.Peer 
implements java.io.Serializable
{

    /**
     * Discrete chart parameter.
     */
    private java.lang.String name;

    /**
     * Discrete chart parameter.
     */
    private double scale;

    /**
     * Keeps track of whether primitive field scale has been set
     * already.
     */
    private boolean hasscale;

    /**
     * Composite chart parameter.
     */
    private org.chartacaeli.model.ChartPage chartPage;

    /**
     * Composite chart parameter.
     */
    private org.chartacaeli.model.Oblique oblique;

    /**
     * Chart feature class.
     */
    private java.util.Vector<org.chartacaeli.model.Horizon> horizonList;

    public ChartType() {
        super();
        this.horizonList = new java.util.Vector<org.chartacaeli.model.Horizon>();
    }

    /**
     * 
     * 
     * @param vHorizon
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addHorizon(final org.chartacaeli.model.Horizon vHorizon) throws java.lang.IndexOutOfBoundsException {
        this.horizonList.addElement(vHorizon);
    }

    /**
     * 
     * 
     * @param index
     * @param vHorizon
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addHorizon(final int index,final org.chartacaeli.model.Horizon vHorizon) throws java.lang.IndexOutOfBoundsException {
        this.horizonList.add(index, vHorizon);
    }

    /**
     */
    public void deleteScale() {
        this.hasscale= false;
    }

    /**
     * Method enumerateHorizon.
     * 
     * @return an Enumeration over all
     * org.chartacaeli.model.Horizon elements
     */
    public java.util.Enumeration<? extends org.chartacaeli.model.Horizon> enumerateHorizon() {
        return this.horizonList.elements();
    }

    /**
     * Returns the value of field 'chartPage'. The field
     * 'chartPage' has the following description: Composite chart
     * parameter.
     * 
     * @return the value of field 'ChartPage'.
     */
    public org.chartacaeli.model.ChartPage getChartPage() {
        return this.chartPage;
    }

    /**
     * Method getHorizon.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the org.chartacaeli.model.Horizon at
     * the given index
     */
    public org.chartacaeli.model.Horizon getHorizon(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.horizonList.size()) {
            throw new IndexOutOfBoundsException("getHorizon: Index value '" + index + "' not in range [0.." + (this.horizonList.size() - 1) + "]");
        }

        return horizonList.get(index);
    }

    /**
     * Method getHorizon.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.chartacaeli.model.Horizon[] getHorizon() {
        org.chartacaeli.model.Horizon[] array = new org.chartacaeli.model.Horizon[0];
        return this.horizonList.toArray(array);
    }

    /**
     * Method getHorizonCount.
     * 
     * @return the size of this collection
     */
    public int getHorizonCount() {
        return this.horizonList.size();
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
     * Returns the value of field 'oblique'. The field 'oblique'
     * has the following description: Composite chart parameter.
     * 
     * @return the value of field 'Oblique'.
     */
    public org.chartacaeli.model.Oblique getOblique() {
        return this.oblique;
    }

    /**
     * Returns the value of field 'scale'. The field 'scale' has
     * the following description: Discrete chart parameter.
     * 
     * @return the value of field 'Scale'.
     */
    public double getScale() {
        return this.scale;
    }

    /**
     * Method hasScale.
     * 
     * @return true if at least one Scale has been added
     */
    public boolean hasScale() {
        return this.hasscale;
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
    public void removeAllHorizon() {
        this.horizonList.clear();
    }

    /**
     * Method removeHorizon.
     * 
     * @param vHorizon
     * @return true if the object was removed from the collection.
     */
    public boolean removeHorizon(final org.chartacaeli.model.Horizon vHorizon) {
        boolean removed = horizonList.remove(vHorizon);
        return removed;
    }

    /**
     * Method removeHorizonAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.chartacaeli.model.Horizon removeHorizonAt(final int index) {
        java.lang.Object obj = this.horizonList.remove(index);
        return (org.chartacaeli.model.Horizon) obj;
    }

    /**
     * Sets the value of field 'chartPage'. The field 'chartPage'
     * has the following description: Composite chart parameter.
     * 
     * @param chartPage the value of field 'chartPage'.
     */
    public void setChartPage(final org.chartacaeli.model.ChartPage chartPage) {
        this.chartPage = chartPage;
    }

    /**
     * 
     * 
     * @param index
     * @param vHorizon
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setHorizon(final int index,final org.chartacaeli.model.Horizon vHorizon) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.horizonList.size()) {
            throw new IndexOutOfBoundsException("setHorizon: Index value '" + index + "' not in range [0.." + (this.horizonList.size() - 1) + "]");
        }

        this.horizonList.set(index, vHorizon);
    }

    /**
     * 
     * 
     * @param vHorizonArray
     */
    public void setHorizon(final org.chartacaeli.model.Horizon[] vHorizonArray) {
        //-- copy array
        horizonList.clear();

        for (int i = 0; i < vHorizonArray.length; i++) {
                this.horizonList.add(vHorizonArray[i]);
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
     * Sets the value of field 'oblique'. The field 'oblique' has
     * the following description: Composite chart parameter.
     * 
     * @param oblique the value of field 'oblique'.
     */
    public void setOblique(final org.chartacaeli.model.Oblique oblique) {
        this.oblique = oblique;
    }

    /**
     * Sets the value of field 'scale'. The field 'scale' has the
     * following description: Discrete chart parameter.
     * 
     * @param scale the value of field 'scale'.
     */
    public void setScale(final double scale) {
        this.scale = scale;
        this.hasscale = true;
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
