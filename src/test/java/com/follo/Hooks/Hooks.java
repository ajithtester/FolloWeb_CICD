package com.follo.Hooks;

import com.follo.baseclass.Baseclass;

import io.cucumber.java.After;
import report.ReportConfig;

public class Hooks extends Baseclass {

	@After
	public void ScreenShot() throws Throwable {

		
		Wait(2000);
		ReportConfig.ReportCooldown();

	}

}
