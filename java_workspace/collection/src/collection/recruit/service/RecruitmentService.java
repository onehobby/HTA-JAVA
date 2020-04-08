package collection.recruit.service;

import java.util.ArrayList;
import java.util.Iterator;

import collection.recruit.repo.RecruitmentRepository;
import collection.recruit.vo.Career;
import collection.recruit.vo.Recruitment;
import collection.recruit.vo.Resume;

public class RecruitmentService {

	private RecruitmentRepository repo = new RecruitmentRepository();
	
	// 이력서 등록기능
	public void addNewResume(Resume resume) {
		// 구직신청객체 생성
		// 구직신청객체에 전달받은 이력서 객체 저장
		// 레포지토리객체를 사용해서 db에 저장하고, 자신의 구직신청번호를 반환받는다.
		// 구직신청번호를 출력한다.
		Recruitment recruitment = new Recruitment();
		recruitment.setResume(resume);
		int recruitmentNo = repo.addRecuitment(recruitment);
		System.out.print("구직신청번호는"+"\t");
		System.out.println(recruitmentNo);
	}
	
	// 경력사항 등록기능
	public void addCareer(int recruitmentNo, Career career) {
		// 레포지토리에서 구직신청번호에 해당하는 구직신청객체를 조회한다.
		// 구직신청객체의 경력사항에 전달받은 경력사항객체를 추가한다.
		Recruitment findRecruitment = repo.getRecruitmentByNo(recruitmentNo);
		
		if(findRecruitment == null) {
			System.out.println("### 정보가 없습니다");
			return;
		}
		
		findRecruitment.addCareer(career);
	}
	
	// 구직신청 상태 조회 기능
	public void printRecruitmentDetail(int recruitmentNo) {
		// 레포지토리에서 구직신청번호에 해당하는 구직신청객체를 조회해서 화면에 출력한다.
		Recruitment findRecruitment = repo.getRecruitmentByNo(recruitmentNo);
		
		if(findRecruitment == null) {
			System.out.println("### 정보가 없습니다");
			return;
		}
		
		
		System.out.println("구직신청번호: " + findRecruitment.getNo());
		System.out.println("이름: " + findRecruitment.getResume().getName());
		System.out.println("전화번호: " + findRecruitment.getResume().getTel());
		System.out.println("지원부서: " + findRecruitment.getResume().getDept());
		System.out.println("합격여부: " + findRecruitment.isPassed());
		
		ArrayList<Career> findCareer = findRecruitment.getCareers();
		System.out.println("[경력사항]");
		for(Career career : findCareer) {
			System.out.println("이전회사: " + career.getCompanyName());
			System.out.println("재직부서: " + career.getDept());
			System.out.println("직    급: " + career.getPosition());
			System.out.println("연    차: " + career.getYear());
		}
		
		
	}
	
	// 이력서 수정 기능
	public void updateResume(int recruitmentNo, Resume resume) {
		// 레포지토리에서 구직신청번호에 해당하는 구직신청객체를 조회한다.
		// 구직신청객체의 이력서정보를 전달받은 이력서 정보로 교체한다.
		
		Recruitment findRecruitment = repo.getRecruitmentByNo(recruitmentNo);
		
		if(findRecruitment == null) {
			System.out.println("### 정보가 없습니다");
			return;
		}
		
		
		findRecruitment.setResume(resume);
	}
	
	// 이력서 조회기능
	public void displayResume(int recruitmentNo) {
		Recruitment findRecruitment = repo.getRecruitmentByNo(recruitmentNo);
		if(findRecruitment == null) {
			System.out.println("정보가 없습니다.");
			return;
		}
		Resume findResume = findRecruitment.getResume();
		System.out.println("이름\t전화번호\t지원부서");
		System.out.print(findResume.getName());
		System.out.print(findResume.getTel());
		System.out.println(findResume.getDept());
		
	}
	
	// 구직신청 삭제하기
	public void deleteRecruitment(int recruitmentNo) {
		// 레포지토리에서 구직신청번호에 해당하는 구직신청객체를 삭제한다.
		repo.deleteRecruitmentByNo(recruitmentNo);
		
	}
	
