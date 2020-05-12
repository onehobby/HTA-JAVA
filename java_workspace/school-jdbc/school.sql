

/* Create Tables */

CREATE TABLE school_courses
(
	course_no number(4,0) NOT NULL,
	subject_no number(4,0) NOT NULL,
	prof_no number(4,0) NOT NULL,
	course_name varchar2(200) NOT NULL,
	course_quota number(3,0) DEFAULT 30,
	course_reg_cnt number(3,0) DEFAULT 0,
	course_cancel_cnt number(3,0) DEFAULT 0,
	course_closed char(1) DEFAULT '''N''',
	course_create_date date DEFAULT sysdate,
	PRIMARY KEY (course_no)
);


CREATE TABLE school_course_registrations
(
	reg_no number(5,0) NOT NULL,
	course_no number(4,0) NOT NULL,
	stud_no number(4,0) NOT NULL,
	reg_canceled char(1) DEFAULT '''N''',
	reg_completed char(1) DEFAULT '''N''',
	reg_score number(2,1),
	reg_create_date date,
	PRIMARY KEY (reg_no),
	CONSTRAINT course_reg_uk UNIQUE (course_no, stud_no)
);


CREATE TABLE school_dept
(
	dept_no number(4,0) NOT NULL,
	dept_name varchar2(100) NOT NULL,
	PRIMARY KEY (dept_no)
);


CREATE TABLE school_professors
(
	prof_no number(4,0) NOT NULL,
	dept_no number(4,0) NOT NULL,
	prof_name varchar2(100) NOT NULL,
	prof_position varchar2(50),
	prof_create_date date DEFAULT sysdate,
	PRIMARY KEY (prof_no)
);


CREATE TABLE school_students
(
	stud_no number(4,0) NOT NULL,
	stud_name varchar2(100) NOT NULL,
	stud_grade number(1) NOT NULL,
	stud_create_date date DEFAULT sysdate,
	dept_no number(4,0) NOT NULL,
	PRIMARY KEY (stud_no)
);


CREATE TABLE school_subjects
(
	subject_no number(4,0) NOT NULL,
	subject_name varchar2(200) NOT NULL,
	subject_create_date date DEFAULT sysdate,
	dept_no number(4,0) NOT NULL,
	PRIMARY KEY (subject_no)
);



/* Create Foreign Keys */

ALTER TABLE school_course_registrations
	ADD FOREIGN KEY (course_no)
	REFERENCES school_courses (course_no)
;


ALTER TABLE school_professors
	ADD FOREIGN KEY (dept_no)
	REFERENCES school_dept (dept_no)
;


ALTER TABLE school_students
	ADD FOREIGN KEY (dept_no)
	REFERENCES school_dept (dept_no)
;


ALTER TABLE school_subjects
	ADD FOREIGN KEY (dept_no)
	REFERENCES school_dept (dept_no)
;


ALTER TABLE school_courses
	ADD FOREIGN KEY (prof_no)
	REFERENCES school_professors (prof_no)
;


ALTER TABLE school_course_registrations
	ADD FOREIGN KEY (stud_no)
	REFERENCES school_students (stud_no)
;


ALTER TABLE school_courses
	ADD FOREIGN KEY (subject_no)
	REFERENCES school_subjects (subject_no)
;



/* Comments */

COMMENT ON COLUMN school_courses.prof_no IS '교수의 고유한 번호';
COMMENT ON COLUMN school_courses.course_quota IS '과정별 최대 수강인원이다.
기본값은 30이다.
최대 인원수는 100명이다.';
COMMENT ON COLUMN school_courses.course_reg_cnt IS '해당 과정을 신청한 학생수다.
수강신청정보가 추가될 떄 마다 1씩 증가시켜야한다.';
COMMENT ON COLUMN school_courses.course_cancel_cnt IS '해당 과정을 수강신청했다가 취소한 학생의 수다.
수강신청테이블의 reg_canceled가 ''Y''로 변경되면
1씩 증가시킨다.';
COMMENT ON COLUMN school_course_registrations.stud_no IS '학생의 고유한 번호';
COMMENT ON COLUMN school_course_registrations.reg_canceled IS '수강신청 취소여부는 ''Y'', ''N''으로 지정한다.
기본값은 ''N''이다.';
COMMENT ON COLUMN school_course_registrations.reg_completed IS '수강신청 수료여부는 ''Y'', ''N''으로 지정한다.
기본값은 ''N''이다';
COMMENT ON COLUMN school_course_registrations.reg_score IS '평가점수는 0.0 ~ 4.5이다.
기본값은 null이다.';
COMMENT ON COLUMN school_dept.dept_no IS '학과의 고유한 번호';
COMMENT ON COLUMN school_dept.dept_name IS '학과의 이름';
COMMENT ON COLUMN school_professors.prof_no IS '교수의 고유한 번호';
COMMENT ON COLUMN school_professors.dept_no IS '학과 테이블의 학과번호를 참조한다.';
COMMENT ON COLUMN school_professors.prof_position IS '조교수 부교수 정교수 겸임교수 석좌교수 등의 값이 가능하다';
COMMENT ON COLUMN school_students.stud_no IS '학생의 고유한 번호';
COMMENT ON COLUMN school_students.dept_no IS '학과의 고유한 번호';
COMMENT ON COLUMN school_subjects.dept_no IS '학과의 고유한 번호';



