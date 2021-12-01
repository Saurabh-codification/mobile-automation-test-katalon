package com.apiDemoApp

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.time.Duration
import java.time.Instant

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.appmanagement.AndroidInstallApplicationOptions
import io.appium.java_client.android.appmanagement.AndroidRemoveApplicationOptions

class ApplicationUtils {

	@Keyword
	def installApp(String appPath) {
		getCurrentSessionAndroidMobileDriver().installApp(appPath, new AndroidInstallApplicationOptions().withReplaceEnabled())
	}

	@Keyword
	def boolean isAppInstalled(String appId) {
		getCurrentSessionAndroidMobileDriver().isAppInstalled(appId)
	}

	@Keyword
	def removeApp(String appId) {
		getCurrentSessionAndroidMobileDriver().removeApp(appId, new AndroidRemoveApplicationOptions().withKeepDataEnabled())
	}

	@Keyword
	def launchApp() {

		getCurrentSessionAndroidMobileDriver().launchApp()
	}

	@Keyword
	def runAppInBackgroud(int durationInSeconds) {

		Duration duration = Duration.ofSeconds(durationInSeconds)
		
		getCurrentSessionAndroidMobileDriver().runAppInBackground(duration)
	}

	@Keyword
	def activateApp(String appId) {

		getCurrentSessionAndroidMobileDriver().activateApp(appId)
	}

	@Keyword
	def AndroidDriver getCurrentSessionAndroidMobileDriver() {
		return (AndroidDriver) MobileDriverFactory.getDriver();
	}

	@Keyword
	def resetApp() {
		getCurrentSessionAndroidMobileDriver().resetApp();
	}


	@Keyword
	def lockDevice(int durationInSeconds) {
		getCurrentSessionAndroidMobileDriver().lockDevice(Duration.ofSeconds(durationInSeconds))
	}
	
	@Keyword
	def lockDevice() {
		getCurrentSessionAndroidMobileDriver().lockDevice()
	}
}
