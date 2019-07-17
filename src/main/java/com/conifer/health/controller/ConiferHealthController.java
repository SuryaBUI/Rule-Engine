package com.conifer.health.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.conifer.health.entity.RuleEntity;
import com.conifer.health.model.QueryResponse;
import com.conifer.health.rules.model.RequestRule;
import com.conifer.health.service.ConiferHealthService;




/*("/ConiferHealthApps")*/

@RestController
@RequestMapping("/ConiferHealthApps")
public class ConiferHealthController {

	@Autowired
	ConiferHealthService coniferHealthService; // Service which will do all data
												// retrieval/manipulation work
	//@Autowired
	//RuleService ruleService;

	// -------------------Retrieve All
	// HealthCareProvider--------------------------------------------------------
	final static Logger logger = Logger
			.getLogger(ConiferHealthController.class);

	@RequestMapping(value = "/healthCareRule", method = RequestMethod.POST, produces = { "application/json" })
	public ArrayList<QueryResponse> healthCareRule(
			@RequestBody List<RequestRule> ruleList) {
		logger.info("HealthCareRuleModel-------" + ruleList);
		ArrayList<QueryResponse> response = coniferHealthService
				.healthCareRule(ruleList);

		return response;
	}
/*	//@PostMapping(value="/addrule")
	@RequestMapping(value = "/addrule", method = RequestMethod.POST, produces = { "application/json" })
	public void addNewRule(@RequestBody RuleEntity ruleEntity)
	{
		logger.info("bipin muddule-------");
		ruleService.addRule(ruleEntity);
		System.out.println("table created");
	}
	
	
	@RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
	public void deleteRule(@PathVariable long id)
	{
		ruleService.deleteRule(id);
	}
	@RequestMapping(method=RequestMethod.PUT, value="/edit/{id}")
	public void updateRule(@RequestBody RuleEntity ruleEntity)
	{
		ruleService.updateRule(ruleEntity);
	}*/
}
