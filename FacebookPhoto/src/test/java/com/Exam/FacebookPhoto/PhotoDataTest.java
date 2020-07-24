package com.Exam.FacebookPhoto;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.Exam.FacebookPhoto.model.PhotoData;
import org.junit.jupiter.api.Assertions;
/**
 * 
 * classe di test della classe PhotoData
 * 
 * @author Andrea Marcheggiani
 * @author Francesco Columbaro
 *
 */
public class PhotoDataTest {

	private PhotoData pd1 = null;

	@Before
	public void setUp() throws Exception {
		pd1 = new PhotoData(6, "Marzo", 1997, "Giovedì", "123456");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals(6, pd1.getDay());
		assertEquals("Marzo", pd1.getMonth());
		assertEquals(1997, pd1.getYear());
		assertEquals("Giovedì", pd1.getDayName());
		assertEquals("123456", pd1.getId());
		
	}

}
