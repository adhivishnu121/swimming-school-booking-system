package SwimmingSchool;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {
	private static int nextId = 2000;
	private Learner learner;
	private String lessonDate;
	private String lessonTime;
	private int lessonId;
	private String status;
	private String review;
	private int rating;
	private Coach coach;
	private int gradeLevel;
	private static final int MAX_CAPACITY = 4;
	private int currentCapacity;

	public Booking(Learner learner, String lessonDate, String lessonTime, Coach coach, int gradeLevel, int lessonId) {
		this.lessonId = ++nextId;
		this.learner = learner;
		this.lessonDate = lessonDate;
		this.lessonTime = lessonTime;
		this.status = "booked"; 
		this.review = ""; 
		this.rating = 0; 
		this.coach = coach;
		this.gradeLevel = gradeLevel;
		this.currentCapacity = 1; 
	}

	public int getlessonId() {
		return lessonId;
	}

	public void setLearner(Learner learner) {
		this.learner = learner;
	}

	public Learner getLearner() {
		return learner;
	}

	public void setLessonTime(String lessonTime) {
		this.lessonTime = lessonTime;
	}

	public void setLessonDate(String lessonDate) {
		this.lessonDate = lessonDate;
	}

	public String getLessonTime() {
		return lessonTime;
	}

	public String getLessonDate() {
		return lessonDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	public Coach getCoach() {
		return coach;
	}

	public int getGradeLevel() {
		return gradeLevel;
	}

	public int getMaxCapacity() {
		return MAX_CAPACITY;
	}

	public int getCurrentCapacity() {
		return currentCapacity;
	}

	public boolean isFull() {
		return currentCapacity >= MAX_CAPACITY;
	}

	public void increaseCapacity() {
		if (!isFull()) {
			currentCapacity++;
		} else {
			System.out.println("Booking failed: Lesson is already at maximum capacity.");
		}
	}

	public void decreaseCapacity() {
		if (currentCapacity > 0) {
			currentCapacity--;
		} else {
			System.out.println("Error: No learners booked for this lesson.");
		}
	}

	public String getTime() {
		return lessonTime; 
	}

	public DayOfWeek getDayOfWeek() {
		LocalDate date = LocalDate.parse(lessonDate);

		if (date.getDayOfWeek() == DayOfWeek.MONDAY || date.getDayOfWeek() == DayOfWeek.WEDNESDAY
				|| date.getDayOfWeek() == DayOfWeek.FRIDAY) {
			return date.getDayOfWeek();
		} else if (date.getDayOfWeek() == DayOfWeek.SATURDAY) {
			LocalTime time = LocalTime.parse(lessonTime);
			if (time.isAfter(LocalTime.of(13, 59)) && time.isBefore(LocalTime.of(16, 1))) {
				return date.getDayOfWeek();
			}
		}
		return null; 
	}

	public void addLearner(Learner learner) {
		if (currentCapacity < MAX_CAPACITY) {
			increaseCapacity();
			System.out.println("Learner " + learner.getName() + " added to the booking.");
		} else {
			System.out.println("Cannot add learner. Booking is full.");
		}
	}

	@Override
	public String toString() {
		return "Booking Information: \n" + "Learner: " + learner.getName() + "\n" + "Lesson Date: " + lessonDate + "\n"
				+ "Lesson Time: " + lessonTime + "\n" + "Status: " + status + "\n" + "Review: "
				+ (review != null ? review : "N/A") + "\n" + "Rating: " + (rating != 0 ? rating : "N/A");
	}

	public int getMonth() {
		return Integer.parseInt(lessonDate.split("-")[1]);
	}
}
