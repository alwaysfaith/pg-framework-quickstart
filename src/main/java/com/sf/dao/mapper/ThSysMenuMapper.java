package com.sf.dao.mapper;

import com.sf.dao.model.ThSysMenu;
import com.sf.core.mapper.MyMapper;
import java.util.List;
import org.apache.ibatis.session.RowBounds;

public interface ThSysMenuMapper extends MyMapper<ThSysMenu> {
    /**
     * list
     * @param thSysMenu
     * @param rowBounds
     * @return
     */
    List<ThSysMenu> queryList(ThSysMenu thSysMenu, RowBounds rowBounds);
}