package com.example.rule;

import com.example.entities.Royalty;
import com.example.service.PackagingService;

public class DuplicatePackingSlipAction implements Action<Royalty> {
	private final PackagingService service;
	
	public DuplicatePackingSlipAction(PackagingService service) {
		this.service = service;
	}
	
	@Override
	public void execute(Royalty royalty) {
		this.service.generateDuplicateSlip(royalty);
	}
}