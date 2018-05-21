package demo.forkjoin;

/**
 * 金矿石
 *
 * @author: dongzhihua
 * @time: 2018/5/21 17:30:41
 */
public class GoldOre {

	public GoldOre(int weight, float tenorInGold) {
		this.weight = weight;
		this.tenorInGold = tenorInGold;
	}

	// 重量 KG
	private int weight;
	// 含金量
	private float tenorInGold;

	public float getTenorInGold() {
		return tenorInGold;
	}

	public void setTenorInGold(float tenorInGold) {
		this.tenorInGold = tenorInGold;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}
