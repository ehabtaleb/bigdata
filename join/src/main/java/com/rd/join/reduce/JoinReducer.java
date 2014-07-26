package com.rd.join.reduce;

import java.io.IOException;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import com.google.common.base.Joiner;


/**
 * 
 */
public class JoinReducer extends Reducer<Text, Text, NullWritable, Text>
{

	private static final NullWritable NULL = NullWritable.get();
	private final Text value2 = new Text();

	private static final String SEP = ",";
	private final Joiner joiner = Joiner.on(SEP);


	@Override
	protected void reduce(final Text key, final Iterable<Text> values, final Context ctx) throws IOException, InterruptedException
	{
		final String parts = joiner.join(values);
		value2.set(parts);
		ctx.write(NULL, value2);
	}
}
