package collection.recruit.repo;

import java.util.ArrayList;
import java.util.Iterator;

import collection.recruit.vo.Recruitment;

public class RecruitmentRepository {

	private ArrayList<Recruitment> db = new ArrayList<Recruitment>();
	private int sequence = 100;
	
	// 구직신청 등록하기
	public int addRecuitment(Recruitment recruitment) {
		recruitment.setNo(sequence++);
		db.add(recruitment);
		return sequence - 1;
	}
	
	// 나의 구직신청 현황 조회하기
	public Recruitment getRecruitmentByNo(int recruitmentNo) {
		Recruitment result = null;
		
		for(Recruitment recruitment : db) {
			if(recruitment.getNo() == recruitmentNo) {
				result = recruitment;
			}
		}
		return result;
	}
	
	// 나의 구직신청 삭제하기
	public void deleteRecruitmentByNo(int recruitmentNo) {
		Recruitment findRecruitment = getRecruitmentByNo(recruitmentNo);
		
		if(findRecruitment == null) {
			System.out.println("### 정보가 없습니다");
			return;
		}
//		db.remove(findRecruitment);
		Iterator<Recruitment> itr = db.iterator();
		while(itr.hasNext()) {
			Recruitment recruitment = itr.next();
			if (recruitment.getNo() == findRecruitment.getNo()) {
				itr.remove();
			}
		}
	}
	
	// 전체 구직현황 조회하기
	public ArrayList<Recruitment> getAllRecruitments() {
		return db;
	}
}