package com.epe.etm;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(value = {"management.port=0"}, classes = EtmApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class Test {
	
	@org.junit.Test
	public void test() {
		System.out.println("test");
	}

}
