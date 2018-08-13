package com.sf.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ThSysMenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ThSysMenuExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andOperIdIsNull() {
            addCriterion("OPER_ID is null");
            return (Criteria) this;
        }

        public Criteria andOperIdIsNotNull() {
            addCriterion("OPER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOperIdEqualTo(Long value) {
            addCriterion("OPER_ID =", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdNotEqualTo(Long value) {
            addCriterion("OPER_ID <>", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdGreaterThan(Long value) {
            addCriterion("OPER_ID >", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdGreaterThanOrEqualTo(Long value) {
            addCriterion("OPER_ID >=", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdLessThan(Long value) {
            addCriterion("OPER_ID <", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdLessThanOrEqualTo(Long value) {
            addCriterion("OPER_ID <=", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdIn(List<Long> values) {
            addCriterion("OPER_ID in", values, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdNotIn(List<Long> values) {
            addCriterion("OPER_ID not in", values, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdBetween(Long value1, Long value2) {
            addCriterion("OPER_ID between", value1, value2, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdNotBetween(Long value1, Long value2) {
            addCriterion("OPER_ID not between", value1, value2, "operId");
            return (Criteria) this;
        }

        public Criteria andOperTypeIsNull() {
            addCriterion("OPER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andOperTypeIsNotNull() {
            addCriterion("OPER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOperTypeEqualTo(String value) {
            addCriterion("OPER_TYPE =", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeNotEqualTo(String value) {
            addCriterion("OPER_TYPE <>", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeGreaterThan(String value) {
            addCriterion("OPER_TYPE >", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeGreaterThanOrEqualTo(String value) {
            addCriterion("OPER_TYPE >=", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeLessThan(String value) {
            addCriterion("OPER_TYPE <", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeLessThanOrEqualTo(String value) {
            addCriterion("OPER_TYPE <=", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeLike(String value) {
            addCriterion("OPER_TYPE like", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeNotLike(String value) {
            addCriterion("OPER_TYPE not like", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeIn(List<String> values) {
            addCriterion("OPER_TYPE in", values, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeNotIn(List<String> values) {
            addCriterion("OPER_TYPE not in", values, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeBetween(String value1, String value2) {
            addCriterion("OPER_TYPE between", value1, value2, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeNotBetween(String value1, String value2) {
            addCriterion("OPER_TYPE not between", value1, value2, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTimeIsNull() {
            addCriterion("OPER_TIME is null");
            return (Criteria) this;
        }

        public Criteria andOperTimeIsNotNull() {
            addCriterion("OPER_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andOperTimeEqualTo(Date value) {
            addCriterion("OPER_TIME =", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeNotEqualTo(Date value) {
            addCriterion("OPER_TIME <>", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeGreaterThan(Date value) {
            addCriterion("OPER_TIME >", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("OPER_TIME >=", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeLessThan(Date value) {
            addCriterion("OPER_TIME <", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeLessThanOrEqualTo(Date value) {
            addCriterion("OPER_TIME <=", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeIn(List<Date> values) {
            addCriterion("OPER_TIME in", values, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeNotIn(List<Date> values) {
            addCriterion("OPER_TIME not in", values, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeBetween(Date value1, Date value2) {
            addCriterion("OPER_TIME between", value1, value2, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeNotBetween(Date value1, Date value2) {
            addCriterion("OPER_TIME not between", value1, value2, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperByIsNull() {
            addCriterion("OPER_BY is null");
            return (Criteria) this;
        }

        public Criteria andOperByIsNotNull() {
            addCriterion("OPER_BY is not null");
            return (Criteria) this;
        }

        public Criteria andOperByEqualTo(String value) {
            addCriterion("OPER_BY =", value, "operBy");
            return (Criteria) this;
        }

        public Criteria andOperByNotEqualTo(String value) {
            addCriterion("OPER_BY <>", value, "operBy");
            return (Criteria) this;
        }

        public Criteria andOperByGreaterThan(String value) {
            addCriterion("OPER_BY >", value, "operBy");
            return (Criteria) this;
        }

        public Criteria andOperByGreaterThanOrEqualTo(String value) {
            addCriterion("OPER_BY >=", value, "operBy");
            return (Criteria) this;
        }

        public Criteria andOperByLessThan(String value) {
            addCriterion("OPER_BY <", value, "operBy");
            return (Criteria) this;
        }

        public Criteria andOperByLessThanOrEqualTo(String value) {
            addCriterion("OPER_BY <=", value, "operBy");
            return (Criteria) this;
        }

        public Criteria andOperByLike(String value) {
            addCriterion("OPER_BY like", value, "operBy");
            return (Criteria) this;
        }

        public Criteria andOperByNotLike(String value) {
            addCriterion("OPER_BY not like", value, "operBy");
            return (Criteria) this;
        }

        public Criteria andOperByIn(List<String> values) {
            addCriterion("OPER_BY in", values, "operBy");
            return (Criteria) this;
        }

        public Criteria andOperByNotIn(List<String> values) {
            addCriterion("OPER_BY not in", values, "operBy");
            return (Criteria) this;
        }

        public Criteria andOperByBetween(String value1, String value2) {
            addCriterion("OPER_BY between", value1, value2, "operBy");
            return (Criteria) this;
        }

        public Criteria andOperByNotBetween(String value1, String value2) {
            addCriterion("OPER_BY not between", value1, value2, "operBy");
            return (Criteria) this;
        }

        public Criteria andMenuIdIsNull() {
            addCriterion("MENU_ID is null");
            return (Criteria) this;
        }

        public Criteria andMenuIdIsNotNull() {
            addCriterion("MENU_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMenuIdEqualTo(Long value) {
            addCriterion("MENU_ID =", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotEqualTo(Long value) {
            addCriterion("MENU_ID <>", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThan(Long value) {
            addCriterion("MENU_ID >", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThanOrEqualTo(Long value) {
            addCriterion("MENU_ID >=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThan(Long value) {
            addCriterion("MENU_ID <", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThanOrEqualTo(Long value) {
            addCriterion("MENU_ID <=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdIn(List<Long> values) {
            addCriterion("MENU_ID in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotIn(List<Long> values) {
            addCriterion("MENU_ID not in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdBetween(Long value1, Long value2) {
            addCriterion("MENU_ID between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotBetween(Long value1, Long value2) {
            addCriterion("MENU_ID not between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andParentMenuIdIsNull() {
            addCriterion("PARENT_MENU_ID is null");
            return (Criteria) this;
        }

        public Criteria andParentMenuIdIsNotNull() {
            addCriterion("PARENT_MENU_ID is not null");
            return (Criteria) this;
        }

        public Criteria andParentMenuIdEqualTo(Long value) {
            addCriterion("PARENT_MENU_ID =", value, "parentMenuId");
            return (Criteria) this;
        }

        public Criteria andParentMenuIdNotEqualTo(Long value) {
            addCriterion("PARENT_MENU_ID <>", value, "parentMenuId");
            return (Criteria) this;
        }

        public Criteria andParentMenuIdGreaterThan(Long value) {
            addCriterion("PARENT_MENU_ID >", value, "parentMenuId");
            return (Criteria) this;
        }

        public Criteria andParentMenuIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PARENT_MENU_ID >=", value, "parentMenuId");
            return (Criteria) this;
        }

        public Criteria andParentMenuIdLessThan(Long value) {
            addCriterion("PARENT_MENU_ID <", value, "parentMenuId");
            return (Criteria) this;
        }

        public Criteria andParentMenuIdLessThanOrEqualTo(Long value) {
            addCriterion("PARENT_MENU_ID <=", value, "parentMenuId");
            return (Criteria) this;
        }

        public Criteria andParentMenuIdIn(List<Long> values) {
            addCriterion("PARENT_MENU_ID in", values, "parentMenuId");
            return (Criteria) this;
        }

        public Criteria andParentMenuIdNotIn(List<Long> values) {
            addCriterion("PARENT_MENU_ID not in", values, "parentMenuId");
            return (Criteria) this;
        }

        public Criteria andParentMenuIdBetween(Long value1, Long value2) {
            addCriterion("PARENT_MENU_ID between", value1, value2, "parentMenuId");
            return (Criteria) this;
        }

        public Criteria andParentMenuIdNotBetween(Long value1, Long value2) {
            addCriterion("PARENT_MENU_ID not between", value1, value2, "parentMenuId");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNull() {
            addCriterion("MENU_NAME is null");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNotNull() {
            addCriterion("MENU_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andMenuNameEqualTo(String value) {
            addCriterion("MENU_NAME =", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotEqualTo(String value) {
            addCriterion("MENU_NAME <>", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThan(String value) {
            addCriterion("MENU_NAME >", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThanOrEqualTo(String value) {
            addCriterion("MENU_NAME >=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThan(String value) {
            addCriterion("MENU_NAME <", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThanOrEqualTo(String value) {
            addCriterion("MENU_NAME <=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLike(String value) {
            addCriterion("MENU_NAME like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotLike(String value) {
            addCriterion("MENU_NAME not like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameIn(List<String> values) {
            addCriterion("MENU_NAME in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotIn(List<String> values) {
            addCriterion("MENU_NAME not in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameBetween(String value1, String value2) {
            addCriterion("MENU_NAME between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotBetween(String value1, String value2) {
            addCriterion("MENU_NAME not between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuDescIsNull() {
            addCriterion("MENU_DESC is null");
            return (Criteria) this;
        }

        public Criteria andMenuDescIsNotNull() {
            addCriterion("MENU_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andMenuDescEqualTo(String value) {
            addCriterion("MENU_DESC =", value, "menuDesc");
            return (Criteria) this;
        }

        public Criteria andMenuDescNotEqualTo(String value) {
            addCriterion("MENU_DESC <>", value, "menuDesc");
            return (Criteria) this;
        }

        public Criteria andMenuDescGreaterThan(String value) {
            addCriterion("MENU_DESC >", value, "menuDesc");
            return (Criteria) this;
        }

        public Criteria andMenuDescGreaterThanOrEqualTo(String value) {
            addCriterion("MENU_DESC >=", value, "menuDesc");
            return (Criteria) this;
        }

        public Criteria andMenuDescLessThan(String value) {
            addCriterion("MENU_DESC <", value, "menuDesc");
            return (Criteria) this;
        }

        public Criteria andMenuDescLessThanOrEqualTo(String value) {
            addCriterion("MENU_DESC <=", value, "menuDesc");
            return (Criteria) this;
        }

        public Criteria andMenuDescLike(String value) {
            addCriterion("MENU_DESC like", value, "menuDesc");
            return (Criteria) this;
        }

        public Criteria andMenuDescNotLike(String value) {
            addCriterion("MENU_DESC not like", value, "menuDesc");
            return (Criteria) this;
        }

        public Criteria andMenuDescIn(List<String> values) {
            addCriterion("MENU_DESC in", values, "menuDesc");
            return (Criteria) this;
        }

        public Criteria andMenuDescNotIn(List<String> values) {
            addCriterion("MENU_DESC not in", values, "menuDesc");
            return (Criteria) this;
        }

        public Criteria andMenuDescBetween(String value1, String value2) {
            addCriterion("MENU_DESC between", value1, value2, "menuDesc");
            return (Criteria) this;
        }

        public Criteria andMenuDescNotBetween(String value1, String value2) {
            addCriterion("MENU_DESC not between", value1, value2, "menuDesc");
            return (Criteria) this;
        }

        public Criteria andUrlPerfixIsNull() {
            addCriterion("URL_PERFIX is null");
            return (Criteria) this;
        }

        public Criteria andUrlPerfixIsNotNull() {
            addCriterion("URL_PERFIX is not null");
            return (Criteria) this;
        }

        public Criteria andUrlPerfixEqualTo(String value) {
            addCriterion("URL_PERFIX =", value, "urlPerfix");
            return (Criteria) this;
        }

        public Criteria andUrlPerfixNotEqualTo(String value) {
            addCriterion("URL_PERFIX <>", value, "urlPerfix");
            return (Criteria) this;
        }

        public Criteria andUrlPerfixGreaterThan(String value) {
            addCriterion("URL_PERFIX >", value, "urlPerfix");
            return (Criteria) this;
        }

        public Criteria andUrlPerfixGreaterThanOrEqualTo(String value) {
            addCriterion("URL_PERFIX >=", value, "urlPerfix");
            return (Criteria) this;
        }

        public Criteria andUrlPerfixLessThan(String value) {
            addCriterion("URL_PERFIX <", value, "urlPerfix");
            return (Criteria) this;
        }

        public Criteria andUrlPerfixLessThanOrEqualTo(String value) {
            addCriterion("URL_PERFIX <=", value, "urlPerfix");
            return (Criteria) this;
        }

        public Criteria andUrlPerfixLike(String value) {
            addCriterion("URL_PERFIX like", value, "urlPerfix");
            return (Criteria) this;
        }

        public Criteria andUrlPerfixNotLike(String value) {
            addCriterion("URL_PERFIX not like", value, "urlPerfix");
            return (Criteria) this;
        }

        public Criteria andUrlPerfixIn(List<String> values) {
            addCriterion("URL_PERFIX in", values, "urlPerfix");
            return (Criteria) this;
        }

        public Criteria andUrlPerfixNotIn(List<String> values) {
            addCriterion("URL_PERFIX not in", values, "urlPerfix");
            return (Criteria) this;
        }

        public Criteria andUrlPerfixBetween(String value1, String value2) {
            addCriterion("URL_PERFIX between", value1, value2, "urlPerfix");
            return (Criteria) this;
        }

        public Criteria andUrlPerfixNotBetween(String value1, String value2) {
            addCriterion("URL_PERFIX not between", value1, value2, "urlPerfix");
            return (Criteria) this;
        }

        public Criteria andModContextIsNull() {
            addCriterion("MOD_CONTEXT is null");
            return (Criteria) this;
        }

        public Criteria andModContextIsNotNull() {
            addCriterion("MOD_CONTEXT is not null");
            return (Criteria) this;
        }

        public Criteria andModContextEqualTo(String value) {
            addCriterion("MOD_CONTEXT =", value, "modContext");
            return (Criteria) this;
        }

        public Criteria andModContextNotEqualTo(String value) {
            addCriterion("MOD_CONTEXT <>", value, "modContext");
            return (Criteria) this;
        }

        public Criteria andModContextGreaterThan(String value) {
            addCriterion("MOD_CONTEXT >", value, "modContext");
            return (Criteria) this;
        }

        public Criteria andModContextGreaterThanOrEqualTo(String value) {
            addCriterion("MOD_CONTEXT >=", value, "modContext");
            return (Criteria) this;
        }

        public Criteria andModContextLessThan(String value) {
            addCriterion("MOD_CONTEXT <", value, "modContext");
            return (Criteria) this;
        }

        public Criteria andModContextLessThanOrEqualTo(String value) {
            addCriterion("MOD_CONTEXT <=", value, "modContext");
            return (Criteria) this;
        }

        public Criteria andModContextLike(String value) {
            addCriterion("MOD_CONTEXT like", value, "modContext");
            return (Criteria) this;
        }

        public Criteria andModContextNotLike(String value) {
            addCriterion("MOD_CONTEXT not like", value, "modContext");
            return (Criteria) this;
        }

        public Criteria andModContextIn(List<String> values) {
            addCriterion("MOD_CONTEXT in", values, "modContext");
            return (Criteria) this;
        }

        public Criteria andModContextNotIn(List<String> values) {
            addCriterion("MOD_CONTEXT not in", values, "modContext");
            return (Criteria) this;
        }

        public Criteria andModContextBetween(String value1, String value2) {
            addCriterion("MOD_CONTEXT between", value1, value2, "modContext");
            return (Criteria) this;
        }

        public Criteria andModContextNotBetween(String value1, String value2) {
            addCriterion("MOD_CONTEXT not between", value1, value2, "modContext");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIsNull() {
            addCriterion("MENU_URL is null");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIsNotNull() {
            addCriterion("MENU_URL is not null");
            return (Criteria) this;
        }

        public Criteria andMenuUrlEqualTo(String value) {
            addCriterion("MENU_URL =", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotEqualTo(String value) {
            addCriterion("MENU_URL <>", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlGreaterThan(String value) {
            addCriterion("MENU_URL >", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlGreaterThanOrEqualTo(String value) {
            addCriterion("MENU_URL >=", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLessThan(String value) {
            addCriterion("MENU_URL <", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLessThanOrEqualTo(String value) {
            addCriterion("MENU_URL <=", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLike(String value) {
            addCriterion("MENU_URL like", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotLike(String value) {
            addCriterion("MENU_URL not like", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIn(List<String> values) {
            addCriterion("MENU_URL in", values, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotIn(List<String> values) {
            addCriterion("MENU_URL not in", values, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlBetween(String value1, String value2) {
            addCriterion("MENU_URL between", value1, value2, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotBetween(String value1, String value2) {
            addCriterion("MENU_URL not between", value1, value2, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andPermIdIsNull() {
            addCriterion("PERM_ID is null");
            return (Criteria) this;
        }

        public Criteria andPermIdIsNotNull() {
            addCriterion("PERM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPermIdEqualTo(Long value) {
            addCriterion("PERM_ID =", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdNotEqualTo(Long value) {
            addCriterion("PERM_ID <>", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdGreaterThan(Long value) {
            addCriterion("PERM_ID >", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PERM_ID >=", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdLessThan(Long value) {
            addCriterion("PERM_ID <", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdLessThanOrEqualTo(Long value) {
            addCriterion("PERM_ID <=", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdIn(List<Long> values) {
            addCriterion("PERM_ID in", values, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdNotIn(List<Long> values) {
            addCriterion("PERM_ID not in", values, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdBetween(Long value1, Long value2) {
            addCriterion("PERM_ID between", value1, value2, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdNotBetween(Long value1, Long value2) {
            addCriterion("PERM_ID not between", value1, value2, "permId");
            return (Criteria) this;
        }

        public Criteria andIconIndexIsNull() {
            addCriterion("ICON_INDEX is null");
            return (Criteria) this;
        }

        public Criteria andIconIndexIsNotNull() {
            addCriterion("ICON_INDEX is not null");
            return (Criteria) this;
        }

        public Criteria andIconIndexEqualTo(String value) {
            addCriterion("ICON_INDEX =", value, "iconIndex");
            return (Criteria) this;
        }

        public Criteria andIconIndexNotEqualTo(String value) {
            addCriterion("ICON_INDEX <>", value, "iconIndex");
            return (Criteria) this;
        }

        public Criteria andIconIndexGreaterThan(String value) {
            addCriterion("ICON_INDEX >", value, "iconIndex");
            return (Criteria) this;
        }

        public Criteria andIconIndexGreaterThanOrEqualTo(String value) {
            addCriterion("ICON_INDEX >=", value, "iconIndex");
            return (Criteria) this;
        }

        public Criteria andIconIndexLessThan(String value) {
            addCriterion("ICON_INDEX <", value, "iconIndex");
            return (Criteria) this;
        }

        public Criteria andIconIndexLessThanOrEqualTo(String value) {
            addCriterion("ICON_INDEX <=", value, "iconIndex");
            return (Criteria) this;
        }

        public Criteria andIconIndexLike(String value) {
            addCriterion("ICON_INDEX like", value, "iconIndex");
            return (Criteria) this;
        }

        public Criteria andIconIndexNotLike(String value) {
            addCriterion("ICON_INDEX not like", value, "iconIndex");
            return (Criteria) this;
        }

        public Criteria andIconIndexIn(List<String> values) {
            addCriterion("ICON_INDEX in", values, "iconIndex");
            return (Criteria) this;
        }

        public Criteria andIconIndexNotIn(List<String> values) {
            addCriterion("ICON_INDEX not in", values, "iconIndex");
            return (Criteria) this;
        }

        public Criteria andIconIndexBetween(String value1, String value2) {
            addCriterion("ICON_INDEX between", value1, value2, "iconIndex");
            return (Criteria) this;
        }

        public Criteria andIconIndexNotBetween(String value1, String value2) {
            addCriterion("ICON_INDEX not between", value1, value2, "iconIndex");
            return (Criteria) this;
        }

        public Criteria andResOwnerIsNull() {
            addCriterion("RES_OWNER is null");
            return (Criteria) this;
        }

        public Criteria andResOwnerIsNotNull() {
            addCriterion("RES_OWNER is not null");
            return (Criteria) this;
        }

        public Criteria andResOwnerEqualTo(String value) {
            addCriterion("RES_OWNER =", value, "resOwner");
            return (Criteria) this;
        }

        public Criteria andResOwnerNotEqualTo(String value) {
            addCriterion("RES_OWNER <>", value, "resOwner");
            return (Criteria) this;
        }

        public Criteria andResOwnerGreaterThan(String value) {
            addCriterion("RES_OWNER >", value, "resOwner");
            return (Criteria) this;
        }

        public Criteria andResOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("RES_OWNER >=", value, "resOwner");
            return (Criteria) this;
        }

        public Criteria andResOwnerLessThan(String value) {
            addCriterion("RES_OWNER <", value, "resOwner");
            return (Criteria) this;
        }

        public Criteria andResOwnerLessThanOrEqualTo(String value) {
            addCriterion("RES_OWNER <=", value, "resOwner");
            return (Criteria) this;
        }

        public Criteria andResOwnerLike(String value) {
            addCriterion("RES_OWNER like", value, "resOwner");
            return (Criteria) this;
        }

        public Criteria andResOwnerNotLike(String value) {
            addCriterion("RES_OWNER not like", value, "resOwner");
            return (Criteria) this;
        }

        public Criteria andResOwnerIn(List<String> values) {
            addCriterion("RES_OWNER in", values, "resOwner");
            return (Criteria) this;
        }

        public Criteria andResOwnerNotIn(List<String> values) {
            addCriterion("RES_OWNER not in", values, "resOwner");
            return (Criteria) this;
        }

        public Criteria andResOwnerBetween(String value1, String value2) {
            addCriterion("RES_OWNER between", value1, value2, "resOwner");
            return (Criteria) this;
        }

        public Criteria andResOwnerNotBetween(String value1, String value2) {
            addCriterion("RES_OWNER not between", value1, value2, "resOwner");
            return (Criteria) this;
        }

        public Criteria andOpenTypeIsNull() {
            addCriterion("OPEN_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andOpenTypeIsNotNull() {
            addCriterion("OPEN_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOpenTypeEqualTo(String value) {
            addCriterion("OPEN_TYPE =", value, "openType");
            return (Criteria) this;
        }

        public Criteria andOpenTypeNotEqualTo(String value) {
            addCriterion("OPEN_TYPE <>", value, "openType");
            return (Criteria) this;
        }

        public Criteria andOpenTypeGreaterThan(String value) {
            addCriterion("OPEN_TYPE >", value, "openType");
            return (Criteria) this;
        }

        public Criteria andOpenTypeGreaterThanOrEqualTo(String value) {
            addCriterion("OPEN_TYPE >=", value, "openType");
            return (Criteria) this;
        }

        public Criteria andOpenTypeLessThan(String value) {
            addCriterion("OPEN_TYPE <", value, "openType");
            return (Criteria) this;
        }

        public Criteria andOpenTypeLessThanOrEqualTo(String value) {
            addCriterion("OPEN_TYPE <=", value, "openType");
            return (Criteria) this;
        }

        public Criteria andOpenTypeLike(String value) {
            addCriterion("OPEN_TYPE like", value, "openType");
            return (Criteria) this;
        }

        public Criteria andOpenTypeNotLike(String value) {
            addCriterion("OPEN_TYPE not like", value, "openType");
            return (Criteria) this;
        }

        public Criteria andOpenTypeIn(List<String> values) {
            addCriterion("OPEN_TYPE in", values, "openType");
            return (Criteria) this;
        }

        public Criteria andOpenTypeNotIn(List<String> values) {
            addCriterion("OPEN_TYPE not in", values, "openType");
            return (Criteria) this;
        }

        public Criteria andOpenTypeBetween(String value1, String value2) {
            addCriterion("OPEN_TYPE between", value1, value2, "openType");
            return (Criteria) this;
        }

        public Criteria andOpenTypeNotBetween(String value1, String value2) {
            addCriterion("OPEN_TYPE not between", value1, value2, "openType");
            return (Criteria) this;
        }

        public Criteria andSortNoIsNull() {
            addCriterion("SORT_NO is null");
            return (Criteria) this;
        }

        public Criteria andSortNoIsNotNull() {
            addCriterion("SORT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andSortNoEqualTo(Long value) {
            addCriterion("SORT_NO =", value, "sortNo");
            return (Criteria) this;
        }

        public Criteria andSortNoNotEqualTo(Long value) {
            addCriterion("SORT_NO <>", value, "sortNo");
            return (Criteria) this;
        }

        public Criteria andSortNoGreaterThan(Long value) {
            addCriterion("SORT_NO >", value, "sortNo");
            return (Criteria) this;
        }

        public Criteria andSortNoGreaterThanOrEqualTo(Long value) {
            addCriterion("SORT_NO >=", value, "sortNo");
            return (Criteria) this;
        }

        public Criteria andSortNoLessThan(Long value) {
            addCriterion("SORT_NO <", value, "sortNo");
            return (Criteria) this;
        }

        public Criteria andSortNoLessThanOrEqualTo(Long value) {
            addCriterion("SORT_NO <=", value, "sortNo");
            return (Criteria) this;
        }

        public Criteria andSortNoIn(List<Long> values) {
            addCriterion("SORT_NO in", values, "sortNo");
            return (Criteria) this;
        }

        public Criteria andSortNoNotIn(List<Long> values) {
            addCriterion("SORT_NO not in", values, "sortNo");
            return (Criteria) this;
        }

        public Criteria andSortNoBetween(Long value1, Long value2) {
            addCriterion("SORT_NO between", value1, value2, "sortNo");
            return (Criteria) this;
        }

        public Criteria andSortNoNotBetween(Long value1, Long value2) {
            addCriterion("SORT_NO not between", value1, value2, "sortNo");
            return (Criteria) this;
        }

        public Criteria andMenuConfigIsNull() {
            addCriterion("MENU_CONFIG is null");
            return (Criteria) this;
        }

        public Criteria andMenuConfigIsNotNull() {
            addCriterion("MENU_CONFIG is not null");
            return (Criteria) this;
        }

        public Criteria andMenuConfigEqualTo(String value) {
            addCriterion("MENU_CONFIG =", value, "menuConfig");
            return (Criteria) this;
        }

        public Criteria andMenuConfigNotEqualTo(String value) {
            addCriterion("MENU_CONFIG <>", value, "menuConfig");
            return (Criteria) this;
        }

        public Criteria andMenuConfigGreaterThan(String value) {
            addCriterion("MENU_CONFIG >", value, "menuConfig");
            return (Criteria) this;
        }

        public Criteria andMenuConfigGreaterThanOrEqualTo(String value) {
            addCriterion("MENU_CONFIG >=", value, "menuConfig");
            return (Criteria) this;
        }

        public Criteria andMenuConfigLessThan(String value) {
            addCriterion("MENU_CONFIG <", value, "menuConfig");
            return (Criteria) this;
        }

        public Criteria andMenuConfigLessThanOrEqualTo(String value) {
            addCriterion("MENU_CONFIG <=", value, "menuConfig");
            return (Criteria) this;
        }

        public Criteria andMenuConfigLike(String value) {
            addCriterion("MENU_CONFIG like", value, "menuConfig");
            return (Criteria) this;
        }

        public Criteria andMenuConfigNotLike(String value) {
            addCriterion("MENU_CONFIG not like", value, "menuConfig");
            return (Criteria) this;
        }

        public Criteria andMenuConfigIn(List<String> values) {
            addCriterion("MENU_CONFIG in", values, "menuConfig");
            return (Criteria) this;
        }

        public Criteria andMenuConfigNotIn(List<String> values) {
            addCriterion("MENU_CONFIG not in", values, "menuConfig");
            return (Criteria) this;
        }

        public Criteria andMenuConfigBetween(String value1, String value2) {
            addCriterion("MENU_CONFIG between", value1, value2, "menuConfig");
            return (Criteria) this;
        }

        public Criteria andMenuConfigNotBetween(String value1, String value2) {
            addCriterion("MENU_CONFIG not between", value1, value2, "menuConfig");
            return (Criteria) this;
        }

        public Criteria andMenuFrameIsNull() {
            addCriterion("MENU_FRAME is null");
            return (Criteria) this;
        }

        public Criteria andMenuFrameIsNotNull() {
            addCriterion("MENU_FRAME is not null");
            return (Criteria) this;
        }

        public Criteria andMenuFrameEqualTo(String value) {
            addCriterion("MENU_FRAME =", value, "menuFrame");
            return (Criteria) this;
        }

        public Criteria andMenuFrameNotEqualTo(String value) {
            addCriterion("MENU_FRAME <>", value, "menuFrame");
            return (Criteria) this;
        }

        public Criteria andMenuFrameGreaterThan(String value) {
            addCriterion("MENU_FRAME >", value, "menuFrame");
            return (Criteria) this;
        }

        public Criteria andMenuFrameGreaterThanOrEqualTo(String value) {
            addCriterion("MENU_FRAME >=", value, "menuFrame");
            return (Criteria) this;
        }

        public Criteria andMenuFrameLessThan(String value) {
            addCriterion("MENU_FRAME <", value, "menuFrame");
            return (Criteria) this;
        }

        public Criteria andMenuFrameLessThanOrEqualTo(String value) {
            addCriterion("MENU_FRAME <=", value, "menuFrame");
            return (Criteria) this;
        }

        public Criteria andMenuFrameLike(String value) {
            addCriterion("MENU_FRAME like", value, "menuFrame");
            return (Criteria) this;
        }

        public Criteria andMenuFrameNotLike(String value) {
            addCriterion("MENU_FRAME not like", value, "menuFrame");
            return (Criteria) this;
        }

        public Criteria andMenuFrameIn(List<String> values) {
            addCriterion("MENU_FRAME in", values, "menuFrame");
            return (Criteria) this;
        }

        public Criteria andMenuFrameNotIn(List<String> values) {
            addCriterion("MENU_FRAME not in", values, "menuFrame");
            return (Criteria) this;
        }

        public Criteria andMenuFrameBetween(String value1, String value2) {
            addCriterion("MENU_FRAME between", value1, value2, "menuFrame");
            return (Criteria) this;
        }

        public Criteria andMenuFrameNotBetween(String value1, String value2) {
            addCriterion("MENU_FRAME not between", value1, value2, "menuFrame");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andBreakTagIsNull() {
            addCriterion("BREAK_TAG is null");
            return (Criteria) this;
        }

        public Criteria andBreakTagIsNotNull() {
            addCriterion("BREAK_TAG is not null");
            return (Criteria) this;
        }

        public Criteria andBreakTagEqualTo(Boolean value) {
            addCriterion("BREAK_TAG =", value, "breakTag");
            return (Criteria) this;
        }

        public Criteria andBreakTagNotEqualTo(Boolean value) {
            addCriterion("BREAK_TAG <>", value, "breakTag");
            return (Criteria) this;
        }

        public Criteria andBreakTagGreaterThan(Boolean value) {
            addCriterion("BREAK_TAG >", value, "breakTag");
            return (Criteria) this;
        }

        public Criteria andBreakTagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("BREAK_TAG >=", value, "breakTag");
            return (Criteria) this;
        }

        public Criteria andBreakTagLessThan(Boolean value) {
            addCriterion("BREAK_TAG <", value, "breakTag");
            return (Criteria) this;
        }

        public Criteria andBreakTagLessThanOrEqualTo(Boolean value) {
            addCriterion("BREAK_TAG <=", value, "breakTag");
            return (Criteria) this;
        }

        public Criteria andBreakTagIn(List<Boolean> values) {
            addCriterion("BREAK_TAG in", values, "breakTag");
            return (Criteria) this;
        }

        public Criteria andBreakTagNotIn(List<Boolean> values) {
            addCriterion("BREAK_TAG not in", values, "breakTag");
            return (Criteria) this;
        }

        public Criteria andBreakTagBetween(Boolean value1, Boolean value2) {
            addCriterion("BREAK_TAG between", value1, value2, "breakTag");
            return (Criteria) this;
        }

        public Criteria andBreakTagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("BREAK_TAG not between", value1, value2, "breakTag");
            return (Criteria) this;
        }

        public Criteria andValidTagIsNull() {
            addCriterion("VALID_TAG is null");
            return (Criteria) this;
        }

        public Criteria andValidTagIsNotNull() {
            addCriterion("VALID_TAG is not null");
            return (Criteria) this;
        }

        public Criteria andValidTagEqualTo(Boolean value) {
            addCriterion("VALID_TAG =", value, "validTag");
            return (Criteria) this;
        }

        public Criteria andValidTagNotEqualTo(Boolean value) {
            addCriterion("VALID_TAG <>", value, "validTag");
            return (Criteria) this;
        }

        public Criteria andValidTagGreaterThan(Boolean value) {
            addCriterion("VALID_TAG >", value, "validTag");
            return (Criteria) this;
        }

        public Criteria andValidTagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("VALID_TAG >=", value, "validTag");
            return (Criteria) this;
        }

        public Criteria andValidTagLessThan(Boolean value) {
            addCriterion("VALID_TAG <", value, "validTag");
            return (Criteria) this;
        }

        public Criteria andValidTagLessThanOrEqualTo(Boolean value) {
            addCriterion("VALID_TAG <=", value, "validTag");
            return (Criteria) this;
        }

        public Criteria andValidTagIn(List<Boolean> values) {
            addCriterion("VALID_TAG in", values, "validTag");
            return (Criteria) this;
        }

        public Criteria andValidTagNotIn(List<Boolean> values) {
            addCriterion("VALID_TAG not in", values, "validTag");
            return (Criteria) this;
        }

        public Criteria andValidTagBetween(Boolean value1, Boolean value2) {
            addCriterion("VALID_TAG between", value1, value2, "validTag");
            return (Criteria) this;
        }

        public Criteria andValidTagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("VALID_TAG not between", value1, value2, "validTag");
            return (Criteria) this;
        }

        public Criteria andSubsysCodeIsNull() {
            addCriterion("SUBSYS_CODE is null");
            return (Criteria) this;
        }

        public Criteria andSubsysCodeIsNotNull() {
            addCriterion("SUBSYS_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andSubsysCodeEqualTo(String value) {
            addCriterion("SUBSYS_CODE =", value, "subsysCode");
            return (Criteria) this;
        }

        public Criteria andSubsysCodeNotEqualTo(String value) {
            addCriterion("SUBSYS_CODE <>", value, "subsysCode");
            return (Criteria) this;
        }

        public Criteria andSubsysCodeGreaterThan(String value) {
            addCriterion("SUBSYS_CODE >", value, "subsysCode");
            return (Criteria) this;
        }

        public Criteria andSubsysCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SUBSYS_CODE >=", value, "subsysCode");
            return (Criteria) this;
        }

        public Criteria andSubsysCodeLessThan(String value) {
            addCriterion("SUBSYS_CODE <", value, "subsysCode");
            return (Criteria) this;
        }

        public Criteria andSubsysCodeLessThanOrEqualTo(String value) {
            addCriterion("SUBSYS_CODE <=", value, "subsysCode");
            return (Criteria) this;
        }

        public Criteria andSubsysCodeLike(String value) {
            addCriterion("SUBSYS_CODE like", value, "subsysCode");
            return (Criteria) this;
        }

        public Criteria andSubsysCodeNotLike(String value) {
            addCriterion("SUBSYS_CODE not like", value, "subsysCode");
            return (Criteria) this;
        }

        public Criteria andSubsysCodeIn(List<String> values) {
            addCriterion("SUBSYS_CODE in", values, "subsysCode");
            return (Criteria) this;
        }

        public Criteria andSubsysCodeNotIn(List<String> values) {
            addCriterion("SUBSYS_CODE not in", values, "subsysCode");
            return (Criteria) this;
        }

        public Criteria andSubsysCodeBetween(String value1, String value2) {
            addCriterion("SUBSYS_CODE between", value1, value2, "subsysCode");
            return (Criteria) this;
        }

        public Criteria andSubsysCodeNotBetween(String value1, String value2) {
            addCriterion("SUBSYS_CODE not between", value1, value2, "subsysCode");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("CREATE_BY is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("CREATE_BY is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("CREATE_BY =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("CREATE_BY <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("CREATE_BY >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_BY >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("CREATE_BY <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("CREATE_BY <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("CREATE_BY like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("CREATE_BY not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("CREATE_BY in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("CREATE_BY not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("CREATE_BY between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("CREATE_BY not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("UPDATE_BY is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("UPDATE_BY is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(String value) {
            addCriterion("UPDATE_BY =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(String value) {
            addCriterion("UPDATE_BY <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(String value) {
            addCriterion("UPDATE_BY >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_BY >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(String value) {
            addCriterion("UPDATE_BY <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_BY <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLike(String value) {
            addCriterion("UPDATE_BY like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotLike(String value) {
            addCriterion("UPDATE_BY not like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<String> values) {
            addCriterion("UPDATE_BY in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<String> values) {
            addCriterion("UPDATE_BY not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(String value1, String value2) {
            addCriterion("UPDATE_BY between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(String value1, String value2) {
            addCriterion("UPDATE_BY not between", value1, value2, "updateBy");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}