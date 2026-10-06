# Alumni Network Platform

## 1. Project Overview

The **Alumni Network Platform** is a web application that connects **students, alumni, and administrators** in one centralized platform.

The system helps students discover alumni and career opportunities, allows alumni to contribute through **jobs, referrals, mentorship, events, posts, and donations**, and provides administrators with tools to manage users and monitor overall platform engagement.

The application is built using **Java Spring Boot, React, and MySQL**, with a design that can later be extended into a microservice-based architecture.

---

## 2. User Roles

### Admin
The administrator manages and monitors the complete platform.

- Manage students and alumni
- Verify or reject alumni registrations
- Manage events and announcements
- Manage jobs and posts
- Create and manage donation campaigns
- Monitor mentorship and referral activities
- View platform analytics and engagement statistics

### Alumni
Verified alumni can interact with the community and support students.

- Create and manage their profile
- Control profile privacy
- Search and connect with other alumni
- Post job opportunities
- Provide employee referrals
- Become mentors
- Respond to mentorship requests
- Participate in events
- Create posts
- Donate to campaigns

### Student
Students can use the platform for networking and career development.

- Search alumni
- View alumni profiles according to privacy settings
- Search job opportunities
- Request employee referrals
- Find and request mentors
- Participate in events
- View posts and announcements

---

# 3. Main Features

## Authentication & Authorization

Users securely log in to the platform using their credentials.

The system uses:

- JWT authentication
- Password encryption
- Role-based authorization

Each role gets access only to the features permitted for that role.

---

## Alumni Registration & Verification

Alumni can submit their details for registration.

Their account initially remains **Pending**.

```text
Registration
     ↓
Pending
     ↓
Admin Review
   ↙     ↘
Verified  Rejected
```

Only verified alumni receive full alumni functionality.

---

## Alumni Profile

Alumni can maintain professional information such as:

- Name
- Batch
- Department
- Graduation year
- Company
- Designation
- Location
- Skills
- Bio
- GitHub / LinkedIn
- Career information

---

## Privacy Management

Alumni can decide which profile information is visible to other users.

For example:

```text
Email       → Private
Phone       → Private
Company     → Public
City        → Public
LinkedIn    → Public
```

The system applies these privacy settings whenever another user views the profile.

---

## Alumni Directory

Students and alumni can discover other alumni using filters such as:

- Batch
- Department
- Company
- Location
- Skills

This makes it easier to find alumni with relevant educational or professional backgrounds.

---

# 4. Jobs & Referrals

## Job Opportunities

Verified alumni can publish job openings.

A job can contain:

- Job title
- Company
- Location
- Description
- Experience
- Salary range
- Required skills
- Application link
- Referral availability
- Expiry date

Students and other alumni can browse available jobs.

---

## Employee Referrals

Alumni can indicate that they are willing to provide a referral for a particular job.

A student can then submit a referral request.

The request can move through different stages such as:

```text
Pending → Accepted → Referred
                   ↘ Rejected
```

This creates a structured connection between students and alumni for career opportunities.

---

# 5. Mentorship

Alumni can become mentors by specifying the areas in which they can help.

Examples:

- Java
- Spring Boot
- Backend Development
- Data Science
- Resume Preparation
- Interview Preparation
- Career Guidance

Students can search for suitable mentors and send mentorship requests.

The alumni can:

- Accept the request
- Reject the request
- Communicate with the student
- Provide career guidance

Mentorship requests are tracked using their status.

---

# 6. Events & RSVP

Administrators can create alumni events such as:

- Alumni meets
- Technical sessions
- Career workshops
- Networking events
- College reunions

Each event can contain:

- Title
- Description
- Date and time
- Location
- Capacity

Users can **RSVP** for an event.

The system prevents:

- Duplicate registrations
- Registration after capacity is reached
- Registration for cancelled events

Administrators can also update or cancel events.

---

# 7. Donations & Campaigns

Administrators can create donation campaigns for purposes such as:

- Scholarships
- Student support
- College development
- Community initiatives

Each campaign has:

- Campaign title
- Description
- Target amount
- Start/end date
- Current amount
- Campaign status

Alumni can contribute to campaigns.

The project uses a **mock payment system** for demonstration instead of processing real financial transactions.

Users can also choose to make their donation anonymous.

---

# 8. Posts & Announcements

The platform provides a community feed where users can share information.

Posts can include:

- General posts
- Job-related posts
- Events
- Announcements

Administrators can manage and moderate platform content.

