package com.ws.service;

public class EmployeeServiceImplProxy implements com.ws.service.EmployeeServiceImpl {
  private String _endpoint = null;
  private com.ws.service.EmployeeServiceImpl employeeServiceImpl = null;
  
  public EmployeeServiceImplProxy() {
    _initEmployeeServiceImplProxy();
  }
  
  public EmployeeServiceImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initEmployeeServiceImplProxy();
  }
  
  private void _initEmployeeServiceImplProxy() {
    try {
      employeeServiceImpl = (new com.ws.service.EmployeeServiceImplServiceLocator()).getEmployeeServiceImpl();
      if (employeeServiceImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)employeeServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)employeeServiceImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (employeeServiceImpl != null)
      ((javax.xml.rpc.Stub)employeeServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.ws.service.EmployeeServiceImpl getEmployeeServiceImpl() {
    if (employeeServiceImpl == null)
      _initEmployeeServiceImplProxy();
    return employeeServiceImpl;
  }
  
  public com.ws.model.Employee searchEmp(com.ws.model.Employee emp) throws java.rmi.RemoteException{
    if (employeeServiceImpl == null)
      _initEmployeeServiceImplProxy();
    return employeeServiceImpl.searchEmp(emp);
  }
  
  
}