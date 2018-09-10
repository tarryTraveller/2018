
package com.blog.service.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.mapper.SysUserMapperExt;
import com.blog.dao.model.SysUser;
import com.blog.dao.model.SysUserExample;
import com.blog.service.base.BaseService;

@Service
public class SysUserService extends BaseService {

	@Autowired
	private SysUserMapperExt sysUserMapperExt;

	public SysUser getByName(String username) {
		SysUserExample example = new SysUserExample();
		example.createCriteria().andUsernameEqualTo(username);
		List<SysUser> list = sysUserMapperExt.selectByExample(example);
		return list != null && list.size() > 0 ? list.get(0) : null;
	}
}
