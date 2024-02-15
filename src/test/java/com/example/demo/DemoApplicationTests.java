package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat; // Import assertThat from AssertJ


class DemoApplicationTests {

	Calculator calculator=new Calculator();
	@Test
	void itShouldAddNumber() {
		int a=10;
		int b=20;

		int result = calculator.sum(a, b);
		assertThat(result).isEqualTo(300);
	}

}

class Calculator{
	
	public int sum(int a,int b){
		return a+b;
	}

}
