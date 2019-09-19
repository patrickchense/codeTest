package jsonutils;

import com.alibaba.fastjson.JSON;
import com.github.wnameless.json.unflattener.JsonUnflattener;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class JsonFlattenTest {

	@Test
	public void testFlattenReverse() {
		Map<String, String> vals = new HashMap<String, String>();
		vals.put("sendList3.privacyProtection", "*MiChat不会向第三方泄露你的隐私");
		vals.put("tip.loading", "载入中...");
		vals.put("sendList3.shareFriendRuleC", "说明：每个好友注册后，会收到你的{{sendNewMoney}}Rp红包，你可再得{{sendOldMoney}}Rp（MiChat提供费用，限选{{userNum}}人）");
		vals.put("receive.freeEarn", "免费赚红包");
		vals.put("receive.tip.openFailed", "该红包已被取消");
		vals.put("receive.tip.cancaled", "红包打开失败了，请重新打开红包");

		String flattenJson = JSON.toJSONString(vals);
		System.out.println("flatten : " + flattenJson);

		String nestedJson = JsonUnflattener.unflatten(flattenJson);

		System.out.println("un flatten: " + nestedJson);
	}
}
