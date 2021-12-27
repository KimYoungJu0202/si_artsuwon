package kr.or.artsuwon.reservation.model.service;

import kr.or.artsuwon.common.JDBCTemplate;
import kr.or.artsuwon.reservation.model.dao.ReservationDAO;
import kr.or.artsuwon.reservation.model.vo.Reservation;

import java.sql.Connection;
import java.util.ArrayList;

public class ReservationServiceImpl implements ReservationService {
    /// FIELDs
    private ReservationDAO rDAO = new ReservationDAO();


    /**
     * 공연일정에 대한 모든 예약정보를 가져옴
     * @param scheduleNo 공연일정
     * @return 예약정보 리스트
     * @author 신현진
     */
    @Override
    public ArrayList<Reservation> getAllReservationByPerfSchedule(int scheduleNo) {
        Connection conn = JDBCTemplate.getConnection();
        ArrayList<Reservation> list = rDAO.selectAllReservationByPerfSchedule(conn, scheduleNo);
        JDBCTemplate.close(conn);
        return list;
    }
}