Users can interact with community content through the available engagement features.

---

# 9. Notifications & Communication

The system can notify users about important activities such as:

- Mentorship requests
- Referral requests
- Event updates
- Announcements
- Other relevant platform activities

Communication can initially be handled through REST APIs and can later support real-time communication.

---

# 10. Admin Dashboard & Analytics

Administrators receive a centralized dashboard to monitor the platform.

Important statistics include:

### Users
- Total users
- Total alumni
- Total students
- Pending alumni verification

### Jobs
- Jobs posted
- Referral requests
- Successful referrals

### Mentorship
- Mentorship requests
- Accepted requests
- Completed mentorships

### Events
- Total events
- Total RSVPs
- Event participation

### Donations
- Active campaigns
- Number of donors
- Total donations
- Campaign progress

The dashboard can display these statistics using charts and visual reports.

---

# 11. Engagement Tracking

The platform can track important user activities such as:

- Profile views
- Job views
- Job posts
- Mentorship requests
- Event participation
- Donations
- Posts

This information is used to understand alumni engagement and generate analytics.

---

# 12. Smart / Advanced Features

The platform can later support intelligent features such as:

### Mentor Matching

Students can receive mentor recommendations based on:

```text
Student Skills
      +
Career Interest
      +
Alumni Expertise
      ↓
Recommended Mentors
```

### Alumni Search

Users can search for alumni using multiple conditions such as:

```text
Batch + Department + Company + Location + Skills
```

### Engagement Score

The system can calculate an engagement score based on activities such as:

```text
Job Posted          → Points
Mentorship          → Points
Event Participation → Points
Donation            → Points
Post                → Points
```

This can help administrators identify highly active alumni.

---

# 13. Technology Stack

### Frontend

- React
- TypeScript
- Vite
- Tailwind CSS
- React Router
- Axios
- Recharts

### Backend

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- Bean Validation
- JWT
- OpenFeign

### Database

- MySQL

### Architecture

The application can initially be developed as a **modular Spring Boot application** and later extended into **microservices**.

---

# 14. Backend Architecture

The backend follows a layered structure:

```text
Controller
     ↓
Service
     ↓
Repository
     ↓
Database
```

### Controller
Handles HTTP requests and responses.

### Service
Contains the application's business logic.

### Repository
Handles database operations.

### Entity
Represents database tables.

### DTO
Transfers data between the frontend and backend.

### Security
Handles authentication and authorization.

---

# 15. Major Database Modules

The main data areas include:

```text
Users
Alumni Profiles
Privacy Settings
Jobs
Referral Requests
Mentorship Requests
Events
Event RSVPs
Donation Campaigns
Donations
Posts
Engagement Records
```

These modules together represent the major functionality of the platform.

---

# 16. Design & Java Concepts

The project also provides opportunities to apply important Java and Spring concepts:

- OOP
- Collections
- Streams
- Exception handling
- Generics
- Design patterns
- Validation
- Transactions
- Multithreading
- CompletableFuture
- REST APIs
- Spring Security
- JPA/Hibernate
- Microservice communication
- OpenFeign

Possible design patterns include:

- **Strategy Pattern** — privacy handling
- **Factory Pattern** — different post types
- **Builder Pattern** — constructing complex responses
- **Specification Pattern** — dynamic alumni search

---

# 17. Overall System Flow

The complete platform can be understood as:

```text
                    ALUMNI NETWORK PLATFORM
                              │
          ┌───────────────────┼───────────────────┐
          │                   │                   │
       ADMIN                ALUMNI             STUDENT
          │                   │                   │
          ├── Users           ├── Profile         ├── Alumni Search
          ├── Verification    ├── Jobs            ├── Jobs
          ├── Events          ├── Referrals       ├── Referrals
          ├── Campaigns       ├── Mentorship      ├── Mentorship
          ├── Posts           ├── Events          ├── Events
          └── Analytics       ├── Posts           └── Posts
                              └── Donations
                                      │
                                      ↓
                              Engagement & Analytics
```

---

# 18. Future Expansion

The platform can later be extended with:

- Microservices
- API Gateway
- OpenFeign communication
- Real-time messaging
- Email notifications
- Advanced mentor recommendations
- Advanced analytics
- Docker deployment
- CI/CD
- Cloud deployment
- AI-based alumni/mentor recommendations

---

## Project Goal

The overall goal is to create a **single digital platform for alumni networking, career support, mentorship, events, contributions, and community engagement**, while giving administrators complete control and visibility over the alumni ecosystem.