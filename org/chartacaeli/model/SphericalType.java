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
public abstract class SphericalType extends org.chartacaeli.Peer 
implements java.io.Serializable
{

    /**
     * Composite chart parameter.
     */
    private org.chartacaeli.model.Longitude longitude;

    /**
     * Composite chart parameter.
     */
    private org.chartacaeli.model.Latitude latitude;

    /**
     * Composite chart parameter.
     */
    private org.chartacaeli.model.Rad rad;

    public SphericalType() {
        super();
    }

    /**
     * Returns the value of field 'latitude'. The field 'latitude'
     * has the following description: Composite chart parameter.
     * 
     * @return the value of field 'Latitude'.
     */
    public org.chartacaeli.model.Latitude getLatitude() {
        return this.latitude;
    }

    /**
     * Returns the value of field 'longitude'. The field
     * 'longitude' has the following description: Composite chart
     * parameter.
     * 
     * @return the value of field 'Longitude'.
     */
    public org.chartacaeli.model.Longitude getLongitude() {
        return this.longitude;
    }

    /**
     * Returns the value of field 'rad'. The field 'rad' has the
     * following description: Composite chart parameter.
     * 
     * @return the value of field 'Rad'.
     */
    public org.chartacaeli.model.Rad getRad() {
        return this.rad;
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
     * Sets the value of field 'latitude'. The field 'latitude' has
     * the following description: Composite chart parameter.
     * 
     * @param latitude the value of field 'latitude'.
     */
    public void setLatitude(final org.chartacaeli.model.Latitude latitude) {
        this.latitude = latitude;
    }

    /**
     * Sets the value of field 'longitude'. The field 'longitude'
     * has the following description: Composite chart parameter.
     * 
     * @param longitude the value of field 'longitude'.
     */
    public void setLongitude(final org.chartacaeli.model.Longitude longitude) {
        this.longitude = longitude;
    }

    /**
     * Sets the value of field 'rad'. The field 'rad' has the
     * following description: Composite chart parameter.
     * 
     * @param rad the value of field 'rad'.
     */
    public void setRad(final org.chartacaeli.model.Rad rad) {
        this.rad = rad;
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
