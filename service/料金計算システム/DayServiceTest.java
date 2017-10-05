package 料金計算システム;

public class DayServiceTest {

		@Test
		public void testIsServiceTime() {

		}

		@Test
		public void testCheckService() {

		}



		@Test
		public void testCalcBasicCharge() {
			DayService dayService = new DayService();

			dayService.clear();
			assertEquals(1000, dayService.calcBasicCharge(1000));

			dayService.checkService("2 E1");
			assertEquals(1200, dayService.calcBasicCharge(1000));
		}

		private void assertEquals(int i, int calcBasicCharge) {
			// TODO 自動生成されたメソッド・スタブ

		}

		@Test
		public void testCalcUnitPrice() {
			DayService dayService = new DayService();

			dayService.clear();
			int unitPrice = dayService.calcUnitPrice("5 2004/06/05 17:59 010 090-1234-0002", 20);
			assertEquals(20, unitPrice);

			dayService.checkService("2 E1");
			unitPrice = dayService.calcUnitPrice("5 2004/06/05 18:00 010 090-1234-0002", 20);
			assertEquals(20, unitPrice);
			unitPrice = dayService.calcUnitPrice("5 2004/06/05 17:59 010 090-1234-0002", 20);
			assertEquals(15, unitPrice);

		}

	}


