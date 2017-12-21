package com.boot.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
class ShipwrekController {

	@RequestMapping(value = "shipwreks", method = RequestMethod.GET)
	public String list() {
		return "List";
	}
	
	@RequestMapping(value = "shipwreks", method = RequestMethod.POST)
	public String create(@RequestBody String shipwrek) {
		return "POST " + shipwrek;
	}
	
	@RequestMapping(value = "shipwreks/{id}", method = RequestMethod.GET)
	public String get(@PathVariable long id) {
		return "GET " + id;
	}
	

	@RequestMapping(value = "shipwreks/{id}", method = RequestMethod.PUT)
	public String put(@PathVariable long id, @RequestBody String shipwrek) {
		return "PUT " + id + " " + shipwrek;
	}
	
	@RequestMapping(value = "shipwreks/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable long id) {
		return "DELETE " + id;
	}
}
