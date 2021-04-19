package de.tekup.loan.invoke.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import de.tekup.loan.invoke.client.service.SoapClient;
import de.tekup.loan.soap.api.consume.loaneligebilty.*;

@Controller
public class CheckController {
	
	@Autowired
	private SoapClient client;
	
	@GetMapping("/check/customer")
	public String customerForm(Model model) {
		CustomerRequest request = new CustomerRequest();
		model.addAttribute("request",request);
		return "request";
	}
	
	@PostMapping("/check/customer")
	public String webServiceResponse(@ModelAttribute("request") CustomerRequest request, Model model) {
		WsResponse response = client.getLoanStatus(request);
		model.addAttribute("response",response);
		return "response";
	}

}
