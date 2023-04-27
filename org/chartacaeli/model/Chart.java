/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package org.chartacaeli.model;

/**
 * Chart feature class.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Chart extends org.chartacaeli.Peer 
implements java.io.Serializable
{

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Chart feature element.
     */
    private org.chartacaeli.model.ChartAzimuthal chartAzimuthal;

    /**
     * Chart feature element.
     */
    private org.chartacaeli.model.ChartPseudoCylindrical chartPseudoCylindrical;

    public Chart() {
        super();
    }

    /**
     * Returns the value of field 'chartAzimuthal'. The field
     * 'chartAzimuthal' has the following description: Chart
     * feature element.
     * 
     * @return the value of field 'ChartAzimuthal'.
     */
    public org.chartacaeli.model.ChartAzimuthal getChartAzimuthal() {
        return this.chartAzimuthal;
    }

    /**
     * Returns the value of field 'chartPseudoCylindrical'. The
     * field 'chartPseudoCylindrical' has the following
     * description: Chart feature element.
     * 
     * @return the value of field 'ChartPseudoCylindrical'.
     */
    public org.chartacaeli.model.ChartPseudoCylindrical getChartPseudoCylindrical() {
        return this.chartPseudoCylindrical;
    }

    /**
     * Returns the value of field 'choiceValue'. The field
     * 'choiceValue' has the following description: Internal choice
     * value storage
     * 
     * @return the value of field 'ChoiceValue'.
     */
    public java.lang.Object getChoiceValue() {
        return this._choiceValue;
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
     * 
     * 
     * @param out
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void marshal(final java.io.Writer out) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Marshaller.marshal(this, out);
    }

    /**
     * 
     * 
     * @param handler
     * @throws java.io.IOException if an IOException occurs during
     * marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     */
    public void marshal(final org.xml.sax.ContentHandler handler) throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Marshaller.marshal(this, handler);
    }

    /**
     * Sets the value of field 'chartAzimuthal'. The field
     * 'chartAzimuthal' has the following description: Chart
     * feature element.
     * 
     * @param chartAzimuthal the value of field 'chartAzimuthal'.
     */
    public void setChartAzimuthal(final org.chartacaeli.model.ChartAzimuthal chartAzimuthal) {
        this.chartAzimuthal = chartAzimuthal;
        this._choiceValue = chartAzimuthal;
    }

    /**
     * Sets the value of field 'chartPseudoCylindrical'. The field
     * 'chartPseudoCylindrical' has the following description:
     * Chart feature element.
     * 
     * @param chartPseudoCylindrical the value of field
     * 'chartPseudoCylindrical'.
     */
    public void setChartPseudoCylindrical(final org.chartacaeli.model.ChartPseudoCylindrical chartPseudoCylindrical) {
        this.chartPseudoCylindrical = chartPseudoCylindrical;
        this._choiceValue = chartPseudoCylindrical;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled org.chartacaeli.model.Chart
     */
    public static org.chartacaeli.model.Chart unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.chartacaeli.model.Chart) org.exolab.castor.xml.Unmarshaller.unmarshal(org.chartacaeli.model.Chart.class, reader);
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
