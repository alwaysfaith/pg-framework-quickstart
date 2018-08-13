package com.sf.dao.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tf_sys_dict")
public class TfSysDict implements Serializable {
    @Id
    @Column(name = "DICT_ID")
    private Long dictId;

    /**
     * 字典KEY
     */
    @Column(name = "DICT_KEY")
    private String dictKey;

    /**
     * 字典值
     */
    @Column(name = "DICT_VALUE")
    private String dictValue;

    /**
     * 字典文字
     */
    @Column(name = "DICT_TEXT")
    private String dictText;

    /**
     * 排序
     */
    @Column(name = "SORT_NO")
    private Integer sortNo;

    /**
     * 有效标识：0-无效，1-有效
     */
    @Column(name = "VALID_TAG")
    private Boolean validTag;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 创建人
     */
    @Column(name = "CREATE_BY")
    private String createBy;

    /**
     * 更新时间
     */
    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    /**
     * 更新人
     */
    @Column(name = "UPDATE_BY")
    private String updateBy;

    private static final long serialVersionUID = 1L;

    /**
     * @return DICT_ID
     */
    public Long getDictId() {
        return dictId;
    }

    /**
     * @param dictId
     */
    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }

    /**
     * 获取字典KEY
     *
     * @return DICT_KEY - 字典KEY
     */
    public String getDictKey() {
        return dictKey;
    }

    /**
     * 设置字典KEY
     *
     * @param dictKey 字典KEY
     */
    public void setDictKey(String dictKey) {
        this.dictKey = dictKey;
    }

    /**
     * 获取字典值
     *
     * @return DICT_VALUE - 字典值
     */
    public String getDictValue() {
        return dictValue;
    }

    /**
     * 设置字典值
     *
     * @param dictValue 字典值
     */
    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    /**
     * 获取字典文字
     *
     * @return DICT_TEXT - 字典文字
     */
    public String getDictText() {
        return dictText;
    }

    /**
     * 设置字典文字
     *
     * @param dictText 字典文字
     */
    public void setDictText(String dictText) {
        this.dictText = dictText;
    }

    /**
     * 获取排序
     *
     * @return SORT_NO - 排序
     */
    public Integer getSortNo() {
        return sortNo;
    }

    /**
     * 设置排序
     *
     * @param sortNo 排序
     */
    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    /**
     * 获取有效标识：0-无效，1-有效
     *
     * @return VALID_TAG - 有效标识：0-无效，1-有效
     */
    public Boolean getValidTag() {
        return validTag;
    }

    /**
     * 设置有效标识：0-无效，1-有效
     *
     * @param validTag 有效标识：0-无效，1-有效
     */
    public void setValidTag(Boolean validTag) {
        this.validTag = validTag;
    }

    /**
     * 获取创建时间
     *
     * @return CREATE_TIME - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取创建人
     *
     * @return CREATE_BY - 创建人
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人
     *
     * @param createBy 创建人
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取更新时间
     *
     * @return UPDATE_TIME - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取更新人
     *
     * @return UPDATE_BY - 更新人
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新人
     *
     * @param updateBy 更新人
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
}