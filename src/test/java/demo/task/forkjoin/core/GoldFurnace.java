package demo.task.forkjoin.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.RecursiveTask;

/**
 * 炼金炉
 *
 * @author: dongzhihua
 * @time: 2018/5/21 17:35:28
 */
public class GoldFurnace extends RecursiveTask<GoldOreOutcome> {

	private static Logger logger = LoggerFactory.getLogger(GoldFurnace.class);

	private static Set<String> threadSet = new HashSet<>();

	public GoldFurnace(LinkedList<GoldOre> goldOres) {
		if (goldOres == null || goldOres.isEmpty()) {
			return;
		}
		this.goldOres = goldOres;
		end = goldOres.size();
	}
	protected GoldFurnace(LinkedList<GoldOre> goldOres, int start, int end) {
		this.goldOres = goldOres;
		this.start = start;
		this.end = end;
	}

	private LinkedList<GoldOre> goldOres;
	private int start;
	private int end;

	protected GoldOreOutcome compute() {
		addThreadRecord();
		logger.info("GoldFurnace.compute furnace: {}", this);
		if (end == 0) {
			return null;
		}

		if (end - start <= 10) {
			GoldOreOutcome oreOutcome = new GoldOreOutcome();
			goldOres.subList(start, end).forEach(e -> oreOutcome.smelt(e.getWeight(), e.getTenorInGold()));
			return oreOutcome;
		}

		int size = goldOres.size() / 10 + 1;
		List<GoldFurnace> goldFurnaces = new LinkedList<>();
		for (int i = 0; i < size; i++) {
			int en = (i + 1) * 10;
			en = en >= this.goldOres.size() ? this.goldOres.size() : en;
			if(i * 10 < goldOres.size()) {
				goldFurnaces.add(new GoldFurnace(this.goldOres, i * 10, en));
			}
		}

		invokeAll(goldFurnaces);

		GoldOreOutcome oreOutcome = new GoldOreOutcome();
		goldFurnaces.forEach(g -> oreOutcome.superpose(g.join()));

		return oreOutcome;
	}

	static void addThreadRecord() {
		threadSet.add(Thread.currentThread().getName());
	}

	public static int getThreadCount() {
		return threadSet.size();
	}

	public static void clear() {
		threadSet.clear();
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("{");
		sb.append("\"start\":")
				.append(start);
		sb.append(",\"end\":")
				.append(end);
		sb.append('}');
		return sb.toString();
	}
}
