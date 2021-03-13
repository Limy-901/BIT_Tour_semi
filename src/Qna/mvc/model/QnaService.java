package Qna.mvc.model;

import java.util.List;
import Domain.Qna;
import Qna.mvc.vo.ListResult;

public class QnaService {
	private QnaDAO dao;
	
	private static final QnaService instance = new QnaService();
	
	private QnaService() {
		dao = new QnaDAO();
	}
	
	public static QnaService getInstance() {
		return instance;
	}
	
	public ListResult getListResult(int cp, int ps) {
		List<Qna> list = dao.list(cp, ps); // 해당 cp, ps의 데이터값을 list에 담음.
		if(list == null) System.out.println("list가 제대로 담기지 않음");
		long totalCount = dao.getTotalCount(); // 전체 게시글 갯수를 알아옴.
		ListResult r = new ListResult(cp, totalCount, ps, list);
		return r;
	}
	public Qna getQna(long no) {
		return dao.getQna(no);
	}
	public void DBupdate(Qna qna) {
		dao.DBupdate(qna);
	}
	public void del(long no) {
		dao.del(no);
	}
	public void insertNew(Qna qna) {
		dao.insertNew(qna);
	}
}
