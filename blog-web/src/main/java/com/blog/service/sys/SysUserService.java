
package com.blog.service.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.mapper.SysPermissionMapperExt;
import com.blog.dao.mapper.SysRoleMapperExt;
import com.blog.dao.mapper.SysUserMapperExt;
import com.blog.dao.model.SysPermission;
import com.blog.dao.model.SysRole;
import com.blog.dao.model.SysUser;
import com.blog.dao.model.SysUserExample;
import com.blog.enums.common.YesNo;
import com.blog.service.base.BaseService;

@Service
public class SysUserService extends BaseService {

	@Autowired
	private SysUserMapperExt sysUserMapperExt;
	@Autowired
	private SysRoleMapperExt sysRoleMapperExt;
	@Autowired
	private SysPermissionMapperExt sysPermissionMapperExt;

	public SysUser getByName(String username) {
		SysUserExample example = new SysUserExample();
		example.createCriteria().andIsDeletedEqualTo(YesNo.NO.value).andUsernameEqualTo(username);
		List<SysUser> list = sysUserMapperExt.selectByExample(example);
		return list != null && list.size() > 0 ? list.get(0) : null;
	}

	public List<SysRole> getRolesByUserId(String userId) {
		List<SysRole> list = sysRoleMapperExt.getRoleByUserId(userId);
		return list;
	}

	public List<SysPermission> getPermsByRoleId(String roleId) {
		List<SysPermission> list = sysPermissionMapperExt.getPermsByRoleId(roleId);
		return list;
	}
}
