
package com.blog.controller.core;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blog.controller.base.BaseController;

@Controller
@RequestMapping("login")
public class LoginController extends BaseController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String toLogin() {
		return "login/login";
	}
}
