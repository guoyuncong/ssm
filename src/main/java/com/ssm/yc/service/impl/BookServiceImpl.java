package com.ssm.yc.service.impl;


import com.ssm.yc.basic.entity.Book;
import com.ssm.yc.dao.AppointmentDao;
import com.ssm.yc.dao.BookDao;
import com.ssm.yc.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// 注入Service依赖
	@Autowired
	private BookDao bookDao;

	@Autowired
	private AppointmentDao appointmentDao;


	@Override
	public Book getById(long bookId) {
		return bookDao.queryById(bookId);
	}

	@Override
	public List<Book> getList() {
		return bookDao.queryAll(0, 1000);
	}

	@Override
	@Transactional
	public Book appoint(long bookId, long studentId) {
		try {
			// 减库存
			int update = bookDao.reduceNumber(bookId);
			if (update <= 0) {// 库存不足
			} else {
				// 执行预约操作
				int insert = appointmentDao.insertAppointment(bookId, studentId);
				if (insert <= 0) {// 重复预约
				} else {// 预约成功

				}
			}
		}  catch (Exception e) {
			logger.error(e.getMessage(), e);
			// 所有编译期异常转换为运行期异常
		}
		return null;
	}

}
