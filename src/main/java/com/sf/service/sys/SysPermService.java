package com.sf.service.sys;

import com.sf.dao.mapper.TfSysPermMapper;
import com.sf.dao.mapper.TfSysUserPermMapper;
import com.sf.dao.mapper.ThSysPermMapper;
import com.sf.dao.model.TfSysPerm;
import com.sf.dao.model.TfSysUserPerm;
import com.sf.dao.model.ThSysPerm;
import com.sf.idworker.generator.IdWorkerInstance;
import com.sf.pg.constant.OperEnum;
import com.sf.pg.core.mybatis.util.PageHelper;
import com.sf.pg.core.mybatis.util.OperUtils;
import com.sf.pg.entity.PageList;
import com.sf.pg.entity.Pagination;
import com.sf.pg.security.auth.shiro.ShiroCacheHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author: lijie.zh
 */
@Slf4j
@Service
public class SysPermService {

    @Autowired
    TfSysPermMapper tfSysPermMapper;

    @Autowired
    ThSysPermMapper thSysPermMapper;

    @Autowired
    TfSysUserPermMapper tfSysUserPermMapper;

    public PageList<TfSysPerm> list(TfSysPerm tfSysPerm, Pagination pg) {
        List<TfSysPerm> list = tfSysPermMapper.queryList(tfSysPerm, PageHelper.createRowBounds(pg));
        return PageHelper.buildPageList(list);
    }

    public TfSysPerm get(Long id) {
        TfSysPerm tfSysPerm = tfSysPermMapper.selectByPrimaryKey(id);
        return tfSysPerm;
    }

    @Transactional(rollbackFor = Exception.class)
    public void addSysPerm(TfSysPerm tfSysPerm) {
        tfSysPerm.setPermId(IdWorkerInstance.getId());
        tfSysPermMapper.insert(tfSysPerm);
        if (null != tfSysPerm) {
            //同步添加到历史表
            ThSysPerm thSysPerm = OperUtils.bulidHistoryObject(tfSysPerm, ThSysPerm.class, OperEnum.CREATE.getValue());
            thSysPermMapper.insert(thSysPerm);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateSysPerm(TfSysPerm tfSysPerm) {
        tfSysPermMapper.updateByPrimaryKeySelective(tfSysPerm);
        TfSysPerm tsp = tfSysPermMapper.selectByPrimaryKey(tfSysPerm.getPermId());
        if (null != tsp) {
            //添加到历史表
            ThSysPerm thSysPerm = OperUtils.bulidHistoryObject(tfSysPerm, ThSysPerm.class, OperEnum.UPDATE.getValue());
            thSysPermMapper.insert(thSysPerm);
        }
        //更新权限缓存
        ShiroCacheHelper.clearAllCachedAuthorizationInfo();
    }

    @Transactional(rollbackFor = Exception.class)
    public void del(Long permId) {
        TfSysPerm tfSysPerm = tfSysPermMapper.selectByPrimaryKey(permId);
        if (null != tfSysPerm) {
            //添加历史表
            ThSysPerm thSysPerm = OperUtils.bulidHistoryObject(tfSysPerm, ThSysPerm.class, OperEnum.DELETE.getValue());
            thSysPermMapper.insert(thSysPerm);
        }
        //删除主表
        tfSysPermMapper.deleteByPrimaryKey(permId);
        //更新权限缓存
        ShiroCacheHelper.clearAllCachedAuthorizationInfo();
    }

    @Transactional(rollbackFor = Exception.class)
    public void assignUserToPerm(TfSysUserPerm tfSysUserPerm) {
        if (!isExists(tfSysUserPerm)) {
            tfSysUserPermMapper.insert(tfSysUserPerm);
        }
        //更新该用户权限缓存
        ShiroCacheHelper.clearCachedAuthenticationInfo(tfSysUserPerm.getUserId());
    }

    @Transactional(rollbackFor = Exception.class)
    public void outUserInPerm(TfSysUserPerm tfSysUserPerm) {
        tfSysUserPermMapper.deleteByPrimaryKey(tfSysUserPerm);
        //更新该用户权限缓存
        ShiroCacheHelper.clearCachedAuthenticationInfo(tfSysUserPerm.getUserId());
    }

    /**
     * 校验权限编码是否存在（新增时使用）
     * @param permCode
     * @return
     */
    public Boolean checkExistsPermCodeForAdd(String permCode) {
        if (StringUtils.isEmpty(permCode)) {
            return false;
        }
        TfSysPerm tfSysPerm = new TfSysPerm();
        tfSysPerm.setPermCode(permCode);

        return tfSysPermMapper.selectOne(tfSysPerm) == null ? false : true;
    }

    /**
     * 校验权限编码是否存在（修改时使用）
     * @param permCode
     * @param permId
     * @return
     */
    public Boolean checkExistsPermCodeForUpdate(String permCode, Long permId) {
        if (StringUtils.isEmpty(permCode)) {
            return false;
        }
        TfSysPerm tfSysPerm = new TfSysPerm();
        tfSysPerm.setPermCode(permCode);

        List<TfSysPerm> tfSysPermList = tfSysPermMapper.select(tfSysPerm);
        for (TfSysPerm tsp : tfSysPermList) {
            if (!tsp.getPermId().equals(permId)) {
                return true;
            }
        }
        return false;
    }

    public Boolean isExists(TfSysUserPerm tfSysUserPerm) {
        return tfSysUserPermMapper.selectOne(tfSysUserPerm) == null ? false : true;
    }

}
