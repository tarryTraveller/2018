
package com.blog.controller.map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blog.controller.base.BaseController;

@Controller
@RequestMapping("/map")
public class MapController extends BaseController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showMap() {
		return "map/map";
	}
}
