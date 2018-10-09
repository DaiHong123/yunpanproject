package cn.qst.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbShareExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbShareExample() {
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

        public Criteria andSidIsNull() {
            addCriterion("sid is null");
            return (Criteria) this;
        }

        public Criteria andSidIsNotNull() {
            addCriterion("sid is not null");
            return (Criteria) this;
        }

        public Criteria andSidEqualTo(String value) {
            addCriterion("sid =", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotEqualTo(String value) {
            addCriterion("sid <>", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThan(String value) {
            addCriterion("sid >", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThanOrEqualTo(String value) {
            addCriterion("sid >=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThan(String value) {
            addCriterion("sid <", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThanOrEqualTo(String value) {
            addCriterion("sid <=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLike(String value) {
            addCriterion("sid like", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotLike(String value) {
            addCriterion("sid not like", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidIn(List<String> values) {
            addCriterion("sid in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotIn(List<String> values) {
            addCriterion("sid not in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidBetween(String value1, String value2) {
            addCriterion("sid between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotBetween(String value1, String value2) {
            addCriterion("sid not between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andFidsIsNull() {
            addCriterion("fids is null");
            return (Criteria) this;
        }

        public Criteria andFidsIsNotNull() {
            addCriterion("fids is not null");
            return (Criteria) this;
        }

        public Criteria andFidsEqualTo(String value) {
            addCriterion("fids =", value, "fids");
            return (Criteria) this;
        }

        public Criteria andFidsNotEqualTo(String value) {
            addCriterion("fids <>", value, "fids");
            return (Criteria) this;
        }

        public Criteria andFidsGreaterThan(String value) {
            addCriterion("fids >", value, "fids");
            return (Criteria) this;
        }

        public Criteria andFidsGreaterThanOrEqualTo(String value) {
            addCriterion("fids >=", value, "fids");
            return (Criteria) this;
        }

        public Criteria andFidsLessThan(String value) {
            addCriterion("fids <", value, "fids");
            return (Criteria) this;
        }

        public Criteria andFidsLessThanOrEqualTo(String value) {
            addCriterion("fids <=", value, "fids");
            return (Criteria) this;
        }

        public Criteria andFidsLike(String value) {
            addCriterion("fids like", value, "fids");
            return (Criteria) this;
        }

        public Criteria andFidsNotLike(String value) {
            addCriterion("fids not like", value, "fids");
            return (Criteria) this;
        }

        public Criteria andFidsIn(List<String> values) {
            addCriterion("fids in", values, "fids");
            return (Criteria) this;
        }

        public Criteria andFidsNotIn(List<String> values) {
            addCriterion("fids not in", values, "fids");
            return (Criteria) this;
        }

        public Criteria andFidsBetween(String value1, String value2) {
            addCriterion("fids between", value1, value2, "fids");
            return (Criteria) this;
        }

        public Criteria andFidsNotBetween(String value1, String value2) {
            addCriterion("fids not between", value1, value2, "fids");
            return (Criteria) this;
        }

        public Criteria andSharetimeIsNull() {
            addCriterion("sharetime is null");
            return (Criteria) this;
        }

        public Criteria andSharetimeIsNotNull() {
            addCriterion("sharetime is not null");
            return (Criteria) this;
        }

        public Criteria andSharetimeEqualTo(Date value) {
            addCriterion("sharetime =", value, "sharetime");
            return (Criteria) this;
        }

        public Criteria andSharetimeNotEqualTo(Date value) {
            addCriterion("sharetime <>", value, "sharetime");
            return (Criteria) this;
        }

        public Criteria andSharetimeGreaterThan(Date value) {
            addCriterion("sharetime >", value, "sharetime");
            return (Criteria) this;
        }

        public Criteria andSharetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sharetime >=", value, "sharetime");
            return (Criteria) this;
        }

        public Criteria andSharetimeLessThan(Date value) {
            addCriterion("sharetime <", value, "sharetime");
            return (Criteria) this;
        }

        public Criteria andSharetimeLessThanOrEqualTo(Date value) {
            addCriterion("sharetime <=", value, "sharetime");
            return (Criteria) this;
        }

        public Criteria andSharetimeIn(List<Date> values) {
            addCriterion("sharetime in", values, "sharetime");
            return (Criteria) this;
        }

        public Criteria andSharetimeNotIn(List<Date> values) {
            addCriterion("sharetime not in", values, "sharetime");
            return (Criteria) this;
        }

        public Criteria andSharetimeBetween(Date value1, Date value2) {
            addCriterion("sharetime between", value1, value2, "sharetime");
            return (Criteria) this;
        }

        public Criteria andSharetimeNotBetween(Date value1, Date value2) {
            addCriterion("sharetime not between", value1, value2, "sharetime");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(String value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(String value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(String value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(String value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(String value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(String value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLike(String value) {
            addCriterion("uid like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotLike(String value) {
            addCriterion("uid not like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<String> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<String> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(String value1, String value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(String value1, String value2) {
            addCriterion("uid not between", value1, value2, "uid");
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