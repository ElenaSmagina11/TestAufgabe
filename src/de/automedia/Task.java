package de.automedia;

import java.math.BigInteger;
import java.util.*;

public class Task {

	public static void main(String[] args) {

// Initializes an array of all source meetings
		List<Meeting> allMeetings = new ArrayList<>();

		allMeetings.add(new Meeting(new BigInteger("0"), new BigInteger("1")));
		allMeetings.add(new Meeting(new BigInteger("3"), new BigInteger("5")));
		allMeetings.add(new Meeting(new BigInteger("4"), new BigInteger("8")));
		allMeetings.add(new Meeting(new BigInteger("10"), new BigInteger("12")));
		allMeetings.add(new Meeting(new BigInteger("9"), new BigInteger("10")));

// Initializes an array of meetings with condensed ranges
		List<Meeting> mergedMeetings = new ArrayList<>();
		mergedMeetings = (ArrayList<Meeting>) mergeRanges(allMeetings);

// console output
		toPrint(mergedMeetings);
		//mergedMeetings.forEach(System.out::println);  gibt de.automedia.Meeting@4eec7777 hash aus
	}

	// Task
	public static List<Meeting> mergeRanges(List<Meeting> inputMeeting) {

		// Check up of source array
		if (inputMeeting == null || inputMeeting.size() == 0) {
			throw new IllegalArgumentException("Array is null or empty");
		}

		// Sorting of array according to their startTime
		Collections.sort(inputMeeting, Comparator.comparing((Meeting meet) -> meet.getStartTime()));
		
		// Initializes of array for result
		List<Meeting> resultArray = new ArrayList<>();

		Meeting first = inputMeeting.get(0);

		for (int i = 1; i < inputMeeting.size(); i++) {
			Meeting second = inputMeeting.get(i);
			// if the second meeting starts earlier than the first one ends,
			if (second.getStartTime().compareTo(first.getEndTime()) == 0
					|| second.getStartTime().compareTo(first.getEndTime()) == -1) {
				// the first meeting gets longer
				first.setEndTime(first.getEndTime().max(second.getEndTime()));

			} else {
				resultArray.add(first);
				// to analyze next meeting
				first = second;
			}
		}

		resultArray.add(first);
		return resultArray;
	}

	public static void toPrint(List<Meeting> inputArray) {
		for (int i = 0; i < inputArray.size(); i++) {
			System.out.println("mergedMeeting: " + inputArray.get(i).getStartTime()
			+ ", " + inputArray.get(i).getEndTime());
		}
	}
}
