package com.ud.basic.system.persistence.sys.auto.model;

import java.util.ArrayList;
import java.util.List;

public class SysFhlogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysFhlogExample() {
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

        public Criteria andFhlogIdIsNull() {
            addCriterion("fhlog_id is null");
            return (Criteria) this;
        }

        public Criteria andFhlogIdIsNotNull() {
            addCriterion("fhlog_id is not null");
            return (Criteria) this;
        }

        public Criteria andFhlogIdEqualTo(String value) {
            addCriterion("fhlog_id =", value, "fhlogId");
            return (Criteria) this;
        }

        public Criteria andFhlogIdNotEqualTo(String value) {
            addCriterion("fhlog_id <>", value, "fhlogId");
            return (Criteria) this;
        }

        public Criteria andFhlogIdGreaterThan(String value) {
            addCriterion("fhlog_id >", value, "fhlogId");
            return (Criteria) this;
        }

        public Criteria andFhlogIdGreaterThanOrEqualTo(String value) {
            addCriterion("fhlog_id >=", value, "fhlogId");
            return (Criteria) this;
        }

        public Criteria andFhlogIdLessThan(String value) {
            addCriterion("fhlog_id <", value, "fhlogId");
            return (Criteria) this;
        }

        public Criteria andFhlogIdLessThanOrEqualTo(String value) {
            addCriterion("fhlog_id <=", value, "fhlogId");
            return (Criteria) this;
        }

        public Criteria andFhlogIdLike(String value) {
            addCriterion("fhlog_id like", value, "fhlogId");
            return (Criteria) this;
        }

        public Criteria andFhlogIdNotLike(String value) {
            addCriterion("fhlog_id not like", value, "fhlogId");
            return (Criteria) this;
        }

        public Criteria andFhlogIdIn(List<String> values) {
            addCriterion("fhlog_id in", values, "fhlogId");
            return (Criteria) this;
        }

        public Criteria andFhlogIdNotIn(List<String> values) {
            addCriterion("fhlog_id not in", values, "fhlogId");
            return (Criteria) this;
        }

        public Criteria andFhlogIdBetween(String value1, String value2) {
            addCriterion("fhlog_id between", value1, value2, "fhlogId");
            return (Criteria) this;
        }

        public Criteria andFhlogIdNotBetween(String value1, String value2) {
            addCriterion("fhlog_id not between", value1, value2, "fhlogId");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andCztimeIsNull() {
            addCriterion("cztime is null");
            return (Criteria) this;
        }

        public Criteria andCztimeIsNotNull() {
            addCriterion("cztime is not null");
            return (Criteria) this;
        }

        public Criteria andCztimeEqualTo(String value) {
            addCriterion("cztime =", value, "cztime");
            return (Criteria) this;
        }

        public Criteria andCztimeNotEqualTo(String value) {
            addCriterion("cztime <>", value, "cztime");
            return (Criteria) this;
        }

        public Criteria andCztimeGreaterThan(String value) {
            addCriterion("cztime >", value, "cztime");
            return (Criteria) this;
        }

        public Criteria andCztimeGreaterThanOrEqualTo(String value) {
            addCriterion("cztime >=", value, "cztime");
            return (Criteria) this;
        }

        public Criteria andCztimeLessThan(String value) {
            addCriterion("cztime <", value, "cztime");
            return (Criteria) this;
        }

        public Criteria andCztimeLessThanOrEqualTo(String value) {
            addCriterion("cztime <=", value, "cztime");
            return (Criteria) this;
        }

        public Criteria andCztimeLike(String value) {
            addCriterion("cztime like", value, "cztime");
            return (Criteria) this;
        }

        public Criteria andCztimeNotLike(String value) {
            addCriterion("cztime not like", value, "cztime");
            return (Criteria) this;
        }

        public Criteria andCztimeIn(List<String> values) {
            addCriterion("cztime in", values, "cztime");
            return (Criteria) this;
        }

        public Criteria andCztimeNotIn(List<String> values) {
            addCriterion("cztime not in", values, "cztime");
            return (Criteria) this;
        }

        public Criteria andCztimeBetween(String value1, String value2) {
            addCriterion("cztime between", value1, value2, "cztime");
            return (Criteria) this;
        }

        public Criteria andCztimeNotBetween(String value1, String value2) {
            addCriterion("cztime not between", value1, value2, "cztime");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
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