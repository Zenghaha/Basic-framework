package com.ud.basic.system.persistence.sys.auto.model;

import java.util.ArrayList;
import java.util.List;

public class SysCreatecodeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysCreatecodeExample() {
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

        public Criteria andCreatecodeIdIsNull() {
            addCriterion("createcode_id is null");
            return (Criteria) this;
        }

        public Criteria andCreatecodeIdIsNotNull() {
            addCriterion("createcode_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreatecodeIdEqualTo(String value) {
            addCriterion("createcode_id =", value, "createcodeId");
            return (Criteria) this;
        }

        public Criteria andCreatecodeIdNotEqualTo(String value) {
            addCriterion("createcode_id <>", value, "createcodeId");
            return (Criteria) this;
        }

        public Criteria andCreatecodeIdGreaterThan(String value) {
            addCriterion("createcode_id >", value, "createcodeId");
            return (Criteria) this;
        }

        public Criteria andCreatecodeIdGreaterThanOrEqualTo(String value) {
            addCriterion("createcode_id >=", value, "createcodeId");
            return (Criteria) this;
        }

        public Criteria andCreatecodeIdLessThan(String value) {
            addCriterion("createcode_id <", value, "createcodeId");
            return (Criteria) this;
        }

        public Criteria andCreatecodeIdLessThanOrEqualTo(String value) {
            addCriterion("createcode_id <=", value, "createcodeId");
            return (Criteria) this;
        }

        public Criteria andCreatecodeIdLike(String value) {
            addCriterion("createcode_id like", value, "createcodeId");
            return (Criteria) this;
        }

        public Criteria andCreatecodeIdNotLike(String value) {
            addCriterion("createcode_id not like", value, "createcodeId");
            return (Criteria) this;
        }

        public Criteria andCreatecodeIdIn(List<String> values) {
            addCriterion("createcode_id in", values, "createcodeId");
            return (Criteria) this;
        }

        public Criteria andCreatecodeIdNotIn(List<String> values) {
            addCriterion("createcode_id not in", values, "createcodeId");
            return (Criteria) this;
        }

        public Criteria andCreatecodeIdBetween(String value1, String value2) {
            addCriterion("createcode_id between", value1, value2, "createcodeId");
            return (Criteria) this;
        }

        public Criteria andCreatecodeIdNotBetween(String value1, String value2) {
            addCriterion("createcode_id not between", value1, value2, "createcodeId");
            return (Criteria) this;
        }

        public Criteria andPackagenameIsNull() {
            addCriterion("packagename is null");
            return (Criteria) this;
        }

        public Criteria andPackagenameIsNotNull() {
            addCriterion("packagename is not null");
            return (Criteria) this;
        }

        public Criteria andPackagenameEqualTo(String value) {
            addCriterion("packagename =", value, "packagename");
            return (Criteria) this;
        }

        public Criteria andPackagenameNotEqualTo(String value) {
            addCriterion("packagename <>", value, "packagename");
            return (Criteria) this;
        }

        public Criteria andPackagenameGreaterThan(String value) {
            addCriterion("packagename >", value, "packagename");
            return (Criteria) this;
        }

        public Criteria andPackagenameGreaterThanOrEqualTo(String value) {
            addCriterion("packagename >=", value, "packagename");
            return (Criteria) this;
        }

        public Criteria andPackagenameLessThan(String value) {
            addCriterion("packagename <", value, "packagename");
            return (Criteria) this;
        }

        public Criteria andPackagenameLessThanOrEqualTo(String value) {
            addCriterion("packagename <=", value, "packagename");
            return (Criteria) this;
        }

        public Criteria andPackagenameLike(String value) {
            addCriterion("packagename like", value, "packagename");
            return (Criteria) this;
        }

        public Criteria andPackagenameNotLike(String value) {
            addCriterion("packagename not like", value, "packagename");
            return (Criteria) this;
        }

        public Criteria andPackagenameIn(List<String> values) {
            addCriterion("packagename in", values, "packagename");
            return (Criteria) this;
        }

        public Criteria andPackagenameNotIn(List<String> values) {
            addCriterion("packagename not in", values, "packagename");
            return (Criteria) this;
        }

        public Criteria andPackagenameBetween(String value1, String value2) {
            addCriterion("packagename between", value1, value2, "packagename");
            return (Criteria) this;
        }

        public Criteria andPackagenameNotBetween(String value1, String value2) {
            addCriterion("packagename not between", value1, value2, "packagename");
            return (Criteria) this;
        }

        public Criteria andObjectnameIsNull() {
            addCriterion("objectname is null");
            return (Criteria) this;
        }

        public Criteria andObjectnameIsNotNull() {
            addCriterion("objectname is not null");
            return (Criteria) this;
        }

        public Criteria andObjectnameEqualTo(String value) {
            addCriterion("objectname =", value, "objectname");
            return (Criteria) this;
        }

        public Criteria andObjectnameNotEqualTo(String value) {
            addCriterion("objectname <>", value, "objectname");
            return (Criteria) this;
        }

        public Criteria andObjectnameGreaterThan(String value) {
            addCriterion("objectname >", value, "objectname");
            return (Criteria) this;
        }

        public Criteria andObjectnameGreaterThanOrEqualTo(String value) {
            addCriterion("objectname >=", value, "objectname");
            return (Criteria) this;
        }

        public Criteria andObjectnameLessThan(String value) {
            addCriterion("objectname <", value, "objectname");
            return (Criteria) this;
        }

        public Criteria andObjectnameLessThanOrEqualTo(String value) {
            addCriterion("objectname <=", value, "objectname");
            return (Criteria) this;
        }

        public Criteria andObjectnameLike(String value) {
            addCriterion("objectname like", value, "objectname");
            return (Criteria) this;
        }

        public Criteria andObjectnameNotLike(String value) {
            addCriterion("objectname not like", value, "objectname");
            return (Criteria) this;
        }

        public Criteria andObjectnameIn(List<String> values) {
            addCriterion("objectname in", values, "objectname");
            return (Criteria) this;
        }

        public Criteria andObjectnameNotIn(List<String> values) {
            addCriterion("objectname not in", values, "objectname");
            return (Criteria) this;
        }

        public Criteria andObjectnameBetween(String value1, String value2) {
            addCriterion("objectname between", value1, value2, "objectname");
            return (Criteria) this;
        }

        public Criteria andObjectnameNotBetween(String value1, String value2) {
            addCriterion("objectname not between", value1, value2, "objectname");
            return (Criteria) this;
        }

        public Criteria andTablenameIsNull() {
            addCriterion("tablename is null");
            return (Criteria) this;
        }

        public Criteria andTablenameIsNotNull() {
            addCriterion("tablename is not null");
            return (Criteria) this;
        }

        public Criteria andTablenameEqualTo(String value) {
            addCriterion("tablename =", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotEqualTo(String value) {
            addCriterion("tablename <>", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameGreaterThan(String value) {
            addCriterion("tablename >", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameGreaterThanOrEqualTo(String value) {
            addCriterion("tablename >=", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLessThan(String value) {
            addCriterion("tablename <", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLessThanOrEqualTo(String value) {
            addCriterion("tablename <=", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLike(String value) {
            addCriterion("tablename like", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotLike(String value) {
            addCriterion("tablename not like", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameIn(List<String> values) {
            addCriterion("tablename in", values, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotIn(List<String> values) {
            addCriterion("tablename not in", values, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameBetween(String value1, String value2) {
            addCriterion("tablename between", value1, value2, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotBetween(String value1, String value2) {
            addCriterion("tablename not between", value1, value2, "tablename");
            return (Criteria) this;
        }

        public Criteria andFieldlistIsNull() {
            addCriterion("fieldlist is null");
            return (Criteria) this;
        }

        public Criteria andFieldlistIsNotNull() {
            addCriterion("fieldlist is not null");
            return (Criteria) this;
        }

        public Criteria andFieldlistEqualTo(String value) {
            addCriterion("fieldlist =", value, "fieldlist");
            return (Criteria) this;
        }

        public Criteria andFieldlistNotEqualTo(String value) {
            addCriterion("fieldlist <>", value, "fieldlist");
            return (Criteria) this;
        }

        public Criteria andFieldlistGreaterThan(String value) {
            addCriterion("fieldlist >", value, "fieldlist");
            return (Criteria) this;
        }

        public Criteria andFieldlistGreaterThanOrEqualTo(String value) {
            addCriterion("fieldlist >=", value, "fieldlist");
            return (Criteria) this;
        }

        public Criteria andFieldlistLessThan(String value) {
            addCriterion("fieldlist <", value, "fieldlist");
            return (Criteria) this;
        }

        public Criteria andFieldlistLessThanOrEqualTo(String value) {
            addCriterion("fieldlist <=", value, "fieldlist");
            return (Criteria) this;
        }

        public Criteria andFieldlistLike(String value) {
            addCriterion("fieldlist like", value, "fieldlist");
            return (Criteria) this;
        }

        public Criteria andFieldlistNotLike(String value) {
            addCriterion("fieldlist not like", value, "fieldlist");
            return (Criteria) this;
        }

        public Criteria andFieldlistIn(List<String> values) {
            addCriterion("fieldlist in", values, "fieldlist");
            return (Criteria) this;
        }

        public Criteria andFieldlistNotIn(List<String> values) {
            addCriterion("fieldlist not in", values, "fieldlist");
            return (Criteria) this;
        }

        public Criteria andFieldlistBetween(String value1, String value2) {
            addCriterion("fieldlist between", value1, value2, "fieldlist");
            return (Criteria) this;
        }

        public Criteria andFieldlistNotBetween(String value1, String value2) {
            addCriterion("fieldlist not between", value1, value2, "fieldlist");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(String value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(String value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(String value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(String value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLike(String value) {
            addCriterion("createtime like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotLike(String value) {
            addCriterion("createtime not like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<String> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<String> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(String value1, String value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(String value1, String value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andFhtypeIsNull() {
            addCriterion("fhtype is null");
            return (Criteria) this;
        }

        public Criteria andFhtypeIsNotNull() {
            addCriterion("fhtype is not null");
            return (Criteria) this;
        }

        public Criteria andFhtypeEqualTo(String value) {
            addCriterion("fhtype =", value, "fhtype");
            return (Criteria) this;
        }

        public Criteria andFhtypeNotEqualTo(String value) {
            addCriterion("fhtype <>", value, "fhtype");
            return (Criteria) this;
        }

        public Criteria andFhtypeGreaterThan(String value) {
            addCriterion("fhtype >", value, "fhtype");
            return (Criteria) this;
        }

        public Criteria andFhtypeGreaterThanOrEqualTo(String value) {
            addCriterion("fhtype >=", value, "fhtype");
            return (Criteria) this;
        }

        public Criteria andFhtypeLessThan(String value) {
            addCriterion("fhtype <", value, "fhtype");
            return (Criteria) this;
        }

        public Criteria andFhtypeLessThanOrEqualTo(String value) {
            addCriterion("fhtype <=", value, "fhtype");
            return (Criteria) this;
        }

        public Criteria andFhtypeLike(String value) {
            addCriterion("fhtype like", value, "fhtype");
            return (Criteria) this;
        }

        public Criteria andFhtypeNotLike(String value) {
            addCriterion("fhtype not like", value, "fhtype");
            return (Criteria) this;
        }

        public Criteria andFhtypeIn(List<String> values) {
            addCriterion("fhtype in", values, "fhtype");
            return (Criteria) this;
        }

        public Criteria andFhtypeNotIn(List<String> values) {
            addCriterion("fhtype not in", values, "fhtype");
            return (Criteria) this;
        }

        public Criteria andFhtypeBetween(String value1, String value2) {
            addCriterion("fhtype between", value1, value2, "fhtype");
            return (Criteria) this;
        }

        public Criteria andFhtypeNotBetween(String value1, String value2) {
            addCriterion("fhtype not between", value1, value2, "fhtype");
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