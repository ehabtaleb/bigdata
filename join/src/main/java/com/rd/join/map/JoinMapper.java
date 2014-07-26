package com.rd.join.map;

import java.io.IOException;
import java.util.List;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;


/**
 *
 * 
 */
public class JoinMapper extends Mapper<LongWritable, Text, Text, Text>
{

	private final Text value = new Text();
	private final Text key = new Text();
	private static final String SEP = ",";
	private static final int keyIndx = 0;

	private final Splitter splitter = Splitter.on(SEP).trimResults();
	private final Joiner joiner = Joiner.on(SEP);


	/**
	 * cdd8dde3-0349-4f0d-b97a-7ae84b687f9c,Esther,Garner,4071 Haven Lane,Okemos,MI
	 * 81a43486-07e1-4b92-b92b-03d0caa87b5f,Timothy,Duncan,753 Stadium Drive,Taunton,MA
	 * aef52cf1-f565-4124-bf18-47acdac47a0e,Brett,Ramsey,4985 Shinn Street,New York,NY
	 */
	@Override
	protected void map(final LongWritable _key, final Text _value, final Context context) throws IOException, InterruptedException
	{

		final String line = _value.toString();
		final List<String> tokens = Lists.newArrayList(splitter.split(line));

		key.set(tokens.remove(keyIndx));
		value.set(joiner.join(tokens));
		context.write(key, value);
	}
}
