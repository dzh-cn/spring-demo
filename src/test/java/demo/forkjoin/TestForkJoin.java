package demo.forkjoin;

import java.util.LinkedList;

/**
 * Fork/Join任务
 *
 * @author: dongzhihua
 * @time: 2018/5/21 17:28:28
 */
public class TestForkJoin {
	public static void main(String[] args) {
		LinkedList<GoldOre> goldOres = new LinkedList<>();
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));

		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));

		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));

		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));

		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));

		goldOres.add(new GoldOre(5, 0.12f));
		goldOres.add(new GoldOre(5, 0.12f));

		long start = System.currentTimeMillis();
		GoldOreOutcome g = new GoldFurnace(goldOres).invoke();
		System.out.println(g);
		System.out.println((System.currentTimeMillis() - start)/1000f);
	}
}
