package com.person.springboot.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="spring-cloud-producer",fallback=HelloRemoteHystrix.class)
public interface HelloRemote {

	@GetMapping(value = "/hello")
	public String index(@RequestParam(value="name") String name);
}
