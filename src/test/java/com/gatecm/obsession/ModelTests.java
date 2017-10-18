package com.gatecm.obsession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gatecm.obsession.dto.ModelTreeDTO;
import com.gatecm.obsession.service.MemberService;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModelTests extends TestCase {

	@Autowired
	private MemberService memberService;

	@Test
	public void ShiroLogin() {
		String phoneNumber = "15688745645";
		ModelTreeDTO modelTreeDTO = memberService.getModelTreeByPhoneNumber(phoneNumber);
		modelTreeDTO.print("     ");
	}

}
