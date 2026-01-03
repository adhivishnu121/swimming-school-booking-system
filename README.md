# Swimming School Booking System

A backend-focused **Java Spring Boot** application designed to manage lesson scheduling and bookings for a junior swimming school.

This project models a real-world booking system, focusing on **business logic, object-oriented design, and backend validation**, implemented as a **self-contained command-line application** without any external database.

---

## 📌 Project Overview

The Hatfield Junior Swimming School Booking System manages learners, coaches, swimming lessons, and bookings across a four-week timetable.  
It supports lesson viewing, booking, cancellation, learner progression, reviews, and reporting.

The system enforces strict booking rules and capacity constraints while maintaining clear separation of responsibilities between domain entities.

---

## 🎯 Features

- Predefined **4-week timetable (44 lessons)** covering Grades 1–5
- Lesson scheduling across:
  - Monday, Wednesday, Friday (4–7pm)
  - Saturday (2–4pm)
- Maximum **4 learners per lesson**
- Learner management:
  - Stores name, gender, age, emergency contact, and grade level
  - Age validation (4–11 years)
- Lesson booking with rules:
  - Learners may book their current grade or **one grade higher**
  - No duplicate bookings allowed
- Timetable viewing:
  - By **day**
  - By **grade level**
  - By **coach**
- Booking lifecycle management:
  - Book lessons
  - Change bookings (subject to availability)
  - Cancel bookings before attendance
- Automatic learner grade progression after attending a higher-grade lesson
- Lesson reviews and ratings (1–5 scale)
- Automated reports after four weeks:
  - Learner booking summary (booked, cancelled, attended)
  - Coach average rating report

---

## 🛠️ Technologies Used

- Java  
- Spring Boot  
- JUnit  
- Maven  

---

## 🧠 Design & Architecture

- Object-Oriented Design (OOP)
- Clear domain models: Learner, Lesson, Coach, Booking, Review
- Business rules enforced at service layer
- In-memory data storage (no external database)
- Separation of concerns between scheduling, booking, and reporting logic

---

## 🧪 Testing

- Comprehensive **JUnit tests** to validate:
  - Booking constraints
  - Grade progression logic
  - Capacity limits
  - Booking changes and cancellations
- Ensures correctness and reliability of core business logic

---

## 🚀 How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/swimming-school-booking-system.git
