package m;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

public class LineSplitter implements FlatMapFunction<String, Tuple2<String, Integer>> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void flatMap(String line, Collector<Tuple2<String, Integer>> out) {
        for (String word : line.split("\\s")) {
            out.collect(new Tuple2<String, Integer>(word, 1));
        }
    }
}