package demo2;

import java.math.BigInteger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Demo2Application.class)
//@WebAppConfiguration
public class Demo2ApplicationTests {

	private static BigInteger nextId ;
	@Test
	public void contextLoads() {
		nextId = nextId.valueOf(0);
		nextId = nextId.add(BigInteger.ONE);
	}

}
