package com.ud.basic.common.util;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Component;

import com.ud.basic.common.core.exception.CommonBizException;
import com.ud.basic.common.enums.ResultCode;

import lombok.extern.slf4j.Slf4j;



/**
 * 参数验证器
 * @author lzp
 * @date 2017年10月23日
 */
@Component
@Slf4j
public class ParamValidator<T> {

//	protected static Logger logger = Logger.getLogger(ParamValidator.class);

    public static <T> void validate(T t){

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator =  factory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);

        if(!constraintViolations.isEmpty()){
            StringBuilder errors = new StringBuilder();
            int i = 0 ;
            int size = constraintViolations.size();
            for (ConstraintViolation<T> constraintViolation : constraintViolations) {
                errors.append(constraintViolation.getMessage()+
                		(++i == size ? "" : "&"));
            }
            log.error("==========参数验证出错！==========="+errors);
            throw new CommonBizException(ResultCode.REQUEST_PARAM_ILLEGAL.getModel(), errors.toString());
        }
    }
}
