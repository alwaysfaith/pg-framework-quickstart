package com.sf.dao.mapper;

import com.sf.dao.model.TfSysRole;
import com.sf.core.mapper.MyMapper;

import java.util.List;

public interface TfSysRoleMapper extends MyMapper<TfSysRole> {

    List<String> queryRoleKeysByUserId(Long userId);

    List<String> queryAllRoleKeys();

}