package com.sdp.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class DemoControllerTest {

	@Autowired
	private DemoController demoController;

	@Test
	void smokeTest() {
		Assertions.assertThat(demoController).isNotNull();
	}

	@Test
	void homeHttpStatusTest() {
		final ResponseEntity<HostInfoSO>  homeResponse = demoController.home();
		Assertions.assertThat(homeResponse)
				.isNotNull()
				.hasFieldOrPropertyWithValue("statusCodeValue",200);
	}

}
