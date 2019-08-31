package JUnitTest;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import java.math.BigInteger;
import java.util.ArrayList;
import de.automedia.Meeting;
import de.automedia.Task;

public class TaskTest {

	@Test
	public void testMergeForOverlap() {
		ArrayList<Meeting> meetings = new ArrayList<Meeting>();
		meetings.add(new Meeting(new BigInteger("1"), new BigInteger("3")));
		meetings.add(new Meeting(new BigInteger("2"), new BigInteger("4000000000")));
		ArrayList<Meeting> expected = new ArrayList<>();
		expected.add(new Meeting(new BigInteger("1"), new BigInteger("4000000000")));
		ArrayList<Meeting> result = (ArrayList<Meeting>) Task.mergeRanges(meetings);

		myAssert(expected, result);

	}

	@Test
	public void testMergeForTouch() {
		ArrayList<Meeting> meetings = new ArrayList<Meeting>();
		meetings.add(new Meeting(new BigInteger("3"), new BigInteger("5")));
		meetings.add(new Meeting(new BigInteger("5"), new BigInteger("8")));
		ArrayList<Meeting> expected = new ArrayList<>();
		expected.add(new Meeting(new BigInteger("3"), new BigInteger("8")));
		ArrayList<Meeting> result = (ArrayList<Meeting>) Task.mergeRanges(meetings);

		myAssert(expected, result);
	}

	@Test
	public void testMergeForInclude() {

		ArrayList<Meeting> meetings = new ArrayList<Meeting>();
		meetings.add(new Meeting(new BigInteger("3"), new BigInteger("8")));
		meetings.add(new Meeting(new BigInteger("4"), new BigInteger("6")));
		ArrayList<Meeting> expected = new ArrayList<>();
		expected.add(new Meeting(new BigInteger("3"), new BigInteger("8")));
		ArrayList<Meeting> result = (ArrayList<Meeting>) Task.mergeRanges(meetings);

		myAssert(expected, result);
	}

	@Test
	public void testMergeForNonOverlap() {

		ArrayList<Meeting> meetings = new ArrayList<Meeting>();
		meetings.add(new Meeting(new BigInteger("1"), new BigInteger("3")));
		meetings.add(new Meeting(new BigInteger("5"), new BigInteger("7")));
		ArrayList<Meeting> expected = new ArrayList<>();
		expected.add(new Meeting(new BigInteger("1"), new BigInteger("3")));
		expected.add(new Meeting(new BigInteger("5"), new BigInteger("7")));
		ArrayList<Meeting> result = (ArrayList<Meeting>) Task.mergeRanges(meetings);
		assertEquals("Array is not empty ", result.size(), 2);
		Assert.assertEquals("StartTime is equal", expected.get(0).getStartTime(), result.get(0).getStartTime());
		Assert.assertEquals("EndTime is equal", expected.get(0).getEndTime(), result.get(0).getEndTime());
		Assert.assertEquals("StartTime is equal", expected.get(1).getStartTime(), result.get(1).getStartTime());
		Assert.assertEquals("EndTime is equal", expected.get(1).getEndTime(), result.get(1).getEndTime());
	}

	void myAssert(ArrayList<Meeting> arr1, ArrayList<Meeting> arr2) {

		assertEquals("Arras size is equal ", arr1.size(), arr2.size());
		Assert.assertEquals("StartTime is equal", arr1.get(0).getStartTime(), arr2.get(0).getStartTime());
		Assert.assertEquals("EndTime is equal", arr1.get(0).getEndTime(), arr2.get(0).getEndTime());
	}

}