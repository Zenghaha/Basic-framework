package com.ud.basic.system.persistence.sys.auto.model;

import java.util.ArrayList;
import java.util.List;

public class SysFhbuttonExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysFhbuttonExample() {
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

        public Criteria andFhbuttonIdIsNull() {
            addCriterion("fhbutton_id is null");
            return (Criteria) this;
        }

        public Criteria andFhbuttonIdIsNotNull() {
            addCriterion("fhbutton_id is not null");
            return (Criteria) this;
        }

        public Criteria andFhbuttonIdEqualTo(String value) {
            addCriterion("fhbutton_id =", value, "fhbuttonId");
            return (Criteria) this;
        }

        public Criteria andFhbuttonIdNotEqualTo(String value) {
            addCriterion("fhbutton_id <>", value, "fhbuttonId");
            return (Criteria) this;
        }

        public Criteria andFhbuttonIdGreaterThan(String value) {
            addCriterion("fhbutton_id >", value, "fhbuttonId");
            return (Criteria) this;
        }

        public Criteria andFhbuttonIdGreaterThanOrEqualTo(String value) {
            addCriterion("fhbutton_id >=", value, "fhbuttonId");
            return (Criteria) this;
        }

        public Criteria andFhbuttonIdLessThan(String value) {
            addCriterion("fhbutton_id <", value, "fhbuttonId");
            return (Criteria) this;
        }

        public Criteria andFhbuttonIdLessThanOrEqualTo(String value) {
            addCriterion("fhbutton_id <=", value, "fhbuttonId");
            return (Criteria) this;
        }

        public Criteria andFhbuttonIdLike(String value) {
            addCriterion("fhbutton_id like", value, "fhbuttonId");
            return (Criteria) this;
        }

        public Criteria andFhbuttonIdNotLike(String value) {
            addCriterion("fhbutton_id not like", value, "fhbuttonId");
            return (Criteria) this;
        }

        public Criteria andFhbuttonIdIn(List<String> values) {
            addCriterion("fhbutton_id in", values, "fhbuttonId");
            return (Criteria) this;
        }

        public Criteria andFhbuttonIdNotIn(List<String> values) {
            addCriterion("fhbutton_id not in", values, "fhbuttonId");
            return (Criteria) this;
        }

        public Criteria andFhbuttonIdBetween(String value1, String value2) {
            addCriterion("fhbutton_id between", value1, value2, "fhbuttonId");
            return (Criteria) this;
        }

        public Criteria andFhbuttonIdNotBetween(String value1, String value2) {
            addCriterion("fhbutton_id not between", value1, value2, "fhbuttonId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andQxNameIsNull() {
            addCriterion("qx_name is null");
            return (Criteria) this;
        }

        public Criteria andQxNameIsNotNull() {
            addCriterion("qx_name is not null");
            return (Criteria) this;
        }

        public Criteria andQxNameEqualTo(String value) {
            addCriterion("qx_name =", value, "qxName");
            return (Criteria) this;
        }

        public Criteria andQxNameNotEqualTo(String value) {
            addCriterion("qx_name <>", value, "qxName");
            return (Criteria) this;
        }

        public Criteria andQxNameGreaterThan(String value) {
            addCriterion("qx_name >", value, "qxName");
            return (Criteria) this;
        }

        public Criteria andQxNameGreaterThanOrEqualTo(String value) {
            addCriterion("qx_name >=", value, "qxName");
            return (Criteria) this;
        }

        public Criteria andQxNameLessThan(String value) {
            addCriterion("qx_name <", value, "qxName");
            return (Criteria) this;
        }

        public Criteria andQxNameLessThanOrEqualTo(String value) {
            addCriterion("qx_name <=", value, "qxName");
            return (Criteria) this;
        }

        public Criteria andQxNameLike(String value) {
            addCriterion("qx_name like", value, "qxName");
            return (Criteria) this;
        }

        public Criteria andQxNameNotLike(String value) {
            addCriterion("qx_name not like", value, "qxName");
            return (Criteria) this;
        }

        public Criteria andQxNameIn(List<String> values) {
            addCriterion("qx_name in", values, "qxName");
            return (Criteria) this;
        }

        public Criteria andQxNameNotIn(List<String> values) {
            addCriterion("qx_name not in", values, "qxName");
            return (Criteria) this;
        }

        public Criteria andQxNameBetween(String value1, String value2) {
            addCriterion("qx_name between", value1, value2, "qxName");
            return (Criteria) this;
        }

        public Criteria andQxNameNotBetween(String value1, String value2) {
            addCriterion("qx_name not between", value1, value2, "qxName");
            return (Criteria) this;
        }

        public Criteria andBzIsNull() {
            addCriterion("bz is null");
            return (Criteria) this;
        }

        public Criteria andBzIsNotNull() {
            addCriterion("bz is not null");
            return (Criteria) this;
        }

        public Criteria andBzEqualTo(String value) {
            addCriterion("bz =", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotEqualTo(String value) {
            addCriterion("bz <>", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThan(String value) {
            addCriterion("bz >", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThanOrEqualTo(String value) {
            addCriterion("bz >=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThan(String value) {
            addCriterion("bz <", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThanOrEqualTo(String value) {
            addCriterion("bz <=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLike(String value) {
            addCriterion("bz like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotLike(String value) {
            addCriterion("bz not like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzIn(List<String> values) {
            addCriterion("bz in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotIn(List<String> values) {
            addCriterion("bz not in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzBetween(String value1, String value2) {
            addCriterion("bz between", value1, value2, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotBetween(String value1, String value2) {
            addCriterion("bz not between", value1, value2, "bz");
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