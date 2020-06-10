package com.mhj.exception;

import com.mhj.enums.ResponseCodeEnum;
import com.mhj.web.ResponseObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 自定义异常捕获
     *
     * @param e e
     * @return ResponseObject
     */
    @ExceptionHandler({BaseBusinessException.class})
    public ResponseObject myException(HttpServletRequest request, BaseBusinessException e) {
        log.info("请求的url,{}", request.getRequestURI());
        return ResponseObject.fail(ResponseCodeEnum.FAIL.getCode(), e.getMsg());
    }

    /**
     * 运行时异常
     *
     * @param ex e
     * @return ResponseObject info
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseObject runtimeExceptionHandler(HttpServletRequest request, RuntimeException ex) {
        log.info("请求的url,{}运行时异常,{}", request.getRequestURI(), ex);
        return ResponseObject.fail(ResponseCodeEnum.FAIL.getCode(), ResponseCodeEnum.FAIL.getMessage());
    }


    /**
     * 空指针异常
     *
     * @param ex e
     * @return ResponseObject info
     */
    @ExceptionHandler({NullPointerException.class})
    public ResponseObject nullPointerException(HttpServletRequest request, NullPointerException ex) {
        log.info("请求的url,{}空指针异常,{}", request.getRequestURI(), ex);
        return ResponseObject.fail(ResponseCodeEnum.FAIL.getCode(), ResponseCodeEnum.FAIL.getMessage());
    }

    /**
     * 断言参数异常
     *
     * @param ex e
     * @return ResponseObject info
     */
    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseObject illegalArgumentException(HttpServletRequest request, IllegalArgumentException ex) {
        log.info("请求的url,参数异常,{}", request.getRequestURI(), ex);
        return ResponseObject.fail(ResponseCodeEnum.PARAM_ERROR.getCode(), ex.getMessage());
    }


    /**
     * 类型转换异常
     *
     * @param ex e
     * @return ResponseObject info
     */
    @ExceptionHandler({ClassCastException.class})
    public ResponseObject classCastException(HttpServletRequest request, ClassCastException ex) {
        log.info("请求的url,{}类型转换异常,{}", request.getRequestURI(), ex);
        return ResponseObject.fail(ResponseCodeEnum.FAIL.getCode(), ResponseCodeEnum.FAIL.getMessage());
    }


    /**
     * IO异常
     *
     * @param ex e
     * @return ResponseObject info
     */
    @ExceptionHandler({IOException.class})
    public ResponseObject ioException(HttpServletRequest request, IOException ex) {
        log.info("请求的url,{}IO异常,{}", request.getRequestURI(), ex);
        return ResponseObject.fail(ResponseCodeEnum.FAIL.getCode(), ResponseCodeEnum.FAIL.getMessage());
    }


    /**
     * 未知方法异常
     *
     * @param ex e
     * @return ResponseObject info
     */
    @ExceptionHandler(NoSuchMethodException.class)
    public ResponseObject noSuchMethodException(HttpServletRequest request, NoSuchMethodException ex) {
        log.info("请求的url,{}未知方法异常,{}", request.getRequestURI(), ex);
        return ResponseObject.fail(ResponseCodeEnum.FAIL.getCode(), ResponseCodeEnum.FAIL.getMessage());
    }


    /**
     * 数组越界异常
     *
     * @param ex e
     * @return ResponseObject info
     */
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseObject indexOutOfBoundsExceptionHandler(HttpServletRequest request, IndexOutOfBoundsException ex) {
        log.info("请求的url,{}数组越界异常,{}", request.getRequestURI(), ex);
        return ResponseObject.fail(ResponseCodeEnum.FAIL.getCode(), ResponseCodeEnum.FAIL.getMessage());
    }


    /**
     * 栈溢出
     *
     * @param ex e
     * @return ResponseObject info
     */
    @ExceptionHandler({StackOverflowError.class})
    public ResponseObject requestStackOverflow(HttpServletRequest request, StackOverflowError ex) {
        log.info("请求的url,{}栈溢出,{}", request.getRequestURI(), ex);
        return ResponseObject.fail(ResponseCodeEnum.FAIL.getCode(), ResponseCodeEnum.FAIL.getMessage());
    }


    /**
     * 其他错误
     *
     * @param ex e
     * @return ResponseObject info
     */
    @ExceptionHandler({Exception.class})
    public ResponseObject exception(HttpServletRequest request, Exception ex) {
        log.info("请求的url,{}出现异常", request.getRequestURI(), ex);
        return ResponseObject.fail(ResponseCodeEnum.FAIL.getCode(), ResponseCodeEnum.FAIL.getMessage());
    }

}
