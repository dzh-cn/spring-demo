package demo.task.forkjoin;

import demo.task.forkjoin.entity.ExecuteResult;
import demo.task.forkjoin.mapper.ExecuteResultMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 记录执行统计数据
 *
 * @author: dongzhihua
 * @time: 2018/5/22 12:50:13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:forkjoin/applicationContext.xml")
public class RecordTestResult {

	@Autowired
	ExecuteResultMapper executeResultMapper;

	@Test
	public void testRecord() {
		TestForkJoin.test = false;
		// 每个任务执行时间的样本 10
		Collection<Integer> milliSpecimen = TestForkJoin.getSpecimen(350,50, 3);
		// 数量样本 20
		Collection<Integer> countSpecimen = TestForkJoin.getSpecimen(10,10, 20);

		milliSpecimen.forEach(m -> countSpecimen.forEach(c -> executeResultMapper.insert(TestForkJoin.testTask(m, c))));
	}
}
