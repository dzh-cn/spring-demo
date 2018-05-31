package demo.task.async.exceptionHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * AsyncExceptionHandler
 *
 * @author: dongzhihua
 * @time: 2018/5/23 14:47:32
 */
@Component("customerAsyncUncaughtExceptionHandler")
public class CustomerAsyncUncaughtExceptionHandler implements AsyncUncaughtExceptionHandler {
	private static Logger logger = LoggerFactory.getLogger(CustomerAsyncUncaughtExceptionHandler.class);
	@Override
	public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
		logger.warn("CustomerAsyncUncaughtExceptionHandler.handleUncaughtException error: {}", throwable.getMessage());
	}
}
