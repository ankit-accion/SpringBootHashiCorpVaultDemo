package org.emp.dash.service;

import javax.naming.ServiceUnavailableException;

import org.springframework.web.client.RestClientException;

public interface DiscoveryServiceClient {

	String getRestTemplate(String API) throws RestClientException, ServiceUnavailableException;

}