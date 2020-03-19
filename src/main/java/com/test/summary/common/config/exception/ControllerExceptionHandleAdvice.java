package com.test.summary.common.config.exception;

import com.test.summary.common.constants.ResultEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author 佟星龙
 * @date 2018/6/15.
 */
@RestControllerAdvice
public class ControllerExceptionHandleAdvice {
    private static Logger logger = LoggerFactory.getLogger(ControllerExceptionHandleAdvice.class);

//    @ExceptionHandler
//    public ResultEntity handler(HttpServletRequest req, HttpServletResponse res, Exception ex) throws IOException {
//
//        if (res.getStatus() == HttpStatus.BAD_REQUEST.value()) {
//            logger.info("修改返回状态值为200");
//            res.setStatus(HttpStatus.OK.value());
//        }
//
//        String exceptionName = ex.getClass().getSimpleName();
//
//        switch (exceptionName) {
//            case "BusinessException":
//                break;
//            case "BusinessException1":
//                break;
//            case "BusinessException2":
//                break;
//            case "BonusInsertException":
//                break;
//            case "InvoiceInsertException":
//                break;
//            case "ConstraintViolationException":
//                ConstraintViolationException constraintViolationException = (ConstraintViolationException) ex;
//                Set<ConstraintViolation<?>> constraintViolations = constraintViolationException.getConstraintViolations();
//                Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
//                List<String> msgList = new ArrayList<>();
//                while (iterator.hasNext()) {
//                    ConstraintViolation<?> cvl = iterator.next();
//                    msgList.add(cvl.getMessageTemplate());
//                }
//                return ResultEntity.error("参数校验异常！"+msgList);
//            default:
//                res.sendRedirect("/404");
//                logger.error("ControllerExceptionHandleAdvice:: URL=" + req.getRequestURL(), ex);
//                break;
//        }
//        return ResultEntity.error(ex.getMessage());
//    }
	
	
	@ExceptionHandler
    public ResultEntity handler(HttpServletRequest req, HttpServletResponse res, Exception ex) throws IOException {

        if (res.getStatus() == HttpStatus.BAD_REQUEST.value()) {
            logger.info("修改返回状态值为200");
            res.setStatus(HttpStatus.OK.value());
        }

        String exceptionName = ex.getClass().getSimpleName();
		logger.info("系统异常打印！"+ex);
        switch (exceptionName) {
            case "BusinessException":
                break;
            case "ConcurrentAccessException":
                break;
            case "CustomMessageException":
                break;
			case "ConstraintViolationException":
                break;
            case "IncorrectCredentialsException":
                return ResultEntity.error("用户名密码错误！");
            default:
                ex.printStackTrace();
                return ResultEntity.error("系统异常！"+ ex.getMessage());
        }
		if (exceptionName.equals("ConstraintViolationException")) {
            ConstraintViolationException ex1 = (ConstraintViolationException) ex;
            Set<ConstraintViolation<?>> constraintViolations = ex1.getConstraintViolations();
            Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
            List<String> msgList = new ArrayList<>();
            while (iterator.hasNext()) {
                ConstraintViolation<?> cvl = iterator.next();
                msgList.add(cvl.getMessageTemplate());
            }
            logger.error(ex.getMessage());
            return ResultEntity.error(msgList.get(0).toString());
        }
        if(exceptionName.equals("CustomMessageException")){
            CustomMessageException ex1=(CustomMessageException)ex;
            if(!StringUtils.isEmpty(ex1.getMsgid())){
                return ResultEntity.error(ex1.getMsgid().toString(),ex.getMessage());
            }
        }
        return ResultEntity.error(ex.getMessage());
    }
	
}
