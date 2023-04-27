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
public abstract class IndirectType extends org.chartacaeli.Peer 
implements java.io.Serializable
{

    /**
     * Discrete chart parameter.
     */
    private java.lang.String value;

    /**
     * Discrete chart parameter.
     */
    private java.lang.String node;

    public IndirectType() {
        super();
    }

    /**
     * Returns the value of field 'node'. The field 'node' has the
     * following description: Discrete chart parameter.
     * 
     * @return the value of field 'Node'.
     */
    public java.lang.String getNode() {
        return this.node;
    }

    /**
     * Returns the value of field 'value'. The field 'value' has
     * the following description: Discrete chart parameter.
     * 
     * @return the value of field 'Value'.
     */
    public java.lang.String getValue() {
        return this.value;
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
     * Sets the value of field 'node'. The field 'node' has the
     * following description: Discrete chart parameter.
     * 
     * @param node the value of field 'node'.
     */
    public void setNode(final java.lang.String node) {
        this.node = node;
    }

    /**
     * Sets the value of field 'value'. The field 'value' has the
     * following description: Discrete chart parameter.
     * 
     * @param value the value of field 'value'.
     */
    public void setValue(final java.lang.String value) {
        this.value = value;
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
