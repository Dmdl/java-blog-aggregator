package com.lakmal.jba.service;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.lakmal.jba.entity.Item;
import com.lakmal.jba.exception.RssException;

import junit.framework.TestCase;

public class RssServiceTest extends TestCase {

	private RssService rssservice;

	@Before
	protected void setUp() throws Exception {
		rssservice = new RssService();
	}

	@Test
	public void testGetItemsFile() throws RssException {
		List<Item> items = rssservice
				.getItems(new File("test-rss/javavids.xml"));
		assertEquals(10, items.size());
	}

}
