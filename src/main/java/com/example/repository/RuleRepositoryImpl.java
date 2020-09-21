package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import com.example.enums.ProductCategory;
import com.example.enums.ProductSubCategory;
import com.example.rule.ActivateMembershipAction;
import com.example.rule.CommissionPaymentAction;
import com.example.rule.DuplicatePackingSlipAction;
import com.example.rule.EmailAction;
import com.example.rule.FreeProductAction;
import com.example.rule.PackingSlipAction;
import com.example.rule.ProductCategoryCondition;
import com.example.rule.ProductNameCondition;
import com.example.rule.ProductSubCategoryCondition;
import com.example.rule.Rule;
import com.example.rule.RuleImpl;
import com.example.rule.RuleNamespace;
import com.example.rule.UpgradeMembershipAction;
import com.example.service.MembershipService;
import com.example.service.NotificationService;
import com.example.service.PackagingService;
import com.example.service.PaymentService;

@Repository
public class RuleRepositoryImpl implements RuleRepository {
	@Autowired
	private ApplicationContext context;

	@Override
	public List<Rule> findByNamespace(RuleNamespace namespace) {
		List<Rule> ruleList = new ArrayList<>();

		ruleList.add(new RuleImpl.Builder().ofNamespace(RuleNamespace.PAYMENT)
				.addCondition(new ProductCategoryCondition(ProductCategory.PHYSICAL_PRODUCT))
				.addAction(new PackingSlipAction(context.getBean(PackagingService.class)))
				.addAction(new CommissionPaymentAction(context.getBean(PaymentService.class))).build());

		ruleList.add(new RuleImpl.Builder().ofNamespace(RuleNamespace.PAYMENT)
				.addCondition(new ProductSubCategoryCondition(ProductSubCategory.BOOK))
				.addAction(new DuplicatePackingSlipAction(context.getBean(PackagingService.class)))
				.addAction(new CommissionPaymentAction(context.getBean(PaymentService.class))).build());

		ruleList.add(new RuleImpl.Builder().ofNamespace(RuleNamespace.PAYMENT)
				.addCondition(new ProductCategoryCondition(ProductCategory.MEMBERSHIP))
				.addAction(new ActivateMembershipAction(context.getBean(MembershipService.class)))
				.addAction(new EmailAction(context.getBean(NotificationService.class))).build());

		ruleList.add(new RuleImpl.Builder().ofNamespace(RuleNamespace.PAYMENT)
				.addCondition(new ProductSubCategoryCondition(ProductSubCategory.MEMBERSHIP_UPGRADE))
				.addAction(new UpgradeMembershipAction(context.getBean(MembershipService.class)))
				.addAction(new EmailAction(context.getBean(NotificationService.class))).build());
		
		ruleList.add(new RuleImpl.Builder().ofNamespace(RuleNamespace.PAYMENT)
				.addCondition(new ProductSubCategoryCondition(ProductSubCategory.VIDEO))
				.addCondition(new ProductNameCondition("Learning to Ski,"))
				.addAction(new FreeProductAction(context.getBean(PackagingService.class))).build());

		return ruleList;
	}
}