package HistEq;

import java.io.IOException;
import java.awt.image.BufferedImage;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.JobContext;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

public class ImageInputFormat extends FileInputFormat<LongWritable, BufferedImage> {

	@Override
	public RecordReader<LongWritable, BufferedImage> createRecordReader(InputSplit split,
		TaskAttemptContext context) throws IOException,
		InterruptedException {
			return new ImageRecordReader();
		}

	@Override
	protected boolean isSplitable(JobContext context, Path file) {
		return false;
	}
}