	// 전체 구직신청정보 간단 조회
	public void printAllRecruitment() {
		// 레포지토리에서 모든 구직신청 정보를 조회해서 화면에 출력한다.
		ArrayList<Recruitment> allRecruitmentInfo = repo.getAllRecruitments();
		if(allRecruitmentInfo.isEmpty()) {
			System.out.println("조회된 구직정보가 없습니다.");
		} else {
			for(Recruitment recruitment : allRecruitmentInfo) {
				System.out.println("구직신청번호\t이름\t전화번호\t지원부서");
				System.out.print(recruitment.getNo()+"\t");
				System.out.print(recruitment.getResume().getName());
				System.out.print(recruitment.getResume().getTel());
				System.out.print(recruitment.getResume().getDept());
			}
		}
	}
	
	// 전체 구직신청정보 상태조회
	public void printAllRecruitmentdetail(int recruitmentNo) {
		Recruitment findRecruitment = repo.getRecruitmentByNo(recruitmentNo);
		
		if(findRecruitment == null) {
			System.out.println("### 정보가 없습니다");
			return;
		}
		
		
		System.out.println("구직신청번호: " + findRecruitment.getNo());
		System.out.println("이름: " + findRecruitment.getResume().getName());
		System.out.println("전화번호: " + findRecruitment.getResume().getTel());
		System.out.println("지원부서: " + findRecruitment.getResume().getDept());
		System.out.println("합격여부: " + findRecruitment.isPassed());
		
		ArrayList<Career> findCareer = findRecruitment.getCareers();
		System.out.println("[경력사항]");
		for(Career career : findCareer) {
			System.out.println("이전회사: " + career.getCompanyName());
			System.out.println("재직부서: " + career.getDept());
			System.out.println("직    급: " + career.getPosition());
			System.out.println("연    차: " + career.getYear());
		}
	}
	
	// 구직신청 심사하기
	public void checkRecruitment(int recruitmentNo, boolean passed) {
		// 레포지토리에서 구직신청번호에 해당하는 구직신청객체를 조회한다.
		// 합격/불합격여부를 결정한다.
		
		Recruitment findRecruitment = repo.getRecruitmentByNo(recruitmentNo);
		
		if(findRecruitment == null) {
			System.out.println("### 정보가 없습니다");
			return;
		}
		findRecruitment.setPassed(passed);
	}
	
	// 경력사항 수정하기
	public void modifyCareer(int recruitmentNo, String companyName, Career career) {
		Recruitment findRecruitment = repo.getRecruitmentByNo(recruitmentNo);
		
		if(findRecruitment == null) {
			System.out.println("### 정보가 없습니다");
			return;
		}
		
		ArrayList<Career> findCareer = findRecruitment.getCareers();
		for(Career careers : findCareer) {
			if(careers.getCompanyName().equals(companyName)) {
				careers.setCompanyName(career.getCompanyName());
				careers.setDept(career.getDept());
				careers.setPosition(career.getPosition());
				careers.setYear(career.getYear());
			}
		}
		
	}
	
	
	// 경력사항 삭제하기
	public void deleteCareer(int recruitmentNo, String companyName, Career career) {
		Recruitment findRecruitment = repo.getRecruitmentByNo(recruitmentNo);
		
		if(findRecruitment == null) {
			System.out.println("### 정보가 없습니다.");
			return;
		}
		
		ArrayList<Career> findCareer = findRecruitment.getCareers();
		Iterator<Career> itr = findCareer.iterator();
		
		while(itr.hasNext()) {
			Career careerd = itr.next();
			if(careerd.getCompanyName().equals(companyName)) {
				itr.remove();
			}
		}
	}
	
	// 전체 구직현황 조회
	public void recruitmentSameDept(int recruintmentNo) {
		ArrayList<Recruitment> allRecruitment = repo.getAllRecruitments();
		for(Recruitment recruintment : allRecruitment) {
			
		}
	}
	
}