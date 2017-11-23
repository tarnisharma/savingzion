package com.saving.zion.fishonindia.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutoSuggestionController {

	@RequestMapping("/getDestinations")
	public String getDestinations(@RequestParam(name="key") String key) {
		return key+"Tarni";
		
	}
}
