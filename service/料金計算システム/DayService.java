package 料金計算システム;

public class DayService extends TimeService {

	private static final int START_TIME = 8;

	private static final int END_TIME = 17;

	private static final String SERVICE_CODE = "E1";

	private static final int BASIC_CHARGE = 200;

	public boolean isServiceTime(int hour) {
		return false;
	}

	public String getServiceCode() {
		return null;
	}

	public int getDiscount() {
		return 0;
	}

	public int getBasicCharge() {
		return 0;
	}

	private boolean joined = false;

	// サービスに加入しているかをチェック
	public void checkService(String line) {
		if (line.substring(2, 4).equals("E1")) {
			joined = true;
		}

	}

	public int calcBasicCharge(int baseBasicCharge) {
		if (joined) {
			// サービスに加入していれば基本料金を200円増し
			return baseBasicCharge + 200;
		}
		return baseBasicCharge;
	}

	// 単価を計算する
	public int calcUnitPrice(String line, int baseUnitPrice) {

		if (!joined) {
			// サービスに加入していなければ値引きなし
			return baseUnitPrice;
		}

		int startHour = Integer.parseInt(line.substring(13, 15)); // 通話開始時間

		if (8 <= startHour && startHour <= 17) {
			// 通話開始時間がサービス対象時間ならば5円引き
			return baseUnitPrice - 5;
		}

		return baseUnitPrice;
	}

	public void clear() {
		joined = false;
	}
}
