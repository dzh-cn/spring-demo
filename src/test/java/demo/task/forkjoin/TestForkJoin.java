package demo.task.forkjoin;

import demo.task.forkjoin.core.GoldFurnace;
import demo.task.forkjoin.core.GoldOre;
import demo.task.forkjoin.core.GoldOreOutcome;
import demo.task.forkjoin.entity.ExecuteResult;

import java.util.*;

/**
 * Fork/Join任务
 *
 * @author: dongzhihua
 * @time: 2018/5/21 17:28:28
 */
public class TestForkJoin {

	static boolean test = false;

	public static void main(String[] args) {
		test = true;
		// 每个任务执行时间的样本
		Collection<Integer> milliSpecimen = getSpecimen(5,50, 2);
		// 数量样本
		Collection<Integer> countSpecimen = getSpecimen(8,10, 3);

		ArrayList<ExecuteResult> list = new ArrayList<>();

		milliSpecimen.forEach(m -> countSpecimen.forEach(c -> list.add(testTask(m, c))));

		System.out.println(list);
//		testFj();
	}

	/**
	 * 获取时间样本
	 * @param span 跨度
	 * @param count 样本数量
	 * @return
	 */
	static Collection<Integer> getSpecimen(int start, int span, int count) {
		List<Integer> specimen = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			specimen.add(span * i + start);
		}
		return specimen;
	}

	/**
	 * 执行任务
	 * @param millis 处理时间
	 * @param count 任务个数
	 * @return
	 */
	public static ExecuteResult testTask(long millis, int count) {
		if (test) {
			ExecuteResult result = new ExecuteResult();
			result.setTaskCount(count);
			result.setOnceMillis(millis);
			System.out.println(String.format("TestForkJoin.testTask millis: %s, count: %s", millis, count));
			return result;
		}
		GoldOreOutcome.dealMillis = millis;

		LinkedList<GoldOre> goldOres = new LinkedList<>();
		for (int i = 0; i < count; i++) {
			goldOres.add(new GoldOre(5, 0.12f));
		}

		long start = System.currentTimeMillis();
		GoldOreOutcome g = new GoldFurnace(goldOres).invoke();
		System.out.println(g);
		long fj = System.currentTimeMillis() - start;
		System.out.println(fj);

		start = System.currentTimeMillis();
		GoldOreOutcome finalG = new GoldOreOutcome();
		goldOres.forEach(e -> finalG.smelt(e.getWeight(), e.getTenorInGold()));
		System.out.println(finalG);
		long comm = System.currentTimeMillis() - start;
		System.out.println(comm);

		float scale = 1;
		scale = scale * fj / comm;

		ExecuteResult executeResult = new ExecuteResult();
		executeResult.setFjTotalMillis(fj);
		executeResult.setOnceMillis(millis);
		executeResult.setTaskCount(count);
		executeResult.setTotalMillis(comm);
		executeResult.setScale(scale);
		executeResult.setFjThreadCount(GoldFurnace.getThreadCount());
		GoldFurnace.clear();
		return executeResult;
//		return String.format("count: %d, millis: %d, common:%d, fj:%d, scale: %f", count, millis, comm, fj, scale);
	}
}
