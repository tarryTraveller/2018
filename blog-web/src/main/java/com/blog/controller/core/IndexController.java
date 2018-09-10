
package com.blog.controller.core;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blog.controller.base.BaseController;

@Controller
@RequestMapping("index")
public class IndexController extends BaseController {

	// 首页
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
}
