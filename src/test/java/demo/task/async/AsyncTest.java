package demo.task.async;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * test
 *
 * @author: dongzhihua
 * @time: 2018/5/17 11:56:53
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:demo.task/asyncContext.xml")
public class AsyncTest {
	private static Logger logger = LoggerFactory.getLogger(AsyncTest.class);
	@Autowired
	LogService logService;

	@Autowired
	AsyncUncaughtExceptionHandler exceptionHandler;

	@Test
	public void test() {
		for (int i = 0; i < 10; i++) {
			logService.log("log test ..." + i);
		}
		logger.info("AsyncTest.test end: end ...");
		try {
			// 主线程等到任务执行完成再结束
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			logger.error("AsyncTest.test error: {}", e.getMessage());
		}
	}
}
