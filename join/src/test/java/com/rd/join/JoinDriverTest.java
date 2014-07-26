package com.rd.join;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Before;
import org.junit.Test;

import com.rd.join.map.JoinMapper;
import com.rd.join.reduce.JoinReducer;



/**
 * Unit test for simple App.
 */
public class JoinDriverTest
{

	/**
	 * cdd8dde3-0349-4f0d-b97a-7ae84b687f9c,Esther,Garner,4071 Haven Lane,Okemos,MI
	 * 81a43486-07e1-4b92-b92b-03d0caa87b5f,Timothy,Duncan,753 Stadium Drive,Taunton,MA
	 * aef52cf1-f565-4124-bf18-47acdac47a0e,Brett,Ramsey,4985 Shinn Street,New York,NY
	 */

	MapDriver<LongWritable, Text, Text, Text> mapDriver;
	ReduceDriver<Text, Text, NullWritable, Text> reduceDriver;
	MapReduceDriver<LongWritable, Text, Text, Text, NullWritable, Text> mapReduceDriver;


	@Before
	public void setUp()
	{
		final JoinMapper mapper = new JoinMapper();
		final JoinReducer reducer = new JoinReducer();
		mapDriver = MapDriver.newMapDriver(mapper);
		reduceDriver = ReduceDriver.newReduceDriver(reducer);
		mapReduceDriver = MapReduceDriver.newMapReduceDriver(mapper, reducer);
	}

	@Test
	public void testJoinMapper() throws IOException
	{
		mapDriver.withInput(new LongWritable(), new Text(
				"cdd8dde3-0349-4f0d-b97a-7ae84b687f9c,Esther,Garner,4071 Haven Lane,Okemos,MI"));
		mapDriver.withOutput(new Text("cdd8dde3-0349-4f0d-b97a-7ae84b687f9c"), new Text("Esther,Garner,4071 Haven Lane,Okemos,MI"));

		mapDriver.runTest();
	}


	@Test
	public void testJoinReducer()
	{

	}
}
