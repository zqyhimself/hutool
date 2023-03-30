package cn.hutool.core.text;

import cn.hutool.core.map.Dict;
import cn.hutool.core.util.CharUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NamingCaseTest {

	@Test
	public void toCamelCaseTest() {
		Dict.of()
				.set("Table_Test_Of_day","tableTestOfDay")
				.set("TableTestOfDay","TableTestOfDay")
				.set("abc_1d","abc1d")
				.forEach((key, value) -> Assertions.assertEquals(value, NamingCase.toCamelCase(key)));
	}

	@Test
	public void toCamelCaseFromDashedTest() {
		Dict.of()
				.set("Table-Test-Of-day","tableTestOfDay")
				.forEach((key, value) -> Assertions.assertEquals(value, NamingCase.toCamelCase(key, CharUtil.DASHED)));
	}

	@Test
	public void toUnderLineCaseTest() {
		Dict.of()
				.set("Table_Test_Of_day", "table_test_of_day")
				.set("_Table_Test_Of_day_", "_table_test_of_day_")
				.set("_Table_Test_Of_DAY_", "_table_test_of_DAY_")
				.set("_TableTestOfDAYToday", "_table_test_of_DAY_today")
				.set("HelloWorld_test", "hello_world_test")
				.set("H2", "H2")
				.set("H#case", "H#case")
				.set("PNLabel", "PN_label")
				.set("wPRunOZTime", "w_P_run_OZ_time")
				// https://github.com/dromara/hutool/issues/2070
				.set("customerNickV2", "customer_nick_v2")
				// https://gitee.com/dromara/hutool/issues/I4X9TT
				.set("DEPT_NAME","DEPT_NAME")
				.forEach((key, value) -> Assertions.assertEquals(value, NamingCase.toUnderlineCase(key)));
	}

	@Test
	public void issueI5TVMUTest(){
		// https://gitee.com/dromara/hutool/issues/I5TVMU
		Assertions.assertEquals("t1C1", NamingCase.toUnderlineCase("t1C1"));
	}
}
