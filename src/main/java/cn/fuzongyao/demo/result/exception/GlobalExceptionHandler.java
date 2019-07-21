package cn.fuzongyao.demo.result.exception;

import cn.fuzongyao.result.result.GlobalCodeMessageEnum;
import cn.fuzongyao.result.result.ObjectResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;

/**
 * <p>SpringBoot 全局异常处理</p>
 *
 * @author fuzongyao
 * @date 2019-07-20 13:37
 * @since 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private final static Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 业务异全局处理, 未处理的所有异常在此拦截并处理
     *
     * @param e 异常对象
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ObjectResult<String> exceptionHandler(Exception e) {
        LOGGER.error("", e);
        ObjectResult<String> result = new ObjectResult<String>(GlobalCodeMessageEnum.ERROR).setData(e.getMessage());
        return result;
    }

    @ExceptionHandler({BindException.class})
    public ObjectResult<String> bindExceptionHandler(BindException e) {
        LOGGER.error("发生参数类型不一致异常", e);
        ObjectResult<String> result = new ObjectResult<String>(GlobalCodeMessageEnum.PARAMENTER_TYPE_INCONFORMITY).setData(e.getMessage());
        return result;
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public ObjectResult<String> paramenterExceptionHandler(MethodArgumentTypeMismatchException e) {
        LOGGER.error("发生参数类型不一致异常", e);
        ObjectResult<String> result = new ObjectResult<String>(GlobalCodeMessageEnum.PARAMENTER_TYPE_INCONFORMITY).setData(e.getMessage());
        return result;
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ObjectResult<String> paramenterExceptionHandler(MethodArgumentNotValidException e) {
        LOGGER.error("发生参数不合法异常", e);
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        String tips = "参数不合法";
        if (errors.size() > 0) {
            tips = errors.get(0).getDefaultMessage();
        }

        ObjectResult<String> result = new ObjectResult<String>(GlobalCodeMessageEnum.PARAMENTER_NOT_VALID).setData(tips);
        return result;
    }

    @ExceptionHandler({MissingServletRequestParameterException.class, HttpMessageNotReadableException.class})
    public ObjectResult<String> paramenterExceptionHandler(Exception e) {
        LOGGER.error("发生参数不合法异常", e);
        ObjectResult<String> result = new ObjectResult<String>(GlobalCodeMessageEnum.PARAMENTER_NOT_VALID).setData(e.getMessage());
        return result;
    }
}
