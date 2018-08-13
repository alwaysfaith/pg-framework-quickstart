package com.sf.service.sys;

import com.sf.dao.mapper.TfSysMenuMapper;
import com.sf.dao.mapper.ThSysMenuMapper;
import com.sf.dao.model.TfSysMenu;
import com.sf.dao.model.ThSysMenu;
import com.sf.idworker.generator.IdWorkerInstance;
import com.sf.pg.constant.OperEnum;
import com.sf.pg.core.mybatis.util.OperUtils;
import com.sf.pg.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.util.StringUtil;

/**
 * @author: lijie.zh
 */
@Slf4j
@Service
public class SysMenuService {

    @Autowired
    TfSysMenuMapper tfSysMenuMapper;

    @Autowired
    ThSysMenuMapper thSysMenuMapper;

    @Transactional(rollbackFor = Exception.class)
    public void addSysMenu(TfSysMenu tfSysMenu) {
        tfSysMenu.setMenuId(IdWorkerInstance.getId());
        tfSysMenu.setPermId(tfSysMenu.getMenuId());
        tfSysMenu.setSortNo(tfSysMenu.getMenuId());
        tfSysMenu.setMenuFrame(getMenuFrame(tfSysMenu.getParentMenuId()) + tfSysMenu.getMenuId());
        tfSysMenuMapper.insert(tfSysMenu);
        if (null != tfSysMenu) {
            //同步添加到历史表
            ThSysMenu thSysMenu = OperUtils.bulidHistoryObject(tfSysMenu, ThSysMenu.class, OperEnum.CREATE.getValue());
            thSysMenuMapper.insert(thSysMenu);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateSysMenu(TfSysMenu tfSysMenu) {
        tfSysMenu.setMenuFrame(getMenuFrame(tfSysMenu.getMenuId()) + tfSysMenu.getMenuId());
        tfSysMenuMapper.updateByPrimaryKeySelective(tfSysMenu);
        TfSysMenu tsp = tfSysMenuMapper.selectByPrimaryKey(tfSysMenu.getMenuId());
        if (null != tsp) {
            //添加到历史表
            ThSysMenu thSysMenu = OperUtils.bulidHistoryObject(tfSysMenu, ThSysMenu.class, OperEnum.UPDATE.getValue());
            thSysMenuMapper.insert(thSysMenu);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void delSysMenu(Long permId) {
        TfSysMenu tfSysMenu = tfSysMenuMapper.selectByPrimaryKey(permId);
        if (null != tfSysMenu) {
            //添加历史表
            ThSysMenu thSysMenu = OperUtils.bulidHistoryObject(tfSysMenu, ThSysMenu.class, OperEnum.DELETE.getValue());
            thSysMenuMapper.insert(thSysMenu);
        }
        //删除主表
        tfSysMenuMapper.deleteByPrimaryKey(permId);
    }

    private String getMenuFrame(Long menuId) {
        if (0 == menuId) {
            return "";
        }
        TfSysMenu tfSysMenu = tfSysMenuMapper.selectByPrimaryKey(menuId);
        if (null == tfSysMenu) {
            return "";
        }
        String menuFrame = tfSysMenu.getMenuFrame();
        if (StringUtil.isEmpty(menuFrame)) {
            return "";
        } else {
            menuFrame += ",";
        }
        return menuFrame;
    }

}
