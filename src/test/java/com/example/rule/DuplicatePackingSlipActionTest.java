package com.example.rule;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.entities.Royalty;
import com.example.service.PackagingService;

@RunWith(MockitoJUnitRunner.class)
public class DuplicatePackingSlipActionTest {
	private DuplicatePackingSlipAction action;
	
	@Mock
	private PackagingService service;

	@Before
	public void setUp() throws Exception {
		action = new DuplicatePackingSlipAction(service);
	}

	@Test
	public void shouldExecuteAction() {
		Royalty royalty = new Royalty();
		
		action.execute(royalty);
		
		verify(service, times(1)).generateDuplicateSlip(royalty);
		verifyNoMoreInteractions(service);
	}
}
