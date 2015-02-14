/**
 * EmployeeServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ws.service;

public class EmployeeServiceImplServiceLocator extends org.apache.axis.client.Service implements com.ws.service.EmployeeServiceImplService {

    public EmployeeServiceImplServiceLocator() {
    }


    public EmployeeServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public EmployeeServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for EmployeeServiceImpl
    private java.lang.String EmployeeServiceImpl_address = "http://localhost:8080/WSTest/services/EmployeeServiceImpl";

    public java.lang.String getEmployeeServiceImplAddress() {
        return EmployeeServiceImpl_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String EmployeeServiceImplWSDDServiceName = "EmployeeServiceImpl";

    public java.lang.String getEmployeeServiceImplWSDDServiceName() {
        return EmployeeServiceImplWSDDServiceName;
    }

    public void setEmployeeServiceImplWSDDServiceName(java.lang.String name) {
        EmployeeServiceImplWSDDServiceName = name;
    }

    public com.ws.service.EmployeeServiceImpl getEmployeeServiceImpl() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(EmployeeServiceImpl_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getEmployeeServiceImpl(endpoint);
    }

    public com.ws.service.EmployeeServiceImpl getEmployeeServiceImpl(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.ws.service.EmployeeServiceImplSoapBindingStub _stub = new com.ws.service.EmployeeServiceImplSoapBindingStub(portAddress, this);
            _stub.setPortName(getEmployeeServiceImplWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setEmployeeServiceImplEndpointAddress(java.lang.String address) {
        EmployeeServiceImpl_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.ws.service.EmployeeServiceImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                com.ws.service.EmployeeServiceImplSoapBindingStub _stub = new com.ws.service.EmployeeServiceImplSoapBindingStub(new java.net.URL(EmployeeServiceImpl_address), this);
                _stub.setPortName(getEmployeeServiceImplWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("EmployeeServiceImpl".equals(inputPortName)) {
            return getEmployeeServiceImpl();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.ws.com", "EmployeeServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.ws.com", "EmployeeServiceImpl"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("EmployeeServiceImpl".equals(portName)) {
            setEmployeeServiceImplEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
