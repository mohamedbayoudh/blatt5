package m;

import org.apache.flink.api.common.io.FileInputFormat;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.types.StringValue;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

		// read text file from local files system
		DataSet<StringValue> localLines = env.readTextFileWithValue("file:///F://data/enwiki-20191101-pages-articles-multistream.xml.bz2");
		
		DataSet<String> text = env.fromElements(
	            "Who's there?",
	            "I think I hear them. Stand, ho! Who's there?");
		
		
		DataSet<String> c = text.reduceGroup(new Reducer());
		
		//DataSet<Tuple2<String,Integer>> counts = localLines.flatMap(new LineSplitter());
		
		//
		
		
		
		try {
			c.print();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
