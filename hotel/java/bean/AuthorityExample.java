package com.java.bean;

import java.util.ArrayList;
import java.util.List;

public class AuthorityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AuthorityExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameIsNull() {
            addCriterion("authority_name is null");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameIsNotNull() {
            addCriterion("authority_name is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameEqualTo(String value) {
            addCriterion("authority_name =", value, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameNotEqualTo(String value) {
            addCriterion("authority_name <>", value, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameGreaterThan(String value) {
            addCriterion("authority_name >", value, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameGreaterThanOrEqualTo(String value) {
            addCriterion("authority_name >=", value, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameLessThan(String value) {
            addCriterion("authority_name <", value, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameLessThanOrEqualTo(String value) {
            addCriterion("authority_name <=", value, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameLike(String value) {
            addCriterion("authority_name like", value, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameNotLike(String value) {
            addCriterion("authority_name not like", value, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameIn(List<String> values) {
            addCriterion("authority_name in", values, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameNotIn(List<String> values) {
            addCriterion("authority_name not in", values, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameBetween(String value1, String value2) {
            addCriterion("authority_name between", value1, value2, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameNotBetween(String value1, String value2) {
            addCriterion("authority_name not between", value1, value2, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityUrlIsNull() {
            addCriterion("authority_url is null");
            return (Criteria) this;
        }

        public Criteria andAuthorityUrlIsNotNull() {
            addCriterion("authority_url is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorityUrlEqualTo(String value) {
            addCriterion("authority_url =", value, "authorityUrl");
            return (Criteria) this;
        }

        public Criteria andAuthorityUrlNotEqualTo(String value) {
            addCriterion("authority_url <>", value, "authorityUrl");
            return (Criteria) this;
        }

        public Criteria andAuthorityUrlGreaterThan(String value) {
            addCriterion("authority_url >", value, "authorityUrl");
            return (Criteria) this;
        }

        public Criteria andAuthorityUrlGreaterThanOrEqualTo(String value) {
            addCriterion("authority_url >=", value, "authorityUrl");
            return (Criteria) this;
        }

        public Criteria andAuthorityUrlLessThan(String value) {
            addCriterion("authority_url <", value, "authorityUrl");
            return (Criteria) this;
        }

        public Criteria andAuthorityUrlLessThanOrEqualTo(String value) {
            addCriterion("authority_url <=", value, "authorityUrl");
            return (Criteria) this;
        }

        public Criteria andAuthorityUrlLike(String value) {
            addCriterion("authority_url like", value, "authorityUrl");
            return (Criteria) this;
        }

        public Criteria andAuthorityUrlNotLike(String value) {
            addCriterion("authority_url not like", value, "authorityUrl");
            return (Criteria) this;
        }

        public Criteria andAuthorityUrlIn(List<String> values) {
            addCriterion("authority_url in", values, "authorityUrl");
            return (Criteria) this;
        }

        public Criteria andAuthorityUrlNotIn(List<String> values) {
            addCriterion("authority_url not in", values, "authorityUrl");
            return (Criteria) this;
        }

        public Criteria andAuthorityUrlBetween(String value1, String value2) {
            addCriterion("authority_url between", value1, value2, "authorityUrl");
            return (Criteria) this;
        }

        public Criteria andAuthorityUrlNotBetween(String value1, String value2) {
            addCriterion("authority_url not between", value1, value2, "authorityUrl");
            return (Criteria) this;
        }

        public Criteria andParentIsNull() {
            addCriterion("parent is null");
            return (Criteria) this;
        }

        public Criteria andParentIsNotNull() {
            addCriterion("parent is not null");
            return (Criteria) this;
        }

        public Criteria andParentEqualTo(Long value) {
            addCriterion("parent =", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentNotEqualTo(Long value) {
            addCriterion("parent <>", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentGreaterThan(Long value) {
            addCriterion("parent >", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentGreaterThanOrEqualTo(Long value) {
            addCriterion("parent >=", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentLessThan(Long value) {
            addCriterion("parent <", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentLessThanOrEqualTo(Long value) {
            addCriterion("parent <=", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentIn(List<Long> values) {
            addCriterion("parent in", values, "parent");
            return (Criteria) this;
        }

        public Criteria andParentNotIn(List<Long> values) {
            addCriterion("parent not in", values, "parent");
            return (Criteria) this;
        }

        public Criteria andParentBetween(Long value1, Long value2) {
            addCriterion("parent between", value1, value2, "parent");
            return (Criteria) this;
        }

        public Criteria andParentNotBetween(Long value1, Long value2) {
            addCriterion("parent not between", value1, value2, "parent");
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