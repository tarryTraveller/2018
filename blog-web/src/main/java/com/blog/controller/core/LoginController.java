
package com.blog.controller.core;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	@RequestMapping(value = "error", method = RequestMethod.GET)
	public String checkLogin() {
		return "403";
	}

	@RequestMapping(value = "check", method = RequestMethod.POST)
	public String loginUser(String username, String password, Model model) {
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(usernamePasswordToken); // 完成登录
			String username2 = (String) subject.getPrincipal();
			model.addAttribute("username2", username2);
			return "redirect:/index";
		} catch (UnknownAccountException e) {
			model.addAttribute("errorUserName", "用户不存在");
			return "login/login";// 返回登录页面
		} catch (IncorrectCredentialsException e) {
			model.addAttribute("errorCode", "密码输入错误");
			return "login/login";// 返回登录页面
		} catch (Exception e) {
			// e.printStackTrace();
			return "login/login";// 返回登录页面
		}

	}
}
