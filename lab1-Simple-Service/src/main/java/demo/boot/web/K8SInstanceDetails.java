package demo.boot.web;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class K8SInstanceDetails {

	private static final String HOST_NAME = "HOSTNAME";

	private static final String DEFAULT_ENV_INSTANCE_GUID = "LOCAL";

	@Value("${" + HOST_NAME + ":" + DEFAULT_ENV_INSTANCE_GUID + "}")
	private String hostName;

	@GetMapping("/k8s/instance/details")
	public String retrieveInstanceInfo() throws UnknownHostException {
		//return hostName.substring(hostName.length()-5);
      return InetAddress.getLocalHost().getHostAddress();
	}
	
}
