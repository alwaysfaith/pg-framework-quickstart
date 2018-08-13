package com.sf.dao.mapper;

import com.sf.dao.model.TfSysMenu;
import com.sf.core.mapper.MyMapper;
import java.util.List;
import org.apache.ibatis.session.RowBounds;

public interface TfSysMenuMapper extends MyMapper<TfSysMenu> {
    /**
     * list
     * @param tfSysMenu
     * @param rowBounds
     * @return
     */
    List<TfSysMenu> queryList(TfSysMenu tfSysMenu, RowBounds rowBounds);
}