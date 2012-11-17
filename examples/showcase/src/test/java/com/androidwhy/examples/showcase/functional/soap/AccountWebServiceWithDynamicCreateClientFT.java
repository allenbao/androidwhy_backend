package com.androidwhy.examples.showcase.functional.soap;

import static org.junit.Assert.*;

import javax.xml.ws.BindingProvider;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import com.androidwhy.examples.showcase.functional.BaseFunctionalTestCase;
import com.androidwhy.examples.showcase.webservice.soap.AccountSoapService;
import com.androidwhy.examples.showcase.webservice.soap.response.GetTeamDetailResult;
import com.androidwhy.modules.test.category.Smoke;

/**
 * AccountService Web服务的功能测试, 测试主要的接口调用.
 * 
 * 以用JAXWS的API, 根据AccountWebService接口自行创建.
 * 
 * 集中在Team相关接口.
 * 
 * @author Gordon
 */
public class AccountWebServiceWithDynamicCreateClientFT extends BaseFunctionalTestCase {

	public AccountSoapService creatClient() {
		String address = baseUrl + "/cxf/soap/accountservice";

		JaxWsProxyFactoryBean proxyFactory = new JaxWsProxyFactoryBean();
		proxyFactory.setAddress(address);
		proxyFactory.setServiceClass(AccountSoapService.class);
		AccountSoapService accountWebServiceProxy = (AccountSoapService) proxyFactory.create();

		//(可选)演示重新设定endpoint address.
		((BindingProvider) accountWebServiceProxy).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				address);

		//(可选)演示重新设定Timeout时间
		Client client = ClientProxy.getClient(accountWebServiceProxy);
		HTTPConduit conduit = (HTTPConduit) client.getConduit();
		HTTPClientPolicy policy = conduit.getClient();
		policy.setReceiveTimeout(600000);

		return accountWebServiceProxy;
	}

	/**
	 * 测试搜索用户
	 */
	@Test
	@Category(Smoke.class)
	public void getTeamDetail() {
		AccountSoapService accountWebService = creatClient();

		GetTeamDetailResult result = accountWebService.getTeamDetail(1L);
		assertEquals("Dolphin", result.getTeam().getName());
		assertEquals("Admin", result.getTeam().getMaster().getName());
	}
}
