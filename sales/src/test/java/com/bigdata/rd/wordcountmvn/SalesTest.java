package com.bigdata.rd.wordcountmvn;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class SalesTest extends TestCase {
	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public SalesTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(SalesTest.class);
	}

	/**
	 * Rigourous Test :-)
	 * @throws IOException 
	 */
	public void testApp() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/test.txt")));
		String line = reader.readLine();
		for (String w:line.split("\t")) {
			System.out.println(w);
		} 
		assertTrue(true);
	}
}
