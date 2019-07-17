package com.conifer.health.configuration;

import java.util.HashMap;

import com.conifer.health.rules.AccountReceivableRule;
import com.conifer.health.rules.Addition;
import com.conifer.health.rules.AvailableBedsRule;
import com.conifer.health.rules.CleanClaimRule;
import com.conifer.health.rules.Command;
import com.conifer.health.rules.CompareParamRule;
import com.conifer.health.rules.DaysBetweenRule;
import com.conifer.health.rules.Division;
import com.conifer.health.rules.InclusiveExclusiveRule;
import com.conifer.health.rules.InpatientDaysRule;
import com.conifer.health.rules.Multiplication;
import com.conifer.health.rules.Percent;
import com.conifer.health.rules.CompareParamsRule;
import com.conifer.health.rules.Subtraction;
import com.conifer.health.rules.TotalAmountRule;
import com.conifer.health.rules.TotalClaimRule;
import com.conifer.health.rules.TotalCount;

public class CommandFactory {
	 static HashMap<String, Command> map = new HashMap<String, Command>();
	 static{
		 map.put("COMPARE_PARAM", new CompareParamRule());
		 map.put("COMPARE_PARAMS", new CompareParamsRule());
		 map.put("INCEXC", new InclusiveExclusiveRule());
		 map.put("ADDITION", new Addition());
		 map.put("SUBTRACTION", new Subtraction());
		 map.put("MULTIPLICATION", new Multiplication());
		 map.put("DIVISION", new Division());
		 map.put("PERCENTAGE", new Percent());
		 map.put("INPATIENTDAYSRULE", new InpatientDaysRule());
		 map.put("AVAILABLEBEDS", new AvailableBedsRule());
		 map.put("CLEANCLAIMRULE", new CleanClaimRule());
		 map.put("TOTALCLAIMSRULE", new TotalClaimRule());
		 map.put("COUNT", new TotalCount());
		 map.put("AMOUNT", new TotalAmountRule());
		 map.put("DAYS", new DaysBetweenRule());
		 map.put("ACCOUNTRECEIVABLERULE", new AccountReceivableRule());
	 }
	 public static Command getRule(String ruleName)
	 {
		return  map.get(ruleName);
		 
	 }
}
