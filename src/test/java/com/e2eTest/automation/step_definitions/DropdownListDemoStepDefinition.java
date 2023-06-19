package com.e2eTest.automation.step_definitions;

import com.e2eTest.automation.page_objects.DropdownListDemoPage;
import com.e2eTest.automation.utils.ConfigFileReader;
import com.e2eTest.automation.utils.SelectFromListUtils;
import com.e2eTest.automation.utils.SeleniumUtils;
import com.e2eTest.automation.utils.Validations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DropdownListDemoStepDefinition {

	public DropdownListDemoPage dropdownlistdemoPage;
	public ConfigFileReader configFileReader;
	public SeleniumUtils utils;
	public SelectFromListUtils select;
    public Validations validation;


	public DropdownListDemoStepDefinition() {
		dropdownlistdemoPage = new DropdownListDemoPage();
		configFileReader = new ConfigFileReader();
		utils = new SeleniumUtils();
		select = new SelectFromListUtils();
		validation = new Validations();
	}

	@Given("Je me connecte sur l application DropDownListDemo")
	public void jeMeConnecteSurLApplicationDropDownListDemo() {
		utils.get(configFileReader.getProperties("home.url.dropdownlistdemo"));

	}

	@When("je sélectionne une option par son index")
	public void jeSélectionneUneOptionParSonIndex() {
		select.selectDropDownListByIndex(dropdownlistdemoPage.selectmenu,4);
	}

	@Then("l option correspondante est sélectionnée")
	public void lOptionCorrespondanteEstSélectionnée() throws InterruptedException {
		//Thread.sleep(3000);
//validation.assertEquals(dropdownlistdemoPage.PURPLE,configFileReader.getProperties("home.index"));

//validation.assertEquals(dropdownlistdemoPage.Black,configFileReader.getProperties("home.value"));
	validation.assertEquals(dropdownlistdemoPage.Red,configFileReader.getProperties("home.visibleText"));


	}
	

	@When("je sélectionne une option par sa valeur")
	public void jeSélectionneUneOptionParSaValeur() {

		select.selectDropDownListByValue(dropdownlistdemoPage.selectmenu,"6");

	}
	

	@When("je sélectionne une option par son visibleText")
	public void jeSélectionneUneOptionParSonVisibleText() {
	   select.selectDropDownListByVisibleText(dropdownlistdemoPage.selectmenu, "Red");
	}






}