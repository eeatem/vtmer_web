package com.vtmer.domain;

import java.util.ArrayList;
import java.util.List;

public class StatusLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StatusLogExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNull() {
            addCriterion("admin_id is null");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNotNull() {
            addCriterion("admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdminIdEqualTo(Integer value) {
            addCriterion("admin_id =", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotEqualTo(Integer value) {
            addCriterion("admin_id <>", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThan(Integer value) {
            addCriterion("admin_id >", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin_id >=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThan(Integer value) {
            addCriterion("admin_id <", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThanOrEqualTo(Integer value) {
            addCriterion("admin_id <=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdIn(List<Integer> values) {
            addCriterion("admin_id in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotIn(List<Integer> values) {
            addCriterion("admin_id not in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdBetween(Integer value1, Integer value2) {
            addCriterion("admin_id between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotBetween(Integer value1, Integer value2) {
            addCriterion("admin_id not between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andOldStatusIsNull() {
            addCriterion("old_status is null");
            return (Criteria) this;
        }

        public Criteria andOldStatusIsNotNull() {
            addCriterion("old_status is not null");
            return (Criteria) this;
        }

        public Criteria andOldStatusEqualTo(String value) {
            addCriterion("old_status =", value, "oldStatus");
            return (Criteria) this;
        }

        public Criteria andOldStatusNotEqualTo(String value) {
            addCriterion("old_status <>", value, "oldStatus");
            return (Criteria) this;
        }

        public Criteria andOldStatusGreaterThan(String value) {
            addCriterion("old_status >", value, "oldStatus");
            return (Criteria) this;
        }

        public Criteria andOldStatusGreaterThanOrEqualTo(String value) {
            addCriterion("old_status >=", value, "oldStatus");
            return (Criteria) this;
        }

        public Criteria andOldStatusLessThan(String value) {
            addCriterion("old_status <", value, "oldStatus");
            return (Criteria) this;
        }

        public Criteria andOldStatusLessThanOrEqualTo(String value) {
            addCriterion("old_status <=", value, "oldStatus");
            return (Criteria) this;
        }

        public Criteria andOldStatusLike(String value) {
            addCriterion("old_status like", value, "oldStatus");
            return (Criteria) this;
        }

        public Criteria andOldStatusNotLike(String value) {
            addCriterion("old_status not like", value, "oldStatus");
            return (Criteria) this;
        }

        public Criteria andOldStatusIn(List<String> values) {
            addCriterion("old_status in", values, "oldStatus");
            return (Criteria) this;
        }

        public Criteria andOldStatusNotIn(List<String> values) {
            addCriterion("old_status not in", values, "oldStatus");
            return (Criteria) this;
        }

        public Criteria andOldStatusBetween(String value1, String value2) {
            addCriterion("old_status between", value1, value2, "oldStatus");
            return (Criteria) this;
        }

        public Criteria andOldStatusNotBetween(String value1, String value2) {
            addCriterion("old_status not between", value1, value2, "oldStatus");
            return (Criteria) this;
        }

        public Criteria andNewStatusIsNull() {
            addCriterion("new_status is null");
            return (Criteria) this;
        }

        public Criteria andNewStatusIsNotNull() {
            addCriterion("new_status is not null");
            return (Criteria) this;
        }

        public Criteria andNewStatusEqualTo(String value) {
            addCriterion("new_status =", value, "newStatus");
            return (Criteria) this;
        }

        public Criteria andNewStatusNotEqualTo(String value) {
            addCriterion("new_status <>", value, "newStatus");
            return (Criteria) this;
        }

        public Criteria andNewStatusGreaterThan(String value) {
            addCriterion("new_status >", value, "newStatus");
            return (Criteria) this;
        }

        public Criteria andNewStatusGreaterThanOrEqualTo(String value) {
            addCriterion("new_status >=", value, "newStatus");
            return (Criteria) this;
        }

        public Criteria andNewStatusLessThan(String value) {
            addCriterion("new_status <", value, "newStatus");
            return (Criteria) this;
        }

        public Criteria andNewStatusLessThanOrEqualTo(String value) {
            addCriterion("new_status <=", value, "newStatus");
            return (Criteria) this;
        }

        public Criteria andNewStatusLike(String value) {
            addCriterion("new_status like", value, "newStatus");
            return (Criteria) this;
        }

        public Criteria andNewStatusNotLike(String value) {
            addCriterion("new_status not like", value, "newStatus");
            return (Criteria) this;
        }

        public Criteria andNewStatusIn(List<String> values) {
            addCriterion("new_status in", values, "newStatus");
            return (Criteria) this;
        }

        public Criteria andNewStatusNotIn(List<String> values) {
            addCriterion("new_status not in", values, "newStatus");
            return (Criteria) this;
        }

        public Criteria andNewStatusBetween(String value1, String value2) {
            addCriterion("new_status between", value1, value2, "newStatus");
            return (Criteria) this;
        }

        public Criteria andNewStatusNotBetween(String value1, String value2) {
            addCriterion("new_status not between", value1, value2, "newStatus");
            return (Criteria) this;
        }

        public Criteria andVolunteerFlagIsNull() {
            addCriterion("volunteer_flag is null");
            return (Criteria) this;
        }

        public Criteria andVolunteerFlagIsNotNull() {
            addCriterion("volunteer_flag is not null");
            return (Criteria) this;
        }

        public Criteria andVolunteerFlagEqualTo(Integer value) {
            addCriterion("volunteer_flag =", value, "volunteerFlag");
            return (Criteria) this;
        }

        public Criteria andVolunteerFlagNotEqualTo(Integer value) {
            addCriterion("volunteer_flag <>", value, "volunteerFlag");
            return (Criteria) this;
        }

        public Criteria andVolunteerFlagGreaterThan(Integer value) {
            addCriterion("volunteer_flag >", value, "volunteerFlag");
            return (Criteria) this;
        }

        public Criteria andVolunteerFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("volunteer_flag >=", value, "volunteerFlag");
            return (Criteria) this;
        }

        public Criteria andVolunteerFlagLessThan(Integer value) {
            addCriterion("volunteer_flag <", value, "volunteerFlag");
            return (Criteria) this;
        }

        public Criteria andVolunteerFlagLessThanOrEqualTo(Integer value) {
            addCriterion("volunteer_flag <=", value, "volunteerFlag");
            return (Criteria) this;
        }

        public Criteria andVolunteerFlagIn(List<Integer> values) {
            addCriterion("volunteer_flag in", values, "volunteerFlag");
            return (Criteria) this;
        }

        public Criteria andVolunteerFlagNotIn(List<Integer> values) {
            addCriterion("volunteer_flag not in", values, "volunteerFlag");
            return (Criteria) this;
        }

        public Criteria andVolunteerFlagBetween(Integer value1, Integer value2) {
            addCriterion("volunteer_flag between", value1, value2, "volunteerFlag");
            return (Criteria) this;
        }

        public Criteria andVolunteerFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("volunteer_flag not between", value1, value2, "volunteerFlag");
            return (Criteria) this;
        }

        public Criteria andOperationalTimeIsNull() {
            addCriterion("operational_time is null");
            return (Criteria) this;
        }

        public Criteria andOperationalTimeIsNotNull() {
            addCriterion("operational_time is not null");
            return (Criteria) this;
        }

        public Criteria andOperationalTimeEqualTo(Long value) {
            addCriterion("operational_time =", value, "operationalTime");
            return (Criteria) this;
        }

        public Criteria andOperationalTimeNotEqualTo(Long value) {
            addCriterion("operational_time <>", value, "operationalTime");
            return (Criteria) this;
        }

        public Criteria andOperationalTimeGreaterThan(Long value) {
            addCriterion("operational_time >", value, "operationalTime");
            return (Criteria) this;
        }

        public Criteria andOperationalTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("operational_time >=", value, "operationalTime");
            return (Criteria) this;
        }

        public Criteria andOperationalTimeLessThan(Long value) {
            addCriterion("operational_time <", value, "operationalTime");
            return (Criteria) this;
        }

        public Criteria andOperationalTimeLessThanOrEqualTo(Long value) {
            addCriterion("operational_time <=", value, "operationalTime");
            return (Criteria) this;
        }

        public Criteria andOperationalTimeIn(List<Long> values) {
            addCriterion("operational_time in", values, "operationalTime");
            return (Criteria) this;
        }

        public Criteria andOperationalTimeNotIn(List<Long> values) {
            addCriterion("operational_time not in", values, "operationalTime");
            return (Criteria) this;
        }

        public Criteria andOperationalTimeBetween(Long value1, Long value2) {
            addCriterion("operational_time between", value1, value2, "operationalTime");
            return (Criteria) this;
        }

        public Criteria andOperationalTimeNotBetween(Long value1, Long value2) {
            addCriterion("operational_time not between", value1, value2, "operationalTime");
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