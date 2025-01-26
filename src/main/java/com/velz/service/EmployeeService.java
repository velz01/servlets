package com.velz.service;

import com.velz.dao.EmployeeDao;
import com.velz.dto.EmployeeDto;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {
    private static final EmployeeService SERVICE = new EmployeeService();

    private EmployeeService() {}
    private final EmployeeDao dao = EmployeeDao.getInstance();

    public List<EmployeeDto> findAll() {
        return dao.findAll().stream().map(employee -> EmployeeDto
                .builder()
                .id(employee.getId())
                .name(employee.getName())
                .build()
        ).collect(Collectors.toList());
    }


    public static EmployeeService getInstance() {
        return SERVICE;
    }
}
