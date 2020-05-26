package com.lxf.service.impl;

import com.lxf.dao.SysLogDao;
import com.lxf.domain.SysLog;
import com.lxf.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysLogServiceImpl implements SysLogService {

        @Autowired
        private SysLogDao sysLogDao;
        // 存储日志
        @Override
        public void save(SysLog sysLog) {
            sysLogDao.save(sysLog);
        }

        @Override
        public List<SysLog> findAll() {
                return sysLogDao.findAll();
        }
}
