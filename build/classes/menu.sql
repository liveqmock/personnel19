INSERT INTO menu
   (`menuId`, `men_menuId`, `menuName`, `menuUrl`, `remark`, `menuDate`, `isDelete`)
VALUES
   ('10001', NULL, '员工资料管理', '', NULL, NULL, 0);

INSERT INTO menu
   (`menuId`, `men_menuId`, `menuName`, `menuUrl`, `remark`, `menuDate`, `isDelete`)
VALUES
   ('100010001', '10001', '基本资料', 'user_info.do?method=queryAll', NULL, NULL, 0);

INSERT INTO menu
   (`menuId`, `men_menuId`, `menuName`, `menuUrl`, `remark`, `menuDate`, `isDelete`)
VALUES
   ('100010002', '10001', '高级资料','user_info.do?method=jumpAdvanceInfo', NULL, NULL, 0);

INSERT INTO menu
   (`menuId`, `men_menuId`, `menuName`, `menuUrl`, `remark`, `menuDate`, `isDelete`)
VALUES
   ('10002', NULL, '统计管理', NULL, NULL, NULL, 0);

INSERT INTO menu
   (`menuId`, `men_menuId`, `menuName`, `menuUrl`, `remark`, `menuDate`, `isDelete`)
VALUES
   ('100020001', '10002', '综合信息统计', 'managementJump.do?method=jumpAll', NULL, NULL, 0);

INSERT INTO menu
   (`menuId`, `men_menuId`, `menuName`, `menuUrl`, `remark`, `menuDate`, `isDelete`)
VALUES
   ('100020002', '10002', '员工积分统计', 'managementJump.do?method=jumpScore', NULL, NULL, 0);

INSERT INTO menu
   (`menuId`, `men_menuId`, `menuName`, `menuUrl`, `remark`, `menuDate`, `isDelete`)
VALUES
   ('100020003', '10002', '人事信息统计', 'personnelManagement.do?method=findAll&&all=all', NULL, NULL, 0);

INSERT INTO menu
   (`menuId`, `men_menuId`, `menuName`, `menuUrl`, `remark`, `menuDate`, `isDelete`)
VALUES
   ('100020004', '10002', '人事记录统计', 'personnelRecords.do?method=findAllPersonnelRecords', NULL, NULL, 0);

INSERT INTO menu
   (`menuId`, `men_menuId`, `menuName`, `menuUrl`, `remark`, `menuDate`, `isDelete`)
VALUES
   ('10003', NULL, '工资管理', 'salarymanage.do?method=SalaryManageJump', NULL, NULL, 0);

INSERT INTO menu
   (`menuId`, `men_menuId`, `menuName`, `menuUrl`, `remark`, `menuDate`, `isDelete`)
VALUES
   ('100030001', '10003', '员工帐套设置', 'setofbook.sal?method=wel', NULL, NULL, 0);

INSERT INTO menu
   (`menuId`, `men_menuId`, `menuName`, `menuUrl`, `remark`, `menuDate`, `isDelete`)
VALUES
   ('100030002', '10003', '工资管理', 'salarymanage.sal?method=SalaryManageJump', NULL, NULL, 0);

INSERT INTO menu
   (`menuId`, `men_menuId`, `menuName`, `menuUrl`, `remark`, `menuDate`, `isDelete`)
VALUES
   ('100030003', '10003', '工资表查询', 'searchPayRoll.sal?method=main', NULL, NULL, 0);

INSERT INTO menu
   (`menuId`, `men_menuId`, `menuName`, `menuUrl`, `remark`, `menuDate`, `isDelete`)
VALUES
   ('100030004', '10003', '部门整体奖罚', 'departmentPB.sal?method=search', NULL, NULL, 0);

INSERT INTO menu
   (`menuId`, `men_menuId`, `menuName`, `menuUrl`, `remark`, `menuDate`, `isDelete`)
VALUES
   ('100030005', '10003', '其他', 'other.sal?method=looking', NULL, NULL, 0);

INSERT INTO menu
   (`menuId`, `men_menuId`, `menuName`, `menuUrl`, `remark`, `menuDate`, `isDelete`)
VALUES
   ('10004', NULL, '系统管理', 'menu.do?method=managemenu', NULL, NULL, 0);

