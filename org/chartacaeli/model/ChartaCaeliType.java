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
public abstract class ChartaCaeliType extends org.chartacaeli.Peer 
implements java.io.Serializable
{

    /**
     * Discrete chart parameter.
     */
    private java.lang.String name;

    /**
     * Composite chart parameter.
     */
    private org.chartacaeli.model.Epoch epoch;

    /**
     * Chart feature class.
     */
    private java.util.Vector<org.chartacaeli.model.Chart> chartList;

    public ChartaCaeliType() {
        super();
        this.chartList = new java.util.Vector<org.chartacaeli.model.Chart>();
    }

    /**
     * 
     * 
     * @param vChart
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addChart(final org.chartacaeli.model.Chart vChart) throws java.lang.IndexOutOfBoundsException {
        this.chartList.addElement(vChart);
    }

    /**
     * 
     * 
     * @param index
     * @param vChart
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addChart(final int index,final org.chartacaeli.model.Chart vChart) throws java.lang.IndexOutOfBoundsException {
        this.chartList.add(index, vChart);
    }

    /**
     * Method enumerateChart.
     * 
     * @return an Enumeration over all org.chartacaeli.model.Chart
     * elements
     */
    public java.util.Enumeration<? extends org.chartacaeli.model.Chart> enumerateChart() {
        return this.chartList.elements();
    }

    /**
     * Method getChart.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the org.chartacaeli.model.Chart at the
     * given index
     */
    public org.chartacaeli.model.Chart getChart(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.chartList.size()) {
            throw new IndexOutOfBoundsException("getChart: Index value '" + index + "' not in range [0.." + (this.chartList.size() - 1) + "]");
        }

        return chartList.get(index);
    }

    /**
     * Method getChart.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.chartacaeli.model.Chart[] getChart() {
        org.chartacaeli.model.Chart[] array = new org.chartacaeli.model.Chart[0];
        return this.chartList.toArray(array);
    }

    /**
     * Method getChartCount.
     * 
     * @return the size of this collection
     */
    public int getChartCount() {
        return this.chartList.size();
    }

    /**
     * Returns the value of field 'epoch'. The field 'epoch' has
     * the following description: Composite chart parameter.
     * 
     * @return the value of field 'Epoch'.
     */
    public org.chartacaeli.model.Epoch getEpoch() {
        return this.epoch;
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
    public void removeAllChart() {
        this.chartList.clear();
    }

    /**
     * Method removeChart.
     * 
     * @param vChart
     * @return true if the object was removed from the collection.
     */
    public boolean removeChart(final org.chartacaeli.model.Chart vChart) {
        boolean removed = chartList.remove(vChart);
        return removed;
    }

    /**
     * Method removeChartAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.chartacaeli.model.Chart removeChartAt(final int index) {
        java.lang.Object obj = this.chartList.remove(index);
        return (org.chartacaeli.model.Chart) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vChart
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setChart(final int index,final org.chartacaeli.model.Chart vChart) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.chartList.size()) {
            throw new IndexOutOfBoundsException("setChart: Index value '" + index + "' not in range [0.." + (this.chartList.size() - 1) + "]");
        }

        this.chartList.set(index, vChart);
    }

    /**
     * 
     * 
     * @param vChartArray
     */
    public void setChart(final org.chartacaeli.model.Chart[] vChartArray) {
        //-- copy array
        chartList.clear();

        for (int i = 0; i < vChartArray.length; i++) {
                this.chartList.add(vChartArray[i]);
        }
    }

    /**
     * Sets the value of field 'epoch'. The field 'epoch' has the
     * following description: Composite chart parameter.
     * 
     * @param epoch the value of field 'epoch'.
     */
    public void setEpoch(final org.chartacaeli.model.Epoch epoch) {
        this.epoch = epoch;
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
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void validate() throws org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    }

}
