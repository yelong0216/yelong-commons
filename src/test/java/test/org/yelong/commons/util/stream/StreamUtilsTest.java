package test.org.yelong.commons.util.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.yelong.commons.support.Entry;
import org.yelong.commons.util.stream.StreamUtils;

public class StreamUtilsTest {

	@Test
	public void distinctByKey() {
		Entry<String, Object> entry1 = new Entry<String, Object>("username", "pengfei");
		Entry<String, Object> entry2 = new Entry<String, Object>("username1", "pengfei");
		Entry<String, Object> entry3 = new Entry<String, Object>("username2", "pengfei");
		Entry<String, Object> entry4 = new Entry<String, Object>("username", "pengfei");
		List<Entry<String,Object>> list = Arrays.asList(entry1,entry2,entry3,entry4);
		Stream<Entry<String,Object>> stream = list.stream().filter(StreamUtils.distinctByKey(Entry::getKey));
		System.out.println(stream.collect(Collectors.toList()));
	}
	
	
}
