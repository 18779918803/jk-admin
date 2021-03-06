package com.jk.common.validator;


import com.jk.common.bean.ReturnBean;
import com.jk.common.bean.ReturnCode;
import com.jk.common.exception.KrtException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * hibernate-validator校验工具类
 * 参考文档：http://docs.jboss.org/hibernate/validator/5.4/reference/en-US/html_single/
 *
 * @author 缪隽峰
 * @version 1.0
 * @date 2019年12月25日
 */
public class ValidatorUtils {

    private static Validator validator;

    static {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    /**
     * 校验对象
     *
     * @param object 待校验对象
     * @throws KrtException 校验不通过，则报KrtException异常
     */
    public static void validateEntity(Object object, Class<?>... groups) throws KrtException {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            ConstraintViolation<Object> constraint = constraintViolations.iterator().next();
            throw new KrtException(ReturnBean.error(ReturnCode.INVALID_REQUEST.getCode(), constraint.getMessage()));
        }
    }
}
