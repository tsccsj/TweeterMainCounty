/**
 * UCMapper.java
 * @author Yizhao Gao
 */

package mapper;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class UCMapper extends MapReduceBase implements Mapper<LongWritable, Text, LongWritable, LongWritable> {

	@Override
	public void map(LongWritable key, Text value, OutputCollector<LongWritable, LongWritable> output, Reporter reporter) throws IOException {

		String[] line = value.toString().split(",");
		long sendKey = Long.parseLong(line[0]);
		long countyID = Long.parseLong(line[1]);

		output.collect(new LongWritable(sendKey), new LongWritable(countyID));
	}
}
