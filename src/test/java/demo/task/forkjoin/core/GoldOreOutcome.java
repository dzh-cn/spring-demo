package demo.task.forkjoin.core;

import java.math.BigDecimal;

/**
 * 炼金结果产物
 *
 * @author: dongzhihua
 * @time: 2018/5/21 18:30:08
 */
public class GoldOreOutcome {
	public static long dealMillis = 0;
	// 金子重量KG
	private BigDecimal goldWeight = new BigDecimal("0");
	// 废料重量KG
	private BigDecimal scrapWeight = new BigDecimal("0");

	/**
	 * 冶炼
	 * @param totalWeight
	 * @param percent
	 * @return
	 */
	public GoldOreOutcome smelt(int totalWeight, float percent) {
		if (percent > 1) {
			System.err.println("ERROR percent: " + percent);
			return this;
		}
		BigDecimal tw = new BigDecimal(totalWeight + "");
		BigDecimal theWeight = tw.multiply(new BigDecimal(percent + ""));
		goldWeight = goldWeight.add(theWeight);
		scrapWeight = scrapWeight.add(tw.subtract(theWeight));
		this.sleep(dealMillis);
		return this;
	}

	void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public GoldOreOutcome superpose(GoldOreOutcome goldOreOutcome) {
//		this.sleep(0);
		goldWeight = this.goldWeight.add(goldOreOutcome.goldWeight);
		scrapWeight = this.scrapWeight.add(goldOreOutcome.scrapWeight);
		return this;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("{");
		sb.append("\"goldWeight\":")
				.append(goldWeight);
		sb.append(",\"scrapWeight\":")
				.append(scrapWeight);
		sb.append('}');
		return sb.toString();
	}
}
