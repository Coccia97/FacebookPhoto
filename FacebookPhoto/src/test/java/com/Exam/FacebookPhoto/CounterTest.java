package com.Exam.FacebookPhoto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.Exam.FacebookPhoto.model.Counter;

class CounterTest {
	ArrayList<Counter> alc = new ArrayList<Counter>();
	Counter c1=null;
	Counter c2=null;
	Counter c3=null;
	Counter c4=null;

	@BeforeEach
	void setUp() throws Exception {
		
		
		alc.add(c1= new Counter("Marzo", 6));
		alc.add(c2= new Counter("Gennaio", 5));
		alc.add(c3= new Counter("Ottobre", 13));
		alc.add(c4= new Counter("Dicembre", 25));
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	@Test
	void test() {
		assertAll("parametri ", ()->assertEquals("Marzo",c1.getString()),
				()->assertEquals(6,c1.getCounter()));
		
	}
	
	@Test
	void testReturnMax() {
		assertEquals("Dicembre", Counter.ReturnMax(alc).getString());
		
	}

}
