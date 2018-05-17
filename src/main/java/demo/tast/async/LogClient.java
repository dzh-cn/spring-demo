package demo.tast.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * client
 *
 * @author: dongzhihua
 * @time: 2018/5/17 12:13:16
 */
@Component
public class LogClient {

	@Autowired
	LogService logService;

	private static Logger logger = LoggerFactory.getLogger(LogClient.class);

	public void asyncLog(String message) {
//		logger.info("LogClient.asyncLog before: {}", message);
		logService.log(message);
//		logger.info("LogClient.asyncLog after: {}", message);
	}
}
