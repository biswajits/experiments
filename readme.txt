#################### WSDL URL ###################

http://localhost:8080/SpringWS/endpoints/AccountDetailsService.wsdl
###################################

######################  Resource Url ####################
http://www.beingjavaguys.com/2013/04/create-spring-web-services-using-maven.html
http://spring-webservice-2-step-by-step.blogspot.in/2011/12/spring-web-services-20-step-by-step.html
http://briansjavablog.blogspot.in/2013/01/spring-web-services-tutorial.html
https://github.com/briansjavablog/spring-webservices-tutorial/blob/master/src/main/webapp/WEB-INF/web.xml
http://briansjavablog.blogspot.in/2013/01/spring-web-services-tutorial.html?m=1
http://codereq.com/web-service-using-spring/
http://www.javabeat.net/introduction-to-spring-web-services/
http://www.beingjavaguys.com/2013/04/spring-endpointhttps://spring.io/guides/gs/producing-web-service/-annotation-example.html
https://github.com/spring-projects/spring-ws-samples
http://examples.javacodegeeks.com/enterprise-java/jws/jax-ws-spring-integration-example/
http://javahash.com/spring-web-services-soap-services-tutorial/

###################  STEPS ######################

1. create the schema file(AccountDetails.xsd) and then create operation details schema (input/output) file(AccountDetailsServiceOperations.xsd).
   then right click on the "AccountDetailsServiceOperations.xsd" file go-to "Generate" option and click on "Jaxb classes".
   
2. this will generate some classes and DTO classes which you defined in "AccountDetails.xsd".
   now create a Interface(AccountService) for your operation and define your method.
   
3. Now create a implementation class(AccountServiceImpl) of previously define Interface(AccountService) and define 
   "@Service" annotation on top the class as we are using Spring(this class going to handle all our service operation).
   
   		@Service
		public class AccountServiceImpl implements AccountService {
   
4. Create a Endpoint class(AccountServiceEndpoint) and define "@Endpoint" annotation on top of class.
   define a method to publish as web service 
   
   		@Endpoint
		public class AccountServiceEndpoint {
		private static final String TARGET_NAMESPACE = "http://org/example/accountservice";  
		@Autowired
		private AccountService accountService;
	
		@PayloadRoot(localPart="AccountDetailsRequest", namespace=TARGET_NAMESPACE)
		public @ResponsePayload AccountDetailsResponse getAccountDetails(@RequestPayload AccountDetailsRequest request){
		
5.  Now create a Spring Config file(spring-config.xml) and define your operation XSD(AccountDetailsServiceOperations.xsd),
	portName, serviceName, locationUri.
	
		<context:component-scan base-package="org.example" />
		<web-services:annotation-driven />
		<!-- Our test service bean -->
		<bean id="AccountDetailsService"
			class="org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition"
			lazy-init="true">
			<property name="schemaCollection">
				<bean class="org.springframework.xml.xsd.commons.CommonsXsdSchemaCollection">
					<property name="inline" value="true" />
					<property name="xsds">
						<list>
							<value>schemas/AccountDetailsServiceOperations.xsd</value>
						</list>
					</property>
				</bean>
			</property>
			<property name="portTypeName" value="AccountDetailsService" />
			<property name="serviceName" value="AccountDetailsServices" />
			<property name="locationUri" value="/endpoints" />
		</bean>
		
6. Now define Spring Config file(spring-config.xml) location and url-pattern in "web.xml".

		<context-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>
				/WEB-INF/config/spring-config.xml
			</param-value>
		</context-param>
		<!-- Loads the Spring web application context, using the files defined above. -->
		<listener>
			<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
		</listener>
		<!-- Define the Spring WS Servlet. The 'transformWsldLocations' param means 
			that any WSDLs generated are context-aware and contain the correct path to 
			their exposed port types. The 'contextConfigLocation' param with an empty 
			value means that the Spring context won't try to load a file called webservices-servlet.xml -->
		<servlet>
			<servlet-name>webservices</servlet-name>
			<servlet-class>org.springframework.ws.transport.http.MessageDispatcherServlet</servlet-class>
			<init-param>
				<param-name>transformWsdlLocations</param-name>
				<param-value>true</param-value>
			</init-param>
			<init-param>
				<param-name>contextConfigLocation</param-name>
				<param-value></param-value>
			</init-param>
			<load-on-startup>1</load-on-startup>
		</servlet>
		<servlet-mapping>
			<servlet-name>webservices</servlet-name>
			<url-pattern>*.wsdl</url-pattern>
		</servlet-mapping>
		<servlet-mapping>
			<servlet-name>webservices</servlet-name>
			<url-pattern>/endpoints/*</url-pattern>
		</servlet-mapping>
		
######################################################################## 