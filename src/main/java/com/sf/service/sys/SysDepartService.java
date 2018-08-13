package com.sf.service.sys;

import com.sf.dao.mapper.TfSysDepartMapper;
import com.sf.dao.mapper.TfSysDictMapper;
import com.sf.dao.model.TfSysDepart;
import com.sf.dao.model.TfSysDict;
import com.sf.idworker.generator.IdWorkerInstance;
import com.sf.pg.core.mybatis.util.PageHelper;
import com.sf.pg.entity.PageList;
import com.sf.pg.entity.Pagination;
import com.sf.pg.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author: lijie.zh
 */
@Slf4j
@Service
public class SysDepartService {

    @Autowired
    TfSysDepartMapper tfSysDepartMapper;

    public List<TfSysDepart> list(TfSysDepart tfSysDepart) {
        List<TfSysDepart> list = tfSysDepartMapper.select(tfSysDepart);
        return list;
    }

}
