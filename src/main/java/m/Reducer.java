package m;

import org.apache.flink.api.common.functions.GroupReduceFunction;
import org.apache.flink.util.Collector;

public class Reducer implements GroupReduceFunction<String, String> {

	public void reduce(Iterable<String> values, Collector<String> out) throws Exception {
		String toAdd = "";
	    for (String i : values) {
	    	for(int j = 0;j< i.length();j++ ) {
	    		if((!Character.isWhitespace(i.charAt(j)))&&(Character.isAlphabetic(i.charAt(j)))) {
	    			 toAdd += i.charAt(j);
	    		}
	    	}
	     
	      out.collect(toAdd);
	    }
	}

}
