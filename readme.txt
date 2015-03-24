****************** WSDL URL ********************
http://localhost:8080/CXFWebService/services/bookshelfservice?wsdl

**************************************************


reference link : 
http://www.ibm.com/developerworks/library/j-jws12/
http://www.javacodegeeks.com/2013/06/developing-soap-web-service-using-apache-cxf.html
https://web-gmazza.rhcloud.com/blog/entry/web-service-tutorial
http://www.javabeat.net/developing-a-web-service-with-cxf/


##################################  Steps  ###########################################

1. create the DTO(net.cxf.ws.dto.Book)
		@XmlRootElement(name="Book")
		public class Book implements Serializable{ 
		
2. create endpoint Interface(net.cxf.ws.service.BookselfService)
		@WebService  
		public interface BookSelfService {
	
		@WebMethod
		public Book getBookDetails(String id);
	Define @WebService annotation on top of class and @WebMethod on top of each method which you want to publish as web service.
	
3. now create a implementation class of "BookSelfService"(net.cxf.ws.service.BookSelfServiceImpl)
		@WebService(endpointInterface="net.cxf.ws.service.BookSelfService",portName="bookPort", targetNamespace="http://ws.cxf.net/", serviceName="bookShelfService")
		public class BookSelfServiceImpl implements BookSelfService {

		@Override
		public Book getBookDetails(String id) {
	Define @WebService annotation on top of class with "endpointInterface", "portName", "targetNamespace", "serviceName".
	
4. create a Spring config file(WEB-INF/beans.xml)
		<import resource="classpath:META-INF/cxf/cxf.xml" />
	<!-- <import resource="classpath:META-INF/cxf/cxf-extension-soap.xml" /> -->
		<import resource="classpath:META-INF/cxf/cxf-servlet.xml" />

		<jaxws:endpoint id="bookShelfService"
		implementor="net.cxf.ws.service.BookSelfServiceImpl"
		address="/bookshelfservice" />	
		
5. Now open "web.xml" file and add following lines
		<servlet>
			<description>Apache CXF Endpoint</description>
			<display-name>cxf</display-name>
			<servlet-name>cxf</servlet-name>
			<servlet-class>org.apache.cxf.transport.servlet.CXFServlet</servlet-class>
			<load-on-startup>1</load-on-startup>
		</servlet>
		<servlet-mapping>
			<servlet-name>cxf</servlet-name>
			<url-pattern>/services/*</url-pattern>
		</servlet-mapping>
		<session-config>
			<session-timeout>60</session-timeout>
		</session-config>
		<context-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>WEB-INF/beans.xml</param-value>
		</context-param>
		<listener>
			<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
		</listener>
		
#######################################################################################

######################  CXF Interceptor ##########################

       interceptor bean in bean.xml----> <bean id="cxfInterceptor" class="net.cxf.ws.util.CXFLogging"/>
       
       interceptor config in bean.xml 
       			<cxf:bus>
					<cxf:inInterceptors>
						<ref bean="cxfInterceptor"/>
					</cxf:inInterceptors>
				</cxf:bus>
				
		
	