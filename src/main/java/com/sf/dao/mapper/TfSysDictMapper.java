package com.sf.dao.mapper;

import com.sf.core.mapper.MyMapper;
import com.sf.dao.model.TfSysDict;
import org.apache.ibatis.session.RowBounds;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface TfSysDictMapper extends MyMapper<TfSysDict> {
    /**
     * @param tfSysDict
     * @param rowBounds
     * @return
     */
    List<TfSysDict> queryList(TfSysDict tfSysDict, RowBounds rowBounds);

}