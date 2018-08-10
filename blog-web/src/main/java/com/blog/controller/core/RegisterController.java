
package com.blog.controller.core;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("register")
public class RegisterController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String register() {
		// TODO
		return "register/register";
	}

	// 点击显示《法律声明和隐私权政策》
	@RequestMapping(value = "item", method = RequestMethod.GET)
	public String showItem() {
		return "register/register_item";
	}
}
