package com.conifer.health.service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conifer.health.configuration.CommandFactory;
import com.conifer.health.dao.PatientDao;
import com.conifer.health.model.QueryResponse;
import com.conifer.health.rules.Command;
import com.conifer.health.entity.BillingInformation;
import com.conifer.health.entity.Claims;
import com.conifer.health.entity.Demographic;
import com.conifer.health.entity.Patient;
import com.conifer.health.rules.model.RequestRule;
//import com.conifer.health.util.HibernateUtil;

@Service("coniferHealthService")
public class ConiferHealthServiceImpl implements ConiferHealthService {
	
	final static Logger logger = Logger
			.getLogger(ConiferHealthServiceImpl.class);
	
	 @Autowired
	 private PatientDao patientDao;

	public ArrayList<QueryResponse> healthCareRule(List<RequestRule> ruleList) {

		Collections.sort(ruleList);

		HashMap<String, ArrayList<Patient>> results = new HashMap<>();
		/*
		 * JSONParser parser = new JSONParser(); ObjectMapper mapper = new
		 * ObjectMapper(); Object obj; Resource resource = new
		 * ClassPathResource("patient_db.json"); ArrayList<Patient> listofPerson
		 * = new ArrayList<Patient>();
		 */
		ArrayList<QueryResponse> response = new ArrayList<QueryResponse>();
		
		
		ArrayList<Patient> listofPerson  =patientDao.findAllPatients();
		//@SuppressWarnings("unchecked")		
		//ArrayList<Patient> listofPerson  = (ArrayList<Patient>)HibernateUtil.getSession().createQuery("from Patient").list();

				try {
			/*
			 * byte[] bdata =
			 * FileCopyUtils.copyToByteArray(resource.getInputStream()); String
			 * data = new String(bdata, StandardCharsets.UTF_8); obj =
			 * parser.parse(data); JSONObject jsonObject = (JSONObject) obj;
			 * JSONArray patients = (JSONArray) jsonObject.get("patient");
			 * 
			 * for (Object patient : patients) { Patient person =
			 * mapper.readValue(patient.toString(), Patient.class);
			 * listofPerson.add(person); }
			 */
			HashMap<String, String> specialOutputs = new HashMap<String, String>();
			
			results.put(ruleList.get(0).getFacts()[0], listofPerson);
			for (int i = 0; i < ruleList.size(); i++) {

				// if (jsonObject.toJSONString().contains("patient")) {

				Rules rules = new Rules();
				Facts facts = new Facts();

				String ruleName = ruleList.get(i).getRuleName();
				String ruleOperation = ruleList.get(i).getRuleOperation();

				logger.info("ruleName" + ruleName);
				facts.put("rule", ruleList.get(i));
				facts.put("factList", ruleList.get(i).getFacts());
				facts.put("results", results);
				facts.put("specialOutputs", specialOutputs);
				Command rule = CommandFactory.getRule(ruleOperation);
				rules.register(rule);

				RulesEngine rulesEngine = new DefaultRulesEngine();
				rulesEngine.fire(rules, facts);
				if (ruleList.get(i).isShowOutput()) {
					QueryResponse queryResponse = new QueryResponse();
					Set<String> keySet = specialOutputs.keySet();
					for (String key : keySet) {
						if (key.contains(ruleName)) {
							queryResponse.setKey(key);
							queryResponse.setValue(specialOutputs.get(key));
						}
					}
					response.add(queryResponse);
				}
				// } else
				// System.out.println("Not an valid POJO");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}



	
}
