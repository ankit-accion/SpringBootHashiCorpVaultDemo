package org.emp.dash.service.impl;

import java.net.URI;
import java.util.Optional;

import javax.naming.ServiceUnavailableException;

import org.emp.dash.service.DiscoveryServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class DiscoveryClientServiceImpl implements DiscoveryServiceClient {

	@Autowired
	private DiscoveryClient discoveryClient;

	private Optional<URI> serviceUrl() {
		return discoveryClient.getInstances("EmpMngmt").stream().map(si -> si.getUri()).findFirst();
	}

	private URI getURI(String API) throws ServiceUnavailableException {
		URI uri = serviceUrl().map(s -> s.resolve(API)).orElseThrow(ServiceUnavailableException::new);
		return uri;
	}

	@Override
	public String getRestTemplate(String API) throws RestClientException, ServiceUnavailableException {
		URI serviceURI = getURI("/employee" + API);
		return getRestTemplate().getForEntity(serviceURI, String.class).getBody();
	}

	@Bean
	private RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
