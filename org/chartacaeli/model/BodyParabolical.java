/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package org.chartacaeli.model;

/**
 * Chart feature element.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class BodyParabolical extends org.chartacaeli.model.BodyOrbitalType 
implements java.io.Serializable
{

    /**
     * Discrete chart parameter.
     */
    private double q;

    /**
     * Keeps track of whether primitive field q has been set already
     */
    private boolean hasq;

    /**
     * Discrete chart parameter.
     */
    private double i;

    /**
     * Keeps track of whether primitive field i has been set already
     */
    private boolean hasi;

    /**
     * Discrete chart parameter.
     */
    private double o;

    /**
     * Keeps track of whether primitive field o has been set already
     */
    private boolean haso;

    /**
     * Discrete chart parameter.
     */
    private double w;

    /**
     * Keeps track of whether primitive field w has been set already
     */
    private boolean hasw;

    /**
     * Discrete chart parameter.
     */
    private double t;

    /**
     * Keeps track of whether primitive field t has been set already
     */
    private boolean hast;

    /**
     * Discrete chart parameter.
     */
    private double equinox;

    /**
     * Keeps track of whether primitive field equinox has been set
     * already.
     */
    private boolean hasequinox;

    public BodyParabolical() {
        super();
    }

    /**
     */
    public void deleteEquinox() {
        this.hasequinox= false;
    }

    /**
     */
    public void deleteI() {
        this.hasi= false;
    }

    /**
     */
    public void deleteO() {
        this.haso= false;
    }

    /**
     */
    public void deleteQ() {
        this.hasq= false;
    }

    /**
     */
    public void deleteT() {
        this.hast= false;
    }

    /**
     */
    public void deleteW() {
        this.hasw= false;
    }

    /**
     * Returns the value of field 'equinox'. The field 'equinox'
     * has the following description: Discrete chart parameter.
     * 
     * @return the value of field 'Equinox'.
     */
    public double getEquinox() {
        return this.equinox;
    }

    /**
     * Returns the value of field 'i'. The field 'i' has the
     * following description: Discrete chart parameter.
     * 
     * @return the value of field 'I'.
     */
    public double getI() {
        return this.i;
    }

    /**
     * Returns the value of field 'o'. The field 'o' has the
     * following description: Discrete chart parameter.
     * 
     * @return the value of field 'O'.
     */
    public double getO() {
        return this.o;
    }

    /**
     * Returns the value of field 'q'. The field 'q' has the
     * following description: Discrete chart parameter.
     * 
     * @return the value of field 'Q'.
     */
    public double getQ() {
        return this.q;
    }

    /**
     * Returns the value of field 't'. The field 't' has the
     * following description: Discrete chart parameter.
     * 
     * @return the value of field 'T'.
     */
    public double getT() {
        return this.t;
    }

    /**
     * Returns the value of field 'w'. The field 'w' has the
     * following description: Discrete chart parameter.
     * 
     * @return the value of field 'W'.
     */
    public double getW() {
        return this.w;
    }

    /**
     * Method hasEquinox.
     * 
     * @return true if at least one Equinox has been added
     */
    public boolean hasEquinox() {
        return this.hasequinox;
    }

    /**
     * Method hasI.
     * 
     * @return true if at least one I has been added
     */
    public boolean hasI() {
        return this.hasi;
    }

    /**
     * Method hasO.
     * 
     * @return true if at least one O has been added
     */
    public boolean hasO() {
        return this.haso;
    }

    /**
     * Method hasQ.
     * 
     * @return true if at least one Q has been added
     */
    public boolean hasQ() {
        return this.hasq;
    }

    /**
     * Method hasT.
     * 
     * @return true if at least one T has been added
     */
    public boolean hasT() {
        return this.hast;
    }

    /**
     * Method hasW.
     * 
     * @return true if at least one W has been added
     */
    public boolean hasW() {
        return this.hasw;
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
     * Sets the value of field 'equinox'. The field 'equinox' has
     * the following description: Discrete chart parameter.
     * 
     * @param equinox the value of field 'equinox'.
     */
    public void setEquinox(final double equinox) {
        this.equinox = equinox;
        this.hasequinox = true;
    }

    /**
     * Sets the value of field 'i'. The field 'i' has the following
     * description: Discrete chart parameter.
     * 
     * @param i the value of field 'i'.
     */
    public void setI(final double i) {
        this.i = i;
        this.hasi = true;
    }

    /**
     * Sets the value of field 'o'. The field 'o' has the following
     * description: Discrete chart parameter.
     * 
     * @param o the value of field 'o'.
     */
    public void setO(final double o) {
        this.o = o;
        this.haso = true;
    }

    /**
     * Sets the value of field 'q'. The field 'q' has the following
     * description: Discrete chart parameter.
     * 
     * @param q the value of field 'q'.
     */
    public void setQ(final double q) {
        this.q = q;
        this.hasq = true;
    }

    /**
     * Sets the value of field 't'. The field 't' has the following
     * description: Discrete chart parameter.
     * 
     * @param t the value of field 't'.
     */
    public void setT(final double t) {
        this.t = t;
        this.hast = true;
    }

    /**
     * Sets the value of field 'w'. The field 'w' has the following
     * description: Discrete chart parameter.
     * 
     * @param w the value of field 'w'.
     */
    public void setW(final double w) {
        this.w = w;
        this.hasw = true;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled org.chartacaeli.model.BodyParabolical
     */
    public static org.chartacaeli.model.BodyParabolical unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.chartacaeli.model.BodyParabolical) org.exolab.castor.xml.Unmarshaller.unmarshal(org.chartacaeli.model.BodyParabolical.class, reader);
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
