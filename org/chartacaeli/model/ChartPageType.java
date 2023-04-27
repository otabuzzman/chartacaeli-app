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
public abstract class ChartPageType extends org.chartacaeli.Peer 
implements java.io.Serializable
{

    /**
     * Discrete chart parameter.
     */
    private java.lang.String name;

    /**
     * Discrete chart parameter.
     */
    private java.lang.String size;

    /**
     * Discrete chart parameter.
     */
    private double view;

    /**
     * Keeps track of whether primitive field view has been set
     * already.
     */
    private boolean hasview;

    public ChartPageType() {
        super();
    }

    /**
     */
    public void deleteView() {
        this.hasview= false;
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
     * Returns the value of field 'size'. The field 'size' has the
     * following description: Discrete chart parameter.
     * 
     * @return the value of field 'Size'.
     */
    public java.lang.String getSize() {
        return this.size;
    }

    /**
     * Returns the value of field 'view'. The field 'view' has the
     * following description: Discrete chart parameter.
     * 
     * @return the value of field 'View'.
     */
    public double getView() {
        return this.view;
    }

    /**
     * Method hasView.
     * 
     * @return true if at least one View has been added
     */
    public boolean hasView() {
        return this.hasview;
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
     * Sets the value of field 'name'. The field 'name' has the
     * following description: Discrete chart parameter.
     * 
     * @param name the value of field 'name'.
     */
    public void setName(final java.lang.String name) {
        this.name = name;
    }

    /**
     * Sets the value of field 'size'. The field 'size' has the
     * following description: Discrete chart parameter.
     * 
     * @param size the value of field 'size'.
     */
    public void setSize(final java.lang.String size) {
        this.size = size;
    }

    /**
     * Sets the value of field 'view'. The field 'view' has the
     * following description: Discrete chart parameter.
     * 
     * @param view the value of field 'view'.
     */
    public void setView(final double view) {
        this.view = view;
        this.hasview = true;
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
