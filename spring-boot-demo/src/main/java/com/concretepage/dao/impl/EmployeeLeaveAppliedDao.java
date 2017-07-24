package com.concretepage.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.dao.IEmployeeLeaveAppliedDao;
import com.concretepage.entity.EmployeeLeave;
import com.concretepage.entity.LEAVESTATUS;

@Transactional
@Repository
public class EmployeeLeaveAppliedDao implements IEmployeeLeaveAppliedDao {

	@PersistenceContext	
	private EntityManager entityManager;	
	
	@Override
	public List<EmployeeLeave> getEmployeeLeaveApplied(int employeeId) {
		String hql = "from EmployeeLeave as l where l.employee.employeeId = ? order by l.appliedDate ";
		Query query = entityManager.createQuery(hql);
		query.setParameter(1, employeeId);
		return (List<EmployeeLeave>) query.getResultList();
		
	}

	@Override
	public List<EmployeeLeave> getEmployeeLeaveAppliedForManager(int managerId) {
		String hql = "from EmployeeLeave as l where l.approvalManagerId = ? and l.leaveStatus = ? order by l.appliedDate ";
		Query query = entityManager.createQuery(hql);
		query.setParameter(1, managerId);
		query.setParameter(2, LEAVESTATUS.PENDING_APPROVAL.name());
		return (List<EmployeeLeave>) query.getResultList();
	}

	@Override
	public void applyLeave(EmployeeLeave leave) {
		entityManager.persist(leave);
	}

	@Override
	public EmployeeLeave updateLeaveStatus(EmployeeLeave leave, String Status) {
		leave.setLeaveStatus(Status);
		entityManager.persist(leave);
		return leave;
	}

	@Override
	public EmployeeLeave getEmployeeLeave(int leaveId) {
		EmployeeLeave leave = entityManager.find(EmployeeLeave.class, leaveId);
		return leave;
	}

}
