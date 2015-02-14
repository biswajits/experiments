package com.ws.service;

public class PerosnServiceImplProxy implements com.ws.service.PerosnServiceImpl {
  private String _endpoint = null;
  private com.ws.service.PerosnServiceImpl perosnServiceImpl = null;
  
  public PerosnServiceImplProxy() {
    _initPerosnServiceImplProxy();
  }
  
  public PerosnServiceImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initPerosnServiceImplProxy();
  }
  
  private void _initPerosnServiceImplProxy() {
    try {
      perosnServiceImpl = (new com.ws.service.PerosnServiceImplServiceLocator()).getPerosnServiceImpl();
      if (perosnServiceImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)perosnServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)perosnServiceImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (perosnServiceImpl != null)
      ((javax.xml.rpc.Stub)perosnServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.ws.service.PerosnServiceImpl getPerosnServiceImpl() {
    if (perosnServiceImpl == null)
      _initPerosnServiceImplProxy();
    return perosnServiceImpl;
  }
  
  public com.ws.model.Person searchPerson(com.ws.model.Person per) throws java.rmi.RemoteException{
    if (perosnServiceImpl == null)
      _initPerosnServiceImplProxy();
    return perosnServiceImpl.searchPerson(per);
  }
  
  
}