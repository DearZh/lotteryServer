package lottery.domains.content.biz.impl;

import java.util.ArrayList;
import java.util.List;
import javautils.StringUtil;
import javautils.jdbc.PageList;
import lottery.domains.content.biz.ActivityRechargeLoopService;
import lottery.domains.content.dao.ActivityRechargeLoopBillDao;
import lottery.domains.content.dao.UserDao;
import lottery.domains.content.entity.ActivityRechargeLoopBill;
import lottery.domains.content.entity.User;
import lottery.domains.content.vo.activity.ActivityRechargeLoopBillVO;
import lottery.domains.pool.LotteryDataFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityRechargeLoopServiceImpl
  implements ActivityRechargeLoopService
{
  @Autowired
  private UserDao uDao;
  @Autowired
  private ActivityRechargeLoopBillDao aRechargeLoopBillDao;
  @Autowired
  private LotteryDataFactory lotteryDataFactory;
  
  public PageList search(String username, String date, Integer step, int start, int limit)
  {
    List<Criterion> criterions = new ArrayList();
    List<Order> orders = new ArrayList();
    boolean isSearch = true;
    if (StringUtil.isNotNull(username))
    {
      User user = this.uDao.getByUsername(username);
      if (user != null) {
        criterions.add(Restrictions.eq("userId", Integer.valueOf(user.getId())));
      } else {
        isSearch = false;
      }
    }
    if (StringUtil.isNotNull(date)) {
      criterions.add(Restrictions.like("time", date, MatchMode.ANYWHERE));
    }
    if (step != null) {
      criterions.add(Restrictions.eq("step", Integer.valueOf(step.intValue())));
    }
    orders.add(Order.desc("id"));
    if (isSearch)
    {
      List<ActivityRechargeLoopBillVO> list = new ArrayList();
      PageList pList = this.aRechargeLoopBillDao.find(criterions, orders, start, limit);
      for (Object tmpBean : pList.getList()) {
        list.add(new ActivityRechargeLoopBillVO((ActivityRechargeLoopBill)tmpBean, this.lotteryDataFactory));
      }
      pList.setList(list);
      return pList;
    }
    return null;
  }
}
