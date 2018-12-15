package lottery.domains.content.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_regist_link", catalog="ecai")
public class UserRegistLink
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private int id;
  private int userId;
  private int type;
  private String code;
  private double locatePoint;
  private String expTime;
  private int amount;
  private String time;
  private int status;
  private int deviceType;
  private String qrCode;
  
  public UserRegistLink() {}
  
  public UserRegistLink(int userId, int type, String code, double locatePoint, int amount, String time, int status)
  {
    this.userId = userId;
    this.type = type;
    this.code = code;
    this.locatePoint = locatePoint;
    this.amount = amount;
    this.time = time;
    this.status = status;
  }
  
  public UserRegistLink(int userId, int type, String code, double locatePoint, String expTime, int amount, String time, int status)
  {
    this.userId = userId;
    this.type = type;
    this.code = code;
    this.locatePoint = locatePoint;
    this.expTime = expTime;
    this.amount = amount;
    this.time = time;
    this.status = status;
  }
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="id", unique=true, nullable=false)
  public int getId()
  {
    return this.id;
  }
  
  public void setId(int id)
  {
    this.id = id;
  }
  
  @Column(name="user_id", nullable=false)
  public int getUserId()
  {
    return this.userId;
  }
  
  public void setUserId(int userId)
  {
    this.userId = userId;
  }
  
  @Column(name="type", nullable=false)
  public int getType()
  {
    return this.type;
  }
  
  public void setType(int type)
  {
    this.type = type;
  }
  
  @Column(name="code", nullable=false, length=64)
  public String getCode()
  {
    return this.code;
  }
  
  public void setCode(String code)
  {
    this.code = code;
  }
  
  @Column(name="locate_point", nullable=false, precision=11, scale=2)
  public double getLocatePoint()
  {
    return this.locatePoint;
  }
  
  public void setLocatePoint(double locatePoint)
  {
    this.locatePoint = locatePoint;
  }
  
  @Column(name="exp_time", length=19)
  public String getExpTime()
  {
    return this.expTime;
  }
  
  public void setExpTime(String expTime)
  {
    this.expTime = expTime;
  }
  
  @Column(name="amount", nullable=false)
  public int getAmount()
  {
    return this.amount;
  }
  
  public void setAmount(int amount)
  {
    this.amount = amount;
  }
  
  @Column(name="time", nullable=false, length=19)
  public String getTime()
  {
    return this.time;
  }
  
  public void setTime(String time)
  {
    this.time = time;
  }
  
  @Column(name="status", nullable=false)
  public int getStatus()
  {
    return this.status;
  }
  
  public void setStatus(int status)
  {
    this.status = status;
  }
  
  @Column(name="device_type")
  public int getDeviceType()
  {
    return this.deviceType;
  }
  
  public void setDeviceType(int deviceType)
  {
    this.deviceType = deviceType;
  }
  
  @Column(name="qr_code", length=1024)
  public String getQrCode()
  {
    return this.qrCode;
  }
  
  public void setQrCode(String qrCode)
  {
    this.qrCode = qrCode;
  }
}
