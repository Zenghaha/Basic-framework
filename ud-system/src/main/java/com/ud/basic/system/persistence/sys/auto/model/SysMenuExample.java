package com.ud.basic.system.persistence.sys.auto.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysMenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysMenuExample() {
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

        public Criteria andMenuIdIsNull() {
            addCriterion("menu_id is null");
            return (Criteria) this;
        }

        public Criteria andMenuIdIsNotNull() {
            addCriterion("menu_id is not null");
            return (Criteria) this;
        }

        public Criteria andMenuIdEqualTo(Integer value) {
            addCriterion("menu_id =", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotEqualTo(Integer value) {
            addCriterion("menu_id <>", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThan(Integer value) {
            addCriterion("menu_id >", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_id >=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThan(Integer value) {
            addCriterion("menu_id <", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThanOrEqualTo(Integer value) {
            addCriterion("menu_id <=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdIn(List<Integer> values) {
            addCriterion("menu_id in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotIn(List<Integer> values) {
            addCriterion("menu_id not in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdBetween(Integer value1, Integer value2) {
            addCriterion("menu_id between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_id not between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuParentJsonIsNull() {
            addCriterion("menu_parent_json is null");
            return (Criteria) this;
        }

        public Criteria andMenuParentJsonIsNotNull() {
            addCriterion("menu_parent_json is not null");
            return (Criteria) this;
        }

        public Criteria andMenuParentJsonEqualTo(String value) {
            addCriterion("menu_parent_json =", value, "menuParentJson");
            return (Criteria) this;
        }

        public Criteria andMenuParentJsonNotEqualTo(String value) {
            addCriterion("menu_parent_json <>", value, "menuParentJson");
            return (Criteria) this;
        }

        public Criteria andMenuParentJsonGreaterThan(String value) {
            addCriterion("menu_parent_json >", value, "menuParentJson");
            return (Criteria) this;
        }

        public Criteria andMenuParentJsonGreaterThanOrEqualTo(String value) {
            addCriterion("menu_parent_json >=", value, "menuParentJson");
            return (Criteria) this;
        }

        public Criteria andMenuParentJsonLessThan(String value) {
            addCriterion("menu_parent_json <", value, "menuParentJson");
            return (Criteria) this;
        }

        public Criteria andMenuParentJsonLessThanOrEqualTo(String value) {
            addCriterion("menu_parent_json <=", value, "menuParentJson");
            return (Criteria) this;
        }

        public Criteria andMenuParentJsonLike(String value) {
            addCriterion("menu_parent_json like", value, "menuParentJson");
            return (Criteria) this;
        }

        public Criteria andMenuParentJsonNotLike(String value) {
            addCriterion("menu_parent_json not like", value, "menuParentJson");
            return (Criteria) this;
        }

        public Criteria andMenuParentJsonIn(List<String> values) {
            addCriterion("menu_parent_json in", values, "menuParentJson");
            return (Criteria) this;
        }

        public Criteria andMenuParentJsonNotIn(List<String> values) {
            addCriterion("menu_parent_json not in", values, "menuParentJson");
            return (Criteria) this;
        }

        public Criteria andMenuParentJsonBetween(String value1, String value2) {
            addCriterion("menu_parent_json between", value1, value2, "menuParentJson");
            return (Criteria) this;
        }

        public Criteria andMenuParentJsonNotBetween(String value1, String value2) {
            addCriterion("menu_parent_json not between", value1, value2, "menuParentJson");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNull() {
            addCriterion("menu_name is null");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNotNull() {
            addCriterion("menu_name is not null");
            return (Criteria) this;
        }

        public Criteria andMenuNameEqualTo(String value) {
            addCriterion("menu_name =", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotEqualTo(String value) {
            addCriterion("menu_name <>", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThan(String value) {
            addCriterion("menu_name >", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThanOrEqualTo(String value) {
            addCriterion("menu_name >=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThan(String value) {
            addCriterion("menu_name <", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThanOrEqualTo(String value) {
            addCriterion("menu_name <=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLike(String value) {
            addCriterion("menu_name like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotLike(String value) {
            addCriterion("menu_name not like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameIn(List<String> values) {
            addCriterion("menu_name in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotIn(List<String> values) {
            addCriterion("menu_name not in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameBetween(String value1, String value2) {
            addCriterion("menu_name between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotBetween(String value1, String value2) {
            addCriterion("menu_name not between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIsNull() {
            addCriterion("menu_url is null");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIsNotNull() {
            addCriterion("menu_url is not null");
            return (Criteria) this;
        }

        public Criteria andMenuUrlEqualTo(String value) {
            addCriterion("menu_url =", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotEqualTo(String value) {
            addCriterion("menu_url <>", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlGreaterThan(String value) {
            addCriterion("menu_url >", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlGreaterThanOrEqualTo(String value) {
            addCriterion("menu_url >=", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLessThan(String value) {
            addCriterion("menu_url <", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLessThanOrEqualTo(String value) {
            addCriterion("menu_url <=", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLike(String value) {
            addCriterion("menu_url like", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotLike(String value) {
            addCriterion("menu_url not like", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIn(List<String> values) {
            addCriterion("menu_url in", values, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotIn(List<String> values) {
            addCriterion("menu_url not in", values, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlBetween(String value1, String value2) {
            addCriterion("menu_url between", value1, value2, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotBetween(String value1, String value2) {
            addCriterion("menu_url not between", value1, value2, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(String value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(String value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(String value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(String value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(String value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLike(String value) {
            addCriterion("parent_id like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotLike(String value) {
            addCriterion("parent_id not like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<String> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<String> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(String value1, String value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(String value1, String value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andMenuOrderIsNull() {
            addCriterion("menu_order is null");
            return (Criteria) this;
        }

        public Criteria andMenuOrderIsNotNull() {
            addCriterion("menu_order is not null");
            return (Criteria) this;
        }

        public Criteria andMenuOrderEqualTo(String value) {
            addCriterion("menu_order =", value, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderNotEqualTo(String value) {
            addCriterion("menu_order <>", value, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderGreaterThan(String value) {
            addCriterion("menu_order >", value, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderGreaterThanOrEqualTo(String value) {
            addCriterion("menu_order >=", value, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderLessThan(String value) {
            addCriterion("menu_order <", value, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderLessThanOrEqualTo(String value) {
            addCriterion("menu_order <=", value, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderLike(String value) {
            addCriterion("menu_order like", value, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderNotLike(String value) {
            addCriterion("menu_order not like", value, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderIn(List<String> values) {
            addCriterion("menu_order in", values, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderNotIn(List<String> values) {
            addCriterion("menu_order not in", values, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderBetween(String value1, String value2) {
            addCriterion("menu_order between", value1, value2, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderNotBetween(String value1, String value2) {
            addCriterion("menu_order not between", value1, value2, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuIconIsNull() {
            addCriterion("menu_icon is null");
            return (Criteria) this;
        }

        public Criteria andMenuIconIsNotNull() {
            addCriterion("menu_icon is not null");
            return (Criteria) this;
        }

        public Criteria andMenuIconEqualTo(String value) {
            addCriterion("menu_icon =", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconNotEqualTo(String value) {
            addCriterion("menu_icon <>", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconGreaterThan(String value) {
            addCriterion("menu_icon >", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconGreaterThanOrEqualTo(String value) {
            addCriterion("menu_icon >=", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconLessThan(String value) {
            addCriterion("menu_icon <", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconLessThanOrEqualTo(String value) {
            addCriterion("menu_icon <=", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconLike(String value) {
            addCriterion("menu_icon like", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconNotLike(String value) {
            addCriterion("menu_icon not like", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconIn(List<String> values) {
            addCriterion("menu_icon in", values, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconNotIn(List<String> values) {
            addCriterion("menu_icon not in", values, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconBetween(String value1, String value2) {
            addCriterion("menu_icon between", value1, value2, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconNotBetween(String value1, String value2) {
            addCriterion("menu_icon not between", value1, value2, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuTypeIsNull() {
            addCriterion("menu_type is null");
            return (Criteria) this;
        }

        public Criteria andMenuTypeIsNotNull() {
            addCriterion("menu_type is not null");
            return (Criteria) this;
        }

        public Criteria andMenuTypeEqualTo(String value) {
            addCriterion("menu_type =", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeNotEqualTo(String value) {
            addCriterion("menu_type <>", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeGreaterThan(String value) {
            addCriterion("menu_type >", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeGreaterThanOrEqualTo(String value) {
            addCriterion("menu_type >=", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeLessThan(String value) {
            addCriterion("menu_type <", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeLessThanOrEqualTo(String value) {
            addCriterion("menu_type <=", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeLike(String value) {
            addCriterion("menu_type like", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeNotLike(String value) {
            addCriterion("menu_type not like", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeIn(List<String> values) {
            addCriterion("menu_type in", values, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeNotIn(List<String> values) {
            addCriterion("menu_type not in", values, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeBetween(String value1, String value2) {
            addCriterion("menu_type between", value1, value2, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeNotBetween(String value1, String value2) {
            addCriterion("menu_type not between", value1, value2, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuStateIsNull() {
            addCriterion("menu_state is null");
            return (Criteria) this;
        }

        public Criteria andMenuStateIsNotNull() {
            addCriterion("menu_state is not null");
            return (Criteria) this;
        }

        public Criteria andMenuStateEqualTo(Integer value) {
            addCriterion("menu_state =", value, "menuState");
            return (Criteria) this;
        }

        public Criteria andMenuStateNotEqualTo(Integer value) {
            addCriterion("menu_state <>", value, "menuState");
            return (Criteria) this;
        }

        public Criteria andMenuStateGreaterThan(Integer value) {
            addCriterion("menu_state >", value, "menuState");
            return (Criteria) this;
        }

        public Criteria andMenuStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_state >=", value, "menuState");
            return (Criteria) this;
        }

        public Criteria andMenuStateLessThan(Integer value) {
            addCriterion("menu_state <", value, "menuState");
            return (Criteria) this;
        }

        public Criteria andMenuStateLessThanOrEqualTo(Integer value) {
            addCriterion("menu_state <=", value, "menuState");
            return (Criteria) this;
        }

        public Criteria andMenuStateIn(List<Integer> values) {
            addCriterion("menu_state in", values, "menuState");
            return (Criteria) this;
        }

        public Criteria andMenuStateNotIn(List<Integer> values) {
            addCriterion("menu_state not in", values, "menuState");
            return (Criteria) this;
        }

        public Criteria andMenuStateBetween(Integer value1, Integer value2) {
            addCriterion("menu_state between", value1, value2, "menuState");
            return (Criteria) this;
        }

        public Criteria andMenuStateNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_state not between", value1, value2, "menuState");
            return (Criteria) this;
        }

        public Criteria andCreatedDateIsNull() {
            addCriterion("created_date is null");
            return (Criteria) this;
        }

        public Criteria andCreatedDateIsNotNull() {
            addCriterion("created_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedDateEqualTo(Date value) {
            addCriterion("created_date =", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateNotEqualTo(Date value) {
            addCriterion("created_date <>", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateGreaterThan(Date value) {
            addCriterion("created_date >", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateGreaterThanOrEqualTo(Date value) {
            addCriterion("created_date >=", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateLessThan(Date value) {
            addCriterion("created_date <", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateLessThanOrEqualTo(Date value) {
            addCriterion("created_date <=", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateIn(List<Date> values) {
            addCriterion("created_date in", values, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateNotIn(List<Date> values) {
            addCriterion("created_date not in", values, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateBetween(Date value1, Date value2) {
            addCriterion("created_date between", value1, value2, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateNotBetween(Date value1, Date value2) {
            addCriterion("created_date not between", value1, value2, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNull() {
            addCriterion("created_by is null");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNotNull() {
            addCriterion("created_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedByEqualTo(String value) {
            addCriterion("created_by =", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotEqualTo(String value) {
            addCriterion("created_by <>", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThan(String value) {
            addCriterion("created_by >", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThanOrEqualTo(String value) {
            addCriterion("created_by >=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThan(String value) {
            addCriterion("created_by <", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThanOrEqualTo(String value) {
            addCriterion("created_by <=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLike(String value) {
            addCriterion("created_by like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotLike(String value) {
            addCriterion("created_by not like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByIn(List<String> values) {
            addCriterion("created_by in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotIn(List<String> values) {
            addCriterion("created_by not in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByBetween(String value1, String value2) {
            addCriterion("created_by between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotBetween(String value1, String value2) {
            addCriterion("created_by not between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andLastModifiedDateIsNull() {
            addCriterion("last_modified_date is null");
            return (Criteria) this;
        }

        public Criteria andLastModifiedDateIsNotNull() {
            addCriterion("last_modified_date is not null");
            return (Criteria) this;
        }

        public Criteria andLastModifiedDateEqualTo(Date value) {
            addCriterion("last_modified_date =", value, "lastModifiedDate");
            return (Criteria) this;
        }

        public Criteria andLastModifiedDateNotEqualTo(Date value) {
            addCriterion("last_modified_date <>", value, "lastModifiedDate");
            return (Criteria) this;
        }

        public Criteria andLastModifiedDateGreaterThan(Date value) {
            addCriterion("last_modified_date >", value, "lastModifiedDate");
            return (Criteria) this;
        }

        public Criteria andLastModifiedDateGreaterThanOrEqualTo(Date value) {
            addCriterion("last_modified_date >=", value, "lastModifiedDate");
            return (Criteria) this;
        }

        public Criteria andLastModifiedDateLessThan(Date value) {
            addCriterion("last_modified_date <", value, "lastModifiedDate");
            return (Criteria) this;
        }

        public Criteria andLastModifiedDateLessThanOrEqualTo(Date value) {
            addCriterion("last_modified_date <=", value, "lastModifiedDate");
            return (Criteria) this;
        }

        public Criteria andLastModifiedDateIn(List<Date> values) {
            addCriterion("last_modified_date in", values, "lastModifiedDate");
            return (Criteria) this;
        }

        public Criteria andLastModifiedDateNotIn(List<Date> values) {
            addCriterion("last_modified_date not in", values, "lastModifiedDate");
            return (Criteria) this;
        }

        public Criteria andLastModifiedDateBetween(Date value1, Date value2) {
            addCriterion("last_modified_date between", value1, value2, "lastModifiedDate");
            return (Criteria) this;
        }

        public Criteria andLastModifiedDateNotBetween(Date value1, Date value2) {
            addCriterion("last_modified_date not between", value1, value2, "lastModifiedDate");
            return (Criteria) this;
        }

        public Criteria andLastModifiedByIsNull() {
            addCriterion("last_modified_by is null");
            return (Criteria) this;
        }

        public Criteria andLastModifiedByIsNotNull() {
            addCriterion("last_modified_by is not null");
            return (Criteria) this;
        }

        public Criteria andLastModifiedByEqualTo(String value) {
            addCriterion("last_modified_by =", value, "lastModifiedBy");
            return (Criteria) this;
        }

        public Criteria andLastModifiedByNotEqualTo(String value) {
            addCriterion("last_modified_by <>", value, "lastModifiedBy");
            return (Criteria) this;
        }

        public Criteria andLastModifiedByGreaterThan(String value) {
            addCriterion("last_modified_by >", value, "lastModifiedBy");
            return (Criteria) this;
        }

        public Criteria andLastModifiedByGreaterThanOrEqualTo(String value) {
            addCriterion("last_modified_by >=", value, "lastModifiedBy");
            return (Criteria) this;
        }

        public Criteria andLastModifiedByLessThan(String value) {
            addCriterion("last_modified_by <", value, "lastModifiedBy");
            return (Criteria) this;
        }

        public Criteria andLastModifiedByLessThanOrEqualTo(String value) {
            addCriterion("last_modified_by <=", value, "lastModifiedBy");
            return (Criteria) this;
        }

        public Criteria andLastModifiedByLike(String value) {
            addCriterion("last_modified_by like", value, "lastModifiedBy");
            return (Criteria) this;
        }

        public Criteria andLastModifiedByNotLike(String value) {
            addCriterion("last_modified_by not like", value, "lastModifiedBy");
            return (Criteria) this;
        }

        public Criteria andLastModifiedByIn(List<String> values) {
            addCriterion("last_modified_by in", values, "lastModifiedBy");
            return (Criteria) this;
        }

        public Criteria andLastModifiedByNotIn(List<String> values) {
            addCriterion("last_modified_by not in", values, "lastModifiedBy");
            return (Criteria) this;
        }

        public Criteria andLastModifiedByBetween(String value1, String value2) {
            addCriterion("last_modified_by between", value1, value2, "lastModifiedBy");
            return (Criteria) this;
        }

        public Criteria andLastModifiedByNotBetween(String value1, String value2) {
            addCriterion("last_modified_by not between", value1, value2, "lastModifiedBy");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNull() {
            addCriterion("del_flag is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(Boolean value) {
            addCriterion("del_flag =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(Boolean value) {
            addCriterion("del_flag <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(Boolean value) {
            addCriterion("del_flag >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("del_flag >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(Boolean value) {
            addCriterion("del_flag <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("del_flag <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<Boolean> values) {
            addCriterion("del_flag in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<Boolean> values) {
            addCriterion("del_flag not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("del_flag between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("del_flag not between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andIsParentIsNull() {
            addCriterion("is_parent is null");
            return (Criteria) this;
        }

        public Criteria andIsParentIsNotNull() {
            addCriterion("is_parent is not null");
            return (Criteria) this;
        }

        public Criteria andIsParentEqualTo(Boolean value) {
            addCriterion("is_parent =", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentNotEqualTo(Boolean value) {
            addCriterion("is_parent <>", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentGreaterThan(Boolean value) {
            addCriterion("is_parent >", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_parent >=", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentLessThan(Boolean value) {
            addCriterion("is_parent <", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentLessThanOrEqualTo(Boolean value) {
            addCriterion("is_parent <=", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentIn(List<Boolean> values) {
            addCriterion("is_parent in", values, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentNotIn(List<Boolean> values) {
            addCriterion("is_parent not in", values, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentBetween(Boolean value1, Boolean value2) {
            addCriterion("is_parent between", value1, value2, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_parent not between", value1, value2, "isParent");
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