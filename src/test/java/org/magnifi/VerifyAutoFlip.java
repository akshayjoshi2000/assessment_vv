package org.magnifi;

import PageObjects.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class VerifyAutoFlip extends App {


	public VerifyAutoFlip(){
		super();
	}

	
	@Test
	void testing() throws InterruptedException {

		DashboardPage VideoPage = new DashboardPage();
		VideosPage Video = new VideosPage();
		AllClipsPage AllVideos = new AllClipsPage();
		EditPage EditVideos = new EditPage();

		VideoPage.ClickOnVideo();
		Video.SelectVideoThumbnail();
		AllVideos.SelectAutoFlipOption();
		EditVideos.FlipClip();
	}
	
	@AfterTest
	void closure() {
		driver.quit();
	}

}

