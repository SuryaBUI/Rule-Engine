package com.conifer.health.service;

import java.util.ArrayList;
import java.util.List;

import com.conifer.health.model.QueryResponse;
import com.conifer.health.rules.model.RequestRule;

public interface ConiferHealthService {
	ArrayList<QueryResponse> healthCareRule(List<RequestRule> ruleList);

}
