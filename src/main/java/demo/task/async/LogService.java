package demo.task.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * service
 *
 * @author: dongzhihua
 * @time: 2018/5/17 12:08:58
 */
@Component
public class LogService {

	private static Logger logger = LoggerFactory.getLogger(LogService.class);

	@Async
	public void log(String message) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			logger.error("LogService.log e: {}", e);
		}
		logger.info("LogService.log message: {}", message);
		throw new RuntimeException("*****");
	}
}
