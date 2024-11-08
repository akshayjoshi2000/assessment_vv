package org.magnifi;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import PageObjects.LoginPage;
import PageObjects.DashboardPage;
import PageObjects.VideosPage;
import PageObjects.AllClipsPage;
import PageObjects.EditPage;


public class AppTest extends App {
	
	
	public AppTest(){
		super();
	}
	
	@BeforeTest
	void settingup() {
		initialization();
	}
	
	@Test
	void testing() throws InterruptedException {
		LoginPage homepage = new LoginPage();
		DashboardPage VideoPage = new DashboardPage();
		VideosPage Video = new VideosPage();
		AllClipsPage AllVideos = new AllClipsPage();
		EditPage EditVideos = new EditPage();


		homepage.Login();
		VideoPage.ClickOnVideo();
		Video.SelectVideoThumbnail();
		AllVideos.SelectVideoThumbnailToEdit();
		EditVideos.TrimVideo();

	}

	@AfterClass
	void reset(){
		DashboardPage VideoPage = new DashboardPage();
		VideoPage.GoToDashboard();
	}
	
	@AfterTest
	void closure() {
		driver.quit();
	}

}

