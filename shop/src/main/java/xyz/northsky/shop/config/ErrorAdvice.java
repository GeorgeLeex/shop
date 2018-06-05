package xyz.northsky.shop.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@ControllerAdvice
public class ErrorAdvice {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler({RuntimeException.class})
    @ResponseStatus(code = HttpStatus.OK)
    public ModelAndView processException(Exception exception) {
        logger.warn("time:" + LocalDateTime.now() + " , errorType : " + exception.getClass() + " , errorMessage : " + exception.getMessage());
        return new ModelAndView("500");
    }

}
