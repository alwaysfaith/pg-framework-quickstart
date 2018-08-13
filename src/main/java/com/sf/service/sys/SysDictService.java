package com.sf.service.sys;

import com.sf.dao.mapper.TfSysDictMapper;
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
@CacheConfig(cacheNames = "cache_sys_dict")
public class SysDictService {

    @Autowired
    TfSysDictMapper tfSysDictMapper;

    public PageList<TfSysDict> list(TfSysDict tfSysDict, Pagination pg) {
        List<TfSysDict> list = tfSysDictMapper.queryList(tfSysDict, PageHelper.createRowBounds(pg));
        return PageHelper.buildPageList(list);
    }

    @Cacheable(key = "#dictKey")
    public List<TfSysDict> listByKey(String dictKey) {
        TfSysDict params = new TfSysDict();
        params.setDictKey(dictKey);
        params.setValidTag(true);
        Example example = new Example(TfSysDict.class);
        example.setOrderByClause("sort_no asc");
        example.createCriteria().andEqualTo("dictKey", dictKey)
                .andEqualTo("validTag", true);
        List<TfSysDict> list = tfSysDictMapper.selectByExample(example);

        return list;
    }

    @CacheEvict(key = "#tfSysDict.dictKey")
    public void add(TfSysDict tfSysDict) {
        TfSysDict params = new TfSysDict();
        params.setDictKey(tfSysDict.getDictKey());
        params.setDictValue(tfSysDict.getDictValue());
        params.setValidTag(true);
        if (isExists(params)) {
            throw new BusinessException("该字典已存在");
        }
        tfSysDict.setDictId(IdWorkerInstance.getId());
        tfSysDictMapper.insert(tfSysDict);
    }

    @CacheEvict(key = "#tfSysDict.dictKey")
    public void update(TfSysDict tfSysDict) {
        if (checkExistsForUpdate(tfSysDict.getDictId(), tfSysDict.getDictKey(), tfSysDict.getDictValue())) {
            throw new BusinessException("该字典已存在");
        }
        tfSysDictMapper.updateByPrimaryKeySelective(tfSysDict);
    }

    @CacheEvict(key = "#tfSysDict.dictKey")
    public void del(TfSysDict tfSysDict) {
        tfSysDictMapper.deleteByPrimaryKey(tfSysDict);
    }

    public TfSysDict get(Long dictId) {
        return tfSysDictMapper.selectByPrimaryKey(dictId);
    }

    public Boolean checkExistsForUpdate(Long dictId, String dictKey, String dictValue) {
        TfSysDict tfSysDict = new TfSysDict();
        tfSysDict.setDictValue(dictValue);
        tfSysDict.setDictKey(dictKey);

        List<TfSysDict> tfSysDictList = tfSysDictMapper.select(tfSysDict);
        for (TfSysDict tsd : tfSysDictList) {
            if (!tsd.getDictId().equals(dictId)) {
                return true;
            }
        }
        return false;
    }

    public Boolean isExists(TfSysDict tfSysDict) {
        return tfSysDictMapper.selectOne(tfSysDict) == null ? false : true;
    }

}
