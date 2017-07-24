package com.concretepage.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.concretepage.dao.ITimesheetSummaryDao;
import com.concretepage.entity.TimesheetStatus;
import com.concretepage.entity.TimesheetSummary;

@Transactional
@Repository
public class TimesheetSummaryDao implements ITimesheetSummaryDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public List<TimesheetSummary> getTimesheetSummary(Integer employeeId, String startDate, String endDate) {
		String hql = "from TimesheetSummary as s where s.id.employeeId = ? and str_to_date(s.id.weekStartDate, '%Y-%m-%d') >= str_to_date( ? ,'%Y-%m-%d')  and str_to_date(s.id.weekStartDate, '%Y-%m-%d') < str_to_date( ? ,'%Y-%m-%d') ";
		Query query = entityManager.createQuery(hql);
		query.setParameter(1, employeeId);
		query.setParameter(2,startDate );
		query.setParameter(3, endDate);
		
		return (List<TimesheetSummary>)query.getResultList();
	}

	@Override
	public List<TimesheetSummary> getPendingTimesheetSummary(List<Integer> employeeIds) {
		String hql = "from TimesheetSummary as s where s.id.employeeId IN :employeeList and  s.timesheetStatus = :timesheetStatus order by s.id.employeeId " ;
		Query query = entityManager.createQuery(hql);
		query.setParameter("employeeList", employeeIds);
		query.setParameter("timesheetStatus", TimesheetStatus.DRAFT.name());
		
		return (List<TimesheetSummary>)query.getResultList();
	}

}
