package per.ymm.weixiubao.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrdersExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTextInfoIsNull() {
            addCriterion("text_info is null");
            return (Criteria) this;
        }

        public Criteria andTextInfoIsNotNull() {
            addCriterion("text_info is not null");
            return (Criteria) this;
        }

        public Criteria andTextInfoEqualTo(String value) {
            addCriterion("text_info =", value, "textInfo");
            return (Criteria) this;
        }

        public Criteria andTextInfoNotEqualTo(String value) {
            addCriterion("text_info <>", value, "textInfo");
            return (Criteria) this;
        }

        public Criteria andTextInfoGreaterThan(String value) {
            addCriterion("text_info >", value, "textInfo");
            return (Criteria) this;
        }

        public Criteria andTextInfoGreaterThanOrEqualTo(String value) {
            addCriterion("text_info >=", value, "textInfo");
            return (Criteria) this;
        }

        public Criteria andTextInfoLessThan(String value) {
            addCriterion("text_info <", value, "textInfo");
            return (Criteria) this;
        }

        public Criteria andTextInfoLessThanOrEqualTo(String value) {
            addCriterion("text_info <=", value, "textInfo");
            return (Criteria) this;
        }

        public Criteria andTextInfoLike(String value) {
            addCriterion("text_info like", value, "textInfo");
            return (Criteria) this;
        }

        public Criteria andTextInfoNotLike(String value) {
            addCriterion("text_info not like", value, "textInfo");
            return (Criteria) this;
        }

        public Criteria andTextInfoIn(List<String> values) {
            addCriterion("text_info in", values, "textInfo");
            return (Criteria) this;
        }

        public Criteria andTextInfoNotIn(List<String> values) {
            addCriterion("text_info not in", values, "textInfo");
            return (Criteria) this;
        }

        public Criteria andTextInfoBetween(String value1, String value2) {
            addCriterion("text_info between", value1, value2, "textInfo");
            return (Criteria) this;
        }

        public Criteria andTextInfoNotBetween(String value1, String value2) {
            addCriterion("text_info not between", value1, value2, "textInfo");
            return (Criteria) this;
        }

        public Criteria andPicInfoIsNull() {
            addCriterion("pic_info is null");
            return (Criteria) this;
        }

        public Criteria andPicInfoIsNotNull() {
            addCriterion("pic_info is not null");
            return (Criteria) this;
        }

        public Criteria andPicInfoEqualTo(String value) {
            addCriterion("pic_info =", value, "picInfo");
            return (Criteria) this;
        }

        public Criteria andPicInfoNotEqualTo(String value) {
            addCriterion("pic_info <>", value, "picInfo");
            return (Criteria) this;
        }

        public Criteria andPicInfoGreaterThan(String value) {
            addCriterion("pic_info >", value, "picInfo");
            return (Criteria) this;
        }

        public Criteria andPicInfoGreaterThanOrEqualTo(String value) {
            addCriterion("pic_info >=", value, "picInfo");
            return (Criteria) this;
        }

        public Criteria andPicInfoLessThan(String value) {
            addCriterion("pic_info <", value, "picInfo");
            return (Criteria) this;
        }

        public Criteria andPicInfoLessThanOrEqualTo(String value) {
            addCriterion("pic_info <=", value, "picInfo");
            return (Criteria) this;
        }

        public Criteria andPicInfoLike(String value) {
            addCriterion("pic_info like", value, "picInfo");
            return (Criteria) this;
        }

        public Criteria andPicInfoNotLike(String value) {
            addCriterion("pic_info not like", value, "picInfo");
            return (Criteria) this;
        }

        public Criteria andPicInfoIn(List<String> values) {
            addCriterion("pic_info in", values, "picInfo");
            return (Criteria) this;
        }

        public Criteria andPicInfoNotIn(List<String> values) {
            addCriterion("pic_info not in", values, "picInfo");
            return (Criteria) this;
        }

        public Criteria andPicInfoBetween(String value1, String value2) {
            addCriterion("pic_info between", value1, value2, "picInfo");
            return (Criteria) this;
        }

        public Criteria andPicInfoNotBetween(String value1, String value2) {
            addCriterion("pic_info not between", value1, value2, "picInfo");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNull() {
            addCriterion("user_phone is null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNotNull() {
            addCriterion("user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneEqualTo(String value) {
            addCriterion("user_phone =", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotEqualTo(String value) {
            addCriterion("user_phone <>", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThan(String value) {
            addCriterion("user_phone >", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("user_phone >=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThan(String value) {
            addCriterion("user_phone <", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("user_phone <=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLike(String value) {
            addCriterion("user_phone like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotLike(String value) {
            addCriterion("user_phone not like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIn(List<String> values) {
            addCriterion("user_phone in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotIn(List<String> values) {
            addCriterion("user_phone not in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneBetween(String value1, String value2) {
            addCriterion("user_phone between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotBetween(String value1, String value2) {
            addCriterion("user_phone not between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andModeIsNull() {
            addCriterion("mode is null");
            return (Criteria) this;
        }

        public Criteria andModeIsNotNull() {
            addCriterion("mode is not null");
            return (Criteria) this;
        }

        public Criteria andModeEqualTo(Integer value) {
            addCriterion("mode =", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeNotEqualTo(Integer value) {
            addCriterion("mode <>", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeGreaterThan(Integer value) {
            addCriterion("mode >", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeGreaterThanOrEqualTo(Integer value) {
            addCriterion("mode >=", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeLessThan(Integer value) {
            addCriterion("mode <", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeLessThanOrEqualTo(Integer value) {
            addCriterion("mode <=", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeIn(List<Integer> values) {
            addCriterion("mode in", values, "mode");
            return (Criteria) this;
        }

        public Criteria andModeNotIn(List<Integer> values) {
            addCriterion("mode not in", values, "mode");
            return (Criteria) this;
        }

        public Criteria andModeBetween(Integer value1, Integer value2) {
            addCriterion("mode between", value1, value2, "mode");
            return (Criteria) this;
        }

        public Criteria andModeNotBetween(Integer value1, Integer value2) {
            addCriterion("mode not between", value1, value2, "mode");
            return (Criteria) this;
        }

        public Criteria andBackPersonIsNull() {
            addCriterion("back_person is null");
            return (Criteria) this;
        }

        public Criteria andBackPersonIsNotNull() {
            addCriterion("back_person is not null");
            return (Criteria) this;
        }

        public Criteria andBackPersonEqualTo(String value) {
            addCriterion("back_person =", value, "backPerson");
            return (Criteria) this;
        }

        public Criteria andBackPersonNotEqualTo(String value) {
            addCriterion("back_person <>", value, "backPerson");
            return (Criteria) this;
        }

        public Criteria andBackPersonGreaterThan(String value) {
            addCriterion("back_person >", value, "backPerson");
            return (Criteria) this;
        }

        public Criteria andBackPersonGreaterThanOrEqualTo(String value) {
            addCriterion("back_person >=", value, "backPerson");
            return (Criteria) this;
        }

        public Criteria andBackPersonLessThan(String value) {
            addCriterion("back_person <", value, "backPerson");
            return (Criteria) this;
        }

        public Criteria andBackPersonLessThanOrEqualTo(String value) {
            addCriterion("back_person <=", value, "backPerson");
            return (Criteria) this;
        }

        public Criteria andBackPersonLike(String value) {
            addCriterion("back_person like", value, "backPerson");
            return (Criteria) this;
        }

        public Criteria andBackPersonNotLike(String value) {
            addCriterion("back_person not like", value, "backPerson");
            return (Criteria) this;
        }

        public Criteria andBackPersonIn(List<String> values) {
            addCriterion("back_person in", values, "backPerson");
            return (Criteria) this;
        }

        public Criteria andBackPersonNotIn(List<String> values) {
            addCriterion("back_person not in", values, "backPerson");
            return (Criteria) this;
        }

        public Criteria andBackPersonBetween(String value1, String value2) {
            addCriterion("back_person between", value1, value2, "backPerson");
            return (Criteria) this;
        }

        public Criteria andBackPersonNotBetween(String value1, String value2) {
            addCriterion("back_person not between", value1, value2, "backPerson");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPayModeIsNull() {
            addCriterion("pay_mode is null");
            return (Criteria) this;
        }

        public Criteria andPayModeIsNotNull() {
            addCriterion("pay_mode is not null");
            return (Criteria) this;
        }

        public Criteria andPayModeEqualTo(Integer value) {
            addCriterion("pay_mode =", value, "payMode");
            return (Criteria) this;
        }

        public Criteria andPayModeNotEqualTo(Integer value) {
            addCriterion("pay_mode <>", value, "payMode");
            return (Criteria) this;
        }

        public Criteria andPayModeGreaterThan(Integer value) {
            addCriterion("pay_mode >", value, "payMode");
            return (Criteria) this;
        }

        public Criteria andPayModeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_mode >=", value, "payMode");
            return (Criteria) this;
        }

        public Criteria andPayModeLessThan(Integer value) {
            addCriterion("pay_mode <", value, "payMode");
            return (Criteria) this;
        }

        public Criteria andPayModeLessThanOrEqualTo(Integer value) {
            addCriterion("pay_mode <=", value, "payMode");
            return (Criteria) this;
        }

        public Criteria andPayModeIn(List<Integer> values) {
            addCriterion("pay_mode in", values, "payMode");
            return (Criteria) this;
        }

        public Criteria andPayModeNotIn(List<Integer> values) {
            addCriterion("pay_mode not in", values, "payMode");
            return (Criteria) this;
        }

        public Criteria andPayModeBetween(Integer value1, Integer value2) {
            addCriterion("pay_mode between", value1, value2, "payMode");
            return (Criteria) this;
        }

        public Criteria andPayModeNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_mode not between", value1, value2, "payMode");
            return (Criteria) this;
        }

        public Criteria andEvaluateIsNull() {
            addCriterion("evaluate is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateIsNotNull() {
            addCriterion("evaluate is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateEqualTo(String value) {
            addCriterion("evaluate =", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateNotEqualTo(String value) {
            addCriterion("evaluate <>", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateGreaterThan(String value) {
            addCriterion("evaluate >", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateGreaterThanOrEqualTo(String value) {
            addCriterion("evaluate >=", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateLessThan(String value) {
            addCriterion("evaluate <", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateLessThanOrEqualTo(String value) {
            addCriterion("evaluate <=", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateLike(String value) {
            addCriterion("evaluate like", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateNotLike(String value) {
            addCriterion("evaluate not like", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateIn(List<String> values) {
            addCriterion("evaluate in", values, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateNotIn(List<String> values) {
            addCriterion("evaluate not in", values, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateBetween(String value1, String value2) {
            addCriterion("evaluate between", value1, value2, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateNotBetween(String value1, String value2) {
            addCriterion("evaluate not between", value1, value2, "evaluate");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIsNull() {
            addCriterion("receive_time is null");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIsNotNull() {
            addCriterion("receive_time is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeEqualTo(Date value) {
            addCriterion("receive_time =", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotEqualTo(Date value) {
            addCriterion("receive_time <>", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeGreaterThan(Date value) {
            addCriterion("receive_time >", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("receive_time >=", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeLessThan(Date value) {
            addCriterion("receive_time <", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeLessThanOrEqualTo(Date value) {
            addCriterion("receive_time <=", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIn(List<Date> values) {
            addCriterion("receive_time in", values, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotIn(List<Date> values) {
            addCriterion("receive_time not in", values, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeBetween(Date value1, Date value2) {
            addCriterion("receive_time between", value1, value2, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotBetween(Date value1, Date value2) {
            addCriterion("receive_time not between", value1, value2, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEngineerIdIsNull() {
            addCriterion("engineer_id is null");
            return (Criteria) this;
        }

        public Criteria andEngineerIdIsNotNull() {
            addCriterion("engineer_id is not null");
            return (Criteria) this;
        }

        public Criteria andEngineerIdEqualTo(Integer value) {
            addCriterion("engineer_id =", value, "engineerId");
            return (Criteria) this;
        }

        public Criteria andEngineerIdNotEqualTo(Integer value) {
            addCriterion("engineer_id <>", value, "engineerId");
            return (Criteria) this;
        }

        public Criteria andEngineerIdGreaterThan(Integer value) {
            addCriterion("engineer_id >", value, "engineerId");
            return (Criteria) this;
        }

        public Criteria andEngineerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("engineer_id >=", value, "engineerId");
            return (Criteria) this;
        }

        public Criteria andEngineerIdLessThan(Integer value) {
            addCriterion("engineer_id <", value, "engineerId");
            return (Criteria) this;
        }

        public Criteria andEngineerIdLessThanOrEqualTo(Integer value) {
            addCriterion("engineer_id <=", value, "engineerId");
            return (Criteria) this;
        }

        public Criteria andEngineerIdIn(List<Integer> values) {
            addCriterion("engineer_id in", values, "engineerId");
            return (Criteria) this;
        }

        public Criteria andEngineerIdNotIn(List<Integer> values) {
            addCriterion("engineer_id not in", values, "engineerId");
            return (Criteria) this;
        }

        public Criteria andEngineerIdBetween(Integer value1, Integer value2) {
            addCriterion("engineer_id between", value1, value2, "engineerId");
            return (Criteria) this;
        }

        public Criteria andEngineerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("engineer_id not between", value1, value2, "engineerId");
            return (Criteria) this;
        }

        public Criteria andUserOpenidIsNull() {
            addCriterion("user_openid is null");
            return (Criteria) this;
        }

        public Criteria andUserOpenidIsNotNull() {
            addCriterion("user_openid is not null");
            return (Criteria) this;
        }

        public Criteria andUserOpenidEqualTo(String value) {
            addCriterion("user_openid =", value, "userOpenid");
            return (Criteria) this;
        }

        public Criteria andUserOpenidNotEqualTo(String value) {
            addCriterion("user_openid <>", value, "userOpenid");
            return (Criteria) this;
        }

        public Criteria andUserOpenidGreaterThan(String value) {
            addCriterion("user_openid >", value, "userOpenid");
            return (Criteria) this;
        }

        public Criteria andUserOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("user_openid >=", value, "userOpenid");
            return (Criteria) this;
        }

        public Criteria andUserOpenidLessThan(String value) {
            addCriterion("user_openid <", value, "userOpenid");
            return (Criteria) this;
        }

        public Criteria andUserOpenidLessThanOrEqualTo(String value) {
            addCriterion("user_openid <=", value, "userOpenid");
            return (Criteria) this;
        }

        public Criteria andUserOpenidLike(String value) {
            addCriterion("user_openid like", value, "userOpenid");
            return (Criteria) this;
        }

        public Criteria andUserOpenidNotLike(String value) {
            addCriterion("user_openid not like", value, "userOpenid");
            return (Criteria) this;
        }

        public Criteria andUserOpenidIn(List<String> values) {
            addCriterion("user_openid in", values, "userOpenid");
            return (Criteria) this;
        }

        public Criteria andUserOpenidNotIn(List<String> values) {
            addCriterion("user_openid not in", values, "userOpenid");
            return (Criteria) this;
        }

        public Criteria andUserOpenidBetween(String value1, String value2) {
            addCriterion("user_openid between", value1, value2, "userOpenid");
            return (Criteria) this;
        }

        public Criteria andUserOpenidNotBetween(String value1, String value2) {
            addCriterion("user_openid not between", value1, value2, "userOpenid");
            return (Criteria) this;
        }

        public Criteria andCurrentOrderIsNull() {
            addCriterion("current_order is null");
            return (Criteria) this;
        }

        public Criteria andCurrentOrderIsNotNull() {
            addCriterion("current_order is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentOrderEqualTo(Integer value) {
            addCriterion("current_order =", value, "currentOrder");
            return (Criteria) this;
        }

        public Criteria andCurrentOrderNotEqualTo(Integer value) {
            addCriterion("current_order <>", value, "currentOrder");
            return (Criteria) this;
        }

        public Criteria andCurrentOrderGreaterThan(Integer value) {
            addCriterion("current_order >", value, "currentOrder");
            return (Criteria) this;
        }

        public Criteria andCurrentOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("current_order >=", value, "currentOrder");
            return (Criteria) this;
        }

        public Criteria andCurrentOrderLessThan(Integer value) {
            addCriterion("current_order <", value, "currentOrder");
            return (Criteria) this;
        }

        public Criteria andCurrentOrderLessThanOrEqualTo(Integer value) {
            addCriterion("current_order <=", value, "currentOrder");
            return (Criteria) this;
        }

        public Criteria andCurrentOrderIn(List<Integer> values) {
            addCriterion("current_order in", values, "currentOrder");
            return (Criteria) this;
        }

        public Criteria andCurrentOrderNotIn(List<Integer> values) {
            addCriterion("current_order not in", values, "currentOrder");
            return (Criteria) this;
        }

        public Criteria andCurrentOrderBetween(Integer value1, Integer value2) {
            addCriterion("current_order between", value1, value2, "currentOrder");
            return (Criteria) this;
        }

        public Criteria andCurrentOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("current_order not between", value1, value2, "currentOrder");
            return (Criteria) this;
        }

        public Criteria andOrderAddressIsNull() {
            addCriterion("order_address is null");
            return (Criteria) this;
        }

        public Criteria andOrderAddressIsNotNull() {
            addCriterion("order_address is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAddressEqualTo(String value) {
            addCriterion("order_address =", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressNotEqualTo(String value) {
            addCriterion("order_address <>", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressGreaterThan(String value) {
            addCriterion("order_address >", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressGreaterThanOrEqualTo(String value) {
            addCriterion("order_address >=", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressLessThan(String value) {
            addCriterion("order_address <", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressLessThanOrEqualTo(String value) {
            addCriterion("order_address <=", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressLike(String value) {
            addCriterion("order_address like", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressNotLike(String value) {
            addCriterion("order_address not like", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressIn(List<String> values) {
            addCriterion("order_address in", values, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressNotIn(List<String> values) {
            addCriterion("order_address not in", values, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressBetween(String value1, String value2) {
            addCriterion("order_address between", value1, value2, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressNotBetween(String value1, String value2) {
            addCriterion("order_address not between", value1, value2, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andXLocationIsNull() {
            addCriterion("x_location is null");
            return (Criteria) this;
        }

        public Criteria andXLocationIsNotNull() {
            addCriterion("x_location is not null");
            return (Criteria) this;
        }

        public Criteria andXLocationEqualTo(Double value) {
            addCriterion("x_location =", value, "xLocation");
            return (Criteria) this;
        }

        public Criteria andXLocationNotEqualTo(Double value) {
            addCriterion("x_location <>", value, "xLocation");
            return (Criteria) this;
        }

        public Criteria andXLocationGreaterThan(Double value) {
            addCriterion("x_location >", value, "xLocation");
            return (Criteria) this;
        }

        public Criteria andXLocationGreaterThanOrEqualTo(Double value) {
            addCriterion("x_location >=", value, "xLocation");
            return (Criteria) this;
        }

        public Criteria andXLocationLessThan(Double value) {
            addCriterion("x_location <", value, "xLocation");
            return (Criteria) this;
        }

        public Criteria andXLocationLessThanOrEqualTo(Double value) {
            addCriterion("x_location <=", value, "xLocation");
            return (Criteria) this;
        }

        public Criteria andXLocationIn(List<Double> values) {
            addCriterion("x_location in", values, "xLocation");
            return (Criteria) this;
        }

        public Criteria andXLocationNotIn(List<Double> values) {
            addCriterion("x_location not in", values, "xLocation");
            return (Criteria) this;
        }

        public Criteria andXLocationBetween(Double value1, Double value2) {
            addCriterion("x_location between", value1, value2, "xLocation");
            return (Criteria) this;
        }

        public Criteria andXLocationNotBetween(Double value1, Double value2) {
            addCriterion("x_location not between", value1, value2, "xLocation");
            return (Criteria) this;
        }

        public Criteria andYLocationIsNull() {
            addCriterion("y_location is null");
            return (Criteria) this;
        }

        public Criteria andYLocationIsNotNull() {
            addCriterion("y_location is not null");
            return (Criteria) this;
        }

        public Criteria andYLocationEqualTo(Double value) {
            addCriterion("y_location =", value, "yLocation");
            return (Criteria) this;
        }

        public Criteria andYLocationNotEqualTo(Double value) {
            addCriterion("y_location <>", value, "yLocation");
            return (Criteria) this;
        }

        public Criteria andYLocationGreaterThan(Double value) {
            addCriterion("y_location >", value, "yLocation");
            return (Criteria) this;
        }

        public Criteria andYLocationGreaterThanOrEqualTo(Double value) {
            addCriterion("y_location >=", value, "yLocation");
            return (Criteria) this;
        }

        public Criteria andYLocationLessThan(Double value) {
            addCriterion("y_location <", value, "yLocation");
            return (Criteria) this;
        }

        public Criteria andYLocationLessThanOrEqualTo(Double value) {
            addCriterion("y_location <=", value, "yLocation");
            return (Criteria) this;
        }

        public Criteria andYLocationIn(List<Double> values) {
            addCriterion("y_location in", values, "yLocation");
            return (Criteria) this;
        }

        public Criteria andYLocationNotIn(List<Double> values) {
            addCriterion("y_location not in", values, "yLocation");
            return (Criteria) this;
        }

        public Criteria andYLocationBetween(Double value1, Double value2) {
            addCriterion("y_location between", value1, value2, "yLocation");
            return (Criteria) this;
        }

        public Criteria andYLocationNotBetween(Double value1, Double value2) {
            addCriterion("y_location not between", value1, value2, "yLocation");
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