package com.mm.configclient;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class GreetingController {
	


 @Value("${my:default value}") private String smg;

	  @Value("some  static string") private String staticGreting;

	@Value("${my.list.values}")
	 private List<String> values;
	
	
	 // @Value("#{${dbvalue}}") 
	 // private Map<String,String> dbvalues;
	 
	
	@Autowired
	private DbSettings dbsetting;
	
	@GetMapping("/greeting")
	 public String greeting() {
		return smg+staticGreting+values+dbsetting.getConnection()+dbsetting.getHost();
	}

}
