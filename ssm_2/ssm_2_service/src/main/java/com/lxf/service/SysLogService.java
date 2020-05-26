package com.lxf.service;

import com.lxf.domain.SysLog;

import java.util.List;

public interface SysLogService {

    void save(SysLog sysLog);

    List<SysLog> findAll();
}
