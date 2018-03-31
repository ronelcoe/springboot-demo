package com.springboot.demo.hello;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping(value="/hello", method = RequestMethod.GET)
	public String hi() {
		String canonicalHost = "", hostName = "", hostAddress = "";
		try {
			hostName = InetAddress.getLocalHost().getHostName();
			hostAddress = InetAddress.getLocalHost().getHostAddress();
			canonicalHost = InetAddress.getLocalHost().getCanonicalHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return "hi from this machine. <br/>HostName: " + hostName + 
				"<br/>HostAddress: " + hostAddress +
				"<br/>CanonicalHostName: " + canonicalHost;
	}
}
