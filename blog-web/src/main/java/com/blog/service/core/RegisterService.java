
package com.blog.service.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.mapper.SysUserMapperExt;
import com.blog.dao.model.SysUser;
import com.blog.dao.model.SysUserExample;
import com.blog.enums.common.YesNo;
import com.blog.service.base.BaseService;

@Service
public class RegisterService extends BaseService {

	@Autowired
	private SysUserMapperExt sysUserMapperExt;

	public boolean checkUserName(String userName) {
		SysUserExample example = new SysUserExample();
		example.createCriteria().andIsDeletedEqualTo(YesNo.NO.value).andUsernameEqualTo(userName);
		List<SysUser> list = sysUserMapperExt.selectByExample(example);
		if (list == null || list.size() == 0) {
			return true;
		}
		return false;
	}
}
