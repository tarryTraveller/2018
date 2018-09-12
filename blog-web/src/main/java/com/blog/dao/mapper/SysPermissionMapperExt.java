
package com.blog.dao.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.blog.dao.model.SysPermission;

@Repository
public interface SysPermissionMapperExt extends SysPermissionMapper {
	List<SysPermission> getPermsByRoleId(String roleId);
}