INSERT INTO menu
   (`menuId`, `men_menuId`, `menuName`, `menuUrl`, `remark`, `menuDate`, `isDelete`)
VALUES
   ('100040001', '10004', '基本信息设置', 'basicChoose.do?method=jumpBasic', NULL, NULL, 0);

INSERT INTO menu
   (`menuId`, `men_menuId`, `menuName`, `menuUrl`, `remark`, `menuDate`, `isDelete`)
VALUES
   ('100040002', '10004', '操作日志管理', 'operateLog.do?method=query', NULL, NULL, 0);

INSERT INTO menu
   (`menuId`, `men_menuId`, `menuName`, `menuUrl`, `remark`, `menuDate`, `isDelete`)
VALUES
   ('100040003', '10004', '备份恢复数据', 'bak.do?method=query', NULL, NULL, 0);

INSERT INTO menu
   (`menuId`, `men_menuId`, `menuName`, `menuUrl`, `remark`, `menuDate`, `isDelete`)
VALUES
   ('100040004', '10004', '初始化数据库', 'initDataBaseServlet.do?method=initDB', NULL, NULL, 0);

INSERT INTO menu
   (`menuId`, `men_menuId`, `menuName`, `menuUrl`, `remark`, `menuDate`, `isDelete`)
VALUES
   ('100040005', '10004', '系统管理', 'menu.do?method=managemenu', NULL, NULL, 0);

INSERT INTO menu
   (`menuId`, `men_menuId`, `menuName`, `menuUrl`, `remark`, `menuDate`, `isDelete`)
VALUES
   ('100040006', '10004', '操作员管理', 'operatermanage.do?method=operater', '', NULL, 0);

INSERT INTO menu
   (`menuId`, `men_menuId`, `menuName`, `menuUrl`, `remark`, `menuDate`, `isDelete`)
VALUES
   ('100040007', '10004', '字典管理', 'diction.do?method=dictionMain', NULL, NULL, 0);

INSERT INTO menu
   (`menuId`, `men_menuId`, `menuName`, `menuUrl`, `remark`, `menuDate`, `isDelete`)
VALUES
   ('10005', NULL, '人事管理', NULL, NULL, NULL, 0);

INSERT INTO menu
   (`menuId`, `men_menuId`, `menuName`, `menuUrl`, `remark`, `menuDate`, `isDelete`)
VALUES
   ('100050001', '10005', '员工资料', 'personInfo.do?method=firstJumpIntoPage', NULL, NULL, 0);

INSERT INTO menu
   (`menuId`, `men_menuId`, `menuName`, `menuUrl`, `remark`, `menuDate`, `isDelete`)
VALUES
   ('100050002', '10005', '员工奖惩', 'personEOC.do?method=firstJumpIntoPage', NULL, NULL, 0);

INSERT INTO menu
   (`menuId`, `men_menuId`, `menuName`, `menuUrl`, `remark`, `menuDate`, `isDelete`)
VALUES
   ('100050003', '10005', '员工培训', 'personTrain.do?method=findAll&currentPage=1', NULL, NULL, 0);

INSERT INTO menu
   (`menuId`, `men_menuId`, `menuName`, `menuUrl`, `remark`, `menuDate`, `isDelete`)
VALUES
   ('100050004', '10005', '员工好评', 'personAppraise.do?method=findAll&state=0&currentPage=1', NULL, NULL, 0);

INSERT INTO menu
   (`menuId`, `men_menuId`, `menuName`, `menuUrl`, `remark`, `menuDate`, `isDelete`)
VALUES
   ('100050006', '10005', '员工调动', 'personnelRemove.do?method=showJob', NULL, NULL, 0);

INSERT INTO menu
   (`menuId`, `men_menuId`, `menuName`, `menuUrl`, `remark`, `menuDate`, `isDelete`)
VALUES
   ('10006', NULL, '版本信息', NULL, NULL, NULL, 0);

INSERT INTO menu
   (`menuId`, `men_menuId`, `menuName`, `menuUrl`, `remark`, `menuDate`, `isDelete`)
VALUES
   ('100060001', '10006', 'by Jessica(865171.cn)', 'http://Www.865171.cn', NULL, NULL, 0);

