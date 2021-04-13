package com.lyx.service.Impl;

import com.lyx.dao.BugTicketDao;
import com.lyx.dao.BugTicketLineDao;
import com.lyx.dao.EmployeeDao;
import com.lyx.dao.TeamDao;
import com.lyx.dto.BugTicketDto;
import com.lyx.dto.ResponseDto;
import com.lyx.dto.query.BugTicketQueryDto;
import com.lyx.dto.query.EmployeeQueryDto;
import com.lyx.dto.query.TeamQueryDto;
import com.lyx.entity.BugTicket;
import com.lyx.entity.BugTicketLine;
import com.lyx.entity.Employee;
import com.lyx.entity.Team;
import com.lyx.service.BugTicketService;
import com.lyx.utils.CommonConstant;
import com.lyx.utils.IdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BugTicketServiceImpl implements BugTicketService {
    @Autowired
    private BugTicketDao bugTicketDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private TeamDao teamDao;
    @Autowired
    private BugTicketLineDao bugTicketLineDao;

    @Override
    @Transactional
    public void submitSave(BugTicketDto bugTicketDto) {
        String userId = bugTicketDto.getUserId();
        Employee employee = employeeDao.findById(userId);

        BugTicket bugTicket = new BugTicket();
        bugTicket.setBugId(IdGeneratorUtil.generateId());
        bugTicket.setTeamId(bugTicketDto.getTeamId());
        bugTicket.setTitle(bugTicketDto.getTitle());
        bugTicket.setDescription(bugTicketDto.getDescription());
        bugTicket.setStatusCode(bugTicketDto.getStatusCode());
        bugTicket.setBugLevel(bugTicketDto.getBugLevel());
        bugTicket.setSubmitId(employee.getEmpId());
        bugTicket.setSubmitName(employee.getRealName());
        bugTicket.setSubmitTime(new Date());

        bugTicketDao.submitSave(bugTicket);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<BugTicket> findAll() {
        return bugTicketDao.findAll();
    }

    @Override
    public BugTicket findById(String id) {
        return bugTicketDao.findById(id);
    }

    @Override
    public void delete(String id) {
        bugTicketDao.delete(id);
    }

    @Override
    public void update(BugTicketDto bugTicketDto) {
        BugTicket bugTicket = new BugTicket();
        bugTicket.setBugId(bugTicketDto.getBugId());
        bugTicket.setTeamId(bugTicketDto.getTeamId());
        bugTicket.setTitle(bugTicketDto.getTitle());
        bugTicket.setDescription(bugTicketDto.getDescription());
        bugTicket.setStatusCode(bugTicketDto.getStatusCode());
        //TODO 从静态文件中对照StatusCode获取StatusName
        bugTicket.setBugLevel(bugTicketDto.getBugLevel());

        bugTicketDao.update(bugTicket);
    }

    @Override
    public List<BugTicket> findList(BugTicketQueryDto queryDto) {
        List<BugTicket> list = bugTicketDao.findList(queryDto);
        return list;
    }

    @Override
    @Transactional
    public Integer createBugTicket(BugTicketDto bugTicketDto) {
        //获取员工姓名
        EmployeeQueryDto employeeQueryDto=new EmployeeQueryDto();
        employeeQueryDto.setEmpId(bugTicketDto.getUserId());
        List<Employee> employees=employeeDao.findList(employeeQueryDto);
        Employee employee=employees.get(0);
        //获取员工所在组
        TeamQueryDto teamQueryDto=new TeamQueryDto();
        teamQueryDto.setTeamId(employee.getTeamId());
        List<Team> teams= teamDao.findList(teamQueryDto);
        Team team=teams.get(0);
        //获取组长姓名
        employeeQueryDto.setEmpId(team.getTeamLeaderId());
        List<Employee> teamLeaders=employeeDao.findList(employeeQueryDto);
        Employee teamLeader=teamLeaders.get(0);

        BugTicket bugTicket = new BugTicket();
        bugTicket.setBugId(IdGeneratorUtil.generateId());
        bugTicket.setTeamId(team.getTeamId());
        bugTicket.setTitle(bugTicketDto.getTitle());
        bugTicket.setDescription(bugTicketDto.getDescription());
        //bugTicket.setStatusCode(CommonConstant.SUBMITTED);
        bugTicket.setStatusName(CommonConstant.SUBMITTED);
        bugTicket.setBugLevel(bugTicketDto.getBugLevel());
        bugTicket.setSubmitId(employee.getEmpId());
        bugTicket.setSubmitName(employee.getRealName());
        bugTicket.setSubmitTime(new Date());
        //审核人是该小组组长
        bugTicket.setCheckId(teamLeader.getEmpId());
        bugTicket.setCheckName(teamLeader.getRealName());
        //处理人是审核人，即小组组长
        bugTicket.setDesignateId(teamLeader.getEmpId());
        bugTicket.setDesignateName(teamLeader.getRealName());


        return bugTicketDao.submitSave(bugTicket);
    }

    @Override
    public ResponseDto<String> checkBugTicket(BugTicketDto bugTicketDto) {

        //获取缺陷清单
        BugTicketQueryDto bugTicketQueryDto=new BugTicketQueryDto();
        bugTicketQueryDto.setBugId(bugTicketDto.getBugId());
        List<BugTicket> bugTickets=bugTicketDao.findList(bugTicketQueryDto);
        BugTicket bugTicket=bugTickets.get(0);

        if(!bugTicketDto.getDesignateName().isEmpty()){
            //指派人不为空
            //获取指派人
            EmployeeQueryDto employeeQueryDto=new EmployeeQueryDto();
            employeeQueryDto.setRealName(bugTicketDto.getDesignateName());
            List<Employee> employees=employeeDao.findList(employeeQueryDto);

            if(employees.isEmpty()){
                //如果不存在这个人
                String msg="您输入的用户不存在，请重新输入";
                return ResponseDto.getFailResponseDto(msg);
            }else{
                //判断指派人是否是本组的
                String teamId=bugTicketDto.getTeamId();
                if(teamId.equals(employees.get(0).getTeamId())){
                    //指派人是本组组员
                    Employee employee=employees.get(0);

                    //更新缺陷清单
                    bugTicket.setStatusName(CommonConstant.CHECKED);
                    bugTicket.setCheckTime(new Date());
                    bugTicket.setDealId(employee.getEmpId());
                    bugTicket.setDealName(employee.getRealName());
                    bugTicket.setDesignateId(employee.getEmpId());
                    bugTicket.setDesignateName(employee.getRealName());
                    bugTicketDao.updateCheckList(bugTicket);

                    //创建缺陷清单备注
                    BugTicketLine bugTicketLine=new BugTicketLine();
                    bugTicketLine.setBugLineId(IdGeneratorUtil.generateId());
                    bugTicketLine.setBugId(bugTicket.getBugId());
                    bugTicketLine.setNote(bugTicketDto.getNote());
                    bugTicketLine.setAddId(employee.getEmpId());
                    bugTicketLine.setAddName(employee.getRealName());
                    bugTicketLine.setAddTime(new Date());
                    bugTicketLineDao.create(bugTicketLine);

                    String msg="操作成功";
                    return ResponseDto.getSuccessResponseDto(msg);
                }else{
                    String msg="您输入的用户不是本组组员，请重新输入";
                    return ResponseDto.getFailResponseDto(msg);
                }
            }
        }else{
            //指派人为空
            String msg="请输入指派人";
            return ResponseDto.getFailResponseDto(msg);
        }


    }

    @Override
    public Integer dealBugTicket(BugTicketDto bugTicketDto) {
        //获取缺陷清单
        BugTicketQueryDto bugTicketQueryDto=new BugTicketQueryDto();
        bugTicketQueryDto.setBugId(bugTicketDto.getBugId());
        List<BugTicket> bugTickets=bugTicketDao.findList(bugTicketQueryDto);
        BugTicket bugTicket=bugTickets.get(0);

        //更新缺陷清单
        bugTicket.setStatusName(CommonConstant.DEALT);
        bugTicket.setDealTime(new Date());
        bugTicketDao.updateDealList(bugTicket);

        //获取添加人
        EmployeeQueryDto employeeQueryDto=new EmployeeQueryDto();
        employeeQueryDto.setEmpId(bugTicket.getDealId());
        List<Employee> employees=employeeDao.findList(employeeQueryDto);
        Employee employee=employees.get(0);

        //创建缺陷清单备注
        BugTicketLine bugTicketLine=new BugTicketLine();
        bugTicketLine.setBugLineId(IdGeneratorUtil.generateId());
        bugTicketLine.setBugId(bugTicket.getBugId());
        bugTicketLine.setNote(bugTicketDto.getNote());
        bugTicketLine.setAddId(employee.getEmpId());
        bugTicketLine.setAddName(employee.getRealName());
        bugTicketLine.setAddTime(new Date());

        return bugTicketLineDao.create(bugTicketLine);
    }

    @Override
    public Integer rejectBugTicket(BugTicketDto bugTicketDto) {
        //获取缺陷清单
        BugTicketQueryDto bugTicketQueryDto=new BugTicketQueryDto();
        bugTicketQueryDto.setBugId(bugTicketDto.getBugId());
        List<BugTicket> bugTickets=bugTicketDao.findList(bugTicketQueryDto);
        BugTicket bugTicket=bugTickets.get(0);
        bugTicket.setStatusName(CommonConstant.REJECTED);

        //获取审核人
        EmployeeQueryDto employeeQueryDto=new EmployeeQueryDto();
        employeeQueryDto.setRealName(bugTicket.getCheckName());
        List<Employee> employees=employeeDao.findList(employeeQueryDto);
        Employee employee=employees.get(0);

        //创建缺陷清单备注
        BugTicketLine bugTicketLine=new BugTicketLine();
        bugTicketLine.setBugLineId(IdGeneratorUtil.generateId());
        bugTicketLine.setBugId(bugTicket.getBugId());
        bugTicketLine.setNote(bugTicketDto.getNote());
        bugTicketLine.setAddId(employee.getEmpId());
        bugTicketLine.setAddName(employee.getRealName());
        bugTicketLine.setAddTime(new Date());
        bugTicketLineDao.create(bugTicketLine);
        return bugTicketDao.reject(bugTicket);
    }
}
