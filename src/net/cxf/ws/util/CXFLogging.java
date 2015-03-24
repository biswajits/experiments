package net.cxf.ws.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.phase.Phase;

/*
 * CXF Interceptor Bean
 * 
 */

public class CXFLogging extends AbstractSoapInterceptor{
	
	public CXFLogging(){
		super(Phase.RECEIVE);
	}

	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		/*
		 * Getting SOAP XML
		 */
		InputStream is = message.getContent (InputStream.class);
		CachedOutputStream os = new CachedOutputStream();
		if(is != null){	
        	try {
        		IOUtils.copy ( is, os );
        		os.flush();
        		message.setContent (  InputStream.class, os.getInputStream());
        		System.out.println ("The request is: " + IOUtils.toString (os.getInputStream()));
        	} catch (IOException e) {
        		e.printStackTrace();
			}
        	finally{
        		try {
					is.close();
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
		}
	}
}
