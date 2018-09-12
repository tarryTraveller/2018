
package com.blog.dao.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.blog.dao.model.SysRole;

@Repository
public interface SysRoleMapperExt extends SysRoleMapper {
	public List<SysRole> getRoleByUserId(String userId);
}