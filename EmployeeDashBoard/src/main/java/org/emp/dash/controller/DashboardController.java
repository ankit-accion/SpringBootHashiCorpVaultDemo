package org.emp.dash.controller;

import javax.naming.ServiceUnavailableException;

import org.emp.dash.service.DiscoveryServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

@RestController
@RequestMapping(path = "/dashboard")
public class DashboardController {

	@Autowired
	private DiscoveryServiceClient client;

	@GetMapping(path = "/all")
	public String getAllEmployee() throws RestClientException, ServiceUnavailableException {
		return client.getRestTemplate("/all");
	}

}
