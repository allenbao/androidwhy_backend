package com.androidwhy.examples.showcase.webservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.androidwhy.examples.showcase.entity.User;
import com.androidwhy.examples.showcase.service.AccountEffectiveService;
import com.androidwhy.modules.mapper.BeanMapper;

@Controller
@RequestMapping(value = "/api/v1/user")
public class UserRestController {
	@Autowired
	private AccountEffectiveService accountService;

	@RequestMapping(value = "/{id}.xml", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public UserDTO getAsXml(@PathVariable("id") Long id) {
		User user = accountService.getUser(id);
		return bindDTO(user);
	}

	@RequestMapping(value = "/{id}.json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public UserDTO getAsJson(@PathVariable("id") Long id) {
		User user = accountService.getUser(id);
		return bindDTO(user);
	}

	private UserDTO bindDTO(User user) {
		UserDTO dto = BeanMapper.map(user, UserDTO.class);
		//补充Dozer不能自动绑定的属性
		dto.setTeamId(user.getTeam().getId());
		return dto;
	}
}
