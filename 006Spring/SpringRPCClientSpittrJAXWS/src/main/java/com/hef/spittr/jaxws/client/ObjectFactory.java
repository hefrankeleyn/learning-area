
package com.hef.spittr.jaxws.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.hef.spittr.jaxws.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FindSpitterById_QNAME = new QName("http://jaxws.remoting.spittr.hef.com/", "findSpitterById");
    private final static QName _SaveSpitterResponse_QNAME = new QName("http://jaxws.remoting.spittr.hef.com/", "saveSpitterResponse");
    private final static QName _FindSpitterByIdResponse_QNAME = new QName("http://jaxws.remoting.spittr.hef.com/", "findSpitterByIdResponse");
    private final static QName _SaveSpitter_QNAME = new QName("http://jaxws.remoting.spittr.hef.com/", "saveSpitter");
    private final static QName _FindAllSpittersResponse_QNAME = new QName("http://jaxws.remoting.spittr.hef.com/", "findAllSpittersResponse");
    private final static QName _FindAllSpitters_QNAME = new QName("http://jaxws.remoting.spittr.hef.com/", "findAllSpitters");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.hef.spittr.jaxws.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindAllSpitters }
     * 
     */
    public FindAllSpitters createFindAllSpitters() {
        return new FindAllSpitters();
    }

    /**
     * Create an instance of {@link FindAllSpittersResponse }
     * 
     */
    public FindAllSpittersResponse createFindAllSpittersResponse() {
        return new FindAllSpittersResponse();
    }

    /**
     * Create an instance of {@link FindSpitterByIdResponse }
     * 
     */
    public FindSpitterByIdResponse createFindSpitterByIdResponse() {
        return new FindSpitterByIdResponse();
    }

    /**
     * Create an instance of {@link SaveSpitter }
     * 
     */
    public SaveSpitter createSaveSpitter() {
        return new SaveSpitter();
    }

    /**
     * Create an instance of {@link SaveSpitterResponse }
     * 
     */
    public SaveSpitterResponse createSaveSpitterResponse() {
        return new SaveSpitterResponse();
    }

    /**
     * Create an instance of {@link FindSpitterById }
     * 
     */
    public FindSpitterById createFindSpitterById() {
        return new FindSpitterById();
    }

    /**
     * Create an instance of {@link Spitter }
     * 
     */
    public Spitter createSpitter() {
        return new Spitter();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindSpitterById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.remoting.spittr.hef.com/", name = "findSpitterById")
    public JAXBElement<FindSpitterById> createFindSpitterById(FindSpitterById value) {
        return new JAXBElement<FindSpitterById>(_FindSpitterById_QNAME, FindSpitterById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveSpitterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.remoting.spittr.hef.com/", name = "saveSpitterResponse")
    public JAXBElement<SaveSpitterResponse> createSaveSpitterResponse(SaveSpitterResponse value) {
        return new JAXBElement<SaveSpitterResponse>(_SaveSpitterResponse_QNAME, SaveSpitterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindSpitterByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.remoting.spittr.hef.com/", name = "findSpitterByIdResponse")
    public JAXBElement<FindSpitterByIdResponse> createFindSpitterByIdResponse(FindSpitterByIdResponse value) {
        return new JAXBElement<FindSpitterByIdResponse>(_FindSpitterByIdResponse_QNAME, FindSpitterByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveSpitter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.remoting.spittr.hef.com/", name = "saveSpitter")
    public JAXBElement<SaveSpitter> createSaveSpitter(SaveSpitter value) {
        return new JAXBElement<SaveSpitter>(_SaveSpitter_QNAME, SaveSpitter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllSpittersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.remoting.spittr.hef.com/", name = "findAllSpittersResponse")
    public JAXBElement<FindAllSpittersResponse> createFindAllSpittersResponse(FindAllSpittersResponse value) {
        return new JAXBElement<FindAllSpittersResponse>(_FindAllSpittersResponse_QNAME, FindAllSpittersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllSpitters }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.remoting.spittr.hef.com/", name = "findAllSpitters")
    public JAXBElement<FindAllSpitters> createFindAllSpitters(FindAllSpitters value) {
        return new JAXBElement<FindAllSpitters>(_FindAllSpitters_QNAME, FindAllSpitters.class, null, value);
    }

}
